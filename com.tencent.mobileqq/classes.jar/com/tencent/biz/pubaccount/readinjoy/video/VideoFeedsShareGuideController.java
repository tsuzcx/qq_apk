package com.tencent.biz.pubaccount.readinjoy.video;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.discovery.BubblePopupWindow;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.TiktokVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.concurrent.TimeUnit;

public class VideoFeedsShareGuideController
{
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716077);
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new VideoFeedsShareGuideController.1(this);
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsRecommendPresenter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter;
  private BubblePopupWindow jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private RecentUser jdField_a_of_type_ComTencentMobileqqDataRecentUser;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private BitmapDrawable jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private RecentUser jdField_b_of_type_ComTencentMobileqqDataRecentUser;
  private boolean jdField_b_of_type_Boolean;
  private Animation jdField_c_of_type_AndroidViewAnimationAnimation;
  private boolean jdField_c_of_type_Boolean = true;
  private Animation jdField_d_of_type_AndroidViewAnimationAnimation;
  private boolean jdField_d_of_type_Boolean;
  private Animation e;
  
  public VideoFeedsShareGuideController(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, VideoFeedsRecommendPresenter paramVideoFeedsRecommendPresenter, View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter = paramVideoFeedsRecommendPresenter;
    paramVideoFeedsRecommendPresenter = Aladdin.getConfig(419);
    this.jdField_a_of_type_Float = paramVideoFeedsRecommendPresenter.getFloatFromString("show_anim_percentage", 0.8F);
    this.jdField_b_of_type_Float = paramVideoFeedsRecommendPresenter.getFloatFromString("dismiss_anim_percentage", 1.0F);
    this.jdField_a_of_type_Int = (paramVideoFeedsRecommendPresenter.getIntegerFromString("is_short_video", 20) * 1000);
    if (paramVideoFeedsRecommendPresenter.getIntegerFromString("long_video_dismiss_anim_enable", 1) == 1) {}
    for (;;)
    {
      this.jdField_d_of_type_Boolean = bool;
      paramFragmentActivity = VideoFeedsHelper.a(paramQQAppInterface, paramFragmentActivity);
      this.jdField_a_of_type_ComTencentMobileqqDataRecentUser = VideoFeedsHelper.a(paramFragmentActivity);
      this.jdField_b_of_type_ComTencentMobileqqDataRecentUser = VideoFeedsHelper.b(paramFragmentActivity);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
      return;
      bool = false;
    }
  }
  
  private Drawable a()
  {
    switch ()
    {
    default: 
      return VideoFeedsResourceLoader.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2130843398);
    case 1: 
      return b();
    case 2: 
      this.jdField_b_of_type_Int = 4;
      return VideoFeedsResourceLoader.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2130843399);
    }
    this.jdField_b_of_type_Int = 5;
    return VideoFeedsResourceLoader.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2130843397);
  }
  
  private Drawable b()
  {
    int i = Aladdin.getConfig(419).getIntegerFromString("qq_guide_icon", 1);
    this.jdField_b_of_type_Int = i;
    switch (i)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            this.jdField_b_of_type_Int = 1;
            return VideoFeedsResourceLoader.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2130843398);
            return VideoFeedsResourceLoader.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2130843398);
            if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) {
              return this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser == null);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        } while (localObject == null);
        localObject = new BitmapDrawable((Bitmap)localObject);
        this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)localObject);
        return localObject;
        if (this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable != null) {
          return this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable;
        }
      } while (this.jdField_b_of_type_ComTencentMobileqqDataRecentUser == null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(113, this.jdField_b_of_type_ComTencentMobileqqDataRecentUser.uin);
    } while (localObject == null);
    Object localObject = new BitmapDrawable((Bitmap)localObject);
    this.jdField_b_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)localObject);
    return localObject;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) && ((this.jdField_c_of_type_AndroidViewAnimationAnimation == null) || (this.jdField_c_of_type_AndroidViewAnimationAnimation.hasEnded())))
    {
      AlphaAnimation localAlphaAnimation;
      if (this.jdField_d_of_type_AndroidViewAnimationAnimation == null)
      {
        localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(300L);
        this.jdField_d_of_type_AndroidViewAnimationAnimation = localAlphaAnimation;
      }
      if (this.jdField_c_of_type_AndroidViewAnimationAnimation == null)
      {
        localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation.setDuration(300L);
        localAlphaAnimation.setAnimationListener(new VideoFeedsShareGuideController.4(this));
        this.jdField_c_of_type_AndroidViewAnimationAnimation = localAlphaAnimation;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        VideoFeedsHelper.b(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.r, "分享");
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow.isShowing())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow.dismiss();
    }
  }
  
  private boolean b()
  {
    if (System.currentTimeMillis() - ((Integer)ReadInJoyHelper.a("CONFIG_LAST_SHOW_SHARE_GUIDE_DATE", Integer.valueOf(0))).intValue() > TimeUnit.DAYS.toMillis(1L)) {
      ReadInJoyHelper.a("CONFIG_TODAY_SHOW_SHARE_GUIDE_TIMES", Integer.valueOf(0));
    }
    int i = Aladdin.getConfig(419).getIntegerFromString("max_show_times", 0);
    if (((Integer)ReadInJoyHelper.a("CONFIG_TODAY_SHOW_SHARE_GUIDE_TIMES", Integer.valueOf(0))).intValue() < i)
    {
      ReadInJoyHelper.a("CONFIG_LAST_SHOW_SHARE_GUIDE_DATE", Long.valueOf(System.currentTimeMillis()));
      ReadInJoyHelper.a("CONFIG_TODAY_SHOW_SHARE_GUIDE_TIMES", Integer.valueOf(0));
      return true;
    }
    return false;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a());
      } while (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 8);
      Object localObject1;
      if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
      {
        localObject1 = new AnimationSet(false);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.1F, 0.0F, 1.1F, 1, 0.5F, 1, 0.5F);
        Object localObject2 = new AlphaAnimation(0.0F, 1.0F);
        localScaleAnimation.setDuration(300L);
        ((AlphaAnimation)localObject2).setDuration(300L);
        ((AnimationSet)localObject1).addAnimation(localScaleAnimation);
        ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
        localObject2 = new ScaleAnimation(1.1F, 1.0F, 1.1F, 1.0F, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject2).setDuration(600L);
        ((ScaleAnimation)localObject2).setRepeatMode(2);
        ((ScaleAnimation)localObject2).setRepeatCount(10);
        this.jdField_a_of_type_AndroidViewAnimationAnimation = ((Animation)localObject2);
        localScaleAnimation.setAnimationListener(new VideoFeedsShareGuideController.2(this));
        this.jdField_b_of_type_AndroidViewAnimationAnimation = ((Animation)localObject1);
      }
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        if (this.e == null)
        {
          localObject1 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new VideoFeedsShareGuideController.3(this));
          this.e = ((Animation)localObject1);
        }
        this.jdField_a_of_type_AndroidViewView.startAnimation(this.e);
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("分享");
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendPresenter.a().a("0X800B943", this.jdField_b_of_type_Int);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow.dismiss();
      return;
    }
    catch (Exception localException)
    {
      do
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow = null;
      } while (!QLog.isColorLevel());
      QLog.e("VideoFeedsShareGuideController", 2, "handleMessage: ", localException);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    b(true);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    int k = 0;
    float f = (float)paramLong1 / (float)paramLong2;
    if ((paramLong2 - this.jdField_a_of_type_Long <= 800L) && (paramLong1 < 1000L)) {}
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (paramLong2 > this.jdField_a_of_type_Int)
      {
        j = k;
        if (this.jdField_d_of_type_Boolean) {
          j = 1;
        }
      }
      if ((j != 0) && ((f >= this.jdField_b_of_type_Float) || (i != 0))) {
        a();
      }
      for (;;)
      {
        this.jdField_a_of_type_Long = paramLong1;
        return;
        if (f >= this.jdField_a_of_type_Float) {
          a(true);
        }
      }
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    Object localObject2 = null;
    this.jdField_a_of_type_AndroidViewView = paramVideoItemHolder.q;
    this.jdField_a_of_type_AndroidWidgetImageView = paramVideoItemHolder.n;
    if (paramVideoItemHolder.a != null) {}
    for (Object localObject1 = paramVideoItemHolder.a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;; localObject1 = null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)localObject1);
      localObject1 = localObject2;
      if ((paramVideoItemHolder instanceof TiktokVideoItemHolder)) {
        localObject1 = ((TiktokVideoItemHolder)paramVideoItemHolder).k();
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Long = 0L;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    if ((this.jdField_c_of_type_Boolean) && (!b()))
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if (paramBoolean)
    {
      c();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    d();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareGuideController
 * JD-Core Version:    0.7.0.1
 */