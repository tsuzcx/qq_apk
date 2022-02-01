package com.tencent.avgame.gameroom.video;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.audio.AudioRouter;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.controller.SurvivalAssistManager;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.qav.AVGameCameraAssistant;
import com.tencent.avgame.qav.AVGameCameraAssistant.CameraEventListener;
import com.tencent.avgame.qav.AVGameMediaPlayerCtrl;
import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.avgame.qav.SecurityPolicyChecker.CheckSecurityPolicyCallback;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.util.AVGameQualityCameraReportUtil;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.avgame.video.VideoRouter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qav.QavSDK;
import com.tencent.qav.controller.multi.IMultiOperator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AVGameControlUIImpl
  extends AVGameControlUI
{
  protected long a;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  protected Drawable a;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  protected View a;
  protected ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AVGameUIEventCallback jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback = new AVGameControlUIImpl.2(this);
  private AVGameControlUIImpl.CheckCameraTask jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask = null;
  protected AVGameNetWorkQualityManager a;
  protected AvGameMicroPhoneAnimatorHolder a;
  private AVGameCameraAssistant.CameraEventListener jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$CameraEventListener = new AVGameControlUIImpl.3(this);
  private final SecurityPolicyChecker.CheckSecurityPolicyCallback jdField_a_of_type_ComTencentAvgameQavSecurityPolicyChecker$CheckSecurityPolicyCallback = new AVGameControlUIImpl.9(this);
  protected AutoBgImageView a;
  public Integer a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AVGameControlUIImpl.1(this);
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -1L;
  protected AutoBgImageView b;
  public Integer b;
  private volatile boolean jdField_b_of_type_Boolean = false;
  protected AutoBgImageView c;
  public Integer c;
  private boolean c;
  
  public AVGameControlUIImpl(AVGameAppInterface paramAVGameAppInterface, BaseActivity paramBaseActivity, ViewGroup paramViewGroup)
  {
    super(paramAVGameAppInterface, paramBaseActivity, paramViewGroup);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    AVGameBusinessCtrl.b().a(this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback);
    this.jdField_a_of_type_AndroidOsHandler = AVGameHandler.a().b();
    SecurityPolicyChecker.a().a(this.jdField_a_of_type_ComTencentAvgameQavSecurityPolicyChecker$CheckSecurityPolicyCallback);
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView == null) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView != null) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.isShown()))) {}
    int i;
    do
    {
      return;
      i = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = paramInt;
    } while (this.jdField_b_of_type_Int == i);
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
    {
      paramInt = ((Integer)this.jdField_a_of_type_AndroidAnimationValueAnimator.getAnimatedValue()).intValue();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      i = paramInt;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new AVGameControlUIImpl.4(this));
      }
      int j;
      ValueAnimator localValueAnimator;
      long l;
      if (this.jdField_b_of_type_Int > i)
      {
        j = 1;
        localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        if (j == 0) {
          break label192;
        }
        l = 100L;
        label141:
        localValueAnimator.setDuration(l);
        localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        if (paramInt != -1) {
          break label200;
        }
      }
      for (;;)
      {
        localValueAnimator.setIntValues(new int[] { i, this.jdField_b_of_type_Int });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        return;
        j = 0;
        break;
        label192:
        l = 200L;
        break label141;
        label200:
        i = paramInt;
      }
      paramInt = -1;
    }
  }
  
  private void b(String paramString)
  {
    int j = 0;
    if (a()) {}
    AVGameBusinessCtrl localAVGameBusinessCtrl;
    AVGameSession localAVGameSession;
    do
    {
      do
      {
        return;
        localAVGameBusinessCtrl = AVGameBusinessCtrl.b();
      } while (localAVGameBusinessCtrl == null);
      localAVGameSession = localAVGameBusinessCtrl.a();
    } while (localAVGameSession == null);
    boolean bool = SecurityPolicyChecker.a().b();
    int i = j;
    AVGameUserInfo localAVGameUserInfo;
    if (bool)
    {
      localAVGameUserInfo = localAVGameSession.a();
      if ((localAVGameUserInfo == null) || (!localAVGameUserInfo.hasVideo()) || (!localAVGameUserInfo.mBigVideo)) {
        break label187;
      }
      localAVGameSession.g = true;
      i = j;
    }
    for (;;)
    {
      if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a())) {
        i = 8;
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.getVisibility() != i)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(i);
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("AVGameControlUIImpl", 4, "updateCameraBtn, [" + bool + "], visibility[" + i + "], from[" + paramString + "]");
      return;
      label187:
      if ((localAVGameUserInfo != null) && (localAVGameUserInfo.hasVideo()) && (!localAVGameUserInfo.mBigVideo))
      {
        localAVGameBusinessCtrl.c();
        i = 8;
      }
      else
      {
        i = 8;
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showTransientTip msgType:=" + paramInt);
    }
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(str);
      return;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690287);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690274);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690359);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690275);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690358);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690281);
      continue;
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690348);
    }
  }
  
  private boolean c()
  {
    return (AVGameUtils.b() == 2) && ((!GameEngine.a().a()) || (GameEngine.a().e()));
  }
  
  private void d(int paramInt)
  {
    EngineData localEngineData;
    if (paramInt == 1)
    {
      localEngineData = GameEngine.a().a();
      if (localEngineData.c() == 1)
      {
        Player localPlayer1 = localEngineData.a();
        Player localPlayer2 = localEngineData.b();
        if ((localPlayer1 == null) || (localPlayer2 == null) || (!TextUtils.equals(localPlayer1.uin, localPlayer2.uin))) {
          break label103;
        }
      }
    }
    label103:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        if (localEngineData.a() != 1) {
          break;
        }
        ReportController.b(null, "dc00898", "", "", "0X800B06E", "0X800B06E", 0, 0, "", "", "", "");
      }
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B073", "0X800B073", 0, 0, "", "", "", "");
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(7);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AVGameControlUIImpl.6(this), 3000L);
  }
  
  private boolean d()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_b_of_type_Long > 500L)
    {
      this.jdField_b_of_type_Long = l;
      return true;
    }
    return false;
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDrawable(2130838913);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAvGameMicroPhoneAnimatorHolder = new AvGameMicroPhoneAnimatorHolder((Activity)this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager = new AVGameNetWorkQualityManager(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363242));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363250));
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363249));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365340);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367699));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363393));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAvGameMicroPhoneAnimatorHolder.a());
    m();
    l();
    n();
    if (GameEngine.a().f())
    {
      i = ViewUtils.a(120.0F);
      this.jdField_a_of_type_AndroidViewView.setTranslationX(i);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      bool = GameEngine.a().g();
      if (!bool)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager != null) && (!bool)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager.a(false);
      }
      if (GameEngine.a().a().a() == 0)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      if (SecurityPolicyChecker.a().b()) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
    }
    while (!c())
    {
      int i;
      boolean bool;
      return;
    }
    a(8);
  }
  
  private void h()
  {
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  private void i()
  {
    if (!d()) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onClick_Speak fast-click");
      }
    }
    AVGameBusinessCtrl localAVGameBusinessCtrl;
    do
    {
      do
      {
        return;
        localAVGameBusinessCtrl = AVGameBusinessCtrl.b();
      } while (localAVGameBusinessCtrl == null);
      i = localAVGameBusinessCtrl.a();
      if (i != 2) {
        break;
      }
      c(3);
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onClick_Speak in AUDIO_ROUTE_BLUETOOTH status, not support close bluetooth");
    return;
    if (i == 0) {}
    for (int i = 1;; i = 0)
    {
      AVGameHandler.a().a().post(new AVGameControlUIImpl.7(this, localAVGameBusinessCtrl, i));
      return;
    }
  }
  
  private void j()
  {
    if (!d()) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onClick_Speak_WithNoAVRoom fast-click");
      }
    }
    AudioRouter localAudioRouter;
    do
    {
      do
      {
        return;
        localAudioRouter = (AudioRouter)GameEngine.a().a(SurvivalAssistManager.a);
      } while (localAudioRouter == null);
      i = localAudioRouter.a();
      if (i != 2) {
        break;
      }
      c(3);
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onClick_Speak_WithNoAVRoom in AUDIO_ROUTE_BLUETOOTH status, not support close bluetooth");
    return;
    if (i == 0) {}
    for (int i = 1;; i = 0)
    {
      AVGameHandler.a().a().post(new AVGameControlUIImpl.8(this, localAudioRouter, i));
      return;
    }
  }
  
  private void k()
  {
    int j = 1;
    Object localObject1 = AVGameBusinessCtrl.b().a();
    if (localObject1 != null)
    {
      boolean bool = ((AVGameSession)localObject1).e;
      AVGameBusinessCtrl.b().c(bool);
      m();
      if (!bool) {
        break label172;
      }
      i = 1;
      ReportController.b(null, "dc00898", "", "", "0X800B03A", "0X800B03A", i, 0, "", "", "", "");
      if (!bool)
      {
        Object localObject2 = GameEngine.a().a();
        if (((EngineData)localObject2).c() == 1)
        {
          localObject1 = ((EngineData)localObject2).a();
          localObject2 = ((EngineData)localObject2).b();
          if ((localObject1 == null) || (localObject2 == null) || (!TextUtils.equals(((Player)localObject1).uin, ((Player)localObject2).uin))) {
            break label177;
          }
        }
      }
    }
    label172:
    label177:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        ReportController.b(null, "dc00898", "", "", "0X800B074", "0X800B074", 0, 0, "", "", "", "");
      }
      return;
      i = 2;
      break;
    }
  }
  
  private void l()
  {
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().a();
    if ((localAVGameSession != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null)) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(localAVGameSession.a(1));
    }
  }
  
  private void m()
  {
    boolean bool2 = true;
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().a();
    Object localObject;
    if (localAVGameSession != null)
    {
      if (localAVGameSession.e) {
        break label109;
      }
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      if (!this.jdField_b_of_type_Boolean) {
        h();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
      if (localAVGameSession.e) {
        break label114;
      }
      bool1 = true;
      label56:
      ((AutoBgImageView)localObject).setSelected(bool1);
      AutoBgImageView localAutoBgImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
      if (!localAVGameSession.e) {
        break label119;
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label80:
      localAutoBgImageView.setImageDrawable((Drawable)localObject);
      localObject = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter;
      if (localAVGameSession.e) {
        break label130;
      }
    }
    label130:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((IGameRoomPresenter)localObject).d(bool1);
      return;
      label109:
      bool1 = false;
      break;
      label114:
      bool1 = false;
      break label56;
      label119:
      localObject = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAvGameMicroPhoneAnimatorHolder.a();
      break label80;
    }
  }
  
  private void n()
  {
    Object localObject = AVGameBusinessCtrl.b().a();
    if (localObject != null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(((AVGameSession)localObject).d);
    }
    do
    {
      return;
      localObject = (AudioRouter)GameEngine.a().a(SurvivalAssistManager.a);
    } while (localObject == null);
    if (((AudioRouter)localObject).a() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(bool);
      return;
    }
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public void a()
  {
    super.a();
    d();
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.l();
    AVGameMediaPlayerCtrl localAVGameMediaPlayerCtrl = AVGameBusinessCtrl.b().a();
    if (localAVGameMediaPlayerCtrl != null) {
      localAVGameMediaPlayerCtrl.a(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer);
    }
    do
    {
      do
      {
        return;
      } while ((!GameEngine.a().f()) || (GameEngine.a().g()));
      localAVGameMediaPlayerCtrl = ((VideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).a();
    } while (localAVGameMediaPlayerCtrl == null);
    localAVGameMediaPlayerCtrl.a(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != paramInt))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
      if ((paramInt == 0) || (paramInt == 4)) {
        this.jdField_a_of_type_AndroidViewView.setTranslationX(0.0F);
      }
    }
    else
    {
      return;
    }
    paramInt = ViewUtils.a(120.0F);
    this.jdField_a_of_type_AndroidViewView.setTranslationX(paramInt);
  }
  
  void a(long paramLong, int paramInt, View paramView)
  {
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().a();
    if (localAVGameSession == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("AVGameControlUIImpl", 2, "onClick_Camera, seq[" + paramLong + "], from[" + paramInt + "], session[" + localAVGameSession + "]");
      }
    } while (!a(paramLong, "android.permission.CAMERA", paramView, paramInt));
    boolean bool3 = SecurityPolicyChecker.a().b();
    boolean bool2 = localAVGameSession.a(1);
    boolean bool1;
    boolean bool4;
    if (paramInt == 2)
    {
      bool1 = false;
      bool4 = SecurityPolicyChecker.a().a(localAVGameSession.jdField_b_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i("AVGameControlUIImpl", 2, "onClick_Camera, seq[" + paramLong + "], from[" + paramInt + "], goOffStage" + bool1 + "], hasLocalVideo[" + bool2 + "], disableSmallPic[" + bool3 + "], canOpenCamera[" + bool4 + "], session[" + localAVGameSession + "]");
      }
      if (!bool1) {
        break label316;
      }
      if ((!bool4) && (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
      AVGameBusinessCtrl.b().c();
      d(paramInt);
      ReportController.b(null, "dc00898", "", "", "0X800B039", "0X800B039", 2, 0, "", "", "", "");
    }
    for (;;)
    {
      l();
      return;
      if (paramInt == 3)
      {
        bool1 = true;
        break;
      }
      bool1 = bool2;
      break;
      label316:
      if (paramInt == 1)
      {
        AVGameQualityCameraReportUtil.a(1);
        ReportController.b(null, "dc00898", "", "", "0X800B039", "0X800B039", 1, 0, "", "", "", "");
      }
      for (;;)
      {
        if (!bool4) {
          break label422;
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.getVisibility() != 0)) {
          this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
        }
        AVGameBusinessCtrl.b().b(paramInt);
        break;
        if (paramInt == 2) {
          AVGameQualityCameraReportUtil.a(2);
        } else if (paramInt == 4) {
          AVGameQualityCameraReportUtil.a(3);
        }
      }
      label422:
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
      QQToast.a(BaseApplicationImpl.getApplication(), 0, 2131690398, 1).a();
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    AVGameHandler.a().b().post(new AVGameControlUIImpl.5(this, paramInt, paramString2));
  }
  
  public void a(long paramLong, View paramView)
  {
    int i = 1;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    while ((GameEngine.a().a().f()) && (GameEngine.a().a() <= 1)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363242: 
      b(paramLong, paramView);
      return;
    case 2131363250: 
      a(paramLong, 1, paramView);
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE ");
    if ((GameEngine.a().f()) && (!GameEngine.a().g())) {}
    while (i != 0)
    {
      j();
      return;
      i = 0;
    }
    i();
  }
  
  public void a(RectF paramRectF)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer == null) || (paramRectF == null))
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onVideoDisplayUpdateWithNoAVRoom rectF:=" + paramRectF);
      return;
    }
    int i = (int)paramRectF.left;
    int j = (int)paramRectF.top;
    int k = (int)paramRectF.right;
    int m = (int)paramRectF.bottom;
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a(new Rect(i, j, k, m));
  }
  
  public void a(EngineData paramEngineData)
  {
    paramEngineData = paramEngineData.a();
    if ((paramEngineData != null) && ((paramEngineData.matchStatus == 1) || (paramEngineData.opened_match)))
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "refresh hideCameraButton");
      this.jdField_c_of_type_Boolean = true;
      f();
    }
  }
  
  public void a(String paramString)
  {
    if (AVGameBusinessCtrl.b() == null) {}
    label405:
    label411:
    for (;;)
    {
      return;
      AVGameSession localAVGameSession = AVGameBusinessCtrl.b().a();
      if (localAVGameSession == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged player[" + paramString + "], session is null.");
        }
      }
      else
      {
        this.jdField_a_of_type_Long = 0L;
        long l = AVGameUtils.a(paramString);
        SecurityPolicyChecker.a().a(paramString);
        localAVGameSession.a();
        boolean bool1;
        boolean bool2;
        if (l != 0L)
        {
          bool1 = localAVGameSession.a(l, true);
          if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a())) {
            break label236;
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged should not click camera in match mode");
            bool2 = bool1;
          }
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label411;
          }
          QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged, uin[" + this.jdField_a_of_type_Long + "], ret[" + bool2 + "], player[" + paramString + "], self[" + this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount() + "], auto[" + localAVGameSession.g + "]");
          return;
          bool1 = true;
          break;
          label236:
          if (TextUtils.equals(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount(), paramString))
          {
            if (!localAVGameSession.a(1))
            {
              if (QLog.isColorLevel()) {
                QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged, go on state, session[" + localAVGameSession + "]");
              }
              a(AudioHelper.b(), 2, this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView);
            }
            bool2 = true;
          }
          for (;;)
          {
            if (!bool2) {
              break label405;
            }
            c();
            break;
            if ((localAVGameSession.g) && (localAVGameSession.a(1)))
            {
              a(AudioHelper.b(), 3, this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView);
              bool2 = bool1;
            }
            else
            {
              bool2 = bool1;
              if (!SecurityPolicyChecker.a().a(localAVGameSession.jdField_b_of_type_Long))
              {
                bool2 = bool1;
                if (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView != null)
                {
                  this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
                  bool2 = bool1;
                }
              }
            }
          }
          this.jdField_a_of_type_Long = l;
        }
      }
    }
  }
  
  public void a(List<MemberVideoDisplayInfo> paramList)
  {
    if (paramList.isEmpty()) {}
    while (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.c(paramBoolean);
    }
  }
  
  @RequiresApi(api=16)
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    try
    {
      if ((AudioProcess.a()) && (AudioProcess.a().b()))
      {
        if (paramInt == 25) {}
        for (paramInt = -1;; paramInt = 1)
        {
          paramKeyEvent = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
          int i = paramKeyEvent.getStreamVolume(0);
          if (this.jdField_a_of_type_JavaLangInteger == null) {
            this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(i);
          }
          int j = paramKeyEvent.getStreamMaxVolume(0);
          if (this.jdField_c_of_type_JavaLangInteger == null) {
            this.jdField_c_of_type_JavaLangInteger = Integer.valueOf(j);
          }
          paramKeyEvent.adjustStreamVolume(0, paramInt, 1);
          paramInt = paramKeyEvent.getStreamVolume(0);
          this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt);
          paramKeyEvent = AVGameBusinessCtrl.b().a();
          if (paramKeyEvent != null) {
            paramKeyEvent.a(this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_c_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue());
          }
          if (QLog.isColorLevel()) {
            QLog.d("AVGameControlUIImpl", 2, "adjustStreamVolume. streamType = " + 0 + ", maxVolume = " + j + ", oldVolume = " + i + ", newVolume = " + paramInt);
          }
          return true;
        }
      }
      return false;
    }
    catch (Exception paramKeyEvent)
    {
      QLog.e("AVGameControlUIImpl", 1, "adjustStreamVolume fail.", paramKeyEvent);
    }
  }
  
  public void b(long paramLong)
  {
    super.b(paramLong);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.m();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask == null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask = new AVGameControlUIImpl.CheckCameraTask();
    }
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask);
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager.b();
    }
    AVGameMediaPlayerCtrl localAVGameMediaPlayerCtrl = AVGameBusinessCtrl.b().a();
    if (localAVGameMediaPlayerCtrl != null) {
      localAVGameMediaPlayerCtrl.f();
    }
    for (;;)
    {
      if (SecurityPolicyChecker.a().a()) {
        b("onResume");
      }
      return;
      localAVGameMediaPlayerCtrl = ((VideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).a();
      if (localAVGameMediaPlayerCtrl != null) {
        localAVGameMediaPlayerCtrl.f();
      }
    }
  }
  
  void b(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.RECORD_AUDIO", paramView, 0)) {
      k();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject;
    if (GameEngine.a().f())
    {
      boolean bool = GameEngine.a().g();
      if (!bool)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager != null) && (!bool)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager.a(false);
      }
      if ((!bool) && (!paramBoolean))
      {
        localObject = ((VideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).a();
        if (localObject != null) {
          ((AVGameMediaPlayerCtrl)localObject).a(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer);
        }
      }
      if (!paramBoolean)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
    do
    {
      do
      {
        return;
        m();
        n();
        l();
        return;
        if (c())
        {
          a(8);
          return;
        }
        if (!paramBoolean) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0);
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "start control animation");
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      int i = ViewUtils.a(120.0F);
      localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationX", new float[] { 0.0F, i });
      ((ObjectAnimator)localObject).setDuration(250L);
      ((ObjectAnimator)localObject).start();
      return;
    } while (GameEngine.a().a().a() != 0);
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "show begin btn");
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewView.setTranslationX(0.0F);
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.getVisibility() != 0;
  }
  
  public void c()
  {
    AVGameHandler.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    AVGameHandler.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  public void c(long paramLong)
  {
    super.c(paramLong);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.n();
    e();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask);
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask = null;
    }
    AVGameMediaPlayerCtrl localAVGameMediaPlayerCtrl = AVGameBusinessCtrl.b().a();
    if (localAVGameMediaPlayerCtrl != null) {
      localAVGameMediaPlayerCtrl.g();
    }
    do
    {
      return;
      localAVGameMediaPlayerCtrl = ((VideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).a();
    } while (localAVGameMediaPlayerCtrl == null);
    localAVGameMediaPlayerCtrl.g();
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "refresh isMatching hideCameraButton");
      this.jdField_c_of_type_Boolean = true;
      f();
    }
  }
  
  protected void d()
  {
    if (a() == null) {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "initUI-->can not get AVGameActivity");
      }
    }
    do
    {
      return;
      g();
      AVGameCameraAssistant localAVGameCameraAssistant = AVGameBusinessCtrl.b().a();
      if (localAVGameCameraAssistant != null) {
        localAVGameCameraAssistant.a(this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$CameraEventListener);
      }
    } while (!GameEngine.a().f());
    c(true);
  }
  
  public void d(long paramLong)
  {
    super.d(paramLong);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.o();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager != null)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager.c();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager = null;
    }
    Object localObject = AVGameBusinessCtrl.b();
    if (localObject != null)
    {
      AVGameCameraAssistant localAVGameCameraAssistant = ((AVGameBusinessCtrl)localObject).a();
      if (localAVGameCameraAssistant != null) {
        localAVGameCameraAssistant.b(this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$CameraEventListener);
      }
      ((AVGameBusinessCtrl)localObject).b(this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback);
    }
    localObject = AVGameBusinessCtrl.b().a();
    if (localObject != null) {
      ((AVGameMediaPlayerCtrl)localObject).b(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer);
    }
    do
    {
      return;
      localObject = ((VideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).a();
    } while (localObject == null);
    ((AVGameMediaPlayerCtrl)localObject).b(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer);
  }
  
  public void e()
  {
    AVGameHandler.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    QavSDK.a().a().d();
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.isSelected()) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.callOnClick();
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
    GameEngine.a().a().a().opened_match = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl
 * JD-Core Version:    0.7.0.1
 */