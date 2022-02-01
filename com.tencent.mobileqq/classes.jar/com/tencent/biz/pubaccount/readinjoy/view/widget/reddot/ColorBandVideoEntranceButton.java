package com.tencent.biz.pubaccount.readinjoy.view.widget.reddot;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJSmartCropUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager.OnSkinChangedListener;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager.EntranceIconInfo;
import com.tencent.biz.pubaccount.util.GifHelper;
import com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.ApngImage;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import cooperation.readinjoy.ReadInJoyHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;

public class ColorBandVideoEntranceButton
  extends FrameLayout
  implements View.OnClickListener, ReadInJoySkinManager.OnSkinChangedListener, RedDotView<IEntranceButtonDataSource>, URLDrawable.URLDrawableListener2
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  Animator jdField_a_of_type_AndroidAnimationAnimator;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  protected Drawable a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  protected ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ColorBandVideoEntranceButton.10(this);
  protected KanDianUrlRoundCornerImageView a;
  private IEntranceButtonDataSource jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource;
  private ApngDrawable.OnPlayRepeatListener jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener;
  protected URLDrawable a;
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new ColorBandVideoEntranceButton.1(this);
  protected URLImageView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new ColorBandVideoEntranceButton.12(this);
  private Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new ColorBandVideoEntranceButton.14(this);
  public boolean a;
  private int jdField_b_of_type_Int;
  Animator jdField_b_of_type_AndroidAnimationAnimator;
  private AnimatorSet jdField_b_of_type_AndroidAnimationAnimatorSet;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  protected ImageView b;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private KanDianUrlRoundCornerImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
  private URLDrawable jdField_b_of_type_ComTencentImageURLDrawable;
  Runnable jdField_b_of_type_JavaLangRunnable = new ColorBandVideoEntranceButton.13(this);
  private Function1<Canvas, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1 = new ColorBandVideoEntranceButton.15(this);
  private boolean jdField_b_of_type_Boolean;
  Animator jdField_c_of_type_AndroidAnimationAnimator;
  private AnimatorSet jdField_c_of_type_AndroidAnimationAnimatorSet;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  Animator jdField_d_of_type_AndroidAnimationAnimator;
  private AnimatorSet jdField_d_of_type_AndroidAnimationAnimatorSet;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean = false;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private boolean jdField_e_of_type_Boolean = false;
  private ImageView f;
  
  public ColorBandVideoEntranceButton(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    j();
  }
  
  public ColorBandVideoEntranceButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    j();
  }
  
  private Drawable a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (int i = RecommendFeedsDiandianEntranceManager.c();; i = 2130842985) {
      return getResources().getDrawable(i);
    }
  }
  
  private Drawable a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a();
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a();
      }
    }
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return HardCodeUtil.a(2131718599);
    case 1: 
      return HardCodeUtil.a(2131718600);
    }
    return HardCodeUtil.a(2131718598);
  }
  
  private String a(RecommendFeedsDiandianEntranceManager.EntranceIconInfo paramEntranceIconInfo)
  {
    return a(paramEntranceIconInfo.d) + " " + a(paramEntranceIconInfo.jdField_b_of_type_Int);
  }
  
  private String a(String paramString)
  {
    float f1 = 0.0F;
    int i = 0;
    float f2;
    if (i < paramString.length()) {
      if (StringUtil.c(paramString.charAt(i)))
      {
        f2 = 2.0F;
        label28:
        f1 += f2;
        if (f1 <= 16.0F) {
          break label85;
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      String str = paramString;
      if (j != 0) {
        str = paramString.substring(0, i) + "...";
      }
      return str;
      f2 = 1.0F;
      break label28;
      label85:
      i += 1;
      break;
    }
  }
  
  private void a(View paramView)
  {
    if (a())
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      c();
      this.jdField_b_of_type_Boolean = false;
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
      }
    }
  }
  
  private void a(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    paramView.clearAnimation();
    paramView.setScaleX(paramFloat);
    paramView.setScaleX(paramFloat);
  }
  
  private void a(ImageView paramImageView)
  {
    paramImageView = paramImageView.getLayoutParams();
    this.jdField_a_of_type_Int = paramImageView.width;
    this.jdField_b_of_type_Int = paramImageView.height;
    if (QLog.isColorLevel()) {
      QLog.d("ColorBandVideoEntranceButton", 2, "initCoverImageSize, width: " + this.jdField_a_of_type_Int + ", height: " + this.jdField_b_of_type_Int);
    }
  }
  
  private void a(RecommendFeedsDiandianEntranceManager.EntranceIconInfo paramEntranceIconInfo)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(paramEntranceIconInfo));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      n();
    }
  }
  
  private void a(RIJColumnDataSource paramRIJColumnDataSource)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (paramRIJColumnDataSource == null);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramRIJColumnDataSource.a))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramRIJColumnDataSource.a);
      }
    } while ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(paramRIJColumnDataSource.jdField_b_of_type_JavaLangString)));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramRIJColumnDataSource.jdField_b_of_type_JavaLangString);
  }
  
  private void a(ApngDrawable paramApngDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener == null) {
      this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener = new ColorBandVideoEntranceButton.11(this);
    }
    paramApngDrawable.setOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener);
    paramApngDrawable.repaly();
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && ((paramURLDrawable.getCurrDrawable() instanceof ApngDrawable))) {
      postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1800L);
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView == null) {
      return;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleX", new float[] { 0.2F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleY", new float[] { 0.2F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleX", new float[] { 0.2F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleY", new float[] { 0.2F, 1.0F }) });
    localAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet.setDuration(400L);
    if (!TextUtils.isEmpty(paramString)) {
      localAnimatorSet.addListener(new ColorBandVideoEntranceButton.6(this, paramString));
    }
    localAnimatorSet.start();
  }
  
  private void a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey("target")) && (paramMap.containsKey("channelid")))
    {
      String str = (String)paramMap.get("target");
      paramMap = (String)paramMap.get("channelid");
      if (("2".equals(str)) && (String.valueOf(70).equals(paramMap))) {
        ReadInJoyHelper.a("key_sp_entrance_follow", Boolean.valueOf(true));
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    b(paramBoolean);
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    if (paramBoolean)
    {
      i = 8;
      localImageView.setVisibility(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      if (!paramBoolean) {
        break label148;
      }
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      t();
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(this.jdField_a_of_type_Int / 2);
    }
    for (;;)
    {
      a(true);
      a(this.jdField_a_of_type_Boolean, false);
      QLog.d("ColorBandVideoEntranceButton", 1, "showColumnDiandian! showColumnDiandian=" + paramBoolean);
      return;
      i = 0;
      break;
      label148:
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(this.jdField_a_of_type_Int / 2);
      ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
      localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Int;
      if (paramBoolean1)
      {
        localURLDrawableOptions.mUseApngImage = true;
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_loop", 1);
        localURLDrawableOptions.mExtraInfo = localBundle;
      }
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    } while (!paramBoolean2);
    if (paramString.getStatus() == 1)
    {
      onLoadSuccessed(paramString);
      return;
    }
    paramString.setURLDrawableListener(this);
    paramString.startDownload();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (paramBoolean1) {
      localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    }
    for (;;)
    {
      try
      {
        localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        int i = ((FrameLayout.LayoutParams)localObject).bottomMargin;
        int k = ((FrameLayout.LayoutParams)localObject).rightMargin;
        int j = ((FrameLayout.LayoutParams)localObject).width;
        localObject = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
        k -= DisplayUtil.a(getContext(), 12.0F);
        i += j + (DisplayUtil.a(getContext(), 30.0F) - ((FrameLayout.LayoutParams)localObject).width);
        ((FrameLayout.LayoutParams)localObject).bottomMargin = i;
        ((FrameLayout.LayoutParams)localObject).rightMargin = k;
        this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (FrameLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).bottomMargin = i;
        ((FrameLayout.LayoutParams)localObject).rightMargin = k;
        this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      catch (Exception localException)
      {
        QLog.d("ColorBandVideoEntranceButton", 1, "updateSkinPosition error!  msg=" + localException);
      }
      if (paramBoolean2) {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
      } else {
        localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      }
    }
  }
  
  private boolean a()
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L;
  }
  
  private boolean a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    return paramIEntranceButtonDataSource instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo;
  }
  
  private void b(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if ((paramIEntranceButtonDataSource instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo)) {
      a(URLUtil.a(((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)paramIEntranceButtonDataSource).c));
    }
  }
  
  private void b(URLDrawable paramURLDrawable)
  {
    if (!this.jdField_b_of_type_Boolean) {
      QLog.d("ColorBandVideoEntranceButton", 1, "has no red dot");
    }
    do
    {
      do
      {
        return;
        QLog.d("ColorBandVideoEntranceButton", 1, "isHasRedDot updateAnimation");
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        if ((paramURLDrawable != null) && ((paramURLDrawable.getCurrDrawable() instanceof ApngDrawable)) && (((ApngDrawable)paramURLDrawable.getCurrDrawable()).getImage() != null))
        {
          Bitmap localBitmap = ((ApngDrawable)paramURLDrawable.getCurrDrawable()).getImage().getCurrentFrame();
          if (localBitmap != null) {
            localBitmap.eraseColor(0);
          }
        }
      } while (paramURLDrawable == null);
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramURLDrawable);
    } while (paramURLDrawable.getStatus() != 1);
    a(paramURLDrawable);
  }
  
  private void b(String paramString)
  {
    QLog.d("ColorBandVideoEntranceButton", 1, "loadUpdateAnimation: " + paramString);
    VasApngFactory.Options localOptions = new VasApngFactory.Options();
    localOptions.a(new ColorDrawable(7));
    localOptions.b(this.jdField_a_of_type_Int);
    localOptions.c(this.jdField_b_of_type_Int);
    localOptions.a(1);
    b(VasApngFactory.a(paramString, localOptions));
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(a());
    ImageView localImageView = this.jdField_e_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0.0F);
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, 0.0F);
      a(this.f, 0.0F);
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
      return;
    }
  }
  
  private void c(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    post(new ColorBandVideoEntranceButton.5(this, paramIEntranceButtonDataSource));
  }
  
  private void c(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((paramURLDrawable instanceof ApngDrawable))
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource instanceof RIJColumnDataSource)) {
        this.jdField_d_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
      {
        paramURLDrawable = this.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
        if ((paramURLDrawable instanceof ApngDrawable))
        {
          a((ApngDrawable)paramURLDrawable);
          this.jdField_c_of_type_Boolean = false;
          this.jdField_d_of_type_Boolean = false;
        }
      }
      return;
      this.jdField_e_of_type_Boolean = true;
      continue;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setImageDrawable(paramURLDrawable);
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  private void c(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (!TextUtils.isEmpty(paramString))
    {
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
      localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Int;
    }
    try
    {
      URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions).startDownload();
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ColorBandVideoEntranceButton", 2, "url format error: " + paramString);
    }
  }
  
  private void d(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (paramIEntranceButtonDataSource == null) {
      return;
    }
    if (paramIEntranceButtonDataSource.c())
    {
      e(paramIEntranceButtonDataSource);
      return;
    }
    c(paramIEntranceButtonDataSource.d());
  }
  
  private void e(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (paramIEntranceButtonDataSource == null) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!(paramIEntranceButtonDataSource instanceof RIJColumnDataSource));
    a((RIJColumnDataSource)paramIEntranceButtonDataSource);
    u();
    a(true, RIJColumnDataSource.g, true);
    a(false, paramIEntranceButtonDataSource.d(), true);
    return;
    if (paramIEntranceButtonDataSource.b())
    {
      if (!TextUtils.isEmpty(paramIEntranceButtonDataSource.c())) {}
      for (;;)
      {
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions1 = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions1.mLoadingDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
          localURLDrawableOptions1.mRequestWidth = this.jdField_a_of_type_Int;
          localURLDrawableOptions1.mRequestHeight = this.jdField_b_of_type_Int;
          localURLDrawableOptions1.mPlayGifImage = true;
          this.jdField_b_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramIEntranceButtonDataSource.c(), localURLDrawableOptions1);
          this.jdField_b_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
          this.jdField_b_of_type_ComTencentImageURLDrawable.startDownload();
          c(paramIEntranceButtonDataSource.d());
          return;
        }
        catch (Exception localException1)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ColorBandVideoEntranceButton", 2, "url error: " + localException1.getMessage());
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ColorBandVideoEntranceButton", 2, "url is null");
        }
      }
    }
    Object localObject = paramIEntranceButtonDataSource.d();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorBandVideoEntranceButton", 2, "rawUrl: " + (String)localObject);
      }
      localObject = RIJSmartCropUtils.a((String)localObject, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("ColorBandVideoEntranceButton", 1, "showCover(): startDownload smartCutUrl: " + (String)localObject + "，mWidth:" + this.jdField_a_of_type_Int + ", mHeight:" + this.jdField_b_of_type_Int);
      }
    }
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions2 = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions2.mLoadingDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        localURLDrawableOptions2.mRequestWidth = this.jdField_a_of_type_Int;
        localURLDrawableOptions2.mRequestHeight = this.jdField_b_of_type_Int;
        this.jdField_b_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions2);
        if ((this.jdField_b_of_type_ComTencentImageURLDrawable.getStatus() != 1) || (!(this.jdField_b_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable))) {
          continue;
        }
        onLoadSuccessed(this.jdField_b_of_type_ComTencentImageURLDrawable);
        paramIEntranceButtonDataSource.b((String)localObject);
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ColorBandVideoEntranceButton", 2, "url error: " + localException2.getMessage());
        continue;
      }
      if ((!paramIEntranceButtonDataSource.d()) || (TextUtils.isEmpty(paramIEntranceButtonDataSource.e()))) {
        break;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = a(false);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramIEntranceButtonDataSource.e(), (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      return;
      this.jdField_b_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
      this.jdField_b_of_type_ComTencentImageURLDrawable.startDownload();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ColorBandVideoEntranceButton", 2, "url is null");
      }
    }
  }
  
  private void j()
  {
    inflate(getContext(), 2131560222, this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131381597);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376586));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369790));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)findViewById(2131376588));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setOnClickListener(this);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(this.jdField_a_of_type_Int / 2);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381637));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381636));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840616);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131376587));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372295));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372294));
    l();
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364988));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)findViewById(2131364982));
    this.f = ((ImageView)findViewById(2131376828));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364992));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364991));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364996));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364995));
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setScaleX(0.2F);
    this.jdField_a_of_type_AndroidViewView.setScaleY(0.2F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setScaleX(0.2F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setScaleY(0.2F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, AIOUtils.a(21.0F, getResources()) });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, AIOUtils.a(21.0F, getResources()) });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 0.38F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.0F, 0.38F });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4 });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(333L);
    this.jdField_b_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_b_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleX", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleY", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleX", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleY", new float[] { 0.2F, 1.1F, 1.0F }) });
    this.jdField_b_of_type_AndroidAnimationAnimatorSet.setDuration(400L);
    localObjectAnimator1.addUpdateListener(new ColorBandVideoEntranceButton.3(this));
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  private void l()
  {
    Object localObject = (ReadInJoySkinManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    BaseSkinRes localBaseSkinRes = ((ReadInJoySkinManager)localObject).a(3);
    if (localBaseSkinRes != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localBaseSkinRes.a());
    }
    localObject = ((ReadInJoySkinManager)localObject).a(2);
    if (localObject != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(((BaseSkinRes)localObject).a());
    }
  }
  
  private void m()
  {
    p();
    a();
  }
  
  private void n()
  {
    if ((this.jdField_c_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_c_of_type_AndroidAnimationAnimatorSet.isStarted())) {
      this.jdField_c_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    this.jdField_c_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_c_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "scaleX", new float[] { 0.5F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "scaleY", new float[] { 0.5F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "translationX", new float[] { 2.0F, 0.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "translationY", new float[] { 40.0F, 20.0F, 0.0F }) });
    this.jdField_c_of_type_AndroidAnimationAnimatorSet.setDuration(300L);
    this.jdField_c_of_type_AndroidAnimationAnimatorSet.addListener(new ColorBandVideoEntranceButton.7(this));
    this.jdField_c_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPivotX(this.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPivotY(this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight());
    if ((this.jdField_d_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_d_of_type_AndroidAnimationAnimatorSet.isStarted())) {
      this.jdField_d_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    this.jdField_d_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_d_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "scaleX", new float[] { 1.0F, 0.5F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "scaleY", new float[] { 1.0F, 0.5F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "translationX", new float[] { 0.0F, 2.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "translationY", new float[] { 0.0F, 20.0F, 40.0F }) });
    this.jdField_d_of_type_AndroidAnimationAnimatorSet.setDuration(300L);
    this.jdField_d_of_type_AndroidAnimationAnimatorSet.addListener(new ColorBandVideoEntranceButton.8(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.postDelayed(new ColorBandVideoEntranceButton.9(this), 2500L);
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    if ((this.jdField_b_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_b_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.cancel();
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!this.jdField_b_of_type_Boolean)
    {
      k();
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    a(null);
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    String str = "https://pub.idqqimg.com/pc/misc/files/20200805/6b42a020cbde489889a5c7ea52bdd5ed.png";
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo)) {
      str = ((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource).jdField_b_of_type_JavaLangString;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      a(str);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    a(str);
  }
  
  private void s()
  {
    if (ReadInJoyHelper.x()) {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        a(this.jdField_a_of_type_Boolean);
        setDataSource(null);
        this.jdField_e_of_type_Boolean = false;
      }
    }
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    a(this.jdField_a_of_type_Boolean);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator == null) {
      this.jdField_a_of_type_AndroidAnimationAnimator = AnimatorInflater.loadAnimator(getContext(), 2130903042);
    }
    if (this.jdField_b_of_type_AndroidAnimationAnimator == null) {
      this.jdField_b_of_type_AndroidAnimationAnimator = AnimatorInflater.loadAnimator(getContext(), 2130903043);
    }
    if (this.jdField_c_of_type_AndroidAnimationAnimator == null) {
      this.jdField_c_of_type_AndroidAnimationAnimator = AnimatorInflater.loadAnimator(getContext(), 2130903044);
    }
    if (this.jdField_d_of_type_AndroidAnimationAnimator == null) {
      this.jdField_d_of_type_AndroidAnimationAnimator = AnimatorInflater.loadAnimator(getContext(), 2130903041);
    }
  }
  
  private void u()
  {
    a(this.jdField_e_of_type_AndroidWidgetImageView, 1.0F);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0.0F);
    a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, 0.0F);
    a(this.f, 0.0F);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public IEntranceButtonDataSource a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource;
  }
  
  public void a()
  {
    d();
    this.jdField_b_of_type_Boolean = false;
    a(this.jdField_a_of_type_Boolean, false);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  public void a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (paramIEntranceButtonDataSource != null) {
      c(paramIEntranceButtonDataSource);
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (!this.jdField_a_of_type_Boolean)) {
      onClick(this.jdField_a_of_type_AndroidWidgetImageView);
    }
  }
  
  protected void c()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.0F, 0.5F, 1.0F }), ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.0F, 0.5F, 1.0F }) });
    int[] arrayOfInt1 = new int[2];
    getLocationOnScreen(arrayOfInt1);
    int[] arrayOfInt2 = new int[2];
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (this.jdField_a_of_type_Boolean) {
      localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    }
    ((View)localObject).getLocationOnScreen(arrayOfInt2);
    setPivotX(arrayOfInt2[0] - arrayOfInt1[0] + this.jdField_a_of_type_Int / 2);
    setPivotY(arrayOfInt2[1] - arrayOfInt1[1] + this.jdField_b_of_type_Int / 2);
    localAnimatorSet.setDuration(600L);
    localAnimatorSet.setInterpolator(new OvershootInterpolator());
    localAnimatorSet.addListener(new ColorBandVideoEntranceButton.4(this));
    localAnimatorSet.start();
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      b(this.jdField_a_of_type_Boolean);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(0.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setTranslationY(0.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(1.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(1.0F);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getVisibility() != 8))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setImageDrawable(null);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(false));
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
  }
  
  public void e()
  {
    s();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource == null)
    {
      p();
      d();
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
        a(true, RIJColumnDataSource.h, true);
      }
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource.b()))
    {
      AbstractGifImage.pauseAll();
      GifHelper.b();
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource.b()))
    {
      AbstractGifImage.resumeAll();
      GifHelper.a();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource instanceof RIJColumnDataSource)))
    {
      t();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPivotX(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPivotY(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() / 2);
      this.jdField_a_of_type_AndroidAnimationAnimator.setTarget(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidAnimationAnimator.start();
      this.jdField_b_of_type_AndroidAnimationAnimator.setTarget(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView);
      this.jdField_b_of_type_AndroidAnimationAnimator.start();
      this.jdField_c_of_type_AndroidAnimationAnimator.setTarget(this.f);
      this.jdField_c_of_type_AndroidAnimationAnimator.start();
      postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
    }
  }
  
  public void i()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView);
      continue;
      paramView.setTag(Integer.valueOf(RIJColumnDataSource.c));
      a(paramView);
    }
  }
  
  public void onFileDownloaded(URLDrawable paramURLDrawable)
  {
    this.jdField_b_of_type_ComTencentImageURLDrawable = null;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ColorBandVideoEntranceButton", 2, "onLoadCanceled");
    }
    this.jdField_b_of_type_ComTencentImageURLDrawable = null;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ColorBandVideoEntranceButton", 2, "onLoadFialed: " + paramThrowable.getMessage());
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.d("ColorBandVideoEntranceButton", 1, "loadSuccess, start setImage, dataSource=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource);
    if (this.jdField_a_of_type_Boolean) {
      c(paramURLDrawable);
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource == null) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setImageDrawable(paramURLDrawable);
      if (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo)) {
        break label188;
      }
      r();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Boolean, true);
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource.d()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource.e()))) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
      return;
      label188:
      q();
    }
  }
  
  public void setDataSource(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    QLog.d("ColorBandVideoEntranceButton", 1, "setDataSource: " + paramIEntranceButtonDataSource);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotIEntranceButtonDataSource = paramIEntranceButtonDataSource;
    b(paramIEntranceButtonDataSource);
  }
  
  public void setDefaultDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setDefaultIconBigMode(int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = AIOUtils.a(paramInt1, getContext().getResources());
    localLayoutParams.height = AIOUtils.a(paramInt2, getContext().getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  public void setNotMsg()
  {
    post(new ColorBandVideoEntranceButton.2(this));
  }
  
  public void setOnVideoCoverClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton
 * JD-Core Version:    0.7.0.1
 */