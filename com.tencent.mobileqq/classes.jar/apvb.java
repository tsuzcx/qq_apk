import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import mqq.app.AppRuntime;

class apvb
  implements AdapterView.OnItemClickListener
{
  apvb(apux paramapux, AIOPicData paramAIOPicData, apsr paramapsr, File paramFile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    this.jdField_a_of_type_Apux.jdField_a_of_type_Bahv.b();
    paramAdapterView = ((baia)paramAdapterView).a;
    paramInt = paramAdapterView.c;
    paramAdapterView = paramAdapterView.b;
    switch (paramInt)
    {
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 67: 
    case 68: 
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      label142:
      awqx.b(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", paramInt, 0, "", "", "", "");
      return;
      paramInt = 12;
      apsm.a().a().a("AIOGalleryPicView", 4, "action sheet add to favorite.");
      paramAdapterView = new Bundle();
      paramAdapterView.putString("pic_md5", this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.f);
      paramView = new apvc(this);
      QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_add_fav", paramAdapterView, paramView);
      if (this.jdField_a_of_type_Apux.jdField_d_of_type_Boolean)
      {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
        paramInt = 12;
        continue;
        paramInt = 1;
        this.jdField_a_of_type_Apux.a("Pic_Forward_Contacts", 0);
        this.jdField_a_of_type_Apux.jdField_a_of_type_Apti.a(this.jdField_a_of_type_Apsr, this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity);
        if (this.jdField_a_of_type_Apux.jdField_d_of_type_Boolean) {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
        }
        if (this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.c())
        {
          aryb.a("0X8009ABA");
          paramInt = 1;
          continue;
          paramInt = 4;
          this.jdField_a_of_type_Apux.a("Pic_Forward_Qzone", 0);
          apto.a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.d(), this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.b(), this.jdField_a_of_type_Apux.jdField_d_of_type_Int, this.jdField_a_of_type_Apsr, this.jdField_a_of_type_Apux.c, this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.a());
          if (this.jdField_a_of_type_Apux.jdField_d_of_type_Boolean)
          {
            VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
            paramInt = 4;
            continue;
            if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.d() + "__qzone_pic_permission__" + this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.a(), -1, Long.valueOf(this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.d()).longValue()) == 0)
            {
              paramAdapterView = new bafb(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, 2131690181);
              paramAdapterView.setContentView(2131493345);
              paramAdapterView.setTitle(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity.getString(2131632185));
              paramAdapterView.setMessage(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity.getString(2131632183));
              paramAdapterView.setNegativeButton(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity.getString(2131632184), new apvd(this));
              paramAdapterView.setCanceledOnTouchOutside(false);
              paramAdapterView.setCancelable(false);
              paramAdapterView.show();
              QZoneClickReport.startReportImediately(this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.d(), "40", "1");
              paramInt = 5;
            }
            else
            {
              this.jdField_a_of_type_Apux.a("Pic_Forward_Grpalbum", 0);
              apto.a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.d(), this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.a(), this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.b(), this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.e, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.g, -1);
              paramInt = 5;
              continue;
              this.jdField_a_of_type_Apux.a("Pic_save", 0);
              paramAdapterView = new apsz();
              if ((paramAdapterView.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData, 4) == null) && (paramAdapterView.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData, 4)) && (AppNetConnInfo.isNetSupport())) {
                if ((!AppNetConnInfo.isWifiConn()) && (this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.c > 29360128L)) {
                  this.jdField_a_of_type_Apux.a(1, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData, this.jdField_a_of_type_Apsr);
                }
              }
              for (;;)
              {
                this.jdField_a_of_type_Apux.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 55);
                if (this.jdField_a_of_type_Apux.jdField_d_of_type_Boolean) {
                  VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
                }
                if (this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.c()) {
                  aryb.a("0X8009ABB");
                }
                apsm.a().a().a("AIOGalleryPicView", 2, "ACTION_GALLERY_PIC_SAVE");
                paramInt = 2;
                break;
                this.jdField_a_of_type_Apux.jdField_a_of_type_Apti.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData);
                this.jdField_a_of_type_Apux.jdField_a_of_type_Apti.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_Int, 3);
                this.jdField_a_of_type_Apux.j();
                continue;
                apto.a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
              }
              paramView = new Intent();
              paramView.putExtra("preResult", paramAdapterView);
              aptv.a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apux.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.f, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.j, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.e, 1, this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.d(), this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.c(), paramView);
              awqx.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
              paramInt = 9;
              continue;
              paramView = new Intent();
              paramView.putExtra("preResult", paramAdapterView);
              aptv.a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apux.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.f, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.j, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.e, 2, this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.d(), this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.c(), paramView);
              paramInt = 10;
              continue;
              paramInt = 3;
              for (;;)
              {
                try
                {
                  paramAdapterView = this.jdField_a_of_type_Apux.jdField_a_of_type_Apti.a(this.jdField_a_of_type_Apsr.a.jdField_a_of_type_Long, this.jdField_a_of_type_Apsr.a.jdField_a_of_type_Int);
                  if (paramAdapterView != null) {
                    break label1418;
                  }
                  bfhl.b(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()).a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.d());
                  bfhz.a(null, 40, 3);
                }
                catch (RemoteException paramAdapterView)
                {
                  apsm.a().a().a("AIOGalleryPicView", 4, "ACTION_GALLERY_PIC_FAVORITE exception = " + paramAdapterView.getMessage());
                  bbmy.a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity.getString(2131627263), 0).a();
                }
                break;
                label1418:
                new bfhl(paramAdapterView).a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.d());
              }
              paramInt = 8;
              OCRResultActivity.a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1);
              continue;
              int i = 6;
              if (this.jdField_a_of_type_Apux.jdField_d_of_type_Boolean)
              {
                apsm.a().a().a("AIOGalleryPicView", 4, "action sheet share weiyun.");
                paramAdapterView = new Bundle();
                paramAdapterView.putString("pic_md5", this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.f);
                QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_upload_wy", paramAdapterView, null);
                VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
                paramInt = 6;
              }
              else
              {
                paramInt = i;
                if (this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_Long > 0L)
                {
                  paramInt = i;
                  if (this.jdField_a_of_type_Apux.jdField_a_of_type_Apti.e())
                  {
                    this.jdField_a_of_type_Apux.jdField_a_of_type_Apti.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_Long);
                    bbmy.a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity.getString(2131627191), 0).a();
                    paramInt = 6;
                    continue;
                    paramAdapterView = this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.a();
                    if (TextUtils.isEmpty(paramAdapterView)) {
                      paramAdapterView = this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.c();
                    }
                    for (;;)
                    {
                      awqx.b(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.c(), 0, "", "", "", "");
                      aptv.a(this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.a(), this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.c(), paramAdapterView, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.d, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_b_of_type_Int, false);
                      paramInt = 7;
                      break label142;
                      paramAdapterView = BaseApplicationImpl.getApplication().getRuntime();
                      if (paramAdapterView == null) {
                        break;
                      }
                      if (this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_m_of_type_Boolean)
                      {
                        this.jdField_a_of_type_Apux.jdField_a_of_type_Apti.a(this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.a(), true, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_m_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.l, paramAdapterView.getAccount(), this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.n);
                        paramInt = 0;
                        break label142;
                      }
                      this.jdField_a_of_type_Apux.jdField_a_of_type_Apti.a(this.jdField_a_of_type_Apux.jdField_a_of_type_Apsx.a(), false, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.l, paramAdapterView.getAccount(), this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.n);
                      paramInt = 0;
                      break label142;
                      PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), this.jdField_a_of_type_Apux.jdField_a_of_type_AndroidAppActivity, 1);
                      awqx.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apvb
 * JD-Core Version:    0.7.0.1
 */