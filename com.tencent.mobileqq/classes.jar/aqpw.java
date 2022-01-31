import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.startup.step.CheckPermission;
import java.io.File;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class aqpw
  implements bcvg
{
  aqpw(aqpt paramaqpt, AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, aqmi paramaqmi) {}
  
  public void a(bbjs parambbjs, bcvf parambcvf)
  {
    int i = 0;
    if (parambbjs == null) {}
    label487:
    do
    {
      return;
      this.jdField_a_of_type_Aqpt.jdField_a_of_type_Bcvf.b();
      int k = parambbjs.jdField_c_of_type_Int;
      switch (k)
      {
      }
      for (;;)
      {
        parambbjs = this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqno.a();
        if ((parambbjs == null) || (parambbjs.a == null) || (!AIOShortVideoData.class.isInstance(parambbjs.a))) {
          break;
        }
        parambbjs = (AIOShortVideoData)parambbjs.a;
        if (parambbjs.jdField_d_of_type_Int != 0) {
          break label1464;
        }
        axqy.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
        return;
        int j = 1;
        if (this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqno.e())
        {
          parambcvf = this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqno.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Int, this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqmo.a());
          if (parambcvf != null)
          {
            parambcvf.putExtra("NeedReportForwardShortVideo", true);
            if (this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqno.a() != null)
            {
              Object localObject = this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqno.a().a;
              if ((localObject instanceof AIOShortVideoData))
              {
                localObject = (AIOShortVideoData)localObject;
                i = ((AIOShortVideoData)localObject).jdField_g_of_type_Int;
                AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
                if ((i == LocalMediaInfo.REDBAG_TYPE_GET) && (localAppRuntime.getAccount().equals(((AIOShortVideoData)localObject).jdField_d_of_type_JavaLangString)))
                {
                  parambcvf.putExtra("param_key_redbag_type", i);
                  parambcvf.putExtra("param_key_redbag_video_id", ((AIOShortVideoData)localObject).jdField_c_of_type_JavaLangString);
                  parambcvf.putExtra("from_session_uin", ((AIOShortVideoData)localObject).e);
                }
                if (((AIOShortVideoData)localObject).k == 2) {
                  parambcvf.putExtra("special_video_type", ((AIOShortVideoData)localObject).k);
                }
                if (!TextUtils.isEmpty(((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString)) {
                  parambcvf.putExtra("widgetinfo", ((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString);
                }
              }
            }
            if (k != 72) {
              break label487;
            }
            parambcvf.putExtra("key_req", ForwardRecentActivity.f);
            parambcvf.putExtra("key_direct_show_uin_type", parambbjs.f);
            parambcvf.putExtra("key_direct_show_uin", parambbjs.jdField_c_of_type_JavaLangString);
            aqbe.a(this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity, parambcvf, ForwardRecentTranslucentActivity.class, 19005, 100500, " biz_src_jc_video");
          }
        }
        for (;;)
        {
          i = j;
          if (!this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqmo.c()) {
            break;
          }
          asuh.a("0X8009ABC");
          i = j;
          break;
          aqbe.a(this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity, parambcvf, 100500, " biz_src_jc_video");
        }
        parambbjs = bgyw.a();
        parambbjs.a = this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqmo.d();
        bgyp.c(this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity, parambbjs, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
        axqy.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
        i = 4;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.j == 5002)
        {
          aqmd.a().a().a("AIOGalleryVideoView", 4, "video file is expired");
          bcql.a(this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity, 1, ajya.a(2131700034), 0).a();
          return;
        }
        if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity))
        {
          CheckPermission.requestStorePermission(this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity, null);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_d_of_type_Int == 1)
        {
          this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqno.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaIoFile);
        }
        else if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_JavaIoFile.length() == this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_c_of_type_Long))
        {
          parambbjs = new StringBuilder().append(this.jdField_a_of_type_JavaIoFile.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4";
          ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqno.a, parambbjs, false));
        }
        else if (!AppNetConnInfo.isNetSupport())
        {
          this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqno.a.sendEmptyMessage(10001);
        }
        else if ((!AppNetConnInfo.isWifiConn()) && (this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_c_of_type_Long > 29360128L))
        {
          this.jdField_a_of_type_Aqpt.a(3, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData, this.jdField_a_of_type_Aqmi);
        }
        else
        {
          this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqno.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData);
          this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqno.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Int, 2);
          this.jdField_a_of_type_Aqpt.j();
          continue;
          axqy.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqmo.c(), 0, "", "", "", "");
          parambcvf = this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqmo.a();
          parambbjs = parambcvf;
          if (TextUtils.isEmpty(parambcvf)) {
            parambbjs = this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqmo.c();
          }
          aqnx.a(this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqmo.a(), this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqmo.c(), parambbjs, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_b_of_type_Int, false);
          i = 6;
          continue;
          j = 3;
          i = j;
          if (this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqno.e())
          {
            parambbjs = this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqno.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Int, this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqmo.a());
            i = j;
            if (parambbjs != null)
            {
              bgpu.a(parambbjs).a(this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity, BaseApplicationImpl.getApplication().getRuntime().getAccount());
              bgqi.a(null, 3, 0, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_b_of_type_Int);
              bgqi.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
              i = j;
              continue;
              parambbjs = new Intent("android.intent.action.VIEW");
              parambbjs.setDataAndType(Uri.parse("file://" + this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_b_of_type_JavaLangString), "video/*");
              parambbjs.putExtra("big_brother_source_key", " biz_src_jc_video");
              this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity.startActivity(parambbjs);
              i = this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_b_of_type_Int;
              if (i == 0)
              {
                axqy.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
                i = 7;
              }
              else if (i == 3000)
              {
                axqy.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
                i = 7;
              }
              else if (i == 1)
              {
                axqy.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
                i = 7;
              }
              else
              {
                axqy.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
                i = 7;
                continue;
                j = 6;
                i = j;
                if (this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqno.e())
                {
                  this.jdField_a_of_type_Aqpt.jdField_a_of_type_Aqno.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Long);
                  bcql.a(this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqpt.jdField_a_of_type_AndroidAppActivity.getString(2131692830), 0).a();
                  i = j;
                }
              }
            }
          }
        }
      }
    } while (parambbjs.jdField_d_of_type_Int != 1);
    label1464:
    axqy.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqpw
 * JD-Core Version:    0.7.0.1
 */