package com.tencent.aelight.camera.aioeditor.share.impl;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.share.AIOShareObject;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class AIOShareHelperImpl$5$1
  implements Runnable
{
  AIOShareHelperImpl$5$1(AIOShareHelperImpl.5 param5, Bitmap paramBitmap) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareImplAIOShareHelperImpl$5.this$0.dismissLoading();
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareImplAIOShareHelperImpl$5.jdField_a_of_type_ComTencentAelightCameraAioeditorShareAIOShareObject.a();
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    int i;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareImplAIOShareHelperImpl$5.jdField_a_of_type_Int == 9) {
      i = 0;
    } else {
      i = 1;
    }
    localWXShareHelper.a(str, localBitmap, i, false, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareImplAIOShareHelperImpl$5.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.5.1
 * JD-Core Version:    0.7.0.1
 */