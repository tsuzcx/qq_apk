package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.data.GameMsgGrayTipsHandler;
import com.tencent.mobileqq.gamecenter.message.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoObserver;
import com.tencent.mobileqq.gamecenter.util.GameMsgStrangerRules;
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
  
  public void a()
  {
    if (!GameMsgChatPie.b(this.a)) {
      GameMsgChatPie.a(this.a);
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    Object localObject;
    if ((paramObject != null) && ((paramObject instanceof JSONObject)))
    {
      QLog.i(GameMsgChatPie.f, 1, "[onGetGameStartPriority] data:" + paramObject.toString());
      try
      {
        paramObject = (JSONObject)paramObject;
        if (paramObject.optString("ret_code") != null)
        {
          localObject = paramObject.optJSONObject("download_info");
          if (localObject != null)
          {
            GameMsgChatPie.a(this.a, ((JSONObject)localObject).optString("pkg_name"));
            GameMsgChatPie.b(this.a, ((JSONObject)localObject).optString("ticket"));
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
              localObject = paramObject.optJSONObject(i);
              GameMsgChatPie.GamePriorityInfo localGamePriorityInfo = new GameMsgChatPie.GamePriorityInfo(null);
              localGamePriorityInfo.b = ((JSONObject)localObject).optString("content");
              localGamePriorityInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("icon_url");
              GameMsgChatPie.a(this.a).add(localGamePriorityInfo);
              i += 1;
            }
          }
        }
        if (GameMsgChatPie.a(this.a)) {
          break label316;
        }
      }
      catch (Exception paramObject)
      {
        QLog.e(GameMsgChatPie.f, 1, paramObject, new Object[0]);
      }
    }
    else if (GameMsgChatPie.a(this.a) != null)
    {
      localObject = GameMsgChatPie.a(this.a).d;
      if (GameMsgChatPie.a(this.a) != 1) {
        break label455;
      }
      paramObject = "1";
      GameMsgUtil.a((String)localObject, "1", "145", "920", "92005", "207561", paramObject, "", "8", "0");
      GameMsgChatPie.a(this.a, true);
    }
    label316:
    if ((this.a.a() != null) && (GameMsgChatPie.a(this.a) != null)) {}
    for (boolean bool = BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0).getBoolean(this.a.a().getCurrentUin() + "_game_msg_chatpie_reddot_click_" + GameMsgChatPie.a(this.a).d, false);; bool = false)
    {
      if ((GameMsgChatPie.a(this.a) == 1) && (!bool))
      {
        GameMsgUtil.a(GameMsgChatPie.a(this.a).d, "1", "145", "920", "92005", "207562", "", "", "8", "0");
        ThreadManagerV2.getUIHandlerV2().post(new GameMsgChatPie.1.1(this));
      }
      return;
      label455:
      paramObject = "0";
      break;
    }
  }
  
  public void b()
  {
    QLog.i(GameMsgChatPie.f, 1, "[onSetSwitchCallback]");
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
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 10007);
      if (localObject != null)
      {
        localObject = new TinyInfo(((Message)localObject).getExtInfoFromExtStr("ext_key_game_msg_info"));
        GameMsgGrayTipsHandler.a(localJSONArray, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.toString(((TinyInfo)localObject).fromTinyId), Long.toString(((TinyInfo)localObject).toTinyId), "");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(GameMsgChatPie.f, 1, localThrowable.getMessage());
    }
  }
  
  public void b(Object paramObject)
  {
    QLog.i(GameMsgChatPie.f, 1, "[onGameUsrInfoChangedNotify]");
    for (;;)
    {
      GameDetailInfo localGameDetailInfo;
      try
      {
        if ((paramObject instanceof ArrayList))
        {
          paramObject = ((ArrayList)paramObject).iterator();
          if (paramObject.hasNext())
          {
            localGameDetailInfo = (GameDetailInfo)paramObject.next();
            if ((TextUtils.isEmpty(localGameDetailInfo.b)) || (!localGameDetailInfo.b.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a()))) {
              break label199;
            }
            GameMsgChatPie.a(this.a, localGameDetailInfo);
            GameMsgChatPie.a(this.a, GameMsgChatPie.a(this.a));
            if (GameMsgChatPie.a(this.a) != null)
            {
              ((GameCenterUnissoHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GAME_CENTER_UNISSO_HANDLER)).a(GameMsgChatPie.a(this.a).d);
              GameMsgChatPie.h = GameMsgChatPie.a(this.a).d;
            }
            GameMsgChatPie.a(this.a, "onGameUsrInfoChangedNotify");
            GameMsgChatPie.b(this.a, GameMsgChatPie.a(this.a));
            QLog.i(GameMsgChatPie.f, 1, "update friend info.");
            continue;
          }
        }
        return;
      }
      catch (Throwable paramObject)
      {
        QLog.e(GameMsgChatPie.f, 1, paramObject.getMessage());
      }
      label199:
      if ((!TextUtils.isEmpty(localGameDetailInfo.b)) && (localGameDetailInfo.b.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b())))
      {
        GameMsgChatPie.b(this.a, localGameDetailInfo);
        QLog.i(GameMsgChatPie.f, 1, "update my info.");
      }
    }
  }
  
  public void c(Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = "";; paramObject = paramObject.toString()) {
      try
      {
        QLog.i(GameMsgChatPie.f, 1, "[onGetFriendExtInfo], data:" + paramObject);
        GameMsgChatPie.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(), paramObject);
        return;
      }
      catch (Throwable paramObject)
      {
        QLog.e(GameMsgChatPie.f, 1, paramObject, new Object[0]);
      }
    }
  }
  
  public void d(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GameMsgChatPie.f, 2, "[onGetTopGrayTips], tips:" + paramObject);
    }
    String str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("game_msg_top_gray_text");
    if ((TextUtils.isEmpty(str)) && ((paramObject instanceof String))) {}
    for (paramObject = (String)paramObject;; paramObject = str)
    {
      GameMsgChatPie.d(this.a, paramObject);
      if ((GameMsgChatPie.a(this.a) != null) && (GameMsgChatPie.a(this.a).b == 0)) {
        GameMsgChatPie.b(this.a, paramObject);
      }
      return;
    }
  }
  
  public void e(Object paramObject)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(GameMsgChatPie.f, 2, "[onGetPlayerAvatar]");
    }
    if (!(paramObject instanceof JSONArray)) {
      QLog.w(GameMsgChatPie.f, 1, "NOT JSONArray return, avatarList:" + paramObject);
    }
    for (;;)
    {
      return;
      paramObject = (JSONArray)paramObject;
      ArrayList localArrayList = new ArrayList();
      try
      {
        QLog.i(GameMsgChatPie.f, 1, "[setAavarList], root:" + paramObject);
        int j = paramObject.length();
        while (i < j)
        {
          localArrayList.add(paramObject.optString(i));
          i += 1;
        }
        paramObject = null;
        if (GameMsgChatPie.a(this.a) != null) {
          paramObject = GameMsgChatPie.a(this.a).c();
        }
        if ((paramObject == null) || (paramObject.size() == 0))
        {
          GameMsgChatPie.a(this.a, localArrayList, false);
          return;
        }
      }
      catch (Throwable paramObject)
      {
        QLog.w(GameMsgChatPie.f, 1, paramObject.getMessage());
      }
    }
  }
  
  public void f(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof JSONObject))) {
      QLog.i(GameMsgChatPie.f, 1, "[onGetAioPopInfo] data:" + paramObject.toString());
    }
    for (;;)
    {
      String str;
      ArrayList localArrayList;
      int i;
      try
      {
        Object localObject = (JSONObject)paramObject;
        paramObject = ((JSONObject)localObject).optString("title");
        str = ((JSONObject)localObject).optString("content");
        localObject = ((JSONObject)localObject).optJSONArray("buttons");
        if (TextUtils.isEmpty(str)) {
          break label288;
        }
        if (((JSONArray)localObject).length() == 0) {
          return;
        }
        localArrayList = new ArrayList();
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
          GameMsgChatPie.ButtonInfo localButtonInfo = new GameMsgChatPie.ButtonInfo(this.a);
          localButtonInfo.b = localJSONObject.optString("title");
          if (TextUtils.isEmpty(localButtonInfo.b)) {
            break label289;
          }
          localButtonInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("url");
          localButtonInfo.jdField_a_of_type_Int = localJSONObject.optInt("type");
          localArrayList.add(localButtonInfo);
        }
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
      if (localArrayList.size() == 1)
      {
        GameMsgChatPie.a(this.a, paramObject, str, (GameMsgChatPie.ButtonInfo)localArrayList.get(0), null);
        return;
      }
      if (localArrayList.size() >= 2)
      {
        GameMsgChatPie.a(this.a, paramObject, str, (GameMsgChatPie.ButtonInfo)localArrayList.get(0), (GameMsgChatPie.ButtonInfo)localArrayList.get(1));
        return;
      }
      QLog.i(GameMsgChatPie.f, 1, "[onGetAioPopInfo] no button.");
      label288:
      return;
      label289:
      i += 1;
    }
  }
  
  public void g(Object paramObject)
  {
    String str = "";
    if (GameMsgChatPie.a(this.a) != null) {
      str = GameMsgChatPie.a(this.a).jdField_a_of_type_JavaLangString;
    }
    GameMsgGrayTipsHandler.a(paramObject, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", str);
  }
  
  public void h(Object paramObject)
  {
    QLog.i(GameMsgChatPie.g, 1, "[onAddOrShiledFriendCallback]");
    int i;
    for (;;)
    {
      int j;
      try
      {
        ChatActivityUtils.b();
        if (paramObject == null)
        {
          QLog.w(GameMsgChatPie.g, 1, "data is null.");
          return;
        }
        paramObject = (JSONObject)paramObject;
        i = paramObject.optInt("ret_code");
        j = paramObject.optInt("op_type");
        paramObject.optString("err_msg");
        if (i != 0) {
          break;
        }
        if (1 == j)
        {
          GameMsgChatPie.a(this.a).b();
          QQToast.a(this.a.a(), HardCodeUtil.a(2131692834), 1).a();
          this.a.a(true, "");
          return;
        }
      }
      catch (Throwable paramObject)
      {
        QLog.e(GameMsgChatPie.f, 1, paramObject, new Object[0]);
        return;
      }
      if (2 == j)
      {
        GameMsgChatPie.a(this.a).setText(this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690028));
        if (GameMsgChatPie.a(this.a) != null) {
          GameMsgChatPie.a(this.a).c = 1;
        }
        GameMsgChatPie.a(this.a, true);
      }
      else if (4 == j)
      {
        GameMsgChatPie.b(this.a).setText(this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690029));
        if (GameMsgChatPie.a(this.a) != null) {
          GameMsgChatPie.a(this.a).c = 0;
        }
        GameMsgChatPie.a(this.a, false);
      }
    }
    QLog.i(GameMsgChatPie.g, 1, "[onAddOrShiledFriendCallback],FAILS! code:" + i);
  }
  
  public void i(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GameMsgChatPie.g, 1, "[onGetStrangerRecomInfo], data:" + paramObject);
    }
    if ((paramObject != null) && ((paramObject instanceof JSONObject))) {}
    for (;;)
    {
      try
      {
        paramObject = (JSONObject)paramObject;
        String str2 = paramObject.optString("uin");
        i = paramObject.optInt("relationship");
        int j = paramObject.optInt("add_friend_type");
        int k = paramObject.optInt("is_shield");
        QLog.i(GameMsgChatPie.g, 1, "relation:" + i + ",addFriendType:" + j + ",isShield:" + k);
        GameMsgChatPie.a(this.a, new GameMsgChatPie.StrangerRecomInfo());
        GameMsgChatPie.a(this.a).jdField_a_of_type_Int = i;
        GameMsgChatPie.a(this.a).b = j;
        GameMsgChatPie.a(this.a).c = k;
        GameMsgChatPie.a(this.a).jdField_a_of_type_JavaLangString = str2;
        GameMsgChatPie.a(this.a, GameMsgChatPie.a(this.a));
        this.a.p();
        GameMsgChatPie.b(this.a);
        GameMsgChatPie.a(this.a, i);
        String str1 = ContactUtils.l(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, GameMsgChatPie.a(this.a).jdField_a_of_type_JavaLangString);
        paramObject = str1;
        if (TextUtils.isEmpty(str1)) {
          paramObject = GameMsgChatPie.a(this.a).f;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramObject;
        GameMsgChatPie.a(this.a, GameMsgChatPie.a(this.a));
        GameMsgUtil.a(GameMsgChatPie.a(this.a).d, "1", "145", "920", "92015", "207856", str2, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "8", "");
        if ((GameMsgChatPie.a(this.a) != null) && (GameMsgChatPie.a(this.a).getVisibility() == 0) && (GameMsgChatPie.a(this.a) != null))
        {
          if (!GameMsgChatPie.c(this.a)) {
            break label567;
          }
          i = 1;
          if (GameMsgChatPie.a(this.a).jdField_a_of_type_Int == 0)
          {
            GameMsgUtil.b(GameMsgChatPie.a(this.a).d, "1", "145", "920", "92015", "207959", "8", GameMsgChatPie.b(this.a) + "", i + "", GameMsgChatPie.a(this.a));
            return;
          }
          GameMsgUtil.b(GameMsgChatPie.a(this.a).d, "1", "145", "920", "92005", "207957", "8", GameMsgChatPie.b(this.a) + "", i + "", GameMsgChatPie.a(this.a));
          return;
        }
      }
      catch (Throwable paramObject)
      {
        QLog.e(GameMsgChatPie.g, 1, paramObject, new Object[0]);
      }
      return;
      label567:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie.1
 * JD-Core Version:    0.7.0.1
 */