package com.tencent.avgame.gameroom.stage;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.AnswerInfo;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.festivalstage.questionoption.IQuestionOptionPresenter;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsPresenterImpl;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.avgame.gameroom.seat.ISeatPresenter;
import com.tencent.avgame.gameroom.stage.festivalstage.FestvialStageView;
import com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStagePresenter;
import com.tencent.avgame.qav.audio.AvGameMusicPlayer;
import com.tencent.avgame.qav.audio.AvGameSysMusicPlayer;
import com.tencent.avgame.report.CJSurvivalReporterUtil;
import com.tencent.avgame.util.ContactUtils;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class StagePresenterImp
  implements IStagePresenter
{
  protected IStageView a;
  protected IGameRoomPresenter b;
  protected IGameStagePresenter c;
  protected int d = 0;
  protected IGameStagePresenter e;
  protected IGameStagePresenter f;
  protected IGameStagePresenter g;
  protected IGameStagePresenter h;
  protected IGameStagePresenter i;
  protected IQuestionOptionPresenter j;
  protected EngineData k;
  Runnable l = new StagePresenterImp.1(this);
  Runnable m = new StagePresenterImp.2(this);
  private Handler n = new Handler(Looper.getMainLooper());
  
  public StagePresenterImp(IStageView paramIStageView)
  {
    this.a = paramIStageView;
  }
  
  private void a(int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      localObject = this.e;
      if (localObject != null) {
        ((IGameStagePresenter)localObject).a(false);
      }
    }
    else if (paramInt == 2)
    {
      localObject = this.g;
      if (localObject != null) {
        ((IGameStagePresenter)localObject).a(false);
      }
    }
    else if (paramInt == 3)
    {
      localObject = this.f;
      if (localObject != null) {
        ((IGameStagePresenter)localObject).a(false);
      }
    }
    else if (paramInt == 4)
    {
      localObject = this.i;
      if (localObject != null) {
        ((IGameStagePresenter)localObject).a(false);
      }
    }
    else if (paramInt == 5)
    {
      localObject = this.h;
      if (localObject != null) {
        ((IGameStagePresenter)localObject).a(false);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideLastGameStagePresenter gameType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("StagePresenterImp", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 0) && (paramInt2 != 0);
  }
  
  private boolean f(EngineData paramEngineData)
  {
    EngineData localEngineData = this.k;
    return (localEngineData != null) && (localEngineData.j() == 4) && (this.k.s().a(paramEngineData.s()));
  }
  
  private boolean g(EngineData paramEngineData)
  {
    EngineData localEngineData = this.k;
    return (localEngineData != null) && (localEngineData.j() == 3) && (this.k.s().a(paramEngineData.s()));
  }
  
  private boolean h(EngineData paramEngineData)
  {
    EngineData localEngineData = this.k;
    return (localEngineData != null) && (localEngineData.j() == 2) && (this.k.s().a(paramEngineData.s()));
  }
  
  private boolean i(EngineData paramEngineData)
  {
    EngineData localEngineData = this.k;
    return (localEngineData != null) && (localEngineData.e().owner != paramEngineData.e().owner) && (GameEngine.a().d());
  }
  
  private boolean j()
  {
    EngineData localEngineData = this.k;
    return (localEngineData != null) && (localEngineData.j() == 10);
  }
  
  private boolean j(EngineData paramEngineData)
  {
    EngineData localEngineData = this.k;
    return (localEngineData != null) && (localEngineData.j() == 1) && (this.k.h().b.uin.equals(paramEngineData.h().b.uin));
  }
  
  private void k(EngineData paramEngineData)
  {
    if (paramEngineData.o() == 1) {
      this.c = this.e;
    } else if (paramEngineData.o() == 2) {
      this.c = this.g;
    } else if (paramEngineData.o() == 3) {
      this.c = this.f;
    } else if (paramEngineData.o() == 4) {
      this.c = this.i;
    } else if (paramEngineData.o() == 5) {
      this.c = this.h;
    }
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("updateCurGameStagePresenter curGameStagePresenter = ");
      paramEngineData.append(this.c);
      QLog.d("StagePresenterImp", 2, paramEngineData.toString());
    }
  }
  
  private void l(EngineData paramEngineData)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGameStart buff = ");
      ((StringBuilder)localObject).append(paramEngineData.s().g()[0]);
      ((StringBuilder)localObject).append(paramEngineData.s().g()[1]);
      ((StringBuilder)localObject).append(paramEngineData.s().g()[2]);
      QLog.d("StagePresenterImp", 2, ((StringBuilder)localObject).toString());
    }
    d();
    m(paramEngineData);
    if ((this.c.b()) && (p(paramEngineData)))
    {
      l1 = Long.parseLong(GameEngine.a().f().getAccount());
      localObject = this.b.d().a(l1);
      this.b.e().b((RectF)localObject);
    }
    long l1 = paramEngineData.h().f.d * 1000 - paramEngineData.h().n();
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("handleGameStart delayMs = ");
      paramEngineData.append(l1);
      QLog.d("StagePresenterImp", 2, paramEngineData.toString());
    }
    this.n.removeCallbacks(this.l);
    this.n.postDelayed(this.l, l1);
  }
  
  private void m(EngineData paramEngineData)
  {
    this.b.e().a();
    boolean bool = p(paramEngineData);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUIForGamePrepare isPlayerSelf = ");
      localStringBuilder.append(bool);
      QLog.d("StagePresenterImp", 2, localStringBuilder.toString());
    }
    a(this.c.b(bool), paramEngineData.h().f.d * 1000, paramEngineData.h().n());
    this.c.a(paramEngineData);
    b(this.c.a(this.b.m(), paramEngineData));
  }
  
  private void n(EngineData paramEngineData)
  {
    boolean bool = p(paramEngineData);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateStageUIForRealStart isPlayerSelf = ");
      localStringBuilder.append(bool);
      QLog.d("StagePresenterImp", 2, localStringBuilder.toString());
    }
    this.a.c();
    this.c.b(paramEngineData);
    GameEngine.a().j(paramEngineData);
    if (paramEngineData.N())
    {
      int i1;
      if (paramEngineData.O()) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ReportController.b(null, "dc00898", "", "", "survival_subject", "survival_subject", i1, 0, String.valueOf(paramEngineData.h().f.a), String.valueOf(paramEngineData.Y()), CJSurvivalReporterUtil.a().b(paramEngineData), String.valueOf(paramEngineData.Q()));
    }
    a(this.c.a(this.b.m(), bool, GameEngine.a().s().e().opened_match));
    if ((this.c.b()) && (!bool))
    {
      long l1 = Long.parseLong(paramEngineData.h().b.uin);
      paramEngineData = this.b.d().a(l1);
      this.b.e().a(paramEngineData);
    }
  }
  
  private void o(EngineData paramEngineData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSwitchTopic ,topic = ");
      localStringBuilder.append(paramEngineData.s().e());
      localStringBuilder.append(" buff = ");
      localStringBuilder.append(paramEngineData.s().g()[0]);
      localStringBuilder.append(paramEngineData.s().g()[1]);
      localStringBuilder.append(paramEngineData.s().g()[2]);
      QLog.d("StagePresenterImp", 2, localStringBuilder.toString());
    }
    this.a.c();
    this.c.c(paramEngineData);
    GameEngine.a().j(paramEngineData);
    if (paramEngineData.N())
    {
      int i1;
      if (paramEngineData.O()) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ReportController.b(null, "dc00898", "", "", "survival_subject", "survival_subject", i1, 0, String.valueOf(paramEngineData.h().f.a), String.valueOf(paramEngineData.Y()), CJSurvivalReporterUtil.a().b(paramEngineData), String.valueOf(paramEngineData.Q()));
    }
    if (paramEngineData.f(GameEngine.a().f().getAccount())) {
      this.b.g().b(this.a.getTopicWrapperView());
    }
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.b().updateRecogTxt(paramEngineData.s().d());
    }
  }
  
  private boolean p(EngineData paramEngineData)
  {
    return GameEngine.a().f().getAccount().equals(paramEngineData.h().b.uin);
  }
  
  public IGameRoomPresenter a()
  {
    return this.b;
  }
  
  public void a(ImageView paramImageView, long paramLong1, long paramLong2)
  {
    this.a.a(paramImageView, paramLong1, paramLong2);
  }
  
  public void a(EngineData paramEngineData)
  {
    Object localObject = this.a;
    if (((localObject instanceof FestvialStageView)) && (!((FestvialStageView)localObject).f())) {
      return;
    }
    this.a.a(paramEngineData);
    this.a.b(paramEngineData);
    k(paramEngineData);
    int i1 = paramEngineData.o();
    int i2 = paramEngineData.j();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refresh gameType = ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(",gameStatus = ");
      ((StringBuilder)localObject).append(i2);
      QLog.d("StagePresenterImp", 2, ((StringBuilder)localObject).toString());
    }
    if (this.c == null)
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("refresh return for null presenter,gameType = ");
      paramEngineData.append(i1);
      paramEngineData.append(",gameStatus = ");
      paramEngineData.append(i2);
      QLog.d("StagePresenterImp", 1, paramEngineData.toString());
      return;
    }
    if (!a(i1, i2))
    {
      a(false);
      this.k = paramEngineData.w();
      return;
    }
    int i3 = this.d;
    if ((i3 != 0) && (i3 != i1)) {
      a(i3);
    }
    a(true);
    this.d = i1;
    if (i2 != 1)
    {
      if (i2 != 2)
      {
        if (i2 != 3)
        {
          if (i2 != 4)
          {
            if ((i2 == 10) && (!j())) {
              d(paramEngineData);
            }
          }
          else if ((!f(paramEngineData)) || (!GameEngine.a().C())) {
            e(paramEngineData);
          }
        }
        else if ((g(paramEngineData)) && (GameEngine.a().C()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("StagePresenterImp", 2, "isSameAnswerRight and break.");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("StagePresenterImp", 2, "refresh handleAnswerRight.");
          }
          localObject = paramEngineData.h().a;
          if ((paramEngineData.h().i == 0) && (localObject != null) && ((localObject instanceof TopicBase)))
          {
            localObject = (TopicBase)localObject;
            if (((TopicBase)localObject).p != 0)
            {
              a(paramEngineData, ((TopicBase)localObject).p, paramEngineData.h().l);
              break label587;
            }
          }
          a(paramEngineData, paramEngineData.h().i, paramEngineData.h().l);
        }
      }
      else if (h(paramEngineData))
      {
        if (i(paramEngineData))
        {
          localObject = this.c;
          if ((localObject instanceof GuessPictureStagePresenter)) {
            ((IGameStagePresenter)localObject).a(GameEngine.a().d(), true);
          }
        }
      }
      else {
        o(paramEngineData);
      }
    }
    else if (!j(paramEngineData))
    {
      l(paramEngineData);
      if ((paramEngineData.Y() == 0) && (paramEngineData.N()))
      {
        if (paramEngineData.O()) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        ReportController.b(null, "dc00898", "", "", "survival_countdown", "survival_countdown", i1, 0, String.valueOf(paramEngineData.P()), "", String.valueOf(paramEngineData.R()), String.valueOf(paramEngineData.Q()));
      }
    }
    label587:
    if (c(paramEngineData))
    {
      i1 = QuestionOptionsPresenterImpl.b();
      o(paramEngineData);
      this.j.a(i1, paramEngineData.h().k);
    }
    this.k = paramEngineData.w();
  }
  
  public void a(EngineData paramEngineData, int paramInt1, int paramInt2)
  {
    if (!paramEngineData.d()) {
      return;
    }
    boolean bool = GameEngine.a().f().getAccount().equals(paramEngineData.h().e.uin);
    Object localObject;
    if ((paramEngineData.M()) && (!paramEngineData.O()))
    {
      if (!bool)
      {
        localObject = this.j;
        if (localObject != null) {
          ((IQuestionOptionPresenter)localObject).a(paramEngineData);
        }
        a(false, true);
      }
    }
    else
    {
      int i1 = paramEngineData.h().a(paramEngineData.h().e.uin);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleAnswerRight scoreThisTime = ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(", actorScoreThisTime = ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(", combo = ");
        ((StringBuilder)localObject).append(paramEngineData.h().j);
        QLog.d("StagePresenterImp", 2, ((StringBuilder)localObject).toString());
      }
      String str2 = paramEngineData.s().d();
      localObject = (UserInfoHandler)GameEngine.a().f().getBusinessHandler(HandlerFactory.b);
      Bitmap localBitmap = ((UserInfoHandler)localObject).a(String.valueOf(paramEngineData.h().e.uin), (byte)1);
      String str3 = paramEngineData.e().getNick(paramEngineData.h().e.uin);
      long l1 = paramEngineData.h().j;
      if ((paramEngineData.o() == 1) && (paramEngineData.r() != null)) {
        localObject = ((UserInfoHandler)localObject).a(paramEngineData.r().uin, (byte)1);
      } else {
        localObject = null;
      }
      if (!bool) {
        ReportController.b(null, "dc00898", "", "", "0X800B04C", "0X800B04C", paramEngineData.p(), 0, "", "", "", "");
      }
      int i2 = paramEngineData.p();
      String str1;
      if (bool) {
        str1 = "1";
      } else {
        str1 = "2";
      }
      ReportController.b(null, "dc00898", "", "", "0X800B04E", "0X800B04E", i2, 0, str1, "", String.valueOf(l1), "");
      if (QLog.isColorLevel()) {
        QLog.d("StagePresenterImp", 1, new Object[] { "[handleAnswerRight] survival: ", Boolean.valueOf(paramEngineData.M()), ", avRoom: ", Boolean.valueOf(paramEngineData.O()) });
      }
      this.b.e().a(str2, localBitmap, str3, paramInt1, i1, l1, (Bitmap)localObject, paramInt2, bool);
      AvGameMusicPlayer.b().a(paramEngineData.s(), "succeed");
      localObject = this.b.e().b();
      this.b.g().a((View)localObject, this.b.e().c(), true);
      h();
      this.n.removeCallbacks(this.m);
      this.n.postDelayed(this.m, paramEngineData.h().f.f * 1000);
    }
    this.c.d(paramEngineData);
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.b = paramIGameRoomPresenter;
  }
  
  public void a(IQuestionOptionPresenter paramIQuestionOptionPresenter)
  {
    this.j = paramIQuestionOptionPresenter;
  }
  
  public void a(IGameStagePresenter paramIGameStagePresenter)
  {
    this.e = paramIGameStagePresenter;
  }
  
  public void a(String paramString)
  {
    this.b.b(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = GameEngine.a().f().getAccount();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showTopicSwitchedTip switcherUin = ");
      localStringBuilder.append(paramString);
      QLog.d("StagePresenterImp", 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(str)))
    {
      if (paramInt == 1)
      {
        this.a.b("avgame_tips_switch_topic@2x.png");
        return;
      }
      if (paramInt == 2) {
        this.a.b("avgame_tips_host_switch_topic@2x.png");
      }
    }
  }
  
  public void a(String paramString, EngineData paramEngineData)
  {
    paramString = GameEngine.a().f().getAccount();
    boolean bool = paramString.equals(paramEngineData.h().d.uin);
    if ((this.c.b()) && (bool))
    {
      long l1 = Long.parseLong(paramString);
      paramString = this.b.d().a(l1);
      this.b.e().b(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowGameContent ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",curGameStagePresenter = ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("StagePresenterImp", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((IGameStagePresenter)localObject).a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.a.a(paramBoolean, paramLong1, paramLong2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("displayAnswerResult isSelf:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" isRight:");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("StagePresenterImp", 2, ((StringBuilder)localObject).toString());
    }
    this.b.d().b(paramBoolean1, paramBoolean2);
    if (!paramBoolean1) {
      return;
    }
    Object localObject = GameEngine.a().s();
    if (paramBoolean2)
    {
      this.b.d().a((EngineData)localObject);
      AvGameSysMusicPlayer.a().a(((EngineData)localObject).s(), "succeed");
      return;
    }
    AvGameSysMusicPlayer.a().a(((EngineData)localObject).s(), "failed");
  }
  
  public RectF b()
  {
    return this.a.getPlayingVideoDisplayRect();
  }
  
  public void b(EngineData paramEngineData)
  {
    IStageView localIStageView = this.a;
    if (((localIStageView instanceof FestvialStageView)) && (!((FestvialStageView)localIStageView).f())) {
      return;
    }
    this.a.b(paramEngineData);
  }
  
  public void b(IGameStagePresenter paramIGameStagePresenter)
  {
    this.f = paramIGameStagePresenter;
  }
  
  public void b(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void b(String paramString, EngineData paramEngineData)
  {
    if (paramEngineData.z())
    {
      if (p(paramEngineData))
      {
        a(this.b.m().getResources().getString(2131887178));
      }
      else
      {
        paramString = paramEngineData.h().b.nick;
        a(String.format(this.b.m().getResources().getString(2131887179), new Object[] { ContactUtils.a(paramString, 8.0F) }));
      }
      ReportController.b(null, "dc00898", "", "", "0X800B04B", "0X800B04B", paramEngineData.p(), 0, "", "", "", "");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "noDisplayAnswerResult");
    }
    this.b.d().a(paramBoolean);
  }
  
  public void c()
  {
    GameEngine.a().o();
  }
  
  public void c(IGameStagePresenter paramIGameStagePresenter)
  {
    this.g = paramIGameStagePresenter;
  }
  
  public boolean c(EngineData paramEngineData)
  {
    return (!paramEngineData.O()) && (this.k == null) && (paramEngineData.j() != 1);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "resetGameContent ");
    }
    IGameStagePresenter localIGameStagePresenter = this.c;
    if (localIGameStagePresenter != null) {
      localIGameStagePresenter.a(null);
    }
  }
  
  public void d(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameOver");
    }
    this.b.e().a();
    i();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 1, new Object[] { "[handleGameOver] survival: ", Boolean.valueOf(paramEngineData.M()), ", avRoom: ", Boolean.valueOf(paramEngineData.O()) });
    }
    if ((paramEngineData.M()) && (!paramEngineData.O())) {
      AvGameSysMusicPlayer.a().a(paramEngineData.s(), "over");
    } else {
      AvGameMusicPlayer.b().a(paramEngineData.s(), "over");
    }
    if (paramEngineData.f(GameEngine.a().f().getAccount())) {
      this.b.g().b();
    }
    this.b.g().e();
    this.c.f(paramEngineData);
  }
  
  public void d(IGameStagePresenter paramIGameStagePresenter)
  {
    this.i = paramIGameStagePresenter;
  }
  
  public Drawable e()
  {
    GameItem localGameItem = GameEngine.a().s().f();
    if ((localGameItem != null) && (!TextUtils.isEmpty(localGameItem.k))) {
      return URLDrawable.getDrawable(localGameItem.k);
    }
    return AvGameResDownloadUtil.a("avgame_questions_bg_110_height@2x.png");
  }
  
  public void e(EngineData paramEngineData)
  {
    boolean bool3 = paramEngineData.M();
    boolean bool2 = false;
    boolean bool1 = true;
    Object localObject;
    if ((bool3) && (!paramEngineData.O()))
    {
      if (paramEngineData.z > 0)
      {
        if ((paramEngineData.z & 0x1) > 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if ((0x2 & paramEngineData.z) > 0) {
          bool2 = true;
        }
        localObject = this.j;
        if (localObject != null) {
          ((IQuestionOptionPresenter)localObject).a(bool1, bool2);
        }
      }
      else if (paramEngineData.h().k != null)
      {
        if (paramEngineData.h().k.answer_result != 1) {
          bool1 = false;
        }
        localObject = this.j;
        if (localObject != null) {
          ((IQuestionOptionPresenter)localObject).a(paramEngineData);
        }
        a(false, bool1);
      }
    }
    else
    {
      localObject = paramEngineData.s().d();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAnswerTimeoutPush answer = ");
        localStringBuilder.append((String)localObject);
        QLog.d("StagePresenterImp", 2, localStringBuilder.toString());
      }
      ReportController.b(null, "dc00898", "", "", "0X800B04F", "0X800B04F", paramEngineData.p(), 0, "", "", "", "");
      this.b.e().a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("StagePresenterImp", 1, new Object[] { "[handleAnswerTimeout] survival: ", Boolean.valueOf(paramEngineData.M()), ", avRoom: ", Boolean.valueOf(paramEngineData.O()) });
      }
      if ((paramEngineData.M()) && (!paramEngineData.O())) {
        AvGameSysMusicPlayer.a().a(paramEngineData.s(), "failed");
      } else {
        AvGameMusicPlayer.b().a(paramEngineData.s(), "failed");
      }
      if ((!paramEngineData.N()) || (paramEngineData.O()))
      {
        localObject = this.b.e().b();
        this.b.g().a((View)localObject, this.b.e().c(), false);
      }
      h();
      this.n.removeCallbacks(this.m);
      this.n.postDelayed(this.m, paramEngineData.h().f.f * 1000);
    }
    this.c.e(paramEngineData);
  }
  
  public void e(IGameStagePresenter paramIGameStagePresenter)
  {
    this.h = paramIGameStagePresenter;
  }
  
  public Drawable f()
  {
    GameItem localGameItem = GameEngine.a().s().f();
    if ((localGameItem != null) && (!TextUtils.isEmpty(localGameItem.l))) {
      return URLDrawable.getDrawable(localGameItem.l);
    }
    return AvGameResDownloadUtil.a("avgame_questions_bg_130_height@2x.png");
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StagePresenterImp", 2, "destroy");
    }
    this.n.removeCallbacksAndMessages(null);
  }
  
  public void h()
  {
    if (GameEngine.a().s().o() == 2) {
      this.a.b();
    }
  }
  
  public void i()
  {
    if (GameEngine.a().A()) {
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.StagePresenterImp
 * JD-Core Version:    0.7.0.1
 */