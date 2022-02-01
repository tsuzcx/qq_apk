package com.tencent.mobileqq.activity.bless;

import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.OnUploadVideoListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;

class BlessResultActivity$2
  implements TroopBarShortVideoUploadUtil.OnUploadVideoListener
{
  BlessResultActivity$2(BlessResultActivity paramBlessResultActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadSuccess!");
    }
    BlessResultActivity localBlessResultActivity = this.a;
    localBlessResultActivity.jdField_a_of_type_Boolean = true;
    localBlessResultActivity.g = localBlessResultActivity.b(localBlessResultActivity.d);
    if (this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1003)) {
      this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1003);
    }
    this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1001);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadFail!");
    }
    if (this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1003)) {
      this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1003);
    }
    this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1003);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadStart!");
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadStop!");
    }
  }
  
  public void c(long paramLong)
  {
    long l = FileUtils.getFileSizes(this.a.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo.a);
    int i = (int)(100L * paramLong / l);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnUploadVideoListener onUploadProcess! rawLen = ");
      localStringBuilder.append(l);
      localStringBuilder.append(",offset = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",process = ");
      localStringBuilder.append(i);
      QLog.d("BlessResultActivity", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessResultActivity.2
 * JD-Core Version:    0.7.0.1
 */