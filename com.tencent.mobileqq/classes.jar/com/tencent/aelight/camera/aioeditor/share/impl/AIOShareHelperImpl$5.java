package com.tencent.aelight.camera.aioeditor.share.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.aelight.camera.aioeditor.share.AIOShareObject;
import com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper.AIOWXShareListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AIOShareHelperImpl$5
  implements Runnable
{
  AIOShareHelperImpl$5(AIOShareHelperImpl paramAIOShareHelperImpl, AIOShareObject paramAIOShareObject, IAIOShareHelper.AIOWXShareListener paramAIOWXShareListener, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareAIOShareObject.a())
    {
      localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareAIOShareObject.a());
      if (localObject == null)
      {
        AEQLog.d("AIOShareHelperImpl", "share image to wx, but decode image fail");
        this.this$0.dismissLoading();
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareIAIOShareHelper$AIOWXShareListener;
        if (localObject != null) {
          ((IAIOShareHelper.AIOWXShareListener)localObject).a(false, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareAIOShareObject);
        }
        return;
      }
      ThreadManager.getUIHandler().post(new AIOShareHelperImpl.5.1(this, (Bitmap)localObject));
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareAIOShareObject.b())
    {
      localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShareAIOShareObject.b());
      ThreadManager.getUIHandler().post(new AIOShareHelperImpl.5.2(this, (Bitmap)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.5
 * JD-Core Version:    0.7.0.1
 */