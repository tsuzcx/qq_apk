package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.GameMsgPopInfoHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.data.GameMsgGrayTipsHandler;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.sso.GameCenterUnissoObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class GameMsgChatPie$1
  extends GameCenterUnissoObserver
{
  GameMsgChatPie$1(GameMsgChatPie paramGameMsgChatPie, int paramInt)
  {
    super(paramInt);
  }
  
  public void a()
  {
    if (!GameMsgChatPie.h(this.a)) {
      GameMsgChatPie.i(this.a);
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    boolean bool2 = false;
    Object localObject1;
    Object localObject2;
    if ((paramObject != null) && ((paramObject instanceof JSONObject)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onGetGameStartPriority] data:");
      ((StringBuilder)localObject1).append(paramObject.toString());
      QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, ((StringBuilder)localObject1).toString());
      try
      {
        paramObject = (JSONObject)paramObject;
        if (paramObject.optString("ret_code") != null)
        {
          localObject1 = paramObject.optJSONObject("download_info");
          if (localObject1 != null)
          {
            GameMsgChatPie.a(this.a, ((JSONObject)localObject1).optString("pkg_name"));
            GameMsgChatPie.b(this.a, ((JSONObject)localObject1).optString("ticket"));
          }
          GameMsgChatPie.a(this.a, paramObject.optInt("open_switch"));
          paramObject = paramObject.optJSONArray("start_priority_list");
          GameMsgChatPie.a(this.a).clear();
          if (paramObject != null)
          {
            int i = 0;
            while (i < paramObject.length())
            {
              localObject1 = paramObject.optJSONObject(i);
              localObject2 = new GameMsgChatPie.GamePriorityInfo(null);
              ((GameMsgChatPie.GamePriorityInfo)localObject2).b = ((JSONObject)localObject1).optString("content");
              ((GameMsgChatPie.GamePriorityInfo)localObject2).a = ((JSONObject)localObject1).optString("icon_url");
              GameMsgChatPie.a(this.a).add(localObject2);
              i += 1;
            }
          }
        }
        if (GameMsgChatPie.b(this.a)) {
          break label333;
        }
      }
      catch (Exception paramObject)
      {
        QLog.e("GameCenterMsg.GameCenterUnissoObserver", 1, paramObject, new Object[0]);
      }
    }
    else if (GameMsgChatPie.c(this.a) != null)
    {
      localObject1 = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
      localObject2 = GameMsgChatPie.c(this.a).c;
      if (GameMsgChatPie.d(this.a) == 1) {
        paramObject = "1";
      } else {
        paramObject = "0";
      }
      ((IGameMsgHelperApi)localObject1).reportForGameMsg((String)localObject2, "1", "145", "920", "92005", "207561", paramObject, "", "8", "0");
      GameMsgChatPie.a(this.a, true);
    }
    label333:
    boolean bool1 = bool2;
    if (this.a.i() != null)
    {
      bool1 = bool2;
      if (GameMsgChatPie.c(this.a) != null)
      {
        paramObject = BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.a.i().getCurrentUin());
        ((StringBuilder)localObject1).append("_game_msg_chatpie_reddot_click_");
        ((StringBuilder)localObject1).append(GameMsgChatPie.c(this.a).c);
        bool1 = paramObject.getBoolean(((StringBuilder)localObject1).toString(), false);
      }
    }
    if ((GameMsgChatPie.d(this.a) == 1) && (!bool1))
    {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.c(this.a).c, "1", "145", "920", "92005", "207562", "", "", "8", "0");
      ThreadManagerV2.getUIHandlerV2().post(new GameMsgChatPie.1.1(this));
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Object localObject = GameMsgChatPie.c(this.a);
    String str1 = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = GameMsgChatPie.c(this.a).c;
    }
    if (GameMsgChatPie.c(this.a) != null)
    {
      if (paramJSONObject.has("tianji_id")) {
        str1 = String.valueOf(paramJSONObject.optInt("tianji_id"));
      }
      String str2;
      if (GameMsgChatPie.j(this.a) == 5)
      {
        str2 = "3";
      }
      else
      {
        if ((GameMsgChatPie.j(this.a) != 1) && (GameMsgChatPie.j(this.a) != 4)) {
          GameMsgChatPie.j(this.a);
        }
        str2 = "1";
      }
      IGameMsgHelperApi localIGameMsgHelperApi = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
      String str4 = Integer.toString(GameMsgChatPie.c(this.a).j);
      String str3;
      if (GameMsgChatPie.c(this.a).m == 0) {
        str3 = "1";
      } else {
        str3 = "0";
      }
      localIGameMsgHelperApi.reportForGameMsg865WithTianJi((String)localObject, "1", "145", "920", "92005", "206350", str4, str3, "8", str2, "", "", str1);
    }
    int i = 0;
    if (paramJSONObject.optInt("qcard_switch", 0) == 1) {
      i = 1;
    }
    if ((i != 0) && (this.a.f != null) && (!this.a.f.isFinishing()))
    {
      if ((GameMsgChatPie.k(this.a) != null) && (GameMsgChatPie.k(this.a).isShowing())) {
        return;
      }
      try
      {
        GameMsgChatPie.a(this.a, ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).createProfileGuideDailg(this.a.f, (String)localObject));
        if (GameMsgChatPie.k(this.a) != null)
        {
          GameMsgChatPie.k(this.a).show();
          return;
        }
      }
      catch (Throwable paramJSONObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("show ProfileGuideDialog e:");
        ((StringBuilder)localObject).append(paramJSONObject);
        QLog.e("GameCenterMsg.GameCenterUnissoObserver", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void b()
  {
    QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, "[onSetSwitchCallback]");
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("type", 1);
      ((JSONObject)localObject).put("title", "如游戏好友消息对你产生骚扰，可");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", 2);
      localJSONObject.put("title", "设置屏蔽");
      localJSONObject.put("url", "https://speed.gamecenter.qq.com/pushgame/v1/gamemsg-setting?_wv=2&_wwv=134");
      localJSONArray.put(localObject);
      localJSONArray.put(localJSONObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("content", localJSONArray);
      localJSONArray = new JSONArray();
      localJSONArray.put(localObject);
      localObject = this.a.d.getMessageFacade().getLastMessage(this.a.ah.b, 10007);
      if (localObject != null)
      {
        localObject = new TinyInfo(((Message)localObject).getExtInfoFromExtStr("ext_key_game_msg_info"));
        GameMsgGrayTipsHandler.a(localJSONArray, this.a.d, this.a.ah.b, Long.toString(((TinyInfo)localObject).fromTinyId), Long.toString(((TinyInfo)localObject).toTinyId), "", 0L);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GameCenterMsg.GameCenterUnissoObserver", 1, localThrowable.getMessage());
    }
  }
  
  public void b(Object paramObject)
  {
    QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, "[onGameUsrInfoChangedNotify]");
    try
    {
      if ((paramObject instanceof ArrayList))
      {
        paramObject = ((ArrayList)paramObject).iterator();
        while (paramObject.hasNext())
        {
          GameDetailInfo localGameDetailInfo = (GameDetailInfo)paramObject.next();
          if ((!TextUtils.isEmpty(localGameDetailInfo.a)) && (localGameDetailInfo.a.equals(this.a.ah.c())))
          {
            GameMsgChatPie.a(this.a, localGameDetailInfo);
            GameMsgChatPie.b(this.a, GameMsgChatPie.c(this.a));
            if (GameMsgChatPie.c(this.a) != null)
            {
              ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).getGameStartPriority(GameMsgChatPie.e(this.a), GameMsgChatPie.c(this.a).c);
              GameMsgChatPie.bi = GameMsgChatPie.c(this.a).c;
            }
            QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, "update friend info.");
          }
          else if ((!TextUtils.isEmpty(localGameDetailInfo.a)) && (localGameDetailInfo.a.equals(this.a.ah.d())))
          {
            GameMsgChatPie.c(this.a, localGameDetailInfo);
            QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, "update my info.");
          }
        }
      }
      return;
    }
    catch (Throwable paramObject)
    {
      QLog.e("GameCenterMsg.GameCenterUnissoObserver", 1, paramObject.getMessage());
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    GameMsgPopInfoHelper localGameMsgPopInfoHelper = (GameMsgPopInfoHelper)this.a.q(140);
    if (localGameMsgPopInfoHelper != null) {
      localGameMsgPopInfoHelper.a(paramJSONObject);
    }
  }
  
  public void c(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = "";
    }
    try
    {
      paramObject = paramObject.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onGetFriendExtInfo], data:");
      localStringBuilder.append(paramObject);
      QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, localStringBuilder.toString());
      GameMsgChatPie.f(this.a).updateRedDotConfig(this.a.ah.c(), paramObject);
      return;
    }
    catch (Throwable paramObject)
    {
      QLog.e("GameCenterMsg.GameCenterUnissoObserver", 1, paramObject, new Object[0]);
    }
  }
  
  public void d(Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onGetTopGrayTips], tips:");
      ((StringBuilder)localObject).append(paramObject);
      QLog.d("GameCenterMsg.GameCenterUnissoObserver", 2, ((StringBuilder)localObject).toString());
    }
    String str = this.a.f.getIntent().getStringExtra("game_msg_top_gray_text");
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = str;
      if ((paramObject instanceof String)) {
        localObject = (String)paramObject;
      }
    }
    GameMsgChatPie.c(this.a, (String)localObject);
    if ((GameMsgChatPie.g(this.a) != null) && (GameMsgChatPie.g(this.a).b == 0)) {
      GameMsgChatPie.d(this.a, (String)localObject);
    }
  }
  
  public void e(Object paramObject)
  {
    Object localObject1;
    if ((paramObject != null) && ((paramObject instanceof JSONObject)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onGetAioPopInfo] data:");
      ((StringBuilder)localObject1).append(paramObject.toString());
      QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = (JSONObject)paramObject;
        paramObject = ((JSONObject)localObject2).optString("title");
        localObject1 = ((JSONObject)localObject2).optString("content");
        localObject2 = ((JSONObject)localObject2).optJSONArray("buttons");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (((JSONArray)localObject2).length() == 0) {
            return;
          }
          ArrayList localArrayList = new ArrayList();
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = (JSONObject)((JSONArray)localObject2).get(i);
            GameMsgChatPie.ButtonInfo localButtonInfo = new GameMsgChatPie.ButtonInfo(this.a);
            localButtonInfo.b = localJSONObject.optString("title");
            if (TextUtils.isEmpty(localButtonInfo.b)) {
              break label298;
            }
            localButtonInfo.a = localJSONObject.optString("url");
            localButtonInfo.c = localJSONObject.optInt("type");
            localArrayList.add(localButtonInfo);
            break label298;
          }
          if (localArrayList.size() == 1)
          {
            GameMsgChatPie.a(this.a, paramObject, (String)localObject1, (GameMsgChatPie.ButtonInfo)localArrayList.get(0), null);
            return;
          }
          if (localArrayList.size() >= 2)
          {
            GameMsgChatPie.a(this.a, paramObject, (String)localObject1, (GameMsgChatPie.ButtonInfo)localArrayList.get(0), (GameMsgChatPie.ButtonInfo)localArrayList.get(1));
            return;
          }
          QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, "[onGetAioPopInfo] no button.");
          return;
        }
        return;
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
      }
      return;
      label298:
      i += 1;
    }
  }
  
  public void f(Object paramObject)
  {
    String str;
    if (GameMsgChatPie.g(this.a) != null) {
      str = GameMsgChatPie.g(this.a).d;
    } else {
      str = "";
    }
    GameMsgGrayTipsHandler.a(paramObject, this.a.d, this.a.ah.b, "", "", str, 0L);
  }
  
  public void g(Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onGetStrangerRecomInfo], data:");
      ((StringBuilder)localObject).append(paramObject);
      QLog.d("GameCenterMsg.GameMsgChatPie.strangerRecom", 1, ((StringBuilder)localObject).toString());
    }
    if ((paramObject != null) && ((paramObject instanceof JSONObject))) {
      try
      {
        paramObject = (JSONObject)paramObject;
        String str = paramObject.optString("uin");
        int i = paramObject.optInt("relationship");
        int j = paramObject.optInt("add_friend_type");
        int k = paramObject.optInt("is_shield");
        paramObject = new StringBuilder();
        paramObject.append("relation:");
        paramObject.append(i);
        paramObject.append(",addFriendType:");
        paramObject.append(j);
        paramObject.append(",isShield:");
        paramObject.append(k);
        QLog.i("GameCenterMsg.GameMsgChatPie.strangerRecom", 1, paramObject.toString());
        GameMsgChatPie.a(this.a, new GameMsgChatPie.StrangerRecomInfo());
        GameMsgChatPie.g(this.a).a = i;
        GameMsgChatPie.g(this.a).b = j;
        GameMsgChatPie.g(this.a).c = k;
        GameMsgChatPie.g(this.a).d = str;
        GameMsgChatPie.b(this.a, k);
        GameMsgChatPie.b(this.a, GameMsgChatPie.c(this.a));
        GameMsgChatPie.c(this.a, i);
        localObject = ContactUtils.f(this.a.d, GameMsgChatPie.g(this.a).d);
        paramObject = localObject;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramObject = localObject;
          if (GameMsgChatPie.c(this.a) != null) {
            paramObject = GameMsgChatPie.c(this.a).e;
          }
        }
        this.a.ah.e = paramObject;
        if (GameMsgChatPie.c(this.a) != null)
        {
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.c(this.a).c, "1", "145", "920", "92015", "207856", str, this.a.d.getCurrentAccountUin(), "8", "");
          return;
        }
      }
      catch (Throwable paramObject)
      {
        QLog.e("GameCenterMsg.GameMsgChatPie.strangerRecom", 1, paramObject, new Object[0]);
      }
    }
  }
  
  public void h(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {
      GameMsgChatPie.e(this.a, (String)paramObject);
    }
  }
  
  public void i(Object paramObject)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onAddOrShiledFriendCallback], data:");
      localStringBuilder.append(paramObject);
      QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, localStringBuilder.toString());
      paramObject = (JSONObject)paramObject;
      GameMsgChatPie.b(this.a, paramObject.optInt("op_type"));
      return;
    }
    catch (Throwable paramObject)
    {
      QLog.w("GameCenterMsg.GameCenterUnissoObserver", 1, paramObject.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.1
 * JD-Core Version:    0.7.0.1
 */