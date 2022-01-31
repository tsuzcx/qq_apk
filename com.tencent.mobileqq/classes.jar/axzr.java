import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.presenter.IProvider;
import java.io.File;

class axzr
  implements ShareActionSheet.OnItemClickListener
{
  axzr(axzp paramaxzp, AIOFilePictureData paramAIOFilePictureData, File paramFile) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.jdField_a_of_type_Axzp.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    int i = paramActionSheetItem.action;
    String str = paramActionSheetItem.argus;
    switch (i)
    {
    }
    for (;;)
    {
      i = -1;
      for (;;)
      {
        azqs.b(null, "dc00898", "", "", "0X8009EF7", "0X8009EF7", i, 0, "", "", "", "");
        return;
        if ((RichMediaBrowserManager.getInstance().getProvider() == null) || (!RichMediaBrowserManager.getInstance().getProvider().isPingBinder())) {
          break;
        }
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int == 1) {}
        for (boolean bool = true;; bool = false)
        {
          axzg.a(this.jdField_a_of_type_Axzp.mContext, paramActionSheetItem, bool);
          i = -1;
          break;
        }
        int j = 1;
        i = j;
        if (RichMediaBrowserManager.getInstance().getProvider() != null)
        {
          i = j;
          if (RichMediaBrowserManager.getInstance().getProvider().isPingBinder())
          {
            paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 0);
            if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int == 1) {}
            for (bool = true;; bool = false)
            {
              axzg.a(this.jdField_a_of_type_Axzp.mContext, paramActionSheetItem, bool);
              i = j;
              break;
            }
            i = paramActionSheetItem.uinType;
            paramActionSheetItem = paramActionSheetItem.uin;
            if ((RichMediaBrowserManager.getInstance().getProvider() == null) || (!RichMediaBrowserManager.getInstance().getProvider().isPingBinder())) {
              break;
            }
            paramShareActionSheet = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 0);
            if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int == 1) {}
            for (bool = true;; bool = false)
            {
              axzg.a(this.jdField_a_of_type_Axzp.mContext, paramShareActionSheet, bool, paramActionSheetItem, i);
              i = -1;
              break;
            }
            if ((RichMediaBrowserManager.getInstance().getProvider() == null) || (!RichMediaBrowserManager.getInstance().getProvider().isPingBinder())) {
              break;
            }
            RichMediaBrowserManager.getInstance().getProvider().sendFileToPC(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long);
            azqs.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
            QQToast.a(this.jdField_a_of_type_Axzp.mContext, 2, this.jdField_a_of_type_Axzp.mContext.getString(2131692840), 0).a();
            i = -1;
            continue;
            j = 6;
            i = j;
            if (RichMediaBrowserManager.getInstance().getProvider() != null)
            {
              i = j;
              if (RichMediaBrowserManager.getInstance().getProvider().isPingBinder())
              {
                RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long);
                QQToast.a(this.jdField_a_of_type_Axzp.mContext, this.jdField_a_of_type_Axzp.mContext.getString(2131692914), 0).a();
                i = j;
                continue;
                i = 2;
                paramShareActionSheet = this.jdField_a_of_type_JavaIoFile;
                paramActionSheetItem = paramShareActionSheet;
                if (paramShareActionSheet == null) {
                  paramActionSheetItem = new axyj().a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData, 20);
                }
                if (paramActionSheetItem == null)
                {
                  BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 1, "setItemClickListenerForFile: error, file is null.");
                  return;
                }
                axza.a(this.jdField_a_of_type_Axzp.mContext, paramActionSheetItem, arrr.a(paramActionSheetItem.getAbsolutePath()));
                continue;
                j = 3;
                i = j;
                if (RichMediaBrowserManager.getInstance().getProvider() != null)
                {
                  i = j;
                  if (RichMediaBrowserManager.getInstance().getProvider().isPingBinder())
                  {
                    RichMediaBrowserManager.getInstance().getProvider().favorite(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long);
                    i = j;
                    continue;
                    paramShareActionSheet = axyd.a().a();
                    paramActionSheetItem = paramShareActionSheet;
                    if (TextUtils.isEmpty(paramShareActionSheet)) {
                      paramActionSheetItem = axyd.a().c();
                    }
                    axzh.a(this.jdField_a_of_type_Axzp.mContext, axyd.a().a(), axyd.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int, false);
                    i = 7;
                    continue;
                    i = 8;
                    OCRPerformFragment.a(this.jdField_a_of_type_Axzp.mContext, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.i);
                  }
                }
              }
            }
          }
        }
      }
      paramShareActionSheet = new Intent();
      paramShareActionSheet.putExtra("preResult", str);
      if (bdil.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_d_of_type_Int)) {}
      for (paramActionSheetItem = axyd.a().d();; paramActionSheetItem = axyd.a().c())
      {
        axzh.a(this.jdField_a_of_type_Axzp.mContext, this.jdField_a_of_type_Axzp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.c, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.h, 1, axyd.a().d(), axyd.a().c(), paramShareActionSheet);
        azqs.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
        i = 9;
        break;
      }
      paramShareActionSheet = new Intent();
      paramShareActionSheet.putExtra("preResult", str);
      if (bdil.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_d_of_type_Int)) {}
      for (paramActionSheetItem = axyd.a().d();; paramActionSheetItem = axyd.a().c())
      {
        axzh.a(this.jdField_a_of_type_Axzp.mContext, this.jdField_a_of_type_Axzp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.c, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.h, 2, axyd.a().d(), axyd.a().c(), paramShareActionSheet);
        i = 10;
        break;
      }
      PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), this.jdField_a_of_type_Axzp.mContext, 1);
      azqs.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzr
 * JD-Core Version:    0.7.0.1
 */