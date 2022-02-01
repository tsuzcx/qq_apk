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
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.a.dismiss();
      return;
    }
    Object localObject = this.a.getContent(paramInt);
    if (localObject == null)
    {
      this.a.dismiss();
      return;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.a.dismiss();
      return;
    }
    if (((String)localObject).equals(paramView.getResources().getString(2131890804)))
    {
      int i = 1;
      paramInt = i;
      if (this.e.I.j() == 130)
      {
        paramInt = i;
        if (!this.b.getBooleanExtra("extra_is_edited_pic", false)) {
          paramInt = 0;
        }
      }
      this.b.putExtra("forward_type", paramInt);
      this.b.putExtra("forward_filepath", this.c);
      ForwardBaseOption.a(this.d, this.b, 19003);
      ReportController.b(null, "dc00898", "", "", "0X800A184", "0X800A184", 0, 0, "", "", "", "");
    }
    else if (((String)localObject).equals(paramView.getResources().getString(2131890810)))
    {
      localObject = new File(this.c);
      String str = ((File)localObject).getAbsolutePath();
      AIOGalleryUtils.a((Activity)paramView.getContext(), (File)localObject, Utils.Crc64String(str), this.e);
      ReportController.b(null, "dc00898", "", "", "0X800A185", "0X800A185", 0, 0, "", "", "", "");
    }
    else if (((String)localObject).equals(paramView.getResources().getString(2131890802)))
    {
      paramView = BaseApplicationImpl.getApplication();
      QfavBuilder.b(this.c).a(this.d, paramView.getRuntime().getAccount(), 2131892594, this.e);
      ReportController.b(null, "dc00898", "", "", "0X800A186", "0X800A186", 0, 0, "", "", "", "");
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager.2
 * JD-Core Version:    0.7.0.1
 */