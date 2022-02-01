package com.tencent.ilivesdk.playview.codec;

import android.graphics.Bitmap.Config;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.ilivesdk.utils.LogUtils;
import com.tencent.qt.base.video.AVCDecoder;
import com.tencent.qt.base.video.VideoPicture;
import java.nio.ByteBuffer;

public class SoftwareFileDecoder
  implements VideoFileDecoder
{
  static final String TAG = "MediaPESdk|SoftwareFileDecoder";
  private VideoFileDecodeListener mDecodeListener = null;
  private AVCDecoder mDecoder = null;
  private MediaExtractor mExtractor = null;
  private long mFirstFrameSysTime = 0L;
  private long mFirstFrameTimeUS = 0L;
  private MediaFormat mFormat = null;
  private boolean mLoop = false;
  private String mMime = null;
  private long mPresentationTimeUs = 0L;
  private long mSamplePresentationTimeUs = 0L;
  private boolean mStart = false;
  
  public SoftwareFileDecoder() {}
  
  public SoftwareFileDecoder(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
  }
  
  private void releaseCodec()
  {
    if (this.mDecoder != null) {
      this.mDecoder.native_destroy();
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
    //   4: new 64	android/media/MediaExtractor
    //   7: dup
    //   8: invokespecial 72	android/media/MediaExtractor:<init>	()V
    //   11: putfield 33	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   14: aload_0
    //   15: getfield 33	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   18: aload_1
    //   19: invokevirtual 76	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   22: iconst_0
    //   23: istore_3
    //   24: iload 5
    //   26: istore 4
    //   28: iload_3
    //   29: aload_0
    //   30: getfield 33	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   33: invokevirtual 80	android/media/MediaExtractor:getTrackCount	()I
    //   36: if_icmpge +35 -> 71
    //   39: aload_0
    //   40: getfield 33	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   43: iload_3
    //   44: invokevirtual 84	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   47: ldc 86
    //   49: invokevirtual 92	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: ldc 94
    //   54: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   57: ifeq +158 -> 215
    //   60: aload_0
    //   61: getfield 33	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   64: iload_3
    //   65: invokevirtual 104	android/media/MediaExtractor:selectTrack	(I)V
    //   68: iload_3
    //   69: istore 4
    //   71: aload_0
    //   72: aload_0
    //   73: getfield 33	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   76: iload 4
    //   78: invokevirtual 84	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   81: putfield 35	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   84: aload_0
    //   85: getfield 35	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   88: ifnull +16 -> 104
    //   91: aload_0
    //   92: aload_0
    //   93: getfield 35	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   96: ldc 86
    //   98: invokevirtual 92	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: putfield 37	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mMime	Ljava/lang/String;
    //   104: aload_0
    //   105: getfield 33	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mExtractor	Landroid/media/MediaExtractor;
    //   108: iload 4
    //   110: invokevirtual 104	android/media/MediaExtractor:selectTrack	(I)V
    //   113: aload_0
    //   114: getfield 35	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   117: ifnull +15 -> 132
    //   120: aload_0
    //   121: getfield 37	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mMime	Ljava/lang/String;
    //   124: ldc 94
    //   126: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   129: ifne +146 -> 275
    //   132: ldc 10
    //   134: ldc 106
    //   136: invokestatic 112	com/tencent/ilivesdk/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: getfield 53	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   143: ifnull +14 -> 157
    //   146: aload_0
    //   147: getfield 53	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   150: bipush 253
    //   152: invokeinterface 117 2 0
    //   157: aload_0
    //   158: invokespecial 119	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:releaseExtractor	()V
    //   161: bipush 253
    //   163: ireturn
    //   164: astore_1
    //   165: ldc 10
    //   167: new 121	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   174: ldc 124
    //   176: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_1
    //   180: invokevirtual 132	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   183: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 112	com/tencent/ilivesdk/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_0
    //   193: getfield 53	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   196: ifnull +13 -> 209
    //   199: aload_0
    //   200: getfield 53	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   203: iconst_m1
    //   204: invokeinterface 117 2 0
    //   209: aload_0
    //   210: invokespecial 119	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:releaseExtractor	()V
    //   213: iconst_m1
    //   214: ireturn
    //   215: iload_3
    //   216: iconst_1
    //   217: iadd
    //   218: istore_3
    //   219: goto -195 -> 24
    //   222: astore_1
    //   223: ldc 10
    //   225: new 121	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   232: ldc 137
    //   234: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_1
    //   238: invokevirtual 132	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   241: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 112	com/tencent/ilivesdk/utils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload_0
    //   251: getfield 53	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   254: ifnull +14 -> 268
    //   257: aload_0
    //   258: getfield 53	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   261: bipush 254
    //   263: invokeinterface 117 2 0
    //   268: aload_0
    //   269: invokespecial 119	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:releaseExtractor	()V
    //   272: bipush 254
    //   274: ireturn
    //   275: aload_0
    //   276: getfield 53	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   279: ifnull +16 -> 295
    //   282: aload_0
    //   283: getfield 53	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   286: aload_0
    //   287: getfield 35	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   290: invokeinterface 141 2 0
    //   295: aload_0
    //   296: getfield 35	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   299: ldc 143
    //   301: invokevirtual 147	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   304: istore_3
    //   305: aload_0
    //   306: getfield 35	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mFormat	Landroid/media/MediaFormat;
    //   309: ldc 149
    //   311: invokevirtual 147	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   314: istore 4
    //   316: aload_0
    //   317: getfield 53	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   320: ifnull +15 -> 335
    //   323: aload_0
    //   324: getfield 53	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   327: iload_3
    //   328: iload 4
    //   330: invokeinterface 153 3 0
    //   335: aload_0
    //   336: new 58	com/tencent/qt/base/video/AVCDecoder
    //   339: dup
    //   340: invokespecial 154	com/tencent/qt/base/video/AVCDecoder:<init>	()V
    //   343: putfield 47	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecoder	Lcom/tencent/qt/base/video/AVCDecoder;
    //   346: aload_0
    //   347: getfield 47	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecoder	Lcom/tencent/qt/base/video/AVCDecoder;
    //   350: iload_3
    //   351: iload 4
    //   353: aconst_null
    //   354: invokevirtual 158	com/tencent/qt/base/video/AVCDecoder:native_create	(IILjava/lang/Object;)I
    //   357: ifeq +32 -> 389
    //   360: aload_0
    //   361: getfield 53	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   364: ifnull +14 -> 378
    //   367: aload_0
    //   368: getfield 53	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   371: bipush 251
    //   373: invokeinterface 117 2 0
    //   378: aload_0
    //   379: invokespecial 160	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:releaseCodec	()V
    //   382: aload_0
    //   383: invokespecial 119	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:releaseExtractor	()V
    //   386: bipush 251
    //   388: ireturn
    //   389: aload_0
    //   390: getfield 53	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   393: ifnull +13 -> 406
    //   396: aload_0
    //   397: getfield 53	com/tencent/ilivesdk/playview/codec/SoftwareFileDecoder:mDecodeListener	Lcom/tencent/ilivesdk/playview/codec/VideoFileDecodeListener;
    //   400: iconst_0
    //   401: invokeinterface 163 2 0
    //   406: iconst_1
    //   407: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	this	SoftwareFileDecoder
    //   0	408	1	paramString	String
    //   0	408	2	paramObject	Object
    //   23	328	3	i	int
    //   26	326	4	j	int
    //   1	24	5	k	int
    // Exception table:
    //   from	to	target	type
    //   3	22	164	java/lang/Exception
    //   28	68	222	java/lang/Exception
    //   71	104	222	java/lang/Exception
    //   104	113	222	java/lang/Exception
  }
  
  public void decode()
  {
    Object localObject = this.mFormat.getByteBuffer("csd-0");
    ByteBuffer localByteBuffer3 = this.mFormat.getByteBuffer("csd-1");
    int n = this.mFormat.getInteger("width");
    int i1 = this.mFormat.getInteger("height");
    ByteBuffer localByteBuffer1 = ByteBuffer.allocateDirect(i1 * n);
    VideoPicture localVideoPicture = new VideoPicture(n, i1, Bitmap.Config.ARGB_8888);
    if ((localObject != null) && (((ByteBuffer)localObject).array().length > 0)) {
      this.mDecoder.native_decode(((ByteBuffer)localObject).array(), 0, ((ByteBuffer)localObject).array().length, localVideoPicture);
    }
    if ((localByteBuffer3 != null) && (localByteBuffer3.array().length > 0)) {
      this.mDecoder.native_decode(localByteBuffer3.array(), 0, localByteBuffer3.array().length, localVideoPicture);
    }
    int j = 0;
    if (this.mDecodeListener != null) {
      this.mDecodeListener.onVideoDecodeStart();
    }
    int i = 0;
    this.mFirstFrameSysTime = 0L;
    this.mFirstFrameTimeUS = 0L;
    for (;;)
    {
      int k;
      try
      {
        this.mStart = true;
        k = 1;
        if (j == 0)
        {
          if (!this.mStart) {
            LogUtils.d("MediaPESdk|SoftwareFileDecoder", "decode need stop");
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
          this.mSamplePresentationTimeUs = 0L;
          this.mPresentationTimeUs = 0L;
          this.mFirstFrameSysTime = 0L;
          this.mFirstFrameTimeUS = 0L;
          if ((k != 0) && (this.mDecodeListener != null)) {
            this.mDecodeListener.onVideoDecodeEnd();
          }
          return;
        }
      }
      finally {}
      localByteBuffer2.position(0);
      m = this.mExtractor.readSampleData(localByteBuffer2, 0);
      LogUtils.d("MediaPESdk|SoftwareFileDecoder", "sampleSize = " + m + " buffer size = " + i1 * n);
      if (m < 0)
      {
        LogUtils.d("MediaPESdk|SoftwareFileDecoder", "decode input EOS. End");
        if (this.mLoop)
        {
          this.mFirstFrameSysTime = 0L;
          this.mFirstFrameTimeUS = 0L;
          this.mPresentationTimeUs = 0L;
          this.mExtractor.seekTo(0L, 1);
        }
        else
        {
          j = 1;
        }
      }
      else
      {
        this.mSamplePresentationTimeUs = this.mExtractor.getSampleTime();
        LogUtils.e("MediaPESdk|SoftwareFileDecoder", "mSample time = " + this.mSamplePresentationTimeUs / 1000L);
        localByteBuffer2.position(0);
        localObject = new byte[m];
        localByteBuffer2.get((byte[])localObject, 0, m);
        localVideoPicture.clear();
        if (this.mDecoder.native_decode((byte[])localObject, 0, m, localVideoPicture) >= 0) {
          break;
        }
        LogUtils.e("MediaPESdk|SoftwareFileDecoder", "decoding error, not get valid frame");
        if (this.mDecodeListener != null) {
          this.mDecodeListener.onVideoDecodeError(-101);
        }
        this.mStart = false;
        k = 0;
      }
    }
    LogUtils.d("MediaPESdk|SoftwareFileDecoder", "mDecoder success");
    int m = i + 1;
    if (this.mFirstFrameSysTime == 0L)
    {
      this.mFirstFrameSysTime = System.currentTimeMillis();
      this.mFirstFrameTimeUS = this.mSamplePresentationTimeUs;
    }
    for (;;)
    {
      this.mPresentationTimeUs = this.mSamplePresentationTimeUs;
      if (this.mDecodeListener != null) {
        this.mDecodeListener.onVideoDecodeFrame(this.mSamplePresentationTimeUs, localVideoPicture.pixels);
      }
      i = m;
      if (j != 0) {
        break;
      }
      this.mExtractor.advance();
      i = m;
      break;
      long l1 = System.currentTimeMillis() - this.mFirstFrameSysTime;
      long l2 = (this.mSamplePresentationTimeUs - this.mFirstFrameTimeUS) / 1000L;
      if (l1 < l2) {
        try
        {
          LogUtils.d("MediaPESdk|SoftwareFileDecoder", "this frame need sleep time =" + (l2 - l1));
          Thread.sleep(l2 - l1);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
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
      if (this.mStart) {
        this.mStart = false;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.codec.SoftwareFileDecoder
 * JD-Core Version:    0.7.0.1
 */