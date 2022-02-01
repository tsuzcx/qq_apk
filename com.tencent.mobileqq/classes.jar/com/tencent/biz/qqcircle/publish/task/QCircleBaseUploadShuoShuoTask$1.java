package com.tencent.biz.qqcircle.publish.task;

import com.tencent.qphone.base.util.QLog;

class QCircleBaseUploadShuoShuoTask$1
  implements Runnable
{
  QCircleBaseUploadShuoShuoTask$1(QCircleBaseUploadShuoShuoTask paramQCircleBaseUploadShuoShuoTask) {}
  
  public void run()
  {
    if (this.this$0.t != 11) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.C());
    localStringBuilder.append(", libavcodec download timeout, go to next step");
    QLog.w("[upload2_QZoneUploadShuoShuoTask]", 1, localStringBuilder.toString());
    if (this.this$0.bn_() != 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.this$0.C());
      localStringBuilder.append(", change state to running");
      QLog.i("[upload2_QZoneUploadShuoShuoTask]", 1, localStringBuilder.toString());
      this.this$0.a(1);
    }
    QCircleBaseUploadShuoShuoTask.a(this.this$0, true);
    this.this$0.u();
    QCircleBaseUploadShuoShuoTask.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.task.QCircleBaseUploadShuoShuoTask.1
 * JD-Core Version:    0.7.0.1
 */