package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import mqq.app.AppRuntime;

class AIOGalleryScene$17
  implements AdapterView.OnItemClickListener
{
  AIOGalleryScene$17(AIOGalleryScene paramAIOGalleryScene, AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, AIORichMediaInfo paramAIORichMediaInfo) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    Object localObject = paramView.getTag();
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      switch (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).a.action)
      {
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
        if ((localObject == null) || (((AIORichMediaInfo)localObject).a == null) || (!AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).a))) {
          break;
        }
        localObject = (AIOShortVideoData)((AIORichMediaInfo)localObject).a;
        if (((AIOShortVideoData)localObject).b != 0) {
          break label640;
        }
        ReportController.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
        break;
        i = 1;
        AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "click menu to share to qzone");
        }
        localObject = QZoneHelper.UserInfo.getInstance();
        ((QZoneHelper.UserInfo)localObject).qzone_uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b;
        QZoneHelper.forwardToPublishMood(AIOGalleryScene.t(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), (QZoneHelper.UserInfo)localObject, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
        ReportController.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
        i = 4;
        continue;
        AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
        continue;
        ReportController.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.k, 0, "", "", "", "");
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.d;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c;
        }
        AIOGalleryScene.a(AIOGalleryScene.u(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int, false);
        i = 6;
        continue;
        int j = 3;
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder())
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_g_of_type_Int);
          i = j;
          if (localObject != null)
          {
            QfavBuilder.a((Intent)localObject).a(AIOGalleryScene.v(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), BaseApplicationImpl.getApplication().getRuntime().getAccount());
            QfavReport.a(null, 3, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_g_of_type_Int);
            QfavReport.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
            i = j;
            continue;
            i = 7;
            AIOGalleryScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData);
            continue;
            j = 6;
            i = j;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder())
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.jdField_f_of_type_Long);
              QQToast.a(AIOGalleryScene.w(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), AIOGalleryScene.x(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131692733), 0).a();
              i = j;
            }
          }
        }
      }
      label640:
      if (((AIOShortVideoData)localObject).b == 1) {
        ReportController.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.17
 * JD-Core Version:    0.7.0.1
 */