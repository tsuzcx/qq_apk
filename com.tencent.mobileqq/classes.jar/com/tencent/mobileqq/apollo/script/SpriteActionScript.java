package com.tencent.mobileqq.apollo.script;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.ChannelConst;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.script.callback.ISpriteActionCallback;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.CheckPtvListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SpriteActionScript
  extends SpriteAioScript
{
  public SpriteActionScript(int paramInt, SpriteContext paramSpriteContext)
  {
    super(paramInt, paramSpriteContext);
  }
  
  private HandleResult d(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d != 0) {
        return null;
      }
      paramString = new JSONObject(paramString).optString("text");
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptManager.a().a(paramString);
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private HandleResult e(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("uinList");
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        a(paramString.optString(i), true);
        i += 1;
      }
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
    }
  }
  
  private HandleResult f(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d != 0) {
        return null;
      }
      int i = new JSONObject(paramString).optInt("status");
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[handleSpriteStatus], status:", Integer.valueOf(i) });
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptManager.a().b(i);
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptManager.a().a(i);
      return null;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private HandleResult g(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d != 0) {
        return null;
      }
      int i = new JSONObject(paramString).optInt("status");
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptManager.a().a(i);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private HandleResult h(String paramString)
  {
    int i;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      i = paramString.optInt("taskId");
      j = paramString.optInt("status");
      if (!QLog.isColorLevel()) {
        break label122;
      }
      QLog.d("cmshow_scripted_SpriteActionScript.callback", 2, new Object[] { "taskId:", Integer.valueOf(i), ",status:", Integer.valueOf(j) });
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
      break label148;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback.b(i);
      break label148;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback.a(i, j);
        break label148;
        label122:
        switch (j)
        {
        }
      }
    }
    label148:
    return null;
  }
  
  private HandleResult i(String paramString)
  {
    label118:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        JSONObject localJSONObject = new JSONObject();
        if ("pet".equals(paramString.getString("config_name")))
        {
          paramString = new JSONArray();
          ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getManager(152);
          if (localApolloManager.k == null) {
            break label118;
          }
          paramString = new JSONArray(localApolloManager.k);
          localJSONObject.put("petConfig", paramString);
          paramString = new HandleResult();
          paramString.b = true;
          paramString.jdField_a_of_type_JavaLangString = localJSONObject.toString();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "handleGetLocalData error:", paramString);
      }
      return null;
    }
  }
  
  private HandleResult j(String paramString)
  {
    int i = 0;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      j = paramString.optInt("from");
      if (!QLog.isColorLevel()) {
        break label180;
      }
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "handlePlayAction from:", Integer.valueOf(j) });
    }
    catch (JSONException paramString)
    {
      label69:
      Object localObject;
      paramString.printStackTrace();
      return null;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if (paramString != null)
    {
      paramString.a();
      return null;
      if (j == 0)
      {
        paramString = paramString.optString("uinList");
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = new JSONArray(paramString);
          paramString = new ArrayList();
        }
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject).length())
      {
        String str = ((JSONArray)localObject).optString(i);
        if (!TextUtils.isEmpty(str)) {
          paramString.add(str);
        }
      }
      else
      {
        if (paramString.size() != 0)
        {
          localObject = SpriteUtil.a(a());
          if (localObject != null)
          {
            ((SpriteRscBuilder)localObject).a(paramString);
            return null;
            label180:
            if (j == 1) {
              break;
            }
            if (j != 2) {
              break label69;
            }
            break;
          }
        }
        return null;
      }
      i += 1;
    }
  }
  
  private HandleResult k(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("from");
      int j = paramString.optInt("apolloStatus");
      int k = paramString.optInt("clickPart");
      paramString = paramString.optString("apolloId");
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "handleOnApolloClick", ",from:", Integer.valueOf(i), ",apolloStatus:", Integer.valueOf(j), ",clickPart:", Integer.valueOf(k), "apolloId:", paramString });
      }
      ISpriteDrawerInfoCallback localISpriteDrawerInfoCallback = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
      if (localISpriteDrawerInfoCallback != null) {
        localISpriteDrawerInfoCallback.a(j, k, paramString);
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public HandleResult a()
  {
    HandleResult localHandleResult;
    label248:
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = a();
        if (localQQAppInterface == null) {
          return null;
        }
        localHandleResult = new HandleResult();
        localHandleResult.b = true;
        JSONObject localJSONObject = new JSONObject();
        if ((1 == localQQAppInterface.c()) && (((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int != 3000)) || (((1 == localQQAppInterface.a()) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int == -2)) && (!localQQAppInterface.k()) && (!localQQAppInterface.l()) && (localQQAppInterface.m()) && (!MediaPlayerManager.a(localQQAppInterface).b()) && ((localQQAppInterface.a() == null) || (!localQQAppInterface.a().g())) && (!localQQAppInterface.c()))))
        {
          if (localQQAppInterface.a() == null) {
            break label248;
          }
          if (!localQQAppInterface.a().h())
          {
            break label248;
            localJSONObject.put("isAllowed", i);
            localHandleResult.jdField_a_of_type_JavaLangString = localJSONObject.toString();
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "isAllowPlayAudio:", Integer.valueOf(i) });
            break;
          }
        }
        SpriteUtil.b(localQQAppInterface);
        int i = 0;
        continue;
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, localThrowable, new Object[0]);
        return null;
      }
    }
    return localHandleResult;
  }
  
  public HandleResult a(long paramLong, String paramString1, String paramString2)
  {
    IApolloRenderView localIApolloRenderView = a();
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {}
    do
    {
      do
      {
        return null;
      } while ((localIApolloRenderView == null) || (localIApolloRenderView.getLuaState() != paramLong));
      if ((paramString1.startsWith("apollo_")) && (!paramString1.startsWith("cs.")) && (!paramString1.endsWith(".local")) && (!ChannelConst.a(paramString1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteActionScript", 2, "ssoCmdRule, [aio],cmd:" + paramString1);
        }
        ((VasExtensionHandler)localQQAppInterface.a(71)).a(paramString1, paramString2.toString(), paramLong, 4);
        return null;
      }
      if ("cs.script_action_status_notify.local".equals(paramString1)) {
        return h(paramString2);
      }
      if ("cs.script_change_panel_status.local".equals(paramString1)) {
        return g(paramString2);
      }
      if ("cs.script_get_dress_data.local".equals(paramString1)) {
        return e(paramString2);
      }
      if ("cs.script_sprite_status_change.local".equals(paramString1)) {
        return f(paramString2);
      }
      if ("cs.script_get_show_action.local".equals(paramString1)) {
        return a(paramString2);
      }
      if ("cs.script_is_allow_play_audio.local".equals(paramString1)) {
        return a();
      }
      if ("cs.script_show_barrage.local".equals(paramString1)) {
        return b(paramString2);
      }
      if ("cs.script_send_action_msg.local".equals(paramString1)) {
        return c(paramString2);
      }
      if ("cs.script_show_toast.local".equals(paramString1)) {
        return d(paramString2);
      }
      if ("cs.script_get_config.local".equals(paramString1)) {
        return i(paramString2);
      }
      if ("cs.script_play_action.local".equals(paramString1)) {
        return j(paramString2);
      }
    } while (!"cs.script_action_apollo_click.local".equals(paramString1));
    return k(paramString2);
  }
  
  public HandleResult a(String paramString)
  {
    HandleResult localHandleResult;
    JSONObject localJSONObject1;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d != 0) {
        return null;
      }
      paramString = new JSONObject(paramString);
      JSONArray localJSONArray1 = new JSONArray(paramString.optString("uinList"));
      JSONArray localJSONArray2 = new JSONArray();
      localHandleResult = new HandleResult();
      localHandleResult.b = true;
      localJSONObject1 = new JSONObject();
      int j = paramString.optInt("type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[handleGetShowAction] type:", Integer.valueOf(j) });
      }
      SpriteRscBuilder localSpriteRscBuilder = SpriteUtil.a(a());
      if (localSpriteRscBuilder != null)
      {
        int i = 0;
        if (i < localJSONArray1.length())
        {
          JSONObject localJSONObject2 = new JSONObject();
          Object localObject = localJSONArray1.optString(i);
          localJSONObject2.put("uin", localObject);
          if (j == 1) {
            localJSONObject2.put("petPath", localSpriteRscBuilder.a(new JSONArray(paramString.optString("actionList"))));
          }
          for (;;)
          {
            localJSONArray2.put(localJSONObject2);
            i += 1;
            break;
            localObject = localSpriteRscBuilder.a((String)localObject);
            localJSONObject2.put("path", ((Pair)localObject).first);
            localJSONObject2.put("actionType", ((Pair)localObject).second);
          }
        }
      }
      localJSONObject1.put("path", localJSONArray2);
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localHandleResult.jdField_a_of_type_JavaLangString = localJSONObject1.toString();
    return localHandleResult;
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d != 0) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyPanelStatusChanged], status:", Integer.valueOf(paramInt) });
        }
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("status", paramInt);
        ApolloCmdChannel.getChannel(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a()).callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getLuaState(), 0, "sc.script_panel_status_change.local", ((JSONObject)localObject).toString());
        localObject = "";
        if (1 == paramInt)
        {
          localObject = "panel_close_clk";
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), "cmshow", "Apollo", (String)localObject, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int), 0, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifyPanelStatusChanged],", localThrowable);
        return;
      }
      if (2 == paramInt) {
        String str = "panel_open_clk";
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyDrawRectChanged], width:", Integer.valueOf(paramInt1), ",height:", Integer.valueOf(paramInt2) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", paramInt1);
      localJSONObject.put("height", paramInt2);
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a()).callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getLuaState(), 0, "sc.script_draw_area_change.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", localThrowable);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[init], width:", Integer.valueOf(paramInt1), ",height:", Integer.valueOf(paramInt2), ",aioType:", Integer.valueOf(paramInt3), "friendUin:", paramString, ",spriteFrom:", Integer.valueOf(paramInt4) });
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) {
          return;
        }
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
        if (localQQAppInterface != null)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("platform", "android");
          localJSONObject.put("aioType", ApolloGameUtil.a(localQQAppInterface, paramInt3, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString));
          localJSONObject.put("friendUin", paramString);
          localJSONObject.put("width", paramInt1);
          localJSONObject.put("height", paramInt2);
          localJSONObject.put("screenW", DeviceInfoUtil.j());
          localJSONObject.put("screenH", DeviceInfoUtil.k());
          localJSONObject.put("qqVer", "7.6.0");
          localJSONObject.put("uin", this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.b);
          localJSONObject.put("density", DeviceInfoUtil.a);
          localJSONObject.put("wait", "def/basic/action/1/action/action");
          localJSONObject.put("standup", "def/basic/action/4/action/action");
          localJSONObject.put("think", "def/basic/action/3/action/action");
          localJSONObject.put("sitdown", "def/basic/action/2/action/action");
          if (!SpriteUtil.a(localQQAppInterface)) {
            break label623;
          }
          paramInt1 = 1;
          localJSONObject.put("isHide", paramInt1);
          paramString = new JSONArray();
          int[] arrayOfInt = new int[7];
          int[] tmp334_332 = arrayOfInt;
          tmp334_332[0] = 1;
          int[] tmp338_334 = tmp334_332;
          tmp338_334[1] = 2;
          int[] tmp342_338 = tmp338_334;
          tmp342_338[2] = 3;
          int[] tmp346_342 = tmp342_338;
          tmp346_342[3] = 4;
          int[] tmp350_346 = tmp346_342;
          tmp350_346[4] = 5;
          int[] tmp354_350 = tmp350_346;
          tmp354_350[5] = 6;
          int[] tmp359_354 = tmp354_350;
          tmp359_354[6] = 7;
          tmp359_354;
          paramInt2 = arrayOfInt.length;
          paramInt1 = i;
          if (paramInt1 < paramInt2)
          {
            paramString.put(ApolloActionHelper.a(1, Integer.valueOf(arrayOfInt[paramInt1]).intValue()));
            paramInt1 += 1;
            continue;
          }
          localJSONObject.put("defDress", paramString);
          localJSONObject.put("defRole", ApolloActionHelper.a(0, 0));
          localJSONObject.put("from", paramInt4);
          if ((paramInt4 == 1) || (paramInt4 == 2))
          {
            localJSONObject.put("drawer_up", "def/role/0/drawer/1/action/action");
            localJSONObject.put("drawer_down", "def/role/0/drawer/2/action/action");
            localJSONObject.put("friendcard_up", "def/role/0/friendcard/1/action/action");
            localJSONObject.put("friendcard_down", "def/role/0/friendcard/2/action/action");
            if (ApolloActionHelper.a(localQQAppInterface, 11, 3))
            {
              localJSONObject.put("drawer_pet_up", "def/role/0/drawer/3/action/action");
              localJSONObject.put("drawer_pet_down", "def/role/0/drawer/4/action/action");
            }
            paramString = (ApolloManager)localQQAppInterface.getManager(152);
            if (paramString != null) {
              localJSONObject.put("drawerGameBoxUser", paramString.e);
            }
          }
          paramString = new StringBuilder();
          paramString.append("if(commonInit){commonInit('").append(localJSONObject.toString()).append("');}");
          a(paramString.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmshow_scripted_SpriteActionScript", 1, "[getCommonInit], errInfo->", paramString);
      }
      return;
      label623:
      paramInt1 = 0;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifySpriteClicked], clickPart:", Integer.valueOf(paramInt), ",url:", paramString1 });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("clickPart", paramInt);
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("url", paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("apolloId", paramString2);
      }
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a()).callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getLuaState(), 0, "sc.script_on_sprite_single_clicked.local", localJSONObject.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteClicked],", paramString1);
    }
  }
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    JSONObject localJSONObject;
    try
    {
      QLog.i("cmshow_scripted_SpriteActionScript", 1, "[notifyStatusOrDressChanged], type:" + paramInt);
      localJSONObject = new JSONObject();
      localJSONObject.put("type", paramInt);
      JSONArray localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if (!TextUtils.isEmpty(str)) {
          localJSONArray.put(str);
        }
      }
      localJSONObject.put("uinList", localJSONArray);
    }
    catch (Throwable paramArrayList)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", paramArrayList);
      return;
    }
    ApolloCmdChannel.getChannel(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a()).callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getLuaState(), 0, "sc.script_user_dressOrStatus_changed.local", localJSONObject.toString());
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c()) || (!this.jdField_a_of_type_Boolean))
    {
      QLog.w("cmshow_scripted_SpriteActionScript", 1, "[notifyDressReady], surfaceView is destroyed. return");
      return;
    }
    try
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("[");
      int j = paramArrayOfInt.length;
      paramInt2 = 0;
      while (paramInt2 < j)
      {
        paramQQAppInterface.append(Integer.valueOf(paramArrayOfInt[paramInt2])).append(",");
        paramInt2 += 1;
      }
      paramQQAppInterface.append("]");
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyDressReady], uin:", paramString, "dress:", paramQQAppInterface });
      }
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("uin", paramString);
      paramQQAppInterface = new JSONArray();
      j = paramArrayOfInt.length;
      paramInt2 = i;
      while (paramInt2 < j)
      {
        paramQQAppInterface.put(ApolloActionHelper.a(1, Integer.valueOf(paramArrayOfInt[paramInt2]).intValue()));
        paramInt2 += 1;
      }
      localJSONObject2.put("dress", paramQQAppInterface);
      localJSONObject2.put("role", ApolloActionHelper.a(0, paramInt1));
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
      if (paramQQAppInterface != null)
      {
        paramString = paramQQAppInterface.a(paramString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, true);
        paramQQAppInterface = paramString;
        if (paramString == null) {
          paramQQAppInterface = new JSONObject();
        }
        localJSONObject2.put("pet", paramQQAppInterface);
      }
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("dressInfo", localJSONArray);
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a()).callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getLuaState(), 0, "sc.script_notify_dress_ready.local", localJSONObject1.toString());
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", paramQQAppInterface);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyAddBubble],text:", paramString2 });
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("text", new String(SpriteUtil.a(Base64Util.encodeToString(paramString2.getBytes("utf-8"), 0))));
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("uin", paramString1);
      }
      SpriteUtil.a(a());
      localJSONObject.put("bubble", SpriteRscBuilder.a(paramString2, 0));
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a()).callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getLuaState(), 0, "sc.script_add_bubble.local", localJSONObject.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifyAddBubble] ", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyAddBubble],text:", paramString2 });
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("text", paramString2);
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("uin", paramString1);
      }
      localJSONObject.put("bubble", SpriteRscBuilder.a(paramString2, 0, paramInt));
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a()).callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getLuaState(), 0, "sc.script_add_bubble.local", localJSONObject.toString());
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifyAddBubble] ", paramString1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyGameBoxStatusChanged],isGameBoxUser:", Boolean.valueOf(paramBoolean) });
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {
        i = 1;
      }
      localJSONObject.put("isGameBoxUser", i);
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a()).callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getLuaState(), 0, "sc.script_game_box_user_change.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifyGameBoxStatusChanged] ", localThrowable);
    }
  }
  
  public HandleResult b(String paramString)
  {
    IApolloRenderView localIApolloRenderView;
    try
    {
      localIApolloRenderView = a();
      if (localIApolloRenderView == null) {
        return null;
      }
      paramString = new JSONObject(paramString);
      if (1 == paramString.optInt("isShow"))
      {
        localIApolloRenderView.bulkApolloBarrages("", new String(Base64Util.decode(paramString.optString("text").getBytes("utf-8"), 0)), true);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localIApolloRenderView.removeAllApolloBarrages(true);
    return null;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() != null)) {
      a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getHeight(), this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d);
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifySpriteVisibility], status:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isShow", paramInt);
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a()).callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getLuaState(), 0, "sc.script_set_sprite_visibility.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", localThrowable);
    }
  }
  
  public HandleResult c(String paramString)
  {
    QQAppInterface localQQAppInterface;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d != 0) {
        return null;
      }
      paramString = SpriteUtil.a(paramString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
      localQQAppInterface = a();
      if ((paramString == null) || (localQQAppInterface == null)) {
        break label129;
      }
      SpriteActionMessage localSpriteActionMessage = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptManager.a();
      if ((localSpriteActionMessage != null) && (!localSpriteActionMessage.a(paramString)))
      {
        if (!QLog.isColorLevel()) {
          break label129;
        }
        QLog.d("cmshow_scripted_SpriteActionScript", 2, "Message can't be sent out without any slave.");
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, paramString, new Object[0]);
      return null;
    }
    localQQAppInterface.a().a(paramString, null);
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "send an action msg, actionId:", Integer.valueOf(paramString.mApolloMessage.id) });
    }
    label129:
    return null;
  }
  
  public void c(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteActionScript", 2, new Object[] { "[notifyUsrOperation], status:", Integer.valueOf(paramInt) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("status", paramInt);
      ApolloCmdChannel.getChannel(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a()).callbackFromRequest(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getLuaState(), 0, "sc.script_notify_user_operation.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteActionScript", 1, "[notifySpriteVisibility],", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionScript
 * JD-Core Version:    0.7.0.1
 */