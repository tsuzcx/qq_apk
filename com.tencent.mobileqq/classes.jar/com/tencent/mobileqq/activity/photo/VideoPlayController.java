package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.LongVideoUrlCacheManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.VersionUtils;
import java.util.HashMap;

public abstract class VideoPlayController
{
  private int jdField_a_of_type_Int = 0;
  Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected IAIOImageProvider a;
  MediaPlayHelper jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper = new MediaPlayHelper();
  VideoPlayController.EventHandler jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$EventHandler = new VideoPlayController.EventHandler(this, null);
  VideoPlayController.VideoPlayerStateListener jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener;
  public VideoPlayMedioInfo a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VideoPlayController.1(this);
  private final String jdField_a_of_type_JavaLangString = "carverW VideoPlayController";
  protected boolean a;
  private boolean b;
  private boolean c = false;
  private boolean d = false;
  
  public VideoPlayController()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "#setupVideoView  ");
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "#setupVideoView  layout is null#");
      }
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      paramActivity.getWindow().addFlags(67108864);
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
    b(paramActivity);
  }
  
  private void a(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "#initMediaPlayVideo  ");
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper != null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$EventHandler, paramVideoPlayMedioInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        a(this.jdField_a_of_type_AndroidAppActivity);
        paramVideoPlayMedioInfo = new HashMap();
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "previewVideoViewCreateSuc", true, 0L, 0L, paramVideoPlayMedioInfo, null);
      }
    }
  }
  
  private void b(Activity paramActivity)
  {
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a(paramActivity, (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void o()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.b();
    }
    if ((VersionUtils.b()) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      Activity localActivity1 = this.jdField_a_of_type_AndroidAppActivity;
      Activity localActivity2 = this.jdField_a_of_type_AndroidAppActivity;
      ((AudioManager)localActivity1.getSystemService("audio")).abandonAudioFocus(null);
    }
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoPlayController.2(this));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.b();
    }
    return 0L;
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  void a(int paramInt1, int paramInt2)
  {
    String str1 = HardCodeUtil.a(2131716150);
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131719377);
    }
    if ((paramInt1 == 101) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString != null) && (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_JavaLangString)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str2 = localObject[i];
        if (!StringUtil.a(str2)) {
          InnerDns.getInstance().reportBadIp(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_JavaLangString, InnerDns.getHostFromUrl(str2), 1005);
        }
        i += 1;
      }
      LongVideoUrlCacheManager.a().a();
    }
    Object localObject = str1;
    if (paramInt1 == 122) {
      if (paramInt2 != 204)
      {
        localObject = str1;
        if (paramInt2 != 202) {}
      }
      else
      {
        localObject = str1;
        if (this.jdField_a_of_type_AndroidAppActivity != null) {
          localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131719374);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo, paramInt1, paramInt2, (String)localObject);
    }
  }
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(View paramView);
  
  public void a(View paramView, VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    if ((paramView == null) || (paramVideoPlayMedioInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper == null)) {
      return;
    }
    h();
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    }
    if (paramView == null)
    {
      a();
      this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
      this.jdField_a_of_type_AndroidAppActivity = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).removeViewCallBack(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$EventHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.c = false;
      this.d = false;
      a(false);
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a();
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo = paramVideoPlayMedioInfo;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo == null) || (paramView == null) || (paramView.getContext() == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "onItemSelect no == " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.hashCode() + " id=" + paramVideoPlayMedioInfo.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramView.getContext());
      a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo);
      return;
      a(paramView);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131373470));
    }
  }
  
  public void a(AIOShortVideoData paramAIOShortVideoData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo != null) && (paramAIOShortVideoData.jdField_f_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long)) {
      QLog.d("carverW VideoPlayController", 2, "onGetUrl data.id = " + paramAIOShortVideoData.jdField_f_of_type_Long + " mInfo,id=" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "onGetUrl data=" + paramAIOShortVideoData.jdField_f_of_type_Long + " isNeedShowCenterBtn=" + paramBoolean2 + " isStart=" + paramBoolean1);
    }
    VideoPlayMedioInfo localVideoPlayMedioInfo = new VideoPlayMedioInfo();
    localVideoPlayMedioInfo.jdField_a_of_type_Long = paramAIOShortVideoData.jdField_f_of_type_Long;
    localVideoPlayMedioInfo.jdField_b_of_type_Int = paramAIOShortVideoData.jdField_f_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener.a(localVideoPlayMedioInfo, paramBoolean1);
    if (paramBoolean2)
    {
      b(0);
      return;
    }
    b(8);
  }
  
  public void a(IAIOImageProvider paramIAIOImageProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
  }
  
  public void a(VideoPlayController.VideoPlayerStateListener paramVideoPlayerStateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener = paramVideoPlayerStateListener;
  }
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.c();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.d = true;
    }
    b(8);
    a(8, "");
  }
  
  public abstract void b(int paramInt);
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 0) {
      g();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Boolean;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a(paramInt);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a();
    }
    return false;
  }
  
  public long d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.d();
  }
  
  public void d() {}
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.b(paramInt);
    }
  }
  
  public void e() {}
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "onItemClick  onItemClick mCurInfo is null");
      }
    }
    do
    {
      return;
      this.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "onItemClick curState=" + this.jdField_a_of_type_Int + " no = " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.hashCode() + " id=" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("carverW VideoPlayController", 2, "onItemClick  isComplete=" + this.d);
        }
        if (this.d)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_Boolean) {
            g();
          }
          this.d = false;
        }
        a(true);
        return;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        a(true);
        return;
      }
      if (this.jdField_a_of_type_Int == 3)
      {
        l();
        return;
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        h();
        this.jdField_a_of_type_Int = 4;
        return;
      }
    } while (this.jdField_a_of_type_Int != 4);
    l();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Boolean) {
        break label50;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaLangString != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaLangString, 0L);
      }
    }
    return;
    label50:
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)
    {
      str1 = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
        break label124;
      }
    }
    label124:
    for (String str2 = "";; str2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.a(), str1, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString, 0L, str2, this.jdField_a_of_type_AndroidAppActivity);
      return;
      str1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime);
      break;
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "  play = Pasue ");
    }
    this.jdField_a_of_type_Int = 4;
    o();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "  play = onResume mVideoState=" + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int == 1))
    {
      a(true);
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoPlayController.3(this));
      }
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "  play = onDestory ");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.f();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper = null;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$EventHandler != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$EventHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$EventHandler = null;
    }
  }
  
  public void k() {}
  
  protected void l()
  {
    if ((VersionUtils.b()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.e) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      Activity localActivity1 = this.jdField_a_of_type_AndroidAppActivity;
      Activity localActivity2 = this.jdField_a_of_type_AndroidAppActivity;
      ((AudioManager)localActivity1.getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.c();
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoPlayController.4(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$EventHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.d();
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.VideoPlayController
 * JD-Core Version:    0.7.0.1
 */