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

class aqpf
  implements bcvg
{
  aqpf(aqoz paramaqoz, AIOPicData paramAIOPicData, aqmi paramaqmi, File paramFile) {}
  
  public void a(bbjs parambbjs, bcvf parambcvf)
  {
    int j = parambbjs.jdField_c_of_type_Int;
    parambcvf = parambbjs.b;
    if (j != 72) {
      this.jdField_a_of_type_Aqoz.jdField_a_of_type_Bcvf.b();
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
      axqy.b(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", i, 0, "", "", "", "");
      return;
      i = 12;
      aqmd.a().a().a("AIOGalleryPicView", 4, "action sheet add to favorite.");
      parambbjs = new Bundle();
      parambbjs.putString("pic_md5", this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.f);
      parambcvf = new aqpg(this);
      QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_add_fav", parambbjs, parambcvf);
      if (this.jdField_a_of_type_Aqoz.jdField_d_of_type_Boolean)
      {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
        i = 12;
        continue;
        i = 1;
        this.jdField_a_of_type_Aqoz.a("Pic_Forward_Contacts", 0);
        parambcvf = new aqnl();
        parambcvf.jdField_a_of_type_Int = j;
        if (j == 72)
        {
          parambcvf.jdField_a_of_type_JavaLangString = parambbjs.jdField_c_of_type_JavaLangString;
          parambcvf.jdField_b_of_type_Int = parambbjs.f;
        }
        aqnj localaqnj = this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqnj;
        aqmi localaqmi = this.jdField_a_of_type_Aqmi;
        Activity localActivity = this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity;
        if (this.jdField_a_of_type_Aqoz.jdField_d_of_type_Boolean) {}
        for (parambbjs = "biz_src_jc_groupgif";; parambbjs = "biz_src_jc_photo")
        {
          localaqnj.a(localaqmi, localActivity, parambcvf, 100500, parambbjs);
          if (this.jdField_a_of_type_Aqoz.jdField_d_of_type_Boolean) {
            VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
          }
          if (!this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.c()) {
            break label2101;
          }
          asuh.a("0X8009ABA");
          i = 1;
          break;
        }
        i = 4;
        this.jdField_a_of_type_Aqoz.a("Pic_Forward_Qzone", 0);
        aqnq.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.d(), this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.b(), this.jdField_a_of_type_Aqoz.jdField_d_of_type_Int, this.jdField_a_of_type_Aqmi, this.jdField_a_of_type_Aqoz.c, this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.a());
        if (this.jdField_a_of_type_Aqoz.jdField_d_of_type_Boolean)
        {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
          i = 4;
          continue;
          if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.d() + "__qzone_pic_permission__" + this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.a(), -1, Long.valueOf(this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.d()).longValue()) == 0)
          {
            parambbjs = new bbgu(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, 2131755791);
            parambbjs.setContentView(2131558906);
            parambbjs.setTitle(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity.getString(2131697920));
            parambbjs.setMessage(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity.getString(2131697918));
            parambbjs.setNegativeButton(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity.getString(2131697919), new aqph(this));
            parambbjs.setCanceledOnTouchOutside(false);
            parambbjs.setCancelable(false);
            parambbjs.show();
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.d(), "40", "1");
            i = 5;
          }
          else
          {
            this.jdField_a_of_type_Aqoz.a("Pic_Forward_Grpalbum", 0);
            aqnq.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.d(), this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.a(), this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.b(), this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.e, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.g, -1);
            i = 5;
            continue;
            if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity))
            {
              CheckPermission.requestStorePermission(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, null);
              return;
            }
            this.jdField_a_of_type_Aqoz.a("Pic_save", 0);
            parambbjs = new aqmq();
            if ((parambbjs.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData, 4) == null) && (parambbjs.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData, 4)) && (AppNetConnInfo.isNetSupport())) {
              if ((!AppNetConnInfo.isWifiConn()) && (this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.c > 29360128L)) {
                this.jdField_a_of_type_Aqoz.a(1, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData, this.jdField_a_of_type_Aqmi);
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_Aqoz.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 55);
              if (this.jdField_a_of_type_Aqoz.jdField_d_of_type_Boolean) {
                VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
              }
              if (this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.c()) {
                asuh.a("0X8009ABB");
              }
              aqmd.a().a().a("AIOGalleryPicView", 2, "ACTION_GALLERY_PIC_SAVE");
              i = 2;
              break;
              this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqnj.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData);
              this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqnj.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_Int, 3);
              this.jdField_a_of_type_Aqoz.j();
              continue;
              aqnq.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
            }
            parambbjs = new Intent();
            parambbjs.putExtra("preResult", parambcvf);
            aqnx.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqoz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.f, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.j, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.e, 1, this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.d(), this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.c(), parambbjs);
            axqy.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
            i = 9;
            continue;
            parambbjs = new Intent();
            parambbjs.putExtra("preResult", parambcvf);
            aqnx.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqoz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.f, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.j, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.e, 2, this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.d(), this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.c(), parambbjs);
            i = 10;
            continue;
            i = 3;
            for (;;)
            {
              try
              {
                parambbjs = this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqnj.a(this.jdField_a_of_type_Aqmi.a.jdField_a_of_type_Long, this.jdField_a_of_type_Aqmi.a.jdField_a_of_type_Int);
                if (parambbjs != null) {
                  break label1547;
                }
                bgpu.b(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()).a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.d());
                bgqi.a(null, 40, 3);
              }
              catch (RemoteException parambbjs)
              {
                aqmd.a().a().a("AIOGalleryPicView", 4, "ACTION_GALLERY_PIC_FAVORITE exception = " + parambbjs.getMessage());
                bcql.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity.getString(2131692902), 0).a();
              }
              break;
              new bgpu(parambbjs).a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.d());
            }
            i = 8;
            OCRPerformFragment.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.f);
            continue;
            j = 6;
            if (this.jdField_a_of_type_Aqoz.jdField_d_of_type_Boolean)
            {
              aqmd.a().a().a("AIOGalleryPicView", 4, "action sheet share weiyun.");
              parambbjs = new Bundle();
              parambbjs.putString("pic_md5", this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.f);
              QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_upload_wy", parambbjs, null);
              VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
              i = 6;
            }
            else
            {
              i = j;
              if (this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_Long > 0L)
              {
                i = j;
                if (this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqnj.e())
                {
                  this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqnj.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_a_of_type_Long);
                  bcql.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity.getString(2131692830), 0).a();
                  i = 6;
                  continue;
                  parambbjs = this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.a();
                  if (TextUtils.isEmpty(parambbjs)) {
                    parambbjs = this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.c();
                  }
                  for (;;)
                  {
                    axqy.b(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.c(), 0, "", "", "", "");
                    aqnx.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.a(), this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.c(), parambbjs, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.d, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_b_of_type_Int, false);
                    i = 7;
                    break label174;
                    parambbjs = BaseApplicationImpl.getApplication().getRuntime();
                    if (parambbjs == null) {
                      break;
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_m_of_type_Boolean)
                    {
                      this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqnj.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.a(), true, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_m_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.l, parambbjs.getAccount(), this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.n);
                      i = 0;
                      break label174;
                    }
                    this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqnj.a(this.jdField_a_of_type_Aqoz.jdField_a_of_type_Aqmo.a(), false, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.l, parambbjs.getAccount(), this.jdField_a_of_type_ComTencentMobileqqGalleryModelPicAIOPicData.n);
                    i = 0;
                    break label174;
                    PicShareToWX.a(this.jdField_a_of_type_JavaIoFile.getPath(), this.jdField_a_of_type_Aqoz.jdField_a_of_type_AndroidAppActivity, 1);
                    axqy.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
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
 * Qualified Name:     aqpf
 * JD-Core Version:    0.7.0.1
 */