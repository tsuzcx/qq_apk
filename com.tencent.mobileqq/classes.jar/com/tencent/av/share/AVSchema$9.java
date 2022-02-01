package com.tencent.av.share;

import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.qphone.base.util.QLog;

class AVSchema$9
  implements ChatActivityUtils.StartVideoListener
{
  AVSchema$9(AVSchema paramAVSchema, long paramLong) {}
  
  public void a()
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvShareAVSchema.a, 1, "joinVideoChat.onCancel, isDetached[" + this.jdField_a_of_type_ComTencentAvShareAVSchema.isDetached() + "], seq[" + this.jdField_a_of_type_Long + "]");
    this.jdField_a_of_type_ComTencentAvShareAVSchema.b();
  }
  
  public void b()
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvShareAVSchema.a, 1, "joinVideoChat.onBeforeStartActivity, isDetached[" + this.jdField_a_of_type_ComTencentAvShareAVSchema.isDetached() + "], seq[" + this.jdField_a_of_type_Long + "]");
  }
  
  public void c()
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvShareAVSchema.a, 1, "joinVideoChat.onAfterStartActivity, isDetached[" + this.jdField_a_of_type_ComTencentAvShareAVSchema.isDetached() + "], seq[" + this.jdField_a_of_type_Long + "]");
    this.jdField_a_of_type_ComTencentAvShareAVSchema.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.9
 * JD-Core Version:    0.7.0.1
 */