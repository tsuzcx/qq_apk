package com.tencent.avgame.gameroom.stage.guesstext;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameInfo;
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

public class GuessTextStagePresenter
  implements IGameStagePresenter
{
  IStagePresenter a;
  IGameStageView b;
  private ArrayList<Pair<GuessTextStagePresenter.MixGraphicContent, Boolean>> c = new ArrayList(20);
  
  public GuessTextStagePresenter(IGameStageView paramIGameStageView)
  {
    this.b = paramIGameStageView;
  }
  
  public IStagePresenter a()
  {
    return this.a;
  }
  
  public String a(Context paramContext, EngineData paramEngineData)
  {
    paramContext = paramEngineData.f();
    if (paramContext == null)
    {
      QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip null gameItem");
      paramContext = "";
    }
    else
    {
      paramContext = paramContext.t;
    }
    Object localObject = paramContext;
    if (TextUtils.isEmpty(paramContext))
    {
      localObject = MobileQQ.getContext().getResources().getString(2131887257);
      QLog.e("GuessPictureStagePresenter", 1, "getGamePrepareBottomTip tips isEmpty");
    }
    paramContext = paramEngineData.x();
    if (!TextUtils.isEmpty(paramContext))
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append(paramContext);
      paramEngineData.append("\n");
      paramContext = paramEngineData.toString();
    }
    else
    {
      QLog.e("GuessPictureStagePresenter", 1, "textTypeString tips isEmpty");
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
        QLog.d("GuessPictureStagePresenter", 2, "getGameRuleAnswerTip null context");
      }
      return "";
    }
    String str = paramContext.getResources().getString(2131887256);
    EngineData localEngineData = GameEngine.a().s();
    ITopic localITopic = localEngineData.s();
    if ((localITopic != null) && ((localITopic instanceof TopicBase)) && (!TextUtils.isEmpty(((TopicBase)localITopic).r))) {
      return "";
    }
    if ((localEngineData.M()) && (localEngineData.Y() == 0)) {
      return paramContext.getResources().getString(2131887249);
    }
    if (localEngineData.M()) {
      return "";
    }
    return str;
  }
  
  public void a(ITopic paramITopic)
  {
    this.b.a(paramITopic);
  }
  
  public void a(EngineData paramEngineData)
  {
    a(GameEngine.k(paramEngineData), false);
    this.a.a().e(false);
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.a = paramIStagePresenter;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b.a(paramBoolean1, paramBoolean2);
  }
  
  public void b(EngineData paramEngineData)
  {
    ITopic localITopic = paramEngineData.s();
    a(GameEngine.k(paramEngineData), true);
    a(localITopic);
    Object localObject;
    if (this.b.a())
    {
      this.a.a().e(false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramEngineData.A() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramEngineData.B());
      localObject = ((StringBuilder)localObject).toString();
      this.b.setTitleRight((String)localObject);
    }
    else if (paramEngineData.h().f.d())
    {
      this.a.a().e(true);
      this.a.a().a(paramEngineData.h().f.c * 1000, paramEngineData.h().o());
    }
    else
    {
      this.a.a().e(true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramEngineData.A() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramEngineData.B());
      localObject = ((StringBuilder)localObject).toString();
      this.a.a().c((String)localObject);
    }
    this.a.a(this.b.getTopicClockView(), paramEngineData.h().p(), paramEngineData.h().n());
    if (localITopic != null) {
      this.c.add(new Pair(new GuessTextStagePresenter.MixGraphicContent(localITopic.e(), localITopic.c()), Boolean.valueOf(false)));
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(boolean paramBoolean)
  {
    return false;
  }
  
  public void c(EngineData paramEngineData)
  {
    ITopic localITopic = paramEngineData.s();
    a(GameEngine.k(paramEngineData), true);
    a(localITopic);
    Object localObject;
    if (this.b.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramEngineData.A() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramEngineData.B());
      localObject = ((StringBuilder)localObject).toString();
      this.b.setTitleRight((String)localObject);
    }
    else if (paramEngineData.h().f.d())
    {
      this.a.a().a(paramEngineData.h().f.c * 1000, paramEngineData.h().o());
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramEngineData.A() + 1);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramEngineData.B());
      localObject = ((StringBuilder)localObject).toString();
      this.a.a().c((String)localObject);
    }
    this.a.a(this.b.getTopicClockView(), paramEngineData.h().p(), paramEngineData.h().n());
    if (localITopic != null) {
      this.c.add(new Pair(new GuessTextStagePresenter.MixGraphicContent(localITopic.e(), localITopic.c()), Boolean.valueOf(false)));
    }
  }
  
  public void d(EngineData paramEngineData)
  {
    Object localObject = paramEngineData.s();
    if ((localObject != null) && (!this.c.isEmpty()))
    {
      paramEngineData = ((ITopic)localObject).e();
      ArrayList localArrayList = this.c;
      localArrayList.remove(localArrayList.size() - 1);
      this.c.add(new Pair(new GuessTextStagePresenter.MixGraphicContent(((ITopic)localObject).e(), ((ITopic)localObject).c()), Boolean.valueOf(true)));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAnswerRight ");
      ((StringBuilder)localObject).append(paramEngineData);
      QLog.d("GuessPictureStagePresenter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void e(EngineData paramEngineData) {}
  
  public void f(EngineData paramEngineData)
  {
    boolean bool = this.c.isEmpty();
    paramEngineData = null;
    if (!bool)
    {
      localObject1 = new ArrayList(this.c.size());
      localObject2 = this.c.iterator();
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
        ((StringBuilder)localObject2).append(this.c.size());
        ((StringBuilder)localObject2).append(" notAnswer:");
        ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
        QLog.d("GuessPictureStagePresenter", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new Random();
      int i;
      if (((ArrayList)localObject1).isEmpty())
      {
        i = ((Random)localObject2).nextInt(this.c.size());
        if (i < this.c.size())
        {
          localObject1 = (Pair)this.c.get(i);
          paramEngineData = ((GuessTextStagePresenter.MixGraphicContent)((Pair)localObject1).first).a;
          localObject1 = ((GuessTextStagePresenter.MixGraphicContent)((Pair)localObject1).first).b;
          break label331;
        }
      }
      else
      {
        if (((ArrayList)localObject1).size() == 1)
        {
          paramEngineData = ((GuessTextStagePresenter.MixGraphicContent)((ArrayList)localObject1).get(0)).a;
          localObject1 = ((GuessTextStagePresenter.MixGraphicContent)((ArrayList)localObject1).get(0)).b;
          break label331;
        }
        i = ((Random)localObject2).nextInt(((ArrayList)localObject1).size());
        if (i < ((ArrayList)localObject1).size())
        {
          paramEngineData = ((GuessTextStagePresenter.MixGraphicContent)((ArrayList)localObject1).get(i)).a;
          localObject1 = ((GuessTextStagePresenter.MixGraphicContent)((ArrayList)localObject1).get(i)).b;
          break label331;
        }
      }
    }
    Object localObject1 = null;
    label331:
    Object localObject3 = a().a().s();
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
      QLog.d("GuessPictureStagePresenter", 2, paramEngineData, new Object[0]);
    }
    paramEngineData = ((JSONObject)localObject2).toString();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGameOver str:");
      ((StringBuilder)localObject1).append(paramEngineData);
      QLog.d("GuessPictureStagePresenter", 2, ((StringBuilder)localObject1).toString());
    }
    GameEngine.a().s().a(paramEngineData);
    this.c.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.GuessTextStagePresenter
 * JD-Core Version:    0.7.0.1
 */