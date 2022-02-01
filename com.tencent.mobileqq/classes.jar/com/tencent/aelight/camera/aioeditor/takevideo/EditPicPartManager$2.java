package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qqfav.QfavBuilder;
import java.io.File;
import mqq.app.AppRuntime;

class EditPicPartManager$2
  implements ActionSheet.OnButtonClickListener
{
  EditPicPartManager$2(EditPicPartManager paramEditPicPartManager, ActionSheet paramActionSheet, Intent paramIntent, String paramString, Activity paramActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    if (((String)localObject).equals(paramView.getResources().getString(2131693256)))
    {
      int i = 1;
      paramInt = i;
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicPartManager.a.c() == 130)
      {
        paramInt = i;
        if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_is_edited_pic", false)) {
          paramInt = 0;
        }
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_type", paramInt);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_filepath", this.jdField_a_of_type_JavaLangString);
      ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentIntent, 19003);
      ReportController.b(null, "dc00898", "", "", "0X800A184", "0X800A184", 0, 0, "", "", "", "");
    }
    else if (((String)localObject).equals(paramView.getResources().getString(2131693262)))
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      String str = ((File)localObject).getAbsolutePath();
      AIOGalleryUtils.a((Activity)paramView.getContext(), (File)localObject, Utils.Crc64String(str), this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicPartManager);
      ReportController.b(null, "dc00898", "", "", "0X800A185", "0X800A185", 0, 0, "", "", "", "");
    }
    else if (((String)localObject).equals(paramView.getResources().getString(2131693254)))
    {
      paramView = BaseApplicationImpl.getApplication();
      QfavBuilder.b(this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_AndroidAppActivity, paramView.getRuntime().getAccount(), 2131694890, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicPartManager);
      ReportController.b(null, "dc00898", "", "", "0X800A186", "0X800A186", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager.2
 * JD-Core Version:    0.7.0.1
 */