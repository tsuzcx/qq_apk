package com.tencent.ilivesdk.playview.codec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.ilivesdk.utils.LogUtils;
import java.nio.ByteBuffer;

public class HardwareFileDecoder
  implements VideoFileDecoder
{
  static final String TAG = "Render|HardwareFileDecoder";
  private VideoFileDecodeListener mDecodeListener = null;
  private MediaExtractor mExtractor = null;
  private long mFirstFrameSysTime = 0L;
  private long mFirstFrameTimeUS = 0L;
  private MediaFormat mFormat = null;
  private ByteBuffer[] mInputBuffers = null;
  private boolean mLoop = false;
  private MediaCodec mMediaCodec = null;
  private String mMime = null;
  private ByteBuffer[] mOutputBuffers = null;
  private long mPresentationTimeUs = 0L;
  private long mSamplePresentationTimeUs = 0L;
  private boolean mStart = false;
  
  public HardwareFileDecoder() {}
  
  public HardwareFileDecoder(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
  }
  
  private void releaseCodec()
  {
    if (this.mMediaCodec != null) {}
    try
    {
      LogUtils.i("Render|HardwareFileDecoder", "mMediaCodec stop + release begin!" + hashCode());
      this.mMediaCodec.stop();
      this.mMediaCodec.release();
      this.mMediaCodec = null;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        LogUtils.e("Render|HardwareFileDecoder", "Failed to stop MediaCodec " + localIllegalStateException.getMessage());
      }
    }
  }
  
  private void releaseExtractor()
  {
    if (this.mExtractor != null)
    {
      this.mExtractor.release();
      this.mExtractor = null;
    }
  }
  
  /* Error */
  public int createDecoder(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 5
    //   3: aload_0
    //   4: new 110	android/media/MediaExtractor
    //   7: dup
    //   8: invokespecial 116	android/media/MediaExtractor:<init>	()V
    //   11: putfield 40	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   14: aload_0
    //   15: getfield 40	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   18: aload_1
    //   19: invokevirtual 120	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   22: iconst_0
    //   23: istore_3
    //   24: iload 5
    //   26: istore 4
    //   28: iload_3
    //   29: aload_0
    //   30: getfield 40	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   33: invokevirtual 123	android/media/MediaExtractor:getTrackCount	()I
    //   36: if_icmpge +35 -> 71
    //   39: aload_0
    //   40: getfield 40	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   43: iload_3
    //   44: invokevirtual 127	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   47: ldc 129
    //   49: invokevirtual 135	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: ldc 137
    //   54: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   57: ifeq +158 -> 215
    //   60: aload_0
    //   61: getfield 40	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   64: iload_3
    //   65: invokevirtual 147	android/media/MediaExtractor:selectTrack	(I)V
    //   68: iload_3
    //   69: istore 4
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 40	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   76: iload 4
    //   78: invokevirtual 127	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   81: putfield 38	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   84: aload_0
    //   85: getfield 38	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   88: ifnull +16 -> 104
    //   91: aload_0
    //   92: aload_0
    //   93: getfield 38	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   96: ldc 129
    //   98: invokevirtual 135	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: putfield 42	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMime	Ljava/lang/String;
    //   104: aload_0
    //   105: getfield 40	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   108: iload 4
    //   110: invokevirtual 147	android/media/MediaExtractor:selectTrack	(I)V
    //   113: aload_0
    //   114: getfield 38	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   117: ifnull +15 -> 132
    //   120: aload_0
    //   121: getfield 42	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMime	Ljava/lang/String;
    //   124: ldc 137
    //   126: invokevirtual 143	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   129: ifne +146 -> 275
    //   132: ldc 10
    //   134: ldc 149
    //   136: invokestatic 107	com/tencent/ilivesdk/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   143: ifnull +14 -> 157
    //   146: aload_0
    //   147: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   150: bipush 253
    //   152: invokeinterface 154 2 0
    //   157: aload_0
    //   158: invokespecial 156	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:releaseExtractor	()V
    //   161: bipush 253
    //   163: ireturn
    //   164: astore_1
    //   165: ldc 10
    //   167: new 67	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   174: ldc 158
    //   176: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_1
    //   180: invokevirtual 159	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   183: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 107	com/tencent/ilivesdk/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_0
    //   193: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   196: ifnull +13 -> 209
    //   199: aload_0
    //   200: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   203: iconst_m1
    //   204: invokeinterface 154 2 0
    //   209: aload_0
    //   210: invokespecial 156	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:releaseExtractor	()V
    //   213: iconst_m1
    //   214: ireturn
    //   215: iload_3
    //   216: iconst_1
    //   217: iadd
    //   218: istore_3
    //   219: goto -195 -> 24
    //   222: astore_1
    //   223: ldc 10
    //   225: new 67	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   232: ldc 161
    //   234: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_1
    //   238: invokevirtual 159	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   241: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 107	com/tencent/ilivesdk/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload_0
    //   251: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   254: ifnull +14 -> 268
    //   257: aload_0
    //   258: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   261: bipush 254
    //   263: invokeinterface 154 2 0
    //   268: aload_0
    //   269: invokespecial 156	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:releaseExtractor	()V
    //   272: bipush 254
    //   274: ireturn
    //   275: aload_0
    //   276: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   279: ifnull +16 -> 295
    //   282: aload_0
    //   283: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   286: aload_0
    //   287: getfield 38	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   290: invokeinterface 165 2 0
    //   295: aload_0
    //   296: getfield 38	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   299: ldc 167
    //   301: invokevirtual 171	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   304: istore_3
    //   305: aload_0
    //   306: getfield 38	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   309: ldc 173
    //   311: invokevirtual 171	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   314: istore 4
    //   316: aload_0
    //   317: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   320: ifnull +15 -> 335
    //   323: aload_0
    //   324: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   327: iload_3
    //   328: iload 4
    //   330: invokeinterface 177 3 0
    //   335: aload_0
    //   336: aload_0
    //   337: getfield 42	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMime	Ljava/lang/String;
    //   340: invokestatic 181	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   343: putfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   346: ldc 10
    //   348: new 67	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   355: ldc 183
    //   357: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload_0
    //   361: invokevirtual 78	java/lang/Object:hashCode	()I
    //   364: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 91	com/tencent/ilivesdk/utils/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload_0
    //   374: getfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   377: aload_0
    //   378: getfield 38	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   381: aload_2
    //   382: checkcast 185	android/view/Surface
    //   385: aconst_null
    //   386: iconst_0
    //   387: invokevirtual 189	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   390: ldc 10
    //   392: new 67	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   399: ldc 191
    //   401: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload_0
    //   405: invokevirtual 78	java/lang/Object:hashCode	()I
    //   408: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   411: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 91	com/tencent/ilivesdk/utils/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: aload_0
    //   418: getfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   421: invokevirtual 194	android/media/MediaCodec:start	()V
    //   424: aload_0
    //   425: aload_0
    //   426: getfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   429: invokevirtual 198	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   432: putfield 52	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mInputBuffers	[Ljava/nio/ByteBuffer;
    //   435: aload_0
    //   436: aload_0
    //   437: getfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   440: invokevirtual 201	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   443: putfield 54	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mOutputBuffers	[Ljava/nio/ByteBuffer;
    //   446: ldc 10
    //   448: ldc 203
    //   450: invokestatic 91	com/tencent/ilivesdk/utils/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   453: aload_0
    //   454: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   457: ifnull +13 -> 470
    //   460: aload_0
    //   461: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   464: iconst_1
    //   465: invokeinterface 206 2 0
    //   470: iconst_1
    //   471: ireturn
    //   472: astore_1
    //   473: aload_1
    //   474: invokevirtual 209	java/lang/Exception:printStackTrace	()V
    //   477: aload_0
    //   478: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   481: ifnull +14 -> 495
    //   484: aload_0
    //   485: getfield 56	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   488: bipush 251
    //   490: invokeinterface 154 2 0
    //   495: aload_0
    //   496: getfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   499: ifnull +42 -> 541
    //   502: ldc 10
    //   504: new 67	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   511: ldc 211
    //   513: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_0
    //   517: invokevirtual 78	java/lang/Object:hashCode	()I
    //   520: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 91	com/tencent/ilivesdk/utils/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   529: aload_0
    //   530: getfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   533: invokevirtual 99	android/media/MediaCodec:release	()V
    //   536: aload_0
    //   537: aconst_null
    //   538: putfield 36	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mMediaCodec	Landroid/media/MediaCodec;
    //   541: aload_0
    //   542: aconst_null
    //   543: putfield 52	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mInputBuffers	[Ljava/nio/ByteBuffer;
    //   546: aload_0
    //   547: aconst_null
    //   548: putfield 54	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:mOutputBuffers	[Ljava/nio/ByteBuffer;
    //   551: aload_0
    //   552: invokespecial 156	com/tencent/ilivesdk/playview/codec/HardwareFileDecoder:releaseExtractor	()V
    //   555: bipush 251
    //   557: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	558	0	this	HardwareFileDecoder
    //   0	558	1	paramString	String
    //   0	558	2	paramObject	Object
    //   23	305	3	i	int
    //   26	303	4	j	int
    //   1	24	5	k	int
    // Exception table:
    //   from	to	target	type
    //   3	22	164	java/lang/Exception
    //   28	68	222	java/lang/Exception
    //   71	104	222	java/lang/Exception
    //   104	113	222	java/lang/Exception
    //   335	453	472	java/lang/Exception
  }
  
  public void decode()
  {
    int j = 0;
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    if (this.mDecodeListener != null) {
      this.mDecodeListener.onVideoDecodeStart();
    }
    this.mFirstFrameSysTime = 0L;
    this.mFirstFrameTimeUS = 0L;
    int k;
    try
    {
      this.mStart = true;
      k = 1;
      i = 0;
      if (j == 0)
      {
        if (!this.mStart) {
          LogUtils.i("Render|HardwareFileDecoder", "decode stop!");
        }
      }
      else
      {
        if (this.mStart) {
          this.mStart = false;
        }
        releaseCodec();
        releaseExtractor();
        this.mMime = null;
        this.mFormat = null;
        this.mInputBuffers = null;
        this.mOutputBuffers = null;
        this.mSamplePresentationTimeUs = 0L;
        this.mPresentationTimeUs = 0L;
        this.mFirstFrameTimeUS = 0L;
        this.mFirstFrameSysTime = 0L;
        if ((k != 0) && (this.mDecodeListener != null)) {
          this.mDecodeListener.onVideoDecodeEnd();
        }
        return;
      }
    }
    finally {}
    if (i == 0) {}
    label406:
    label566:
    try
    {
      i1 = this.mMediaCodec.dequeueInputBuffer(1000L);
      if (i1 >= 0)
      {
        localObject2 = this.mInputBuffers[i1];
        m = this.mExtractor.readSampleData((ByteBuffer)localObject2, 0);
        if (m < 0)
        {
          LogUtils.d("Render|HardwareFileDecoder", "saw input EOS. Stopping playback");
          i = 1;
          m = 0;
        }
      }
    }
    catch (RuntimeException localRuntimeException2)
    {
      int i1;
      Object localObject2;
      int m;
      label215:
      long l1;
      label234:
      label509:
      break label509;
    }
    try
    {
      localObject2 = this.mMediaCodec;
      l1 = this.mSamplePresentationTimeUs;
      if (i == 0) {
        break label711;
      }
      n = 4;
    }
    catch (RuntimeException localRuntimeException3)
    {
      break label509;
      break label406;
      n = 0;
      break label234;
    }
    ((MediaCodec)localObject2).queueInputBuffer(i1, 0, m, l1, n);
    if (i == 0) {
      this.mExtractor.advance();
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          m = this.mMediaCodec.dequeueOutputBuffer(localBufferInfo, 1000L);
          if (m >= 0) {
            if (this.mFirstFrameSysTime == 0L)
            {
              this.mFirstFrameSysTime = System.currentTimeMillis();
              this.mFirstFrameTimeUS = localBufferInfo.presentationTimeUs;
              this.mPresentationTimeUs = localBufferInfo.presentationTimeUs;
              this.mMediaCodec.releaseOutputBuffer(m, true);
              if (this.mDecodeListener != null) {
                this.mDecodeListener.onVideoDecodeFrame(this.mPresentationTimeUs, null);
              }
              if ((localBufferInfo.flags & 0x4) == 0) {
                break label708;
              }
              LogUtils.d("Render|HardwareFileDecoder", "decode output EOS. End");
              boolean bool = this.mLoop;
              if (!bool) {
                break label566;
              }
            }
          }
        }
        catch (RuntimeException localRuntimeException1)
        {
          long l2;
          LogUtils.e("Render|HardwareFileDecoder", "decoding error:" + localRuntimeException1.getMessage());
          if (this.mDecodeListener != null) {
            this.mDecodeListener.onVideoDecodeError(-101);
          }
          this.mStart = false;
          k = 0;
        }
        try
        {
          this.mFirstFrameSysTime = 0L;
          this.mFirstFrameTimeUS = 0L;
          this.mPresentationTimeUs = 0L;
          this.mExtractor.seekTo(0L, 2);
          this.mMediaCodec.flush();
          i = 0;
        }
        catch (RuntimeException localRuntimeException4)
        {
          MediaFormat localMediaFormat;
          i = 0;
        }
      }
      this.mSamplePresentationTimeUs = this.mExtractor.getSampleTime();
      break label215;
      LogUtils.e("Render|HardwareFileDecoder", "inputBufIndex " + i1);
      continue;
      l1 = System.currentTimeMillis() - this.mFirstFrameSysTime;
      l2 = (localBufferInfo.presentationTimeUs - this.mFirstFrameTimeUS) / 1000L;
      if (l1 < l2)
      {
        try
        {
          Thread.sleep(l2 - l1);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        continue;
        break;
        j = 1;
        continue;
        if (m == -3)
        {
          this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
          LogUtils.d("Render|HardwareFileDecoder", "output buffers have changed.");
        }
        else if (m == -2)
        {
          localMediaFormat = this.mMediaCodec.getOutputFormat();
          LogUtils.d("Render|HardwareFileDecoder", "output mFormat has changed to " + localMediaFormat);
        }
        else if (m == -1)
        {
          LogUtils.d("Render|HardwareFileDecoder", "dequeueOutputBuffer timed out! MediaCodec.INFO_TRY_AGAIN_LATER ");
        }
        else
        {
          LogUtils.d("Render|HardwareFileDecoder", " dequeueOutputBuffer returned " + m);
        }
      }
    }
  }
  
  public long getCurPresentationTimeUs()
  {
    return this.mPresentationTimeUs;
  }
  
  public VideoFileDecodeListener getDecodeListener()
  {
    return this.mDecodeListener;
  }
  
  public void release()
  {
    releaseCodec();
    releaseExtractor();
  }
  
  public void setDecodeListener(VideoFileDecodeListener paramVideoFileDecodeListener)
  {
    this.mDecodeListener = paramVideoFileDecodeListener;
  }
  
  public void setLoopState(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
  }
  
  public void stop()
  {
    try
    {
      this.mStart = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.codec.HardwareFileDecoder
 * JD-Core Version:    0.7.0.1
 */