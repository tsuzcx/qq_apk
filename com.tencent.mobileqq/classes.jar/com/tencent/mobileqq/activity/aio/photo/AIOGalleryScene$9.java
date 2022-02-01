package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import mqq.app.AppRuntime;

class AIOGalleryScene$9
  implements AdapterView.OnItemClickListener
{
  AIOGalleryScene$9(AIOGalleryScene paramAIOGalleryScene, AIOImageData paramAIOImageData, AIORichMediaInfo paramAIORichMediaInfo, File paramFile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (localObject == null)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    localObject = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).a;
    int i = ((ShareActionSheetBuilder.ActionSheetItem)localObject).action;
    localObject = ((ShareActionSheetBuilder.ActionSheetItem)localObject).argus;
    switch (i)
    {
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 67: 
    case 68: 
    default: 
      i = 0;
    }
    for (;;)
    {
      label163:
      ReportController.b(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", i, 0, "", "", "", "");
      break;
      i = 12;
      AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData);
      continue;
      i = 1;
      AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a("Pic_Forward_Qzone", 0);
      AIOGalleryUtils.a(AIOGalleryScene.n(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.e, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.d);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.h)
      {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
        i = 4;
        continue;
        i = 5;
        AIOGalleryScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData);
        continue;
        i = 2;
        AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo, this.jdField_a_of_type_JavaIoFile);
        continue;
        Intent localIntent = new Intent();
        localIntent.putExtra("preResult", (String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.h, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e, 1, localIntent);
        ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
        i = 9;
        continue;
        localIntent = new Intent();
        localIntent.putExtra("preResult", (String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.h, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.e, 2, localIntent);
        i = 10;
        continue;
        i = 3;
        AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo, this.jdField_a_of_type_JavaIoFile);
        continue;
        i = 8;
        OCRResultActivity.a(AIOGalleryScene.o(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1);
        continue;
        i = 6;
        AIOGalleryScene.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData);
        continue;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.d;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c;
        }
        for (;;)
        {
          ReportController.b(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.k, 0, "", "", "", "");
          AIOGalleryScene.a(AIOGalleryScene.p(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_g_of_type_Int, false);
          i = 7;
          break label163;
          localObject = BaseApplicationImpl.getApplication().getRuntime();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider == null) || (localObject == null)) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.jdField_j_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_g_of_type_Int, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.m, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.l, ((AppRuntime)localObject).getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.n);
            i = 0;
            break label163;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_g_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.k, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.l, ((AppRuntime)localObject).getAccount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData.n);
          i = 0;
          break label163;
          PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), AIOGalleryScene.q(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), 1);
          ReportController.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
          break;
        }
      }
      else
      {
        i = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.9
 * JD-Core Version:    0.7.0.1
 */