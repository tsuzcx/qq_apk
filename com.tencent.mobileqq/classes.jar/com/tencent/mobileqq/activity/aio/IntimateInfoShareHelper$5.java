package com.tencent.mobileqq.activity.aio;

import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class IntimateInfoShareHelper$5
  implements QQPermissionCallback
{
  IntimateInfoShareHelper$5(IntimateInfoShareHelper paramIntimateInfoShareHelper, Bitmap paramBitmap) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(IntimateInfoShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoShareHelper.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.5
 * JD-Core Version:    0.7.0.1
 */