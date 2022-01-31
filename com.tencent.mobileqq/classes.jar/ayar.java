import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import java.io.File;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class ayar
  implements ShareActionSheet.OnItemClickListener
{
  ayar(ayao paramayao, AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {}
    int i;
    label518:
    label1781:
    do
    {
      return;
      this.jdField_a_of_type_Ayao.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      i = paramActionSheetItem.action;
      switch (i)
      {
      }
      for (;;)
      {
        i = 0;
        for (;;)
        {
          paramActionSheetItem = this.jdField_a_of_type_Ayao.jdField_a_of_type_Axyy.getSelectedItem();
          if ((paramActionSheetItem == null) || (paramActionSheetItem.baseData == null) || (!AIOVideoData.class.isInstance(paramActionSheetItem.baseData))) {
            break;
          }
          paramActionSheetItem = (AIOVideoData)paramActionSheetItem.baseData;
          if (paramActionSheetItem.jdField_d_of_type_Int != 0) {
            break label1781;
          }
          azqs.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
          return;
          int j = 1;
          if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
          {
            paramShareActionSheet = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_a_of_type_Int, axyd.a().a());
            if (paramShareActionSheet != null)
            {
              paramShareActionSheet.putExtra("NeedReportForwardShortVideo", true);
              if (this.jdField_a_of_type_Ayao.jdField_a_of_type_Axyy.getSelectedItem() != null)
              {
                Object localObject = this.jdField_a_of_type_Ayao.jdField_a_of_type_Axyy.getSelectedItem().baseData;
                if ((localObject instanceof AIOVideoData))
                {
                  localObject = (AIOVideoData)localObject;
                  int k = ((AIOVideoData)localObject).jdField_g_of_type_Int;
                  AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
                  if ((k == LocalMediaInfo.REDBAG_TYPE_GET) && (localAppRuntime.getAccount().equals(((AIOVideoData)localObject).jdField_d_of_type_JavaLangString)))
                  {
                    paramShareActionSheet.putExtra("param_key_redbag_type", k);
                    paramShareActionSheet.putExtra("param_key_redbag_video_id", ((AIOVideoData)localObject).jdField_c_of_type_JavaLangString);
                    paramShareActionSheet.putExtra("from_session_uin", ((AIOVideoData)localObject).e);
                  }
                  if (((AIOVideoData)localObject).k == 2) {
                    paramShareActionSheet.putExtra("special_video_type", ((AIOVideoData)localObject).k);
                  }
                  if (!TextUtils.isEmpty(((AIOVideoData)localObject).f))
                  {
                    paramShareActionSheet.putExtra("widgetinfo", ((AIOVideoData)localObject).f);
                    paramShareActionSheet.putExtra("key_camera_material_name", ((AIOVideoData)localObject).jdField_g_of_type_JavaLangString);
                  }
                }
              }
              if (i != 72) {
                break label518;
              }
              paramShareActionSheet.putExtra("key_req", ForwardRecentActivity.f);
              paramShareActionSheet.putExtra("key_direct_show_uin_type", paramActionSheetItem.uinType);
              paramShareActionSheet.putExtra("key_direct_show_uin", paramActionSheetItem.uin);
              aryv.a(this.jdField_a_of_type_Ayao.mContext, paramShareActionSheet, ForwardRecentTranslucentActivity.class, 19005, 100500, " biz_src_jc_video");
            }
          }
          for (;;)
          {
            i = j;
            if (!axyd.a().c()) {
              break;
            }
            aupn.a("0X8009ABC");
            i = j;
            break;
            aryv.a(this.jdField_a_of_type_Ayao.mContext, paramShareActionSheet, 100500, " biz_src_jc_video");
          }
          paramActionSheetItem = bjea.a();
          paramActionSheetItem.a = axyd.a().d();
          bjdt.c(this.jdField_a_of_type_Ayao.mContext, paramActionSheetItem, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
          azqs.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
          i = 4;
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.j == 5002)
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "video file is expired");
            QQToast.a(this.jdField_a_of_type_Ayao.mContext, 1, alud.a(2131700415), 0).a();
            return;
          }
          if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_Ayao.mContext))
          {
            CheckPermission.requestStorePermission(this.jdField_a_of_type_Ayao.mContext, null);
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_Int == 1)
          {
            this.jdField_a_of_type_Ayao.jdField_a_of_type_Axyy.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaIoFile);
            i = 0;
          }
          else if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_JavaIoFile.length() == this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_c_of_type_Long))
          {
            paramActionSheetItem = new StringBuilder().append(this.jdField_a_of_type_JavaIoFile.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4";
            ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Ayao.jdField_a_of_type_Axyy.a, paramActionSheetItem, false));
            i = 0;
          }
          else if (!AppNetConnInfo.isNetSupport())
          {
            this.jdField_a_of_type_Ayao.jdField_a_of_type_Axyy.a.sendEmptyMessage(10001);
            i = 0;
          }
          else if ((!AppNetConnInfo.isWifiConn()) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_c_of_type_Long > 29360128L))
          {
            this.jdField_a_of_type_Ayao.a(3, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo);
            i = 0;
          }
          else
          {
            this.jdField_a_of_type_Ayao.jdField_a_of_type_Axyy.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData);
            this.jdField_a_of_type_Ayao.jdField_a_of_type_Axyy.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_a_of_type_Int, 2);
            this.jdField_a_of_type_Ayao.updateUI();
            if (this.jdField_a_of_type_Ayao.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
              this.jdField_a_of_type_Ayao.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
            }
            ayao.b(this.jdField_a_of_type_Ayao, false);
            i = 0;
            continue;
            azqs.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", axyd.a().c(), 0, "", "", "", "");
            paramShareActionSheet = axyd.a().a();
            paramActionSheetItem = paramShareActionSheet;
            if (TextUtils.isEmpty(paramShareActionSheet)) {
              paramActionSheetItem = axyd.a().c();
            }
            axzh.a(this.jdField_a_of_type_Ayao.mContext, axyd.a().a(), axyd.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false);
            i = 6;
            continue;
            j = 3;
            i = j;
            if (RichMediaBrowserManager.getInstance().getProvider() != null)
            {
              i = j;
              if (RichMediaBrowserManager.getInstance().getProvider().isPingBinder())
              {
                paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_a_of_type_Int, axyd.a().a());
                i = j;
                if (paramActionSheetItem != null)
                {
                  biva.a(paramActionSheetItem).a(this.jdField_a_of_type_Ayao.mContext, BaseApplicationImpl.getApplication().getRuntime().getAccount());
                  bivo.a(null, 3, 0, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int);
                  bivo.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
                  i = j;
                  continue;
                  paramActionSheetItem = new Intent("android.intent.action.VIEW");
                  paramActionSheetItem.setDataAndType(Uri.parse("file://" + this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_JavaLangString), "video/*");
                  paramActionSheetItem.putExtra("big_brother_source_key", " biz_src_jc_video");
                  this.jdField_a_of_type_Ayao.mContext.startActivity(paramActionSheetItem);
                  i = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int;
                  if (i == 0)
                  {
                    azqs.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
                    i = 7;
                  }
                  else if (i == 3000)
                  {
                    azqs.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
                    i = 7;
                  }
                  else if (i == 1)
                  {
                    azqs.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
                    i = 7;
                  }
                  else
                  {
                    azqs.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
                    i = 7;
                    continue;
                    j = 6;
                    i = j;
                    if (RichMediaBrowserManager.getInstance().getProvider() != null)
                    {
                      i = j;
                      if (RichMediaBrowserManager.getInstance().getProvider().isPingBinder())
                      {
                        RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_a_of_type_Long);
                        QQToast.a(this.jdField_a_of_type_Ayao.mContext, this.jdField_a_of_type_Ayao.mContext.getString(2131692914), 0).a();
                        i = j;
                        continue;
                        paramShareActionSheet = new Intent(this.jdField_a_of_type_Ayao.mContext, ScannerActivity.class);
                        paramShareActionSheet.putExtra("detectType", 1);
                        paramShareActionSheet.putExtra("preResult", paramActionSheetItem.argus);
                        paramShareActionSheet.putExtra("QRDecode", true);
                        axzh.a(this.jdField_a_of_type_Ayao.mContext, ayao.a(this.jdField_a_of_type_Ayao), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_JavaLangString, "", "", "", 1, axyd.a().d(), axyd.a().c(), paramShareActionSheet);
                        ayao.a(this.jdField_a_of_type_Ayao, "0X800ACB7", this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int);
                        i = 0;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        paramShareActionSheet = new Intent(this.jdField_a_of_type_Ayao.mContext, ScannerActivity.class);
        paramShareActionSheet.putExtra("detectType", 2);
        paramShareActionSheet.putExtra("preResult", paramActionSheetItem.argus);
        paramShareActionSheet.putExtra("QRDecode", true);
        axzh.a(this.jdField_a_of_type_Ayao.mContext, ayao.a(this.jdField_a_of_type_Ayao), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_JavaLangString, "", "", "", 2, axyd.a().d(), axyd.a().c(), paramShareActionSheet);
        ayao.a(this.jdField_a_of_type_Ayao, "0X800ACB8", this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int);
      }
    } while (paramActionSheetItem.jdField_d_of_type_Int != 1);
    azqs.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayar
 * JD-Core Version:    0.7.0.1
 */