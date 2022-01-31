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

class aqpu
  implements bcur
{
  aqpu(aqpr paramaqpr, AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, aqmg paramaqmg) {}
  
  public void a(bbje parambbje, bcuq parambcuq)
  {
    int i = 0;
    if (parambbje == null) {}
    label487:
    do
    {
      return;
      this.jdField_a_of_type_Aqpr.jdField_a_of_type_Bcuq.b();
      int k = parambbje.jdField_c_of_type_Int;
      switch (k)
      {
      }
      for (;;)
      {
        parambbje = this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqnm.a();
        if ((parambbje == null) || (parambbje.a == null) || (!AIOShortVideoData.class.isInstance(parambbje.a))) {
          break;
        }
        parambbje = (AIOShortVideoData)parambbje.a;
        if (parambbje.jdField_d_of_type_Int != 0) {
          break label1464;
        }
        axqw.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
        return;
        int j = 1;
        if (this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqnm.e())
        {
          parambcuq = this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Int, this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqmm.a());
          if (parambcuq != null)
          {
            parambcuq.putExtra("NeedReportForwardShortVideo", true);
            if (this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqnm.a() != null)
            {
              Object localObject = this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqnm.a().a;
              if ((localObject instanceof AIOShortVideoData))
              {
                localObject = (AIOShortVideoData)localObject;
                i = ((AIOShortVideoData)localObject).jdField_g_of_type_Int;
                AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
                if ((i == LocalMediaInfo.REDBAG_TYPE_GET) && (localAppRuntime.getAccount().equals(((AIOShortVideoData)localObject).jdField_d_of_type_JavaLangString)))
                {
                  parambcuq.putExtra("param_key_redbag_type", i);
                  parambcuq.putExtra("param_key_redbag_video_id", ((AIOShortVideoData)localObject).jdField_c_of_type_JavaLangString);
                  parambcuq.putExtra("from_session_uin", ((AIOShortVideoData)localObject).e);
                }
                if (((AIOShortVideoData)localObject).k == 2) {
                  parambcuq.putExtra("special_video_type", ((AIOShortVideoData)localObject).k);
                }
                if (!TextUtils.isEmpty(((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString)) {
                  parambcuq.putExtra("widgetinfo", ((AIOShortVideoData)localObject).jdField_g_of_type_JavaLangString);
                }
              }
            }
            if (k != 72) {
              break label487;
            }
            parambcuq.putExtra("key_req", ForwardRecentActivity.f);
            parambcuq.putExtra("key_direct_show_uin_type", parambbje.f);
            parambcuq.putExtra("key_direct_show_uin", parambbje.jdField_c_of_type_JavaLangString);
            aqbc.a(this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity, parambcuq, ForwardRecentTranslucentActivity.class, 19005, 100500, " biz_src_jc_video");
          }
        }
        for (;;)
        {
          i = j;
          if (!this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqmm.c()) {
            break;
          }
          asuf.a("0X8009ABC");
          i = j;
          break;
          aqbc.a(this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity, parambcuq, 100500, " biz_src_jc_video");
        }
        parambbje = bgyf.a();
        parambbje.a = this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqmm.d();
        bgxy.c(this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity, parambbje, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
        axqw.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
        i = 4;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.j == 5002)
        {
          aqmb.a().a().a("AIOGalleryVideoView", 4, "video file is expired");
          bcpw.a(this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity, 1, ajyc.a(2131700023), 0).a();
          return;
        }
        if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity))
        {
          CheckPermission.requestStorePermission(this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity, null);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_d_of_type_Int == 1)
        {
          this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaIoFile);
        }
        else if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_JavaIoFile.length() == this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_c_of_type_Long))
        {
          parambbje = new StringBuilder().append(this.jdField_a_of_type_JavaIoFile.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4";
          ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqnm.a, parambbje, false));
        }
        else if (!AppNetConnInfo.isNetSupport())
        {
          this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqnm.a.sendEmptyMessage(10001);
        }
        else if ((!AppNetConnInfo.isWifiConn()) && (this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_c_of_type_Long > 29360128L))
        {
          this.jdField_a_of_type_Aqpr.a(3, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData, this.jdField_a_of_type_Aqmg);
        }
        else
        {
          this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData);
          this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Int, 2);
          this.jdField_a_of_type_Aqpr.j();
          continue;
          axqw.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqmm.c(), 0, "", "", "", "");
          parambcuq = this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqmm.a();
          parambbje = parambcuq;
          if (TextUtils.isEmpty(parambcuq)) {
            parambbje = this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqmm.c();
          }
          aqnv.a(this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqmm.a(), this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqmm.c(), parambbje, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_b_of_type_Int, false);
          i = 6;
          continue;
          j = 3;
          i = j;
          if (this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqnm.e())
          {
            parambbje = this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Int, this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqmm.a());
            i = j;
            if (parambbje != null)
            {
              bgpd.a(parambbje).a(this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity, BaseApplicationImpl.getApplication().getRuntime().getAccount());
              bgpr.a(null, 3, 0, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_b_of_type_Int);
              bgpr.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
              i = j;
              continue;
              parambbje = new Intent("android.intent.action.VIEW");
              parambbje.setDataAndType(Uri.parse("file://" + this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_b_of_type_JavaLangString), "video/*");
              parambbje.putExtra("big_brother_source_key", " biz_src_jc_video");
              this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity.startActivity(parambbje);
              i = this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_b_of_type_Int;
              if (i == 0)
              {
                axqw.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
                i = 7;
              }
              else if (i == 3000)
              {
                axqw.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
                i = 7;
              }
              else if (i == 1)
              {
                axqw.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
                i = 7;
              }
              else
              {
                axqw.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
                i = 7;
                continue;
                j = 6;
                i = j;
                if (this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqnm.e())
                {
                  this.jdField_a_of_type_Aqpr.jdField_a_of_type_Aqnm.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Long);
                  bcpw.a(this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aqpr.jdField_a_of_type_AndroidAppActivity.getString(2131692829), 0).a();
                  i = j;
                }
              }
            }
          }
        }
      }
    } while (parambbje.jdField_d_of_type_Int != 1);
    label1464:
    axqw.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqpu
 * JD-Core Version:    0.7.0.1
 */