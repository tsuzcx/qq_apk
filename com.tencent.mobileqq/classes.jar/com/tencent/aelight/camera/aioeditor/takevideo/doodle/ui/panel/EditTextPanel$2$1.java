package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class EditTextPanel$2$1
  implements Runnable
{
  EditTextPanel$2$1(EditTextPanel.2 param2, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel$2.a.a != null)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel$2.a.a.a == null) {
        return;
      }
      int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel$2.a.a.a.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel$2.a.a.a.getChildAt(i);
        localObject = (EditTextEffectView.EditTextHolder)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel$2.a.a.getChildViewHolder((View)localObject);
        if ((((EditTextEffectView.EditTextHolder)localObject).a.isContainsResUrl(this.jdField_a_of_type_JavaLangString)) && (((EditTextEffectView.EditTextHolder)localObject).a.text_id == this.jdField_a_of_type_Int)) {
          ThreadManager.getUIHandler().post(new EditTextPanel.2.1.1(this, (EditTextEffectView.EditTextHolder)localObject));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.2.1
 * JD-Core Version:    0.7.0.1
 */