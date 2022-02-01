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

class balq
  implements ShareActionSheet.OnItemClickListener
{
  balq(balk parambalk, AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {}
    int i;
    label763:
    do
    {
      return;
      this.jdField_a_of_type_Balk.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      int j = paramActionSheetItem.action;
      switch (j)
      {
      }
      for (;;)
      {
        i = 0;
        for (;;)
        {
          paramActionSheetItem = this.jdField_a_of_type_Balk.jdField_a_of_type_Bajt.getSelectedItem();
          if ((paramActionSheetItem == null) || (paramActionSheetItem.baseData == null) || (!AIOVideoData.class.isInstance(paramActionSheetItem.baseData))) {
            break;
          }
          paramActionSheetItem = (AIOVideoData)paramActionSheetItem.baseData;
          if (paramActionSheetItem.jdField_d_of_type_Int != 0) {
            break label763;
          }
          bcef.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
          return;
          i = 1;
          balk.a(this.jdField_a_of_type_Balk, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData, j, paramActionSheetItem);
          continue;
          paramActionSheetItem = QZoneHelper.UserInfo.getInstance();
          paramActionSheetItem.qzone_uin = bais.a().d();
          QZoneHelper.forwardToPublishMood(this.jdField_a_of_type_Balk.mContext, paramActionSheetItem, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
          bcef.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
          i = 4;
          continue;
          balk.a(this.jdField_a_of_type_Balk, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo);
          i = 0;
          continue;
          bcef.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", bais.a().c(), 0, "", "", "", "");
          paramShareActionSheet = bais.a().a();
          paramActionSheetItem = paramShareActionSheet;
          if (TextUtils.isEmpty(paramShareActionSheet)) {
            paramActionSheetItem = bais.a().c();
          }
          bakd.a(this.jdField_a_of_type_Balk.mContext, bais.a().a(), bais.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false);
          i = 6;
          continue;
          i = 3;
          balk.a(this.jdField_a_of_type_Balk, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData);
          continue;
          i = 7;
          balk.b(this.jdField_a_of_type_Balk, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData);
          continue;
          j = 6;
          i = j;
          if (RichMediaBrowserManager.getInstance().getProvider() != null)
          {
            i = j;
            if (RichMediaBrowserManager.getInstance().getProvider().isPingBinder())
            {
              RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.a);
              QQToast.a(this.jdField_a_of_type_Balk.mContext, this.jdField_a_of_type_Balk.mContext.getString(2131692493), 0).a();
              i = j;
              continue;
              paramShareActionSheet = new Intent(this.jdField_a_of_type_Balk.mContext, ScannerActivity.class);
              paramShareActionSheet.putExtra("detectType", 1);
              paramShareActionSheet.putExtra("preResult", paramActionSheetItem.argus);
              paramShareActionSheet.putExtra("QRDecode", true);
              bakd.a(this.jdField_a_of_type_Balk.mContext, balk.a(this.jdField_a_of_type_Balk), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_JavaLangString, "", "", "", 1, bais.a().d(), bais.a().c(), paramShareActionSheet);
              balk.a(this.jdField_a_of_type_Balk, "0X800ACB7", this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int);
              i = 0;
            }
          }
        }
        paramShareActionSheet = new Intent(this.jdField_a_of_type_Balk.mContext, ScannerActivity.class);
        paramShareActionSheet.putExtra("detectType", 2);
        paramShareActionSheet.putExtra("preResult", paramActionSheetItem.argus);
        paramShareActionSheet.putExtra("QRDecode", true);
        bakd.a(this.jdField_a_of_type_Balk.mContext, balk.a(this.jdField_a_of_type_Balk), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_JavaLangString, "", "", "", 2, bais.a().d(), bais.a().c(), paramShareActionSheet);
        balk.a(this.jdField_a_of_type_Balk, "0X800ACB8", this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int);
      }
    } while (paramActionSheetItem.jdField_d_of_type_Int != 1);
    bcef.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     balq
 * JD-Core Version:    0.7.0.1
 */