package com.tencent.avgame.gameroom.stage.guesstext;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IGameStageView;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class GuessTextClickStagePresenter
  implements IGameStagePresenter
{
  IGameStageView jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView;
  IStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  private ArrayList<Pair<GuessTextClickStagePresenter.MixGraphicContent, Boolean>> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  
  public GuessTextClickStagePresenter(IGameStageView paramIGameStageView)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView = paramIGameStageView;
  }
  
  public IStagePresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  }
  
  public String a(Context paramContext, EngineData paramEngineData)
  {
    paramContext = "";
    Object localObject = paramEngineData.a();
    if (localObject == null)
    {
      QLog.e("GuessTextClickStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      localObject = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131690422);
        QLog.e("GuessTextClickStagePresenter", 1, "getGamePrepareBottomTip tips isEmpty");
      }
      paramContext = paramEngineData.c();
      if (TextUtils.isEmpty(paramContext)) {
        break label98;
      }
      paramContext = paramContext + "\n";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContext)) {
        break label109;
      }
      return localObject;
      paramContext = ((GameItem)localObject).n;
      break;
      label98:
      QLog.e("GuessTextClickStagePresenter", 1, "textTypeString tips isEmpty");
    }
    label109:
    return paramContext + (String)localObject;
  }
  
  public String a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuessTextClickStagePresenter", 2, "getGameRuleAnswerTip null context");
      }
      return "";
    }
    EngineData localEngineData = GameEngine.a().a();
    ITopic localITopic = localEngineData.a();
    if ((localITopic != null) && ((localITopic instanceof TopicBase)) && (!TextUtils.isEmpty(((TopicBase)localITopic).c))) {
      return "";
    }
    if ((localEngineData.f()) && (localEngineData.p() == 0)) {
      return paramContext.getResources().getString(2131690415);
    }
    return "";
  }
  
  public void a(ITopic paramITopic)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(paramITopic);
  }
  
  public void a(EngineData paramEngineData)
  {
    a(GameEngine.a(paramEngineData), false);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().e(false);
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter = paramIStagePresenter;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b(EngineData paramEngineData)
  {
    ITopic localITopic = paramEngineData.a();
    a(GameEngine.a(paramEngineData), true);
    a(localITopic);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().e(false);
    String str = paramEngineData.e() + 1 + "/" + paramEngineData.f();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.setTitleRight(str);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(), paramEngineData.a().f(), paramEngineData.a().d());
    if (localITopic != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(new GuessTextClickStagePresenter.MixGraphicContent(localITopic.c(), localITopic.a()), Boolean.valueOf(false)));
    }
  }
  
  public void c(EngineData paramEngineData)
  {
    ITopic localITopic = paramEngineData.a();
    a(GameEngine.a(paramEngineData), true);
    a(localITopic);
    String str = paramEngineData.e() + 1 + "/" + paramEngineData.f();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.setTitleRight(str);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(), paramEngineData.a().f(), paramEngineData.a().d());
    if (localITopic != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(new GuessTextClickStagePresenter.MixGraphicContent(localITopic.c(), localITopic.a()), Boolean.valueOf(false)));
    }
  }
  
  public void d(EngineData paramEngineData)
  {
    paramEngineData = paramEngineData.a();
    if ((paramEngineData != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      String str = paramEngineData.c();
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(new GuessTextClickStagePresenter.MixGraphicContent(paramEngineData.c(), paramEngineData.a()), Boolean.valueOf(true)));
      QLog.d("GuessTextClickStagePresenter", 2, "onAnswerRight " + str);
    }
  }
  
  public void e(EngineData paramEngineData) {}
  
  public void f(EngineData paramEngineData)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    int i;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      localObject3 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
      paramEngineData = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramEngineData.hasNext())
      {
        Pair localPair = (Pair)paramEngineData.next();
        if (!((Boolean)localPair.second).booleanValue()) {
          ((ArrayList)localObject3).add(localPair.first);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuessTextClickStagePresenter", 2, "onGameOver all:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " notAnswer:" + ((ArrayList)localObject3).size());
      }
      paramEngineData = new Random();
      if (((ArrayList)localObject3).isEmpty())
      {
        i = paramEngineData.nextInt(this.jdField_a_of_type_JavaUtilArrayList.size());
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label461;
        }
        paramEngineData = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = ((GuessTextClickStagePresenter.MixGraphicContent)paramEngineData.first).a;
      }
    }
    label461:
    for (paramEngineData = ((GuessTextClickStagePresenter.MixGraphicContent)paramEngineData.first).b;; paramEngineData = null)
    {
      localObject2 = localObject1;
      localObject1 = paramEngineData;
      paramEngineData = (EngineData)localObject2;
      for (;;)
      {
        localObject3 = a().a().b();
        localObject2 = new JSONObject();
        try
        {
          if (!TextUtils.isEmpty(paramEngineData)) {
            ((JSONObject)localObject2).putOpt("textContent", paramEngineData);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((JSONObject)localObject2).putOpt("imageUrl", localObject1);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((JSONObject)localObject2).putOpt("bgUrl", localObject3);
          }
        }
        catch (JSONException paramEngineData)
        {
          for (;;)
          {
            QLog.d("GuessTextClickStagePresenter", 2, paramEngineData, new Object[0]);
          }
        }
        paramEngineData = ((JSONObject)localObject2).toString();
        if (QLog.isColorLevel()) {
          QLog.d("GuessTextClickStagePresenter", 2, "onGameOver str:" + paramEngineData);
        }
        GameEngine.a().a().a(paramEngineData);
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        return;
        if (((ArrayList)localObject3).size() == 1)
        {
          paramEngineData = ((GuessTextClickStagePresenter.MixGraphicContent)((ArrayList)localObject3).get(0)).a;
          localObject1 = ((GuessTextClickStagePresenter.MixGraphicContent)((ArrayList)localObject3).get(0)).b;
        }
        else
        {
          i = paramEngineData.nextInt(((ArrayList)localObject3).size());
          if (i < ((ArrayList)localObject3).size())
          {
            paramEngineData = ((GuessTextClickStagePresenter.MixGraphicContent)((ArrayList)localObject3).get(i)).a;
            localObject1 = ((GuessTextClickStagePresenter.MixGraphicContent)((ArrayList)localObject3).get(i)).b;
          }
          else
          {
            paramEngineData = null;
            localObject1 = localObject2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.GuessTextClickStagePresenter
 * JD-Core Version:    0.7.0.1
 */