package com.tencent.biz.pubaccount.readinjoy.view.widget.reddot;

import amtj;
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
import bgft;
import bgfu;
import bjnd;
import bkwm;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager.EntranceIconInfo;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.ApngImage;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import pay;
import pkp;
import pkt;
import rai;
import rau;
import rbh;
import tet;
import teu;
import tev;
import tew;
import tex;
import tey;
import tez;
import tfa;
import tfb;
import tfc;
import uds;
import ugu;

public class ColorBandVideoEntranceButton
  extends FrameLayout
  implements View.OnClickListener, URLDrawable.URLDrawableListener2, rbh
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
  protected KanDianUrlRoundCornerImageView a;
  private ApngDrawable.OnPlayRepeatListener jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener;
  protected URLDrawable a;
  protected URLImageView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new ColorBandVideoEntranceButton.10(this);
  private Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new tet(this);
  pkt jdField_a_of_type_Pkt = new tez(this);
  private tfb jdField_a_of_type_Tfb;
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
  public Runnable b;
  private Function1<Canvas, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1 = new teu(this);
  private boolean jdField_b_of_type_Boolean;
  Animator jdField_c_of_type_AndroidAnimationAnimator;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
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
    this.jdField_b_of_type_JavaLangRunnable = new ColorBandVideoEntranceButton.11(this);
    j();
  }
  
  public ColorBandVideoEntranceButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_JavaLangRunnable = new ColorBandVideoEntranceButton.11(this);
    j();
  }
  
  private AnimatorSet a()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "scaleX", new float[] { 0.5F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "scaleY", new float[] { 0.5F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "translationX", new float[] { 2.0F, 0.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "translationY", new float[] { 40.0F, 20.0F, 0.0F }) });
    localAnimatorSet.setDuration(300L);
    localAnimatorSet.addListener(new tex(this));
    return localAnimatorSet;
  }
  
  private Drawable a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (int i = RecommendFeedsDiandianEntranceManager.b();; i = 2130842799) {
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
  
  private String a()
  {
    Object localObject2 = ((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)this.jdField_a_of_type_Tfb).d;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (Object localObject1 = "";; localObject1 = localObject2)
    {
      float f1 = 0.0F;
      int i = 0;
      float f2;
      if (i < ((String)localObject2).length()) {
        if (StringUtil.isChinese(((String)localObject2).charAt(i)))
        {
          f2 = 2.0F;
          label51:
          f1 += f2;
          if (f1 <= 16.0F) {
            break label171;
          }
        }
      }
      for (int j = 1;; j = 0)
      {
        if (j != 0) {}
        for (localObject2 = ((String)localObject2).substring(0, i) + "...";; localObject2 = localObject1)
        {
          i = ((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)this.jdField_a_of_type_Tfb).jdField_b_of_type_Int;
          localObject1 = "";
          switch (i)
          {
          }
          for (;;)
          {
            return (String)localObject2 + " " + (String)localObject1;
            f2 = 1.0F;
            break label51;
            label171:
            i += 1;
            break;
            localObject1 = amtj.a(2131717723);
            continue;
            localObject1 = amtj.a(2131717724);
            continue;
            localObject1 = amtj.a(2131717722);
          }
        }
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
      this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener = new tfa(this);
    }
    paramApngDrawable.setOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener);
    paramApngDrawable.repaly();
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      QLog.d("ColorBandVideoEntranceButton", 1, "has no red dot");
      return;
    }
    QLog.d("ColorBandVideoEntranceButton", 1, "isHasRedDot updateAnimation");
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if ((paramURLDrawable != null) && ((paramURLDrawable.getCurrDrawable() instanceof ApngDrawable)) && (((ApngDrawable)paramURLDrawable.getCurrDrawable()).getImage() != null))
    {
      Bitmap localBitmap = ((ApngDrawable)paramURLDrawable.getCurrDrawable()).getImage().getCurrentFrame();
      if (localBitmap != null) {
        localBitmap.eraseColor(0);
      }
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramURLDrawable);
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
    localAnimatorSet.addListener(new tew(this, paramString));
    localAnimatorSet.start();
  }
  
  private void a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey("target")) && (paramMap.containsKey("channelid")))
    {
      String str = (String)paramMap.get("target");
      paramMap = (String)paramMap.get("channelid");
      if (("2".equals(str)) && (String.valueOf(70).equals(paramMap))) {
        bkwm.a("key_sp_entrance_follow", Boolean.valueOf(true));
      }
    }
  }
  
  private void a(tfc paramtfc)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (paramtfc == null);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramtfc.a))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramtfc.a);
      }
    } while ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(paramtfc.jdField_b_of_type_JavaLangString)));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramtfc.a);
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
        break label149;
      }
      pkp.a().a(this.jdField_a_of_type_Pkt);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      p();
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
      label149:
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(this.jdField_a_of_type_Int / 2);
      pkp.a().b(this.jdField_a_of_type_Pkt);
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
        k -= DisplayUtil.dip2px(getContext(), 12.0F);
        i += j + (DisplayUtil.dip2px(getContext(), 30.0F) - ((FrameLayout.LayoutParams)localObject).width);
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
  
  private AnimatorSet b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPivotX(this.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPivotY(this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "scaleX", new float[] { 1.0F, 0.5F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "scaleY", new float[] { 1.0F, 0.5F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "translationX", new float[] { 0.0F, 2.0F }), ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "translationY", new float[] { 0.0F, 20.0F, 40.0F }) });
    localAnimatorSet.setDuration(300L);
    localAnimatorSet.setStartDelay(2500L);
    localAnimatorSet.addListener(new tey(this));
    return localAnimatorSet;
  }
  
  private void b(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((paramURLDrawable instanceof ApngDrawable))
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
      if ((this.jdField_a_of_type_Tfb instanceof tfc)) {
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
  
  private void b(String paramString)
  {
    QLog.d("ColorBandVideoEntranceButton", 1, "loadUpdateAnimation: " + paramString);
    bgfu localbgfu = new bgfu();
    localbgfu.a(new ColorDrawable(7));
    localbgfu.b(this.jdField_a_of_type_Int);
    localbgfu.c(this.jdField_b_of_type_Int);
    localbgfu.a(1);
    a(bgft.a(paramString, localbgfu));
  }
  
  private void b(tfb paramtfb)
  {
    if ((paramtfb instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo)) {
      a(bjnd.a(((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)paramtfb).c));
    }
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
  
  private void c(tfb paramtfb)
  {
    post(new ColorBandVideoEntranceButton.4(this, paramtfb));
  }
  
  private void d(tfb paramtfb)
  {
    if (paramtfb == null) {
      return;
    }
    if (paramtfb.c())
    {
      e(paramtfb);
      return;
    }
    c(paramtfb.d());
  }
  
  private void e(tfb paramtfb)
  {
    if (paramtfb == null) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!(paramtfb instanceof tfc));
    a((tfc)paramtfb);
    q();
    a(true, tfc.g, true);
    a(false, paramtfb.d(), true);
    return;
    if (paramtfb.b())
    {
      if (!TextUtils.isEmpty(paramtfb.c())) {}
      for (;;)
      {
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions1 = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions1.mLoadingDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
          localURLDrawableOptions1.mRequestWidth = this.jdField_a_of_type_Int;
          localURLDrawableOptions1.mRequestHeight = this.jdField_b_of_type_Int;
          localURLDrawableOptions1.mPlayGifImage = true;
          this.jdField_b_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramtfb.c(), localURLDrawableOptions1);
          this.jdField_b_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
          this.jdField_b_of_type_ComTencentImageURLDrawable.startDownload();
          c(paramtfb.d());
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
    Object localObject = paramtfb.d();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorBandVideoEntranceButton", 2, "rawUrl: " + (String)localObject);
      }
      localObject = pay.a((String)localObject, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
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
        paramtfb.b((String)localObject);
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ColorBandVideoEntranceButton", 2, "url error: " + localException2.getMessage());
        continue;
      }
      if ((!paramtfb.d()) || (TextUtils.isEmpty(paramtfb.e()))) {
        break;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = a(false);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramtfb.e(), (URLDrawable.URLDrawableOptions)localObject);
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
    inflate(getContext(), 2131560097, this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131380776);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375952));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369358));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)findViewById(2131375954));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setOnClickListener(this);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(this.jdField_a_of_type_Int / 2);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380817));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380816));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840441);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131375953));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371798));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371797));
    k();
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364778));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)findViewById(2131364772));
    this.f = ((ImageView)findViewById(2131376186));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364782));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364781));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364786));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364785));
  }
  
  private void k()
  {
    Object localObject = (rau)pay.a().getManager(261);
    rai localrai = ((rau)localObject).a(3);
    if (localrai != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localrai.a());
    }
    localObject = ((rau)localObject).a(2);
    if (localObject != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(((rai)localObject).a());
    }
  }
  
  private void l()
  {
    n();
    a();
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      a().start();
    }
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
    if (bkwm.t()) {
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
  
  public tfb a()
  {
    return this.jdField_a_of_type_Tfb;
  }
  
  public void a()
  {
    d();
    this.jdField_b_of_type_Boolean = false;
    a(this.jdField_a_of_type_Boolean, false);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  public void a(tfb paramtfb)
  {
    if (paramtfb != null) {
      c(paramtfb);
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
    localAnimatorSet.addListener(new tev(this));
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
    ugu.a.a(paramCanvas, true, this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
  }
  
  public void draw(Canvas paramCanvas)
  {
    ugu.a.a(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
  }
  
  public void e()
  {
    o();
    if (this.jdField_a_of_type_Tfb == null)
    {
      n();
      d();
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
        a(true, tfc.h, true);
      }
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Tfb != null) && (this.jdField_a_of_type_Tfb.b()))
    {
      AbstractGifImage.pauseAll();
      uds.b();
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Tfb != null) && (this.jdField_a_of_type_Tfb.b()))
    {
      AbstractGifImage.resumeAll();
      uds.a();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && ((this.jdField_a_of_type_Tfb instanceof tfc)))
    {
      p();
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
    pkp.a().b(this.jdField_a_of_type_Pkt);
    a().removeAllListeners();
    b().removeAllListeners();
    a().cancel();
    b().cancel();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
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
      paramView.setTag(Integer.valueOf(tfc.c));
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
    QLog.d("ColorBandVideoEntranceButton", 1, "loadSuccess, start setImage, dataSource=" + this.jdField_a_of_type_Tfb);
    if (this.jdField_a_of_type_Boolean) {
      b(paramURLDrawable);
    }
    while (this.jdField_a_of_type_Tfb == null) {
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
      paramURLDrawable = "http://pub.idqqimg.com/pc/misc/files/20200805/6b42a020cbde489889a5c7ea52bdd5ed.png";
      if ((this.jdField_a_of_type_Tfb instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo)) {
        paramURLDrawable = ((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)this.jdField_a_of_type_Tfb).jdField_b_of_type_JavaLangString;
      }
      if (this.jdField_b_of_type_Boolean) {
        break label226;
      }
      a(paramURLDrawable);
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Boolean, true);
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Tfb.d()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Tfb.e()))) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
      return;
      label226:
      a(paramURLDrawable);
    }
  }
  
  public void setDataSource(tfb paramtfb)
  {
    QLog.d("ColorBandVideoEntranceButton", 1, "setDataSource: " + paramtfb);
    this.jdField_a_of_type_Tfb = paramtfb;
    b(paramtfb);
  }
  
  public void setDefaultDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setDefaultIconBigMode(int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = AIOUtils.dp2px(paramInt1, getContext().getResources());
    localLayoutParams.height = AIOUtils.dp2px(paramInt2, getContext().getResources());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton
 * JD-Core Version:    0.7.0.1
 */