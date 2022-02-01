package com.tencent.av.share;

import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.qphone.base.util.QLog;

class AVSchema$9
  implements ChatActivityUtils.StartVideoListener
{
  AVSchema$9(AVSchema paramAVSchema, long paramLong) {}
  
  public void a()
  {
    String str = AVSchema.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("joinVideoChat.onCancel, isDetached[");
    localStringBuilder.append(this.b.isDetached());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.b.d();
  }
  
  public void b()
  {
    String str = AVSchema.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("joinVideoChat.onBeforeStartActivity, isDetached[");
    localStringBuilder.append(this.b.isDetached());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
  }
  
  public void c()
  {
    String str = AVSchema.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("joinVideoChat.onAfterStartActivity, isDetached[");
    localStringBuilder.append(this.b.isDetached());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.b.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.9
 * JD-Core Version:    0.7.0.1
 */