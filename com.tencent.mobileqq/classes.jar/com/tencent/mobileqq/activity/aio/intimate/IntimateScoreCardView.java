package com.tencent.mobileqq.activity.aio.intimate;

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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.IntimateScoreCardInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.friends.intimate.IntimateInfoManager;
import com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.FileInputStream;

public class IntimateScoreCardView
  extends RelativeLayout
  implements View.OnClickListener, View.OnTouchListener, ImageAssetDelegate, OnCompositionLoadedListener
{
  public static String a = "IntimateScoreView";
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  public Context a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IntimateScoreCardView.Callback jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView$Callback;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IntimateInfo.IntimateScoreCardInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo;
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private TickerView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView;
  Runnable jdField_a_of_type_JavaLangRunnable = new IntimateScoreCardView.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  Runnable jdField_b_of_type_JavaLangRunnable = new IntimateScoreCardView.2(this);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 4;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  
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
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = true;
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559275, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131376960));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376959));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131376954));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131376958));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView = ((TickerView)localView.findViewById(2131376957));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setCharacterLists(new String[] { "9876543210" });
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setAnimationDuration(2000L);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)localView.findViewById(2131376956));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376961));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376955));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131376953));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131368938);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      localObject = (IntimateInfoManager)((QQAppInterface)localObject).getManager(QQManagerFactory.INTIMATE_INFO_MANAGER);
      if (localObject == null) {
        return;
      }
      String str = ((IntimateInfoManager)localObject).a(this.jdField_a_of_type_Int, paramBoolean);
      if (TextUtils.isEmpty(str)) {
        return;
      }
      localObject = new File(str).getParent();
      StringBuilder localStringBuilder;
      if (((String)localObject).endsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("images");
        localObject = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("/images");
        localObject = localStringBuilder.toString();
      }
      this.jdField_b_of_type_JavaLangString = ((String)localObject);
      try
      {
        LottieComposition.Factory.fromInputStream(getContext(), new FileInputStream(str), this);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        return;
      }
      catch (Throwable localThrowable)
      {
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startScoreLottieAnim error:");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
    boolean bool = true;
    int i = 0;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo != null))
    {
      localObject = FriendIntimateRelationshipConfProcessor.a();
      if (IntimateUtil.a(this.jdField_a_of_type_Int) ? this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore >= ((FriendIntimateRelationshipBean)localObject).jdField_a_of_type_Int : this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore >= ((FriendIntimateRelationshipBean)localObject).jdField_c_of_type_Int) {}
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canShow res: ");
      localStringBuilder.append(bool);
      localStringBuilder.append("  mCurrentShowType:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(" score:");
      IntimateInfo localIntimateInfo = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
      if (localIntimateInfo != null) {
        i = localIntimateInfo.currentScore;
      }
      localStringBuilder.append(i);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private void b()
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndStartUpdateAnim mIsResumed:");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(" mCurrentShowType:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(" mIntimateInfo:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (a()))
    {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if ((b()) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore != this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore > 0))
      {
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
        return;
      }
      e();
    }
  }
  
  private boolean b()
  {
    boolean bool;
    if (this.jdField_b_of_type_Int == 4) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canUpdateAnim res: ");
      localStringBuilder.append(bool);
      localStringBuilder.append("  mCurrentShowType:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore;
    boolean bool1 = false;
    int j = Math.max(0, i);
    int k = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore);
    boolean bool2 = QLog.isColorLevel();
    i = 2;
    if (bool2)
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("smoothUpdateScores fromScore:");
      localStringBuilder.append(j);
      localStringBuilder.append(" toScore:");
      localStringBuilder.append(k);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView;
    if (k > j) {
      i = 1;
    }
    ((TickerView)localObject).setPreferredScrollingDirection(i);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setDigitalAnimWidthSpeedIncrement(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setIgnoreWidthAnim(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setText(String.valueOf(k));
    removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2500L);
    if (IntimateUtil.a(this.jdField_a_of_type_Int))
    {
      if (k > j) {
        bool1 = true;
      }
      a(bool1);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView$Callback;
    if (localObject != null) {
      ((IntimateScoreCardView.Callback)localObject).k();
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() == 0) || (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()))
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAllLottieOnCompositionLoadedListener();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null)
    {
      f();
      return;
    }
    if (!IntimateUtil.a(this.jdField_a_of_type_Int))
    {
      f();
      return;
    }
    Object localObject = FriendIntimateRelationshipConfProcessor.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore < ((FriendIntimateRelationshipBean)localObject).jdField_b_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore >= ((FriendIntimateRelationshipBean)localObject).jdField_a_of_type_Int))
    {
      localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      if ((localObject != null) && (((ValueAnimator)localObject).isRunning())) {
        return;
      }
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(1500L);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new IntimateScoreCardView.3(this));
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new IntimateScoreCardView.4(this));
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
    f();
  }
  
  private void f()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    paramLottieImageAsset = paramLottieImageAsset.getFileName();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramLottieImageAsset);
    paramLottieImageAsset = ((StringBuilder)localObject).toString();
    boolean bool = new File(paramLottieImageAsset).exists();
    StringBuilder localStringBuilder;
    if (!bool)
    {
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fetchBitmap exists:");
        localStringBuilder.append(bool);
        localStringBuilder.append(" imagePath:");
        localStringBuilder.append(paramLottieImageAsset);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      return null;
    }
    localObject = GlobalImageCache.a.get(paramLottieImageAsset);
    if ((localObject != null) && ((localObject instanceof Bitmap))) {
      return (Bitmap)localObject;
    }
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inScaled = false;
      localObject = BitmapFactory.decodeFile(paramLottieImageAsset, (BitmapFactory.Options)localObject);
      GlobalImageCache.a.put(paramLottieImageAsset, localObject);
      return localObject;
    }
    catch (Throwable paramLottieImageAsset)
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchBitmap error ");
      localStringBuilder.append(paramLottieImageAsset.getMessage());
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onClick");
    }
    int i = paramView.getId();
    if (i != 2131368938)
    {
      if (i == 2131376953) {
        ReportController.b(null, "dc00898", "", "", "0X800AE5C", "0X800AE5C", this.jdField_c_of_type_Int, 0, "", "", "", "");
      }
    }
    else {
      ReportController.b(null, "dc00898", "", "", "0X800AE5B", "0X800AE5B", this.jdField_c_of_type_Int, 0, "", "", "", "");
    }
    IntimateScoreCardView.Callback localCallback = this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView$Callback;
    if (localCallback != null)
    {
      IntimateInfo.IntimateScoreCardInfo localIntimateScoreCardInfo = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo;
      if (localIntimateScoreCardInfo != null) {
        localCallback.a(localIntimateScoreCardInfo.buttonUrl);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((paramLottieComposition != null) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() == 0) && (this.jdField_b_of_type_Boolean))
    {
      int i = AIOUtils.b(75.0F, getResources());
      int j = AIOUtils.b(90.0F, getResources());
      Object localObject = paramLottieComposition.getBounds();
      float f1 = i / ((Rect)localObject).width();
      float f2 = j / ((Rect)localObject).height();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetDelegate(this);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setComposition(paramLottieComposition);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleXY(f1, f2);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAllLottieOnCompositionLoadedListener();
      }
      if (QLog.isColorLevel())
      {
        paramLottieComposition = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCompositionLoaded playAnim duration: ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getDuration());
        ((StringBuilder)localObject).append(" mIsResumed:");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
        QLog.d(paramLottieComposition, 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "composition is null ,return");
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (((i == 1) || (i == 3)) && (Build.VERSION.SDK_INT >= 11)) {
        paramView.setAlpha(1.0F);
      }
    }
    else if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void setCallBack(IntimateScoreCardView.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView$Callback = paramCallback;
  }
  
  public void setCurrentShowType(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCurrentShowType showType: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  old:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("  this:");
      localStringBuilder.append(this);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setData(IntimateInfo paramIntimateInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.jdField_a_of_type_Int = paramInt;
    if (paramIntimateInfo != null) {
      paramIntimateInfo = paramIntimateInfo.scoreCardInfo;
    } else {
      paramIntimateInfo = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo = paramIntimateInfo;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramIntimateInfo = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setData scoreCardInfo:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo);
      QLog.i(paramIntimateInfo, 2, localStringBuilder.toString());
    }
    if (!a())
    {
      setVisibility(8);
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    if (paramInt == 1) {
      this.jdField_c_of_type_Int = 1;
    } else if (paramInt == 2) {
      this.jdField_c_of_type_Int = 2;
    } else if (paramInt == 26) {
      this.jdField_c_of_type_Int = 5;
    } else if (paramInt == 3) {
      this.jdField_c_of_type_Int = 3;
    } else {
      this.jdField_c_of_type_Int = 4;
    }
    setVisibility(0);
    int j = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore;
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore >= 0) {
      j = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setText(String.valueOf(j), false);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo.title);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo.typeDescribe);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo.levelDescribe);
    this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo.buttonDescribe);
    int i = 2131165734;
    if (paramInt == 3) {
      i = 2131165729;
    } else if (paramInt == 2) {
      i = 2131165727;
    } else if (paramInt == 26) {
      i = 2131165733;
    } else if (paramInt == 1) {
      i = 2131165731;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(i));
    b();
    if (QLog.isColorLevel())
    {
      paramIntimateInfo = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateIntimateInfo score: ");
      localStringBuilder.append(j);
      QLog.d(paramIntimateInfo, 2, localStringBuilder.toString());
    }
    if (!this.d)
    {
      this.d = true;
      ReportController.b(null, "dc00898", "", "", "0X800AE5A", "0X800AE5A", this.jdField_c_of_type_Int, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.IntimateScoreCardView
 * JD-Core Version:    0.7.0.1
 */