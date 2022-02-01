package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.os.SystemClock;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.LayerListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.qphone.base.util.QLog;

class DoodleLayout$TextLayerListener
  implements TextLayer.LayerListener
{
  private DoodleLayout$TextLayerListener(DoodleLayout paramDoodleLayout) {}
  
  public void a(float paramFloat)
  {
    if (paramFloat >= 0.95F)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAnimate:");
        localStringBuilder.append(paramFloat);
        QLog.d("DoodleLayout", 2, localStringBuilder.toString());
      }
      if ((this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog != null) && (this.a.a() != null) && (this.a.a().a() != null)) {
        this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.a(this.a.a().a(), this.a.a().a().b());
      }
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem)
  {
    if (DoodleLayout.a(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "onClickInside mIsRecording");
      }
      return;
    }
    long l = SystemClock.uptimeMillis();
    if (l - this.a.jdField_a_of_type_Long > 500L)
    {
      DoodleLayout localDoodleLayout = this.a;
      localDoodleLayout.jdField_a_of_type_Long = l;
      localDoodleLayout.a(paramDynamicTextItem, paramDynamicTextItem.b(), 1);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.a.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public boolean a(TextLayer.TextItem paramTextItem)
  {
    if ((DoodleLayout.b(this.a)) && (!DoodleLayout.c(this.a))) {
      return false;
    }
    return this.a.a(paramTextItem, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.TextLayerListener
 * JD-Core Version:    0.7.0.1
 */