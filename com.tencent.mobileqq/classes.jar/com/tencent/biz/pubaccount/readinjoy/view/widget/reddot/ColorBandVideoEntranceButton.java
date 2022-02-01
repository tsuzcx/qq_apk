package com.tencent.biz.pubaccount.readinjoy.view.widget.reddot;

import agej;
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
import bhgr;
import bnrf;
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
import ozs;
import pfd;
import pfh;
import qtk;
import qtw;
import quj;
import tat;
import tau;
import tav;
import taw;
import tax;
import tay;
import taz;
import txc;
import uaf;

public class ColorBandVideoEntranceButton
  extends FrameLayout
  implements View.OnClickListener, URLDrawable.URLDrawableListener2, quj
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
  private Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new taw(this);
  pfh jdField_a_of_type_Pfh = new tau(this);
  private tay jdField_a_of_type_Tay;
  public boolean a;
  private int jdField_b_of_type_Int;
  Animator jdField_b_of_type_AndroidAnimationAnimator;
  private AnimatorSet jdField_b_of_type_AndroidAnimationAnimatorSet;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  protected ImageView b;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected KanDianUrlRoundCornerImageView b;
  private URLDrawable jdField_b_of_type_ComTencentImageURLDrawable;
  private Function1<Canvas, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1 = new tax(this);
  private boolean jdField_b_of_type_Boolean;
  Animator jdField_c_of_type_AndroidAnimationAnimator;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private KanDianUrlRoundCornerImageView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
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
    for (int i = RecommendFeedsDiandianEntranceManager.b();; i = 2130842753) {
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
      this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener = new tav(this);
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
      if ((this.jdField_a_of_type_Tay instanceof taz)) {
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
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setImageDrawable(paramURLDrawable);
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
  
  private void a(taz paramtaz)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (paramtaz == null);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramtaz.a))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramtaz.a);
      }
    } while ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(paramtaz.b)));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramtaz.a);
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
      pfd.a().a(this.jdField_a_of_type_Pfh);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      p();
      a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(this.jdField_a_of_type_Int / 2);
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
      pfd.a().b(this.jdField_a_of_type_Pfh);
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
        k -= bhgr.a(getContext(), 12.0F);
        i += j + (bhgr.a(getContext(), 30.0F) - ((FrameLayout.LayoutParams)localObject).width);
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
  
  private void b(tay paramtay)
  {
    post(new ColorBandVideoEntranceButton.4(this, paramtay));
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
      a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, 0.0F);
      a(this.f, 0.0F);
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
      return;
    }
  }
  
  private void c(tay paramtay)
  {
    if (paramtay == null) {
      return;
    }
    if (paramtay.c())
    {
      d(paramtay);
      return;
    }
    a(paramtay.d());
  }
  
  private void d(tay paramtay)
  {
    if (paramtay == null) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!(paramtay instanceof taz));
    a((taz)paramtay);
    q();
    a(true, taz.g, true);
    a(false, paramtay.d(), true);
    return;
    if (paramtay.b())
    {
      if (!TextUtils.isEmpty(paramtay.c())) {}
      for (;;)
      {
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions1 = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions1.mLoadingDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
          localURLDrawableOptions1.mRequestWidth = this.jdField_a_of_type_Int;
          localURLDrawableOptions1.mRequestHeight = this.jdField_b_of_type_Int;
          localURLDrawableOptions1.mPlayGifImage = true;
          this.jdField_b_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramtay.c(), localURLDrawableOptions1);
          this.jdField_b_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
          this.jdField_b_of_type_ComTencentImageURLDrawable.startDownload();
          a(paramtay.d());
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
    Object localObject = paramtay.d();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorBandVideoEntranceButton", 2, "rawUrl: " + (String)localObject);
      }
      localObject = ozs.a((String)localObject, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
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
        paramtay.b((String)localObject);
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ColorBandVideoEntranceButton", 2, "url error: " + localException2.getMessage());
        continue;
      }
      if ((!paramtay.d()) || (TextUtils.isEmpty(paramtay.e()))) {
        break;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = a(false);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramtay.e(), (URLDrawable.URLDrawableOptions)localObject);
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
    inflate(getContext(), 2131560091, this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131381050);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376188));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369354));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)findViewById(2131376190));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setOnClickListener(this);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(this.jdField_a_of_type_Int / 2);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381094));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381093));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840403);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)findViewById(2131376189));
    k();
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364747));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)findViewById(2131364741));
    this.f = ((ImageView)findViewById(2131376418));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364751));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364750));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364755));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364754));
  }
  
  private void k()
  {
    Object localObject = (qtw)ozs.a().getManager(261);
    qtk localqtk = ((qtw)localObject).a(3);
    if (localqtk != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localqtk.a());
    }
    localObject = ((qtw)localObject).a(2);
    if (localObject != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(((qtk)localObject).a());
    }
  }
  
  private void l()
  {
    n();
    a();
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView == null) {
      return;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleX", new float[] { 0.2F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleY", new float[] { 0.2F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleX", new float[] { 0.2F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleY", new float[] { 0.2F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleX", new float[] { 0.2F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleY", new float[] { 0.2F, 1.0F }) });
    localAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet.setDuration(400L);
    localAnimatorSet.start();
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    if ((this.jdField_b_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_b_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationAnimatorSet.cancel();
    }
  }
  
  private void o()
  {
    if (bnrf.s()) {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        a(this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_Tay = null;
        this.jdField_e_of_type_Boolean = false;
      }
    }
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    a(this.jdField_a_of_type_Boolean);
  }
  
  private void p()
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
  
  private void q()
  {
    a(this.jdField_e_of_type_AndroidWidgetImageView, 1.0F);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0.0F);
    a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, 0.0F);
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
  
  public tay a()
  {
    return this.jdField_a_of_type_Tay;
  }
  
  public void a()
  {
    d();
    this.jdField_b_of_type_Boolean = false;
    a(this.jdField_a_of_type_Boolean, false);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setVisibility(8);
  }
  
  public void a(tay paramtay)
  {
    if (paramtay != null) {
      b(paramtay);
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
    localAnimatorSet.addListener(new tat(this));
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
    uaf.a.a(paramCanvas, true, this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
  }
  
  public void draw(Canvas paramCanvas)
  {
    uaf.a.a(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
  }
  
  public void e()
  {
    o();
    if (this.jdField_a_of_type_Tay == null)
    {
      n();
      d();
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
        a(true, taz.h, true);
      }
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Tay != null) && (this.jdField_a_of_type_Tay.b()))
    {
      AbstractGifImage.pauseAll();
      txc.b();
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Tay != null) && (this.jdField_a_of_type_Tay.b()))
    {
      AbstractGifImage.resumeAll();
      txc.a();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && ((this.jdField_a_of_type_Tay instanceof taz)))
    {
      p();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPivotX(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPivotY(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() / 2);
      this.jdField_a_of_type_AndroidAnimationAnimator.setTarget(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidAnimationAnimator.start();
      this.jdField_b_of_type_AndroidAnimationAnimator.setTarget(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView);
      this.jdField_b_of_type_AndroidAnimationAnimator.start();
      this.jdField_c_of_type_AndroidAnimationAnimator.setTarget(this.f);
      this.jdField_c_of_type_AndroidAnimationAnimator.start();
      postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
    }
  }
  
  public void i()
  {
    pfd.a().b(this.jdField_a_of_type_Pfh);
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
      paramView.setTag(Integer.valueOf(taz.c));
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
      QLog.d("ColorBandVideoEntranceButton", 2, "loadSuccess, start setImage, dataSource=" + this.jdField_a_of_type_Tay);
    }
    if (this.jdField_a_of_type_Boolean) {
      a(paramURLDrawable);
    }
    while (this.jdField_a_of_type_Tay == null) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setImageDrawable(paramURLDrawable);
      if (this.jdField_b_of_type_Boolean) {
        break label213;
      }
      m();
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setVisibility(0);
      a(this.jdField_a_of_type_Boolean, true);
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Tay.d()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Tay.e()))) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
      return;
      label213:
      m();
    }
  }
  
  public void setDataSource(tay paramtay)
  {
    this.jdField_a_of_type_Tay = paramtay;
  }
  
  public void setDefaultDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setDefaultIconBigMode(int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = agej.a(paramInt1, getContext().getResources());
    localLayoutParams.height = agej.a(paramInt2, getContext().getResources());
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