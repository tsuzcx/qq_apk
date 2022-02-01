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
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.controller.SurvivalAssistManager;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.qav.AVGameCameraAssistant;
import com.tencent.avgame.qav.AVGameCameraAssistant.CameraEventListener;
import com.tencent.avgame.qav.IAVGameMediaPlayerCtrl;
import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.avgame.qav.SecurityPolicyChecker.CheckSecurityPolicyCallback;
import com.tencent.avgame.qav.audio.AudioRouter;
import com.tencent.avgame.report.AVGameQualityCameraReportUtil;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.avgame.video.api.IVideoRouter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQAudioHelper;
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
  
  public AVGameControlUIImpl(AVGameAppInterface paramAVGameAppInterface, QBaseActivity paramQBaseActivity, ViewGroup paramViewGroup)
  {
    super(paramAVGameAppInterface, paramQBaseActivity, paramViewGroup);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    AVGameBusinessCtrl.b().a(this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback);
    this.jdField_a_of_type_AndroidOsHandler = AVGameHandler.a().b();
    SecurityPolicyChecker.a().a(this.jdField_a_of_type_ComTencentAvgameQavSecurityPolicyChecker$CheckSecurityPolicyCallback);
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
    if (localObject != null)
    {
      if ((localObject != null) && (!((AutoBgImageView)localObject).isShown())) {
        return;
      }
      int j = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = paramInt;
      if (this.jdField_b_of_type_Int != j)
      {
        localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        int i;
        if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
        {
          paramInt = ((Integer)this.jdField_a_of_type_AndroidAnimationValueAnimator.getAnimatedValue()).intValue();
          this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
          i = paramInt;
        }
        else
        {
          i = -1;
          paramInt = j;
        }
        if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
        {
          this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
          this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new AVGameControlUIImpl.4(this));
        }
        if (this.jdField_b_of_type_Int > paramInt) {
          j = 1;
        } else {
          j = 0;
        }
        localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        long l;
        if (j != 0) {
          l = 100L;
        } else {
          l = 200L;
        }
        ((ValueAnimator)localObject).setDuration(l);
        localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
        j = i;
        if (i == -1) {
          j = paramInt;
        }
        ((ValueAnimator)localObject).setIntValues(new int[] { j, this.jdField_b_of_type_Int });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
    }
  }
  
  private void b(String paramString)
  {
    if (a()) {
      return;
    }
    Object localObject = AVGameBusinessCtrl.b();
    if (localObject == null) {
      return;
    }
    AVGameSession localAVGameSession = ((AVGameBusinessCtrl)localObject).a();
    if (localAVGameSession == null) {
      return;
    }
    boolean bool = SecurityPolicyChecker.a().b();
    int j = 0;
    int i = j;
    if (bool)
    {
      AVGameUserInfo localAVGameUserInfo = localAVGameSession.a();
      if ((localAVGameUserInfo != null) && (localAVGameUserInfo.hasVideo()) && (localAVGameUserInfo.mBigVideo))
      {
        localAVGameSession.g = true;
        i = j;
      }
      else
      {
        if ((localAVGameUserInfo != null) && (localAVGameUserInfo.hasVideo()) && (!localAVGameUserInfo.mBigVideo)) {
          ((AVGameBusinessCtrl)localObject).c();
        }
        i = 8;
      }
    }
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a())) {
      i = 8;
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView;
    if ((localObject != null) && (((AutoBgImageView)localObject).getVisibility() != i)) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(i);
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateCameraBtn, [");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("], visibility[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], from[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameControlUIImpl", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  private void c(int paramInt)
  {
    String str;
    if (QLog.isColorLevel())
    {
      str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showTransientTip msgType:=");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    switch (paramInt)
    {
    default: 
      str = "";
      break;
    case 7: 
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690271);
      break;
    case 6: 
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690199);
      break;
    case 5: 
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690192);
      break;
    case 4: 
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690205);
      break;
    case 3: 
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690281);
      break;
    case 2: 
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690282);
      break;
    case 1: 
      str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getApp().getString(2131690193);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(str);
  }
  
  private boolean c()
  {
    if (AVGameUtil.b() == 2) {
      return (!GameEngine.a().a()) || (GameEngine.a().e());
    }
    return false;
  }
  
  private void d(int paramInt)
  {
    if (paramInt == 1)
    {
      EngineData localEngineData = GameEngine.a().a();
      if (localEngineData.c() == 1)
      {
        Player localPlayer1 = localEngineData.a();
        Player localPlayer2 = localEngineData.b();
        if ((localPlayer1 != null) && (localPlayer2 != null) && (TextUtils.equals(localPlayer1.uin, localPlayer2.uin))) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (paramInt != 0)
        {
          if (localEngineData.a() == 1)
          {
            ReportController.b(null, "dc00898", "", "", "0X800B06E", "0X800B06E", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(null, "dc00898", "", "", "0X800B073", "0X800B073", 0, 0, "", "", "", "");
        }
      }
    }
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDrawable(2130838673);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAvGameMicroPhoneAnimatorHolder = new AvGameMicroPhoneAnimatorHolder((Activity)this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager = new AVGameNetWorkQualityManager(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363174));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363182));
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363181));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365212);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367452));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363325));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAvGameMicroPhoneAnimatorHolder.a());
    n();
    m();
    o();
    if (GameEngine.a().f())
    {
      int i = ViewUtils.a(120.0F);
      this.jdField_a_of_type_AndroidViewView.setTranslationX(i);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      boolean bool = GameEngine.a().g();
      if (!bool)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
      }
      AVGameNetWorkQualityManager localAVGameNetWorkQualityManager = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager;
      if ((localAVGameNetWorkQualityManager != null) && (!bool)) {
        localAVGameNetWorkQualityManager.a(false);
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
    else
    {
      h();
      if ((c()) || (GameEngine.a().a().a() != 0)) {
        a(8);
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.getLayoutParams().width = GameRoomViewLayoutParamsDef.i;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.getLayoutParams().height = GameRoomViewLayoutParamsDef.e;
    int i = GameRoomViewLayoutParamsDef.j;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setPadding(i, i, i, i);
    Object localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = GameRoomViewLayoutParamsDef.i;
    ((LinearLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.e;
    ((LinearLayout.LayoutParams)localObject).rightMargin = GameRoomViewLayoutParamsDef.g;
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setPadding(i, i, i, i);
    localObject = (LinearLayout.LayoutParams)this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = GameRoomViewLayoutParamsDef.i;
    ((LinearLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.e;
    ((LinearLayout.LayoutParams)localObject).rightMargin = GameRoomViewLayoutParamsDef.g;
    this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setPadding(i, i, i, i);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).rightMargin = GameRoomViewLayoutParamsDef.h;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = GameRoomViewLayoutParamsDef.f;
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).rightMargin = GameRoomViewLayoutParamsDef.f;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = GameRoomViewLayoutParamsDef.f;
    ((RelativeLayout.LayoutParams)localObject).width = GameRoomViewLayoutParamsDef.k;
    ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.e;
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager.d();
  }
  
  private void i()
  {
    this.jdField_b_of_type_Int = 0;
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  private void j()
  {
    if (!d())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onClick_Speak fast-click");
      }
      return;
    }
    AVGameBusinessCtrl localAVGameBusinessCtrl = AVGameBusinessCtrl.b();
    if (localAVGameBusinessCtrl != null)
    {
      int i = localAVGameBusinessCtrl.a();
      if (i == 2)
      {
        c(3);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onClick_Speak in AUDIO_ROUTE_BLUETOOTH status, not support close bluetooth");
        }
        return;
      }
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      AVGameHandler.a().a().post(new AVGameControlUIImpl.7(this, localAVGameBusinessCtrl, i));
    }
  }
  
  private void k()
  {
    if (!d())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onClick_Speak_WithNoAVRoom fast-click");
      }
      return;
    }
    AudioRouter localAudioRouter = (AudioRouter)GameEngine.a().a(SurvivalAssistManager.a);
    if (localAudioRouter == null) {
      return;
    }
    int i = localAudioRouter.a();
    if (i == 2)
    {
      c(3);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onClick_Speak_WithNoAVRoom in AUDIO_ROUTE_BLUETOOTH status, not support close bluetooth");
      }
      return;
    }
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    AVGameHandler.a().a().post(new AVGameControlUIImpl.8(this, localAudioRouter, i));
  }
  
  private void l()
  {
    Object localObject1 = AVGameBusinessCtrl.b().a();
    if (localObject1 != null)
    {
      boolean bool = ((AVGameSession)localObject1).e;
      AVGameBusinessCtrl.b().c(bool);
      n();
      int j = 1;
      int i;
      if (bool) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B03A", "0X800B03A", i, 0, "", "", "", "");
      if (!bool)
      {
        Object localObject2 = GameEngine.a().a();
        if (((EngineData)localObject2).c() == 1)
        {
          localObject1 = ((EngineData)localObject2).a();
          localObject2 = ((EngineData)localObject2).b();
          if ((localObject1 != null) && (localObject2 != null) && (TextUtils.equals(((Player)localObject1).uin, ((Player)localObject2).uin))) {
            i = j;
          } else {
            i = 0;
          }
          if (i != 0) {
            ReportController.b(null, "dc00898", "", "", "0X800B074", "0X800B074", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
  
  private void m()
  {
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().a();
    if (localAVGameSession != null)
    {
      AutoBgImageView localAutoBgImageView = this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView;
      if (localAutoBgImageView != null) {
        localAutoBgImageView.setSelected(localAVGameSession.a(1));
      }
    }
  }
  
  private void n()
  {
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().a();
    if (localAVGameSession != null)
    {
      this.jdField_b_of_type_Boolean = (localAVGameSession.e ^ true);
      if (!this.jdField_b_of_type_Boolean) {
        i();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(localAVGameSession.e ^ true);
      AutoBgImageView localAutoBgImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
      Drawable localDrawable;
      if (localAVGameSession.e) {
        localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      } else {
        localDrawable = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAvGameMicroPhoneAnimatorHolder.a();
      }
      localAutoBgImageView.setImageDrawable(localDrawable);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.d(localAVGameSession.e ^ true);
    }
  }
  
  private void o()
  {
    Object localObject = AVGameBusinessCtrl.b().a();
    if (localObject != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(((AVGameSession)localObject).d);
      return;
    }
    localObject = (AudioRouter)GameEngine.a().a(SurvivalAssistManager.a);
    if (localObject != null)
    {
      int i = ((AudioRouter)localObject).a();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(bool);
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
    IAVGameMediaPlayerCtrl localIAVGameMediaPlayerCtrl = AVGameBusinessCtrl.b().a();
    if (localIAVGameMediaPlayerCtrl != null)
    {
      localIAVGameMediaPlayerCtrl.a(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer);
      return;
    }
    if ((GameEngine.a().f()) && (!GameEngine.a().g()))
    {
      localIAVGameMediaPlayerCtrl = ((IVideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).getAVGameMediaPlayerCtrl();
      if (localIAVGameMediaPlayerCtrl != null) {
        localIAVGameMediaPlayerCtrl.a(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer);
      }
    }
  }
  
  public void a(int paramInt)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if ((localImageView != null) && (localImageView.getVisibility() != paramInt))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
      if ((paramInt != 0) && (paramInt != 4))
      {
        paramInt = GameRoomViewLayoutParamsDef.h;
        int i = GameRoomViewLayoutParamsDef.f;
        this.jdField_a_of_type_AndroidViewView.setTranslationX(paramInt - i);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setTranslationX(0.0F);
    }
  }
  
  void a(long paramLong, int paramInt, View paramView)
  {
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().a();
    if (localAVGameSession == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_Camera, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], session[");
      localStringBuilder.append(localAVGameSession);
      localStringBuilder.append("]");
      QLog.i("AVGameControlUIImpl", 2, localStringBuilder.toString());
    }
    if (a(paramLong, "android.permission.CAMERA", paramView, paramInt))
    {
      boolean bool3 = SecurityPolicyChecker.a().b();
      boolean bool2 = localAVGameSession.a(1);
      boolean bool1;
      if (paramInt == 2) {
        bool1 = false;
      } else if (paramInt == 3) {
        bool1 = true;
      } else {
        bool1 = bool2;
      }
      boolean bool4 = SecurityPolicyChecker.a().a(localAVGameSession.jdField_b_of_type_Long);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("onClick_Camera, seq[");
        paramView.append(paramLong);
        paramView.append("], from[");
        paramView.append(paramInt);
        paramView.append("], goOffStage");
        paramView.append(bool1);
        paramView.append("], hasLocalVideo[");
        paramView.append(bool2);
        paramView.append("], disableSmallPic[");
        paramView.append(bool3);
        paramView.append("], canOpenCamera[");
        paramView.append(bool4);
        paramView.append("], session[");
        paramView.append(localAVGameSession);
        paramView.append("]");
        QLog.i("AVGameControlUIImpl", 2, paramView.toString());
      }
      if (bool1)
      {
        if (!bool4)
        {
          paramView = this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView;
          if (paramView != null) {
            paramView.setVisibility(8);
          }
        }
        AVGameBusinessCtrl.b().c();
        d(paramInt);
        ReportController.b(null, "dc00898", "", "", "0X800B039", "0X800B039", 2, 0, "", "", "", "");
      }
      else
      {
        if (paramInt == 1)
        {
          AVGameQualityCameraReportUtil.a(1);
          ReportController.b(null, "dc00898", "", "", "0X800B039", "0X800B039", 1, 0, "", "", "", "");
        }
        else if (paramInt == 2)
        {
          AVGameQualityCameraReportUtil.a(2);
        }
        else if (paramInt == 4)
        {
          AVGameQualityCameraReportUtil.a(3);
        }
        if (bool4)
        {
          paramView = this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView;
          if ((paramView != null) && (paramView.getVisibility() != 0)) {
            this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
          }
          AVGameBusinessCtrl.b().b(paramInt);
        }
        else
        {
          paramView = this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView;
          if (paramView != null) {
            paramView.setVisibility(8);
          }
          QQToast.a(BaseApplicationImpl.getApplication(), 0, 2131690322, 1).a();
        }
      }
      m();
      return;
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    AVGameHandler.a().b().post(new AVGameControlUIImpl.5(this, paramInt, paramString2));
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return;
    }
    boolean bool = GameEngine.a().a().f();
    int i = 1;
    if ((bool) && (GameEngine.a().a() <= 1)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363182: 
      a(paramLong, 1, paramView);
      return;
    case 2131363181: 
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onClick QavPanel.ViewID.HAND_FREE ");
      if ((!GameEngine.a().f()) || (GameEngine.a().g())) {
        i = 0;
      }
      if (i != 0)
      {
        k();
        return;
      }
      j();
      return;
    }
    b(paramLong, paramView);
  }
  
  public void a(RectF paramRectF)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer != null) && (paramRectF != null))
    {
      int i = (int)paramRectF.left;
      int j = (int)paramRectF.top;
      int k = (int)paramRectF.right;
      int m = (int)paramRectF.bottom;
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a(new Rect(i, j, k, m));
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVideoDisplayUpdateWithNoAVRoom rectF:=");
    localStringBuilder.append(paramRectF);
    QLog.d(str, 2, localStringBuilder.toString());
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
    if (AVGameBusinessCtrl.b() == null) {
      return;
    }
    Object localObject1 = AVGameBusinessCtrl.b().a();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onPlayerBeginVideoChanged player[");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("], session is null.");
        QLog.i("AVGameControlUIImpl", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    this.jdField_a_of_type_Long = 0L;
    long l = AVGameUtil.a(paramString);
    SecurityPolicyChecker.a().a(paramString);
    ((AVGameSession)localObject1).a();
    boolean bool1;
    if (l != 0L) {
      bool1 = ((AVGameSession)localObject1).a(l, true);
    } else {
      bool1 = true;
    }
    Object localObject2;
    boolean bool2;
    if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a()))
    {
      if (TextUtils.equals(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount(), paramString))
      {
        if (!((AVGameSession)localObject1).a(1))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onPlayerBeginVideoChanged, go on state, session[");
            ((StringBuilder)localObject2).append(localObject1);
            ((StringBuilder)localObject2).append("]");
            QLog.i("AVGameControlUIImpl", 2, ((StringBuilder)localObject2).toString());
          }
          a(QQAudioHelper.b(), 2, this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView);
        }
        bool2 = true;
      }
      else if ((((AVGameSession)localObject1).g) && (((AVGameSession)localObject1).a(1)))
      {
        a(QQAudioHelper.b(), 3, this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView);
        bool2 = bool1;
      }
      else
      {
        bool2 = bool1;
        if (!SecurityPolicyChecker.a().a(((AVGameSession)localObject1).jdField_b_of_type_Long))
        {
          localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView;
          bool2 = bool1;
          if (localObject2 != null)
          {
            ((AutoBgImageView)localObject2).setVisibility(8);
            bool2 = bool1;
          }
        }
      }
      if (bool2) {
        c();
      } else {
        this.jdField_a_of_type_Long = l;
      }
    }
    else
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.i("AVGameControlUIImpl", 2, "onPlayerBeginVideoChanged should not click camera in match mode");
        bool2 = bool1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onPlayerBeginVideoChanged, uin[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject2).append("], ret[");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append("], player[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("], self[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount());
      ((StringBuilder)localObject2).append("], auto[");
      ((StringBuilder)localObject2).append(((AVGameSession)localObject1).g);
      ((StringBuilder)localObject2).append("]");
      QLog.i("AVGameControlUIImpl", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(List<MemberVideoDisplayInfo> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a(paramList);
    }
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
    if ((paramInt != 24) && (paramInt != 25)) {
      return false;
    }
    for (;;)
    {
      try
      {
        if ((AudioProcess.a()) && (AudioProcess.a().isPlayStarted()))
        {
          if (paramInt != 25) {
            break label254;
          }
          paramInt = -1;
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
          if (QLog.isColorLevel())
          {
            paramKeyEvent = new StringBuilder();
            paramKeyEvent.append("adjustStreamVolume. streamType = ");
            paramKeyEvent.append(0);
            paramKeyEvent.append(", maxVolume = ");
            paramKeyEvent.append(j);
            paramKeyEvent.append(", oldVolume = ");
            paramKeyEvent.append(i);
            paramKeyEvent.append(", newVolume = ");
            paramKeyEvent.append(paramInt);
            QLog.d("AVGameControlUIImpl", 2, paramKeyEvent.toString());
          }
          return true;
        }
      }
      catch (Exception paramKeyEvent)
      {
        QLog.e("AVGameControlUIImpl", 1, "adjustStreamVolume fail.", paramKeyEvent);
      }
      return false;
      label254:
      paramInt = 1;
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
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager;
    if (localObject != null) {
      ((AVGameNetWorkQualityManager)localObject).b();
    }
    localObject = AVGameBusinessCtrl.b().a();
    if (localObject != null)
    {
      ((IAVGameMediaPlayerCtrl)localObject).f();
    }
    else
    {
      localObject = ((IVideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).getAVGameMediaPlayerCtrl();
      if (localObject != null) {
        ((IAVGameMediaPlayerCtrl)localObject).f();
      }
    }
    if (SecurityPolicyChecker.a().a()) {
      b("onResume");
    }
  }
  
  void b(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.RECORD_AUDIO", paramView, 0)) {
      l();
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
      localObject = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager;
      if ((localObject != null) && (!bool)) {
        ((AVGameNetWorkQualityManager)localObject).a(false);
      }
      if ((!bool) && (!paramBoolean))
      {
        localObject = ((IVideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).getAVGameMediaPlayerCtrl();
        if (localObject != null) {
          ((IAVGameMediaPlayerCtrl)localObject).a(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer);
        }
      }
      if (!paramBoolean)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_c_of_type_ComTencentMobileqqWidgetAutoBgImageView.setSelected(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
      n();
      o();
      m();
      return;
    }
    if (c())
    {
      a(8);
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "start control animation");
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        int i = GameRoomViewLayoutParamsDef.h;
        int j = GameRoomViewLayoutParamsDef.f;
        localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationX", new float[] { 0.0F, i - j });
        ((ObjectAnimator)localObject).setDuration(250L);
        ((ObjectAnimator)localObject).start();
      }
    }
    else if (GameEngine.a().a().a() == 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "show begin btn");
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidViewView.setTranslationX(0.0F);
    }
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
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)localObject);
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUIImpl$CheckCameraTask = null;
    }
    localObject = AVGameBusinessCtrl.b().a();
    if (localObject != null)
    {
      ((IAVGameMediaPlayerCtrl)localObject).g();
      return;
    }
    localObject = ((IVideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).getAVGameMediaPlayerCtrl();
    if (localObject != null) {
      ((IAVGameMediaPlayerCtrl)localObject).g();
    }
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
    if (a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "initUI-->can not get AVGameActivity");
      }
      return;
    }
    g();
    AVGameCameraAssistant localAVGameCameraAssistant = AVGameBusinessCtrl.b().a();
    if (localAVGameCameraAssistant != null) {
      localAVGameCameraAssistant.a(this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$CameraEventListener);
    }
    if (GameEngine.a().f()) {
      c(true);
    }
  }
  
  public void d(long paramLong)
  {
    super.d(paramLong);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.o();
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager;
    if (localObject != null)
    {
      ((AVGameNetWorkQualityManager)localObject).c();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager = null;
    }
    localObject = AVGameBusinessCtrl.b();
    if (localObject != null)
    {
      AVGameCameraAssistant localAVGameCameraAssistant = ((AVGameBusinessCtrl)localObject).a();
      if (localAVGameCameraAssistant != null) {
        localAVGameCameraAssistant.b(this.jdField_a_of_type_ComTencentAvgameQavAVGameCameraAssistant$CameraEventListener);
      }
      ((AVGameBusinessCtrl)localObject).b(this.jdField_a_of_type_ComTencentAvgameCallbackAVGameUIEventCallback);
    }
    localObject = AVGameBusinessCtrl.b().a();
    if (localObject != null)
    {
      ((IAVGameMediaPlayerCtrl)localObject).b(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer);
      return;
    }
    localObject = ((IVideoRouter)GameEngine.a().a(SurvivalAssistManager.jdField_b_of_type_Int)).getAVGameMediaPlayerCtrl();
    if (localObject != null) {
      ((IAVGameMediaPlayerCtrl)localObject).b(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl
 * JD-Core Version:    0.7.0.1
 */