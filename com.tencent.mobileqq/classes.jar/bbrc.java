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
import com.tencent.richmediabrowser.presenter.IProvider;
import java.io.File;

class bbrc
  implements ShareActionSheet.OnItemClickListener
{
  bbrc(bbra parambbra, AIOFilePictureData paramAIOFilePictureData, File paramFile) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.jdField_a_of_type_Bbra.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    int i = paramActionSheetItem.action;
    paramShareActionSheet = paramActionSheetItem.argus;
    switch (i)
    {
    }
    for (;;)
    {
      i = -1;
      for (;;)
      {
        bdla.b(null, "dc00898", "", "", "0X8009EF7", "0X8009EF7", i, 0, "", "", "", "");
        return;
        if (!bbra.a(this.jdField_a_of_type_Bbra)) {
          break;
        }
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int == 1) {}
        for (boolean bool = true;; bool = false)
        {
          bbqr.a(this.jdField_a_of_type_Bbra.mContext, paramActionSheetItem, bool);
          i = -1;
          break;
        }
        int j = 1;
        i = j;
        if (bbra.a(this.jdField_a_of_type_Bbra))
        {
          paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int == 1) {}
          for (bool = true;; bool = false)
          {
            bbqr.a(this.jdField_a_of_type_Bbra.mContext, paramActionSheetItem, bool);
            i = j;
            break;
          }
          i = paramActionSheetItem.uinType;
          paramActionSheetItem = paramActionSheetItem.uin;
          if (!bbra.a(this.jdField_a_of_type_Bbra)) {
            break;
          }
          paramShareActionSheet = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int == 1) {}
          for (bool = true;; bool = false)
          {
            bbqr.a(this.jdField_a_of_type_Bbra.mContext, paramShareActionSheet, bool, paramActionSheetItem, i);
            i = -1;
            break;
          }
          if (!bbra.a(this.jdField_a_of_type_Bbra)) {
            break;
          }
          RichMediaBrowserManager.getInstance().getProvider().sendFileToPC(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long);
          bdla.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
          QQToast.a(this.jdField_a_of_type_Bbra.mContext, 2, this.jdField_a_of_type_Bbra.mContext.getString(2131692551), 0).a();
          i = -1;
          continue;
          j = 6;
          i = j;
          if (bbra.a(this.jdField_a_of_type_Bbra))
          {
            RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long);
            QQToast.a(this.jdField_a_of_type_Bbra.mContext, this.jdField_a_of_type_Bbra.mContext.getString(2131692595), 0).a();
            i = j;
            continue;
            i = 2;
            bbra.a(this.jdField_a_of_type_Bbra, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData);
            continue;
            j = 3;
            i = j;
            if (bbra.a(this.jdField_a_of_type_Bbra))
            {
              RichMediaBrowserManager.getInstance().getProvider().favorite(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long);
              i = j;
              continue;
              paramShareActionSheet = bbph.a().a();
              paramActionSheetItem = paramShareActionSheet;
              if (TextUtils.isEmpty(paramShareActionSheet)) {
                paramActionSheetItem = bbph.a().c();
              }
              bbqs.a(this.jdField_a_of_type_Bbra.mContext, bbph.a().a(), bbph.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int, false);
              i = 7;
              continue;
              i = 8;
              OCRPerformFragment.a(this.jdField_a_of_type_Bbra.mContext, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.i);
            }
          }
        }
      }
      paramShareActionSheet = new Intent();
      if (bhfj.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_d_of_type_Int)) {}
      for (paramActionSheetItem = bbph.a().d();; paramActionSheetItem = bbph.a().c())
      {
        bbqs.a(this.jdField_a_of_type_Bbra.mContext, this.jdField_a_of_type_Bbra.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.c, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.h, 1, bbph.a().d(), bbph.a().c(), paramShareActionSheet);
        bdla.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
        i = 9;
        break;
      }
      paramShareActionSheet = new Intent();
      if (bhfj.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_d_of_type_Int)) {}
      for (paramActionSheetItem = bbph.a().d();; paramActionSheetItem = bbph.a().c())
      {
        bbqs.a(this.jdField_a_of_type_Bbra.mContext, this.jdField_a_of_type_Bbra.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.c, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.h, 2, bbph.a().d(), bbph.a().c(), paramShareActionSheet);
        i = 10;
        break;
      }
      PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), this.jdField_a_of_type_Bbra.mContext, 1);
      bdla.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrc
 * JD-Core Version:    0.7.0.1
 */