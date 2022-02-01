package com.tencent.biz.videostory.video;

import android.os.Build.VERSION;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;

public class FrameVideoHelper
{
  private MediaCodecGLFrameFetcher a;
  private ArrayList<FrameVideoHelper.FrameBuffer> b = new ArrayList();
  private final String c;
  private final long d;
  private final long e;
  private long f;
  private long g;
  private long h = ((Long)VSConfigManager.a().a("SmartCutPicWidth", Long.valueOf(224L))).longValue();
  private long i = ((Long)VSConfigManager.a().a("SmartCutPicCount", Long.valueOf(10L))).longValue();
  private long j = ((Long)VSConfigManager.a().a("SmartCutPicQuality_And", Long.valueOf(80L))).longValue();
  private long k = ((Long)VSConfigManager.a().a("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
  private long l;
  private long m = 0L;
  private long n;
  private volatile boolean o;
  
  public FrameVideoHelper(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    this.c = paramString;
    this.f = paramInt1;
    this.g = paramInt2;
    this.d = paramLong;
    long l1 = 60000L;
    if (paramLong > 60000L) {
      paramLong = l1;
    }
    this.e = paramLong;
  }
  
  private long a(long paramLong)
  {
    long l2 = Math.min(paramLong + this.e, this.d);
    long l3 = this.i;
    long l1 = l2 / l3;
    paramLong = l1;
    if (l1 > 1000L) {
      paramLong = (l2 - 1000L) / l3;
    }
    return paramLong;
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((MediaCodecGLFrameFetcher)localObject).a();
    }
    localObject = this.b;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
  }
  
  public void a(long paramLong, FrameVideoHelper.GetFrameByteArrayListener paramGetFrameByteArrayListener)
  {
    AEQLog.b("AEEditorMusicHelper", "FrameVideoHelper.start(), BEGIN");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FrameVideoHelper.start(), videoStart=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", videoDuration=");
    localStringBuilder.append(this.d);
    AEQLog.b("AEEditorMusicHelper", localStringBuilder.toString());
    if (this.o) {
      return;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      if (paramGetFrameByteArrayListener != null) {
        paramGetFrameByteArrayListener.a(false, null, -1L);
      }
      return;
    }
    this.m = 0L;
    this.n = 0L;
    this.l = System.currentTimeMillis();
    this.o = true;
    ThreadManager.executeOnFileThread(new FrameVideoHelper.1(this, paramLong, paramGetFrameByteArrayListener));
    AEQLog.b("AEEditorMusicHelper", "FrameVideoHelper.start(), END");
  }
  
  public void a(FrameVideoHelper.GetFrameByteArrayListener paramGetFrameByteArrayListener)
  {
    a(0L, paramGetFrameByteArrayListener);
  }
  
  public long b()
  {
    return this.m;
  }
  
  public long c()
  {
    return this.n / 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.video.FrameVideoHelper
 * JD-Core Version:    0.7.0.1
 */