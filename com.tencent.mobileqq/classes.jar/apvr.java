import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gallery.model.video.AIOShortVideoData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import java.io.File;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class apvr
  implements AdapterView.OnItemClickListener
{
  apvr(apvq paramapvq, AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, apsr paramapsr) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt = 0;
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {}
    label1317:
    do
    {
      return;
      this.jdField_a_of_type_Apvq.jdField_a_of_type_Bahv.b();
      switch (((baia)paramAdapterView).a.c)
      {
      }
      for (;;)
      {
        paramAdapterView = this.jdField_a_of_type_Apvq.jdField_a_of_type_Aptm.a();
        if ((paramAdapterView == null) || (paramAdapterView.a == null) || (!AIOShortVideoData.class.isInstance(paramAdapterView.a))) {
          break;
        }
        paramAdapterView = (AIOShortVideoData)paramAdapterView.a;
        if (paramAdapterView.jdField_d_of_type_Int != 0) {
          break label1317;
        }
        awqx.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", paramInt, 0, "", "", "", "");
        return;
        int i = 1;
        if (this.jdField_a_of_type_Apvq.jdField_a_of_type_Aptm.e())
        {
          paramAdapterView = this.jdField_a_of_type_Apvq.jdField_a_of_type_Aptm.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Int, this.jdField_a_of_type_Apvq.jdField_a_of_type_Apsx.a());
          if (paramAdapterView != null)
          {
            paramAdapterView.putExtra("NeedReportForwardShortVideo", true);
            if (this.jdField_a_of_type_Apvq.jdField_a_of_type_Aptm.a() != null)
            {
              paramView = this.jdField_a_of_type_Apvq.jdField_a_of_type_Aptm.a().a;
              if ((paramView instanceof AIOShortVideoData))
              {
                paramView = (AIOShortVideoData)paramView;
                paramInt = paramView.jdField_g_of_type_Int;
                AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
                if ((paramInt == LocalMediaInfo.REDBAG_TYPE_GET) && (localAppRuntime.getAccount().equals(paramView.jdField_d_of_type_JavaLangString)))
                {
                  paramAdapterView.putExtra("param_key_redbag_type", paramInt);
                  paramAdapterView.putExtra("param_key_redbag_video_id", paramView.jdField_c_of_type_JavaLangString);
                  paramAdapterView.putExtra("from_session_uin", paramView.e);
                }
                if (paramView.k == 2) {
                  paramAdapterView.putExtra("special_video_type", paramView.k);
                }
                if (!TextUtils.isEmpty(paramView.jdField_g_of_type_JavaLangString)) {
                  paramAdapterView.putExtra("widgetinfo", paramView.jdField_g_of_type_JavaLangString);
                }
              }
            }
            aphp.a(this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity, paramAdapterView);
          }
        }
        paramInt = i;
        if (this.jdField_a_of_type_Apvq.jdField_a_of_type_Apsx.c())
        {
          aryb.a("0X8009ABC");
          paramInt = i;
          continue;
          paramAdapterView = bfpy.a();
          paramAdapterView.a = this.jdField_a_of_type_Apvq.jdField_a_of_type_Apsx.d();
          bfpr.c(this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity, paramAdapterView, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
          awqx.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
          paramInt = 4;
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.j == 5002)
          {
            apsm.a().a().a("AIOGalleryVideoView", 4, "video file is expired");
            bbmy.a(this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity, 1, ajjy.a(2131634235), 0).a();
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_d_of_type_Int == 1)
          {
            this.jdField_a_of_type_Apvq.jdField_a_of_type_Aptm.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaIoFile);
          }
          else if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_JavaIoFile.length() == this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_c_of_type_Long))
          {
            paramAdapterView = new StringBuilder().append(this.jdField_a_of_type_JavaIoFile.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4";
            ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_Apvq.jdField_a_of_type_Aptm.a, paramAdapterView, false));
          }
          else if (!AppNetConnInfo.isNetSupport())
          {
            this.jdField_a_of_type_Apvq.jdField_a_of_type_Aptm.a.sendEmptyMessage(10001);
          }
          else if ((!AppNetConnInfo.isWifiConn()) && (this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_c_of_type_Long > 29360128L))
          {
            this.jdField_a_of_type_Apvq.a(3, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData, this.jdField_a_of_type_Apsr);
          }
          else
          {
            this.jdField_a_of_type_Apvq.jdField_a_of_type_Aptm.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData);
            this.jdField_a_of_type_Apvq.jdField_a_of_type_Aptm.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Int, 2);
            this.jdField_a_of_type_Apvq.j();
            continue;
            awqx.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", this.jdField_a_of_type_Apvq.jdField_a_of_type_Apsx.c(), 0, "", "", "", "");
            paramView = this.jdField_a_of_type_Apvq.jdField_a_of_type_Apsx.a();
            paramAdapterView = paramView;
            if (TextUtils.isEmpty(paramView)) {
              paramAdapterView = this.jdField_a_of_type_Apvq.jdField_a_of_type_Apsx.c();
            }
            aptv.a(this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apvq.jdField_a_of_type_Apsx.a(), this.jdField_a_of_type_Apvq.jdField_a_of_type_Apsx.c(), paramAdapterView, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_b_of_type_Int, false);
            paramInt = 6;
            continue;
            i = 3;
            paramInt = i;
            if (this.jdField_a_of_type_Apvq.jdField_a_of_type_Aptm.e())
            {
              paramAdapterView = this.jdField_a_of_type_Apvq.jdField_a_of_type_Aptm.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Int, this.jdField_a_of_type_Apvq.jdField_a_of_type_Apsx.a());
              paramInt = i;
              if (paramAdapterView != null)
              {
                bfhl.a(paramAdapterView).a(this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity, BaseApplicationImpl.getApplication().getRuntime().getAccount());
                bfhz.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
                paramInt = i;
                continue;
                paramAdapterView = new Intent("android.intent.action.VIEW");
                paramAdapterView.setDataAndType(Uri.parse("file://" + this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_b_of_type_JavaLangString), "video/*");
                paramAdapterView.putExtra("big_brother_source_key", " biz_src_jc_video");
                this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity.startActivity(paramAdapterView);
                paramInt = this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_b_of_type_Int;
                if (paramInt == 0)
                {
                  awqx.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
                  paramInt = 7;
                }
                else if (paramInt == 3000)
                {
                  awqx.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
                  paramInt = 7;
                }
                else if (paramInt == 1)
                {
                  awqx.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
                  paramInt = 7;
                }
                else
                {
                  awqx.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
                  paramInt = 7;
                  continue;
                  i = 6;
                  paramInt = i;
                  if (this.jdField_a_of_type_Apvq.jdField_a_of_type_Aptm.e())
                  {
                    this.jdField_a_of_type_Apvq.jdField_a_of_type_Aptm.a(this.jdField_a_of_type_ComTencentMobileqqGalleryModelVideoAIOShortVideoData.jdField_a_of_type_Long);
                    bbmy.a(this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apvq.jdField_a_of_type_AndroidAppActivity.getString(2131627191), 0).a();
                    paramInt = i;
                  }
                }
              }
            }
          }
        }
      }
    } while (paramAdapterView.jdField_d_of_type_Int != 1);
    awqx.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", paramInt, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apvr
 * JD-Core Version:    0.7.0.1
 */