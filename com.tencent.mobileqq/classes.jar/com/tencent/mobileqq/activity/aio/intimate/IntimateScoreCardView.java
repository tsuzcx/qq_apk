package com.tencent.mobileqq.activity.aio.intimate;

import agej;
import agxg;
import agxh;
import agxi;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import areb;
import arec;
import avgx;
import bdll;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.IntimateScoreCardInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.FileInputStream;

public class IntimateScoreCardView
  extends RelativeLayout
  implements View.OnClickListener, View.OnTouchListener, ImageAssetDelegate, OnCompositionLoadedListener
{
  public static String a;
  private int jdField_a_of_type_Int;
  private agxi jdField_a_of_type_Agxi;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  public Context a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TickerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IntimateInfo.IntimateScoreCardInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo;
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  Runnable jdField_a_of_type_JavaLangRunnable = new IntimateScoreCardView.1(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  Runnable jdField_b_of_type_JavaLangRunnable = new IntimateScoreCardView.2(this);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 4;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "IntimateScoreView";
  }
  
  public IntimateScoreCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateScoreCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateScoreCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_b_of_type_Boolean)) {}
    String str2;
    do
    {
      do
      {
        return;
        localObject = (avgx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(323);
      } while (localObject == null);
      str2 = ((avgx)localObject).a(this.jdField_a_of_type_Int, paramBoolean);
    } while (TextUtils.isEmpty(str2));
    Object localObject = new File(str2).getParent();
    if (((String)localObject).endsWith("/")) {}
    String str1;
    for (localObject = (String)localObject + "images";; str1 = localThrowable + "/images")
    {
      this.jdField_b_of_type_JavaLangString = ((String)localObject);
      try
      {
        LottieComposition.Factory.fromInputStream(getContext(), new FileInputStream(str2), this);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "startScoreLottieAnim error:" + localThrowable.getMessage());
        return;
      }
    }
  }
  
  private boolean a()
  {
    int i = 0;
    boolean bool = true;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo != null))
    {
      localObject = arec.a();
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 1)) {
        if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore < ((areb)localObject).jdField_a_of_type_Int) {
          break label150;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("canShow res: ").append(bool).append("  mCurrentShowType:").append(this.jdField_b_of_type_Int).append(" score:");
        if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore;
        }
        QLog.d((String)localObject, 2, i);
      }
      return bool;
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore < ((areb)localObject).jdField_c_of_type_Int) {
        label150:
        bool = false;
      }
    }
  }
  
  private boolean b()
  {
    boolean bool = true;
    if (this.jdField_b_of_type_Int == 4) {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "canUpdateAnim res: " + bool + "  mCurrentShowType:" + this.jdField_b_of_type_Int);
    }
    return bool;
  }
  
  private void f()
  {
    this.jdField_a_of_type_Boolean = true;
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559278, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131377082));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377081));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131377076));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131377080));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView = ((TickerView)localView.findViewById(2131377079));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setCharacterLists(new String[] { "9876543210" });
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setAnimationDuration(2000L);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)localView.findViewById(2131377078));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377083));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377077));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131377075));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368792);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "checkAndStartUpdateAnim mIsResumed:" + this.jdField_b_of_type_Boolean + " mCurrentShowType:" + this.jdField_b_of_type_Int + " mIntimateInfo:" + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (a()))
    {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if ((b()) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore != this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore > 0)) {
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
      }
    }
    else
    {
      return;
    }
    j();
  }
  
  private void h()
  {
    boolean bool = true;
    int j = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore);
    int k = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "smoothUpdateScores fromScore:" + j + " toScore:" + k);
    }
    TickerView localTickerView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView;
    int i;
    if (k > j)
    {
      i = 1;
      localTickerView.setPreferredScrollingDirection(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setDigitalAnimWidthSpeedIncrement(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setIgnoreWidthAnim(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText(String.valueOf(k));
      removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2500L);
      if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 1)) {
        if (k <= j) {
          break label194;
        }
      }
    }
    for (;;)
    {
      a(bool);
      if (this.jdField_a_of_type_Agxi != null) {
        this.jdField_a_of_type_Agxi.l();
      }
      return;
      i = 2;
      break;
      label194:
      bool = false;
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() == 0) || (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()))
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAllLottieOnCompositionLoadedListener();
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) {
      k();
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 1))
      {
        k();
        return;
      }
      areb localareb = arec.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore >= localareb.jdField_b_of_type_Int) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore < localareb.jdField_a_of_type_Int))
      {
        k();
        return;
      }
    } while ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()));
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(1500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new agxg(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new agxh(this));
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onDrawerOpened mIsResumed:" + this.jdField_b_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    g();
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.d = false;
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onDrawerClosed mIsResumed:" + this.jdField_b_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    i();
    k();
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onResumed mIsOpened:" + this.jdField_c_of_type_Boolean);
      }
      if (this.jdField_c_of_type_Boolean) {}
    }
    do
    {
      return;
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onResumed mIsResumed:" + this.jdField_b_of_type_Boolean);
      }
    } while (!this.jdField_a_of_type_Boolean);
    g();
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onPaused mIsResumed:" + this.jdField_b_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    i();
    k();
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Agxi = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    i();
    k();
  }
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    paramLottieImageAsset = paramLottieImageAsset.getFileName();
    paramLottieImageAsset = this.jdField_b_of_type_JavaLangString + File.separator + paramLottieImageAsset;
    boolean bool = new File(paramLottieImageAsset).exists();
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "fetchBitmap exists:" + bool + " imagePath:" + paramLottieImageAsset);
      }
      return null;
    }
    Object localObject = BaseApplicationImpl.sImageCache.get(paramLottieImageAsset);
    if ((localObject != null) && ((localObject instanceof Bitmap))) {
      return (Bitmap)localObject;
    }
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inScaled = false;
      localObject = BitmapFactory.decodeFile(paramLottieImageAsset, (BitmapFactory.Options)localObject);
      BaseApplicationImpl.sImageCache.put(paramLottieImageAsset, localObject);
      return localObject;
    }
    catch (Throwable paramLottieImageAsset)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "fetchBitmap error " + paramLottieImageAsset.getMessage());
    }
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onClick");
    }
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Agxi != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo != null)) {
        this.jdField_a_of_type_Agxi.a(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo.buttonUrl);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdll.b(null, "dc00898", "", "", "0X800AE5B", "0X800AE5B", this.jdField_c_of_type_Int, 0, "", "", "", "");
      continue;
      bdll.b(null, "dc00898", "", "", "0X800AE5C", "0X800AE5C", this.jdField_c_of_type_Int, 0, "", "", "", "");
    }
  }
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((paramLottieComposition == null) || (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() != 0) || (!this.jdField_b_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "composition is null ,return");
        }
      }
      else
      {
        int i = agej.a(75.0F, getResources());
        int j = agej.a(90.0F, getResources());
        Rect localRect = paramLottieComposition.getBounds();
        float f1 = i / localRect.width();
        float f2 = j / localRect.height();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetDelegate(this);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setComposition(paramLottieComposition);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleXY(f1, f2);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
        }
        while (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onCompositionLoaded playAnim duration: " + this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getDuration() + " mIsResumed:" + this.jdField_b_of_type_Boolean);
          return;
          this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
          this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAllLottieOnCompositionLoadedListener();
        }
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramView.setAlpha(0.5F);
        continue;
        if (Build.VERSION.SDK_INT >= 11) {
          paramView.setAlpha(1.0F);
        }
      }
    }
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void setCallBack(agxi paramagxi)
  {
    this.jdField_a_of_type_Agxi = paramagxi;
  }
  
  public void setCurrentShowType(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setCurrentShowType showType: " + paramInt + "  old:" + this.jdField_b_of_type_Int + "  this:" + this);
    }
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setData(IntimateInfo paramIntimateInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.jdField_a_of_type_Int = paramInt;
    if (paramIntimateInfo != null) {}
    for (paramIntimateInfo = paramIntimateInfo.scoreCardInfo;; paramIntimateInfo = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo = paramIntimateInfo;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "setData scoreCardInfo:" + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo);
      }
      if (a()) {
        break;
      }
      setVisibility(8);
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      f();
    }
    label100:
    int j;
    int i;
    if (paramInt == 1)
    {
      this.jdField_c_of_type_Int = 1;
      setVisibility(0);
      j = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore;
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore >= 0) {
        j = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText(String.valueOf(j), false);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo.title);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo.typeDescribe);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo.levelDescribe);
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo.buttonDescribe);
      i = 2131165722;
      if (paramInt != 3) {
        break label358;
      }
      i = 2131165719;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(i));
      g();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateIntimateInfo score: " + j);
      }
      if (this.d) {
        break;
      }
      this.d = true;
      bdll.b(null, "dc00898", "", "", "0X800AE5A", "0X800AE5A", this.jdField_c_of_type_Int, 0, "", "", "", "");
      return;
      if (paramInt == 2)
      {
        this.jdField_c_of_type_Int = 2;
        break label100;
      }
      if (paramInt == 3)
      {
        this.jdField_c_of_type_Int = 3;
        break label100;
      }
      this.jdField_c_of_type_Int = 4;
      break label100;
      label358:
      if (paramInt == 2) {
        i = 2131165717;
      } else if (paramInt == 1) {
        i = 2131165721;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.IntimateScoreCardView
 * JD-Core Version:    0.7.0.1
 */