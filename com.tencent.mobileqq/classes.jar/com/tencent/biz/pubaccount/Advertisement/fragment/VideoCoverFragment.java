package com.tencent.biz.pubaccount.Advertisement.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton;
import com.tencent.biz.pubaccount.Advertisement.view.AdvertisementSplitedProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;

public class VideoCoverFragment
  extends BaseFragment
  implements View.OnClickListener
{
  public static boolean b = false;
  public static boolean c = false;
  public static boolean d = true;
  private boolean A = true;
  private boolean B = true;
  private boolean C = false;
  private boolean D = false;
  private AudioManager E = null;
  private Handler F = null;
  private int G = 0;
  private int H = 1;
  private int I = 2;
  private boolean J = false;
  private Runnable K = new VideoCoverFragment.4(this);
  protected AnimatorSet a;
  public int e = 0;
  public boolean f = true;
  private Context g;
  private ViewPager h;
  private View i;
  private View j;
  private AdControlView k;
  private View l;
  private TextView m;
  private View n;
  private View o;
  private View p;
  private URLImageView q;
  private TextView r;
  private View s;
  private TextView t;
  private AdProgressButton u;
  private ViewPager.OnPageChangeListener v;
  private View.OnClickListener w;
  private AdvertisementItem x;
  private VideoCoverAdapter y;
  private int z;
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.l.setVisibility(0);
      if ((this.x.g != null) && (!TextUtils.isEmpty(this.x.g.w)))
      {
        this.m.setVisibility(0);
        this.m.setText(this.x.g.w);
      }
      else
      {
        this.m.setVisibility(8);
      }
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.l.getLayoutParams();
      if (this.D)
      {
        localLayoutParams.setMargins(0, 0, 0, AIOUtils.b(18.0F, this.g.getResources()));
        return;
      }
      localLayoutParams.setMargins(0, 0, 0, AIOUtils.b(30.0F, this.g.getResources()));
      return;
    }
    this.l.setVisibility(8);
    this.m.setVisibility(8);
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.D = true;
      this.p.setVisibility(0);
      return;
    }
    this.D = false;
    this.p.setVisibility(8);
  }
  
  private void f()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if ((localQBaseActivity instanceof PublicAccountAdvertisementActivity)) {
      ((PublicAccountAdvertisementActivity)localQBaseActivity).b();
    }
  }
  
  @TargetApi(11)
  private void g()
  {
    this.n.setAlpha(0.0F);
    this.n.setVisibility(0);
    this.o.setAlpha(0.0F);
    this.o.setVisibility(0);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.o, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.n, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    localObjectAnimator1.setDuration(1800L);
    localObjectAnimator1.setRepeatCount(-1);
    localObjectAnimator1.setRepeatMode(1);
    localObjectAnimator1.setStartDelay(100L);
    localObjectAnimator2.setDuration(1800L);
    localObjectAnimator2.setRepeatCount(-1);
    localObjectAnimator2.setRepeatMode(1);
    localObjectAnimator2.setStartDelay(240L);
    this.a = new AnimatorSet();
    this.a.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
  }
  
  private boolean h()
  {
    return (this.j.getVisibility() == 0) && (this.k.getVisibility() == 0);
  }
  
  private void i()
  {
    Object localObject = this.E;
    if (localObject == null) {
      return;
    }
    this.e = ((AudioManager)localObject).getStreamVolume(3);
    if (this.x.g.h == this.G)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "isVideoMute true");
      }
      d = true;
      this.k.getVideoVolumeBtn().setBackgroundResource(2130842578);
    }
    else
    {
      d = false;
      this.k.getVideoVolumeBtn().setBackgroundResource(2130842579);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(",music system is ");
        ((StringBuilder)localObject).append(this.e);
        QLog.d("VideoCoverFragment", 2, ((StringBuilder)localObject).toString());
      }
      if (this.x.g.h == this.I) {
        o();
      }
    }
    if (n()) {
      d = true;
    }
  }
  
  private void j()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.y.e();
    if (localTVK_IMediaPlayer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "media play is null");
      }
      return;
    }
    if (n())
    {
      AudioManager localAudioManager = this.E;
      if (localAudioManager == null) {
        return;
      }
      int i1 = localAudioManager.getStreamMaxVolume(3);
      localAudioManager = this.E;
      double d1 = i1;
      Double.isNaN(d1);
      localAudioManager.setStreamVolume(3, (int)(d1 * 0.2D), 1);
      localTVK_IMediaPlayer.setOutputMute(false);
      d = false;
      this.J = true;
      this.k.getVideoVolumeBtn().setBackgroundResource(2130842579);
      return;
    }
    if (localTVK_IMediaPlayer.getOutputMute())
    {
      this.y.e().setOutputMute(false);
      d = false;
      this.J = true;
      this.k.getVideoVolumeBtn().setBackgroundResource(2130842579);
      ReportController.a(null, "dc00898", "", this.x.g.a, "0X8008F62", "0X8008F62", 0, 0, this.x.g.c, "", ((VideoCoverItem)this.x.c.get(this.z)).c, this.x.g.b);
      return;
    }
    if (this.y.e() != null) {
      this.y.e().setOutputMute(true);
    }
    d = true;
    this.J = true;
    this.k.getVideoVolumeBtn().setBackgroundResource(2130842578);
    ReportController.a(null, "dc00898", "", this.x.g.a, "0X8008F63", "0X8008F63", 0, 0, this.x.g.c, "", ((VideoCoverItem)this.x.c.get(this.z)).c, this.x.g.b);
  }
  
  private void k()
  {
    VideoDownloadItem localVideoDownloadItem = this.x.g;
    Object localObject1;
    if (l())
    {
      e(true);
      if (!TextUtils.isEmpty(localVideoDownloadItem.k))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        Object localObject2 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
        localObject1 = URLDrawable.getDrawable(localVideoDownloadItem.k, (URLDrawable.URLDrawableOptions)localObject1);
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1))
        {
          localObject2 = this.q.getLayoutParams();
          int i1 = ((URLDrawable)localObject1).getIntrinsicWidth();
          int i2 = ((URLDrawable)localObject1).getIntrinsicHeight();
          ((ViewGroup.LayoutParams)localObject2).width = (AIOUtils.b(23.0F, this.g.getResources()) * i1 / i2);
          this.q.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        this.q.setURLDrawableDownListener(new VideoCoverFragment.5(this));
        this.q.setImageDrawable((Drawable)localObject1);
      }
      this.r.setText(localVideoDownloadItem.l);
      if (localVideoDownloadItem.j == 1)
      {
        this.u.setVisibility(0);
        this.s.setVisibility(8);
        this.u.setText(localVideoDownloadItem.m);
        this.C = true;
      }
      else if (localVideoDownloadItem.j == 2)
      {
        this.u.setVisibility(8);
        this.s.setVisibility(0);
        this.t.setText(localVideoDownloadItem.m);
        this.C = false;
      }
    }
    else
    {
      e(false);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("canShowBanner scrollUpToJump = ");
      ((StringBuilder)localObject1).append(localVideoDownloadItem.E);
      QLog.d("VideoCoverFragment", 2, ((StringBuilder)localObject1).toString());
    }
    if (((this.x.g.n == 1) && (!TextUtils.isEmpty(this.x.g.p))) || ((this.x.g.n >= 2) && (!TextUtils.isEmpty(this.x.g.v)) && (this.x.g.E) && (this.f)))
    {
      d(true);
      return;
    }
    d(false);
  }
  
  private boolean l()
  {
    VideoDownloadItem localVideoDownloadItem = this.x.g;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localVideoDownloadItem != null)
    {
      if (!this.f) {
        return false;
      }
      if (!localVideoDownloadItem.i) {
        return false;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("canShowBanner bannerImgUrl == null ");
        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.k) ^ true);
        localStringBuilder.append("，bannerButtonText == null");
        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.m) ^ true);
        localStringBuilder.append("，bannerText == null");
        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.l) ^ true);
        localStringBuilder.append("，mNickName == null");
        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.b) ^ true);
        localStringBuilder.append("，mTrueUin == null");
        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.a) ^ true);
        localStringBuilder.append("，adId == null");
        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.c) ^ true);
        localStringBuilder.append("，adPosId == null");
        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.d) ^ true);
        QLog.d("VideoCoverFragment", 2, localStringBuilder.toString());
      }
      bool1 = bool2;
      if (!TextUtils.isEmpty(localVideoDownloadItem.k))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(localVideoDownloadItem.m))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(localVideoDownloadItem.l))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(localVideoDownloadItem.b))
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty(localVideoDownloadItem.a))
              {
                bool1 = bool2;
                if (!TextUtils.isEmpty(localVideoDownloadItem.c))
                {
                  bool1 = bool2;
                  if (!TextUtils.isEmpty(localVideoDownloadItem.d))
                  {
                    if (QLog.isColorLevel())
                    {
                      localStringBuilder = new StringBuilder();
                      localStringBuilder.append("canShowBanner jumpType = ");
                      localStringBuilder.append(localVideoDownloadItem.n);
                      QLog.d("VideoCoverFragment", 2, localStringBuilder.toString());
                    }
                    if (localVideoDownloadItem.n == 2)
                    {
                      if (QLog.isColorLevel())
                      {
                        localStringBuilder = new StringBuilder();
                        localStringBuilder.append("canShowBanner jumpUrl = null ");
                        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.v) ^ true);
                        QLog.d("VideoCoverFragment", 2, localStringBuilder.toString());
                      }
                      bool1 = bool2;
                      if (TextUtils.isEmpty(localVideoDownloadItem.v)) {
                        return bool1;
                      }
                    }
                    else if (localVideoDownloadItem.n == 1)
                    {
                      if (QLog.isColorLevel())
                      {
                        localStringBuilder = new StringBuilder();
                        localStringBuilder.append("canShowBanner myappDownloadUrl = null ");
                        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.p) ^ true);
                        QLog.d("VideoCoverFragment", 2, localStringBuilder.toString());
                      }
                      bool2 = TextUtils.isEmpty(localVideoDownloadItem.p) ^ true;
                      if (QLog.isColorLevel())
                      {
                        localStringBuilder = new StringBuilder();
                        localStringBuilder.append("canShowBanner appId = null ");
                        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.q) ^ true);
                        localStringBuilder.append(" appName = null ");
                        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.s) ^ true);
                        localStringBuilder.append(" packagename = null ");
                        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.r) ^ true);
                        localStringBuilder.append(" downloadUrl = null ");
                        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.o) ^ true);
                        QLog.d("VideoCoverFragment", 2, localStringBuilder.toString());
                      }
                      bool1 = bool2;
                      if (TextUtils.isEmpty(localVideoDownloadItem.q)) {
                        return bool1;
                      }
                      bool1 = bool2;
                      if (TextUtils.isEmpty(localVideoDownloadItem.s)) {
                        return bool1;
                      }
                      bool1 = bool2;
                      if (TextUtils.isEmpty(localVideoDownloadItem.r)) {
                        return bool1;
                      }
                      bool1 = bool2;
                      if (TextUtils.isEmpty(localVideoDownloadItem.o)) {
                        return bool1;
                      }
                    }
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean m()
  {
    Intent localIntent = getQBaseActivity().getIntent();
    try
    {
      this.x = AdvertisementItem.a(localIntent.getStringExtra("arg_ad_json"));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.x = null;
    }
    AdvertisementItem localAdvertisementItem = this.x;
    if ((localAdvertisementItem != null) && (localAdvertisementItem.c != null) && (this.x.c.size() > 0)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverFragment", 2, "refetchItemData failed");
    }
    return false;
  }
  
  private boolean n()
  {
    AudioManager localAudioManager = this.E;
    boolean bool = false;
    if (localAudioManager == null) {
      return false;
    }
    if (localAudioManager.getStreamVolume(3) == 0) {
      bool = true;
    }
    return bool;
  }
  
  private void o()
  {
    Object localObject = this.E;
    if (localObject == null) {
      return;
    }
    int i3 = ((AudioManager)localObject).getStreamVolume(3);
    int i4 = this.x.g.f;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("audioFadeinDuration is ");
      ((StringBuilder)localObject).append(i4);
      ((StringBuilder)localObject).append(", maxMusicVolume is ");
      ((StringBuilder)localObject).append(i3);
      QLog.d("VideoCoverFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (i3 == 0) {
      return;
    }
    double d1 = i3;
    Double.isNaN(d1);
    int i2 = (int)(d1 * 0.2D);
    int i1 = i2;
    if (i2 < 1) {
      i1 = 1;
    }
    this.E.setStreamVolume(3, i1, 0);
    i1 = (int)(i4 * 1000.0F / i3);
    this.F.postDelayed(new VideoCoverFragment.6(this, i3, i1), i1);
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateDownloadProgress progress ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("VideoCoverFragment", 2, ((StringBuilder)localObject).toString());
    if (this.C)
    {
      if ((getQBaseActivity() != null) && (!getQBaseActivity().isFinishing()))
      {
        if (((PublicAccountAdvertisementActivity)getQBaseActivity()).f())
        {
          QLog.d("VideoCoverFragment", 2, "updateDownloadProgress appInstalled!");
          this.u.setText(HardCodeUtil.a(2131913335));
          this.u.setTextColor(-1);
          this.u.setBackgroundResource(2130839481);
          this.u.setProgress(0);
          return;
        }
        if (((PublicAccountAdvertisementActivity)getQBaseActivity()).g())
        {
          QLog.d("VideoCoverFragment", 2, "updateDownloadProgress pkgExist!");
          this.u.setText(HardCodeUtil.a(2131913337));
          this.u.setTextColor(-1);
          this.u.setBackgroundResource(2130839481);
          this.u.setProgress(0);
          return;
        }
        if (paramInt == 0)
        {
          this.u.setText(this.x.g.m);
          this.u.setTextColor(-1);
          this.u.setBackgroundResource(2130839481);
          this.u.setProgress(0);
          return;
        }
        if (paramInt == 100)
        {
          this.u.setText(HardCodeUtil.a(2131913333));
          this.u.setTextColor(-1);
          this.u.setBackgroundResource(2130839481);
          this.u.setProgress(0);
          return;
        }
        this.u.setText(HardCodeUtil.a(2131913331));
        this.u.setTextColor(-16777216);
        this.u.setBackgroundResource(2130839494);
        this.u.setProgress(paramInt);
        return;
      }
      QLog.e("VideoCoverFragment", 1, "updateDownloadProgress null error");
      return;
    }
    if (((PublicAccountAdvertisementActivity)getQBaseActivity()).f())
    {
      this.t.setText(HardCodeUtil.a(2131913329));
      return;
    }
    if (((PublicAccountAdvertisementActivity)getQBaseActivity()).g())
    {
      this.t.setText(HardCodeUtil.a(2131913336));
      return;
    }
    if (paramInt == 0)
    {
      this.u.setText(this.x.g.m);
      return;
    }
    if (paramInt == 100)
    {
      this.t.setText(HardCodeUtil.a(2131913330));
      return;
    }
    localObject = this.t;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131913334));
    localStringBuilder.append(paramInt);
    localStringBuilder.append("%");
    ((TextView)localObject).setText(localStringBuilder.toString());
  }
  
  public void a(AdvertisementItem paramAdvertisementItem, ViewPager.OnPageChangeListener paramOnPageChangeListener, View.OnClickListener paramOnClickListener, AudioManager paramAudioManager, AdControlView paramAdControlView, boolean paramBoolean)
  {
    this.x = paramAdvertisementItem;
    this.w = paramOnClickListener;
    this.k = paramAdControlView;
    this.f = paramBoolean;
    this.v = new VideoCoverFragment.1(this, paramOnPageChangeListener);
    this.E = paramAudioManager;
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 6);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.F.removeCallbacks(this.K);
    if (paramBoolean)
    {
      this.j.setVisibility(0);
      this.k.setVisibility(0);
      this.F.postDelayed(this.K, paramInt * 1000L);
      ReportController.a(null, "dc00898", "", this.x.g.a, "0X8008F67", "0X8008F67", 0, 0, this.x.g.c, "", "", this.x.g.b);
      return;
    }
    this.j.setVisibility(4);
    this.k.setVisibility(4);
  }
  
  public boolean a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("forceSetControllerPanelVisible ");
      ((StringBuilder)localObject).append(this.x.g);
      if (((StringBuilder)localObject).toString() != null) {
        localObject = Integer.valueOf(this.x.g.C);
      } else {
        localObject = "null";
      }
      QLog.d("VideoCoverFragment", 2, new Object[] { localObject });
    }
    if (this.x.g.C == 2)
    {
      this.j.setVisibility(0);
      localObject = this.k;
      ((AdControlView)localObject).c = true;
      ((AdControlView)localObject).setVisibility(0);
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.y.getCount();
  }
  
  public void b(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  public void c()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.y.e();
    if (localTVK_IMediaPlayer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "media play is null");
      }
      return;
    }
    if (localTVK_IMediaPlayer.getOutputMute()) {
      this.y.e().setOutputMute(false);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.p.setClickable(paramBoolean ^ true);
  }
  
  public boolean d()
  {
    return this.D;
  }
  
  public View e()
  {
    return this.p;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131449773)
    {
      if (this.k.b)
      {
        this.k.b();
        if (!a()) {
          a(true);
        }
      }
      j();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.g = getQBaseActivity();
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131625620, paramViewGroup, false);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    b = false;
    c = false;
    Object localObject = this.y;
    if (localObject != null) {
      ((VideoCoverAdapter)localObject).b();
    }
    localObject = this.F;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((AnimatorSet)localObject).cancel();
    }
    this.y.a();
    localObject = this.E;
    if (localObject != null) {
      ((AudioManager)localObject).abandonAudioFocus(null);
    }
    super.onPause();
  }
  
  public void onResume()
  {
    if (this.a == null) {
      g();
    }
    if (!this.k.c())
    {
      if ((n()) || (this.x.g.h == this.G)) {
        this.k.a();
      }
      if ((this.x.g.h == this.I) && (this.e == 0)) {
        this.k.a();
      }
    }
    this.a.start();
    if (this.A)
    {
      this.y.a(true);
      this.k.getSplitedProgressBar().setProgress(0, 0);
      this.A = false;
    }
    else if (this.B)
    {
      this.y.a(false);
    }
    AudioManager localAudioManager = this.E;
    if (localAudioManager != null) {
      localAudioManager.requestAudioFocus(null, 3, 1);
    }
    super.onResume();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if ((this.x == null) && (!m()))
    {
      getQBaseActivity().finish();
      return;
    }
    if (this.k == null)
    {
      if ((getQBaseActivity() instanceof PublicAccountAdvertisementActivity)) {
        ((PublicAccountAdvertisementActivity)getQBaseActivity()).d();
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onViewCreated:");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d("VideoCoverFragment", 2, ((StringBuilder)localObject).toString());
    }
    this.F = new Handler();
    Object localObject = (ViewGroup)paramView;
    this.h = ((ViewPager)((ViewGroup)localObject).findViewById(2131449646));
    this.j = ((ViewGroup)localObject).findViewById(2131435500);
    if (!a())
    {
      AdvertisementItem localAdvertisementItem = this.x;
      if ((localAdvertisementItem != null) && (localAdvertisementItem.g != null) && (this.x.g.D > 0)) {
        a(true, this.x.g.D);
      }
    }
    this.i = ((ViewGroup)localObject).findViewById(2131435501);
    this.i.setOnTouchListener(new VideoCoverFragment.2(this));
    this.l = ((ViewGroup)localObject).findViewById(2131449533);
    this.m = ((TextView)((ViewGroup)localObject).findViewById(2131449485));
    this.n = ((ViewGroup)localObject).findViewById(2131449242);
    this.o = ((ViewGroup)localObject).findViewById(2131449243);
    this.y = new VideoCoverAdapter(this.g, this.k.getSplitedProgressBar(), this.x, new VideoCoverFragment.3(this));
    this.h.setAdapter(this.y);
    this.h.setOnPageChangeListener(this.v);
    this.k.getVideoCloseBtn().setOnClickListener(this.w);
    this.k.getVideoVolumeBtn().setOnClickListener(this);
    this.k.getSplitedProgressBar().setTotalCount(this.x.c.size());
    this.l.setOnClickListener(this.w);
    this.p = ((ViewGroup)localObject).findViewById(2131449524);
    this.p.setOnClickListener(this.w);
    this.q = ((URLImageView)((ViewGroup)localObject).findViewById(2131449526));
    this.r = ((TextView)((ViewGroup)localObject).findViewById(2131449525));
    this.u = ((AdProgressButton)((ViewGroup)localObject).findViewById(2131449530));
    this.u.setProgressColor(this.g.getResources().getColor(2131165591));
    this.s = ((ViewGroup)localObject).findViewById(2131449528);
    this.t = ((TextView)((ViewGroup)localObject).findViewById(2131449527));
    k();
    i();
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment
 * JD-Core Version:    0.7.0.1
 */