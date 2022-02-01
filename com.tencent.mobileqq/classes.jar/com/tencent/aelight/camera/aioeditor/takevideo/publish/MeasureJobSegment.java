package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.os.SystemClock;
import com.tribe.async.async.JobSegment;

public abstract class MeasureJobSegment<IN, OUT>
  extends JobSegment<IN, OUT>
{
  protected long a;
  private final String a;
  private long b = 0L;
  
  public MeasureJobSegment()
  {
    this.jdField_a_of_type_Long = 0L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.qqstory.publish.edit.");
    localStringBuilder.append(getClass().getSimpleName());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  protected void call(IN paramIN)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    super.call(paramIN);
  }
  
  protected void notifyError(Error paramError)
  {
    this.b = SystemClock.uptimeMillis();
    super.notifyError(paramError);
  }
  
  protected void notifyResult(OUT paramOUT)
  {
    this.b = SystemClock.uptimeMillis();
    super.notifyResult(paramOUT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.MeasureJobSegment
 * JD-Core Version:    0.7.0.1
 */