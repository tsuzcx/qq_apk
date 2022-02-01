package com.tencent.biz.videostory.video;

import android.os.Build.VERSION;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;

public class FrameVideoHelper
{
  private final long jdField_a_of_type_Long;
  private MediaCodecGLFrameFetcher jdField_a_of_type_ComTencentBizVideostoryVideoMediaCodecGLFrameFetcher;
  private final String jdField_a_of_type_JavaLangString;
  private ArrayList<FrameVideoHelper.FrameBuffer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  private final long b;
  private long c;
  private long d;
  private long e = ((Long)VSConfigManager.a().a("SmartCutPicWidth", Long.valueOf(224L))).longValue();
  private long f = ((Long)VSConfigManager.a().a("SmartCutPicCount", Long.valueOf(10L))).longValue();
  private long g = ((Long)VSConfigManager.a().a("SmartCutPicQuality_And", Long.valueOf(80L))).longValue();
  private long h = ((Long)VSConfigManager.a().a("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
  private long i;
  private long j = 0L;
  private long k;
  
  public FrameVideoHelper(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt1;
    this.d = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
    long l = 60000L;
    if (paramLong > 60000L) {
      paramLong = l;
    }
    this.b = paramLong;
  }
  
  private long a(long paramLong)
  {
    long l2 = Math.min(paramLong + this.b, this.jdField_a_of_type_Long);
    long l3 = this.f;
    long l1 = l2 / l3;
    paramLong = l1;
    if (l1 > 1000L) {
      paramLong = (l2 - 1000L) / l3;
    }
    return paramLong;
  }
  
  public long a()
  {
    return this.j;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizVideostoryVideoMediaCodecGLFrameFetcher;
    if (localObject != null) {
      ((MediaCodecGLFrameFetcher)localObject).a();
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
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
    localStringBuilder.append(this.jdField_a_of_type_Long);
    AEQLog.b("AEEditorMusicHelper", localStringBuilder.toString());
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      if (paramGetFrameByteArrayListener != null) {
        paramGetFrameByteArrayListener.a(false, null, -1L);
      }
      return;
    }
    this.j = 0L;
    this.k = 0L;
    this.i = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.executeOnFileThread(new FrameVideoHelper.1(this, paramLong, paramGetFrameByteArrayListener));
    AEQLog.b("AEEditorMusicHelper", "FrameVideoHelper.start(), END");
  }
  
  public void a(FrameVideoHelper.GetFrameByteArrayListener paramGetFrameByteArrayListener)
  {
    a(0L, paramGetFrameByteArrayListener);
  }
  
  public long b()
  {
    return this.k / 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.video.FrameVideoHelper
 * JD-Core Version:    0.7.0.1
 */