package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.qphone.base.util.QLog;

class EditVideoPartManager$12
  implements Runnable
{
  EditVideoPartManager$12(EditVideoPartManager paramEditVideoPartManager) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.a();
    if (localBitmap != null) {
      try
      {
        if (EditVideoPartManager.a(this.this$0.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c, 64))
        {
          if (EditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecRendererGPUBitmapImageRender == null) {
            EditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecRendererGPUBitmapImageRender = new GPUBitmapImageRender();
          }
          EditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecRendererGPUBitmapImageRender.c(localBitmap.getWidth(), localBitmap.getHeight());
          return;
        }
      }
      catch (Exception localException)
      {
        EditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecRendererGPUBitmapImageRender = null;
        QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 1, "artImageRender init error, ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.12
 * JD-Core Version:    0.7.0.1
 */