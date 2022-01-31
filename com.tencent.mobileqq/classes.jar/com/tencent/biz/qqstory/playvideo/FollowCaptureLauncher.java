package com.tencent.biz.qqstory.playvideo;

import actj;
import ajya;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import avte;
import bbdj;
import bbgu;
import bcpu;
import bcql;
import bkzs;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import suj;
import suy;
import svl;
import ttk;
import ttl;
import ttm;
import ttn;
import ugh;
import ugj;
import ved;
import vei;
import vwj;

public class FollowCaptureLauncher
  implements ugh, ugj
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private bcpu jdField_a_of_type_Bcpu;
  private AbsVideoInfoWidget jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget;
  private String jdField_a_of_type_JavaLangString;
  private suy jdField_a_of_type_Suy;
  private ttn jdField_a_of_type_Ttn;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public FollowCaptureLauncher(AbsVideoInfoWidget paramAbsVideoInfoWidget)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget = paramAbsVideoInfoWidget;
    this.jdField_a_of_type_Ttn = new ttn(this);
  }
  
  private int a()
  {
    int j = 0;
    if (this.jdField_c_of_type_Boolean) {
      j = 20;
    }
    int i = j;
    if (this.d) {
      i = j + 40;
    }
    j = i;
    if (this.e) {
      j = i + 40;
    }
    return j;
  }
  
  private bcpu a()
  {
    bcpu localbcpu = new bcpu(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b());
    localbcpu.a(actj.a(50.0F, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b().getResources()));
    localbcpu.a(true);
    localbcpu.c(false);
    localbcpu.f(-1);
    localbcpu.e(0);
    localbcpu.d(-15550475);
    localbcpu.g(3);
    localbcpu.jdField_f_of_type_Boolean = true;
    localbcpu.jdField_f_of_type_Int = 2;
    localbcpu.e(true);
    return localbcpu;
  }
  
  private void a(String paramString1, String paramString2)
  {
    ThreadManagerV2.excute(new FollowCaptureLauncher.ConvertAllIFrameRunnable(paramString1, paramString2, this.jdField_a_of_type_Ttn), 16, null, true);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget != null)
    {
      Object localObject = (StoryPlayerGroupHolder)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.a();
      if (localObject != null)
      {
        localObject = ((StoryPlayerGroupHolder)localObject).a();
        if (localObject != null) {
          ((VideoViewVideoHolder)localObject).c(paramBoolean);
        }
      }
    }
  }
  
  private boolean a(Context paramContext)
  {
    boolean bool = false;
    if (!avte.a())
    {
      ved.b("FollowCaptureLauncher", "checkApiVersionDialog false");
      bbdj.a(paramContext, 230).setMessage(ajya.a(2131704676)).setPositiveButton(2131694794, new ttm(this)).show();
      bool = true;
    }
    return bool;
  }
  
  private void c(String paramString)
  {
    ThreadManagerV2.excute(new FollowCaptureLauncher.1(this, paramString), 16, null, true);
  }
  
  private void d(String paramString)
  {
    if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_JavaLangString)) || (this.d)) {}
    File localFile;
    do
    {
      return;
      this.d = true;
      localFile = suj.a(paramString, 0, false, false);
    } while (localFile == null);
    paramString = new File(bkzs.a(), paramString + ".mp4");
    a(localFile.getPath(), paramString.getPath());
  }
  
  private void e()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.e = false;
  }
  
  private void e(String paramString)
  {
    d(paramString);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FollowCaptureLauncher", 2, "launchFollowCapture, vid:" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureLauncher", 2, "launchFollowCapture, cancel");
      }
      return;
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureLauncher", 2, "launchFollowCapture, path is null");
      }
      vei.a("FollowLaunchEvent", false, System.currentTimeMillis() - this.jdField_a_of_type_Long, new String[] { "iframe_video_path_null" });
      h();
      return;
    }
    if (!new File(this.jdField_c_of_type_JavaLangString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureLauncher", 2, "launchFollowCapture, file not exist");
      }
      vei.a("FollowLaunchEvent", false, System.currentTimeMillis() - this.jdField_a_of_type_Long, new String[] { "iframe_video_nonexist" });
      h();
      return;
    }
    FollowCaptureParam localFollowCaptureParam = new FollowCaptureParam();
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_c_of_type_Boolean))
    {
      localObject = bkzs.a(this.jdField_b_of_type_JavaLangString);
      localFollowCaptureParam.backgroundPath = localObject[0];
      localFollowCaptureParam.foregroundPath = localObject[1];
    }
    localFollowCaptureParam.videoPath = this.jdField_c_of_type_JavaLangString;
    localFollowCaptureParam.vid = this.jdField_a_of_type_JavaLangString;
    localFollowCaptureParam.showLink = this.jdField_a_of_type_Boolean;
    localFollowCaptureParam.comparedLevel = this.jdField_b_of_type_Int;
    localFollowCaptureParam.comparedActivityId = this.jdField_c_of_type_Int;
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("edit_video_type", 10014);
    ((Bundle)localObject).putSerializable("extra_follow_capture_param", localFollowCaptureParam);
    vwj.a().a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b(), (Bundle)localObject, 1024);
    this.jdField_a_of_type_Ttn.removeCallbacksAndMessages(null);
    e();
    vei.a("FollowLaunchEvent", true, System.currentTimeMillis() - this.jdField_a_of_type_Long, new String[0]);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_b_of_type_Boolean = true;
    a(false);
    vei.a("FollowLaunchEvent", true, System.currentTimeMillis() - this.jdField_a_of_type_Long, new String[] { "activity_stop" });
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FollowCaptureLauncher", 2, "showFollowCaptureError");
    }
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    e();
    bcql.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b(), 0, ajya.a(2131704675), 0).a();
  }
  
  private void i()
  {
    this.jdField_a_of_type_Int = Math.min(this.jdField_a_of_type_Int + 1, 99);
    if (this.jdField_a_of_type_Int == 99) {
      this.jdField_a_of_type_Ttn.removeMessages(65536);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Int);
      return;
      if (this.jdField_a_of_type_Int > 80) {
        this.jdField_a_of_type_Ttn.sendEmptyMessageDelayed(65536, 500L);
      } else {
        this.jdField_a_of_type_Ttn.sendEmptyMessageDelayed(65536, 200L);
      }
    }
  }
  
  private void j()
  {
    this.e = true;
  }
  
  private void k()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void l()
  {
    int i = a();
    if (this.jdField_a_of_type_Int < i) {
      this.jdField_a_of_type_Int = i;
    }
    if ((this.jdField_c_of_type_Boolean) && (this.e) && (this.d))
    {
      a(100);
      f();
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void a()
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b();
    if ((localActivity == null) || (localActivity.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (localActivity.isDestroyed()))) {}
    while (this.jdField_a_of_type_AndroidAppDialog == null) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bcpu == null) {
      return;
    }
    this.jdField_a_of_type_Bcpu.a();
    this.jdField_a_of_type_Bcpu.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("FollowCaptureLauncher", 2, "[setProgress] current:" + this.jdField_a_of_type_Bcpu.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bcpu.b(true);
    this.jdField_a_of_type_Bcpu.d(false);
    this.jdField_a_of_type_Bcpu.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(false);
    if (paramInt2 == -1)
    {
      svl.b("FollowCaptureLauncher onActivityResult");
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.a().mReportData.from != 106)
      {
        paramIntent = new Intent(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b(), QQStoryMainActivity.class);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b().startActivity(paramIntent);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b().finish();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Suy == null) {
      this.jdField_a_of_type_Suy = new suy();
    }
    this.jdField_a_of_type_Suy.a(paramString, 0, true, new ttk(this));
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget == null) {
      QLog.e("FollowCaptureLauncher", 1, "follow capture error:BannerVideoInfoWidget is null");
    }
    do
    {
      do
      {
        return;
      } while (a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b()));
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureLauncher", 1, "follow capture vid:" + paramString1 + " templateUrl:" + paramString2);
      }
      e();
    } while (TextUtils.isEmpty(paramString1));
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    a(true);
    bkzs.c();
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_b_of_type_JavaLangString = bkzs.a(paramString2);
      if (!bkzs.a(this.jdField_b_of_type_JavaLangString))
      {
        c(paramString2);
        paramString2 = new File(bkzs.a(), paramString1 + ".mp4");
        this.jdField_c_of_type_JavaLangString = paramString2.getPath();
        if (!paramString2.exists()) {
          break label254;
        }
        this.d = true;
        this.e = true;
      }
    }
    for (;;)
    {
      if ((!this.d) || (!this.e) || (!this.jdField_c_of_type_Boolean)) {
        break label297;
      }
      a(100);
      f();
      return;
      this.jdField_c_of_type_Boolean = true;
      break;
      this.jdField_c_of_type_Boolean = true;
      break;
      label254:
      File localFile = suj.a(paramString1, 0, false, false);
      if (localFile != null)
      {
        this.d = true;
        a(localFile.getPath(), paramString2.getPath());
      }
      else
      {
        a(paramString1);
      }
    }
    label297:
    this.jdField_a_of_type_Int = a();
    a(ajya.a(2131704674), true, 0);
    this.jdField_a_of_type_Ttn.sendEmptyMessageDelayed(65536, 100L);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        ((Window)localObject).setDimAmount(0.0F);
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561255);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371995);
      this.jdField_a_of_type_Bcpu = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bcpu);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370452)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new ttl(this));
    this.jdField_a_of_type_Bcpu.c(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Ttn.sendEmptyMessageDelayed(65545, paramInt);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ttn.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Suy != null) {
      this.jdField_a_of_type_Suy.a();
    }
  }
  
  public void b(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 65537;
    localMessage.obj = paramString;
    this.jdField_a_of_type_Ttn.sendMessage(localMessage);
  }
  
  public void c()
  {
    g();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Ttn.sendEmptyMessage(65538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher
 * JD-Core Version:    0.7.0.1
 */