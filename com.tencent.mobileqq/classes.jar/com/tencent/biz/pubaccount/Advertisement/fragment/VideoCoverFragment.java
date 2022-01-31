package com.tencent.biz.pubaccount.Advertisement.fragment;

import aepi;
import alud;
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
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import azqs;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton;
import com.tencent.biz.pubaccount.Advertisement.view.AdvertisementSplitedProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.ArrayList;
import nlo;
import nlp;
import nlq;
import nlr;
import nls;
import nlt;
import nlu;

public class VideoCoverFragment
  extends Fragment
  implements View.OnClickListener
{
  public static boolean a;
  public static boolean b;
  public static boolean c;
  public int a;
  protected AnimatorSet a;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoCoverAdapter jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter;
  private AdControlView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView;
  private AdProgressButton jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VideoCoverFragment.4(this);
  private nlo jdField_a_of_type_Nlo;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int = 1;
  private View jdField_d_of_type_AndroidViewView;
  public boolean d;
  private int jdField_e_of_type_Int = 2;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean = true;
  private View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean = true;
  private View jdField_g_of_type_AndroidViewView;
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  private boolean i;
  
  static
  {
    jdField_c_of_type_Boolean = true;
  }
  
  public VideoCoverFragment()
  {
    this.jdField_d_of_type_Boolean = true;
  }
  
  private void b()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof PublicAccountAdvertisementActivity)) {
      ((PublicAccountAdvertisementActivity)localFragmentActivity).a();
    }
  }
  
  @TargetApi(11)
  private void c()
  {
    this.jdField_d_of_type_AndroidViewView.setAlpha(0.0F);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setAlpha(0.0F);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_e_of_type_AndroidViewView, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidViewView, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    localObjectAnimator1.setDuration(1800L);
    localObjectAnimator1.setRepeatCount(-1);
    localObjectAnimator1.setRepeatMode(1);
    localObjectAnimator1.setStartDelay(100L);
    localObjectAnimator2.setDuration(1800L);
    localObjectAnimator2.setRepeatCount(-1);
    localObjectAnimator2.setRepeatMode(1);
    localObjectAnimator2.setStartDelay(240L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
  }
  
  private boolean c()
  {
    return (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.getVisibility() == 0);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
      if (this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_b_of_type_Int == this.jdField_c_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCoverFragment", 2, "isVideoMute true");
        }
        jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130841275);
      }
      while (f())
      {
        jdField_c_of_type_Boolean = true;
        return;
        jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130841276);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCoverFragment", 2, ",music system is " + this.jdField_a_of_type_Int);
        }
        if (this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_b_of_type_Int == this.jdField_e_of_type_Int) {
          g();
        }
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      if ((this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.o)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.o);
      }
      LinearLayout.LayoutParams localLayoutParams;
      for (;;)
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
        if (!this.h) {
          break;
        }
        localLayoutParams.setMargins(0, 0, 0, aepi.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localLayoutParams.setMargins(0, 0, 0, aepi.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private boolean d()
  {
    boolean bool3 = false;
    nlq localnlq = this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq;
    if ((localnlq == null) || (!this.jdField_d_of_type_Boolean)) {}
    StringBuilder localStringBuilder;
    label67:
    label94:
    label121:
    do
    {
      do
      {
        return false;
      } while (!localnlq.jdField_b_of_type_Boolean);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("canShowBanner bannerImgUrl == null ");
        if (TextUtils.isEmpty(localnlq.f)) {
          break;
        }
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append("，bannerButtonText == null");
        if (TextUtils.isEmpty(localnlq.h)) {
          break label433;
        }
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append("，bannerText == null");
        if (TextUtils.isEmpty(localnlq.g)) {
          break label438;
        }
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append("，mNickName == null");
        if (TextUtils.isEmpty(localnlq.jdField_b_of_type_JavaLangString)) {
          break label443;
        }
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append("，mTrueUin == null");
        if (TextUtils.isEmpty(localnlq.jdField_a_of_type_JavaLangString)) {
          break label448;
        }
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append("，adId == null");
        if (TextUtils.isEmpty(localnlq.jdField_c_of_type_JavaLangString)) {
          break label453;
        }
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append("，adPosId == null");
        if (TextUtils.isEmpty(localnlq.jdField_d_of_type_JavaLangString)) {
          break label458;
        }
        bool1 = true;
        QLog.d("VideoCoverFragment", 2, bool1);
      }
    } while ((TextUtils.isEmpty(localnlq.f)) || (TextUtils.isEmpty(localnlq.h)) || (TextUtils.isEmpty(localnlq.g)) || (TextUtils.isEmpty(localnlq.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(localnlq.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localnlq.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(localnlq.jdField_d_of_type_JavaLangString)));
    label148:
    label175:
    label202:
    label229:
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverFragment", 2, "canShowBanner jumpType = " + localnlq.jdField_d_of_type_Int);
    }
    if (localnlq.jdField_d_of_type_Int == 2)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("canShowBanner jumpUrl = null ");
        if (TextUtils.isEmpty(localnlq.n)) {
          break label463;
        }
      }
      label433:
      label438:
      label443:
      label448:
      label453:
      label458:
      label463:
      for (bool1 = true;; bool1 = false)
      {
        QLog.d("VideoCoverFragment", 2, bool1);
        if (TextUtils.isEmpty(localnlq.n)) {
          break;
        }
        return true;
        bool1 = false;
        break label67;
        bool1 = false;
        break label94;
        bool1 = false;
        break label121;
        bool1 = false;
        break label148;
        bool1 = false;
        break label175;
        bool1 = false;
        break label202;
        bool1 = false;
        break label229;
      }
    }
    if (localnlq.jdField_d_of_type_Int == 1) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("canShowBanner myappDownloadUrl = null ");
        if (!TextUtils.isEmpty(localnlq.jdField_j_of_type_JavaLangString))
        {
          bool1 = true;
          QLog.d("VideoCoverFragment", 2, bool1);
        }
      }
      else
      {
        if (TextUtils.isEmpty(localnlq.jdField_j_of_type_JavaLangString)) {
          break label741;
        }
      }
    }
    label573:
    label600:
    label732:
    label739:
    label741:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("canShowBanner appId = null ");
        if (TextUtils.isEmpty(localnlq.k)) {
          break label722;
        }
        bool2 = true;
        localStringBuilder = localStringBuilder.append(bool2).append(" appName = null ");
        if (TextUtils.isEmpty(localnlq.m)) {
          break label727;
        }
        bool2 = true;
        localStringBuilder = localStringBuilder.append(bool2).append(" packagename = null ");
        if (TextUtils.isEmpty(localnlq.l)) {
          break label732;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        localStringBuilder = localStringBuilder.append(bool2).append(" downloadUrl = null ");
        bool2 = bool3;
        if (!TextUtils.isEmpty(localnlq.jdField_i_of_type_JavaLangString)) {
          bool2 = true;
        }
        QLog.d("VideoCoverFragment", 2, bool2);
        if ((TextUtils.isEmpty(localnlq.k)) || (TextUtils.isEmpty(localnlq.m)) || (TextUtils.isEmpty(localnlq.l)) || (TextUtils.isEmpty(localnlq.jdField_i_of_type_JavaLangString))) {
          break label739;
        }
        return true;
        bool1 = false;
        break;
        bool2 = false;
        break label573;
        bool2 = false;
        break label600;
      }
      return true;
      return bool1;
    }
  }
  
  private void e()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a();
    if (localTVK_IMediaPlayer == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "media play is null");
      }
    }
    do
    {
      return;
      if (!f()) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidMediaAudioManager == null);
    int j = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(3);
    this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, (int)(j * 0.2D), 1);
    localTVK_IMediaPlayer.setOutputMute(false);
    jdField_c_of_type_Boolean = false;
    this.i = true;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130841276);
    return;
    if (localTVK_IMediaPlayer.getOutputMute())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a().setOutputMute(false);
      jdField_c_of_type_Boolean = false;
      this.i = true;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130841276);
      azqs.a(null, "dc00898", "", this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_a_of_type_JavaLangString, "0X8008F62", "0X8008F62", 0, 0, this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_c_of_type_JavaLangString, "", ((nlp)this.jdField_a_of_type_Nlo.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_b_of_type_JavaLangString);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a() != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a().setOutputMute(true);
    }
    jdField_c_of_type_Boolean = true;
    this.i = true;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130841275);
    azqs.a(null, "dc00898", "", this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_a_of_type_JavaLangString, "0X8008F63", "0X8008F63", 0, 0, this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_c_of_type_JavaLangString, "", ((nlp)this.jdField_a_of_type_Nlo.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_b_of_type_JavaLangString);
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.h = true;
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.h = false;
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
  }
  
  private boolean e()
  {
    Intent localIntent = getActivity().getIntent();
    try
    {
      this.jdField_a_of_type_Nlo = nlo.a(localIntent.getStringExtra("arg_ad_json"));
      if ((this.jdField_a_of_type_Nlo == null) || (this.jdField_a_of_type_Nlo.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Nlo.jdField_a_of_type_JavaUtilArrayList.size() <= 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCoverFragment", 2, "refetchItemData failed");
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_Nlo = null;
      }
    }
    return true;
  }
  
  private void f()
  {
    nlq localnlq = this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq;
    if (d())
    {
      e(true);
      if (!TextUtils.isEmpty(localnlq.f))
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        Object localObject2 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
        localObject1 = URLDrawable.getDrawable(localnlq.f, (URLDrawable.URLDrawableOptions)localObject1);
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1))
        {
          localObject2 = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
          int j = ((URLDrawable)localObject1).getIntrinsicWidth();
          int k = ((URLDrawable)localObject1).getIntrinsicHeight();
          ((ViewGroup.LayoutParams)localObject2).width = (j * aepi.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) / k);
          this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new nlu(this));
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localnlq.g);
      if (localnlq.jdField_c_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setVisibility(0);
        this.jdField_g_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(localnlq.h);
        this.jdField_g_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "canShowBanner scrollUpToJump = " + localnlq.jdField_d_of_type_Boolean);
      }
      if (((this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_d_of_type_Int != 1) || (TextUtils.isEmpty(this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_j_of_type_JavaLangString))) && ((this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_d_of_type_Int < 2) || (TextUtils.isEmpty(this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.n)) || (!this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_d_of_type_Boolean) || (!this.jdField_d_of_type_Boolean))) {
        break;
      }
      d(true);
      return;
      if (localnlq.jdField_c_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setVisibility(8);
        this.jdField_g_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(localnlq.h);
        this.jdField_g_of_type_Boolean = false;
        continue;
        e(false);
      }
    }
    d(false);
  }
  
  private boolean f()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {}
    while (this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3) != 0) {
      return false;
    }
    return true;
  }
  
  private void g()
  {
    int j = 1;
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {}
    int m;
    int n;
    do
    {
      return;
      m = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
      n = this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "audioFadeinDuration is " + n + ", maxMusicVolume is " + m);
      }
    } while (m == 0);
    int k = (int)(m * 0.2D);
    if (k < 1) {}
    for (;;)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, j, 0);
      j = (int)(n * 1000.0F / m);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoCoverFragment.6(this, m, j), j);
      return;
      j = k;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.getCount();
  }
  
  public View a()
  {
    return this.jdField_f_of_type_AndroidViewView;
  }
  
  public void a()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a();
    if (localTVK_IMediaPlayer == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "media play is null");
      }
    }
    while (!localTVK_IMediaPlayer.getOutputMute()) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a().setOutputMute(false);
  }
  
  public void a(int paramInt)
  {
    QLog.d("VideoCoverFragment", 2, "updateDownloadProgress progress " + paramInt);
    if (this.jdField_g_of_type_Boolean)
    {
      if ((getActivity() == null) || (getActivity().isFinishing()))
      {
        QLog.e("VideoCoverFragment", 1, "updateDownloadProgress null error");
        return;
      }
      if (((PublicAccountAdvertisementActivity)getActivity()).b())
      {
        QLog.d("VideoCoverFragment", 2, "updateDownloadProgress appInstalled!");
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(alud.a(2131716521));
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839129);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
        return;
      }
      if (((PublicAccountAdvertisementActivity)getActivity()).c())
      {
        QLog.d("VideoCoverFragment", 2, "updateDownloadProgress pkgExist!");
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(alud.a(2131716523));
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839129);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
        return;
      }
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.h);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839129);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
        return;
      }
      if (paramInt == 100)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(alud.a(2131716519));
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839129);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(alud.a(2131716517));
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839142);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(paramInt);
      return;
    }
    if (((PublicAccountAdvertisementActivity)getActivity()).b())
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131716515));
      return;
    }
    if (((PublicAccountAdvertisementActivity)getActivity()).c())
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131716522));
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.h);
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131716516));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131716520) + paramInt + "%");
  }
  
  public void a(nlo paramnlo, ViewPager.OnPageChangeListener paramOnPageChangeListener, View.OnClickListener paramOnClickListener, AudioManager paramAudioManager, AdControlView paramAdControlView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Nlo = paramnlo;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView = paramAdControlView;
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new nlr(this, paramOnPageChangeListener);
    this.jdField_a_of_type_AndroidMediaAudioManager = paramAudioManager;
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 6);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt * 1000L);
      azqs.a(null, "dc00898", "", this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_a_of_type_JavaLangString, "0X8008F67", "0X8008F67", 0, 0, this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_c_of_type_JavaLangString, "", "", this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_b_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.setVisibility(4);
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      if ("forceSetControllerPanelVisible " + this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq == null) {
        break label103;
      }
    }
    label103:
    for (Object localObject = Integer.valueOf(this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_i_of_type_Int);; localObject = "null")
    {
      QLog.d("VideoCoverFragment", 2, new Object[] { localObject });
      if (this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_i_of_type_Int != 2) {
        break;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.setVisibility(0);
      return true;
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public void c(boolean paramBoolean)
  {
    View localView = this.jdField_f_of_type_AndroidViewView;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localView.setClickable(paramBoolean);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b();
      if (!a()) {
        a(true);
      }
    }
    e();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2131559465, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.b();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a();
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
    }
    super.onPause();
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null) {
      c();
    }
    if (!this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a())
    {
      if ((f()) || (this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_b_of_type_Int == this.jdField_c_of_type_Int)) {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a();
      }
      if ((this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_b_of_type_Int == this.jdField_e_of_type_Int) && (this.jdField_a_of_type_Int == 0)) {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a();
      }
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a().setProgress(0, 0);
      this.jdField_e_of_type_Boolean = false;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 1);
      }
      super.onResume();
      return;
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a(false);
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_Nlo == null) && (!e())) {
      getActivity().finish();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView != null) {
        break;
      }
    } while (!(getActivity() instanceof PublicAccountAdvertisementActivity));
    ((PublicAccountAdvertisementActivity)getActivity()).c();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverFragment", 2, "onViewCreated:" + hashCode());
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    ViewGroup localViewGroup = (ViewGroup)paramView;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)localViewGroup.findViewById(2131379765));
    this.jdField_b_of_type_AndroidViewView = localViewGroup.findViewById(2131368050);
    if ((!a()) && (this.jdField_a_of_type_Nlo != null) && (this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq != null) && (this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_j_of_type_Int > 0)) {
      a(true, this.jdField_a_of_type_Nlo.jdField_a_of_type_Nlq.jdField_j_of_type_Int);
    }
    this.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131368051);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new nls(this));
    this.jdField_c_of_type_AndroidViewView = localViewGroup.findViewById(2131379671);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131379632));
    this.jdField_d_of_type_AndroidViewView = localViewGroup.findViewById(2131379431);
    this.jdField_e_of_type_AndroidViewView = localViewGroup.findViewById(2131379432);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter = new VideoCoverAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a(), this.jdField_a_of_type_Nlo, new nlt(this));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a().setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a().setTotalCount(this.jdField_a_of_type_Nlo.jdField_a_of_type_JavaUtilArrayList.size());
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_f_of_type_AndroidViewView = localViewGroup.findViewById(2131379664);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localViewGroup.findViewById(2131379666));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131379665));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton = ((AdProgressButton)localViewGroup.findViewById(2131379670));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgressColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165332));
    this.jdField_g_of_type_AndroidViewView = localViewGroup.findViewById(2131379668);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131379667));
    f();
    d();
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment
 * JD-Core Version:    0.7.0.1
 */