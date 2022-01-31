package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.app.BaseActivity;
import xbq;

class AIOImageProviderService$8
  implements Runnable
{
  AIOImageProviderService$8(AIOImageProviderService paramAIOImageProviderService, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      xbq.a(BaseActivity.sTopActivity.app, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d);
      return;
    }
    xbq.a(BaseActivity.sTopActivity, this.b, this.jdField_a_of_type_JavaLangString, this.c, xbq.a(this.jdField_a_of_type_Int), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.8
 * JD-Core Version:    0.7.0.1
 */