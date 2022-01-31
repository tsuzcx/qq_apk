package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class MultiVideoCtrlLayerUI4Discussion$7
  implements Runnable
{
  MultiVideoCtrlLayerUI4Discussion$7(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    String str = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(this.a), String.valueOf(this.this$0.b), this.this$0.e);
    this.this$0.jdField_a_of_type_JavaUtilMap.put(String.valueOf(this.a), str);
    QLog.d(this.this$0.d, 1, "refreshUI --> user name mark name=" + str + ", mApp.getCurrentAccountUin()=" + String.valueOf(this.a) + ", mMapNickNameCache.size()=" + this.this$0.jdField_a_of_type_JavaUtilMap.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.7
 * JD-Core Version:    0.7.0.1
 */