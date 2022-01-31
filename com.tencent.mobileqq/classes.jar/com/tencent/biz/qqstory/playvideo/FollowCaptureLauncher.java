package com.tencent.biz.qqstory.playvideo;

import actn;
import ajyc;
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
import avtc;
import bbcv;
import bbgg;
import bcpf;
import bcpw;
import bkzb;
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
import sum;
import svb;
import svo;
import ttn;
import tto;
import ttp;
import ttq;
import ugk;
import ugm;
import veg;
import vel;
import vwm;

public class FollowCaptureLauncher
  implements ugk, ugm
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private bcpf jdField_a_of_type_Bcpf;
  private AbsVideoInfoWidget jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget;
  private String jdField_a_of_type_JavaLangString;
  private svb jdField_a_of_type_Svb;
  private ttq jdField_a_of_type_Ttq;
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
    this.jdField_a_of_type_Ttq = new ttq(this);
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
  
  private bcpf a()
  {
    bcpf localbcpf = new bcpf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b());
    localbcpf.a(actn.a(50.0F, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b().getResources()));
    localbcpf.a(true);
    localbcpf.c(false);
    localbcpf.f(-1);
    localbcpf.e(0);
    localbcpf.d(-15550475);
    localbcpf.g(3);
    localbcpf.jdField_f_of_type_Boolean = true;
    localbcpf.jdField_f_of_type_Int = 2;
    localbcpf.e(true);
    return localbcpf;
  }
  
  private void a(String paramString1, String paramString2)
  {
    ThreadManagerV2.excute(new FollowCaptureLauncher.ConvertAllIFrameRunnable(paramString1, paramString2, this.jdField_a_of_type_Ttq), 16, null, true);
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
    if (!avtc.a())
    {
      veg.b("FollowCaptureLauncher", "checkApiVersionDialog false");
      bbcv.a(paramContext, 230).setMessage(ajyc.a(2131704665)).setPositiveButton(2131694793, new ttp(this)).show();
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
      localFile = sum.a(paramString, 0, false, false);
    } while (localFile == null);
    paramString = new File(bkzb.a(), paramString + ".mp4");
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
      vel.a("FollowLaunchEvent", false, System.currentTimeMillis() - this.jdField_a_of_type_Long, new String[] { "iframe_video_path_null" });
      h();
      return;
    }
    if (!new File(this.jdField_c_of_type_JavaLangString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureLauncher", 2, "launchFollowCapture, file not exist");
      }
      vel.a("FollowLaunchEvent", false, System.currentTimeMillis() - this.jdField_a_of_type_Long, new String[] { "iframe_video_nonexist" });
      h();
      return;
    }
    FollowCaptureParam localFollowCaptureParam = new FollowCaptureParam();
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_c_of_type_Boolean))
    {
      localObject = bkzb.a(this.jdField_b_of_type_JavaLangString);
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
    vwm.a().a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b(), (Bundle)localObject, 1024);
    this.jdField_a_of_type_Ttq.removeCallbacksAndMessages(null);
    e();
    vel.a("FollowLaunchEvent", true, System.currentTimeMillis() - this.jdField_a_of_type_Long, new String[0]);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_b_of_type_Boolean = true;
    a(false);
    vel.a("FollowLaunchEvent", true, System.currentTimeMillis() - this.jdField_a_of_type_Long, new String[] { "activity_stop" });
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
    bcpw.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget.b(), 0, ajyc.a(2131704664), 0).a();
  }
  
  private void i()
  {
    this.jdField_a_of_type_Int = Math.min(this.jdField_a_of_type_Int + 1, 99);
    if (this.jdField_a_of_type_Int == 99) {
      this.jdField_a_of_type_Ttq.removeMessages(65536);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Int);
      return;
      if (this.jdField_a_of_type_Int > 80) {
        this.jdField_a_of_type_Ttq.sendEmptyMessageDelayed(65536, 500L);
      } else {
        this.jdField_a_of_type_Ttq.sendEmptyMessageDelayed(65536, 200L);
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
    if (this.jdField_a_of_type_Bcpf == null) {
      return;
    }
    this.jdField_a_of_type_Bcpf.a();
    this.jdField_a_of_type_Bcpf.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("FollowCaptureLauncher", 2, "[setProgress] current:" + this.jdField_a_of_type_Bcpf.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bcpf.b(true);
    this.jdField_a_of_type_Bcpf.d(false);
    this.jdField_a_of_type_Bcpf.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(false);
    if (paramInt2 == -1)
    {
      svo.b("FollowCaptureLauncher onActivityResult");
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
    if (this.jdField_a_of_type_Svb == null) {
      this.jdField_a_of_type_Svb = new svb();
    }
    this.jdField_a_of_type_Svb.a(paramString, 0, true, new ttn(this));
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
    bkzb.c();
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_b_of_type_JavaLangString = bkzb.a(paramString2);
      if (!bkzb.a(this.jdField_b_of_type_JavaLangString))
      {
        c(paramString2);
        paramString2 = new File(bkzb.a(), paramString1 + ".mp4");
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
      File localFile = sum.a(paramString1, 0, false, false);
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
    a(ajyc.a(2131704663), true, 0);
    this.jdField_a_of_type_Ttq.sendEmptyMessageDelayed(65536, 100L);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561256);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371995);
      this.jdField_a_of_type_Bcpf = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bcpf);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370453)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new tto(this));
    this.jdField_a_of_type_Bcpf.c(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Ttq.sendEmptyMessageDelayed(65545, paramInt);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Ttq.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Svb != null) {
      this.jdField_a_of_type_Svb.a();
    }
  }
  
  public void b(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 65537;
    localMessage.obj = paramString;
    this.jdField_a_of_type_Ttq.sendMessage(localMessage);
  }
  
  public void c()
  {
    g();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Ttq.sendEmptyMessage(65538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher
 * JD-Core Version:    0.7.0.1
 */