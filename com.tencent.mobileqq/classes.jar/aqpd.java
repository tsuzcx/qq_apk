import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.gallery.model.GalleryBaseData;
import com.tencent.mobileqq.gallery.model.pic.AIOPicData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import mqq.app.AppRuntime;

class aqpd
  implements bcur
{
  aqpd(aqox paramaqox, AIOPicData paramAIOPicData, aqmg paramaqmg, File paramFile) {}
  
  public void a(bbje parambbje, bcuq parambcuq)
  {
    int j = parambbje.jdField_c_of_type_Int;
    parambcuq = parambbje.b;
    if (j != 72) {
      this.jdField_a_of_type_Aqox.jdField_a_of_type_Bcuq.b();
    }
    int i;
    switch (j)
    {
    default: 
      i = 0;
    }
    label174:
    label2101:
    for (;;)
    {
      axqw.b(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", i, 0, "", "", "", "");
      return;
      i = 12;
      aqmb.a().a().a("AIOGalleryPicView", 4, "action sheet add to favorite.");
      parambbje = new Bundle();
      parambbje.putString("pic_md5", this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.f);
      parambcuq = new aqpe(this);
      QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_add_fav", parambbje, parambcuq);
      if (this.jdField_a_of_type_Aqox.jdField_d_of_type_Boolean)
      {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
        i = 12;
        continue;
        i = 1;
        this.jdField_a_of_type_Aqox.a("Pic_Forward_Contacts", 0);
        parambcuq = new aqnj();
        parambcuq.jdField_a_of_type_Int = j;
        if (j == 72)
        {
          parambcuq.jdField_a_of_type_JavaLangString = parambbje.jdField_c_of_type_JavaLangString;
          parambcuq.jdField_b_of_type_Int = parambbje.f;
        }
        aqnh localaqnh = this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqnh;
        aqmg localaqmg = this.jdField_a_of_type_Aqmg;
        Activity localActivity = this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity;
        if (this.jdField_a_of_type_Aqox.jdField_d_of_type_Boolean) {}
        for (parambbje = "biz_src_jc_groupgif";; parambbje = "biz_src_jc_photo")
        {
          localaqnh.a(localaqmg, localActivity, parambcuq, 100500, parambbje);
          if (this.jdField_a_of_type_Aqox.jdField_d_of_type_Boolean) {
            VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
          }
          if (!this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.c()) {
            break label2101;
          }
          asuf.a("0X8009ABA");
          i = 1;
          break;
        }
        i = 4;
        this.jdField_a_of_type_Aqox.a("Pic_Forward_Qzone", 0);
        aqno.a(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.d(), this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.b(), this.jdField_a_of_type_Aqox.jdField_d_of_type_Int, this.jdField_a_of_type_Aqmg, this.jdField_a_of_type_Aqox.c, this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.a());
        if (this.jdField_a_of_type_Aqox.jdField_d_of_type_Boolean)
        {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
          i = 4;
          continue;
          if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.d() + "__qzone_pic_permission__" + this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.a(), -1, Long.valueOf(this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.d()).longValue()) == 0)
          {
            parambbje = new bbgg(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity, 2131755791);
            parambbje.setContentView(2131558906);
            parambbje.setTitle(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity.getString(2131697910));
            parambbje.setMessage(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity.getString(2131697908));
            parambbje.setNegativeButton(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity.getString(2131697909), new aqpf(this));
            parambbje.setCanceledOnTouchOutside(false);
            parambbje.setCancelable(false);
            parambbje.show();
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.d(), "40", "1");
            i = 5;
          }
          else
          {
            this.jdField_a_of_type_Aqox.a("Pic_Forward_Grpalbum", 0);
            aqno.a(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.d(), this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.a(), this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.b(), this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.e, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.g, -1);
            i = 5;
            continue;
            if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity))
            {
              CheckPermission.requestStorePermission(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity, null);
              return;
            }
            this.jdField_a_of_type_Aqox.a("Pic_save", 0);
            parambbje = new aqmo();
            if ((parambbje.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData, 4) == null) && (parambbje.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData, 4)) && (AppNetConnInfo.isNetSupport())) {
              if ((!AppNetConnInfo.isWifiConn()) && (this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.c > 29360128L)) {
                this.jdField_a_of_type_Aqox.a(1, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData, this.jdField_a_of_type_Aqmg);
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_Aqox.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 55);
              if (this.jdField_a_of_type_Aqox.jdField_d_of_type_Boolean) {
                VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
              }
              if (this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.c()) {
                asuf.a("0X8009ABB");
              }
              aqmb.a().a().a("AIOGalleryPicView", 2, "ACTION_GALLERY_PIC_SAVE");
              i = 2;
              break;
              this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqnh.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData);
              this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqnh.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_Int, 3);
              this.jdField_a_of_type_Aqox.j();
              continue;
              aqno.a(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
            }
            parambbje = new Intent();
            parambbje.putExtra("preResult", parambcuq);
            aqnv.a(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqox.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.f, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.j, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.e, 1, this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.d(), this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.c(), parambbje);
            axqw.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
            i = 9;
            continue;
            parambbje = new Intent();
            parambbje.putExtra("preResult", parambcuq);
            aqnv.a(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqox.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.f, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.j, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.e, 2, this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.d(), this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.c(), parambbje);
            i = 10;
            continue;
            i = 3;
            for (;;)
            {
              try
              {
                parambbje = this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqnh.a(this.jdField_a_of_type_Aqmg.a.jdField_a_of_type_Long, this.jdField_a_of_type_Aqmg.a.jdField_a_of_type_Int);
                if (parambbje != null) {
                  break label1547;
                }
                bgpd.b(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()).a(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.d());
                bgpr.a(null, 40, 3);
              }
              catch (RemoteException parambbje)
              {
                aqmb.a().a().a("AIOGalleryPicView", 4, "ACTION_GALLERY_PIC_FAVORITE exception = " + parambbje.getMessage());
                bcpw.a(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity.getString(2131692901), 0).a();
              }
              break;
              new bgpd(parambbje).a(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.d());
            }
            i = 8;
            OCRPerformFragment.a(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.f);
            continue;
            j = 6;
            if (this.jdField_a_of_type_Aqox.jdField_d_of_type_Boolean)
            {
              aqmb.a().a().a("AIOGalleryPicView", 4, "action sheet share weiyun.");
              parambbje = new Bundle();
              parambbje.putString("pic_md5", this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.f);
              QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_upload_wy", parambbje, null);
              VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
              i = 6;
            }
            else
            {
              i = j;
              if (this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_Long > 0L)
              {
                i = j;
                if (this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqnh.e())
                {
                  this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqnh.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_Long);
                  bcpw.a(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity.getString(2131692829), 0).a();
                  i = 6;
                  continue;
                  parambbje = this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.a();
                  if (TextUtils.isEmpty(parambbje)) {
                    parambbje = this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.c();
                  }
                  for (;;)
                  {
                    axqw.b(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.c(), 0, "", "", "", "");
                    aqnv.a(this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.a(), this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.c(), parambbje, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.d, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_b_of_type_Int, false);
                    i = 7;
                    break label174;
                    parambbje = BaseApplicationImpl.getApplication().getRuntime();
                    if (parambbje == null) {
                      break;
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_m_of_type_Boolean)
                    {
                      this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqnh.a(this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.a(), true, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_m_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.l, parambbje.getAccount(), this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.n);
                      i = 0;
                      break label174;
                    }
                    this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqnh.a(this.jdField_a_of_type_Aqox.jdField_a_of_type_Aqmm.a(), false, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.l, parambbje.getAccount(), this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.n);
                    i = 0;
                    break label174;
                    PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), this.jdField_a_of_type_Aqox.jdField_a_of_type_AndroidAppActivity, 1);
                    axqw.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqpd
 * JD-Core Version:    0.7.0.1
 */