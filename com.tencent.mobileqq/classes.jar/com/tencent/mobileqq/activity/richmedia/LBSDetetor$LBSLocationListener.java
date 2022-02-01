package com.tencent.mobileqq.activity.richmedia;

import android.os.Handler;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class LBSDetetor$LBSLocationListener
  extends SosoInterfaceOnLocationListener
{
  private int jdField_a_of_type_Int = -1;
  
  public LBSDetetor$LBSLocationListener(LBSDetetor paramLBSDetetor, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, int paramInt2)
  {
    super(paramInt1, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      double d1 = paramSosoLbsInfo.mLocation.mLat02;
      double d2 = paramSosoLbsInfo.mLocation.mLon02;
      if (QLog.isColorLevel()) {
        QLog.d("LBSDetetor", 2, "onLocationUpdate() latitude=" + d1 + " longitude=" + d2);
      }
      LBSDetetor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaLBSDetetor, d1, d2, this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LBSDetetor", 2, "onLocationUpdate() error");
      }
    } while ((LBSDetetor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaLBSDetetor) == null) || (!LBSDetetor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaLBSDetetor).hasMessages(this.jdField_a_of_type_Int)));
    LBSDetetor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaLBSDetetor, false, null, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.LBSDetetor.LBSLocationListener
 * JD-Core Version:    0.7.0.1
 */