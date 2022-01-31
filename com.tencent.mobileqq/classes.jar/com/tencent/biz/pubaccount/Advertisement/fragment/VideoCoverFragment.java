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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.ArrayList;
import kwa;
import kwb;
import kwc;
import kwf;
import kwg;
import kwh;

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
  private AdvertisementItem jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
  private AdControlView jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView;
  private AdProgressButton jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new kwf(this);
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int = 1;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = 2;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean = true;
  private View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean;
  private View jdField_g_of_type_AndroidViewView;
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  
  static
  {
    jdField_c_of_type_Boolean = true;
  }
  
  private boolean a()
  {
    return (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.getVisibility() == 0);
  }
  
  @TargetApi(11)
  private void b()
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
  
  private boolean b()
  {
    VideoDownloadItem localVideoDownloadItem = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem;
    if ((localVideoDownloadItem == null) || (!localVideoDownloadItem.jdField_a_of_type_Boolean)) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while ((TextUtils.isEmpty(localVideoDownloadItem.i)) || (TextUtils.isEmpty(localVideoDownloadItem.k)) || (TextUtils.isEmpty(localVideoDownloadItem.j)) || (TextUtils.isEmpty(localVideoDownloadItem.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(localVideoDownloadItem.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localVideoDownloadItem.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(localVideoDownloadItem.jdField_d_of_type_JavaLangString)));
        if (localVideoDownloadItem.jdField_b_of_type_Int != 2) {
          break;
        }
      } while (TextUtils.isEmpty(localVideoDownloadItem.e));
      return true;
    } while ((localVideoDownloadItem.jdField_b_of_type_Int != 1) || (TextUtils.isEmpty(localVideoDownloadItem.f)) || (TextUtils.isEmpty(localVideoDownloadItem.l)) || (TextUtils.isEmpty(localVideoDownloadItem.g)) || (TextUtils.isEmpty(localVideoDownloadItem.h)));
    return true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
      if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_d_of_type_Int == this.jdField_c_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("volumeTrace", 2, "isVideoMute true");
        }
        jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130839675);
      }
      while (d())
      {
        jdField_c_of_type_Boolean = true;
        return;
        jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130839676);
        if (QLog.isColorLevel()) {
          QLog.d("volumeTrace", 2, ",music system is " + this.jdField_a_of_type_Int);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_d_of_type_Int == this.jdField_e_of_type_Int) {
          f();
        }
      }
    }
  }
  
  private boolean c()
  {
    Intent localIntent = getActivity().getIntent();
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = AdvertisementItem.a(localIntent.getStringExtra("arg_ad_json"));
      if ((this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem == null) || (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size() <= 0))
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
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = null;
      }
    }
    return true;
  }
  
  private void d()
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
      if (!d()) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidMediaAudioManager == null);
    int i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(3);
    this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, (int)(i * 0.2D), 1);
    localTVK_IMediaPlayer.setOutputMute(false);
    jdField_c_of_type_Boolean = false;
    this.h = true;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130839676);
    return;
    if (localTVK_IMediaPlayer.getOutputMute())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a().setOutputMute(false);
      jdField_c_of_type_Boolean = false;
      this.h = true;
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130839676);
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F62", "0X8008F62", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, "", ((VideoCoverItem)this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a() != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a().setOutputMute(true);
    }
    jdField_c_of_type_Boolean = true;
    this.h = true;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setBackgroundResource(2130839675);
    ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F63", "0X8008F63", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, "", ((VideoCoverItem)this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.n)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.n);
      }
      LinearLayout.LayoutParams localLayoutParams;
      for (;;)
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
        if (!this.jdField_g_of_type_Boolean) {
          break;
        }
        localLayoutParams.setMargins(0, 0, 0, AIOUtils.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localLayoutParams.setMargins(0, 0, 0, AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {}
    while (this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3) != 0) {
      return false;
    }
    return true;
  }
  
  private void e()
  {
    VideoDownloadItem localVideoDownloadItem = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem;
    if (b())
    {
      e(true);
      if (!TextUtils.isEmpty(localVideoDownloadItem.i))
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        Object localObject2 = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
        localObject1 = URLDrawable.getDrawable(localVideoDownloadItem.i, (URLDrawable.URLDrawableOptions)localObject1);
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1))
        {
          localObject2 = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
          int i = ((URLDrawable)localObject1).getIntrinsicWidth();
          int j = ((URLDrawable)localObject1).getIntrinsicHeight();
          ((ViewGroup.LayoutParams)localObject2).width = (i * AIOUtils.a(23.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) / j);
          this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new kwg(this));
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localVideoDownloadItem.j);
      if (localVideoDownloadItem.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setVisibility(0);
        this.jdField_g_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(localVideoDownloadItem.k);
        this.jdField_f_of_type_Boolean = true;
      }
    }
    while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_b_of_type_JavaLangString))
    {
      d(false);
      return;
      if (localVideoDownloadItem.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setVisibility(8);
        this.jdField_g_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(localVideoDownloadItem.k);
        this.jdField_f_of_type_Boolean = false;
        continue;
        e(false);
      }
    }
    d(true);
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_g_of_type_Boolean = false;
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {}
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
      j = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCoverFragment", 2, "audioFadeinDuration is " + j + ", maxMusicVolume is " + i);
      }
    } while (i == 0);
    this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, (int)(i * 0.2D), 0);
    int j = (int)(j * 1000.0F / i);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new kwh(this, i, j), j);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.getCount();
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
    if (this.jdField_f_of_type_Boolean)
    {
      if ((getActivity() == null) || (getActivity().isFinishing()))
      {
        QLog.e("VideoCoverFragment", 1, "updateDownloadProgress null error");
        return;
      }
      if (((PublicAccountAdvertisementActivity)getActivity()).a())
      {
        QLog.d("VideoCoverFragment", 2, "updateDownloadProgress appInstalled!");
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText("打开");
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130838514);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
        return;
      }
      if (((PublicAccountAdvertisementActivity)getActivity()).b())
      {
        QLog.d("VideoCoverFragment", 2, "updateDownloadProgress pkgExist!");
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText("安装");
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130838514);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
        return;
      }
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.k);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130838514);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
        return;
      }
      if (paramInt == 100)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText("安装");
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130838514);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText("下载");
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130838526);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(paramInt);
      return;
    }
    if (((PublicAccountAdvertisementActivity)getActivity()).a())
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText("打开");
      return;
    }
    if (((PublicAccountAdvertisementActivity)getActivity()).b())
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText("安装");
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.k);
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText("安装");
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText("下载中 " + paramInt + "%");
  }
  
  public void a(AdvertisementItem paramAdvertisementItem, ViewPager.OnPageChangeListener paramOnPageChangeListener, View.OnClickListener paramOnClickListener, AudioManager paramAudioManager, AdControlView paramAdControlView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = paramAdvertisementItem;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView = paramAdControlView;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new kwa(this, paramOnPageChangeListener);
    this.jdField_a_of_type_AndroidMediaAudioManager = paramAudioManager;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 6000L);
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F67", "0X8008F67", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, "", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.setVisibility(4);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
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
      a(true);
    }
    d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969201, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.b();
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
      b();
    }
    if (!this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a())
    {
      if ((d()) || (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_d_of_type_Int == this.jdField_c_of_type_Int)) {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a();
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_d_of_type_Int == this.jdField_e_of_type_Int) && (this.jdField_a_of_type_Int == 0)) {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a();
      }
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a().setProgress(0, 0);
      this.jdField_d_of_type_Boolean = false;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 1);
      }
      super.onResume();
      return;
      if (this.jdField_e_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter.a(false);
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem == null) && (!c()))
    {
      getActivity().finish();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    ViewGroup localViewGroup = (ViewGroup)paramView;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)localViewGroup.findViewById(2131365588));
    this.jdField_b_of_type_AndroidViewView = localViewGroup.findViewById(2131365590);
    this.jdField_a_of_type_AndroidViewView = localViewGroup.findViewById(2131365589);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new kwb(this));
    this.jdField_c_of_type_AndroidViewView = localViewGroup.findViewById(2131365592);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131365591));
    this.jdField_d_of_type_AndroidViewView = localViewGroup.findViewById(2131365593);
    this.jdField_e_of_type_AndroidViewView = localViewGroup.findViewById(2131365594);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter = new VideoCoverAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a(), this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem, new kwc(this));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementAdapterVideoCoverAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a().setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.b().setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdControlView.a().setTotalCount(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.size());
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_f_of_type_AndroidViewView = localViewGroup.findViewById(2131365595);
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localViewGroup.findViewById(2131365596));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131365598));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton = ((AdProgressButton)localViewGroup.findViewById(2131365597));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgressColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493308));
    this.jdField_g_of_type_AndroidViewView = localViewGroup.findViewById(2131365599);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131365600));
    e();
    c();
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment
 * JD-Core Version:    0.7.0.1
 */