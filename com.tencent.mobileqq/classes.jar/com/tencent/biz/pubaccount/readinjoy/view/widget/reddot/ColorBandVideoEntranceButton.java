package com.tencent.biz.pubaccount.readinjoy.view.widget.reddot;

import actn;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import bawz;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;
import onk;
import pyw;
import pzi;
import pzv;
import ruy;
import ruz;
import rva;
import sed;

public class ColorBandVideoEntranceButton
  extends FrameLayout
  implements View.OnClickListener, URLDrawable.URLDrawableListener2, pzv
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  protected Drawable a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  protected ImageView a;
  protected KanDianUrlRoundCornerImageView a;
  protected URLDrawable a;
  private rva jdField_a_of_type_Rva;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private AnimatorSet jdField_b_of_type_AndroidAnimationAnimatorSet;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  protected ImageView b;
  private URLDrawable jdField_b_of_type_ComTencentImageURLDrawable;
  private ImageView c;
  private ImageView d;
  
  public ColorBandVideoEntranceButton(@NonNull Context paramContext)
  {
    super(paramContext);
    h();
  }
  
  public ColorBandVideoEntranceButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h();
  }
  
  private Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842525);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private void a(View paramView)
  {
    if (a())
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      c();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
      }
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
  
  private boolean a()
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L;
  }
  
  private void b(rva paramrva)
  {
    post(new ColorBandVideoEntranceButton.4(this, paramrva));
  }
  
  private void c(rva paramrva)
  {
    if (paramrva == null) {
      return;
    }
    if (paramrva.c())
    {
      d(paramrva);
      return;
    }
    a(paramrva.d());
  }
  
  private void d(rva paramrva)
  {
    if (paramrva == null) {
      return;
    }
    if (paramrva.b())
    {
      if (!TextUtils.isEmpty(paramrva.c())) {}
      for (;;)
      {
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions1 = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions1.mLoadingDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
          localURLDrawableOptions1.mRequestWidth = this.jdField_a_of_type_Int;
          localURLDrawableOptions1.mRequestHeight = this.jdField_b_of_type_Int;
          localURLDrawableOptions1.mPlayGifImage = true;
          this.jdField_b_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramrva.c(), localURLDrawableOptions1);
          this.jdField_b_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
          this.jdField_b_of_type_ComTencentImageURLDrawable.startDownload();
          a(paramrva.d());
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
    Object localObject = paramrva.d();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorBandVideoEntranceButton", 2, "rawUrl: " + (String)localObject);
      }
      localObject = onk.a((String)localObject, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
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
        paramrva.a((String)localObject);
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ColorBandVideoEntranceButton", 2, "url error: " + localException2.getMessage());
        continue;
      }
      if ((!paramrva.d()) || (TextUtils.isEmpty(paramrva.e()))) {
        break;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = a();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramrva.e(), (URLDrawable.URLDrawableOptions)localObject);
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
  
  private void h()
  {
    inflate(getContext(), 2131559838, this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379156);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374808));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368675));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)findViewById(2131374809));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setOnClickListener(this);
    i();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(this.jdField_a_of_type_Int / 2);
    this.c = ((ImageView)findViewById(2131379194));
    this.d = ((ImageView)findViewById(2131379193));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840112);
    k();
  }
  
  private void i()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getLayoutParams();
    this.jdField_a_of_type_Int = localLayoutParams.width;
    this.jdField_b_of_type_Int = localLayoutParams.height;
    if (QLog.isColorLevel()) {
      QLog.d("ColorBandVideoEntranceButton", 2, "initCoverImageSize, width: " + this.jdField_a_of_type_Int + ", height: " + this.jdField_b_of_type_Int);
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setScaleX(0.2F);
    this.jdField_a_of_type_AndroidViewView.setScaleY(0.2F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setScaleX(0.2F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setScaleY(0.2F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, actn.a(21.0F, getResources()) });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, actn.a(21.0F, getResources()) });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 0.38F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.0F, 0.38F });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4 });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(333L);
    this.jdField_b_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_b_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleX", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleY", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleX", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleY", new float[] { 0.2F, 1.1F, 1.0F }) });
    this.jdField_b_of_type_AndroidAnimationAnimatorSet.setDuration(400L);
    localObjectAnimator1.addUpdateListener(new ruy(this));
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  private void k()
  {
    Object localObject = (pzi)onk.a().getManager(261);
    pyw localpyw = ((pzi)localObject).a(3);
    if (localpyw != null) {
      this.c.setImageDrawable(localpyw.a());
    }
    localObject = ((pzi)localObject).a(2);
    if (localObject != null) {
      this.d.setImageDrawable(((pyw)localObject).a());
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setScaleX(0.3F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setScaleY(0.3F);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleX", new float[] { 0.3F, 1.1F, 0.8F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleY", new float[] { 0.3F, 1.1F, 0.8F, 1.0F }) });
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
  
  public rva a()
  {
    return this.jdField_a_of_type_Rva;
  }
  
  public void a()
  {
    d();
    this.jdField_a_of_type_Boolean = false;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.c.getLayoutParams();
    int i = bawz.a(getContext(), 4.0F);
    localLayoutParams.topMargin = i;
    localLayoutParams.leftMargin = i;
    i = bawz.a(getContext(), 2.5F);
    localLayoutParams.bottomMargin = i;
    localLayoutParams.rightMargin = i;
    this.c.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.d.getLayoutParams();
    i = bawz.a(getContext(), 4.0F);
    localLayoutParams.topMargin = i;
    localLayoutParams.leftMargin = i;
    i = bawz.a(getContext(), 2.5F);
    localLayoutParams.bottomMargin = i;
    localLayoutParams.rightMargin = i;
    this.d.setLayoutParams(localLayoutParams);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    k();
  }
  
  public void a(rva paramrva)
  {
    if (paramrva != null) {
      b(paramrva);
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      onClick(this.jdField_a_of_type_AndroidWidgetImageView);
    }
  }
  
  protected void c()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.0F, 0.5F, 1.0F }), ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.0F, 0.5F, 1.0F }) });
    localAnimatorSet.setDuration(600L);
    localAnimatorSet.setInterpolator(new OvershootInterpolator());
    localAnimatorSet.addListener(new ruz(this));
    localAnimatorSet.start();
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a());
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Rva == null)
    {
      n();
      d();
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Rva != null) && (this.jdField_a_of_type_Rva.b()))
    {
      AbstractGifImage.pauseAll();
      sed.b();
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Rva != null) && (this.jdField_a_of_type_Rva.b()))
    {
      AbstractGifImage.resumeAll();
      sed.a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a(paramView);
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
      QLog.d("ColorBandVideoEntranceButton", 2, "loadSuccess, start setImage, dataSource=" + this.jdField_a_of_type_Rva);
    }
    if (this.jdField_a_of_type_Rva == null) {
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
      if (this.jdField_a_of_type_Boolean) {
        break label336;
      }
      j();
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      paramURLDrawable = (FrameLayout.LayoutParams)this.c.getLayoutParams();
      paramURLDrawable.leftMargin = bawz.a(getContext(), 4.0F);
      paramURLDrawable.topMargin = bawz.a(getContext(), -3.0F);
      int i = bawz.a(getContext(), 2.5F);
      paramURLDrawable.bottomMargin = i;
      paramURLDrawable.rightMargin = i;
      this.c.setLayoutParams(paramURLDrawable);
      paramURLDrawable = (FrameLayout.LayoutParams)this.d.getLayoutParams();
      paramURLDrawable.leftMargin = bawz.a(getContext(), 4.0F);
      paramURLDrawable.topMargin = bawz.a(getContext(), -3.0F);
      i = bawz.a(getContext(), 2.5F);
      paramURLDrawable.bottomMargin = i;
      paramURLDrawable.rightMargin = i;
      this.d.setLayoutParams(paramURLDrawable);
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Rva.d()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Rva.e()))) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
      return;
      label336:
      m();
    }
  }
  
  public void setDataSource(rva paramrva)
  {
    this.jdField_a_of_type_Rva = paramrva;
  }
  
  public void setDefaultDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setDefaultIconBigMode(int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = actn.a(paramInt1, getContext().getResources());
    localLayoutParams.height = actn.a(paramInt2, getContext().getResources());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton
 * JD-Core Version:    0.7.0.1
 */