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

class bbrt
  implements ShareActionSheet.OnItemClickListener
{
  bbrt(bbrl parambbrl, AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int j = paramActionSheetItem.action;
    paramShareActionSheet = paramActionSheetItem.argus;
    if (j != 72) {
      this.jdField_a_of_type_Bbrl.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
    int i;
    switch (j)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", i, 0, "", "", "", "");
      return;
      i = 12;
      bbrl.a(this.jdField_a_of_type_Bbrl, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
      continue;
      i = 1;
      bbrl.a(this.jdField_a_of_type_Bbrl, j, paramActionSheetItem, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo);
      continue;
      if (RichMediaBrowserManager.getInstance().getProvider() != null) {
        RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_Forward_Qzone", 0);
      }
      bbql.a(this.jdField_a_of_type_Bbrl.mContext, bbph.a().d(), bbph.a().b(), this.jdField_a_of_type_Bbrl.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_Bbrl.jdField_a_of_type_Boolean, bbph.a().a());
      if (this.jdField_a_of_type_Bbrl.b)
      {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
        i = 4;
        continue;
        i = 5;
        bbrl.b(this.jdField_a_of_type_Bbrl, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
        continue;
        i = 2;
        bbrl.a(this.jdField_a_of_type_Bbrl, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaIoFile);
        continue;
        paramActionSheetItem = new Intent();
        bbqs.a(this.jdField_a_of_type_Bbrl.mContext, this.jdField_a_of_type_Bbrl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.b, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.j, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.e, 1, bbph.a().d(), bbph.a().c(), paramActionSheetItem);
        bdla.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
        i = 9;
        continue;
        paramActionSheetItem = new Intent();
        bbqs.a(this.jdField_a_of_type_Bbrl.mContext, this.jdField_a_of_type_Bbrl.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.b, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.j, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.e, 2, bbph.a().d(), bbph.a().c(), paramActionSheetItem);
        i = 10;
        continue;
        i = 3;
        bbrl.a(this.jdField_a_of_type_Bbrl, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_JavaIoFile);
        continue;
        i = 8;
        OCRPerformFragment.a(this.jdField_a_of_type_Bbrl.mContext, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.b, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f);
        continue;
        i = 6;
        bbrl.c(this.jdField_a_of_type_Bbrl, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
        continue;
        i = 7;
        bbrl.d(this.jdField_a_of_type_Bbrl, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
        continue;
        bbrl.e(this.jdField_a_of_type_Bbrl, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
        i = 0;
        continue;
        PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), this.jdField_a_of_type_Bbrl.mContext, 1);
        bdla.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
        break;
      }
      i = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrt
 * JD-Core Version:    0.7.0.1
 */