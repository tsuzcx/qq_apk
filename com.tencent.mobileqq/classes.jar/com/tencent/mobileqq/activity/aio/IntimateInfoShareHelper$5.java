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
    DialogUtil.a(IntimateInfoShareHelper.e(this.b), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.b.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.5
 * JD-Core Version:    0.7.0.1
 */