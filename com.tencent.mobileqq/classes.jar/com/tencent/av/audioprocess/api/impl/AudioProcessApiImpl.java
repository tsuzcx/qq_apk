package com.tencent.av.audioprocess.api.impl;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.av.AVPathUtil;
import com.tencent.av.audioprocess.AudioProcessCallback.OnRecog;
import com.tencent.av.audioprocess.AudioProcessCallback.OnRecord;
import com.tencent.av.audioprocess.DecodeInfo;
import com.tencent.av.audioprocess.FileInfo;
import com.tencent.av.audioprocess.ISetAudioFrameCallback;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.av.recog.AVVoiceRecog;
import com.tencent.av.ui.funchat.record.SdkAudioFrameCallback;
import com.tencent.av.utils.AudioDump;
import com.tencent.avcore.engine.common.IAVEngineCommon;
import com.tencent.avgame.localvoicerecog.api.IAVGameVoiceRecog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qav.log.AVLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@RequiresApi(api=16)
public class AudioProcessApiImpl
  implements IAudioProcessApi, SdkAudioFrameCallback
{
  private static final int MAX_QUEUE_SIZE = 25;
  private static final int MAX_RECOG_DATA_LEN = 9600000;
  public static final String TAG = "AudioProcessApiImpl";
  private int mAddCnt = 0;
  private int mAddLen = 0;
  private long mAddStartTime = 0L;
  private IAVEngineCommon mEngineCommon = null;
  List<FileInfo> mFileInfoList = new ArrayList();
  private boolean mIsInited = false;
  private final Object mLock = new Object();
  private final Object mLockPCMDataFromOutside = new Object();
  private final Object mLockRecog = new Object();
  private int mMixCnt = 0;
  private int mMixLen = 0;
  private long mMixStartTime = 0L;
  private AudioProcessCallback.OnRecog mOnRecog = null;
  private AudioProcessCallback.OnRecord mOnRecord = null;
  private byte[] mPCMDataFromOutside = null;
  private int mPCMDataLenFromOutside = 0;
  Queue<byte[]> mPCMDataQueueFromOutside = new LinkedList();
  private int mPlayMixSrcType = 1;
  private int mPlayState = 0;
  private byte[] mRecogData = null;
  private int mRecogDataLen = 0;
  private int mRecogState = 0;
  private long mRecogTimeStart = 0L;
  private String mRecogTxt = "";
  private int mRecordMixSrcType = 5;
  private int mRecordState = 0;
  private ISetAudioFrameCallback mSetAudioFrameCallback = null;
  
  private static int decodeMP3Frame(byte[] paramArrayOfByte, FileInfo paramFileInfo)
  {
    int i;
    int j;
    int k;
    if ((paramArrayOfByte != null) && (paramFileInfo != null) && (paramFileInfo.j != null))
    {
      if (paramFileInfo.a == null) {
        return 1;
      }
      int m;
      if (paramFileInfo.m != null)
      {
        if (paramFileInfo.l + paramArrayOfByte.length * paramFileInfo.b <= paramFileInfo.m.length)
        {
          if (paramFileInfo.b == 1)
          {
            System.arraycopy(paramFileInfo.m, paramFileInfo.l, paramArrayOfByte, 0, paramArrayOfByte.length);
          }
          else
          {
            i = 0;
            while (i < paramArrayOfByte.length)
            {
              localObject = paramFileInfo.m;
              j = paramFileInfo.l;
              k = i * 2;
              paramArrayOfByte[i] = localObject[(j + k)];
              paramArrayOfByte[(i + 1)] = paramFileInfo.m[(paramFileInfo.l + k + 1)];
              i += 2;
            }
          }
          paramFileInfo.l += paramArrayOfByte.length * paramFileInfo.b;
          return 0;
        }
        if (paramFileInfo.l < paramFileInfo.m.length)
        {
          j = (paramFileInfo.m.length - paramFileInfo.l) / paramFileInfo.b;
          if (paramFileInfo.b == 1)
          {
            System.arraycopy(paramFileInfo.m, paramFileInfo.l, paramArrayOfByte, 0, j);
          }
          else
          {
            i = 0;
            while (i < j)
            {
              localObject = paramFileInfo.m;
              k = paramFileInfo.l;
              m = i * 2;
              paramArrayOfByte[i] = localObject[(k + m)];
              paramArrayOfByte[(i + 1)] = paramFileInfo.m[(paramFileInfo.l + m + 1)];
              i += 2;
            }
          }
          paramFileInfo.l += paramFileInfo.b * j;
          i = j;
          break label291;
        }
      }
      i = 0;
      label291:
      Object localObject = paramFileInfo.a.getInputBuffers();
      j = paramFileInfo.a.dequeueInputBuffer(10000L);
      if (j >= 0)
      {
        localObject = localObject[j];
        ((ByteBuffer)localObject).clear();
        k = paramFileInfo.j.readSampleData((ByteBuffer)localObject, 0);
        if (k > 0)
        {
          paramFileInfo.a.queueInputBuffer(j, 0, k, 0L, 0);
          paramFileInfo.j.advance();
        }
        else
        {
          paramFileInfo.a.queueInputBuffer(j, 0, 0, 0L, 0);
          return 2;
        }
      }
      else if (j == -1)
      {
        return 3;
      }
      localObject = paramFileInfo.a.getOutputBuffers();
      k = paramFileInfo.a.dequeueOutputBuffer(paramFileInfo.k, 10000L);
      if ((k >= 0) && (paramFileInfo.k.size > (paramArrayOfByte.length - i) * paramFileInfo.b))
      {
        localObject = localObject[k];
        if ((paramFileInfo.m == null) || (paramFileInfo.m.length != paramFileInfo.k.size)) {
          paramFileInfo.m = new byte[paramFileInfo.k.size];
        }
        ((ByteBuffer)localObject).get(paramFileInfo.m);
        ((ByteBuffer)localObject).clear();
        if (paramFileInfo.b == 1)
        {
          System.arraycopy(paramFileInfo.m, 0, paramArrayOfByte, i, paramArrayOfByte.length - i);
        }
        else
        {
          j = 0;
          while (j < paramArrayOfByte.length - i)
          {
            m = i + j;
            localObject = paramFileInfo.m;
            int n = j * 2;
            paramArrayOfByte[m] = localObject[n];
            paramArrayOfByte[(m + 1)] = paramFileInfo.m[(n + 1)];
            j += 2;
          }
        }
        paramFileInfo.l = ((paramArrayOfByte.length - i) * paramFileInfo.b);
        paramFileInfo.a.releaseOutputBuffer(k, false);
        return 0;
      }
      if (k == -2)
      {
        paramArrayOfByte = paramFileInfo.a.getOutputFormat();
        if (paramArrayOfByte == null) {}
      }
    }
    try
    {
      i = paramArrayOfByte.getInteger("sample-rate");
      j = paramArrayOfByte.getInteger("pcm-encoding");
      k = paramArrayOfByte.getInteger("channel-count");
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("decodeMP3Frame but format changed. INFO_OUTPUT_FORMAT_CHANGED. sampleRate = ");
      paramArrayOfByte.append(i);
      paramArrayOfByte.append(", pcmEncoding = ");
      paramArrayOfByte.append(j);
      paramArrayOfByte.append(", channelCount = ");
      paramArrayOfByte.append(k);
      AVLog.b("AudioProcessApiImpl", paramArrayOfByte.toString());
      return 3;
    }
    catch (NullPointerException paramArrayOfByte)
    {
      break label713;
    }
    catch (ClassCastException paramArrayOfByte)
    {
      label703:
      label713:
      break label703;
    }
    AVLog.a("AudioProcessApiImpl", "decodeMP3Frame failed. INFO_OUTPUT_FORMAT_CHANGED. ClassCastException.");
    return 3;
    AVLog.a("AudioProcessApiImpl", "decodeMP3Frame failed. INFO_OUTPUT_FORMAT_CHANGED. NullPointerException.");
    return 3;
    return 1;
  }
  
  private static List<byte[]> getPCMDataFromMP3File(List<FileInfo> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if ((((FileInfo)paramList.get(i)).d == 1) && (((FileInfo)paramList.get(i)).j != null) && (((FileInfo)paramList.get(i)).a != null))
      {
        Object localObject1 = new byte[paramInt];
        int j = decodeMP3Frame((byte[])localObject1, (FileInfo)paramList.get(i));
        if (j == 0)
        {
          scaleVolume((byte[])localObject1, ((FileInfo)paramList.get(i)).f);
          localArrayList.add(localObject1);
        }
        else if ((j == 1) || (j == 2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getPCMDataFromMP3File failed. ret = ");
          ((StringBuilder)localObject1).append(j);
          AVLog.a("AudioProcessApiImpl", ((StringBuilder)localObject1).toString());
          if (((FileInfo)paramList.get(i)).a != null)
          {
            try
            {
              ((FileInfo)paramList.get(i)).a.stop();
              ((FileInfo)paramList.get(i)).a.release();
            }
            catch (IllegalStateException localIllegalStateException)
            {
              AVLog.b("AudioProcessApiImpl", "mp3Decoder stop failed.", localIllegalStateException);
            }
            ((FileInfo)paramList.get(i)).a = null;
          }
          if (((FileInfo)paramList.get(i)).j != null)
          {
            ((FileInfo)paramList.get(i)).j.release();
            ((FileInfo)paramList.get(i)).j = null;
          }
          if ((j != 1) && (((FileInfo)paramList.get(i)).e > 1))
          {
            if (((FileInfo)paramList.get(i)).e > 1)
            {
              Object localObject2 = (FileInfo)paramList.get(i);
              ((FileInfo)localObject2).e -= 1;
              localObject2 = new MediaExtractor();
              DecodeInfo localDecodeInfo = startDecodeMP3((MediaExtractor)localObject2, ((FileInfo)paramList.get(i)).c);
              if ((localDecodeInfo != null) && (localDecodeInfo.a != null))
              {
                ((FileInfo)paramList.get(i)).j = ((MediaExtractor)localObject2);
                ((FileInfo)paramList.get(i)).a = localDecodeInfo.a;
              }
              else
              {
                AVLog.a("AudioProcessApiImpl", "getPCMDataFromMP3File failed. startDecodeMP3 failed.");
                paramList.remove(i);
              }
            }
          }
          else {
            paramList.remove(i);
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  /* Error */
  private static List<byte[]> getPCMDataFromPCMFile(List<FileInfo> paramList, int paramInt)
  {
    // Byte code:
    //   0: new 87	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 88	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: aload_0
    //   12: invokeinterface 269 1 0
    //   17: if_icmpge +568 -> 585
    //   20: aload_0
    //   21: iload_2
    //   22: invokeinterface 272 2 0
    //   27: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   30: getfield 275	com/tencent/av/audioprocess/FileInfo:d	I
    //   33: ifeq +6 -> 39
    //   36: goto +542 -> 578
    //   39: aload_0
    //   40: iload_2
    //   41: invokeinterface 272 2 0
    //   46: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   49: getfield 330	com/tencent/av/audioprocess/FileInfo:g	I
    //   52: iload_1
    //   53: iadd
    //   54: i2l
    //   55: aload_0
    //   56: iload_2
    //   57: invokeinterface 272 2 0
    //   62: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   65: getfield 333	com/tencent/av/audioprocess/FileInfo:i	J
    //   68: lcmp
    //   69: ifle +153 -> 222
    //   72: aload_0
    //   73: iload_2
    //   74: invokeinterface 272 2 0
    //   79: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   82: getfield 306	com/tencent/av/audioprocess/FileInfo:e	I
    //   85: iconst_1
    //   86: if_icmple +6 -> 92
    //   89: goto +133 -> 222
    //   92: new 231	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   99: astore 4
    //   101: aload 4
    //   103: ldc_w 335
    //   106: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 4
    //   112: iload_2
    //   113: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 4
    //   119: ldc_w 337
    //   122: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 4
    //   128: aload_0
    //   129: iload_2
    //   130: invokeinterface 272 2 0
    //   135: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   138: getfield 306	com/tencent/av/audioprocess/FileInfo:e	I
    //   141: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: ldc 20
    //   147: aload 4
    //   149: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 258	com/tencent/qav/log/AVLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_0
    //   156: iload_2
    //   157: invokeinterface 272 2 0
    //   162: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   165: getfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   168: ifnull +410 -> 578
    //   171: aload_0
    //   172: iload_2
    //   173: invokeinterface 272 2 0
    //   178: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   181: getfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   184: invokevirtual 346	java/io/RandomAccessFile:close	()V
    //   187: goto +14 -> 201
    //   190: astore_3
    //   191: goto +21 -> 212
    //   194: astore 4
    //   196: aload 4
    //   198: invokevirtual 349	java/io/IOException:printStackTrace	()V
    //   201: aload_0
    //   202: iload_2
    //   203: invokeinterface 322 2 0
    //   208: pop
    //   209: goto +369 -> 578
    //   212: aload_0
    //   213: iload_2
    //   214: invokeinterface 322 2 0
    //   219: pop
    //   220: aload_3
    //   221: athrow
    //   222: iload_1
    //   223: newarray byte
    //   225: astore 4
    //   227: aload 4
    //   229: iconst_0
    //   230: invokestatic 355	java/util/Arrays:fill	([BB)V
    //   233: aload_0
    //   234: iload_2
    //   235: invokeinterface 272 2 0
    //   240: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   243: getfield 330	com/tencent/av/audioprocess/FileInfo:g	I
    //   246: iload_1
    //   247: iadd
    //   248: i2l
    //   249: aload_0
    //   250: iload_2
    //   251: invokeinterface 272 2 0
    //   256: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   259: getfield 333	com/tencent/av/audioprocess/FileInfo:i	J
    //   262: lcmp
    //   263: ifle +179 -> 442
    //   266: aload_0
    //   267: iload_2
    //   268: invokeinterface 272 2 0
    //   273: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   276: astore 5
    //   278: aload 5
    //   280: aload 5
    //   282: getfield 306	com/tencent/av/audioprocess/FileInfo:e	I
    //   285: iconst_1
    //   286: isub
    //   287: putfield 306	com/tencent/av/audioprocess/FileInfo:e	I
    //   290: aload_0
    //   291: iload_2
    //   292: invokeinterface 272 2 0
    //   297: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   300: getfield 306	com/tencent/av/audioprocess/FileInfo:e	I
    //   303: ifgt +70 -> 373
    //   306: aload_0
    //   307: iload_2
    //   308: invokeinterface 272 2 0
    //   313: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   316: getfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   319: ifnull +54 -> 373
    //   322: aload_0
    //   323: iload_2
    //   324: invokeinterface 272 2 0
    //   329: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   332: getfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   335: invokevirtual 346	java/io/RandomAccessFile:close	()V
    //   338: goto +14 -> 352
    //   341: astore_3
    //   342: goto +21 -> 363
    //   345: astore 4
    //   347: aload 4
    //   349: invokevirtual 349	java/io/IOException:printStackTrace	()V
    //   352: aload_0
    //   353: iload_2
    //   354: invokeinterface 322 2 0
    //   359: pop
    //   360: goto +218 -> 578
    //   363: aload_0
    //   364: iload_2
    //   365: invokeinterface 322 2 0
    //   370: pop
    //   371: aload_3
    //   372: athrow
    //   373: aload_0
    //   374: iload_2
    //   375: invokeinterface 272 2 0
    //   380: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   383: iconst_0
    //   384: putfield 330	com/tencent/av/audioprocess/FileInfo:g	I
    //   387: aload_0
    //   388: iload_2
    //   389: invokeinterface 272 2 0
    //   394: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   397: getfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   400: lconst_0
    //   401: invokevirtual 359	java/io/RandomAccessFile:seek	(J)V
    //   404: goto +38 -> 442
    //   407: new 231	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   414: astore 5
    //   416: aload 5
    //   418: ldc_w 361
    //   421: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload 5
    //   427: iload_2
    //   428: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: ldc 20
    //   434: aload 5
    //   436: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 258	com/tencent/qav/log/AVLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: aload 4
    //   444: aload_0
    //   445: iload_2
    //   446: invokeinterface 272 2 0
    //   451: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   454: getfield 330	com/tencent/av/audioprocess/FileInfo:g	I
    //   457: aload_0
    //   458: iload_2
    //   459: invokeinterface 272 2 0
    //   464: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   467: getfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   470: invokestatic 365	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:readFile	([BILjava/io/RandomAccessFile;)Z
    //   473: ifne +54 -> 527
    //   476: aload_0
    //   477: iload_2
    //   478: invokeinterface 272 2 0
    //   483: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   486: getfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   489: invokevirtual 346	java/io/RandomAccessFile:close	()V
    //   492: goto +14 -> 506
    //   495: astore_3
    //   496: goto +21 -> 517
    //   499: astore 4
    //   501: aload 4
    //   503: invokevirtual 349	java/io/IOException:printStackTrace	()V
    //   506: aload_0
    //   507: iload_2
    //   508: invokeinterface 322 2 0
    //   513: pop
    //   514: goto +64 -> 578
    //   517: aload_0
    //   518: iload_2
    //   519: invokeinterface 322 2 0
    //   524: pop
    //   525: aload_3
    //   526: athrow
    //   527: aload 4
    //   529: aload_0
    //   530: iload_2
    //   531: invokeinterface 272 2 0
    //   536: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   539: getfield 281	com/tencent/av/audioprocess/FileInfo:f	F
    //   542: invokestatic 285	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:scaleVolume	([BF)V
    //   545: aload_3
    //   546: aload 4
    //   548: invokeinterface 289 2 0
    //   553: pop
    //   554: aload_0
    //   555: iload_2
    //   556: invokeinterface 272 2 0
    //   561: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   564: astore 4
    //   566: aload 4
    //   568: aload 4
    //   570: getfield 330	com/tencent/av/audioprocess/FileInfo:g	I
    //   573: iload_1
    //   574: iadd
    //   575: putfield 330	com/tencent/av/audioprocess/FileInfo:g	I
    //   578: iload_2
    //   579: iconst_1
    //   580: iadd
    //   581: istore_2
    //   582: goto -572 -> 10
    //   585: aload_3
    //   586: areturn
    //   587: astore 5
    //   589: goto -182 -> 407
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	592	0	paramList	List<FileInfo>
    //   0	592	1	paramInt	int
    //   9	573	2	i	int
    //   7	1	3	localArrayList	ArrayList
    //   190	31	3	localObject1	Object
    //   341	31	3	localObject2	Object
    //   495	91	3	localList	List<byte[]>
    //   99	49	4	localStringBuilder	StringBuilder
    //   194	3	4	localIOException1	IOException
    //   225	3	4	arrayOfByte	byte[]
    //   345	98	4	localIOException2	IOException
    //   499	48	4	localIOException3	IOException
    //   564	5	4	localFileInfo	FileInfo
    //   276	159	5	localObject3	Object
    //   587	1	5	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   171	187	190	finally
    //   196	201	190	finally
    //   171	187	194	java/io/IOException
    //   322	338	341	finally
    //   347	352	341	finally
    //   322	338	345	java/io/IOException
    //   476	492	495	finally
    //   501	506	495	finally
    //   476	492	499	java/io/IOException
    //   387	404	587	java/io/IOException
  }
  
  private static boolean isSpeaking(byte[] paramArrayOfByte)
  {
    int j = 0;
    int i = 0;
    while (j < paramArrayOfByte.length / 2)
    {
      int k = j * 2;
      int m = paramArrayOfByte[k];
      k = (short)((paramArrayOfByte[(k + 1)] & 0xFF) << 8 | m & 0xFF);
      if ((k < 10000) && (k > -10000))
      {
        i = 0;
      }
      else
      {
        k = i + 1;
        i = k;
        if (k >= 10)
        {
          AVLog.c("AudioProcessApiImpl", "isSpeaking true");
          return true;
        }
      }
      j += 1;
    }
    return false;
  }
  
  private static boolean isSpeaking2(byte[] paramArrayOfByte)
  {
    double d1 = 100.0D;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      int i = 0;
      int j = 0;
      while (i < paramArrayOfByte.length / 2)
      {
        int k = i * 2;
        int m = paramArrayOfByte[k];
        j += Math.abs((short)((paramArrayOfByte[(k + 1)] & 0xFF) << 8 | m & 0xFF));
        i += 1;
      }
      double d2 = j;
      Double.isNaN(d2);
      d2 = d2 * 250.0D / 32767.0D;
      double d3 = paramArrayOfByte.length;
      Double.isNaN(d3);
      d2 /= d3;
      if (d2 < 100.0D) {
        d1 = d2;
      }
    }
    else
    {
      d1 = 0.0D;
    }
    if (d1 > 4.800000190734863D)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("isSpeaking2 energy=");
      paramArrayOfByte.append(d1);
      AVLog.c("AudioProcessApiImpl", paramArrayOfByte.toString());
    }
    return d1 > 4.800000190734863D;
  }
  
  private static boolean isSpeaking3(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    double d1 = 0.0D;
    int i = 0;
    while (i < paramArrayOfByte.length / 2)
    {
      int j = i * 2;
      int k = paramArrayOfByte[j];
      d1 += Math.pow((short)((paramArrayOfByte[(j + 1)] & 0xFF) << 8 | k & 0xFF), 2.0D);
      i += 1;
    }
    double d2 = paramArrayOfByte.length;
    Double.isNaN(d2);
    d2 = Math.log10(d1 * 2.0D / d2 / 32767.0D / 32767.0D) * 10.0D;
    d1 = d2;
    if (d2 < -30.0D) {
      d1 = -30.0D;
    }
    d1 = -d1;
    if (d1 < 27.0D)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("isSpeaking3 rms=");
      paramArrayOfByte.append(0.5D + d1);
      AVLog.c("AudioProcessApiImpl", paramArrayOfByte.toString());
    }
    if (d1 < 27.0D) {
      bool = true;
    }
    return bool;
  }
  
  private static List<byte[]> mergePCMDataList(List<byte[]> paramList1, List<byte[]> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i;
    if (paramList1 != null)
    {
      i = 0;
      while (i < paramList1.size())
      {
        localArrayList.add(paramList1.get(i));
        i += 1;
      }
    }
    if (paramList2 != null)
    {
      i = j;
      while (i < paramList2.size())
      {
        localArrayList.add(paramList2.get(i));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private static boolean mix(byte[] paramArrayOfByte, List<byte[]> paramList)
  {
    if (paramArrayOfByte == null)
    {
      AVLog.b("AudioProcessApiImpl", "no to mix this data. param error. mixData == null.");
      return false;
    }
    if (paramList == null)
    {
      AVLog.b("AudioProcessApiImpl", "no to mix this data. param error. pcmDataList == null.");
      return false;
    }
    if (paramList.size() == 0)
    {
      AVLog.b("AudioProcessApiImpl", "no to mix this data. param error. pcmDataList.size() == 0.");
      return false;
    }
    if (((byte[])paramList.get(0)).length % 2 != 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("no to mix this data. param error. pcmDataList.get(0).length = ");
      paramArrayOfByte.append(((byte[])paramList.get(0)).length);
      AVLog.b("AudioProcessApiImpl", paramArrayOfByte.toString());
      return false;
    }
    Object localObject;
    if (paramArrayOfByte.length < ((byte[])paramList.get(0)).length)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("no to mix this data. param error. mixData.length = ");
      ((StringBuilder)localObject).append(paramArrayOfByte.length);
      ((StringBuilder)localObject).append(", pcmDataList.get(0).length = ");
      ((StringBuilder)localObject).append(((byte[])paramList.get(0)).length);
      AVLog.b("AudioProcessApiImpl", ((StringBuilder)localObject).toString());
      return false;
    }
    int m = paramList.size();
    int n = ((byte[])paramList.get(0)).length;
    if (m == 1)
    {
      System.arraycopy(paramList.get(0), 0, paramArrayOfByte, 0, n);
      return true;
    }
    int j = 0;
    while (j < n / 2)
    {
      int i = 0;
      int k = 0;
      while (i < m)
      {
        localObject = (byte[])paramList.get(i);
        int i1 = j * 2;
        k += (short)(localObject[i1] & 0xFF | (((byte[])paramList.get(i))[(i1 + 1)] & 0xFF) << 8);
        i += 1;
      }
      i = k / m;
      k = -32768;
      if (i > 32767) {
        i = 32767;
      } else if (i < -32768) {
        i = k;
      }
      k = j * 2;
      i = (short)i;
      paramArrayOfByte[k] = ((byte)(i & 0xFF));
      paramArrayOfByte[(k + 1)] = ((byte)((i & 0xFF00) >> 8));
      j += 1;
    }
    return true;
  }
  
  private static RandomAccessFile openFile(String paramString)
  {
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramString, "r");
      return localRandomAccessFile;
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openFile failed. pcmFilename = ");
      localStringBuilder.append(paramString);
      AVLog.a("AudioProcessApiImpl", localStringBuilder.toString(), localIOException);
    }
    return null;
  }
  
  private static boolean readFile(byte[] paramArrayOfByte, int paramInt, RandomAccessFile paramRandomAccessFile)
  {
    long l = paramInt;
    for (;;)
    {
      try
      {
        paramRandomAccessFile.seek(l);
        paramInt = paramRandomAccessFile.read(paramArrayOfByte);
        if (paramArrayOfByte.length == paramInt)
        {
          bool = true;
          if (!bool)
          {
            paramRandomAccessFile = new StringBuilder();
            paramRandomAccessFile.append("readFile failed. readLen = ");
            paramRandomAccessFile.append(paramInt);
            paramRandomAccessFile.append(", data.length = ");
            paramRandomAccessFile.append(paramArrayOfByte.length);
            AVLog.a("AudioProcessApiImpl", paramRandomAccessFile.toString());
          }
          return bool;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        AVLog.a("AudioProcessApiImpl", "readFile failed. ", paramArrayOfByte);
        return false;
      }
      boolean bool = false;
    }
  }
  
  /* Error */
  private static void saveData(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: new 464	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 467	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: new 231	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   17: astore 5
    //   19: aload 5
    //   21: aload_0
    //   22: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 5
    //   28: aload_1
    //   29: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: new 464	java/io/File
    //   36: dup
    //   37: aload 5
    //   39: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 467	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_0
    //   46: aload 4
    //   48: invokevirtual 470	java/io/File:exists	()Z
    //   51: ifne +9 -> 60
    //   54: aload 4
    //   56: invokevirtual 473	java/io/File:mkdirs	()Z
    //   59: pop
    //   60: aload_0
    //   61: invokevirtual 470	java/io/File:exists	()Z
    //   64: ifne +16 -> 80
    //   67: aload_0
    //   68: invokevirtual 476	java/io/File:createNewFile	()Z
    //   71: pop
    //   72: goto +8 -> 80
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 349	java/io/IOException:printStackTrace	()V
    //   80: new 478	java/io/FileOutputStream
    //   83: dup
    //   84: aload_0
    //   85: iconst_1
    //   86: invokespecial 481	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   89: astore_1
    //   90: aload_2
    //   91: ifnull +12 -> 103
    //   94: aload_1
    //   95: astore_0
    //   96: aload_1
    //   97: aload_2
    //   98: iconst_0
    //   99: iload_3
    //   100: invokevirtual 485	java/io/FileOutputStream:write	([BII)V
    //   103: aload_1
    //   104: astore_0
    //   105: aload_1
    //   106: invokevirtual 488	java/io/FileOutputStream:flush	()V
    //   109: aload_1
    //   110: invokevirtual 489	java/io/FileOutputStream:close	()V
    //   113: return
    //   114: astore_2
    //   115: goto +16 -> 131
    //   118: astore_2
    //   119: goto +30 -> 149
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_1
    //   125: goto +50 -> 175
    //   128: astore_2
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_1
    //   132: astore_0
    //   133: aload_2
    //   134: invokevirtual 349	java/io/IOException:printStackTrace	()V
    //   137: aload_1
    //   138: ifnull +31 -> 169
    //   141: aload_1
    //   142: invokevirtual 489	java/io/FileOutputStream:close	()V
    //   145: return
    //   146: astore_2
    //   147: aconst_null
    //   148: astore_1
    //   149: aload_1
    //   150: astore_0
    //   151: aload_2
    //   152: invokevirtual 490	java/io/FileNotFoundException:printStackTrace	()V
    //   155: aload_1
    //   156: ifnull +13 -> 169
    //   159: aload_1
    //   160: invokevirtual 489	java/io/FileOutputStream:close	()V
    //   163: return
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 349	java/io/IOException:printStackTrace	()V
    //   169: return
    //   170: astore_2
    //   171: aload_0
    //   172: astore_1
    //   173: aload_2
    //   174: astore_0
    //   175: aload_1
    //   176: ifnull +15 -> 191
    //   179: aload_1
    //   180: invokevirtual 489	java/io/FileOutputStream:close	()V
    //   183: goto +8 -> 191
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 349	java/io/IOException:printStackTrace	()V
    //   191: aload_0
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramString1	String
    //   0	193	1	paramString2	String
    //   0	193	2	paramArrayOfByte	byte[]
    //   0	193	3	paramInt	int
    //   8	47	4	localFile	File
    //   17	21	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   67	72	75	java/io/IOException
    //   96	103	114	java/io/IOException
    //   105	109	114	java/io/IOException
    //   96	103	118	java/io/FileNotFoundException
    //   105	109	118	java/io/FileNotFoundException
    //   80	90	122	finally
    //   80	90	128	java/io/IOException
    //   80	90	146	java/io/FileNotFoundException
    //   109	113	164	java/io/IOException
    //   141	145	164	java/io/IOException
    //   159	163	164	java/io/IOException
    //   96	103	170	finally
    //   105	109	170	finally
    //   133	137	170	finally
    //   151	155	170	finally
    //   179	183	186	java/io/IOException
  }
  
  private static void saveData(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, String paramString)
  {
    Object localObject = Calendar.getInstance();
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    int k = ((Calendar)localObject).get(5);
    int m = ((Calendar)localObject).get(11);
    ((Calendar)localObject).get(12);
    ((Calendar)localObject).get(13);
    String str = AVPathUtil.s();
    if (paramBoolean) {
      localObject = "识别成功";
    } else {
      localObject = "识别失败";
    }
    saveData(str, String.format("com.tencent.mobileqq_AVGameVoiceRecogData_16000_1_%s_%s_%d_%02d.%02d.%02d.%02d.log", new Object[] { localObject, paramString, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i % 100), Integer.valueOf(j + 1), Integer.valueOf(k), Integer.valueOf(m) }), paramArrayOfByte, paramInt);
  }
  
  public static void scaleVolume(byte[] paramArrayOfByte, float paramFloat)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    int j = 0;
    while (j < paramArrayOfByte.length / 2)
    {
      int m = j * 2;
      int i = paramArrayOfByte[m];
      int n = m + 1;
      int k = (short)(int)((short)(i & 0xFF | (paramArrayOfByte[n] & 0xFF) << 8) * paramFloat);
      if (k > 32767)
      {
        i = 32767;
      }
      else
      {
        i = k;
        if (k < -32768) {
          i = -32768;
        }
      }
      paramArrayOfByte[m] = ((byte)(i & 0xFF));
      paramArrayOfByte[n] = ((byte)((0xFF00 & i) >> 8));
      j += 1;
    }
  }
  
  private void setAudioFrameCallback(int paramInt, SdkAudioFrameCallback paramSdkAudioFrameCallback)
  {
    ISetAudioFrameCallback localISetAudioFrameCallback = this.mSetAudioFrameCallback;
    if (localISetAudioFrameCallback != null)
    {
      localISetAudioFrameCallback.a(paramInt, paramSdkAudioFrameCallback);
      return;
    }
    AVLog.a("AudioProcessApiImpl", "setAudioFrameCallback failed. mSetAudioFrameCallback == null.");
  }
  
  private static DecodeInfo startDecodeMP3(MediaExtractor paramMediaExtractor, String paramString)
  {
    File localFile = new File(paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDecodeMP3. mp3FilePath = ");
    ((StringBuilder)localObject).append(paramString);
    AVLog.d("AudioProcessApiImpl", ((StringBuilder)localObject).toString());
    if ((paramMediaExtractor != null) && (localFile.exists()))
    {
      localObject = new DecodeInfo();
      try
      {
        paramMediaExtractor.setDataSource(paramString);
        int m = 0;
        int i = 0;
        while (i < paramMediaExtractor.getTrackCount())
        {
          MediaFormat localMediaFormat = paramMediaExtractor.getTrackFormat(i);
          String str = localMediaFormat.getString("mime");
          if (str.startsWith("audio"))
          {
            m = localMediaFormat.getInteger("sample-rate");
            j = localMediaFormat.getInteger("channel-count");
            k = 16;
            if (j > 2)
            {
              AVLog.a("AudioProcessApiImpl", "startDecodeMP3 failed. channelNum > 2.");
              return null;
            }
            ((DecodeInfo)localObject).b = j;
            paramMediaExtractor.selectTrack(i);
            ((DecodeInfo)localObject).a = MediaCodec.createDecoderByType(str);
            try
            {
              ((DecodeInfo)localObject).a.configure(localMediaFormat, null, null, 0);
              i = m;
            }
            catch (Throwable paramMediaExtractor)
            {
              AVLog.a("AudioProcessApiImpl", "startDecodeMP3 failed. configure exception: ", paramMediaExtractor);
              ((DecodeInfo)localObject).a.release();
              ((DecodeInfo)localObject).a = null;
              return null;
            }
          }
          i += 1;
        }
        int j = 0;
        int k = 0;
        i = m;
        if (((DecodeInfo)localObject).a == null)
        {
          AVLog.a("AudioProcessApiImpl", "startDecodeMP3 failed. mAudioCodec == null.");
          return null;
        }
        try
        {
          ((DecodeInfo)localObject).a.start();
          paramMediaExtractor = new StringBuilder();
          paramMediaExtractor.append("startDecodeMP3 successfully. mp3FilePath = ");
          paramMediaExtractor.append(paramString);
          paramMediaExtractor.append(", fileSize = ");
          paramMediaExtractor.append(localFile.length());
          paramMediaExtractor.append(", sampleRate = ");
          paramMediaExtractor.append(i);
          paramMediaExtractor.append(", channelNum = ");
          paramMediaExtractor.append(j);
          paramMediaExtractor.append(", sampleSize = ");
          paramMediaExtractor.append(k);
          AVLog.d("AudioProcessApiImpl", paramMediaExtractor.toString());
          return localObject;
        }
        catch (Exception paramMediaExtractor)
        {
          AVLog.a("AudioProcessApiImpl", "startDecodeMP3 failed. AudioCodec.start failed.", paramMediaExtractor);
          ((DecodeInfo)localObject).a.release();
          ((DecodeInfo)localObject).a = null;
          return null;
        }
        AVLog.a("AudioProcessApiImpl", "startDecodeMP3 failed. !mp3File.exists().");
      }
      catch (IOException paramMediaExtractor)
      {
        AVLog.a("AudioProcessApiImpl", "startDecodeMP3 failed. exception: ", paramMediaExtractor);
        if (((DecodeInfo)localObject).a != null)
        {
          ((DecodeInfo)localObject).a.release();
          ((DecodeInfo)localObject).a = null;
        }
        return null;
      }
    }
    return null;
  }
  
  @RequiresApi(api=21)
  public void addFile(String arg1, int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject1;
    int i;
    if ((this.mIsInited) && (this.mEngineCommon != null) && (!TextUtils.isEmpty(???)) && (paramInt2 > 0))
    {
      localObject1 = this.mLock;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.mFileInfoList.size())
        {
          if (!((FileInfo)this.mFileInfoList.get(i)).c.equalsIgnoreCase(???)) {
            break label407;
          }
          return;
        }
        localObject1 = new FileInfo();
        ((FileInfo)localObject1).c = ???;
        ((FileInfo)localObject1).d = paramInt1;
        ((FileInfo)localObject1).e = paramInt2;
        float f;
        if (paramFloat < 0.1F)
        {
          f = 0.1F;
        }
        else
        {
          f = paramFloat;
          if (paramFloat > 10.0F) {
            f = 10.0F;
          }
        }
        ((FileInfo)localObject1).f = f;
        MediaExtractor localMediaExtractor;
        if (paramInt1 == 0)
        {
          ??? = openFile(???);
          if (??? != null)
          {
            ((FileInfo)localObject1).h = ???;
            try
            {
              ((FileInfo)localObject1).i = ???.length();
            }
            catch (IOException localIOException)
            {
              AVLog.a("AudioProcessApiImpl", "addFile failed. get pcm file length failed.", localIOException);
              try
              {
                ???.close();
                return;
              }
              catch (IOException ???)
              {
                ???.printStackTrace();
                return;
              }
            }
          }
          AVLog.a("AudioProcessApiImpl", "addFile failed. open pcm file failed.");
        }
        else
        {
          if (paramInt1 != 1) {
            continue;
          }
          localMediaExtractor = new MediaExtractor();
          ??? = startDecodeMP3(localMediaExtractor, ???);
          if ((??? == null) || (???.a == null)) {
            continue;
          }
          localIOException.j = localMediaExtractor;
          localIOException.a = ???.a;
          localIOException.b = ???.b;
          localIOException.k = new MediaCodec.BufferInfo();
        }
        synchronized (this.mLock)
        {
          this.mFileInfoList.add(localIOException);
          ??? = new StringBuilder();
          ???.append("addFile successfully. fileinfo = ");
          ???.append(localIOException);
          AVLog.d("AudioProcessApiImpl", ???.toString());
          return;
        }
        localMediaExtractor.release();
        AVLog.a("AudioProcessApiImpl", "addFile failed. startDecodeMP3 failed.");
        return;
        ??? = new StringBuilder();
        ???.append("addFile failed. fileType = ");
        ???.append(paramInt1);
        AVLog.a("AudioProcessApiImpl", ???.toString());
        return;
      }
      finally {}
      AVLog.a("AudioProcessApiImpl", "addFile failed. !mIsInited || mEngineCommon == null || mixCnt <= 0.");
      return;
      label407:
      i += 1;
    }
  }
  
  public void addPCMData(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if ((this.mIsInited) && (this.mEngineCommon != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length >= paramInt))
    {
      if (this.mAddCnt == 0) {
        this.mAddStartTime = System.currentTimeMillis();
      }
      this.mAddCnt += 1;
      this.mAddLen += paramInt;
      if (this.mAddCnt == 100)
      {
        long l = System.currentTimeMillis();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("addPCMData. mAddCnt = ");
        ((StringBuilder)localObject1).append(this.mAddCnt);
        ((StringBuilder)localObject1).append(", mAddLen = ");
        ((StringBuilder)localObject1).append(this.mAddLen);
        ((StringBuilder)localObject1).append(", mAddStartTime = ");
        ((StringBuilder)localObject1).append(this.mAddStartTime);
        ((StringBuilder)localObject1).append(", addEndTime = ");
        ((StringBuilder)localObject1).append(l);
        ((StringBuilder)localObject1).append(", mAddTimeLen = ");
        ((StringBuilder)localObject1).append(l - this.mAddStartTime);
        AVLog.d("AudioProcessApiImpl", ((StringBuilder)localObject1).toString());
        this.mAddCnt = 0;
        this.mAddLen = 0;
        this.mAddStartTime = 0L;
      }
      localObject2 = this.mLockPCMDataFromOutside;
      localObject1 = paramArrayOfByte;
    }
    for (;;)
    {
      try
      {
        if (this.mPCMDataLenFromOutside > 0)
        {
          localObject1 = new byte[this.mPCMDataLenFromOutside + paramInt];
          System.arraycopy(this.mPCMDataFromOutside, 0, localObject1, 0, this.mPCMDataLenFromOutside);
          System.arraycopy(paramArrayOfByte, 0, localObject1, this.mPCMDataLenFromOutside, paramInt);
          this.mPCMDataLenFromOutside = 0;
        }
        int i = localObject1.length / 1920;
        if (i > 0)
        {
          int j = this.mPCMDataQueueFromOutside.size();
          paramInt = 0;
          if (paramInt >= j + i - 25) {
            break label471;
          }
          this.mPCMDataQueueFromOutside.poll();
          paramInt += 1;
          continue;
          if (paramInt < i)
          {
            paramArrayOfByte = new byte[1920];
            System.arraycopy(localObject1, paramInt * 1920, paramArrayOfByte, 0, 1920);
            this.mPCMDataQueueFromOutside.offer(paramArrayOfByte);
            paramInt += 1;
            continue;
          }
          paramInt = localObject1.length % 1920;
          if (paramInt > 0)
          {
            if (this.mPCMDataFromOutside == null) {
              this.mPCMDataFromOutside = new byte[1920];
            }
            System.arraycopy(localObject1, localObject1.length - paramInt, this.mPCMDataFromOutside, 0, paramInt);
            this.mPCMDataLenFromOutside = paramInt;
          }
        }
        else
        {
          if (this.mPCMDataFromOutside == null) {
            this.mPCMDataFromOutside = new byte[1920];
          }
          paramInt = localObject1.length;
          System.arraycopy(localObject1, 0, this.mPCMDataFromOutside, 0, paramInt);
          this.mPCMDataLenFromOutside = paramInt;
        }
        return;
      }
      finally {}
      AVLog.a("AudioProcessApiImpl", "addPCMData failed. !mIsInited || mEngineCommon == null || pcmData == null.");
      return;
      label471:
      paramInt = 0;
    }
  }
  
  public boolean init(IAVEngineCommon paramIAVEngineCommon, ISetAudioFrameCallback paramISetAudioFrameCallback)
  {
    if (this.mIsInited) {
      return true;
    }
    if ((paramIAVEngineCommon != null) && (paramISetAudioFrameCallback != null))
    {
      this.mEngineCommon = paramIAVEngineCommon;
      this.mSetAudioFrameCallback = paramISetAudioFrameCallback;
      this.mIsInited = true;
      this.mAddCnt = 0;
      this.mAddLen = 0;
      this.mAddStartTime = 0L;
      this.mMixCnt = 0;
      this.mMixLen = 0;
      this.mMixStartTime = 0L;
      AVLog.d("AudioProcessApiImpl", "init successfully.");
      return true;
    }
    this.mIsInited = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init failed. engineCommon = ");
    localStringBuilder.append(paramIAVEngineCommon);
    localStringBuilder.append(" setAudioFrameCallback = ");
    localStringBuilder.append(paramISetAudioFrameCallback);
    AVLog.a("AudioProcessApiImpl", localStringBuilder.toString(), new Throwable("打印调用栈"));
    return false;
  }
  
  public boolean isPlayStarted()
  {
    return this.mPlayState != 0;
  }
  
  public boolean isRecogStarted()
  {
    return this.mRecogState != 0;
  }
  
  public boolean isRecordStarted()
  {
    return this.mRecordState != 0;
  }
  
  public void mix(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3)
    {
      if ((this.mPlayState == 1) && ((this.mPlayMixSrcType & 0x2) > 0) && ((this.mFileInfoList.size() > 0) || (this.mPCMDataQueueFromOutside.size() > 0)))
      {
        List localList = mergePCMDataList(getPCMDataFromPCMFile(this.mFileInfoList, paramInt2), getPCMDataFromMP3File(this.mFileInfoList, paramInt2));
        if (this.mPCMDataQueueFromOutside.size() > 0) {
          synchronized (this.mLockPCMDataFromOutside)
          {
            if (this.mPCMDataQueueFromOutside.size() > 0) {
              localList.add(this.mPCMDataQueueFromOutside.poll());
            }
          }
        }
        mix(paramArrayOfByte, localList);
      }
    }
    else if (paramInt1 == 100)
    {
      if (this.mRecordState == 1)
      {
        ??? = this.mOnRecord;
        if (??? != null) {
          ((AudioProcessCallback.OnRecord)???).a(paramArrayOfByte);
        }
      }
    }
    else if (paramInt1 != 8) {}
    for (;;)
    {
      synchronized (this.mLockRecog)
      {
        if ((isRecogStarted()) && (!TextUtils.isEmpty(this.mRecogTxt)))
        {
          if ((this.mRecogTimeStart == 0L) && (isSpeaking3(paramArrayOfByte)))
          {
            this.mRecogTimeStart = System.currentTimeMillis();
            AVLog.c("AudioProcessApiImpl", "reset RecogTimeStart");
          }
          if (((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).recognize(paramArrayOfByte, paramArrayOfByte.length) == 1)
          {
            ((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).end();
            long l = System.currentTimeMillis();
            if (this.mRecogTimeStart <= 0L) {
              break label381;
            }
            paramInt1 = (int)(l - this.mRecogTimeStart);
            this.mRecogTimeStart = 0L;
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("onReceiveAudioFrame. 本地识别成功。答案：");
            paramArrayOfByte.append(this.mRecogTxt);
            paramArrayOfByte.append(", recogTimeLen = ");
            paramArrayOfByte.append(paramInt1);
            AVLog.d("AudioProcessApiImpl", paramArrayOfByte.toString());
            if (this.mOnRecog != null) {
              this.mOnRecog.a(this.mRecogTxt, paramInt1);
            }
          }
        }
        return;
      }
      return;
      label381:
      paramInt1 = 0;
    }
  }
  
  public void onReceiveAudioFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.mIsInited) {
      return;
    }
    int i = paramInt2;
    if (paramInt2 % 2 != 0)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onReceiveAudioFrame. size = ");
      ((StringBuilder)???).append(paramInt2);
      AVLog.a("AudioProcessApiImpl", ((StringBuilder)???).toString());
      i = paramInt2 - 1;
    }
    if (this.mMixCnt == 0) {
      this.mMixStartTime = System.currentTimeMillis();
    }
    this.mMixCnt += 1;
    this.mMixLen += i;
    long l;
    if (this.mMixCnt == 400)
    {
      l = System.currentTimeMillis();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onReceiveAudioFrame. mMixCnt = ");
      ((StringBuilder)???).append(this.mMixCnt);
      ((StringBuilder)???).append(", mMixLen = ");
      ((StringBuilder)???).append(this.mMixLen);
      ((StringBuilder)???).append(", mMixStartTime = ");
      ((StringBuilder)???).append(this.mMixStartTime);
      ((StringBuilder)???).append(", mixEndTime = ");
      ((StringBuilder)???).append(l);
      ((StringBuilder)???).append(", mMixTimeLen = ");
      ((StringBuilder)???).append(l - this.mMixStartTime);
      AVLog.d("AudioProcessApiImpl", ((StringBuilder)???).toString());
      this.mMixCnt = 0;
      this.mMixLen = 0;
      this.mMixStartTime = 0L;
    }
    synchronized (this.mLock)
    {
      l = System.currentTimeMillis();
      mix(paramArrayOfByte, paramInt1, i);
      l = System.currentTimeMillis() - l;
      if (l > 50L)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("onReceiveAudioFrame. mix. srcType = ");
        paramArrayOfByte.append(paramInt1);
        paramArrayOfByte.append(", big timelen = ");
        paramArrayOfByte.append(l);
        AVLog.b("AudioProcessApiImpl", paramArrayOfByte.toString());
      }
      return;
    }
  }
  
  public void pausePlay()
  {
    if (isPlayStarted()) {
      this.mPlayState = 2;
    }
  }
  
  public void pauseRecord()
  {
    if (isRecordStarted()) {
      this.mRecordState = 2;
    }
  }
  
  /* Error */
  public void removeAllFiles()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 117	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mLock	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: iconst_0
    //   8: istore_1
    //   9: iload_1
    //   10: aload_0
    //   11: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   14: invokeinterface 269 1 0
    //   19: if_icmpge +295 -> 314
    //   22: aload_0
    //   23: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   26: iload_1
    //   27: invokeinterface 272 2 0
    //   32: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   35: getfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +89 -> 129
    //   43: aload_0
    //   44: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   47: iload_1
    //   48: invokeinterface 272 2 0
    //   53: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   56: getfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   59: invokevirtual 346	java/io/RandomAccessFile:close	()V
    //   62: aload_0
    //   63: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   66: iload_1
    //   67: invokeinterface 272 2 0
    //   72: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   75: astore_2
    //   76: aload_2
    //   77: aconst_null
    //   78: putfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   81: goto +256 -> 337
    //   84: astore_2
    //   85: goto +25 -> 110
    //   88: astore_2
    //   89: aload_2
    //   90: invokevirtual 349	java/io/IOException:printStackTrace	()V
    //   93: aload_0
    //   94: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   97: iload_1
    //   98: invokeinterface 272 2 0
    //   103: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   106: astore_2
    //   107: goto -31 -> 76
    //   110: aload_0
    //   111: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   114: iload_1
    //   115: invokeinterface 272 2 0
    //   120: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   123: aconst_null
    //   124: putfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   127: aload_2
    //   128: athrow
    //   129: aload_0
    //   130: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   133: iload_1
    //   134: invokeinterface 272 2 0
    //   139: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   142: getfield 138	com/tencent/av/audioprocess/FileInfo:j	Landroid/media/MediaExtractor;
    //   145: ifnonnull +22 -> 167
    //   148: aload_0
    //   149: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   152: iload_1
    //   153: invokeinterface 272 2 0
    //   158: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   161: getfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   164: ifnull +173 -> 337
    //   167: aload_0
    //   168: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   171: iload_1
    //   172: invokeinterface 272 2 0
    //   177: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   180: getfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   183: astore_2
    //   184: aload_2
    //   185: ifnull +71 -> 256
    //   188: aload_0
    //   189: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   192: iload_1
    //   193: invokeinterface 272 2 0
    //   198: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   201: getfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   204: invokevirtual 294	android/media/MediaCodec:stop	()V
    //   207: aload_0
    //   208: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   211: iload_1
    //   212: invokeinterface 272 2 0
    //   217: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   220: getfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   223: invokevirtual 297	android/media/MediaCodec:release	()V
    //   226: goto +13 -> 239
    //   229: astore_2
    //   230: ldc 20
    //   232: ldc_w 299
    //   235: aload_2
    //   236: invokestatic 302	com/tencent/qav/log/AVLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   239: aload_0
    //   240: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   243: iload_1
    //   244: invokeinterface 272 2 0
    //   249: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   252: aconst_null
    //   253: putfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   256: aload_0
    //   257: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   260: iload_1
    //   261: invokeinterface 272 2 0
    //   266: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   269: getfield 138	com/tencent/av/audioprocess/FileInfo:j	Landroid/media/MediaExtractor;
    //   272: ifnull +65 -> 337
    //   275: aload_0
    //   276: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   279: iload_1
    //   280: invokeinterface 272 2 0
    //   285: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   288: getfield 138	com/tencent/av/audioprocess/FileInfo:j	Landroid/media/MediaExtractor;
    //   291: invokevirtual 303	android/media/MediaExtractor:release	()V
    //   294: aload_0
    //   295: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   298: iload_1
    //   299: invokeinterface 272 2 0
    //   304: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   307: aconst_null
    //   308: putfield 138	com/tencent/av/audioprocess/FileInfo:j	Landroid/media/MediaExtractor;
    //   311: goto +26 -> 337
    //   314: aload_0
    //   315: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   318: invokeinterface 761 1 0
    //   323: aload_3
    //   324: monitorexit
    //   325: return
    //   326: astore_2
    //   327: aload_3
    //   328: monitorexit
    //   329: goto +5 -> 334
    //   332: aload_2
    //   333: athrow
    //   334: goto -2 -> 332
    //   337: iload_1
    //   338: iconst_1
    //   339: iadd
    //   340: istore_1
    //   341: goto -332 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	AudioProcessApiImpl
    //   8	333	1	i	int
    //   38	39	2	localObject1	Object
    //   84	1	2	localObject2	Object
    //   88	2	2	localIOException	IOException
    //   106	79	2	localObject3	Object
    //   229	7	2	localIllegalStateException	IllegalStateException
    //   326	7	2	localObject4	Object
    //   4	324	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   43	62	84	finally
    //   89	93	84	finally
    //   43	62	88	java/io/IOException
    //   188	226	229	java/lang/IllegalStateException
    //   9	39	326	finally
    //   62	76	326	finally
    //   76	81	326	finally
    //   93	107	326	finally
    //   110	129	326	finally
    //   129	167	326	finally
    //   167	184	326	finally
    //   188	226	326	finally
    //   230	239	326	finally
    //   239	256	326	finally
    //   256	311	326	finally
    //   314	325	326	finally
    //   327	329	326	finally
  }
  
  /* Error */
  public void removeFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 117	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mLock	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: iconst_0
    //   8: istore_2
    //   9: iload_2
    //   10: aload_0
    //   11: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   14: invokeinterface 269 1 0
    //   19: if_icmpge +328 -> 347
    //   22: aload_0
    //   23: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   26: iload_2
    //   27: invokeinterface 272 2 0
    //   32: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   35: getfield 310	com/tencent/av/audioprocess/FileInfo:c	Ljava/lang/String;
    //   38: aload_1
    //   39: invokevirtual 628	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   42: ifeq +319 -> 361
    //   45: aload_0
    //   46: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   49: iload_2
    //   50: invokeinterface 272 2 0
    //   55: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   58: getfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +71 -> 134
    //   66: aload_0
    //   67: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   70: iload_2
    //   71: invokeinterface 272 2 0
    //   76: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   79: getfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   82: invokevirtual 346	java/io/RandomAccessFile:close	()V
    //   85: aload_0
    //   86: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   89: astore_1
    //   90: aload_1
    //   91: iload_2
    //   92: invokeinterface 322 2 0
    //   97: pop
    //   98: goto +20 -> 118
    //   101: astore_1
    //   102: goto +19 -> 121
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 349	java/io/IOException:printStackTrace	()V
    //   110: aload_0
    //   111: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   114: astore_1
    //   115: goto -25 -> 90
    //   118: aload_3
    //   119: monitorexit
    //   120: return
    //   121: aload_0
    //   122: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   125: iload_2
    //   126: invokeinterface 322 2 0
    //   131: pop
    //   132: aload_1
    //   133: athrow
    //   134: aload_0
    //   135: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   138: iload_2
    //   139: invokeinterface 272 2 0
    //   144: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   147: getfield 138	com/tencent/av/audioprocess/FileInfo:j	Landroid/media/MediaExtractor;
    //   150: ifnonnull +39 -> 189
    //   153: aload_0
    //   154: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   157: iload_2
    //   158: invokeinterface 272 2 0
    //   163: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   166: getfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   169: ifnull +6 -> 175
    //   172: goto +17 -> 189
    //   175: aload_0
    //   176: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   179: iload_2
    //   180: invokeinterface 322 2 0
    //   185: pop
    //   186: aload_3
    //   187: monitorexit
    //   188: return
    //   189: aload_0
    //   190: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   193: iload_2
    //   194: invokeinterface 272 2 0
    //   199: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   202: getfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   205: astore_1
    //   206: aload_1
    //   207: ifnull +71 -> 278
    //   210: aload_0
    //   211: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   214: iload_2
    //   215: invokeinterface 272 2 0
    //   220: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   223: getfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   226: invokevirtual 294	android/media/MediaCodec:stop	()V
    //   229: aload_0
    //   230: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   233: iload_2
    //   234: invokeinterface 272 2 0
    //   239: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   242: getfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   245: invokevirtual 297	android/media/MediaCodec:release	()V
    //   248: goto +13 -> 261
    //   251: astore_1
    //   252: ldc 20
    //   254: ldc_w 299
    //   257: aload_1
    //   258: invokestatic 302	com/tencent/qav/log/AVLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   261: aload_0
    //   262: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   265: iload_2
    //   266: invokeinterface 272 2 0
    //   271: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   274: aconst_null
    //   275: putfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   278: aload_0
    //   279: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   282: iload_2
    //   283: invokeinterface 272 2 0
    //   288: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   291: getfield 138	com/tencent/av/audioprocess/FileInfo:j	Landroid/media/MediaExtractor;
    //   294: ifnull +39 -> 333
    //   297: aload_0
    //   298: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   301: iload_2
    //   302: invokeinterface 272 2 0
    //   307: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   310: getfield 138	com/tencent/av/audioprocess/FileInfo:j	Landroid/media/MediaExtractor;
    //   313: invokevirtual 303	android/media/MediaExtractor:release	()V
    //   316: aload_0
    //   317: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   320: iload_2
    //   321: invokeinterface 272 2 0
    //   326: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   329: aconst_null
    //   330: putfield 138	com/tencent/av/audioprocess/FileInfo:j	Landroid/media/MediaExtractor;
    //   333: aload_0
    //   334: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   337: iload_2
    //   338: invokeinterface 322 2 0
    //   343: pop
    //   344: aload_3
    //   345: monitorexit
    //   346: return
    //   347: aload_3
    //   348: monitorexit
    //   349: return
    //   350: astore_1
    //   351: aload_3
    //   352: monitorexit
    //   353: goto +5 -> 358
    //   356: aload_1
    //   357: athrow
    //   358: goto -2 -> 356
    //   361: iload_2
    //   362: iconst_1
    //   363: iadd
    //   364: istore_2
    //   365: goto -356 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	AudioProcessApiImpl
    //   0	368	1	paramString	String
    //   8	357	2	i	int
    //   4	348	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   66	85	101	finally
    //   106	110	101	finally
    //   66	85	105	java/io/IOException
    //   210	248	251	java/lang/IllegalStateException
    //   9	62	350	finally
    //   85	90	350	finally
    //   90	98	350	finally
    //   110	115	350	finally
    //   118	120	350	finally
    //   121	134	350	finally
    //   134	172	350	finally
    //   175	188	350	finally
    //   189	206	350	finally
    //   210	248	350	finally
    //   252	261	350	finally
    //   261	278	350	finally
    //   278	333	350	finally
    //   333	346	350	finally
    //   347	349	350	finally
    //   351	353	350	finally
  }
  
  public void resumePlay()
  {
    if (isPlayStarted()) {
      this.mPlayState = 1;
    }
  }
  
  public void resumeRecord()
  {
    if (isRecordStarted()) {
      this.mRecordState = 1;
    }
  }
  
  public void scaleVolumeValue(byte[] paramArrayOfByte, float paramFloat)
  {
    scaleVolume(paramArrayOfByte, paramFloat);
  }
  
  public boolean startPlay(int paramInt)
  {
    if ((this.mIsInited) && (this.mEngineCommon != null))
    {
      if (isPlayStarted()) {
        return true;
      }
      if (paramInt <= 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startPlay failed. mixSrcType = ");
        localStringBuilder.append(paramInt);
        AVLog.a("AudioProcessApiImpl", localStringBuilder.toString());
        return false;
      }
      int i = this.mEngineCommon.registerAudioDataCallback(3, true);
      if (i != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startPlay failed. registerAudioDataCallback failed. ret = ");
        localStringBuilder.append(i);
        AVLog.a("AudioProcessApiImpl", localStringBuilder.toString());
        return false;
      }
      i = this.mEngineCommon.setAudioDataFormat(3, 48000, 1, 16);
      if (i != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startPlay failed. setAudioDataFormat failed. ret = ");
        localStringBuilder.append(i);
        AVLog.a("AudioProcessApiImpl", localStringBuilder.toString());
        return false;
      }
      AVVoiceRecog.b().b(128);
      setAudioFrameCallback(1, this);
      this.mPlayMixSrcType = paramInt;
      this.mPlayState = 1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startPlay successfully. mixSrcType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ret = ");
      localStringBuilder.append(i);
      AVLog.d("AudioProcessApiImpl", localStringBuilder.toString());
      return true;
    }
    AVLog.a("AudioProcessApiImpl", "startPlay failed. !mIsInited || mEngineCommon == null.");
    return false;
  }
  
  public boolean startRecog(AudioProcessCallback.OnRecog paramOnRecog)
  {
    if ((this.mIsInited) && (this.mEngineCommon != null))
    {
      if (isRecogStarted()) {
        return true;
      }
      if (!((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).init())
      {
        AVLog.a("AudioProcessApiImpl", "startRecog failed. !ret.");
        return false;
      }
      int i = this.mEngineCommon.registerAudioDataCallback(8, false);
      int j = this.mEngineCommon.setAudioDataFormat(8, 16000, 1, 16);
      if ((i == 0) && (j == 0))
      {
        AVVoiceRecog.b().b(128);
        setAudioFrameCallback(1, this);
        this.mEngineCommon.enableLocalSpeechRecognizeModel(true);
        this.mOnRecog = paramOnRecog;
        this.mRecogState = 1;
        AVLog.d("AudioProcessApiImpl", "startRecog successfully.");
        return true;
      }
      paramOnRecog = new StringBuilder();
      paramOnRecog.append("startRecog failed. MIX_SRC_TYPE_MIC. ret1 = ");
      paramOnRecog.append(i);
      paramOnRecog.append(", ret2 = ");
      paramOnRecog.append(j);
      AVLog.a("AudioProcessApiImpl", paramOnRecog.toString());
      return false;
    }
    AVLog.a("AudioProcessApiImpl", "startRecog failed. !mIsInited || mEngineCommon == null.");
    return false;
  }
  
  public boolean startRecord(int paramInt, AudioProcessCallback.OnRecord paramOnRecord)
  {
    if ((this.mIsInited) && (this.mEngineCommon != null))
    {
      if (AudioDump.c())
      {
        QQToast.makeText(BaseApplicationImpl.getApplication(), 2131887202, 1).show();
        return false;
      }
      if (isRecordStarted()) {
        return true;
      }
      if (paramInt > 0)
      {
        int i = paramInt & 0x4;
        if ((i != 0) || ((paramInt & 0x1) != 0))
        {
          int j;
          if (i > 0)
          {
            i = this.mEngineCommon.registerAudioDataCallback(0, true);
            j = this.mEngineCommon.setAudioDataFormat(0, 48000, 1, 16);
            if ((i != 0) || (j != 0))
            {
              paramOnRecord = new StringBuilder();
              paramOnRecord.append("startRecord failed. MIX_SRC_TYPE_MIC. ret1 = ");
              paramOnRecord.append(i);
              paramOnRecord.append(", ret2 = ");
              paramOnRecord.append(j);
              AVLog.a("AudioProcessApiImpl", paramOnRecord.toString());
              return false;
            }
          }
          if ((paramInt & 0x1) > 0)
          {
            i = this.mEngineCommon.registerAudioDataCallback(4, true);
            j = this.mEngineCommon.setAudioDataFormat(4, 48000, 1, 16);
            if ((i != 0) || (j != 0))
            {
              paramOnRecord = new StringBuilder();
              paramOnRecord.append("startRecord failed. MIX_SRC_TYPE_RECV. ret1 = ");
              paramOnRecord.append(i);
              paramOnRecord.append(", ret2 = ");
              paramOnRecord.append(j);
              AVLog.a("AudioProcessApiImpl", paramOnRecord.toString());
              return false;
            }
          }
          AVVoiceRecog.b().b(128);
          this.mOnRecord = paramOnRecord;
          setAudioFrameCallback(0, this);
          this.mRecordMixSrcType = paramInt;
          this.mRecordState = 1;
          paramOnRecord = new StringBuilder();
          paramOnRecord.append("startRecord successfully. mixSrcType = ");
          paramOnRecord.append(paramInt);
          AVLog.d("AudioProcessApiImpl", paramOnRecord.toString());
          return true;
        }
      }
      paramOnRecord = new StringBuilder();
      paramOnRecord.append("startRecord failed. mixSrcType = ");
      paramOnRecord.append(paramInt);
      AVLog.a("AudioProcessApiImpl", paramOnRecord.toString());
      return false;
    }
    AVLog.a("AudioProcessApiImpl", "startRecord failed. !mIsInited || mEngineCommon == null.");
    return false;
  }
  
  public void stopPlay()
  {
    if (this.mIsInited)
    {
      if (this.mEngineCommon == null) {
        return;
      }
      if (!isPlayStarted()) {
        return;
      }
      try
      {
        setAudioFrameCallback(1, null);
        int i = this.mEngineCommon.unregisterAudioDataCallback(3);
        this.mPlayState = 0;
        if ((!isPlayStarted()) && (!isRecogStarted()) && (!isRecordStarted())) {
          AVVoiceRecog.b().c(128);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopPlay successfully. ret = ");
        localStringBuilder.append(i);
        AVLog.d("AudioProcessApiImpl", localStringBuilder.toString());
        return;
      }
      catch (Exception localException)
      {
        AVLog.a("AudioProcessApiImpl", "stopPlay failed. ", localException);
      }
    }
  }
  
  public void stopRecog()
  {
    if (this.mIsInited)
    {
      if (this.mEngineCommon == null) {
        return;
      }
      if (!isRecogStarted()) {
        return;
      }
      try
      {
        this.mOnRecog = null;
        ((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).destroy();
        setAudioFrameCallback(1, null);
        this.mEngineCommon.unregisterAudioDataCallback(8);
        this.mEngineCommon.enableLocalSpeechRecognizeModel(false);
        this.mRecogState = 0;
        if ((!isPlayStarted()) && (!isRecogStarted()) && (!isRecordStarted())) {
          AVVoiceRecog.b().c(128);
        }
        AVLog.d("AudioProcessApiImpl", "stopRecog sucessfully.");
        return;
      }
      catch (Exception localException)
      {
        AVLog.a("AudioProcessApiImpl", "stopRecog failed.", localException);
      }
    }
  }
  
  public void stopRecord()
  {
    if (this.mIsInited)
    {
      if (this.mEngineCommon == null) {
        return;
      }
      if (!isRecordStarted()) {
        return;
      }
      try
      {
        this.mOnRecord = null;
        setAudioFrameCallback(0, null);
        if ((this.mRecordMixSrcType & 0x4) > 0) {
          this.mEngineCommon.unregisterAudioDataCallback(0);
        }
        if ((this.mRecordMixSrcType & 0x1) > 0) {
          this.mEngineCommon.unregisterAudioDataCallback(4);
        }
        this.mRecordState = 0;
        if ((!isPlayStarted()) && (!isRecogStarted()) && (!isRecordStarted())) {
          AVVoiceRecog.b().c(128);
        }
        AVLog.d("AudioProcessApiImpl", "stopRecord sucessfully.");
        return;
      }
      catch (Exception localException)
      {
        AVLog.a("AudioProcessApiImpl", "stopRecord failed.", localException);
      }
    }
  }
  
  /* Error */
  public void unInit()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mIsInited	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 101	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mAddCnt	I
    //   12: ifeq +120 -> 132
    //   15: invokestatic 514	java/lang/System:currentTimeMillis	()J
    //   18: lstore_2
    //   19: new 231	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   26: astore 4
    //   28: aload 4
    //   30: ldc_w 876
    //   33: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 4
    //   39: aload_0
    //   40: getfield 101	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mAddCnt	I
    //   43: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 4
    //   49: ldc_w 657
    //   52: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 4
    //   58: aload_0
    //   59: getfield 103	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mAddLen	I
    //   62: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 4
    //   68: ldc_w 659
    //   71: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 4
    //   77: aload_0
    //   78: getfield 105	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mAddStartTime	J
    //   81: invokevirtual 604	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 4
    //   87: ldc_w 661
    //   90: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 4
    //   96: lload_2
    //   97: invokevirtual 604	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 4
    //   103: ldc_w 663
    //   106: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 4
    //   112: lload_2
    //   113: aload_0
    //   114: getfield 105	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mAddStartTime	J
    //   117: lsub
    //   118: invokevirtual 604	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: ldc 20
    //   124: aload 4
    //   126: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 549	com/tencent/qav/log/AVLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: iconst_0
    //   134: putfield 101	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mAddCnt	I
    //   137: aload_0
    //   138: iconst_0
    //   139: putfield 103	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mAddLen	I
    //   142: aload_0
    //   143: lconst_0
    //   144: putfield 105	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mAddStartTime	J
    //   147: aload_0
    //   148: getfield 107	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mMixCnt	I
    //   151: ifeq +120 -> 271
    //   154: invokestatic 514	java/lang/System:currentTimeMillis	()J
    //   157: lstore_2
    //   158: new 231	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   165: astore 4
    //   167: aload 4
    //   169: ldc_w 878
    //   172: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 4
    //   178: aload_0
    //   179: getfield 107	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mMixCnt	I
    //   182: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 4
    //   188: ldc_w 738
    //   191: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 4
    //   197: aload_0
    //   198: getfield 109	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mMixLen	I
    //   201: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 4
    //   207: ldc_w 740
    //   210: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 4
    //   216: aload_0
    //   217: getfield 111	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mMixStartTime	J
    //   220: invokevirtual 604	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 4
    //   226: ldc_w 742
    //   229: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 4
    //   235: lload_2
    //   236: invokevirtual 604	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 4
    //   242: ldc_w 744
    //   245: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 4
    //   251: lload_2
    //   252: aload_0
    //   253: getfield 111	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mMixStartTime	J
    //   256: lsub
    //   257: invokevirtual 604	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: ldc 20
    //   263: aload 4
    //   265: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 549	com/tencent/qav/log/AVLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_0
    //   272: iconst_0
    //   273: putfield 107	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mMixCnt	I
    //   276: aload_0
    //   277: iconst_0
    //   278: putfield 109	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mMixLen	I
    //   281: aload_0
    //   282: lconst_0
    //   283: putfield 111	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mMixStartTime	J
    //   286: aload_0
    //   287: invokevirtual 880	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:stopPlay	()V
    //   290: aload_0
    //   291: invokevirtual 882	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:stopRecord	()V
    //   294: aload_0
    //   295: invokevirtual 884	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:stopRecog	()V
    //   298: aload_0
    //   299: aconst_null
    //   300: putfield 123	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mEngineCommon	Lcom/tencent/avcore/engine/common/IAVEngineCommon;
    //   303: aload_0
    //   304: getfield 117	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mLock	Ljava/lang/Object;
    //   307: astore 5
    //   309: aload 5
    //   311: monitorenter
    //   312: iconst_0
    //   313: istore_1
    //   314: iload_1
    //   315: aload_0
    //   316: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   319: invokeinterface 269 1 0
    //   324: if_icmpge +308 -> 632
    //   327: aload_0
    //   328: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   331: iload_1
    //   332: invokeinterface 272 2 0
    //   337: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   340: getfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   343: astore 4
    //   345: aload 4
    //   347: ifnull +96 -> 443
    //   350: aload_0
    //   351: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   354: iload_1
    //   355: invokeinterface 272 2 0
    //   360: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   363: getfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   366: invokevirtual 346	java/io/RandomAccessFile:close	()V
    //   369: aload_0
    //   370: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   373: iload_1
    //   374: invokeinterface 272 2 0
    //   379: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   382: astore 4
    //   384: aload 4
    //   386: aconst_null
    //   387: putfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   390: goto +311 -> 701
    //   393: astore 4
    //   395: goto +28 -> 423
    //   398: astore 4
    //   400: aload 4
    //   402: invokevirtual 349	java/io/IOException:printStackTrace	()V
    //   405: aload_0
    //   406: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   409: iload_1
    //   410: invokeinterface 272 2 0
    //   415: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   418: astore 4
    //   420: goto -36 -> 384
    //   423: aload_0
    //   424: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   427: iload_1
    //   428: invokeinterface 272 2 0
    //   433: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   436: aconst_null
    //   437: putfield 341	com/tencent/av/audioprocess/FileInfo:h	Ljava/io/RandomAccessFile;
    //   440: aload 4
    //   442: athrow
    //   443: aload_0
    //   444: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   447: iload_1
    //   448: invokeinterface 272 2 0
    //   453: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   456: getfield 138	com/tencent/av/audioprocess/FileInfo:j	Landroid/media/MediaExtractor;
    //   459: ifnonnull +22 -> 481
    //   462: aload_0
    //   463: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   466: iload_1
    //   467: invokeinterface 272 2 0
    //   472: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   475: getfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   478: ifnull +223 -> 701
    //   481: aload_0
    //   482: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   485: iload_1
    //   486: invokeinterface 272 2 0
    //   491: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   494: getfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   497: astore 4
    //   499: aload 4
    //   501: ifnull +73 -> 574
    //   504: aload_0
    //   505: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   508: iload_1
    //   509: invokeinterface 272 2 0
    //   514: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   517: getfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   520: invokevirtual 294	android/media/MediaCodec:stop	()V
    //   523: aload_0
    //   524: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   527: iload_1
    //   528: invokeinterface 272 2 0
    //   533: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   536: getfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   539: invokevirtual 297	android/media/MediaCodec:release	()V
    //   542: goto +15 -> 557
    //   545: astore 4
    //   547: ldc 20
    //   549: ldc_w 299
    //   552: aload 4
    //   554: invokestatic 302	com/tencent/qav/log/AVLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   557: aload_0
    //   558: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   561: iload_1
    //   562: invokeinterface 272 2 0
    //   567: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   570: aconst_null
    //   571: putfield 142	com/tencent/av/audioprocess/FileInfo:a	Landroid/media/MediaCodec;
    //   574: aload_0
    //   575: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   578: iload_1
    //   579: invokeinterface 272 2 0
    //   584: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   587: getfield 138	com/tencent/av/audioprocess/FileInfo:j	Landroid/media/MediaExtractor;
    //   590: ifnull +111 -> 701
    //   593: aload_0
    //   594: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   597: iload_1
    //   598: invokeinterface 272 2 0
    //   603: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   606: getfield 138	com/tencent/av/audioprocess/FileInfo:j	Landroid/media/MediaExtractor;
    //   609: invokevirtual 303	android/media/MediaExtractor:release	()V
    //   612: aload_0
    //   613: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   616: iload_1
    //   617: invokeinterface 272 2 0
    //   622: checkcast 134	com/tencent/av/audioprocess/FileInfo
    //   625: aconst_null
    //   626: putfield 138	com/tencent/av/audioprocess/FileInfo:j	Landroid/media/MediaExtractor;
    //   629: goto +72 -> 701
    //   632: aload_0
    //   633: getfield 90	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mFileInfoList	Ljava/util/List;
    //   636: invokeinterface 761 1 0
    //   641: aload 5
    //   643: monitorexit
    //   644: aload_0
    //   645: getfield 119	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mLockPCMDataFromOutside	Ljava/lang/Object;
    //   648: astore 4
    //   650: aload 4
    //   652: monitorenter
    //   653: aload_0
    //   654: getfield 95	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mPCMDataQueueFromOutside	Ljava/util/Queue;
    //   657: invokeinterface 885 1 0
    //   662: aload 4
    //   664: monitorexit
    //   665: aload_0
    //   666: iconst_0
    //   667: putfield 65	com/tencent/av/audioprocess/api/impl/AudioProcessApiImpl:mIsInited	Z
    //   670: ldc 20
    //   672: ldc_w 887
    //   675: invokestatic 549	com/tencent/qav/log/AVLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   678: return
    //   679: astore 5
    //   681: aload 4
    //   683: monitorexit
    //   684: aload 5
    //   686: athrow
    //   687: astore 4
    //   689: aload 5
    //   691: monitorexit
    //   692: goto +6 -> 698
    //   695: aload 4
    //   697: athrow
    //   698: goto -3 -> 695
    //   701: iload_1
    //   702: iconst_1
    //   703: iadd
    //   704: istore_1
    //   705: goto -391 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	708	0	this	AudioProcessApiImpl
    //   313	392	1	i	int
    //   18	234	2	l	long
    //   26	359	4	localObject1	Object
    //   393	1	4	localObject2	Object
    //   398	3	4	localIOException	IOException
    //   418	82	4	localObject3	Object
    //   545	8	4	localIllegalStateException	IllegalStateException
    //   648	34	4	localObject4	Object
    //   687	9	4	localObject5	Object
    //   307	335	5	localObject6	Object
    //   679	11	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   350	369	393	finally
    //   400	405	393	finally
    //   350	369	398	java/io/IOException
    //   504	542	545	java/lang/IllegalStateException
    //   653	665	679	finally
    //   681	684	679	finally
    //   314	345	687	finally
    //   369	384	687	finally
    //   384	390	687	finally
    //   405	420	687	finally
    //   423	443	687	finally
    //   443	481	687	finally
    //   481	499	687	finally
    //   504	542	687	finally
    //   547	557	687	finally
    //   557	574	687	finally
    //   574	629	687	finally
    //   632	644	687	finally
    //   689	692	687	finally
  }
  
  public void updateRecogTxt(String paramString)
  {
    if (!isRecogStarted()) {
      return;
    }
    synchronized (this.mLockRecog)
    {
      ((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).end();
      this.mRecogTxt = paramString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateRecogTxt. txt = ");
      localStringBuilder.append(paramString);
      AVLog.d("AudioProcessApiImpl", localStringBuilder.toString());
      ((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).update(paramString);
      if (!TextUtils.isEmpty(this.mRecogTxt)) {
        ((IAVGameVoiceRecog)QRoute.api(IAVGameVoiceRecog.class)).begin();
      }
      this.mRecogTimeStart = 0L;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.audioprocess.api.impl.AudioProcessApiImpl
 * JD-Core Version:    0.7.0.1
 */