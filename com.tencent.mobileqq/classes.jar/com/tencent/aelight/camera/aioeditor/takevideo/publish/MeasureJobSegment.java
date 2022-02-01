package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.os.SystemClock;
import com.tribe.async.async.JobSegment;

public abstract class MeasureJobSegment<IN, OUT>
  extends JobSegment<IN, OUT>
{
  private long a = 0L;
  private final String b;
  protected long e = 0L;
  
  public MeasureJobSegment()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.qqstory.publish.edit.");
    localStringBuilder.append(getClass().getSimpleName());
    this.b = localStringBuilder.toString();
  }
  
  protected void call(IN paramIN)
  {
    this.e = SystemClock.uptimeMillis();
    super.call(paramIN);
  }
  
  protected void notifyError(Error paramError)
  {
    this.a = SystemClock.uptimeMillis();
    super.notifyError(paramError);
  }
  
  protected void notifyResult(OUT paramOUT)
  {
    this.a = SystemClock.uptimeMillis();
    super.notifyResult(paramOUT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.MeasureJobSegment
 * JD-Core Version:    0.7.0.1
 */