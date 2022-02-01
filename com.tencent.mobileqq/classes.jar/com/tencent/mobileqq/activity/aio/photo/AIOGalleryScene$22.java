package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class AIOGalleryScene$22
  implements AdapterView.OnItemClickListener
{
  AIOGalleryScene$22(AIOGalleryScene paramAIOGalleryScene, AIORichMediaData paramAIORichMediaData, boolean paramBoolean, File paramFile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      localObject = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).a;
      int i = ((ShareActionSheetBuilder.ActionSheetItem)localObject).action;
      localObject = ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus;
      if (i != 64)
      {
        if (i != 67)
        {
          if (i != 69)
          {
            int j;
            switch (i)
            {
            default: 
              break;
            case 59: 
              AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
              i = 1;
              break;
            case 58: 
              if (this.jdField_a_of_type_Boolean) {
                i = 6;
              } else {
                i = 5;
              }
              j = i;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder())
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f);
                QQToast.a(AIOGalleryScene.z(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), AIOGalleryScene.A(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131692690), 0).a();
                j = i;
              }
            case 57: 
            case 56: 
            case 55: 
            case 54: 
              for (;;)
              {
                i = j;
                break;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder()) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f);
                }
                i = 3;
                break;
                AIOGalleryScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, (String)localObject);
                i = 10;
                break;
                AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, (String)localObject);
                i = 9;
                break;
                if (this.jdField_a_of_type_Boolean) {
                  j = 7;
                } else {
                  j = 6;
                }
                String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.d;
                localObject = str;
                if (TextUtils.isEmpty(str)) {
                  localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c;
                }
                AIOGalleryScene.a(AIOGalleryScene.D(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_g_of_type_Int, false);
              }
            case 53: 
              AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_JavaIoFile);
              i = 2;
              break;
            case 52: 
              i = 8;
              break;
            }
            AIOGalleryScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
            i = 5;
            break label637;
          }
          PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), AIOGalleryScene.F(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), 1);
          ReportController.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder())
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.f);
          ReportController.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
          QQToast.a(AIOGalleryScene.B(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), 2, AIOGalleryScene.C(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131692645), 0).a();
        }
        i = -1;
      }
      else
      {
        localObject = (AIOFileVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        FileManagerUtil.a(AIOGalleryScene.E(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), ((AIOFileVideoData)localObject).c);
        i = 11;
      }
      label637:
      if (this.jdField_a_of_type_Boolean) {
        localObject = "0X8009EF7";
      } else {
        localObject = "0X8009EFA";
      }
      ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, i, 0, "", "", "", "");
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.22
 * JD-Core Version:    0.7.0.1
 */