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

class axwi
  implements ShareActionSheet.OnItemClickListener
{
  axwi(axwf paramaxwf, AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {}
    int i;
    label518:
    label1781:
    do
    {
      return;
      this.jdField_a_of_type_Axwf.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
      i = paramActionSheetItem.action;
      switch (i)
      {
      }
      for (;;)
      {
        i = 0;
        for (;;)
        {
          paramActionSheetItem = this.jdField_a_of_type_Axwf.jdField_a_of_type_Axup.getSelectedItem();
          if ((paramActionSheetItem == null) || (paramActionSheetItem.baseData == null) || (!AIOVideoData.class.isInstance(paramActionSheetItem.baseData))) {
            break;
          }
          paramActionSheetItem = (AIOVideoData)paramActionSheetItem.baseData;
          if (paramActionSheetItem.jdField_d_of_type_Int != 0) {
            break label1781;
          }
          azmj.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
          return;
          int j = 1;
          if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
          {
            paramShareActionSheet = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_a_of_type_Int, axtu.a().a());
            if (paramShareActionSheet != null)
            {
              paramShareActionSheet.putExtra("NeedReportForwardShortVideo", true);
              if (this.jdField_a_of_type_Axwf.jdField_a_of_type_Axup.getSelectedItem() != null)
              {
                Object localObject = this.jdField_a_of_type_Axwf.jdField_a_of_type_Axup.getSelectedItem().baseData;
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
              arum.a(this.jdField_a_of_type_Axwf.mContext, paramShareActionSheet, ForwardRecentTranslucentActivity.class, 19005, 100500, " biz_src_jc_video");
            }
          }
          for (;;)
          {
            i = j;
            if (!axtu.a().c()) {
              break;
            }
            aule.a("0X8009ABC");
            i = j;
            break;
            arum.a(this.jdField_a_of_type_Axwf.mContext, paramShareActionSheet, 100500, " biz_src_jc_video");
          }
          paramActionSheetItem = bizt.a();
          paramActionSheetItem.a = axtu.a().d();
          bizm.c(this.jdField_a_of_type_Axwf.mContext, paramActionSheetItem, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
          azmj.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
          i = 4;
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.j == 5002)
          {
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "video file is expired");
            QQToast.a(this.jdField_a_of_type_Axwf.mContext, 1, alpo.a(2131700403), 0).a();
            return;
          }
          if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_Axwf.mContext))
          {
            CheckPermission.requestStorePermission(this.jdField_a_of_type_Axwf.mContext, null);
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_Int == 1)
          {
            this.jdField_a_of_type_Axwf.jdField_a_of_type_Axup.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaIoFile);
            i = 0;
          }
          else if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_JavaIoFile.length() == this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_c_of_type_Long))
          {
            paramActionSheetItem = new StringBuilder().append(this.jdField_a_of_type_JavaIoFile.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4";
            ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Axwf.jdField_a_of_type_Axup.a, paramActionSheetItem, false));
            i = 0;
          }
          else if (!AppNetConnInfo.isNetSupport())
          {
            this.jdField_a_of_type_Axwf.jdField_a_of_type_Axup.a.sendEmptyMessage(10001);
            i = 0;
          }
          else if ((!AppNetConnInfo.isWifiConn()) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_c_of_type_Long > 29360128L))
          {
            this.jdField_a_of_type_Axwf.a(3, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo);
            i = 0;
          }
          else
          {
            this.jdField_a_of_type_Axwf.jdField_a_of_type_Axup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData);
            this.jdField_a_of_type_Axwf.jdField_a_of_type_Axup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_a_of_type_Int, 2);
            this.jdField_a_of_type_Axwf.updateUI();
            if (this.jdField_a_of_type_Axwf.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
              this.jdField_a_of_type_Axwf.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
            }
            axwf.b(this.jdField_a_of_type_Axwf, false);
            i = 0;
            continue;
            azmj.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", axtu.a().c(), 0, "", "", "", "");
            paramShareActionSheet = axtu.a().a();
            paramActionSheetItem = paramShareActionSheet;
            if (TextUtils.isEmpty(paramShareActionSheet)) {
              paramActionSheetItem = axtu.a().c();
            }
            axuy.a(this.jdField_a_of_type_Axwf.mContext, axtu.a().a(), axtu.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false);
            i = 6;
            continue;
            j = 3;
            i = j;
            if (RichMediaBrowserManager.getInstance().getProvider() != null)
            {
              i = j;
              if (RichMediaBrowserManager.getInstance().getProvider().isPingBinder())
              {
                paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getForwardData(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_a_of_type_Int, axtu.a().a());
                i = j;
                if (paramActionSheetItem != null)
                {
                  biqt.a(paramActionSheetItem).a(this.jdField_a_of_type_Axwf.mContext, BaseApplicationImpl.getApplication().getRuntime().getAccount());
                  birh.a(null, 3, 0, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int);
                  birh.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
                  i = j;
                  continue;
                  paramActionSheetItem = new Intent("android.intent.action.VIEW");
                  paramActionSheetItem.setDataAndType(Uri.parse("file://" + this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_JavaLangString), "video/*");
                  paramActionSheetItem.putExtra("big_brother_source_key", " biz_src_jc_video");
                  this.jdField_a_of_type_Axwf.mContext.startActivity(paramActionSheetItem);
                  i = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int;
                  if (i == 0)
                  {
                    azmj.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
                    i = 7;
                  }
                  else if (i == 3000)
                  {
                    azmj.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
                    i = 7;
                  }
                  else if (i == 1)
                  {
                    azmj.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
                    i = 7;
                  }
                  else
                  {
                    azmj.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
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
                        QQToast.a(this.jdField_a_of_type_Axwf.mContext, this.jdField_a_of_type_Axwf.mContext.getString(2131692912), 0).a();
                        i = j;
                        continue;
                        paramShareActionSheet = new Intent(this.jdField_a_of_type_Axwf.mContext, ScannerActivity.class);
                        paramShareActionSheet.putExtra("detectType", 1);
                        paramShareActionSheet.putExtra("preResult", paramActionSheetItem.argus);
                        paramShareActionSheet.putExtra("QRDecode", true);
                        axuy.a(this.jdField_a_of_type_Axwf.mContext, axwf.a(this.jdField_a_of_type_Axwf), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_JavaLangString, "", "", "", 1, axtu.a().d(), axtu.a().c(), paramShareActionSheet);
                        axwf.a(this.jdField_a_of_type_Axwf, "0X800ACB7", this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int);
                        i = 0;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        paramShareActionSheet = new Intent(this.jdField_a_of_type_Axwf.mContext, ScannerActivity.class);
        paramShareActionSheet.putExtra("detectType", 2);
        paramShareActionSheet.putExtra("preResult", paramActionSheetItem.argus);
        paramShareActionSheet.putExtra("QRDecode", true);
        axuy.a(this.jdField_a_of_type_Axwf.mContext, axwf.a(this.jdField_a_of_type_Axwf), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_d_of_type_JavaLangString, "", "", "", 2, axtu.a().d(), axtu.a().c(), paramShareActionSheet);
        axwf.a(this.jdField_a_of_type_Axwf, "0X800ACB8", this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOVideoData.jdField_b_of_type_Int);
      }
    } while (paramActionSheetItem.jdField_d_of_type_Int != 1);
    azmj.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axwi
 * JD-Core Version:    0.7.0.1
 */