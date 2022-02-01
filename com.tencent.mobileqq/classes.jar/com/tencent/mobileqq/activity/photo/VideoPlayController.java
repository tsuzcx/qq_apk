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
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidViewView = ((MediaPlayHelper)localObject).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$EventHandler, paramVideoPlayMedioInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
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
    if (!this.jdField_b_of_type_Boolean)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null)
      {
        MediaPlayHelper localMediaPlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper;
        if (localMediaPlayHelper != null)
        {
          localMediaPlayHelper.a(paramActivity, (IVideoViewBase)localView);
          this.jdField_b_of_type_Boolean = true;
        }
      }
    }
  }
  
  private void o()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper;
      if (localObject != null) {
        ((MediaPlayHelper)localObject).b();
      }
    }
    if (VersionUtils.b())
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      if (localObject != null) {
        ((AudioManager)((Activity)localObject).getSystemService("audio")).abandonAudioFocus(null);
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    if (localObject != null) {
      ((Activity)localObject).runOnUiThread(new VideoPlayController.2(this));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    MediaPlayHelper localMediaPlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper;
    if (localMediaPlayHelper != null) {
      return localMediaPlayHelper.b();
    }
    return 0L;
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = HardCodeUtil.a(2131716073);
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity;
    if (localObject2 != null) {
      localObject1 = ((Activity)localObject2).getString(2131719095);
    }
    Object localObject3;
    if (paramInt1 == 101)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo;
      if ((localObject2 != null) && (((VideoPlayMedioInfo)localObject2).jdField_a_of_type_ArrayOfJavaLangString != null) && (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_JavaLangString)))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString;
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          localObject3 = localObject2[i];
          if (!StringUtil.a((String)localObject3)) {
            InnerDns.getInstance().reportBadIp(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_b_of_type_JavaLangString, InnerDns.getHostFromUrl((String)localObject3), 1005);
          }
          i += 1;
        }
        LongVideoUrlCacheManager.a().a();
      }
    }
    localObject2 = localObject1;
    if (paramInt1 == 122) {
      if (paramInt2 != 204)
      {
        localObject2 = localObject1;
        if (paramInt2 != 202) {}
      }
      else
      {
        localObject3 = this.jdField_a_of_type_AndroidAppActivity;
        localObject2 = localObject1;
        if (localObject3 != null) {
          localObject2 = ((Activity)localObject3).getString(2131719092);
        }
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener;
    if (localObject1 != null) {
      ((VideoPlayController.VideoPlayerStateListener)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo, paramInt1, paramInt2, (String)localObject2);
    }
  }
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(View paramView);
  
  public void a(View paramView, VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    if ((paramView != null) && (paramVideoPlayMedioInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper == null) {
        return;
      }
      h();
      Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (localObject != null) {
        ((FrameLayout)localObject).removeAllViews();
      }
      if (paramView == null)
      {
        a();
        this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
        this.jdField_a_of_type_AndroidAppActivity = null;
      }
      else
      {
        a(paramView);
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131373045));
      }
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((IVideoViewBase)localObject).removeViewCallBack(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper);
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo != null) && (paramView != null) && (paramView.getContext() != null))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onItemSelect no == ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.hashCode());
          ((StringBuilder)localObject).append(" id=");
          ((StringBuilder)localObject).append(paramVideoPlayMedioInfo.jdField_a_of_type_Long);
          QLog.d("carverW VideoPlayController", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramView.getContext());
        a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo);
      }
    }
  }
  
  public void a(AIOShortVideoData paramAIOShortVideoData, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo != null) && (paramAIOShortVideoData.jdField_f_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetUrl data.id = ");
      ((StringBuilder)localObject).append(paramAIOShortVideoData.jdField_f_of_type_Long);
      ((StringBuilder)localObject).append(" mInfo,id=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long);
      QLog.d("carverW VideoPlayController", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetUrl data=");
        ((StringBuilder)localObject).append(paramAIOShortVideoData.jdField_f_of_type_Long);
        ((StringBuilder)localObject).append(" isNeedShowCenterBtn=");
        ((StringBuilder)localObject).append(paramBoolean2);
        ((StringBuilder)localObject).append(" isStart=");
        ((StringBuilder)localObject).append(paramBoolean1);
        QLog.d("carverW VideoPlayController", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new VideoPlayMedioInfo();
      ((VideoPlayMedioInfo)localObject).jdField_a_of_type_Long = paramAIOShortVideoData.jdField_f_of_type_Long;
      ((VideoPlayMedioInfo)localObject).jdField_b_of_type_Int = paramAIOShortVideoData.jdField_f_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener.a((VideoPlayMedioInfo)localObject, paramBoolean1);
      if (paramBoolean2)
      {
        b(0);
        return;
      }
      b(8);
    }
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
    VideoPlayMedioInfo localVideoPlayMedioInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo;
    if (localVideoPlayMedioInfo != null) {
      localVideoPlayMedioInfo.d = true;
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
    MediaPlayHelper localMediaPlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper;
    if (localMediaPlayHelper != null) {
      return localMediaPlayHelper.a();
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
    MediaPlayHelper localMediaPlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper;
    if (localMediaPlayHelper != null) {
      localMediaPlayHelper.b(paramInt);
    }
  }
  
  public void e() {}
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("carverW VideoPlayController", 2, "onItemClick  onItemClick mCurInfo is null");
      }
      return;
    }
    this.c = true;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onItemClick curState=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" no = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.hashCode());
      localStringBuilder.append(" id=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_Long);
      QLog.d("carverW VideoPlayController", 2, localStringBuilder.toString());
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onItemClick  isComplete=");
        localStringBuilder.append(this.d);
        QLog.d("carverW VideoPlayController", 2, localStringBuilder.toString());
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
    if (i == 2)
    {
      a(true);
      return;
    }
    if (i == 3)
    {
      l();
      return;
    }
    if (i == 1)
    {
      h();
      this.jdField_a_of_type_Int = 4;
      return;
    }
    if (i == 4) {
      l();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo;
      if (localObject != null) {
        if (!((VideoPlayMedioInfo)localObject).jdField_a_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaLangString != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_JavaLangString, 0L);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
            localObject = "0";
          } else {
            localObject = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime);
          }
          String str;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
            str = "";
          } else {
            str = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.a(), (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString, 0L, str, this.jdField_a_of_type_AndroidAppActivity);
        }
      }
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("  play = onResume mVideoState=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("carverW VideoPlayController", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int == 1))
    {
      a(true);
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      if (localObject != null) {
        ((Activity)localObject).runOnUiThread(new VideoPlayController.3(this));
      }
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("carverW VideoPlayController", 2, "  play = onDestory ");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper;
    if (localObject != null)
    {
      ((MediaPlayHelper)localObject).f();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper = null;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$EventHandler;
    if (localObject != null)
    {
      ((VideoPlayController.EventHandler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$EventHandler = null;
    }
  }
  
  public void k() {}
  
  protected void l()
  {
    if ((VersionUtils.b()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo.e))
    {
      localActivity = this.jdField_a_of_type_AndroidAppActivity;
      if (localActivity != null) {
        ((AudioManager)localActivity.getSystemService("audio")).requestAudioFocus(null, 3, 2);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.c();
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (localActivity != null) {
      localActivity.runOnUiThread(new VideoPlayController.4(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$EventHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
  }
  
  public void m()
  {
    MediaPlayHelper localMediaPlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper;
    if (localMediaPlayHelper != null) {
      localMediaPlayHelper.d();
    }
  }
  
  public void n()
  {
    MediaPlayHelper localMediaPlayHelper = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper;
    if (localMediaPlayHelper != null) {
      localMediaPlayHelper.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.VideoPlayController
 * JD-Core Version:    0.7.0.1
 */