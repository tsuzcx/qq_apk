package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import mqq.app.AppRuntime;

class AIOGalleryScene$9
  implements AdapterView.OnItemClickListener
{
  AIOGalleryScene$9(AIOGalleryScene paramAIOGalleryScene, AIOImageData paramAIOImageData, AIORichMediaInfo paramAIORichMediaInfo, File paramFile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      localObject1 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a;
      int i = ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action;
      localObject1 = ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus;
      if (i != 66)
      {
        if (i != 69)
        {
          Object localObject2;
          switch (i)
          {
          default: 
            break;
          case 58: 
            AIOGalleryScene.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData);
            i = 6;
            break;
          case 57: 
            AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo, this.jdField_a_of_type_JavaIoFile);
            i = 3;
            break;
          case 56: 
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("preResult", (String)localObject1);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene;
            ((AIOGalleryScene)localObject1).a(((AIOGalleryScene)localObject1).jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.h, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e, 2, (Intent)localObject2);
            i = 10;
            break;
          case 55: 
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("preResult", (String)localObject1);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene;
            ((AIOGalleryScene)localObject1).a(((AIOGalleryScene)localObject1).jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.h, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e, 1, (Intent)localObject2);
            ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
            i = 9;
            break;
          case 54: 
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.d;
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c;
            }
            ReportController.b(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.k, 0, "", "", "", "");
            AIOGalleryScene.a(AIOGalleryScene.o(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Int, false);
            i = 7;
            break;
          case 53: 
            AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo, this.jdField_a_of_type_JavaIoFile);
            i = 2;
            break;
          case 52: 
            i = 8;
            break;
          case 51: 
            AIOGalleryScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData);
            i = 5;
            break;
          case 50: 
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a("Pic_Forward_Qzone", 0);
            AIOGalleryUtils.a(AIOGalleryScene.n(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.d);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.h) {
              VasWebviewUtil.a("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
            }
            i = 4;
            break;
          case 49: 
            AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
            i = 1;
            break;
          case 48: 
            AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData);
            i = 12;
            break;
          }
        }
        else
        {
          PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), AIOGalleryScene.p(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), 1);
          ReportController.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
        }
      }
      else
      {
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) && (localObject1 != null)) {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_j_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_g_of_type_Int, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.m, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.l, ((AppRuntime)localObject1).getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.n);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_g_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.l, ((AppRuntime)localObject1).getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.n);
          }
        }
      }
      i = 0;
      ReportController.b(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", i, 0, "", "", "", "");
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.9
 * JD-Core Version:    0.7.0.1
 */