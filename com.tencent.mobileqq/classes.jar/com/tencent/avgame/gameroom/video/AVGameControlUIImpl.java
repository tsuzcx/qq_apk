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
  private final Handler A;
  private long B = -1L;
  private boolean C = false;
  private Runnable D = new AVGameControlUIImpl.1(this);
  private AVGameUIEventCallback E = new AVGameControlUIImpl.2(this);
  private AVGameCameraAssistant.CameraEventListener F = new AVGameControlUIImpl.3(this);
  private final SecurityPolicyChecker.CheckSecurityPolicyCallback G = new AVGameControlUIImpl.9(this);
  protected AutoBgImageView j;
  protected AutoBgImageView k;
  protected AutoBgImageView l;
  protected View m;
  protected ImageView n;
  protected AVGameNetWorkQualityManager o;
  protected long p = 0L;
  protected Drawable q;
  protected AvGameMicroPhoneAnimatorHolder r;
  public Integer s;
  public Integer t;
  public Integer u;
  private TextView v;
  private int w = 0;
  private ValueAnimator x;
  private volatile boolean y = false;
  private AVGameControlUIImpl.CheckCameraTask z = null;
  
  public AVGameControlUIImpl(AVGameAppInterface paramAVGameAppInterface, QBaseActivity paramQBaseActivity, ViewGroup paramViewGroup)
  {
    super(paramAVGameAppInterface, paramQBaseActivity, paramViewGroup);
    AVGameBusinessCtrl.b().a(this.E);
    this.A = AVGameHandler.a().c();
    SecurityPolicyChecker.a().a(this.G);
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      if ((localObject != null) && (!((AutoBgImageView)localObject).isShown())) {
        return;
      }
      int i1 = this.w;
      this.w = paramInt;
      if (this.w != i1)
      {
        localObject = this.x;
        int i;
        if ((localObject != null) && (((ValueAnimator)localObject).isRunning()))
        {
          paramInt = ((Integer)this.x.getAnimatedValue()).intValue();
          this.x.cancel();
          i = paramInt;
        }
        else
        {
          i = -1;
          paramInt = i1;
        }
        if (this.x == null)
        {
          this.x = new ValueAnimator();
          this.x.addUpdateListener(new AVGameControlUIImpl.4(this));
        }
        if (this.w > paramInt) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        localObject = this.x;
        long l1;
        if (i1 != 0) {
          l1 = 100L;
        } else {
          l1 = 200L;
        }
        ((ValueAnimator)localObject).setDuration(l1);
        localObject = this.x;
        i1 = i;
        if (i == -1) {
          i1 = paramInt;
        }
        ((ValueAnimator)localObject).setIntValues(new int[] { i1, this.w });
        this.x.start();
      }
    }
  }
  
  private void b(String paramString)
  {
    if (d()) {
      return;
    }
    Object localObject = AVGameBusinessCtrl.b();
    if (localObject == null) {
      return;
    }
    AVGameSession localAVGameSession = ((AVGameBusinessCtrl)localObject).j();
    if (localAVGameSession == null) {
      return;
    }
    boolean bool = SecurityPolicyChecker.a().c();
    int i1 = 0;
    int i = i1;
    if (bool)
    {
      AVGameUserInfo localAVGameUserInfo = localAVGameSession.a();
      if ((localAVGameUserInfo != null) && (localAVGameUserInfo.hasVideo()) && (localAVGameUserInfo.mBigVideo))
      {
        localAVGameSession.o = true;
        i = i1;
      }
      else
      {
        if ((localAVGameUserInfo != null) && (localAVGameUserInfo.hasVideo()) && (!localAVGameUserInfo.mBigVideo)) {
          ((AVGameBusinessCtrl)localObject).l();
        }
        i = 8;
      }
    }
    if ((this.C) || (this.i.t())) {
      i = 8;
    }
    localObject = this.k;
    if ((localObject != null) && (((AutoBgImageView)localObject).getVisibility() != i)) {
      this.k.setVisibility(i);
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
      str = this.a;
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
      str = this.g.getApp().getString(2131887182);
      break;
    case 6: 
      str = this.g.getApp().getString(2131887099);
      break;
    case 5: 
      str = this.g.getApp().getString(2131887092);
      break;
    case 4: 
      str = this.g.getApp().getString(2131887105);
      break;
    case 3: 
      str = this.g.getApp().getString(2131887192);
      break;
    case 2: 
      str = this.g.getApp().getString(2131887193);
      break;
    case 1: 
      str = this.g.getApp().getString(2131887093);
    }
    this.i.b(str);
  }
  
  private void d(int paramInt)
  {
    if (paramInt == 1)
    {
      EngineData localEngineData = GameEngine.a().s();
      if (localEngineData.o() == 1)
      {
        Player localPlayer1 = localEngineData.q();
        Player localPlayer2 = localEngineData.r();
        if ((localPlayer1 != null) && (localPlayer2 != null) && (TextUtils.equals(localPlayer1.uin, localPlayer2.uin))) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (paramInt != 0)
        {
          if (localEngineData.j() == 1)
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
    this.A.postDelayed(new AVGameControlUIImpl.6(this), 3000L);
  }
  
  private void k()
  {
    this.q = this.e.getResources().getDrawable(2130838861);
    this.r = new AvGameMicroPhoneAnimatorHolder((Activity)this.e.getContext());
    this.o = new AVGameNetWorkQualityManager(this.e);
    this.j = ((AutoBgImageView)this.e.findViewById(2131429048));
    this.k = ((AutoBgImageView)this.e.findViewById(2131429056));
    this.l = ((AutoBgImageView)this.e.findViewById(2131429055));
    this.m = this.e.findViewById(2131431378);
    this.n = ((ImageView)this.e.findViewById(2131433955));
    this.v = ((TextView)this.e.findViewById(2131429199));
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.j.setImageDrawable(this.r.a());
    t();
    s();
    u();
    if (GameEngine.a().A())
    {
      int i = ViewUtils.dip2px(120.0F);
      this.m.setTranslationX(i);
      this.n.setVisibility(8);
      boolean bool = GameEngine.a().B();
      if (!bool)
      {
        this.k.setVisibility(8);
        this.j.setVisibility(8);
      }
      AVGameNetWorkQualityManager localAVGameNetWorkQualityManager = this.o;
      if ((localAVGameNetWorkQualityManager != null) && (!bool)) {
        localAVGameNetWorkQualityManager.a(false);
      }
      if (GameEngine.a().s().j() == 0)
      {
        this.k.setSelected(false);
        this.j.setSelected(false);
        this.l.setSelected(false);
        this.j.setImageDrawable(this.q);
      }
      if (SecurityPolicyChecker.a().c()) {
        this.k.setVisibility(8);
      }
    }
    else
    {
      l();
      if ((m()) || (GameEngine.a().s().j() != 0)) {
        a(8);
      }
    }
  }
  
  private void l()
  {
    this.j.getLayoutParams().width = GameRoomViewLayoutParamsDef.i;
    this.j.getLayoutParams().height = GameRoomViewLayoutParamsDef.e;
    int i = GameRoomViewLayoutParamsDef.j;
    this.j.setPadding(i, i, i, i);
    Object localObject = (LinearLayout.LayoutParams)this.k.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = GameRoomViewLayoutParamsDef.i;
    ((LinearLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.e;
    ((LinearLayout.LayoutParams)localObject).rightMargin = GameRoomViewLayoutParamsDef.g;
    this.k.setPadding(i, i, i, i);
    localObject = (LinearLayout.LayoutParams)this.l.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = GameRoomViewLayoutParamsDef.i;
    ((LinearLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.e;
    ((LinearLayout.LayoutParams)localObject).rightMargin = GameRoomViewLayoutParamsDef.g;
    this.l.setPadding(i, i, i, i);
    localObject = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).rightMargin = GameRoomViewLayoutParamsDef.h;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = GameRoomViewLayoutParamsDef.f;
    localObject = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).rightMargin = GameRoomViewLayoutParamsDef.f;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = GameRoomViewLayoutParamsDef.f;
    ((RelativeLayout.LayoutParams)localObject).width = GameRoomViewLayoutParamsDef.k;
    ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.e;
    this.o.e();
  }
  
  private boolean m()
  {
    if (AVGameUtil.b() == 2) {
      return (!GameEngine.a().d()) || (GameEngine.a().v());
    }
    return false;
  }
  
  private void n()
  {
    this.w = 0;
    ValueAnimator localValueAnimator = this.x;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.x = null;
    }
  }
  
  private boolean o()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.B > 500L)
    {
      this.B = l1;
      return true;
    }
    return false;
  }
  
  private void p()
  {
    if (!o())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "onClick_Speak fast-click");
      }
      return;
    }
    AVGameBusinessCtrl localAVGameBusinessCtrl = AVGameBusinessCtrl.b();
    if (localAVGameBusinessCtrl != null)
    {
      int i = localAVGameBusinessCtrl.i();
      if (i == 2)
      {
        c(3);
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "onClick_Speak in AUDIO_ROUTE_BLUETOOTH status, not support close bluetooth");
        }
        return;
      }
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      AVGameHandler.a().b().post(new AVGameControlUIImpl.7(this, localAVGameBusinessCtrl, i));
    }
  }
  
  private void q()
  {
    if (!o())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "onClick_Speak_WithNoAVRoom fast-click");
      }
      return;
    }
    AudioRouter localAudioRouter = (AudioRouter)GameEngine.a().e(SurvivalAssistManager.a);
    if (localAudioRouter == null) {
      return;
    }
    int i = localAudioRouter.d();
    if (i == 2)
    {
      c(3);
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "onClick_Speak_WithNoAVRoom in AUDIO_ROUTE_BLUETOOTH status, not support close bluetooth");
      }
      return;
    }
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    AVGameHandler.a().b().post(new AVGameControlUIImpl.8(this, localAudioRouter, i));
  }
  
  private void r()
  {
    Object localObject1 = AVGameBusinessCtrl.b().j();
    if (localObject1 != null)
    {
      boolean bool = ((AVGameSession)localObject1).i;
      AVGameBusinessCtrl.b().c(bool);
      t();
      int i1 = 1;
      int i;
      if (bool) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B03A", "0X800B03A", i, 0, "", "", "", "");
      if (!bool)
      {
        Object localObject2 = GameEngine.a().s();
        if (((EngineData)localObject2).o() == 1)
        {
          localObject1 = ((EngineData)localObject2).q();
          localObject2 = ((EngineData)localObject2).r();
          if ((localObject1 != null) && (localObject2 != null) && (TextUtils.equals(((Player)localObject1).uin, ((Player)localObject2).uin))) {
            i = i1;
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
  
  private void s()
  {
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().j();
    if (localAVGameSession != null)
    {
      AutoBgImageView localAutoBgImageView = this.k;
      if (localAutoBgImageView != null) {
        localAutoBgImageView.setSelected(localAVGameSession.c(1));
      }
    }
  }
  
  private void t()
  {
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().j();
    if (localAVGameSession != null)
    {
      this.y = (localAVGameSession.i ^ true);
      if (!this.y) {
        n();
      }
      this.j.setSelected(localAVGameSession.i ^ true);
      AutoBgImageView localAutoBgImageView = this.j;
      Drawable localDrawable;
      if (localAVGameSession.i) {
        localDrawable = this.q;
      } else {
        localDrawable = this.r.a();
      }
      localAutoBgImageView.setImageDrawable(localDrawable);
      this.i.d(localAVGameSession.i ^ true);
    }
  }
  
  private void u()
  {
    Object localObject = AVGameBusinessCtrl.b().j();
    if (localObject != null)
    {
      this.l.setSelected(((AVGameSession)localObject).h);
      return;
    }
    localObject = (AudioRouter)GameEngine.a().e(SurvivalAssistManager.a);
    if (localObject != null)
    {
      int i = ((AudioRouter)localObject).d();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.l.setSelected(bool);
    }
  }
  
  public void a(int paramInt)
  {
    ImageView localImageView = this.n;
    if ((localImageView != null) && (localImageView.getVisibility() != paramInt))
    {
      this.n.setVisibility(paramInt);
      if ((paramInt != 0) && (paramInt != 4))
      {
        paramInt = GameRoomViewLayoutParamsDef.h;
        int i = GameRoomViewLayoutParamsDef.f;
        this.m.setTranslationX(paramInt - i);
        return;
      }
      this.m.setTranslationX(0.0F);
    }
  }
  
  void a(long paramLong, int paramInt, View paramView)
  {
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().j();
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
      boolean bool3 = SecurityPolicyChecker.a().c();
      boolean bool2 = localAVGameSession.c(1);
      boolean bool1;
      if (paramInt == 2) {
        bool1 = false;
      } else if (paramInt == 3) {
        bool1 = true;
      } else {
        bool1 = bool2;
      }
      boolean bool4 = SecurityPolicyChecker.a().a(localAVGameSession.l);
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
          paramView = this.k;
          if (paramView != null) {
            paramView.setVisibility(8);
          }
        }
        AVGameBusinessCtrl.b().l();
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
          paramView = this.k;
          if ((paramView != null) && (paramView.getVisibility() != 0)) {
            this.k.setVisibility(0);
          }
          AVGameBusinessCtrl.b().b(paramInt);
        }
        else
        {
          paramView = this.k;
          if (paramView != null) {
            paramView.setVisibility(8);
          }
          QQToast.makeText(BaseApplicationImpl.getApplication(), 0, 2131887233, 1).show();
        }
      }
      s();
      return;
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    AVGameHandler.a().c().post(new AVGameControlUIImpl.5(this, paramInt, paramString2));
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.c == null) {
      return;
    }
    boolean bool = GameEngine.a().s().M();
    int i = 1;
    if ((bool) && (GameEngine.a().e() <= 1)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131429056: 
      a(paramLong, 1, paramView);
      return;
    case 2131429055: 
      QLog.d(this.a, 1, "onClick QavPanel.ViewID.HAND_FREE ");
      if ((!GameEngine.a().A()) || (GameEngine.a().B())) {
        i = 0;
      }
      if (i != 0)
      {
        q();
        return;
      }
      p();
      return;
    }
    b(paramLong, paramView);
  }
  
  public void a(RectF paramRectF)
  {
    if ((this.h != null) && (paramRectF != null))
    {
      int i = (int)paramRectF.left;
      int i1 = (int)paramRectF.top;
      int i2 = (int)paramRectF.right;
      int i3 = (int)paramRectF.bottom;
      this.h.a(new Rect(i, i1, i2, i3));
      return;
    }
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVideoDisplayUpdateWithNoAVRoom rectF:=");
    localStringBuilder.append(paramRectF);
    QLog.d(str, 2, localStringBuilder.toString());
  }
  
  public void a(EngineData paramEngineData)
  {
    paramEngineData = paramEngineData.e();
    if ((paramEngineData != null) && ((paramEngineData.matchStatus == 1) || (paramEngineData.opened_match)))
    {
      QLog.d(this.a, 1, "refresh hideCameraButton");
      this.C = true;
      i();
    }
  }
  
  public void a(String paramString)
  {
    if (AVGameBusinessCtrl.b() == null) {
      return;
    }
    Object localObject1 = AVGameBusinessCtrl.b().j();
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
    this.p = 0L;
    long l1 = AVGameUtil.b(paramString);
    SecurityPolicyChecker.a().a(paramString);
    ((AVGameSession)localObject1).b();
    boolean bool1;
    if (l1 != 0L) {
      bool1 = ((AVGameSession)localObject1).a(l1, true);
    } else {
      bool1 = true;
    }
    Object localObject2;
    boolean bool2;
    if ((!this.C) && (!this.i.t()))
    {
      if (TextUtils.equals(this.g.getAccount(), paramString))
      {
        if (!((AVGameSession)localObject1).c(1))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onPlayerBeginVideoChanged, go on state, session[");
            ((StringBuilder)localObject2).append(localObject1);
            ((StringBuilder)localObject2).append("]");
            QLog.i("AVGameControlUIImpl", 2, ((StringBuilder)localObject2).toString());
          }
          a(QQAudioHelper.d(), 2, this.k);
        }
        bool2 = true;
      }
      else if ((((AVGameSession)localObject1).o) && (((AVGameSession)localObject1).c(1)))
      {
        a(QQAudioHelper.d(), 3, this.k);
        bool2 = bool1;
      }
      else
      {
        bool2 = bool1;
        if (!SecurityPolicyChecker.a().a(((AVGameSession)localObject1).l))
        {
          localObject2 = this.k;
          bool2 = bool1;
          if (localObject2 != null)
          {
            ((AutoBgImageView)localObject2).setVisibility(8);
            bool2 = bool1;
          }
        }
      }
      if (bool2) {
        e();
      } else {
        this.p = l1;
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
      ((StringBuilder)localObject2).append(this.p);
      ((StringBuilder)localObject2).append("], ret[");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append("], player[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("], self[");
      ((StringBuilder)localObject2).append(this.g.getAccount());
      ((StringBuilder)localObject2).append("], auto[");
      ((StringBuilder)localObject2).append(((AVGameSession)localObject1).o);
      ((StringBuilder)localObject2).append("]");
      QLog.i("AVGameControlUIImpl", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(List<MemberVideoDisplayInfo> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    if (this.h != null) {
      this.h.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.h != null) {
      this.h.c(paramBoolean);
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
        if ((AudioProcess.a()) && (AudioProcess.b().isPlayStarted()))
        {
          if (paramInt != 25) {
            break label256;
          }
          paramInt = -1;
          paramKeyEvent = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
          int i = paramKeyEvent.getStreamVolume(0);
          if (this.s == null) {
            this.s = Integer.valueOf(i);
          }
          int i1 = paramKeyEvent.getStreamMaxVolume(0);
          if (this.u == null) {
            this.u = Integer.valueOf(i1);
          }
          paramKeyEvent.adjustStreamVolume(0, paramInt, 1);
          paramInt = paramKeyEvent.getStreamVolume(0);
          this.t = Integer.valueOf(paramInt);
          paramKeyEvent = AVGameBusinessCtrl.b().n();
          if (paramKeyEvent != null) {
            paramKeyEvent.a(this.s.intValue(), this.u.intValue(), this.t.intValue());
          }
          if (QLog.isColorLevel())
          {
            paramKeyEvent = new StringBuilder();
            paramKeyEvent.append("adjustStreamVolume. streamType = ");
            paramKeyEvent.append(0);
            paramKeyEvent.append(", maxVolume = ");
            paramKeyEvent.append(i1);
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
      label256:
      paramInt = 1;
    }
  }
  
  public void b()
  {
    super.b();
    f();
    this.h.z();
    IAVGameMediaPlayerCtrl localIAVGameMediaPlayerCtrl = AVGameBusinessCtrl.b().n();
    if (localIAVGameMediaPlayerCtrl != null)
    {
      localIAVGameMediaPlayerCtrl.a(this.h);
      return;
    }
    if ((GameEngine.a().A()) && (!GameEngine.a().B()))
    {
      localIAVGameMediaPlayerCtrl = ((IVideoRouter)GameEngine.a().e(SurvivalAssistManager.b)).getAVGameMediaPlayerCtrl();
      if (localIAVGameMediaPlayerCtrl != null) {
        localIAVGameMediaPlayerCtrl.a(this.h);
      }
    }
  }
  
  public void b(long paramLong)
  {
    super.b(paramLong);
    this.h.B();
    if (this.z == null) {
      this.z = new AVGameControlUIImpl.CheckCameraTask();
    }
    this.A.post(this.z);
    Object localObject = this.o;
    if (localObject != null) {
      ((AVGameNetWorkQualityManager)localObject).c();
    }
    localObject = AVGameBusinessCtrl.b().n();
    if (localObject != null)
    {
      ((IAVGameMediaPlayerCtrl)localObject).i();
    }
    else
    {
      localObject = ((IVideoRouter)GameEngine.a().e(SurvivalAssistManager.b)).getAVGameMediaPlayerCtrl();
      if (localObject != null) {
        ((IAVGameMediaPlayerCtrl)localObject).i();
      }
    }
    if (SecurityPolicyChecker.a().b()) {
      b("onResume");
    }
  }
  
  void b(long paramLong, View paramView)
  {
    if (a(paramLong, "android.permission.RECORD_AUDIO", paramView, 0)) {
      r();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject;
    if (GameEngine.a().A())
    {
      boolean bool = GameEngine.a().B();
      if (!bool)
      {
        this.k.setVisibility(8);
        this.j.setVisibility(8);
      }
      localObject = this.o;
      if ((localObject != null) && (!bool)) {
        ((AVGameNetWorkQualityManager)localObject).a(false);
      }
      if ((!bool) && (!paramBoolean))
      {
        localObject = ((IVideoRouter)GameEngine.a().e(SurvivalAssistManager.b)).getAVGameMediaPlayerCtrl();
        if (localObject != null) {
          ((IAVGameMediaPlayerCtrl)localObject).a(this.h);
        }
      }
      if (!paramBoolean)
      {
        this.k.setSelected(false);
        this.j.setSelected(false);
        this.l.setSelected(false);
        this.j.setImageDrawable(this.q);
        return;
      }
      t();
      u();
      s();
      return;
    }
    if (m())
    {
      a(8);
      return;
    }
    if (paramBoolean)
    {
      if (this.n.getVisibility() == 0)
      {
        QLog.d(this.a, 1, "start control animation");
        this.n.setVisibility(8);
        int i = GameRoomViewLayoutParamsDef.h;
        int i1 = GameRoomViewLayoutParamsDef.f;
        localObject = ObjectAnimator.ofFloat(this.m, "translationX", new float[] { 0.0F, i - i1 });
        ((ObjectAnimator)localObject).setDuration(250L);
        ((ObjectAnimator)localObject).start();
      }
    }
    else if (GameEngine.a().s().j() == 0)
    {
      if (this.n.getVisibility() != 0)
      {
        QLog.d(this.a, 1, "show begin btn");
        this.n.setVisibility(0);
      }
      this.m.setTranslationX(0.0F);
    }
  }
  
  public void c(long paramLong)
  {
    super.c(paramLong);
    this.h.C();
    g();
    Object localObject = this.z;
    if (localObject != null)
    {
      this.A.removeCallbacks((Runnable)localObject);
      this.z = null;
    }
    localObject = AVGameBusinessCtrl.b().n();
    if (localObject != null)
    {
      ((IAVGameMediaPlayerCtrl)localObject).j();
      return;
    }
    localObject = ((IVideoRouter)GameEngine.a().e(SurvivalAssistManager.b)).getAVGameMediaPlayerCtrl();
    if (localObject != null) {
      ((IAVGameMediaPlayerCtrl)localObject).j();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.d(this.a, 1, "refresh isMatching hideCameraButton");
      this.C = true;
      i();
    }
  }
  
  public void d(long paramLong)
  {
    super.d(paramLong);
    this.h.D();
    Object localObject = this.o;
    if (localObject != null)
    {
      ((AVGameNetWorkQualityManager)localObject).d();
      this.o = null;
    }
    localObject = AVGameBusinessCtrl.b();
    if (localObject != null)
    {
      AVGameCameraAssistant localAVGameCameraAssistant = ((AVGameBusinessCtrl)localObject).m();
      if (localAVGameCameraAssistant != null) {
        localAVGameCameraAssistant.b(this.F);
      }
      ((AVGameBusinessCtrl)localObject).b(this.E);
    }
    localObject = AVGameBusinessCtrl.b().n();
    if (localObject != null)
    {
      ((IAVGameMediaPlayerCtrl)localObject).b(this.h);
      return;
    }
    localObject = ((IVideoRouter)GameEngine.a().e(SurvivalAssistManager.b)).getAVGameMediaPlayerCtrl();
    if (localObject != null) {
      ((IAVGameMediaPlayerCtrl)localObject).b(this.h);
    }
  }
  
  public void e()
  {
    AVGameHandler.a().c().removeCallbacks(this.D);
    AVGameHandler.a().c().postDelayed(this.D, 1000L);
  }
  
  protected void f()
  {
    if (a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.a, 2, "initUI-->can not get AVGameActivity");
      }
      return;
    }
    k();
    AVGameCameraAssistant localAVGameCameraAssistant = AVGameBusinessCtrl.b().m();
    if (localAVGameCameraAssistant != null) {
      localAVGameCameraAssistant.a(this.F);
    }
    if (GameEngine.a().A()) {
      c(true);
    }
  }
  
  public void g()
  {
    AVGameHandler.a().c().removeCallbacks(this.D);
    QavSDK.a().c().f();
  }
  
  public ImageView h()
  {
    return this.n;
  }
  
  public void i()
  {
    if (this.k.isSelected()) {
      this.k.callOnClick();
    }
    this.k.setVisibility(8);
    GameEngine.a().s().e().opened_match = true;
  }
  
  public boolean j()
  {
    return this.k.getVisibility() != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl
 * JD-Core Version:    0.7.0.1
 */