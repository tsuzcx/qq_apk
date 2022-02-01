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
  public static boolean a = false;
  public static boolean b = false;
  public static boolean c = true;
  public int a;
  protected AnimatorSet a;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
  private ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private VideoCoverAdapter jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter;
  private AdvertisementItem jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
  private AdControlView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView;
  private AdProgressButton jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VideoCoverFragment.4(this);
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = 0;
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
  private boolean jdField_g_of_type_Boolean = false;
  private boolean h = false;
  private boolean i = false;
  
  public VideoCoverFragment()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = true;
  }
  
  private void b()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if ((localQBaseActivity instanceof PublicAccountAdvertisementActivity)) {
      ((PublicAccountAdvertisementActivity)localQBaseActivity).a();
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
    Object localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_Int = ((AudioManager)localObject).getStreamVolume(3);
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_Int == this.jdField_c_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "isVideoMute true");
      }
      jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130841663);
    }
    else
    {
      jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130841664);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(",music system is ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.d("VideoCoverFragment", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_Int == this.jdField_e_of_type_Int) {
        g();
      }
    }
    if (f()) {
      jdField_c_of_type_Boolean = true;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.o)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.o);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      if (this.h)
      {
        localLayoutParams.setMargins(0, 0, 0, AIOUtils.b(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        return;
      }
      localLayoutParams.setMargins(0, 0, 0, AIOUtils.b(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private boolean d()
  {
    VideoDownloadItem localVideoDownloadItem = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localVideoDownloadItem != null)
    {
      if (!this.jdField_d_of_type_Boolean) {
        return false;
      }
      if (!localVideoDownloadItem.jdField_b_of_type_Boolean) {
        return false;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("canShowBanner bannerImgUrl == null ");
        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.f) ^ true);
        localStringBuilder.append("，bannerButtonText == null");
        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.h) ^ true);
        localStringBuilder.append("，bannerText == null");
        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.g) ^ true);
        localStringBuilder.append("，mNickName == null");
        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.jdField_b_of_type_JavaLangString) ^ true);
        localStringBuilder.append("，mTrueUin == null");
        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.jdField_a_of_type_JavaLangString) ^ true);
        localStringBuilder.append("，adId == null");
        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.jdField_c_of_type_JavaLangString) ^ true);
        localStringBuilder.append("，adPosId == null");
        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.jdField_d_of_type_JavaLangString) ^ true);
        QLog.d("VideoCoverFragment", 2, localStringBuilder.toString());
      }
      bool1 = bool2;
      if (!TextUtils.isEmpty(localVideoDownloadItem.f))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(localVideoDownloadItem.h))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(localVideoDownloadItem.g))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(localVideoDownloadItem.jdField_b_of_type_JavaLangString))
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty(localVideoDownloadItem.jdField_a_of_type_JavaLangString))
              {
                bool1 = bool2;
                if (!TextUtils.isEmpty(localVideoDownloadItem.jdField_c_of_type_JavaLangString))
                {
                  bool1 = bool2;
                  if (!TextUtils.isEmpty(localVideoDownloadItem.jdField_d_of_type_JavaLangString))
                  {
                    if (QLog.isColorLevel())
                    {
                      localStringBuilder = new StringBuilder();
                      localStringBuilder.append("canShowBanner jumpType = ");
                      localStringBuilder.append(localVideoDownloadItem.jdField_d_of_type_Int);
                      QLog.d("VideoCoverFragment", 2, localStringBuilder.toString());
                    }
                    if (localVideoDownloadItem.jdField_d_of_type_Int == 2)
                    {
                      if (QLog.isColorLevel())
                      {
                        localStringBuilder = new StringBuilder();
                        localStringBuilder.append("canShowBanner jumpUrl = null ");
                        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.n) ^ true);
                        QLog.d("VideoCoverFragment", 2, localStringBuilder.toString());
                      }
                      bool1 = bool2;
                      if (TextUtils.isEmpty(localVideoDownloadItem.n)) {
                        return bool1;
                      }
                    }
                    else if (localVideoDownloadItem.jdField_d_of_type_Int == 1)
                    {
                      if (QLog.isColorLevel())
                      {
                        localStringBuilder = new StringBuilder();
                        localStringBuilder.append("canShowBanner myappDownloadUrl = null ");
                        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.jdField_j_of_type_JavaLangString) ^ true);
                        QLog.d("VideoCoverFragment", 2, localStringBuilder.toString());
                      }
                      bool2 = TextUtils.isEmpty(localVideoDownloadItem.jdField_j_of_type_JavaLangString) ^ true;
                      if (QLog.isColorLevel())
                      {
                        localStringBuilder = new StringBuilder();
                        localStringBuilder.append("canShowBanner appId = null ");
                        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.k) ^ true);
                        localStringBuilder.append(" appName = null ");
                        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.m) ^ true);
                        localStringBuilder.append(" packagename = null ");
                        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.l) ^ true);
                        localStringBuilder.append(" downloadUrl = null ");
                        localStringBuilder.append(TextUtils.isEmpty(localVideoDownloadItem.jdField_i_of_type_JavaLangString) ^ true);
                        QLog.d("VideoCoverFragment", 2, localStringBuilder.toString());
                      }
                      bool1 = bool2;
                      if (TextUtils.isEmpty(localVideoDownloadItem.k)) {
                        return bool1;
                      }
                      bool1 = bool2;
                      if (TextUtils.isEmpty(localVideoDownloadItem.m)) {
                        return bool1;
                      }
                      bool1 = bool2;
                      if (TextUtils.isEmpty(localVideoDownloadItem.l)) {
                        return bool1;
                      }
                      bool1 = bool2;
                      if (TextUtils.isEmpty(localVideoDownloadItem.jdField_i_of_type_JavaLangString)) {
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
  
  private void e()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a();
    if (localTVK_IMediaPlayer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "media play is null");
      }
      return;
    }
    if (f())
    {
      AudioManager localAudioManager = this.jdField_a_of_type_AndroidMediaAudioManager;
      if (localAudioManager == null) {
        return;
      }
      int j = localAudioManager.getStreamMaxVolume(3);
      localAudioManager = this.jdField_a_of_type_AndroidMediaAudioManager;
      double d1 = j;
      Double.isNaN(d1);
      localAudioManager.setStreamVolume(3, (int)(d1 * 0.2D), 1);
      localTVK_IMediaPlayer.setOutputMute(false);
      jdField_c_of_type_Boolean = false;
      this.i = true;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130841664);
      return;
    }
    if (localTVK_IMediaPlayer.getOutputMute())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a().setOutputMute(false);
      jdField_c_of_type_Boolean = false;
      this.i = true;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130841664);
      ReportController.a(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F62", "0X8008F62", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, "", ((VideoCoverItem)this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a() != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a().setOutputMute(true);
    }
    jdField_c_of_type_Boolean = true;
    this.i = true;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130841663);
    ReportController.a(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F63", "0X8008F63", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, "", ((VideoCoverItem)this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
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
    Intent localIntent = getQBaseActivity().getIntent();
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = AdvertisementItem.a(localIntent.getStringExtra("arg_ad_json"));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = null;
    }
    AdvertisementItem localAdvertisementItem = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
    if ((localAdvertisementItem != null) && (localAdvertisementItem.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverFragment", 2, "refetchItemData failed");
    }
    return false;
  }
  
  private void f()
  {
    VideoDownloadItem localVideoDownloadItem = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem;
    Object localObject1;
    if (d())
    {
      e(true);
      if (!TextUtils.isEmpty(localVideoDownloadItem.f))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        Object localObject2 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
        localObject1 = URLDrawable.getDrawable(localVideoDownloadItem.f, (URLDrawable.URLDrawableOptions)localObject1);
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1))
        {
          localObject2 = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
          int j = ((URLDrawable)localObject1).getIntrinsicWidth();
          int k = ((URLDrawable)localObject1).getIntrinsicHeight();
          ((ViewGroup.LayoutParams)localObject2).width = (AIOUtils.b(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * j / k);
          this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new VideoCoverFragment.5(this));
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localVideoDownloadItem.g);
      if (localVideoDownloadItem.jdField_c_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setVisibility(0);
        this.jdField_g_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(localVideoDownloadItem.h);
        this.jdField_g_of_type_Boolean = true;
      }
      else if (localVideoDownloadItem.jdField_c_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setVisibility(8);
        this.jdField_g_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(localVideoDownloadItem.h);
        this.jdField_g_of_type_Boolean = false;
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
      ((StringBuilder)localObject1).append(localVideoDownloadItem.jdField_d_of_type_Boolean);
      QLog.d("VideoCoverFragment", 2, ((StringBuilder)localObject1).toString());
    }
    if (((this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_d_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_j_of_type_JavaLangString))) || ((this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_d_of_type_Int >= 2) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.n)) && (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_d_of_type_Boolean) && (this.jdField_d_of_type_Boolean)))
    {
      d(true);
      return;
    }
    d(false);
  }
  
  private boolean f()
  {
    AudioManager localAudioManager = this.jdField_a_of_type_AndroidMediaAudioManager;
    boolean bool = false;
    if (localAudioManager == null) {
      return false;
    }
    if (localAudioManager.getStreamVolume(3) == 0) {
      bool = true;
    }
    return bool;
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localObject == null) {
      return;
    }
    int m = ((AudioManager)localObject).getStreamVolume(3);
    int n = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_Int;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("audioFadeinDuration is ");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(", maxMusicVolume is ");
      ((StringBuilder)localObject).append(m);
      QLog.d("VideoCoverFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (m == 0) {
      return;
    }
    double d1 = m;
    Double.isNaN(d1);
    int k = (int)(d1 * 0.2D);
    int j = k;
    if (k < 1) {
      j = 1;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, j, 0);
    j = (int)(n * 1000.0F / m);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoCoverFragment.6(this, m, j), j);
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
    if (localTVK_IMediaPlayer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "media play is null");
      }
      return;
    }
    if (localTVK_IMediaPlayer.getOutputMute()) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a().setOutputMute(false);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateDownloadProgress progress ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("VideoCoverFragment", 2, ((StringBuilder)localObject).toString());
    if (this.jdField_g_of_type_Boolean)
    {
      if ((getQBaseActivity() != null) && (!getQBaseActivity().isFinishing()))
      {
        if (((PublicAccountAdvertisementActivity)getQBaseActivity()).b())
        {
          QLog.d("VideoCoverFragment", 2, "updateDownloadProgress appInstalled!");
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(HardCodeUtil.a(2131715878));
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839301);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
          return;
        }
        if (((PublicAccountAdvertisementActivity)getQBaseActivity()).c())
        {
          QLog.d("VideoCoverFragment", 2, "updateDownloadProgress pkgExist!");
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(HardCodeUtil.a(2131715880));
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839301);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
          return;
        }
        if (paramInt == 0)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.h);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839301);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
          return;
        }
        if (paramInt == 100)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(HardCodeUtil.a(2131715876));
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839301);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
          return;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(HardCodeUtil.a(2131715874));
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839314);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(paramInt);
        return;
      }
      QLog.e("VideoCoverFragment", 1, "updateDownloadProgress null error");
      return;
    }
    if (((PublicAccountAdvertisementActivity)getQBaseActivity()).b())
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715872));
      return;
    }
    if (((PublicAccountAdvertisementActivity)getQBaseActivity()).c())
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715879));
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.h);
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715873));
      return;
    }
    localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131715877));
    localStringBuilder.append(paramInt);
    localStringBuilder.append("%");
    ((TextView)localObject).setText(localStringBuilder.toString());
  }
  
  public void a(AdvertisementItem paramAdvertisementItem, ViewPager.OnPageChangeListener paramOnPageChangeListener, View.OnClickListener paramOnClickListener, AudioManager paramAudioManager, AdControlView paramAdControlView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = paramAdvertisementItem;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView = paramAdControlView;
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener = new VideoCoverFragment.1(this, paramOnPageChangeListener);
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
      ReportController.a(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F67", "0X8008F67", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, "", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.setVisibility(4);
  }
  
  public boolean a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("forceSetControllerPanelVisible ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem);
      if (((StringBuilder)localObject).toString() != null) {
        localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_i_of_type_Int);
      } else {
        localObject = "null";
      }
      QLog.d("VideoCoverFragment", 2, new Object[] { localObject });
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_i_of_type_Int == 2)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView;
      ((AdControlView)localObject).jdField_c_of_type_Boolean = true;
      ((AdControlView)localObject).setVisibility(0);
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
    this.jdField_f_of_type_AndroidViewView.setClickable(paramBoolean ^ true);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131380803)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b();
        if (!a()) {
          a(true);
        }
      }
      e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = getQBaseActivity();
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559591, paramViewGroup, false);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter;
    if (localObject != null) {
      ((VideoCoverAdapter)localObject).b();
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    Object localObject = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localObject != null) {
      ((AnimatorSet)localObject).cancel();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a();
    localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localObject != null) {
      ((AudioManager)localObject).abandonAudioFocus(null);
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
      if ((f()) || (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_Int == this.jdField_c_of_type_Int)) {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a();
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_Int == this.jdField_e_of_type_Int) && (this.jdField_a_of_type_Int == 0)) {
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
    else if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a(false);
    }
    AudioManager localAudioManager = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localAudioManager != null) {
      localAudioManager.requestAudioFocus(null, 3, 1);
    }
    super.onResume();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem == null) && (!e()))
    {
      getQBaseActivity().finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView == null)
    {
      if ((getQBaseActivity() instanceof PublicAccountAdvertisementActivity)) {
        ((PublicAccountAdvertisementActivity)getQBaseActivity()).c();
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
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    Object localObject = (ViewGroup)paramView;
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = ((ViewPager)((ViewGroup)localObject).findViewById(2131380686));
    this.jdField_b_of_type_AndroidViewView = ((ViewGroup)localObject).findViewById(2131368588);
    if (!a())
    {
      AdvertisementItem localAdvertisementItem = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
      if ((localAdvertisementItem != null) && (localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem != null) && (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_j_of_type_Int > 0)) {
        a(true, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_j_of_type_Int);
      }
    }
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)localObject).findViewById(2131368589);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new VideoCoverFragment.2(this));
    this.jdField_c_of_type_AndroidViewView = ((ViewGroup)localObject).findViewById(2131380574);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131380528));
    this.jdField_d_of_type_AndroidViewView = ((ViewGroup)localObject).findViewById(2131380312);
    this.jdField_e_of_type_AndroidViewView = ((ViewGroup)localObject).findViewById(2131380313);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter = new VideoCoverAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a(), this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem, new VideoCoverFragment.3(this));
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a().setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a().setTotalCount(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size());
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_f_of_type_AndroidViewView = ((ViewGroup)localObject).findViewById(2131380567);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)((ViewGroup)localObject).findViewById(2131380569));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131380568));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton = ((AdProgressButton)((ViewGroup)localObject).findViewById(2131380573));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgressColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165349));
    this.jdField_g_of_type_AndroidViewView = ((ViewGroup)localObject).findViewById(2131380571);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)localObject).findViewById(2131380570));
    f();
    d();
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment
 * JD-Core Version:    0.7.0.1
 */