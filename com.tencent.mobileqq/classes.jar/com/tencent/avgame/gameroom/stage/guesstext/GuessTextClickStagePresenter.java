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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import mqq.app.MobileQQ;
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
    paramContext = paramEngineData.a();
    if (paramContext == null)
    {
      QLog.e("GuessTextClickStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      paramContext = "";
    }
    else
    {
      paramContext = paramContext.n;
    }
    Object localObject = paramContext;
    if (TextUtils.isEmpty(paramContext))
    {
      localObject = MobileQQ.getContext().getResources().getString(2131690346);
      QLog.e("GuessTextClickStagePresenter", 1, "getGamePrepareBottomTip tips isEmpty");
    }
    paramContext = paramEngineData.c();
    if (!TextUtils.isEmpty(paramContext))
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append(paramContext);
      paramEngineData.append("\n");
      paramContext = paramEngineData.toString();
    }
    else
    {
      QLog.e("GuessTextClickStagePresenter", 1, "textTypeString tips isEmpty");
    }
    if (TextUtils.isEmpty(paramContext)) {
      return localObject;
    }
    paramEngineData = new StringBuilder();
    paramEngineData.append(paramContext);
    paramEngineData.append((String)localObject);
    return paramEngineData.toString();
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
      return paramContext.getResources().getString(2131690339);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramEngineData.e() + 1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramEngineData.f());
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.setTitleRight((String)localObject);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramEngineData.e() + 1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramEngineData.f());
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.setTitleRight((String)localObject);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStageView.a(), paramEngineData.a().f(), paramEngineData.a().d());
    if (localITopic != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(new GuessTextClickStagePresenter.MixGraphicContent(localITopic.c(), localITopic.a()), Boolean.valueOf(false)));
    }
  }
  
  public void d(EngineData paramEngineData)
  {
    Object localObject = paramEngineData.a();
    if ((localObject != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      paramEngineData = ((ITopic)localObject).c();
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      localArrayList.remove(localArrayList.size() - 1);
      this.jdField_a_of_type_JavaUtilArrayList.add(new Pair(new GuessTextClickStagePresenter.MixGraphicContent(((ITopic)localObject).c(), ((ITopic)localObject).a()), Boolean.valueOf(true)));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAnswerRight ");
      ((StringBuilder)localObject).append(paramEngineData);
      QLog.d("GuessTextClickStagePresenter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void e(EngineData paramEngineData) {}
  
  public void f(EngineData paramEngineData)
  {
    boolean bool = this.jdField_a_of_type_JavaUtilArrayList.isEmpty();
    paramEngineData = null;
    if (!bool)
    {
      localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Pair)((Iterator)localObject2).next();
        if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
          ((ArrayList)localObject1).add(((Pair)localObject3).first);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onGameOver all:");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilArrayList.size());
        ((StringBuilder)localObject2).append(" notAnswer:");
        ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
        QLog.d("GuessTextClickStagePresenter", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new Random();
      int i;
      if (((ArrayList)localObject1).isEmpty())
      {
        i = ((Random)localObject2).nextInt(this.jdField_a_of_type_JavaUtilArrayList.size());
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject1 = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          paramEngineData = ((GuessTextClickStagePresenter.MixGraphicContent)((Pair)localObject1).first).a;
          localObject1 = ((GuessTextClickStagePresenter.MixGraphicContent)((Pair)localObject1).first).b;
          break label329;
        }
      }
      else
      {
        if (((ArrayList)localObject1).size() == 1)
        {
          paramEngineData = ((GuessTextClickStagePresenter.MixGraphicContent)((ArrayList)localObject1).get(0)).a;
          localObject1 = ((GuessTextClickStagePresenter.MixGraphicContent)((ArrayList)localObject1).get(0)).b;
          break label329;
        }
        i = ((Random)localObject2).nextInt(((ArrayList)localObject1).size());
        if (i < ((ArrayList)localObject1).size())
        {
          paramEngineData = ((GuessTextClickStagePresenter.MixGraphicContent)((ArrayList)localObject1).get(i)).a;
          localObject1 = ((GuessTextClickStagePresenter.MixGraphicContent)((ArrayList)localObject1).get(i)).b;
          break label329;
        }
      }
    }
    Object localObject1 = null;
    label329:
    Object localObject3 = a().a().b();
    Object localObject2 = new JSONObject();
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
      QLog.d("GuessTextClickStagePresenter", 2, paramEngineData, new Object[0]);
    }
    paramEngineData = ((JSONObject)localObject2).toString();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGameOver str:");
      ((StringBuilder)localObject1).append(paramEngineData);
      QLog.d("GuessTextClickStagePresenter", 2, ((StringBuilder)localObject1).toString());
    }
    GameEngine.a().a().a(paramEngineData);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.GuessTextClickStagePresenter
 * JD-Core Version:    0.7.0.1
 */