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
import com.tencent.avgame.app.AVGameAppInterface;
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
import com.tencent.avgame.gamelogic.gameres.AvGameMusicPlayer;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
import com.tencent.avgame.gamelogic.gameres.AvGameSysMusicPlayer;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.avgame.gameroom.festivalstage.FestvialStageView;
import com.tencent.avgame.gameroom.festivalstage.questionoption.IQuestionOptionPresenter;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsPresenterImpl;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.avgame.gameroom.seat.ISeatPresenter;
import com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStagePresenter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class StagePresenterImp
  implements IStagePresenter
{
  protected int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  protected EngineData a;
  protected IGameRoomPresenter a;
  protected IQuestionOptionPresenter a;
  protected IGameStagePresenter a;
  protected IStageView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new StagePresenterImp.1(this);
  protected IGameStagePresenter b;
  Runnable b;
  protected IGameStagePresenter c;
  protected IGameStagePresenter d;
  protected IGameStagePresenter e;
  protected IGameStagePresenter f;
  
  public StagePresenterImp(IStageView paramIStageView)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangRunnable = new StagePresenterImp.2(this);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView = paramIStageView;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      if (this.jdField_b_of_type_ComTencentAvgameGameroomStageIGameStagePresenter != null) {
        this.jdField_b_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a(false);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StagePresenterImp", 2, "hideLastGameStagePresenter gameType = " + paramInt);
      }
      return;
      if (paramInt == 2)
      {
        if (this.d != null) {
          this.d.a(false);
        }
      }
      else if (paramInt == 3)
      {
        if (this.c != null) {
          this.c.a(false);
        }
      }
      else if (paramInt == 4)
      {
        if (this.f != null) {
          this.f.a(false);
        }
      }
      else if ((paramInt == 5) && (this.e != null)) {
        this.e.a(false);
      }
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a() == 10);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 0) && (paramInt2 != 0);
  }
  
  private boolean b(EngineData paramEngineData)
  {
    return (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a() == 4) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().a(paramEngineData.a()));
  }
  
  private boolean c(EngineData paramEngineData)
  {
    return (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a() == 3) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().a(paramEngineData.a()));
  }
  
  private boolean d(EngineData paramEngineData)
  {
    return (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a() == 2) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().a(paramEngineData.a()));
  }
  
  private void e(EngineData paramEngineData)
  {
    if (paramEngineData.c() == 1) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = this.jdField_b_of_type_ComTencentAvgameGameroomStageIGameStagePresenter;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StagePresenterImp", 2, "updateCurGameStagePresenter curGameStagePresenter = " + this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter);
      }
      return;
      if (paramEngineData.c() == 2) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = this.d;
      } else if (paramEngineData.c() == 3) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = this.c;
      } else if (paramEngineData.c() == 4) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = this.f;
      } else if (paramEngineData.c() == 5) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = this.e;
      }
    }
  }
  
  private boolean e(EngineData paramEngineData)
  {
    return (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().owner != paramEngineData.a().owner) && (GameEngine.a().a());
  }
  
  private void f(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameStart buff = " + paramEngineData.a().a()[0] + paramEngineData.a().a()[1] + paramEngineData.a().a()[2]);
    }
    b();
    g(paramEngineData);
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a()) && (g(paramEngineData)))
    {
      l = Long.parseLong(GameEngine.a().a().getAccount());
      RectF localRectF = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(l);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().b(localRectF);
    }
    long l = paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.d * 1000 - paramEngineData.a().d();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameStart delayMs = " + l);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
  }
  
  private boolean f(EngineData paramEngineData)
  {
    return (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a() == 1) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin.equals(paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin));
  }
  
  private void g(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a();
    boolean bool = g(paramEngineData);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "updateUIForGamePrepare isPlayerSelf = " + bool);
    }
    a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a(bool), paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.d * 1000, paramEngineData.a().d());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a(paramEngineData);
    b(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(), paramEngineData));
  }
  
  private boolean g(EngineData paramEngineData)
  {
    return GameEngine.a().a().getAccount().equals(paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
  }
  
  private void h(EngineData paramEngineData)
  {
    boolean bool = g(paramEngineData);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "updateStageUIForRealStart isPlayerSelf = " + bool);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.d();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.b(paramEngineData);
    GameEngine.a().j(paramEngineData);
    CJSurvivalFestivalReporter.a(4, 0, true);
    a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(), bool, GameEngine.a().a().a().opened_match));
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a()) && (!bool))
    {
      long l = Long.parseLong(paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
      paramEngineData = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(l);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(paramEngineData);
    }
  }
  
  private void i(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleSwitchTopic ,topic = " + paramEngineData.a().c() + " buff = " + paramEngineData.a().a()[0] + paramEngineData.a().a()[1] + paramEngineData.a().a()[2]);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.d();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.c(paramEngineData);
    GameEngine.a().j(paramEngineData);
    CJSurvivalFestivalReporter.a(4, 0, true);
    if (paramEngineData.d(GameEngine.a().a().getAccount())) {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().b(this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.a());
    }
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.a().a(paramEngineData.a().b());
    }
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.a();
  }
  
  public Drawable a()
  {
    GameItem localGameItem = GameEngine.a().a().a();
    if ((localGameItem == null) || (TextUtils.isEmpty(localGameItem.i))) {
      return AvGameResDownloadManager.a("avgame_questions_bg_110_height@2x.png");
    }
    return URLDrawable.getDrawable(localGameItem.i);
  }
  
  public IGameRoomPresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter;
  }
  
  public void a()
  {
    GameEngine.a().b();
  }
  
  public void a(ImageView paramImageView, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.a(paramImageView, paramLong1, paramLong2);
  }
  
  public void a(EngineData paramEngineData)
  {
    if (((this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView instanceof FestvialStageView)) && (!((FestvialStageView)this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView).a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.a(paramEngineData);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.b(paramEngineData);
    e(paramEngineData);
    int i = paramEngineData.c();
    int j = paramEngineData.a();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "refresh gameType = " + i + ",gameStatus = " + j);
    }
    if (this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter == null)
    {
      QLog.d("StagePresenterImp", 1, "refresh return for null presenter,gameType = " + i + ",gameStatus = " + j);
      return;
    }
    if (!a(i, j))
    {
      a(false);
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData = paramEngineData.a();
      return;
    }
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != i)) {
      a(this.jdField_a_of_type_Int);
    }
    a(true);
    this.jdField_a_of_type_Int = i;
    switch (j)
    {
    }
    for (;;)
    {
      if (a(paramEngineData))
      {
        i = QuestionOptionsPresenterImpl.a();
        i(paramEngineData);
        this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter.a(i, paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo);
      }
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData = paramEngineData.a();
      return;
      if (!f(paramEngineData))
      {
        f(paramEngineData);
        if (paramEngineData.p() == 0)
        {
          CJSurvivalFestivalReporter.a(3, 2, true);
          continue;
          if (d(paramEngineData))
          {
            if ((e(paramEngineData)) && ((this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter instanceof GuessPictureStagePresenter))) {
              this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a(GameEngine.a().a(), true);
            }
          }
          else
          {
            i(paramEngineData);
            continue;
            if ((c(paramEngineData)) && (GameEngine.a().h()))
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
              ITopic localITopic = paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicITopic;
              if ((paramEngineData.a().jdField_a_of_type_Int == 0) && (localITopic != null) && ((localITopic instanceof TopicBase)) && (((TopicBase)localITopic).e != 0))
              {
                a(paramEngineData, ((TopicBase)localITopic).e, paramEngineData.a().b);
              }
              else
              {
                a(paramEngineData, paramEngineData.a().jdField_a_of_type_Int, paramEngineData.a().b);
                continue;
                if ((!b(paramEngineData)) || (!GameEngine.a().h()))
                {
                  d(paramEngineData);
                  continue;
                  if (!a()) {
                    c(paramEngineData);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(EngineData paramEngineData, int paramInt1, int paramInt2)
  {
    if (!paramEngineData.a()) {
      return;
    }
    boolean bool = GameEngine.a().a().getAccount().equals(paramEngineData.a().d.uin);
    if ((paramEngineData.f()) && (!paramEngineData.h()))
    {
      if (!bool)
      {
        if (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter != null) {
          this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter.a(paramEngineData);
        }
        a(false, true);
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.d(paramEngineData);
      return;
    }
    int i = paramEngineData.a().a(paramEngineData.a().d.uin);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleAnswerRight scoreThisTime = " + paramInt1 + ", actorScoreThisTime = " + paramInt2 + ", combo = " + paramEngineData.a().jdField_a_of_type_Long);
    }
    String str2 = paramEngineData.a().b();
    Object localObject = (UserInfoHandler)GameEngine.a().a().getBusinessHandler(HandlerFactory.b);
    Bitmap localBitmap = ((UserInfoHandler)localObject).a(String.valueOf(paramEngineData.a().d.uin), (byte)1);
    String str3 = paramEngineData.a().getNick(paramEngineData.a().d.uin);
    long l = paramEngineData.a().jdField_a_of_type_Long;
    if ((paramEngineData.c() == 1) && (paramEngineData.b() != null)) {}
    for (localObject = ((UserInfoHandler)localObject).a(paramEngineData.b().uin, (byte)1);; localObject = null)
    {
      if (!bool) {
        ReportController.b(null, "dc00898", "", "", "0X800B04C", "0X800B04C", paramEngineData.d(), 0, "", "", "", "");
      }
      int j = paramEngineData.d();
      if (bool) {}
      for (String str1 = "1";; str1 = "2")
      {
        ReportController.b(null, "dc00898", "", "", "0X800B04E", "0X800B04E", j, 0, str1, "", String.valueOf(l), "");
        if (QLog.isColorLevel()) {
          QLog.d("StagePresenterImp", 1, new Object[] { "[handleAnswerRight] survival: ", Boolean.valueOf(paramEngineData.f()), ", avRoom: ", Boolean.valueOf(paramEngineData.h()) });
        }
        this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(str2, localBitmap, str3, paramInt1, i, l, (Bitmap)localObject, paramInt2, bool);
        AvGameMusicPlayer.a().a(paramEngineData.a(), "succeed");
        localObject = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a();
        this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a((View)localObject, this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(), true);
        d();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.f * 1000);
        break;
      }
    }
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter = paramIGameRoomPresenter;
  }
  
  public void a(IQuestionOptionPresenter paramIQuestionOptionPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter = paramIQuestionOptionPresenter;
  }
  
  public void a(IGameStagePresenter paramIGameStagePresenter)
  {
    this.jdField_b_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = paramIGameStagePresenter;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = GameEngine.a().a().getAccount();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "showTopicSwitchedTip switcherUin = " + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(str)))
    {
      if (paramInt != 1) {
        break label75;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.b("avgame_tips_switch_topic@2x.png");
    }
    label75:
    while (paramInt != 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.b("avgame_tips_host_switch_topic@2x.png");
  }
  
  public void a(String paramString, EngineData paramEngineData)
  {
    paramString = GameEngine.a().a().getAccount();
    boolean bool = paramString.equals(paramEngineData.a().c.uin);
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a()) && (bool))
    {
      long l = Long.parseLong(paramString);
      paramString = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(l);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().b(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "onShowGameContent " + paramBoolean + ",curGameStagePresenter = " + this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter);
    }
    if (this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.a(paramBoolean, paramLong1, paramLong2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "displayAnswerResult isSelf:" + paramBoolean1 + " isRight:" + paramBoolean2);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().b(paramBoolean1, paramBoolean2);
    if (!paramBoolean1) {
      return;
    }
    EngineData localEngineData = GameEngine.a().a();
    if (paramBoolean2)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(localEngineData);
      AvGameSysMusicPlayer.a().a(localEngineData.a(), "succeed");
      return;
    }
    AvGameSysMusicPlayer.a().a(localEngineData.a(), "failed");
  }
  
  public boolean a(EngineData paramEngineData)
  {
    return (!paramEngineData.h()) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData == null) && (paramEngineData.a() != 1);
  }
  
  public Drawable b()
  {
    GameItem localGameItem = GameEngine.a().a().a();
    if ((localGameItem == null) || (TextUtils.isEmpty(localGameItem.j))) {
      return AvGameResDownloadManager.a("avgame_questions_bg_130_height@2x.png");
    }
    return URLDrawable.getDrawable(localGameItem.j);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "resetGameContent ");
    }
    if (this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a(null);
    }
  }
  
  public void b(EngineData paramEngineData)
  {
    if (((this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView instanceof FestvialStageView)) && (!((FestvialStageView)this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView).a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.b(paramEngineData);
  }
  
  public void b(IGameStagePresenter paramIGameStagePresenter)
  {
    this.c = paramIGameStagePresenter;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.a(paramString);
  }
  
  public void b(String paramString, EngineData paramEngineData)
  {
    if (paramEngineData.d())
    {
      if (!g(paramEngineData)) {
        break label74;
      }
      a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().getResources().getString(2131690344));
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B04B", "0X800B04B", paramEngineData.d(), 0, "", "", "", "");
      return;
      label74:
      paramString = paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.nick;
      a(String.format(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().getResources().getString(2131690345), new Object[] { ContactUtils.a(paramString, 8.0F) }));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "noDisplayAnswerResult");
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(paramBoolean);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StagePresenterImp", 2, "destroy");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameOver");
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a();
    e();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 1, new Object[] { "[handleGameOver] survival: ", Boolean.valueOf(paramEngineData.f()), ", avRoom: ", Boolean.valueOf(paramEngineData.h()) });
    }
    if ((paramEngineData.f()) && (!paramEngineData.h())) {
      AvGameSysMusicPlayer.a().a(paramEngineData.a(), "over");
    }
    for (;;)
    {
      if (paramEngineData.d(GameEngine.a().a().getAccount())) {
        this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().b();
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().e();
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.f(paramEngineData);
      return;
      AvGameMusicPlayer.a().a(paramEngineData.a(), "over");
    }
  }
  
  public void c(IGameStagePresenter paramIGameStagePresenter)
  {
    this.d = paramIGameStagePresenter;
  }
  
  public void d()
  {
    if (GameEngine.a().a().c() == 2) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.c();
    }
  }
  
  public void d(EngineData paramEngineData)
  {
    if ((!paramEngineData.f()) || (paramEngineData.h()))
    {
      Object localObject = paramEngineData.a().b();
      if (QLog.isColorLevel()) {
        QLog.d("StagePresenterImp", 2, "onAnswerTimeoutPush answer = " + (String)localObject);
      }
      ReportController.b(null, "dc00898", "", "", "0X800B04F", "0X800B04F", paramEngineData.d(), 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("StagePresenterImp", 1, new Object[] { "[handleAnswerTimeout] survival: ", Boolean.valueOf(paramEngineData.f()), ", avRoom: ", Boolean.valueOf(paramEngineData.h()) });
      }
      if ((paramEngineData.f()) && (!paramEngineData.h()))
      {
        AvGameSysMusicPlayer.a().a(paramEngineData.a(), "failed");
        if ((!paramEngineData.g()) || (paramEngineData.h()))
        {
          localObject = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a();
          this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a((View)localObject, this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(), false);
        }
        d();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.f * 1000);
      }
    }
    label333:
    label370:
    label373:
    label375:
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.e(paramEngineData);
        return;
        AvGameMusicPlayer.a().a(paramEngineData.a(), "failed");
        break;
        if (paramEngineData.a <= 0) {
          break label375;
        }
        if ((paramEngineData.a & 0x1) > 0)
        {
          bool1 = true;
          if ((paramEngineData.a & 0x2) <= 0) {
            break label370;
          }
        }
        for (boolean bool2 = true;; bool2 = false)
        {
          if (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter == null) {
            break label373;
          }
          this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter.a(bool1, bool2);
          break;
          bool1 = false;
          break label333;
        }
      }
    } while (paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo == null);
    if (paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo.answer_result == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter != null) {
        this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter.a(paramEngineData);
      }
      a(false, bool1);
      break;
    }
  }
  
  public void d(IGameStagePresenter paramIGameStagePresenter)
  {
    this.f = paramIGameStagePresenter;
  }
  
  public void e()
  {
    if (GameEngine.a().f()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.b();
  }
  
  public void e(IGameStagePresenter paramIGameStagePresenter)
  {
    this.e = paramIGameStagePresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.StagePresenterImp
 * JD-Core Version:    0.7.0.1
 */