import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;

class bbsf
  implements ShareActionSheet.OnItemClickListener
{
  bbsf(bbrz parambbrz, AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {}
    int i;
    label741:
    do
    {
      return;
      this.jdField_a_of_type_Bbrz.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      int j = paramActionSheetItem.action;
      switch (j)
      {
      }
      for (;;)
      {
        i = 0;
        for (;;)
        {
          paramActionSheetItem = this.jdField_a_of_type_Bbrz.jdField_a_of_type_Bbqi.getSelectedItem();
          if ((paramActionSheetItem == null) || (paramActionSheetItem.baseData == null) || (!AIOVideoData.class.isInstance(paramActionSheetItem.baseData))) {
            break;
          }
          paramActionSheetItem = (AIOVideoData)paramActionSheetItem.baseData;
          if (paramActionSheetItem.jdField_d_of_type_Int != 0) {
            break label741;
          }
          bdla.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
          return;
          i = 1;
          bbrz.a(this.jdField_a_of_type_Bbrz, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData, j, paramActionSheetItem);
          continue;
          paramActionSheetItem = QZoneHelper.UserInfo.getInstance();
          paramActionSheetItem.qzone_uin = bbph.a().d();
          QZoneHelper.forwardToPublishMood(this.jdField_a_of_type_Bbrz.mContext, paramActionSheetItem, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
          bdla.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
          i = 4;
          continue;
          bbrz.a(this.jdField_a_of_type_Bbrz, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo);
          i = 0;
          continue;
          bdla.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", bbph.a().c(), 0, "", "", "", "");
          paramShareActionSheet = bbph.a().a();
          paramActionSheetItem = paramShareActionSheet;
          if (TextUtils.isEmpty(paramShareActionSheet)) {
            paramActionSheetItem = bbph.a().c();
          }
          bbqs.a(this.jdField_a_of_type_Bbrz.mContext, bbph.a().a(), bbph.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false);
          i = 6;
          continue;
          i = 3;
          bbrz.a(this.jdField_a_of_type_Bbrz, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData);
          continue;
          i = 7;
          bbrz.b(this.jdField_a_of_type_Bbrz, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData);
          continue;
          j = 6;
          i = j;
          if (RichMediaBrowserManager.getInstance().getProvider() != null)
          {
            i = j;
            if (RichMediaBrowserManager.getInstance().getProvider().isPingBinder())
            {
              RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.a);
              QQToast.a(this.jdField_a_of_type_Bbrz.mContext, this.jdField_a_of_type_Bbrz.mContext.getString(2131692595), 0).a();
              i = j;
              continue;
              paramActionSheetItem = new Intent(this.jdField_a_of_type_Bbrz.mContext, ScannerActivity.class);
              paramActionSheetItem.putExtra("detectType", 1);
              paramActionSheetItem.putExtra("QRDecode", true);
              bbqs.a(this.jdField_a_of_type_Bbrz.mContext, bbrz.a(this.jdField_a_of_type_Bbrz), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_JavaLangString, "", "", "", 1, bbph.a().d(), bbph.a().c(), paramActionSheetItem);
              bbrz.a(this.jdField_a_of_type_Bbrz, "0X800ACB7", this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int);
              i = 0;
            }
          }
        }
        paramActionSheetItem = new Intent(this.jdField_a_of_type_Bbrz.mContext, ScannerActivity.class);
        paramActionSheetItem.putExtra("detectType", 2);
        paramActionSheetItem.putExtra("QRDecode", true);
        bbqs.a(this.jdField_a_of_type_Bbrz.mContext, bbrz.a(this.jdField_a_of_type_Bbrz), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_JavaLangString, "", "", "", 2, bbph.a().d(), bbph.a().c(), paramActionSheetItem);
        bbrz.a(this.jdField_a_of_type_Bbrz, "0X800ACB8", this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int);
      }
    } while (paramActionSheetItem.jdField_d_of_type_Int != 1);
    bdla.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsf
 * JD-Core Version:    0.7.0.1
 */