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
    AVCDecoder localAVCDecoder = this.mDecoder;
    if (localAVCDecoder != null) {
      localAVCDecoder.native_destroy();
    }
  }
  
  private void releaseExtractor()
  {
    MediaExtractor localMediaExtractor = this.mExtractor;
    if (localMediaExtractor != null)
    {
      localMediaExtractor.release();
      this.mExtractor = null;
    }
  }
  
  public int createDecoder(String paramString, Object paramObject)
  {
    int k = -1;
    label416:
    for (;;)
    {
      try
      {
        this.mExtractor = new MediaExtractor();
        this.mExtractor.setDataSource(paramString);
        int i = 0;
        try
        {
          int m = this.mExtractor.getTrackCount();
          int j = k;
          if (i < m)
          {
            if (!this.mExtractor.getTrackFormat(i).getString("mime").startsWith("video/")) {
              break label416;
            }
            this.mExtractor.selectTrack(i);
            j = i;
          }
          this.mFormat = this.mExtractor.getTrackFormat(j);
          if (this.mFormat != null) {
            this.mMime = this.mFormat.getString("mime");
          }
          this.mExtractor.selectTrack(j);
          if ((this.mFormat != null) && (this.mMime.startsWith("video/")))
          {
            paramString = this.mDecodeListener;
            if (paramString != null) {
              paramString.onVideoFormat(this.mFormat);
            }
            i = this.mFormat.getInteger("width");
            j = this.mFormat.getInteger("height");
            paramString = this.mDecodeListener;
            if (paramString != null) {
              paramString.onVideoSize(i, j);
            }
            this.mDecoder = new AVCDecoder();
            if (this.mDecoder.native_create(i, j, null) != 0)
            {
              paramString = this.mDecodeListener;
              if (paramString != null) {
                paramString.onVideoDecodeError(-5);
              }
              releaseCodec();
              releaseExtractor();
              return -5;
            }
            paramString = this.mDecodeListener;
            if (paramString != null) {
              paramString.onVideoDecoderCreated(false);
            }
            return 1;
          }
          LogUtils.e("MediaPESdk|SoftwareFileDecoder", "error: not a video type file, end !");
          paramString = this.mDecodeListener;
          if (paramString != null) {
            paramString.onVideoDecodeError(-3);
          }
          releaseExtractor();
          return -3;
        }
        catch (Exception paramString)
        {
          paramObject = new StringBuilder();
          paramObject.append("error read video file and info ");
          paramObject.append(paramString.getMessage());
          LogUtils.e("MediaPESdk|SoftwareFileDecoder", paramObject.toString());
          paramString = this.mDecodeListener;
          if (paramString != null) {
            paramString.onVideoDecodeError(-2);
          }
          releaseExtractor();
          return -2;
        }
        i += 1;
      }
      catch (Exception paramString)
      {
        paramObject = new StringBuilder();
        paramObject.append(" error mExtractor.setDataSource file path ");
        paramObject.append(paramString.getMessage());
        LogUtils.e("MediaPESdk|SoftwareFileDecoder", paramObject.toString());
        paramString = this.mDecodeListener;
        if (paramString != null) {
          paramString.onVideoDecodeError(-1);
        }
        releaseExtractor();
        return -1;
      }
    }
  }
  
  public void decode()
  {
    Object localObject3 = this.mFormat.getByteBuffer("csd-0");
    ByteBuffer localByteBuffer = this.mFormat.getByteBuffer("csd-1");
    int i = this.mFormat.getInteger("width");
    int j = this.mFormat.getInteger("height");
    int n = j * i;
    Object localObject1 = ByteBuffer.allocateDirect(n);
    VideoPicture localVideoPicture = new VideoPicture(i, j, Bitmap.Config.ARGB_8888);
    if ((localObject3 != null) && (((ByteBuffer)localObject3).array().length > 0)) {
      this.mDecoder.native_decode(((ByteBuffer)localObject3).array(), 0, ((ByteBuffer)localObject3).array().length, localVideoPicture);
    }
    if ((localByteBuffer != null) && (localByteBuffer.array().length > 0)) {
      this.mDecoder.native_decode(localByteBuffer.array(), 0, localByteBuffer.array().length, localVideoPicture);
    }
    localObject3 = this.mDecodeListener;
    if (localObject3 != null) {
      ((VideoFileDecodeListener)localObject3).onVideoDecodeStart();
    }
    this.mFirstFrameSysTime = 0L;
    this.mFirstFrameTimeUS = 0L;
    try
    {
      this.mStart = true;
      j = 0;
      int m;
      for (i = 1; j == 0; i = m)
      {
        if (!this.mStart)
        {
          LogUtils.d("MediaPESdk|SoftwareFileDecoder", "decode need stop");
          break;
        }
        ((ByteBuffer)localObject1).position(0);
        int k = this.mExtractor.readSampleData((ByteBuffer)localObject1, 0);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("sampleSize = ");
        ((StringBuilder)localObject3).append(k);
        ((StringBuilder)localObject3).append(" buffer size = ");
        ((StringBuilder)localObject3).append(n);
        LogUtils.d("MediaPESdk|SoftwareFileDecoder", ((StringBuilder)localObject3).toString());
        if (k < 0)
        {
          LogUtils.d("MediaPESdk|SoftwareFileDecoder", "decode input EOS. End");
          if (this.mLoop)
          {
            this.mFirstFrameSysTime = 0L;
            this.mFirstFrameTimeUS = 0L;
            this.mPresentationTimeUs = 0L;
            this.mExtractor.seekTo(0L, 1);
            k = j;
            m = i;
          }
          else
          {
            k = 1;
            m = i;
          }
        }
        else
        {
          this.mSamplePresentationTimeUs = this.mExtractor.getSampleTime();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("mSample time = ");
          ((StringBuilder)localObject3).append(this.mSamplePresentationTimeUs / 1000L);
          LogUtils.e("MediaPESdk|SoftwareFileDecoder", ((StringBuilder)localObject3).toString());
          ((ByteBuffer)localObject1).position(0);
          localObject3 = new byte[k];
          ((ByteBuffer)localObject1).get((byte[])localObject3, 0, k);
          localVideoPicture.clear();
          if (this.mDecoder.native_decode((byte[])localObject3, 0, k, localVideoPicture) < 0)
          {
            LogUtils.e("MediaPESdk|SoftwareFileDecoder", "decoding error, not get valid frame");
            localObject3 = this.mDecodeListener;
            if (localObject3 != null) {
              ((VideoFileDecodeListener)localObject3).onVideoDecodeError(-101);
            }
            this.mStart = false;
            m = 0;
            k = j;
          }
          else
          {
            LogUtils.d("MediaPESdk|SoftwareFileDecoder", "mDecoder success");
            if (this.mFirstFrameSysTime == 0L)
            {
              this.mFirstFrameSysTime = System.currentTimeMillis();
              this.mFirstFrameTimeUS = this.mSamplePresentationTimeUs;
            }
            else
            {
              l1 = System.currentTimeMillis() - this.mFirstFrameSysTime;
              long l2 = (this.mSamplePresentationTimeUs - this.mFirstFrameTimeUS) / 1000L;
              if (l1 < l2) {
                try
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("this frame need sleep time =");
                  l1 = l2 - l1;
                  ((StringBuilder)localObject3).append(l1);
                  LogUtils.d("MediaPESdk|SoftwareFileDecoder", ((StringBuilder)localObject3).toString());
                  Thread.sleep(l1);
                }
                catch (InterruptedException localInterruptedException)
                {
                  localInterruptedException.printStackTrace();
                }
              }
            }
            long l1 = this.mSamplePresentationTimeUs;
            this.mPresentationTimeUs = l1;
            VideoFileDecodeListener localVideoFileDecodeListener = this.mDecodeListener;
            if (localVideoFileDecodeListener != null) {
              localVideoFileDecodeListener.onVideoDecodeFrame(l1, localVideoPicture.pixels);
            }
            k = j;
            m = i;
            if (j == 0)
            {
              this.mExtractor.advance();
              m = i;
              k = j;
            }
          }
        }
        j = k;
      }
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
      if (i != 0)
      {
        localObject1 = this.mDecodeListener;
        if (localObject1 != null) {
          ((VideoFileDecodeListener)localObject1).onVideoDecodeEnd();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.codec.SoftwareFileDecoder
 * JD-Core Version:    0.7.0.1
 */