package com.tencent.biz.pubaccount.readinjoy.view.widget.reddot;

import afur;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import bggq;
import bmqa;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import pha;
import pmk;
import pmn;
import rcr;
import rdd;
import rdq;
import tjz;
import tka;
import tkb;
import tkc;
import tkd;
import tke;
import tkf;
import tkg;
import txa;
import uad;

public class ColorBandVideoEntranceButton
  extends FrameLayout
  implements View.OnClickListener, URLDrawable.URLDrawableListener2, rdq
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  Animator jdField_a_of_type_AndroidAnimationAnimator;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  protected Drawable a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  protected ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected KanDianUrlRoundCornerImageView a;
  private ApngDrawable.OnPlayRepeatListener jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener;
  protected URLDrawable a;
  Runnable jdField_a_of_type_JavaLangRunnable = new ColorBandVideoEntranceButton.7(this);
  private Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new tkd(this);
  pmn jdField_a_of_type_Pmn = new tkb(this);
  private tkf jdField_a_of_type_Tkf;
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
  private Function1<Canvas, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1 = new tke(this);
  private boolean jdField_b_of_type_Boolean;
  Animator jdField_c_of_type_AndroidAnimationAnimator;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  Animator jdField_d_of_type_AndroidAnimationAnimator;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private boolean jdField_e_of_type_Boolean;
  private ImageView f;
  
  public ColorBandVideoEntranceButton(@NonNull Context paramContext)
  {
    super(paramContext);
    j();
  }
  
  public ColorBandVideoEntranceButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    j();
  }
  
  private Drawable a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (int i = RecommendFeedsDiandianEntranceManager.b();; i = 2130842739) {
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
  
  private void a(ApngDrawable paramApngDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener == null) {
      this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener = new tkc(this);
    }
    paramApngDrawable.setOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener);
    paramApngDrawable.repaly();
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((paramURLDrawable instanceof ApngDrawable))
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
      if ((this.jdField_a_of_type_Tkf instanceof tkg)) {
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
  
  private void a(String paramString)
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
  
  private void a(tkg paramtkg)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (paramtkg == null);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramtkg.a))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramtkg.a);
      }
    } while ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(paramtkg.b)));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramtkg.a);
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
      pmk.a().a(this.jdField_a_of_type_Pmn);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      q();
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
      pmk.a().b(this.jdField_a_of_type_Pmn);
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
        k -= bggq.a(getContext(), 12.0F);
        i += j + (bggq.a(getContext(), 30.0F) - ((FrameLayout.LayoutParams)localObject).width);
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
  
  private void b(tkf paramtkf)
  {
    post(new ColorBandVideoEntranceButton.4(this, paramtkf));
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
  
  private void c(tkf paramtkf)
  {
    if (paramtkf == null) {
      return;
    }
    if (paramtkf.c())
    {
      d(paramtkf);
      return;
    }
    a(paramtkf.d());
  }
  
  private void d(tkf paramtkf)
  {
    if (paramtkf == null) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!(paramtkf instanceof tkg));
    a((tkg)paramtkf);
    r();
    a(true, tkg.g, true);
    a(false, paramtkf.d(), true);
    return;
    if (paramtkf.b())
    {
      if (!TextUtils.isEmpty(paramtkf.c())) {}
      for (;;)
      {
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions1 = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions1.mLoadingDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
          localURLDrawableOptions1.mRequestWidth = this.jdField_a_of_type_Int;
          localURLDrawableOptions1.mRequestHeight = this.jdField_b_of_type_Int;
          localURLDrawableOptions1.mPlayGifImage = true;
          this.jdField_b_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramtkf.c(), localURLDrawableOptions1);
          this.jdField_b_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
          this.jdField_b_of_type_ComTencentImageURLDrawable.startDownload();
          a(paramtkf.d());
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
    Object localObject = paramtkf.d();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorBandVideoEntranceButton", 2, "rawUrl: " + (String)localObject);
      }
      localObject = pha.a((String)localObject, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("ColorBandVideoEntranceButton", 2, "showCover(): startDownload smartCutUrl: " + (String)localObject + "，mWidth:" + this.jdField_a_of_type_Int + ", mHeight:" + this.jdField_b_of_type_Int);
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
        paramtkf.a((String)localObject);
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ColorBandVideoEntranceButton", 2, "url error: " + localException2.getMessage());
        continue;
      }
      if ((!paramtkf.d()) || (TextUtils.isEmpty(paramtkf.e()))) {
        break;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = a(false);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramtkf.e(), (URLDrawable.URLDrawableOptions)localObject);
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
    inflate(getContext(), 2131560079, this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131380872);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376048));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369264));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)findViewById(2131376049));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setOnClickListener(this);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(this.jdField_a_of_type_Int / 2);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380914));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380913));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840393);
    l();
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364701));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)findViewById(2131364695));
    this.f = ((ImageView)findViewById(2131376278));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364705));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364704));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364709));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364708));
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
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, afur.a(21.0F, getResources()) });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, afur.a(21.0F, getResources()) });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 0.38F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.0F, 0.38F });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4 });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(333L);
    this.jdField_b_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_b_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleX", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleY", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleX", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleY", new float[] { 0.2F, 1.1F, 1.0F }) });
    this.jdField_b_of_type_AndroidAnimationAnimatorSet.setDuration(400L);
    localObjectAnimator1.addUpdateListener(new tjz(this));
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  private void l()
  {
    Object localObject = (rdd)pha.a().getManager(261);
    rcr localrcr = ((rdd)localObject).a(3);
    if (localrcr != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localrcr.a());
    }
    localObject = ((rdd)localObject).a(2);
    if (localObject != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(((rcr)localObject).a());
    }
  }
  
  private void m()
  {
    o();
    a();
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setScaleX(0.3F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setScaleY(0.3F);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleX", new float[] { 0.3F, 1.1F, 0.8F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleY", new float[] { 0.3F, 1.1F, 0.8F, 1.0F }) });
    localAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet.setDuration(400L);
    localAnimatorSet.start();
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    if ((this.jdField_b_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_b_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.cancel();
    }
  }
  
  private void p()
  {
    if (bmqa.s()) {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        a(this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_Tkf = null;
        this.jdField_e_of_type_Boolean = false;
      }
    }
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    a(this.jdField_a_of_type_Boolean);
  }
  
  private void q()
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
  
  private void r()
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
  
  public tkf a()
  {
    return this.jdField_a_of_type_Tkf;
  }
  
  public void a()
  {
    d();
    this.jdField_b_of_type_Boolean = false;
    a(this.jdField_a_of_type_Boolean, false);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    l();
  }
  
  public void a(tkf paramtkf)
  {
    if (paramtkf != null) {
      b(paramtkf);
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
    localAnimatorSet.addListener(new tka(this));
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
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    uad.a.a(paramCanvas, true, this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
  }
  
  public void draw(Canvas paramCanvas)
  {
    uad.a.a(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
  }
  
  public void e()
  {
    p();
    if (this.jdField_a_of_type_Tkf == null)
    {
      o();
      d();
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
        a(true, tkg.h, true);
      }
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Tkf != null) && (this.jdField_a_of_type_Tkf.b()))
    {
      AbstractGifImage.pauseAll();
      txa.b();
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Tkf != null) && (this.jdField_a_of_type_Tkf.b()))
    {
      AbstractGifImage.resumeAll();
      txa.a();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && ((this.jdField_a_of_type_Tkf instanceof tkg)))
    {
      q();
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
    pmk.a().b(this.jdField_a_of_type_Pmn);
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
      paramView.setTag(Integer.valueOf(tkg.c));
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
    if (QLog.isColorLevel()) {
      QLog.d("ColorBandVideoEntranceButton", 2, "loadSuccess, start setImage, dataSource=" + this.jdField_a_of_type_Tkf);
    }
    if (this.jdField_a_of_type_Boolean) {
      a(paramURLDrawable);
    }
    while (this.jdField_a_of_type_Tkf == null) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setImageDrawable(paramURLDrawable);
      if (this.jdField_b_of_type_Boolean) {
        break label221;
      }
      k();
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Boolean, true);
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Tkf.d()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Tkf.e()))) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
      return;
      label221:
      n();
    }
  }
  
  public void setDataSource(tkf paramtkf)
  {
    this.jdField_a_of_type_Tkf = paramtkf;
  }
  
  public void setDefaultDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setDefaultIconBigMode(int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = afur.a(paramInt1, getContext().getResources());
    localLayoutParams.height = afur.a(paramInt2, getContext().getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  public void setNotMsg()
  {
    post(new ColorBandVideoEntranceButton.1(this));
  }
  
  public void setOnVideoCoverClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton
 * JD-Core Version:    0.7.0.1
 */