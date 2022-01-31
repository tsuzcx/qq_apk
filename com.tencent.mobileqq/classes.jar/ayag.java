import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import mqq.app.AppRuntime;

class ayag
  implements ShareActionSheet.OnItemClickListener
{
  ayag(ayaa paramayaa, AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int j = paramActionSheetItem.action;
    paramShareActionSheet = paramActionSheetItem.argus;
    if (j != 72) {
      this.jdField_a_of_type_Ayaa.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
    }
    int i;
    switch (j)
    {
    default: 
      i = 0;
    }
    label174:
    label2113:
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", i, 0, "", "", "", "");
      return;
      i = 12;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "action sheet add to favorite.");
      paramActionSheetItem = new Bundle();
      paramActionSheetItem.putString("pic_md5", this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f);
      paramShareActionSheet = new ayah(this);
      QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_add_fav", paramActionSheetItem, paramShareActionSheet);
      if (this.jdField_a_of_type_Ayaa.b)
      {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
        i = 12;
        continue;
        i = 1;
        if (RichMediaBrowserManager.getInstance().getProvider() != null) {
          RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_Forward_Contacts", 0);
        }
        paramShareActionSheet = new axyx();
        paramShareActionSheet.jdField_a_of_type_Int = j;
        if (j == 72)
        {
          paramShareActionSheet.jdField_a_of_type_JavaLangString = paramActionSheetItem.uin;
          paramShareActionSheet.jdField_b_of_type_Int = paramActionSheetItem.uinType;
        }
        axyv localaxyv = ayaa.a(this.jdField_a_of_type_Ayaa);
        RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo;
        Activity localActivity = this.jdField_a_of_type_Ayaa.mContext;
        if (this.jdField_a_of_type_Ayaa.b) {}
        for (paramActionSheetItem = "biz_src_jc_groupgif";; paramActionSheetItem = "biz_src_jc_photo")
        {
          localaxyv.a(localRichMediaBrowserInfo, localActivity, paramShareActionSheet, 100500, paramActionSheetItem);
          if (this.jdField_a_of_type_Ayaa.b) {
            VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
          }
          if (!axyd.a().c()) {
            break label2113;
          }
          aupn.a("0X8009ABA");
          i = 1;
          break;
        }
        i = 4;
        if (RichMediaBrowserManager.getInstance().getProvider() != null) {
          RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_Forward_Qzone", 0);
        }
        axza.a(this.jdField_a_of_type_Ayaa.mContext, axyd.a().d(), axyd.a().b(), this.jdField_a_of_type_Ayaa.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo, this.jdField_a_of_type_Ayaa.jdField_a_of_type_Boolean, axyd.a().a());
        if (this.jdField_a_of_type_Ayaa.b)
        {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
          i = 4;
          continue;
          if (LocalMultiProcConfig.getInt4Uin(axyd.a().d() + "__qzone_pic_permission__" + axyd.a().a(), -1, Long.valueOf(axyd.a().d()).longValue()) == 0)
          {
            paramActionSheetItem = new bdjz(this.jdField_a_of_type_Ayaa.mContext, 2131755801);
            paramActionSheetItem.setContentView(2131558942);
            paramActionSheetItem.setTitle(this.jdField_a_of_type_Ayaa.mContext.getString(2131698099));
            paramActionSheetItem.setMessage(this.jdField_a_of_type_Ayaa.mContext.getString(2131698097));
            paramActionSheetItem.setNegativeButton(this.jdField_a_of_type_Ayaa.mContext.getString(2131698098), new ayai(this));
            paramActionSheetItem.setCanceledOnTouchOutside(false);
            paramActionSheetItem.setCancelable(false);
            paramActionSheetItem.show();
            QZoneClickReport.startReportImediately(axyd.a().d(), "40", "1");
            i = 5;
          }
          else
          {
            if (RichMediaBrowserManager.getInstance().getProvider() != null) {
              RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_Forward_Grpalbum", 0);
            }
            axza.a(this.jdField_a_of_type_Ayaa.mContext, axyd.a().d(), axyd.a().a(), axyd.a().b(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.e, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.g, -1);
            i = 5;
            continue;
            if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_Ayaa.mContext))
            {
              CheckPermission.requestStorePermission(this.jdField_a_of_type_Ayaa.mContext, null);
              return;
            }
            if (RichMediaBrowserManager.getInstance().getProvider() != null) {
              RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_save", 0);
            }
            paramActionSheetItem = new axyn();
            if ((paramActionSheetItem.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, 4) == null) && (paramActionSheetItem.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, 4)) && (AppNetConnInfo.isNetSupport())) {
              if ((!AppNetConnInfo.isWifiConn()) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.c > 29360128L)) {
                this.jdField_a_of_type_Ayaa.a(1, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo);
              }
            }
            for (;;)
            {
              if (RichMediaBrowserManager.getInstance().getProvider() != null) {
                RichMediaBrowserManager.getInstance().getProvider().reportData(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 55);
              }
              if (this.jdField_a_of_type_Ayaa.b) {
                VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
              }
              if (axyd.a().c()) {
                aupn.a("0X8009ABB");
              }
              BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 2, "ACTION_GALLERY_PIC_SAVE");
              i = 2;
              break;
              ayaa.a(this.jdField_a_of_type_Ayaa).a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData);
              ayaa.a(this.jdField_a_of_type_Ayaa).a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_Int, 3);
              this.jdField_a_of_type_Ayaa.updateUI();
              continue;
              axza.a(this.jdField_a_of_type_Ayaa.mContext, this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
            }
            paramActionSheetItem = new Intent();
            paramActionSheetItem.putExtra("preResult", paramShareActionSheet);
            axzh.a(this.jdField_a_of_type_Ayaa.mContext, this.jdField_a_of_type_Ayaa.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.j, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.e, 1, axyd.a().d(), axyd.a().c(), paramActionSheetItem);
            azqs.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
            i = 9;
            continue;
            paramActionSheetItem = new Intent();
            paramActionSheetItem.putExtra("preResult", paramShareActionSheet);
            axzh.a(this.jdField_a_of_type_Ayaa.mContext, this.jdField_a_of_type_Ayaa.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.j, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.e, 2, axyd.a().d(), axyd.a().c(), paramActionSheetItem);
            i = 10;
            continue;
            j = 3;
            for (;;)
            {
              try
              {
                paramActionSheetItem = (AIOBrowserBaseData)this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo.baseData;
                i = j;
                if (RichMediaBrowserManager.getInstance().getProvider() == null) {
                  break;
                }
                paramActionSheetItem = RichMediaBrowserManager.getInstance().getProvider().getFavorateParams(paramActionSheetItem.jdField_a_of_type_Long, paramActionSheetItem.jdField_a_of_type_Int);
                if (paramActionSheetItem != null) {
                  break label1566;
                }
                biva.b(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()).a(this.jdField_a_of_type_Ayaa.mContext, axyd.a().d());
                bivo.a(null, 40, 3);
                i = j;
              }
              catch (RemoteException paramActionSheetItem)
              {
                BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "ACTION_GALLERY_PIC_FAVORITE exception = " + paramActionSheetItem.getMessage());
                QQToast.a(this.jdField_a_of_type_Ayaa.mContext.getApplicationContext(), this.jdField_a_of_type_Ayaa.mContext.getString(2131692988), 0).a();
                i = j;
              }
              break;
              new biva(paramActionSheetItem).a(this.jdField_a_of_type_Ayaa.mContext, axyd.a().d());
            }
            i = 8;
            OCRPerformFragment.a(this.jdField_a_of_type_Ayaa.mContext, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f);
            continue;
            j = 6;
            if (this.jdField_a_of_type_Ayaa.b)
            {
              BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "action sheet share weiyun.");
              paramActionSheetItem = new Bundle();
              paramActionSheetItem.putString("pic_md5", this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.f);
              QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_upload_wy", paramActionSheetItem, null);
              VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
              i = 6;
            }
            else
            {
              i = j;
              if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_Long > 0L)
              {
                i = j;
                if (RichMediaBrowserManager.getInstance().getProvider() != null)
                {
                  i = j;
                  if (RichMediaBrowserManager.getInstance().getProvider().isPingBinder())
                  {
                    RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_a_of_type_Long);
                    QQToast.a(this.jdField_a_of_type_Ayaa.mContext, this.jdField_a_of_type_Ayaa.mContext.getString(2131692914), 0).a();
                    i = 6;
                    continue;
                    paramActionSheetItem = axyd.a().a();
                    if (TextUtils.isEmpty(paramActionSheetItem)) {
                      paramActionSheetItem = axyd.a().c();
                    }
                    for (;;)
                    {
                      azqs.b(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", axyd.a().c(), 0, "", "", "", "");
                      axzh.a(this.jdField_a_of_type_Ayaa.mContext, axyd.a().a(), axyd.a().c(), paramActionSheetItem, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.d, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_b_of_type_Int, false);
                      i = 7;
                      break label174;
                      paramActionSheetItem = BaseApplicationImpl.getApplication().getRuntime();
                      if ((paramActionSheetItem == null) || (RichMediaBrowserManager.getInstance().getProvider() == null)) {
                        break;
                      }
                      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_m_of_type_Boolean)
                      {
                        RichMediaBrowserManager.getInstance().getProvider().safetyReport(axyd.a().a(), true, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_m_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.l, paramActionSheetItem.getAccount(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.n);
                        i = 0;
                        break label174;
                      }
                      RichMediaBrowserManager.getInstance().getProvider().safetyReport(axyd.a().a(), false, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.l, paramActionSheetItem.getAccount(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserModelAIOPictureData.n);
                      i = 0;
                      break label174;
                      PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), this.jdField_a_of_type_Ayaa.mContext, 1);
                      azqs.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
                      break;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayag
 * JD-Core Version:    0.7.0.1
 */