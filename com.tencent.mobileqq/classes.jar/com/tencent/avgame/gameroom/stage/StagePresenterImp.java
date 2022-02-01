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
    Object localObject;
    if (paramInt == 1)
    {
      localObject = this.jdField_b_of_type_ComTencentAvgameGameroomStageIGameStagePresenter;
      if (localObject != null) {
        ((IGameStagePresenter)localObject).a(false);
      }
    }
    else if (paramInt == 2)
    {
      localObject = this.d;
      if (localObject != null) {
        ((IGameStagePresenter)localObject).a(false);
      }
    }
    else if (paramInt == 3)
    {
      localObject = this.c;
      if (localObject != null) {
        ((IGameStagePresenter)localObject).a(false);
      }
    }
    else if (paramInt == 4)
    {
      localObject = this.f;
      if (localObject != null) {
        ((IGameStagePresenter)localObject).a(false);
      }
    }
    else if (paramInt == 5)
    {
      localObject = this.e;
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
  
  private boolean a()
  {
    EngineData localEngineData = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData;
    return (localEngineData != null) && (localEngineData.a() == 10);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 0) && (paramInt2 != 0);
  }
  
  private boolean b(EngineData paramEngineData)
  {
    EngineData localEngineData = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData;
    return (localEngineData != null) && (localEngineData.a() == 4) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().a(paramEngineData.a()));
  }
  
  private boolean c(EngineData paramEngineData)
  {
    EngineData localEngineData = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData;
    return (localEngineData != null) && (localEngineData.a() == 3) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().a(paramEngineData.a()));
  }
  
  private boolean d(EngineData paramEngineData)
  {
    EngineData localEngineData = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData;
    return (localEngineData != null) && (localEngineData.a() == 2) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().a(paramEngineData.a()));
  }
  
  private void e(EngineData paramEngineData)
  {
    if (paramEngineData.c() == 1) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = this.jdField_b_of_type_ComTencentAvgameGameroomStageIGameStagePresenter;
    } else if (paramEngineData.c() == 2) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = this.d;
    } else if (paramEngineData.c() == 3) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = this.c;
    } else if (paramEngineData.c() == 4) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = this.f;
    } else if (paramEngineData.c() == 5) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter = this.e;
    }
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("updateCurGameStagePresenter curGameStagePresenter = ");
      paramEngineData.append(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter);
      QLog.d("StagePresenterImp", 2, paramEngineData.toString());
    }
  }
  
  private boolean e(EngineData paramEngineData)
  {
    EngineData localEngineData = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData;
    return (localEngineData != null) && (localEngineData.a().owner != paramEngineData.a().owner) && (GameEngine.a().a());
  }
  
  private void f(EngineData paramEngineData)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGameStart buff = ");
      ((StringBuilder)localObject).append(paramEngineData.a().a()[0]);
      ((StringBuilder)localObject).append(paramEngineData.a().a()[1]);
      ((StringBuilder)localObject).append(paramEngineData.a().a()[2]);
      QLog.d("StagePresenterImp", 2, ((StringBuilder)localObject).toString());
    }
    b();
    g(paramEngineData);
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a()) && (g(paramEngineData)))
    {
      l = Long.parseLong(GameEngine.a().a().getAccount());
      localObject = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(l);
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().b((RectF)localObject);
    }
    long l = paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.d * 1000 - paramEngineData.a().d();
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("handleGameStart delayMs = ");
      paramEngineData.append(l);
      QLog.d("StagePresenterImp", 2, paramEngineData.toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
  }
  
  private boolean f(EngineData paramEngineData)
  {
    EngineData localEngineData = this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData;
    return (localEngineData != null) && (localEngineData.a() == 1) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin.equals(paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin));
  }
  
  private void g(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a();
    boolean bool = g(paramEngineData);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUIForGamePrepare isPlayerSelf = ");
      localStringBuilder.append(bool);
      QLog.d("StagePresenterImp", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateStageUIForRealStart isPlayerSelf = ");
      localStringBuilder.append(bool);
      QLog.d("StagePresenterImp", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.c();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.b(paramEngineData);
    GameEngine.a().j(paramEngineData);
    if (paramEngineData.g())
    {
      int i;
      if (paramEngineData.h()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "survival_subject", "survival_subject", i, 0, String.valueOf(paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_a_of_type_Int), String.valueOf(paramEngineData.p()), CJSurvivalReporterUtil.a().a(paramEngineData), String.valueOf(paramEngineData.k()));
    }
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSwitchTopic ,topic = ");
      localStringBuilder.append(paramEngineData.a().c());
      localStringBuilder.append(" buff = ");
      localStringBuilder.append(paramEngineData.a().a()[0]);
      localStringBuilder.append(paramEngineData.a().a()[1]);
      localStringBuilder.append(paramEngineData.a().a()[2]);
      QLog.d("StagePresenterImp", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.c();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.c(paramEngineData);
    GameEngine.a().j(paramEngineData);
    if (paramEngineData.g())
    {
      int i;
      if (paramEngineData.h()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "survival_subject", "survival_subject", i, 0, String.valueOf(paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_a_of_type_Int), String.valueOf(paramEngineData.p()), CJSurvivalReporterUtil.a().a(paramEngineData), String.valueOf(paramEngineData.k()));
    }
    if (paramEngineData.d(GameEngine.a().a().getAccount())) {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().b(this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.a());
    }
    if (Build.VERSION.SDK_INT >= 16) {
      AudioProcess.a().updateRecogTxt(paramEngineData.a().b());
    }
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.a();
  }
  
  public Drawable a()
  {
    GameItem localGameItem = GameEngine.a().a().a();
    if ((localGameItem != null) && (!TextUtils.isEmpty(localGameItem.i))) {
      return URLDrawable.getDrawable(localGameItem.i);
    }
    return AvGameResDownloadUtil.a("avgame_questions_bg_110_height@2x.png");
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
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView;
    if (((localObject instanceof FestvialStageView)) && (!((FestvialStageView)localObject).a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.a(paramEngineData);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.b(paramEngineData);
    e(paramEngineData);
    int i = paramEngineData.c();
    int j = paramEngineData.a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refresh gameType = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",gameStatus = ");
      ((StringBuilder)localObject).append(j);
      QLog.d("StagePresenterImp", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter == null)
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("refresh return for null presenter,gameType = ");
      paramEngineData.append(i);
      paramEngineData.append(",gameStatus = ");
      paramEngineData.append(j);
      QLog.d("StagePresenterImp", 1, paramEngineData.toString());
      return;
    }
    if (!a(i, j))
    {
      a(false);
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData = paramEngineData.a();
      return;
    }
    int k = this.jdField_a_of_type_Int;
    if ((k != 0) && (k != i)) {
      a(k);
    }
    a(true);
    this.jdField_a_of_type_Int = i;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if ((j == 10) && (!a())) {
              c(paramEngineData);
            }
          }
          else if ((!b(paramEngineData)) || (!GameEngine.a().h())) {
            d(paramEngineData);
          }
        }
        else if ((c(paramEngineData)) && (GameEngine.a().h()))
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
          localObject = paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicITopic;
          if ((paramEngineData.a().jdField_a_of_type_Int == 0) && (localObject != null) && ((localObject instanceof TopicBase)))
          {
            localObject = (TopicBase)localObject;
            if (((TopicBase)localObject).e != 0)
            {
              a(paramEngineData, ((TopicBase)localObject).e, paramEngineData.a().b);
              break label587;
            }
          }
          a(paramEngineData, paramEngineData.a().jdField_a_of_type_Int, paramEngineData.a().b);
        }
      }
      else if (d(paramEngineData))
      {
        if (e(paramEngineData))
        {
          localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter;
          if ((localObject instanceof GuessPictureStagePresenter)) {
            ((IGameStagePresenter)localObject).a(GameEngine.a().a(), true);
          }
        }
      }
      else {
        i(paramEngineData);
      }
    }
    else if (!f(paramEngineData))
    {
      f(paramEngineData);
      if ((paramEngineData.p() == 0) && (paramEngineData.g()))
      {
        if (paramEngineData.h()) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(null, "dc00898", "", "", "survival_countdown", "survival_countdown", i, 0, String.valueOf(paramEngineData.j()), "", String.valueOf(paramEngineData.l()), String.valueOf(paramEngineData.k()));
      }
    }
    label587:
    if (a(paramEngineData))
    {
      i = QuestionOptionsPresenterImpl.a();
      i(paramEngineData);
      this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter.a(i, paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData = paramEngineData.a();
  }
  
  public void a(EngineData paramEngineData, int paramInt1, int paramInt2)
  {
    if (!paramEngineData.a()) {
      return;
    }
    boolean bool = GameEngine.a().a().getAccount().equals(paramEngineData.a().d.uin);
    Object localObject;
    if ((paramEngineData.f()) && (!paramEngineData.h()))
    {
      if (!bool)
      {
        localObject = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter;
        if (localObject != null) {
          ((IQuestionOptionPresenter)localObject).a(paramEngineData);
        }
        a(false, true);
      }
    }
    else
    {
      int i = paramEngineData.a().a(paramEngineData.a().d.uin);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleAnswerRight scoreThisTime = ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(", actorScoreThisTime = ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(", combo = ");
        ((StringBuilder)localObject).append(paramEngineData.a().jdField_a_of_type_Long);
        QLog.d("StagePresenterImp", 2, ((StringBuilder)localObject).toString());
      }
      String str2 = paramEngineData.a().b();
      localObject = (UserInfoHandler)GameEngine.a().a().getBusinessHandler(HandlerFactory.b);
      Bitmap localBitmap = ((UserInfoHandler)localObject).a(String.valueOf(paramEngineData.a().d.uin), (byte)1);
      String str3 = paramEngineData.a().getNick(paramEngineData.a().d.uin);
      long l = paramEngineData.a().jdField_a_of_type_Long;
      if ((paramEngineData.c() == 1) && (paramEngineData.b() != null)) {
        localObject = ((UserInfoHandler)localObject).a(paramEngineData.b().uin, (byte)1);
      } else {
        localObject = null;
      }
      if (!bool) {
        ReportController.b(null, "dc00898", "", "", "0X800B04C", "0X800B04C", paramEngineData.d(), 0, "", "", "", "");
      }
      int j = paramEngineData.d();
      String str1;
      if (bool) {
        str1 = "1";
      } else {
        str1 = "2";
      }
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
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.d(paramEngineData);
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
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.b("avgame_tips_switch_topic@2x.png");
        return;
      }
      if (paramInt == 2) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.b("avgame_tips_host_switch_topic@2x.png");
      }
    }
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowGameContent ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",curGameStagePresenter = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter);
      QLog.d("StagePresenterImp", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter;
    if (localObject != null) {
      ((IGameStagePresenter)localObject).a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.a(paramBoolean, paramLong1, paramLong2);
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
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().b(paramBoolean1, paramBoolean2);
    if (!paramBoolean1) {
      return;
    }
    Object localObject = GameEngine.a().a();
    if (paramBoolean2)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a((EngineData)localObject);
      AvGameSysMusicPlayer.a().a(((EngineData)localObject).a(), "succeed");
      return;
    }
    AvGameSysMusicPlayer.a().a(((EngineData)localObject).a(), "failed");
  }
  
  public boolean a(EngineData paramEngineData)
  {
    return (!paramEngineData.h()) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataEngineData == null) && (paramEngineData.a() != 1);
  }
  
  public Drawable b()
  {
    GameItem localGameItem = GameEngine.a().a().a();
    if ((localGameItem != null) && (!TextUtils.isEmpty(localGameItem.j))) {
      return URLDrawable.getDrawable(localGameItem.j);
    }
    return AvGameResDownloadUtil.a("avgame_questions_bg_130_height@2x.png");
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "resetGameContent ");
    }
    IGameStagePresenter localIGameStagePresenter = this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter;
    if (localIGameStagePresenter != null) {
      localIGameStagePresenter.a(null);
    }
  }
  
  public void b(EngineData paramEngineData)
  {
    IStageView localIStageView = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView;
    if (((localIStageView instanceof FestvialStageView)) && (!((FestvialStageView)localIStageView).a())) {
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
      if (g(paramEngineData))
      {
        a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().getResources().getString(2131690267));
      }
      else
      {
        paramString = paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.nick;
        a(String.format(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().getResources().getString(2131690268), new Object[] { ContactUtils.a(paramString, 8.0F) }));
      }
      ReportController.b(null, "dc00898", "", "", "0X800B04B", "0X800B04B", paramEngineData.d(), 0, "", "", "", "");
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
    } else {
      AvGameMusicPlayer.a().a(paramEngineData.a(), "over");
    }
    if (paramEngineData.d(GameEngine.a().a().getAccount())) {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().b();
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().e();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.f(paramEngineData);
  }
  
  public void c(IGameStagePresenter paramIGameStagePresenter)
  {
    this.d = paramIGameStagePresenter;
  }
  
  public void d()
  {
    if (GameEngine.a().a().c() == 2) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.b();
    }
  }
  
  public void d(EngineData paramEngineData)
  {
    boolean bool3 = paramEngineData.f();
    boolean bool2 = false;
    boolean bool1 = true;
    Object localObject;
    if ((bool3) && (!paramEngineData.h()))
    {
      if (paramEngineData.a > 0)
      {
        if ((paramEngineData.a & 0x1) > 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if ((0x2 & paramEngineData.a) > 0) {
          bool2 = true;
        }
        localObject = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter;
        if (localObject != null) {
          ((IQuestionOptionPresenter)localObject).a(bool1, bool2);
        }
      }
      else if (paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo != null)
      {
        if (paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo.answer_result != 1) {
          bool1 = false;
        }
        localObject = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter;
        if (localObject != null) {
          ((IQuestionOptionPresenter)localObject).a(paramEngineData);
        }
        a(false, bool1);
      }
    }
    else
    {
      localObject = paramEngineData.a().b();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAnswerTimeoutPush answer = ");
        localStringBuilder.append((String)localObject);
        QLog.d("StagePresenterImp", 2, localStringBuilder.toString());
      }
      ReportController.b(null, "dc00898", "", "", "0X800B04F", "0X800B04F", paramEngineData.d(), 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("StagePresenterImp", 1, new Object[] { "[handleAnswerTimeout] survival: ", Boolean.valueOf(paramEngineData.f()), ", avRoom: ", Boolean.valueOf(paramEngineData.h()) });
      }
      if ((paramEngineData.f()) && (!paramEngineData.h())) {
        AvGameSysMusicPlayer.a().a(paramEngineData.a(), "failed");
      } else {
        AvGameMusicPlayer.a().a(paramEngineData.a(), "failed");
      }
      if ((!paramEngineData.g()) || (paramEngineData.h()))
      {
        localObject = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a();
        this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a((View)localObject, this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a().a(), false);
      }
      d();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.f * 1000);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.e(paramEngineData);
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
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageView.a();
  }
  
  public void e(IGameStagePresenter paramIGameStagePresenter)
  {
    this.e = paramIGameStagePresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.StagePresenterImp
 * JD-Core Version:    0.7.0.1
 */