package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;

class AIOImageListScene$1
  implements ActionSheet.OnButtonClickListener
{
  AIOImageListScene$1(AIOImageListScene paramAIOImageListScene, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView)) {
        if (paramView.equals(AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131689887)))
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a();
          if (paramInt == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.r();
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene;
            paramView.a("Multi_Forward_Contacts", paramView.jdField_a_of_type_JavaUtilArrayList.size());
          }
          else if ((paramInt == 2) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder()))
          {
            paramView = (AIOShortVideoData)((AIORichMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramView.jdField_f_of_type_Long, paramView.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.c);
            if (paramView != null) {
              ForwardBaseOption.a(AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), paramView);
            }
          }
        }
        else if (paramView.equals(AIOImageListScene.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131693257)))
        {
          paramView = new StringBuilder();
          paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaLangString);
          paramView.append("__qzone_pic_permission__");
          paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.b);
          if (LocalMultiProcConfig.getInt4Uin(paramView.toString(), -1, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaLangString).longValue()) == 0)
          {
            paramView = new QQCustomDialog(AIOImageListScene.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), 2131756189);
            paramView.setContentView(2131558978);
            paramView.setTitle(AIOImageListScene.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getString(2131697674));
            paramView.setMessage(AIOImageListScene.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getString(2131697672));
            paramView.setNegativeButton(AIOImageListScene.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getString(2131697673), new AIOImageListScene.1.1(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaLangString, "40", "1");
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaUtilArrayList.size() > 20)
          {
            QQToast.a(AIOImageListScene.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), 2131692653, 0).a();
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.s();
          }
        }
        else if (paramView.equals(AIOImageListScene.j(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131693263)))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
            QQToast.a(AIOImageListScene.k(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), 2131692653, 0).a();
          } else {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.u();
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.1
 * JD-Core Version:    0.7.0.1
 */