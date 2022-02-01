import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import java.io.File;

class bayq
  implements ShareActionSheet.OnItemClickListener
{
  bayq(bayi parambayi, AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int j = paramActionSheetItem.action;
    paramShareActionSheet = paramActionSheetItem.argus;
    if (j != 72) {
      this.jdField_a_of_type_Bayi.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
    int i;
    switch (j)
    {
    default: 
      i = 0;
    }
    label920:
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", i, 0, "", "", "", "");
      return;
      i = 12;
      bayi.a(this.jdField_a_of_type_Bayi, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
      continue;
      i = 1;
      if (RichMediaBrowserManager.getInstance().getProvider() != null) {
        RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_Forward_Contacts", 0);
      }
      paramShareActionSheet = new baxe();
      paramShareActionSheet.jdField_a_of_type_Int = j;
      if (j == 72)
      {
        paramShareActionSheet.jdField_a_of_type_JavaLangString = paramActionSheetItem.uin;
        paramShareActionSheet.b = paramActionSheetItem.uinType;
      }
      baxc localbaxc = bayi.a(this.jdField_a_of_type_Bayi);
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo;
      Activity localActivity = this.jdField_a_of_type_Bayi.mContext;
      if (this.jdField_a_of_type_Bayi.b) {}
      for (paramActionSheetItem = "biz_src_jc_groupgif";; paramActionSheetItem = "biz_src_jc_photo")
      {
        localbaxc.a(localRichMediaBrowserInfo, localActivity, paramShareActionSheet, 100500, paramActionSheetItem);
        if (this.jdField_a_of_type_Bayi.b) {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
        }
        if (!bawe.a().c()) {
          break label920;
        }
        awwt.a("0X8009ABA");
        i = 1;
        break;
      }
      i = 4;
      if (RichMediaBrowserManager.getInstance().getProvider() != null) {
        RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_Forward_Qzone", 0);
      }
      baxi.a(this.jdField_a_of_type_Bayi.mContext, bawe.a().d(), bawe.a().b(), this.jdField_a_of_type_Bayi.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_Bayi.jdField_a_of_type_Boolean, bawe.a().a());
      if (this.jdField_a_of_type_Bayi.b)
      {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
        i = 4;
        continue;
        i = 5;
        bayi.b(this.jdField_a_of_type_Bayi, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
        continue;
        i = 2;
        bayi.a(this.jdField_a_of_type_Bayi, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaIoFile);
        continue;
        paramActionSheetItem = new Intent();
        paramActionSheetItem.putExtra("preResult", paramShareActionSheet);
        baxp.a(this.jdField_a_of_type_Bayi.mContext, this.jdField_a_of_type_Bayi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.b, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.j, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.e, 1, bawe.a().d(), bawe.a().c(), paramActionSheetItem);
        bcst.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
        i = 9;
        continue;
        paramActionSheetItem = new Intent();
        paramActionSheetItem.putExtra("preResult", paramShareActionSheet);
        baxp.a(this.jdField_a_of_type_Bayi.mContext, this.jdField_a_of_type_Bayi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.b, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.j, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.e, 2, bawe.a().d(), bawe.a().c(), paramActionSheetItem);
        i = 10;
        continue;
        i = 3;
        bayi.a(this.jdField_a_of_type_Bayi, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaIoFile);
        continue;
        i = 8;
        OCRPerformFragment.a(this.jdField_a_of_type_Bayi.mContext, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.b, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f);
        continue;
        i = 6;
        bayi.c(this.jdField_a_of_type_Bayi, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
        continue;
        i = 7;
        bayi.d(this.jdField_a_of_type_Bayi, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
        continue;
        bayi.e(this.jdField_a_of_type_Bayi, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
        i = 0;
        continue;
        PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), this.jdField_a_of_type_Bayi.mContext, 1);
        bcst.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayq
 * JD-Core Version:    0.7.0.1
 */