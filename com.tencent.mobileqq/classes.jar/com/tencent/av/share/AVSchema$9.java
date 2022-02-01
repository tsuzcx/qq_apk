package com.tencent.av.share;

import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.qphone.base.util.QLog;

class AVSchema$9
  implements ChatActivityUtils.StartVideoListener
{
  AVSchema$9(AVSchema paramAVSchema, long paramLong) {}
  
  public void a()
  {
    String str = AVSchema.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("joinVideoChat.onCancel, isDetached[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvShareAVSchema.isDetached());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvShareAVSchema.b();
  }
  
  public void b()
  {
    String str = AVSchema.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("joinVideoChat.onBeforeStartActivity, isDetached[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvShareAVSchema.isDetached());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
  }
  
  public void c()
  {
    String str = AVSchema.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("joinVideoChat.onAfterStartActivity, isDetached[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvShareAVSchema.isDetached());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvShareAVSchema.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.9
 * JD-Core Version:    0.7.0.1
 */