package com.tencent.mobileqq.apollo.lightGame;

import alsd;
import alvx;
import amip;
import amtj;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bjng;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;
import java.util.Timer;
import mqq.os.MqqHandler;

public class CmGameLoadingView
  extends RelativeLayout
  implements Handler.Callback
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  public Button a;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public TextView a;
  private bjng jdField_a_of_type_Bjng = new bjng(Looper.getMainLooper(), this);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private CmGameStartChecker.StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private CmGameLoadingView.ProgressTimerTask jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView$ProgressTimerTask;
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  public DiniFlyAnimationView a;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private float jdField_b_of_type_Float;
  public TextView b;
  private ApolloLottieAnim jdField_b_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  public DiniFlyAnimationView b;
  private boolean jdField_b_of_type_Boolean;
  private volatile float jdField_c_of_type_Float;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private volatile boolean jdField_c_of_type_Boolean;
  private TextView d;
  
  public CmGameLoadingView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CmGameLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CmGameLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static CmGameLoadingView a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      return null;
    }
    if (paramBoolean) {}
    for (int i = 2131558918;; i = 2131558919)
    {
      paramContext = (CmGameLoadingView)View.inflate(paramContext, i, null);
      paramContext.e();
      return paramContext;
    }
  }
  
  private void c(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong)
  {
    Object localObject = "";
    Bundle localBundle = new Bundle();
    if (paramStartCheckParam != null) {
      localObject = paramStartCheckParam.wordingV2;
    }
    if (paramLong == -10L) {
      paramStartCheckParam = amtj.a(2131701249);
    }
    for (;;)
    {
      localBundle.putString("failWording", paramStartCheckParam);
      localBundle.putLong("resultCode", paramLong);
      localObject = this.jdField_a_of_type_Bjng.obtainMessage(3);
      ((Message)localObject).obj = localBundle;
      this.jdField_a_of_type_Bjng.sendMessage((Message)localObject);
      QLog.e("CmGameLoadingView", 1, new Object[] { "sendGameFailed failed resultCode:", Long.valueOf(paramLong), ",failWording:", paramStartCheckParam });
      return;
      if (paramLong == -12L)
      {
        paramStartCheckParam = amtj.a(2131701248);
      }
      else if (paramLong == -13L)
      {
        paramStartCheckParam = amtj.a(2131701232);
      }
      else if ((paramLong == -15L) || (paramLong == -17L))
      {
        paramStartCheckParam = amtj.a(2131701229);
      }
      else
      {
        paramStartCheckParam = (CmGameStartChecker.StartCheckParam)localObject;
        if (paramLong == -16L) {
          paramStartCheckParam = amtj.a(2131701247);
        }
      }
    }
  }
  
  private void e()
  {
    QLog.d("CmGameLoadingView", 1, "[initView]");
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131367408));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367410));
    this.d = ((TextView)super.findViewById(2131367414));
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131368255);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131380012));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363816));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131369607));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379975));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)super.findViewById(2131365756));
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)super.findViewById(2131365755));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(null, super.getContext());
    this.jdField_b_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(null, super.getContext());
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.isLottieAnimJsonDone(amip.l + "cmgame_loading_progress_lottie/"))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.fromFileWithCacheBitmap(super.getContext(), this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, amip.l + "cmgame_loading_progress_lottie/", false);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.fromFileWithCacheBitmap(super.getContext(), this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, amip.l + "cmgame_loading_progress_lottie/bubble/", true);
      this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
    }
    for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
    {
      setProgressViewVisibility(true);
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.fromNetworkWithCacheBitmap(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, "https://cmshow.gtimg.cn/client/zip/cmgame_loading_progress_lottie.zip", amip.l + "cmgame_loading_progress_lottie.zip", false);
    }
  }
  
  public void a()
  {
    setPeriodAnimationEnd(0.85F);
    a(150, 0.95F);
  }
  
  public void a(float paramFloat)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      }
    } while (paramFloat <= this.jdField_a_of_type_Float);
    setProgressBubbleParams(paramFloat);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setProgress(paramFloat);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%d%%", new Object[] { Integer.valueOf((int)Math.ceil(100.0F * paramFloat)) }));
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(float paramFloat, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilTimer == null) && (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView$ProgressTimerTask == null)) {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_JavaUtilTimer = new Timer();
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView$ProgressTimerTask = new CmGameLoadingView.ProgressTimerTask(this, paramFloat);
        this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView$ProgressTimerTask, 0L, paramInt);
        return;
      }
    }
    c();
    QLog.e("CmGameLoadingView", 1, "timer is not end");
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if ((paramFloat > this.jdField_b_of_type_Float) && (paramFloat > this.jdField_c_of_type_Float))
    {
      paramInt = (int)(paramInt / ((paramFloat - this.jdField_b_of_type_Float) / 0.01F));
      if (paramInt > 0)
      {
        a(paramFloat, paramInt);
        this.jdField_b_of_type_Float = paramFloat;
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      QLog.e("CmGameLoadingView", 1, "IllegalArgumentException Non-positive period.");
      return;
    }
    QLog.d("CmGameLoadingView", 2, new Object[] { "autoPlayPeriodAnimation endProgress:", Float.valueOf(paramFloat), ", mLastPeriodEndProgress:", Float.valueOf(this.jdField_b_of_type_Float), ", mProgress:", Float.valueOf(this.jdField_c_of_type_Float) });
  }
  
  public void a(int paramInt, CmGameStartChecker paramCmGameStartChecker)
  {
    ThreadManager.getUIHandler().post(new CmGameLoadingView.1(this, paramInt, paramCmGameStartChecker));
  }
  
  public void a(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    setPeriodAnimationEnd(0.15F);
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    Object localObject3 = null;
    QLog.d("CmGameLoadingView", 1, "[updateGameInfo]");
    if (paramStartCheckParam == null)
    {
      QLog.e("CmGameLoadingView", 1, "[initView] startCheckParam null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    Object localObject1 = super.getResources().getDisplayMetrics();
    int i;
    Resources localResources;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode > 0) {
      if (((DisplayMetrics)localObject1).heightPixels > ((DisplayMetrics)localObject1).widthPixels)
      {
        i = ((DisplayMetrics)localObject1).heightPixels;
        this.jdField_a_of_type_Int = i;
        setProgressBubbleParams(0.0F);
        localResources = super.getResources();
        if (paramStartCheckParam.game == null) {
          break label359;
        }
      }
    }
    label180:
    label208:
    label347:
    label359:
    for (localObject1 = paramStartCheckParam.game.logoUrl;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = String.format(Locale.getDefault(), "https://i.hudongcdn.com/%1$d/sp_main_1_1.png", new Object[] { Integer.valueOf(paramStartCheckParam.gameId) });
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localResources.getDrawable(2130838543);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localResources.getDrawable(2130838543);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1));
        if ((paramStartCheckParam.game == null) || (TextUtils.isEmpty(paramStartCheckParam.game.name))) {
          break label326;
        }
        localObject1 = paramStartCheckParam.game.name;
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = localResources.getString(2131690415);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if ((paramStartCheckParam.game == null) || (!paramStartCheckParam.game.isFeatured)) {
          break label347;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      for (;;)
      {
        a(700, 0.15F);
        return;
        i = ((DisplayMetrics)localObject1).widthPixels;
        break;
        if (((DisplayMetrics)localObject1).heightPixels < ((DisplayMetrics)localObject1).widthPixels) {}
        for (i = ((DisplayMetrics)localObject1).heightPixels;; i = ((DisplayMetrics)localObject1).widthPixels)
        {
          this.jdField_a_of_type_Int = i;
          break;
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130838543);
        break label180;
        localObject1 = localObject3;
        if (TextUtils.isEmpty(paramStartCheckParam.gameName)) {
          break label208;
        }
        localObject1 = paramStartCheckParam.gameName;
        break label208;
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    if (paramInt < 0) {
      paramInt = 0;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt >= 100) {
        i = 99;
      }
      paramStartCheckParam = this.jdField_a_of_type_Bjng.obtainMessage(4);
      paramStartCheckParam.obj = Integer.valueOf(i);
      this.jdField_a_of_type_Bjng.removeMessages(4);
      this.jdField_a_of_type_Bjng.sendMessage(paramStartCheckParam);
      return;
    }
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess))
    {
      a(4000, 0.85F);
      return;
    }
    a(1500, 0.85F);
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam, alsd paramalsd, long paramLong)
  {
    this.jdField_a_of_type_Bjng.post(new CmGameLoadingView.2(this, paramStartCheckParam, paramLong, paramalsd));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      setPeriodAnimationEnd(0.85F);
    }
    for (;;)
    {
      a(50, 1.0F);
      return;
      setPeriodAnimationEnd(0.95F);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    Message localMessage = this.jdField_a_of_type_Bjng.obtainMessage(1);
    if (paramBoolean) {}
    for (;;)
    {
      localMessage.obj = Long.valueOf(paramLong);
      this.jdField_a_of_type_Bjng.sendMessage(localMessage);
      return;
      paramLong = -1L;
    }
  }
  
  public void b()
  {
    setPeriodAnimationEnd(0.95F);
    a(60, 1.0F);
  }
  
  public void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    Message localMessage = this.jdField_a_of_type_Bjng.obtainMessage(2);
    localMessage.obj = paramStartCheckParam;
    this.jdField_a_of_type_Bjng.sendMessage(localMessage);
  }
  
  public void b(CmGameStartChecker.StartCheckParam paramStartCheckParam, long paramLong)
  {
    c(paramStartCheckParam, paramLong);
  }
  
  public void c()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView$ProgressTimerTask != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView$ProgressTimerTask.cancel();
        this.jdField_a_of_type_ComTencentMobileqqApolloLightGameCmGameLoadingView$ProgressTimerTask = null;
      }
      return;
    }
  }
  
  public void d()
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.destroy();
    this.jdField_b_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.destroy();
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_c_of_type_Boolean = true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l;
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      for (;;)
      {
        return false;
        l = ((Long)paramMessage.obj).longValue();
        if (l > 0L)
        {
          if (this.d != null)
          {
            paramMessage = String.valueOf(l) + amtj.a(2131701233);
            if (l > 9999L) {
              paramMessage = String.valueOf(l / 10000L) + amtj.a(2131701239);
            }
            this.d.setVisibility(0);
            this.d.setText(paramMessage);
          }
        }
        else if (this.d != null)
        {
          this.d.setVisibility(4);
          continue;
          if (paramMessage.obj != null) {
            a((CmGameStartChecker.StartCheckParam)paramMessage.obj);
          }
        }
      }
    case 3: 
      paramMessage = (Bundle)paramMessage.obj;
      if (paramMessage != null)
      {
        localObject = paramMessage.getString("failWording");
        l = paramMessage.getLong("resultCode");
      }
      break;
    }
    for (;;)
    {
      paramMessage = (Message)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramMessage = amtj.a(2131701226);
      }
      localObject = paramMessage;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr) {
          break label481;
        }
      }
      label481:
      for (localObject = paramMessage;; localObject = paramMessage + amtj.a(2131701242) + l)
      {
        alvx.a(new Object[] { "[game failed] ", localObject });
        setProgressViewVisibility(false);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        paramMessage = alvx.a();
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (paramMessage == null)) {
          break;
        }
        localObject = new HashMap();
        ((HashMap)localObject).put("param_gameId", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId));
        ((HashMap)localObject).put("param_Result", "0");
        ((HashMap)localObject).put("param_FailCode", String.valueOf(l));
        StatisticCollector.getInstance(paramMessage.getApp()).collectPerformance(paramMessage.getCurrentAccountUin(), "cmgame_launch_result", false, 0L, 0L, (HashMap)localObject, "", false);
        QLog.d("CmGameStat", 1, new Object[] { "cmgame_launch_result, failed", " [gameId=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), ", failCode=", Long.valueOf(l), "]" });
        alvx.a(paramMessage, 1, 1, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, l, null);
        break;
      }
      int i = ((Integer)paramMessage.obj).intValue();
      if (i >= 99)
      {
        setPeriodAnimationEnd(0.65F);
        break;
      }
      this.jdField_c_of_type_Float = (i / 200.0F + this.jdField_b_of_type_Float);
      a(this.jdField_c_of_type_Float);
      break;
      a(((Float)paramMessage.obj).floatValue());
      break;
      l = 0L;
      localObject = null;
    }
  }
  
  public void setPeriodAnimationEnd(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameLoadingView", 2, new Object[] { "setPeriodAnimationEnd endProgress:", Float.valueOf(paramFloat), ", cur progress:", Float.valueOf(this.jdField_c_of_type_Float) });
    }
    if (paramFloat > this.jdField_c_of_type_Float)
    {
      c();
      Message localMessage = this.jdField_a_of_type_Bjng.obtainMessage(5);
      localMessage.obj = Float.valueOf(paramFloat);
      this.jdField_a_of_type_Bjng.removeMessages(5);
      this.jdField_a_of_type_Bjng.sendMessage(localMessage);
      this.jdField_b_of_type_Float = paramFloat;
    }
  }
  
  public void setProgressBubbleParams(float paramFloat)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
    localLayoutParams.leftMargin = (this.jdField_a_of_type_Int / 2 - DisplayUtil.dip2px(super.getContext(), 62.0F) + (int)(DisplayUtil.dip2px(super.getContext(), 110.0F) * paramFloat));
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams(localLayoutParams);
  }
  
  public void setProgressViewVisibility(boolean paramBoolean)
  {
    int i = 0;
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (!paramBoolean) {
        break label65;
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label71;
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(i);
      return;
      bool = false;
      break;
      label65:
      i = 8;
    }
    label71:
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(i);
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(i);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView
 * JD-Core Version:    0.7.0.1
 */