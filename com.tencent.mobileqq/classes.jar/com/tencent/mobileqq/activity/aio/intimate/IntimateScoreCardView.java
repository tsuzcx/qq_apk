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
  private boolean A = false;
  public Context b;
  Runnable c = new IntimateScoreCardView.1(this);
  Runnable d = new IntimateScoreCardView.2(this);
  private QQAppInterface e;
  private IntimateScoreCardView.Callback f;
  private boolean g = false;
  private View h;
  private RelativeLayout i;
  private TextView j;
  private ImageView k;
  private RelativeLayout l;
  private TickerView m;
  private DiniFlyAnimationView n;
  private String o;
  private TextView p;
  private TextView q;
  private Button r;
  private ValueAnimator s;
  private boolean t = false;
  private boolean u = false;
  private IntimateInfo v;
  private IntimateInfo.IntimateScoreCardInfo w;
  private int x;
  private int y;
  private int z = 4;
  
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
    this.b = paramContext;
  }
  
  private void a()
  {
    this.g = true;
    View localView = LayoutInflater.from(this.b).inflate(2131625196, this, true);
    this.i = ((RelativeLayout)localView.findViewById(2131445324));
    this.j = ((TextView)localView.findViewById(2131445323));
    this.k = ((ImageView)localView.findViewById(2131445318));
    this.l = ((RelativeLayout)localView.findViewById(2131445322));
    this.m = ((TickerView)localView.findViewById(2131445321));
    this.m.setCharacterLists(new String[] { "9876543210" });
    this.m.setAnimationDuration(2000L);
    this.n = ((DiniFlyAnimationView)localView.findViewById(2131445320));
    this.p = ((TextView)localView.findViewById(2131445325));
    this.q = ((TextView)localView.findViewById(2131445319));
    this.r = ((Button)localView.findViewById(2131445317));
    this.r.setOnClickListener(this);
    this.h = localView.findViewById(2131435887);
    this.h.setOnClickListener(this);
    this.h.setOnTouchListener(this);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if (!this.t) {
        return;
      }
      localObject = (IntimateInfoManager)((QQAppInterface)localObject).getManager(QQManagerFactory.INTIMATE_INFO_MANAGER);
      if (localObject == null) {
        return;
      }
      String str = ((IntimateInfoManager)localObject).a(this.x, paramBoolean);
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
      this.o = ((String)localObject);
      try
      {
        LottieComposition.Factory.fromInputStream(getContext(), new FileInputStream(str), this);
        this.n.setVisibility(0);
        return;
      }
      catch (Throwable localThrowable)
      {
        str = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startScoreLottieAnim error:");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  private boolean b()
  {
    Object localObject = this.v;
    boolean bool = true;
    int i1 = 0;
    if ((localObject != null) && (this.w != null))
    {
      localObject = FriendIntimateRelationshipConfProcessor.a();
      if (IntimateUtil.a(this.x) ? this.v.currentScore >= ((FriendIntimateRelationshipBean)localObject).U : this.v.currentScore >= ((FriendIntimateRelationshipBean)localObject).W) {}
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canShow res: ");
      localStringBuilder.append(bool);
      localStringBuilder.append("  mCurrentShowType:");
      localStringBuilder.append(this.y);
      localStringBuilder.append(" score:");
      IntimateInfo localIntimateInfo = this.v;
      if (localIntimateInfo != null) {
        i1 = localIntimateInfo.currentScore;
      }
      localStringBuilder.append(i1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean c()
  {
    boolean bool;
    if (this.y == 4) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canUpdateAnim res: ");
      localStringBuilder.append(bool);
      localStringBuilder.append("  mCurrentShowType:");
      localStringBuilder.append(this.y);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private void d()
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndStartUpdateAnim mIsResumed:");
      localStringBuilder.append(this.t);
      localStringBuilder.append(" mCurrentShowType:");
      localStringBuilder.append(this.y);
      localStringBuilder.append(" mIntimateInfo:");
      localStringBuilder.append(this.v);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if ((this.t) && (this.v != null) && (b()))
    {
      removeCallbacks(this.c);
      if ((c()) && (this.v.lastAnimAfterScore != this.v.currentScore) && (this.v.currentScore > 0))
      {
        postDelayed(this.c, 300L);
        return;
      }
      g();
    }
  }
  
  private void e()
  {
    int i1 = this.v.lastAnimAfterScore;
    boolean bool1 = false;
    int i2 = Math.max(0, i1);
    int i3 = Math.max(0, this.v.currentScore);
    boolean bool2 = QLog.isColorLevel();
    i1 = 2;
    if (bool2)
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("smoothUpdateScores fromScore:");
      localStringBuilder.append(i2);
      localStringBuilder.append(" toScore:");
      localStringBuilder.append(i3);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.m;
    if (i3 > i2) {
      i1 = 1;
    }
    ((TickerView)localObject).setPreferredScrollingDirection(i1);
    this.m.setDigitalAnimWidthSpeedIncrement(true);
    this.m.setIgnoreWidthAnim(true);
    this.m.setText(String.valueOf(i3));
    removeCallbacks(this.d);
    postDelayed(this.d, 2500L);
    if (IntimateUtil.a(this.x))
    {
      if (i3 > i2) {
        bool1 = true;
      }
      a(bool1);
    }
    localObject = this.f;
    if (localObject != null) {
      ((IntimateScoreCardView.Callback)localObject).p();
    }
  }
  
  private void f()
  {
    if ((this.n.getVisibility() == 0) || (this.n.isAnimating()))
    {
      this.n.setVisibility(8);
      this.n.cancelAnimation();
      this.n.removeAllLottieOnCompositionLoadedListener();
    }
  }
  
  private void g()
  {
    if (this.v == null)
    {
      h();
      return;
    }
    if (!IntimateUtil.a(this.x))
    {
      h();
      return;
    }
    Object localObject = FriendIntimateRelationshipConfProcessor.a();
    if ((this.v.currentScore < ((FriendIntimateRelationshipBean)localObject).V) && (this.v.currentScore >= ((FriendIntimateRelationshipBean)localObject).U))
    {
      localObject = this.s;
      if ((localObject != null) && (((ValueAnimator)localObject).isRunning())) {
        return;
      }
      if (this.s == null)
      {
        this.s = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        this.s.setInterpolator(new LinearInterpolator());
        this.s.setDuration(1500L);
        this.s.setRepeatCount(-1);
        this.s.addUpdateListener(new IntimateScoreCardView.3(this));
        this.s.addListener(new IntimateScoreCardView.4(this));
      }
      this.s.start();
      return;
    }
    h();
  }
  
  private void h()
  {
    ValueAnimator localValueAnimator = this.s;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.s.cancel();
    }
  }
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    if (!this.g) {
      return null;
    }
    paramLottieImageAsset = paramLottieImageAsset.getFileName();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.o);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramLottieImageAsset);
    paramLottieImageAsset = ((StringBuilder)localObject).toString();
    boolean bool = new File(paramLottieImageAsset).exists();
    StringBuilder localStringBuilder;
    if (!bool)
    {
      if (QLog.isColorLevel())
      {
        localObject = a;
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
      localObject = a;
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
      QLog.i(a, 2, "onClick");
    }
    int i1 = paramView.getId();
    if (i1 != 2131435887)
    {
      if (i1 == 2131445317) {
        ReportController.b(null, "dc00898", "", "", "0X800AE5C", "0X800AE5C", this.z, 0, "", "", "", "");
      }
    }
    else {
      ReportController.b(null, "dc00898", "", "", "0X800AE5B", "0X800AE5B", this.z, 0, "", "", "", "");
    }
    IntimateScoreCardView.Callback localCallback = this.f;
    if (localCallback != null)
    {
      IntimateInfo.IntimateScoreCardInfo localIntimateScoreCardInfo = this.w;
      if (localIntimateScoreCardInfo != null) {
        localCallback.a(localIntimateScoreCardInfo.buttonUrl);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (!this.g) {
      return;
    }
    if ((paramLottieComposition != null) && (this.n.getVisibility() == 0) && (this.t))
    {
      int i1 = AIOUtils.b(75.0F, getResources());
      int i2 = AIOUtils.b(90.0F, getResources());
      Object localObject = paramLottieComposition.getBounds();
      float f1 = i1 / ((Rect)localObject).width();
      float f2 = i2 / ((Rect)localObject).height();
      this.n.setImageAssetDelegate(this);
      this.n.setComposition(paramLottieComposition);
      this.n.setScaleXY(f1, f2);
      this.n.setScaleType(ImageView.ScaleType.FIT_XY);
      if ((this.t) && (this.n.getVisibility() == 0))
      {
        this.n.playAnimation();
      }
      else
      {
        this.n.cancelAnimation();
        this.n.removeAllLottieOnCompositionLoadedListener();
      }
      if (QLog.isColorLevel())
      {
        paramLottieComposition = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCompositionLoaded playAnim duration: ");
        ((StringBuilder)localObject).append(this.n.getDuration());
        ((StringBuilder)localObject).append(" mIsResumed:");
        ((StringBuilder)localObject).append(this.t);
        QLog.d(paramLottieComposition, 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "composition is null ,return");
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (((i1 == 1) || (i1 == 3)) && (Build.VERSION.SDK_INT >= 11)) {
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
    this.e = paramQQAppInterface;
  }
  
  public void setCallBack(IntimateScoreCardView.Callback paramCallback)
  {
    this.f = paramCallback;
  }
  
  public void setCurrentShowType(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCurrentShowType showType: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  old:");
      localStringBuilder.append(this.y);
      localStringBuilder.append("  this:");
      localStringBuilder.append(this);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.y = paramInt;
  }
  
  public void setData(IntimateInfo paramIntimateInfo, int paramInt)
  {
    this.v = paramIntimateInfo;
    this.x = paramInt;
    if (paramIntimateInfo != null) {
      paramIntimateInfo = paramIntimateInfo.scoreCardInfo;
    } else {
      paramIntimateInfo = null;
    }
    this.w = paramIntimateInfo;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramIntimateInfo = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setData scoreCardInfo:");
      localStringBuilder.append(this.w);
      QLog.i(paramIntimateInfo, 2, localStringBuilder.toString());
    }
    if (!b())
    {
      setVisibility(8);
      return;
    }
    if (!this.g) {
      a();
    }
    if (paramInt == 1) {
      this.z = 1;
    } else if (paramInt == 2) {
      this.z = 2;
    } else if (paramInt == 26) {
      this.z = 5;
    } else if (paramInt == 3) {
      this.z = 3;
    } else {
      this.z = 4;
    }
    setVisibility(0);
    int i2 = this.v.currentScore;
    if (this.v.currentScore >= 0) {
      i2 = Math.max(0, this.v.lastAnimAfterScore);
    }
    this.m.setText(String.valueOf(i2), false);
    this.j.setText(this.w.title);
    this.p.setText(this.w.typeDescribe);
    this.q.setText(this.w.levelDescribe);
    this.r.setText(this.w.buttonDescribe);
    int i1 = 2131166328;
    if (paramInt == 3) {
      i1 = 2131166323;
    } else if (paramInt == 2) {
      i1 = 2131166321;
    } else if (paramInt == 26) {
      i1 = 2131166327;
    } else if (paramInt == 1) {
      i1 = 2131166325;
    }
    this.m.setTextColor(this.b.getResources().getColor(i1));
    d();
    if (QLog.isColorLevel())
    {
      paramIntimateInfo = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateIntimateInfo score: ");
      localStringBuilder.append(i2);
      QLog.d(paramIntimateInfo, 2, localStringBuilder.toString());
    }
    if (!this.A)
    {
      this.A = true;
      ReportController.b(null, "dc00898", "", "", "0X800AE5A", "0X800AE5A", this.z, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.IntimateScoreCardView
 * JD-Core Version:    0.7.0.1
 */