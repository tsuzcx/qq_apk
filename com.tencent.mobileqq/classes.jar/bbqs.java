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

class bbqs
  implements ShareActionSheet.OnItemClickListener
{
  bbqs(bbqq parambbqq, AIOFilePictureData paramAIOFilePictureData, File paramFile) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.jdField_a_of_type_Bbqq.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
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
        bdll.b(null, "dc00898", "", "", "0X8009EF7", "0X8009EF7", i, 0, "", "", "", "");
        return;
        if (!bbqq.a(this.jdField_a_of_type_Bbqq)) {
          break;
        }
        paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int == 1) {}
        for (boolean bool = true;; bool = false)
        {
          bbqh.a(this.jdField_a_of_type_Bbqq.mContext, paramActionSheetItem, bool);
          i = -1;
          break;
        }
        int j = 1;
        i = j;
        if (bbqq.a(this.jdField_a_of_type_Bbqq))
        {
          paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int == 1) {}
          for (bool = true;; bool = false)
          {
            bbqh.a(this.jdField_a_of_type_Bbqq.mContext, paramActionSheetItem, bool);
            i = j;
            break;
          }
          i = paramActionSheetItem.uinType;
          paramActionSheetItem = paramActionSheetItem.uin;
          if (!bbqq.a(this.jdField_a_of_type_Bbqq)) {
            break;
          }
          paramShareActionSheet = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Int, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int == 1) {}
          for (bool = true;; bool = false)
          {
            bbqh.a(this.jdField_a_of_type_Bbqq.mContext, paramShareActionSheet, bool, paramActionSheetItem, i);
            i = -1;
            break;
          }
          if (!bbqq.a(this.jdField_a_of_type_Bbqq)) {
            break;
          }
          RichMediaBrowserManager.getInstance().getProvider().sendFileToPC(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long);
          bdll.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
          QQToast.a(this.jdField_a_of_type_Bbqq.mContext, 2, this.jdField_a_of_type_Bbqq.mContext.getString(2131692401), 0).a();
          i = -1;
          continue;
          j = 6;
          i = j;
          if (bbqq.a(this.jdField_a_of_type_Bbqq))
          {
            RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long);
            QQToast.a(this.jdField_a_of_type_Bbqq.mContext, this.jdField_a_of_type_Bbqq.mContext.getString(2131692445), 0).a();
            i = j;
            continue;
            i = 2;
            bbqq.a(this.jdField_a_of_type_Bbqq, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData);
            continue;
            j = 3;
            i = j;
            if (bbqq.a(this.jdField_a_of_type_Bbqq))
            {
              RichMediaBrowserManager.getInstance().getProvider().favorite(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_a_of_type_Long);
              i = j;
              continue;
              paramShareActionSheet = bbox.a().a();
              paramActionSheetItem = paramShareActionSheet;
              if (TextUtils.isEmpty(paramShareActionSheet)) {
                paramActionSheetItem = bbox.a().c();
              }
              bbqi.a(this.jdField_a_of_type_Bbqq.mContext, bbox.a().a(), bbox.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int, false);
              i = 7;
              continue;
              i = 8;
              OCRPerformFragment.a(this.jdField_a_of_type_Bbqq.mContext, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.i);
            }
          }
        }
      }
      paramShareActionSheet = new Intent();
      paramShareActionSheet.putExtra("preResult", str);
      if (bhnt.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_d_of_type_Int)) {}
      for (paramActionSheetItem = bbox.a().d();; paramActionSheetItem = bbox.a().c())
      {
        bbqi.a(this.jdField_a_of_type_Bbqq.mContext, this.jdField_a_of_type_Bbqq.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.c, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.h, 1, bbox.a().d(), bbox.a().c(), paramShareActionSheet);
        bdll.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
        i = 9;
        break;
      }
      paramShareActionSheet = new Intent();
      paramShareActionSheet.putExtra("preResult", str);
      if (bhnt.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.jdField_d_of_type_Int)) {}
      for (paramActionSheetItem = bbox.a().d();; paramActionSheetItem = bbox.a().c())
      {
        bbqi.a(this.jdField_a_of_type_Bbqq.mContext, this.jdField_a_of_type_Bbqq.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.c, true, paramActionSheetItem, null, null, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOFilePictureData.h, 2, bbox.a().d(), bbox.a().c(), paramShareActionSheet);
        i = 10;
        break;
      }
      PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), this.jdField_a_of_type_Bbqq.mContext, 1);
      bdll.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqs
 * JD-Core Version:    0.7.0.1
 */