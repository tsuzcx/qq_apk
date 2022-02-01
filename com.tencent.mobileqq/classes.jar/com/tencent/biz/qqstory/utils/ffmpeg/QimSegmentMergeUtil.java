package com.tencent.biz.qqstory.utils.ffmpeg;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IHwVideoMerge;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@TargetApi(18)
public class QimSegmentMergeUtil
{
  public ArrayList<Long> a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() != 1))
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        if (localLinkedHashMap.containsKey(localObject))
        {
          l = ((Long)localLinkedHashMap.get(localObject)).longValue();
          localLinkedHashMap.put(localObject, Long.valueOf(l + l));
        }
        else
        {
          localLinkedHashMap.put(localObject, Long.valueOf(MediaUtil.a((String)localObject)));
        }
      }
      paramList = new ArrayList();
      long l = -10L;
      Object localObject = localLinkedHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        l += ((Long)localLinkedHashMap.get((String)((Iterator)localObject).next())).longValue();
        paramList.add(Long.valueOf(l));
      }
      if (paramList.size() > 1) {
        paramList.remove(paramList.size() - 1);
      }
      return paramList;
    }
    return null;
  }
  
  public ArrayList<Long> a(List<String> paramList, String paramString)
  {
    if ((paramList != null) && (paramList.size() != 1) && (!TextUtils.isEmpty(paramString)))
    {
      long l3 = MediaUtil.a(paramString);
      paramString = new LinkedHashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        if (paramString.containsKey(localObject))
        {
          l1 = ((Long)paramString.get(localObject)).longValue();
          paramString.put(localObject, Long.valueOf(l1 + l1));
        }
        else
        {
          paramString.put(localObject, Long.valueOf(MediaUtil.a((String)localObject)));
        }
      }
      paramList = new ArrayList();
      Object localObject = paramString.keySet().iterator();
      long l1 = 0L;
      long l2 = 0L;
      while (((Iterator)localObject).hasNext())
      {
        l2 += ((Long)paramString.get((String)((Iterator)localObject).next())).longValue();
        paramList.add(Long.valueOf(l2));
      }
      if (l2 > l3) {
        l1 = (l2 - l3) / (paramString.size() - 1) / 2L;
      }
      if (paramList.size() > 1) {
        paramList.remove(paramList.size() - 1);
      }
      l2 = -50L;
      int i = 0;
      int j = paramList.size();
      while (i < j)
      {
        paramList.set(i, Long.valueOf(((Long)paramList.get(i)).longValue() - l1 + l2));
        l2 -= l1 * 2L;
        i += 1;
      }
      return paramList;
    }
    return null;
  }
  
  /* Error */
  public boolean a(List<String> paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 114	java/io/FileOutputStream
    //   9: dup
    //   10: new 116	java/io/File
    //   13: dup
    //   14: aload_2
    //   15: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 122	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   21: astore_2
    //   22: iconst_0
    //   23: istore_3
    //   24: iload_3
    //   25: aload_1
    //   26: invokeinterface 20 1 0
    //   31: if_icmpge +131 -> 162
    //   34: new 124	java/io/RandomAccessFile
    //   37: dup
    //   38: aload_1
    //   39: iload_3
    //   40: invokeinterface 125 2 0
    //   45: checkcast 39	java/lang/String
    //   48: ldc 127
    //   50: invokespecial 130	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: astore 5
    //   55: ldc 131
    //   57: newarray byte
    //   59: astore 6
    //   61: aload 5
    //   63: aload 6
    //   65: invokevirtual 135	java/io/RandomAccessFile:read	([B)I
    //   68: istore 4
    //   70: iload 4
    //   72: iconst_m1
    //   73: if_icmpeq +15 -> 88
    //   76: aload_2
    //   77: aload 6
    //   79: iconst_0
    //   80: iload 4
    //   82: invokevirtual 139	java/io/FileOutputStream:write	([BII)V
    //   85: goto -24 -> 61
    //   88: aload 5
    //   90: invokevirtual 142	java/io/RandomAccessFile:close	()V
    //   93: goto +10 -> 103
    //   96: astore 5
    //   98: aload 5
    //   100: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   103: iload_3
    //   104: iconst_1
    //   105: iadd
    //   106: istore_3
    //   107: goto -83 -> 24
    //   110: astore_1
    //   111: goto +34 -> 145
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   119: aload 5
    //   121: invokevirtual 142	java/io/RandomAccessFile:close	()V
    //   124: goto +8 -> 132
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   132: aload_2
    //   133: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   143: iconst_0
    //   144: ireturn
    //   145: aload 5
    //   147: invokevirtual 142	java/io/RandomAccessFile:close	()V
    //   150: goto +10 -> 160
    //   153: astore 5
    //   155: aload 5
    //   157: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   160: aload_1
    //   161: athrow
    //   162: aload_2
    //   163: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   166: aload_2
    //   167: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   170: goto +8 -> 178
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   178: iconst_1
    //   179: ireturn
    //   180: astore_1
    //   181: goto +48 -> 229
    //   184: astore 5
    //   186: aload_2
    //   187: astore_1
    //   188: aload 5
    //   190: astore_2
    //   191: goto +14 -> 205
    //   194: astore_1
    //   195: aload 5
    //   197: astore_2
    //   198: goto +31 -> 229
    //   201: astore_2
    //   202: aload 6
    //   204: astore_1
    //   205: aload_1
    //   206: astore 5
    //   208: aload_2
    //   209: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   212: aload_1
    //   213: ifnull +14 -> 227
    //   216: aload_1
    //   217: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   220: iconst_0
    //   221: ireturn
    //   222: astore_1
    //   223: aload_1
    //   224: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   227: iconst_0
    //   228: ireturn
    //   229: aload_2
    //   230: ifnull +15 -> 245
    //   233: aload_2
    //   234: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   237: goto +8 -> 245
    //   240: astore_2
    //   241: aload_2
    //   242: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   245: goto +5 -> 250
    //   248: aload_1
    //   249: athrow
    //   250: goto -2 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	QimSegmentMergeUtil
    //   0	253	1	paramList	List<String>
    //   0	253	2	paramString	String
    //   23	84	3	i	int
    //   68	13	4	j	int
    //   4	85	5	localRandomAccessFile	java.io.RandomAccessFile
    //   96	50	5	localException1	Exception
    //   153	3	5	localException2	Exception
    //   184	12	5	localException3	Exception
    //   206	1	5	localList	List<String>
    //   1	202	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   88	93	96	java/lang/Exception
    //   61	70	110	finally
    //   76	85	110	finally
    //   115	119	110	finally
    //   61	70	114	java/lang/Exception
    //   76	85	114	java/lang/Exception
    //   119	124	127	java/lang/Exception
    //   132	136	138	java/io/IOException
    //   145	150	153	java/lang/Exception
    //   166	170	173	java/io/IOException
    //   24	61	180	finally
    //   88	93	180	finally
    //   98	103	180	finally
    //   119	124	180	finally
    //   128	132	180	finally
    //   145	150	180	finally
    //   155	160	180	finally
    //   160	162	180	finally
    //   162	166	180	finally
    //   24	61	184	java/lang/Exception
    //   98	103	184	java/lang/Exception
    //   128	132	184	java/lang/Exception
    //   155	160	184	java/lang/Exception
    //   160	162	184	java/lang/Exception
    //   162	166	184	java/lang/Exception
    //   6	22	194	finally
    //   208	212	194	finally
    //   6	22	201	java/lang/Exception
    //   216	220	222	java/io/IOException
    //   233	237	240	java/io/IOException
  }
  
  public boolean a(List<String> paramList, String paramString, int paramInt1, int paramInt2, MediaFormat paramMediaFormat)
  {
    int i;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      i = 0;
    }
    else
    {
      localObject4 = new MediaMetadataUtils.MetaData();
      try
      {
        i = MediaMetadataUtils.a((String)paramList.get(0), (MediaMetadataUtils.MetaData)localObject4);
        paramInt2 = localObject4.a[2];
        paramInt1 = paramInt2;
        if (i >= 0) {
          break label141;
        }
        paramInt1 = paramInt2;
        try
        {
          if (!QLog.isColorLevel()) {
            break label141;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("MediaMetadataUtils.getRotationDegree error: ");
          localStringBuilder.append(i);
          QLog.e("QimSegmentMergeUtil", 2, localStringBuilder.toString());
          return false;
        }
        catch (Exception localException1)
        {
          paramInt1 = paramInt2;
        }
        if (!QLog.isColorLevel()) {
          break label141;
        }
      }
      catch (Exception localException2)
      {
        paramInt1 = 0;
      }
      QLog.e("QimSegmentMergeUtil", 2, localException2.getMessage(), localException2);
      return false;
      label141:
      j = localObject4.a[0];
      paramInt2 = localObject4.a[1];
      i = paramInt1;
      paramInt1 = j;
    }
    if (QQAudioHelper.d()) {
      return ((IHwVideoMerge)QRoute.api(IHwVideoMerge.class)).ffmpegMergeMultiVideo(paramList, paramString, i);
    }
    Object localObject4 = new ArrayList();
    int j = 0;
    while (j < paramList.size())
    {
      ((List)localObject4).add(new DecodeConfig((String)paramList.get(j), 0, false, true));
      j += 1;
    }
    Object localObject5 = new EncodeConfig(paramString, paramInt1, paramInt2, CodecParam.mMaxrate, 1, false, i);
    ((EncodeConfig)localObject5).b = true;
    for (;;)
    {
      try
      {
        paramList = ByteBuffer.allocate(1048576);
        paramString = new MediaCodec.BufferInfo();
        Object localObject3 = new File(((EncodeConfig)localObject5).a);
        if (!((File)localObject3).exists()) {
          FileUtils.createFileIfNotExits(((File)localObject3).getAbsolutePath());
        }
        localObject3 = new MediaMuxer(((EncodeConfig)localObject5).a, 0);
        ((MediaMuxer)localObject3).setOrientationHint(((EncodeConfig)localObject5).g);
        i = ((MediaMuxer)localObject3).addTrack(paramMediaFormat);
        ((MediaMuxer)localObject3).start();
        localObject4 = ((List)localObject4).iterator();
        long l1 = 0L;
        paramInt1 = 1;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (DecodeConfig)((Iterator)localObject4).next();
          paramMediaFormat = new MediaExtractor();
          try
          {
            paramMediaFormat.setDataSource(((DecodeConfig)localObject5).inputFilePath);
            paramInt2 = 0;
            if (paramInt2 >= paramMediaFormat.getTrackCount()) {
              break label630;
            }
            MediaFormat localMediaFormat = paramMediaFormat.getTrackFormat(paramInt2);
            if (!localMediaFormat.getString("mime").startsWith("video/")) {
              break label621;
            }
            paramMediaFormat.selectTrack(paramInt2);
            localMediaFormat.setInteger("rotation-degrees", ((DecodeConfig)localObject5).rotation);
          }
          catch (IOException paramList)
          {
            Object localObject1;
            Object localObject2;
            paramMediaFormat.release();
            ((MediaMuxer)localObject3).release();
            paramList.printStackTrace();
            return false;
          }
          paramList.clear();
          paramInt2 = paramMediaFormat.readSampleData(paramList, 0);
          if (paramInt2 < 0)
          {
            l1 = localObject1 + localObject2;
            paramMediaFormat.release();
            continue;
          }
          l2 = paramMediaFormat.getSampleTime() + l1;
          if (l2 > 0L) {
            l3 = l2 - paramString.presentationTimeUs;
          }
          paramString.offset = 0;
          paramString.size = paramInt2;
          paramString.flags = paramInt1;
          paramString.presentationTimeUs = l2;
          ((MediaMuxer)localObject3).writeSampleData(i, paramList, paramString);
          paramMediaFormat.advance();
          paramInt1 = 0;
          continue;
        }
        else
        {
          ((MediaMuxer)localObject3).stop();
          ((MediaMuxer)localObject3).release();
          return true;
        }
      }
      catch (Exception paramList)
      {
        QLog.e("QimSegmentMergeUtil", 2, paramList, new Object[0]);
        return false;
      }
      label621:
      paramInt2 += 1;
      continue;
      label630:
      long l2 = 0L;
      long l3 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.QimSegmentMergeUtil
 * JD-Core Version:    0.7.0.1
 */