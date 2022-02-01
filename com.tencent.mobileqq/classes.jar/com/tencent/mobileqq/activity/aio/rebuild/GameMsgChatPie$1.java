package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AddFriendHelper;
import com.tencent.mobileqq.activity.aio.helper.GameMsgAddFriendHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgAddFriendRulesApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.data.GameMsgGrayTipsHandler;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.sso.GameCenterUnissoObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
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
  GameMsgChatPie$1(GameMsgChatPie paramGameMsgChatPie) {}
  
  protected void a()
  {
    if (!GameMsgChatPie.b(this.a)) {
      GameMsgChatPie.a(this.a);
    }
  }
  
  protected void a(Object paramObject)
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
      QLog.i("GameMsgChatPie", 1, ((StringBuilder)localObject1).toString());
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
          GameMsgChatPie.c(this.a, paramObject.optString("reserved_str"));
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
              ((GameMsgChatPie.GamePriorityInfo)localObject2).jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("icon_url");
              GameMsgChatPie.a(this.a).add(localObject2);
              i += 1;
            }
          }
        }
        if (GameMsgChatPie.a(this.a)) {
          break label347;
        }
      }
      catch (Exception paramObject)
      {
        QLog.e("GameMsgChatPie", 1, paramObject, new Object[0]);
      }
    }
    else if (GameMsgChatPie.a(this.a) != null)
    {
      localObject1 = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
      localObject2 = GameMsgChatPie.a(this.a).c;
      if (GameMsgChatPie.a(this.a) == 1) {
        paramObject = "1";
      } else {
        paramObject = "0";
      }
      ((IGameMsgHelperApi)localObject1).reportForGameMsg((String)localObject2, "1", "145", "920", "92005", "207561", paramObject, "", "8", "0");
      GameMsgChatPie.a(this.a, true);
    }
    label347:
    boolean bool1 = bool2;
    if (this.a.a() != null)
    {
      bool1 = bool2;
      if (GameMsgChatPie.a(this.a) != null)
      {
        paramObject = BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.a.a().getCurrentUin());
        ((StringBuilder)localObject1).append("_game_msg_chatpie_reddot_click_");
        ((StringBuilder)localObject1).append(GameMsgChatPie.a(this.a).c);
        bool1 = paramObject.getBoolean(((StringBuilder)localObject1).toString(), false);
      }
    }
    if ((GameMsgChatPie.a(this.a) == 1) && (!bool1))
    {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.a(this.a).c, "1", "145", "920", "92005", "207562", "", "", "8", "0");
      ThreadManagerV2.getUIHandlerV2().post(new GameMsgChatPie.1.1(this));
    }
  }
  
  protected void b()
  {
    QLog.i("GameMsgChatPie", 1, "[onSetSwitchCallback]");
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
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 10007);
      if (localObject != null)
      {
        localObject = new TinyInfo(((Message)localObject).getExtInfoFromExtStr("ext_key_game_msg_info"));
        GameMsgGrayTipsHandler.a(localJSONArray, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.toString(((TinyInfo)localObject).fromTinyId), Long.toString(((TinyInfo)localObject).toTinyId), "", 0L);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GameMsgChatPie", 1, localThrowable.getMessage());
    }
  }
  
  protected void b(Object paramObject)
  {
    QLog.i("GameMsgChatPie", 1, "[onGameUsrInfoChangedNotify]");
    try
    {
      if ((paramObject instanceof ArrayList))
      {
        paramObject = ((ArrayList)paramObject).iterator();
        while (paramObject.hasNext())
        {
          GameDetailInfo localGameDetailInfo = (GameDetailInfo)paramObject.next();
          if ((!TextUtils.isEmpty(localGameDetailInfo.jdField_a_of_type_JavaLangString)) && (localGameDetailInfo.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a())))
          {
            GameMsgChatPie.a(this.a, localGameDetailInfo);
            GameMsgChatPie.a(this.a, GameMsgChatPie.a(this.a));
            if (GameMsgChatPie.a(this.a) != null)
            {
              ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).getGameStartPriority(GameMsgChatPie.a(this.a).c);
              GameMsgChatPie.e = GameMsgChatPie.a(this.a).c;
            }
            GameMsgChatPie.a(this.a, "onGameUsrInfoChangedNotify");
            GameMsgChatPie.b(this.a, GameMsgChatPie.a(this.a));
            QLog.i("GameMsgChatPie", 1, "update friend info.");
          }
          else if ((!TextUtils.isEmpty(localGameDetailInfo.jdField_a_of_type_JavaLangString)) && (localGameDetailInfo.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b())))
          {
            GameMsgChatPie.b(this.a, localGameDetailInfo);
            QLog.i("GameMsgChatPie", 1, "update my info.");
          }
        }
      }
      return;
    }
    catch (Throwable paramObject)
    {
      QLog.e("GameMsgChatPie", 1, paramObject.getMessage());
    }
  }
  
  protected void c(Object paramObject)
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
      QLog.i("GameMsgChatPie", 1, localStringBuilder.toString());
      GameMsgChatPie.a(this.a).updateRedDotConfig(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(), paramObject);
      return;
    }
    catch (Throwable paramObject)
    {
      QLog.e("GameMsgChatPie", 1, paramObject, new Object[0]);
    }
  }
  
  protected void d(Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onGetTopGrayTips], tips:");
      ((StringBuilder)localObject).append(paramObject);
      QLog.d("GameMsgChatPie", 2, ((StringBuilder)localObject).toString());
    }
    String str = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("game_msg_top_gray_text");
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = str;
      if ((paramObject instanceof String)) {
        localObject = (String)paramObject;
      }
    }
    GameMsgChatPie.d(this.a, (String)localObject);
    if ((GameMsgChatPie.a(this.a) != null) && (GameMsgChatPie.a(this.a).b == 0)) {
      GameMsgChatPie.b(this.a, (String)localObject);
    }
  }
  
  protected void e(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameMsgChatPie", 2, "[onGetPlayerAvatar]");
    }
    if (!(paramObject instanceof JSONArray))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NOT JSONArray return, avatarList:");
      ((StringBuilder)localObject).append(paramObject);
      QLog.w("GameMsgChatPie", 1, ((StringBuilder)localObject).toString());
      return;
    }
    paramObject = (JSONArray)paramObject;
    Object localObject = new ArrayList();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setAavarList], root:");
      localStringBuilder.append(paramObject);
      QLog.i("GameMsgChatPie", 1, localStringBuilder.toString());
      int j = paramObject.length();
      int i = 0;
      while (i < j)
      {
        ((ArrayList)localObject).add(paramObject.optString(i));
        i += 1;
      }
      paramObject = null;
      if (GameMsgChatPie.a(this.a) != null) {
        paramObject = GameMsgChatPie.a(this.a).getUnreadFriIcon();
      }
      if ((paramObject == null) || (paramObject.size() == 0))
      {
        GameMsgChatPie.a(this.a, (List)localObject, false);
        return;
      }
    }
    catch (Throwable paramObject)
    {
      QLog.w("GameMsgChatPie", 1, paramObject.getMessage());
    }
  }
  
  protected void f(Object paramObject)
  {
    Object localObject1;
    if ((paramObject != null) && ((paramObject instanceof JSONObject)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onGetAioPopInfo] data:");
      ((StringBuilder)localObject1).append(paramObject.toString());
      QLog.i("GameMsgChatPie", 1, ((StringBuilder)localObject1).toString());
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
              break label294;
            }
            localButtonInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("url");
            localButtonInfo.jdField_a_of_type_Int = localJSONObject.optInt("type");
            localArrayList.add(localButtonInfo);
            break label294;
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
          QLog.i("GameMsgChatPie", 1, "[onGetAioPopInfo] no button.");
          return;
        }
        return;
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
      }
      return;
      label294:
      i += 1;
    }
  }
  
  protected void g(Object paramObject)
  {
    String str;
    if (GameMsgChatPie.a(this.a) != null) {
      str = GameMsgChatPie.a(this.a).jdField_a_of_type_JavaLangString;
    } else {
      str = "";
    }
    GameMsgGrayTipsHandler.a(paramObject, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", str, 0L);
  }
  
  protected void h(Object paramObject)
  {
    QLog.i("GameMsgChatPie.strangerRecom", 1, "[onAddOrShiledFriendCallback]");
    try
    {
      ChatActivityUtils.b();
      if (paramObject == null)
      {
        QLog.w("GameMsgChatPie.strangerRecom", 1, "data is null.");
        return;
      }
      paramObject = (JSONObject)paramObject;
      int i = paramObject.optInt("ret_code");
      int j = paramObject.optInt("op_type");
      paramObject.optString("err_msg");
      if (i == 0)
      {
        paramObject = (GameMsgAddFriendHelper)this.a.a(113);
        if (1 == j)
        {
          GameMsgChatPie.a(this.a).recordAction();
          QQToast.a(this.a.a(), HardCodeUtil.a(2131692788), 1).a();
        }
        else if (2 == j)
        {
          paramObject.a(2131689943);
          if (GameMsgChatPie.a(this.a) != null) {
            GameMsgChatPie.a(this.a).c = 1;
          }
          GameMsgChatPie.a(this.a, true);
        }
        else if (4 == j)
        {
          paramObject.a(2131689944);
          if (GameMsgChatPie.a(this.a) != null) {
            GameMsgChatPie.a(this.a).c = 0;
          }
          GameMsgChatPie.a(this.a, false);
        }
        ((AddFriendHelper)GameMsgChatPie.a(this.a).a(113)).a(true, "");
        return;
      }
      paramObject = new StringBuilder();
      paramObject.append("[onAddOrShiledFriendCallback],FAILS! code:");
      paramObject.append(i);
      QLog.i("GameMsgChatPie.strangerRecom", 1, paramObject.toString());
      return;
    }
    catch (Throwable paramObject)
    {
      QLog.e("GameMsgChatPie", 1, paramObject, new Object[0]);
    }
  }
  
  protected void i(Object paramObject)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onGetStrangerRecomInfo], data:");
      ((StringBuilder)localObject1).append(paramObject);
      QLog.d("GameMsgChatPie.strangerRecom", 1, ((StringBuilder)localObject1).toString());
    }
    if ((paramObject != null) && ((paramObject instanceof JSONObject))) {}
    for (;;)
    {
      try
      {
        paramObject = (JSONObject)paramObject;
        Object localObject2 = paramObject.optString("uin");
        i = paramObject.optInt("relationship");
        int j = paramObject.optInt("add_friend_type");
        int k = paramObject.optInt("is_shield");
        paramObject = new StringBuilder();
        paramObject.append("relation:");
        paramObject.append(i);
        paramObject.append(",addFriendType:");
        paramObject.append(j);
        paramObject.append(",isShield:");
        paramObject.append(k);
        QLog.i("GameMsgChatPie.strangerRecom", 1, paramObject.toString());
        GameMsgChatPie.a(this.a, new GameMsgChatPie.StrangerRecomInfo());
        GameMsgChatPie.a(this.a).jdField_a_of_type_Int = i;
        GameMsgChatPie.a(this.a).b = j;
        GameMsgChatPie.a(this.a).c = k;
        GameMsgChatPie.a(this.a).jdField_a_of_type_JavaLangString = ((String)localObject2);
        GameMsgChatPie.a(this.a, GameMsgChatPie.a(this.a));
        ((AddFriendHelper)GameMsgChatPie.b(this.a).a(113)).e();
        GameMsgChatPie.b(this.a);
        GameMsgChatPie.a(this.a, i);
        localObject1 = ContactUtils.f(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, GameMsgChatPie.a(this.a).jdField_a_of_type_JavaLangString);
        paramObject = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramObject = GameMsgChatPie.a(this.a).e;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramObject;
        GameMsgChatPie.a(this.a, GameMsgChatPie.a(this.a));
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.a(this.a).c, "1", "145", "920", "92015", "207856", (String)localObject2, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "8", "");
        if ((GameMsgChatPie.a(this.a) != null) && (GameMsgChatPie.a(this.a).getVisibility() == 0) && (GameMsgChatPie.a(this.a) != null))
        {
          if (!GameMsgChatPie.c(this.a)) {
            break label697;
          }
          i = 1;
          j = GameMsgChatPie.a(this.a).jdField_a_of_type_Int;
          if (j == 0)
          {
            paramObject = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
            localObject1 = GameMsgChatPie.a(this.a).c;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(GameMsgChatPie.b(this.a));
            ((StringBuilder)localObject2).append("");
            localObject2 = ((StringBuilder)localObject2).toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(i);
            localStringBuilder.append("");
            paramObject.reportForGameMsg850((String)localObject1, "1", "145", "920", "92015", "207959", "8", (String)localObject2, localStringBuilder.toString(), GameMsgChatPie.a(this.a));
            return;
          }
          paramObject = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
          localObject1 = GameMsgChatPie.a(this.a).c;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(GameMsgChatPie.b(this.a));
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(i);
          localStringBuilder.append("");
          paramObject.reportForGameMsg850((String)localObject1, "1", "145", "920", "92005", "207957", "8", (String)localObject2, localStringBuilder.toString(), GameMsgChatPie.a(this.a));
          return;
        }
      }
      catch (Throwable paramObject)
      {
        QLog.e("GameMsgChatPie.strangerRecom", 1, paramObject, new Object[0]);
      }
      return;
      label697:
      int i = 0;
    }
  }
  
  protected void j(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {
      GameMsgChatPie.e(this.a, (String)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.1
 * JD-Core Version:    0.7.0.1
 */