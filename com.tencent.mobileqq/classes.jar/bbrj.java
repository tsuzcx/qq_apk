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

class bbrj
  implements ShareActionSheet.OnItemClickListener
{
  bbrj(bbrb parambbrb, AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int j = paramActionSheetItem.action;
    paramShareActionSheet = paramActionSheetItem.argus;
    if (j != 72) {
      this.jdField_a_of_type_Bbrb.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
    int i;
    switch (j)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", i, 0, "", "", "", "");
      return;
      i = 12;
      bbrb.a(this.jdField_a_of_type_Bbrb, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
      continue;
      i = 1;
      bbrb.a(this.jdField_a_of_type_Bbrb, j, paramActionSheetItem, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo);
      continue;
      if (RichMediaBrowserManager.getInstance().getProvider() != null) {
        RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_Forward_Qzone", 0);
      }
      bbqb.a(this.jdField_a_of_type_Bbrb.mContext, bbox.a().d(), bbox.a().b(), this.jdField_a_of_type_Bbrb.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_Bbrb.jdField_a_of_type_Boolean, bbox.a().a());
      if (this.jdField_a_of_type_Bbrb.b)
      {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
        i = 4;
        continue;
        i = 5;
        bbrb.b(this.jdField_a_of_type_Bbrb, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
        continue;
        i = 2;
        bbrb.a(this.jdField_a_of_type_Bbrb, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaIoFile);
        continue;
        paramActionSheetItem = new Intent();
        paramActionSheetItem.putExtra("preResult", paramShareActionSheet);
        bbqi.a(this.jdField_a_of_type_Bbrb.mContext, this.jdField_a_of_type_Bbrb.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.b, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.j, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.e, 1, bbox.a().d(), bbox.a().c(), paramActionSheetItem);
        bdll.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
        i = 9;
        continue;
        paramActionSheetItem = new Intent();
        paramActionSheetItem.putExtra("preResult", paramShareActionSheet);
        bbqi.a(this.jdField_a_of_type_Bbrb.mContext, this.jdField_a_of_type_Bbrb.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.b, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.j, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.e, 2, bbox.a().d(), bbox.a().c(), paramActionSheetItem);
        i = 10;
        continue;
        i = 3;
        bbrb.a(this.jdField_a_of_type_Bbrb, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaIoFile);
        continue;
        i = 8;
        OCRPerformFragment.a(this.jdField_a_of_type_Bbrb.mContext, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.b, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f);
        continue;
        i = 6;
        bbrb.c(this.jdField_a_of_type_Bbrb, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
        continue;
        i = 7;
        bbrb.d(this.jdField_a_of_type_Bbrb, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
        continue;
        bbrb.e(this.jdField_a_of_type_Bbrb, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
        i = 0;
        continue;
        PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), this.jdField_a_of_type_Bbrb.mContext, 1);
        bdll.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
        break;
      }
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrj
 * JD-Core Version:    0.7.0.1
 */