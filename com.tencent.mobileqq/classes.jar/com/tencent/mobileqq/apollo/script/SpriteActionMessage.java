package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloSlaveInfo;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpriteActionMessage
{
  private SpriteContext a;
  
  public SpriteActionMessage(SpriteContext paramSpriteContext)
  {
    this.a = paramSpriteContext;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new SpriteActionMessage.1(this, paramInt, paramBoolean));
  }
  
  private void a(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      QLog.e("cmshow_scripted_SpriteActionMessage", 1, "[tiggerAction] actionData is null,return.");
    }
    SpriteTaskParam localSpriteTaskParam;
    do
    {
      return;
      localSpriteTaskParam = new SpriteTaskParam();
      localSpriteTaskParam.f = paramApolloActionData.actionId;
      localSpriteTaskParam.jdField_c_of_type_Int = 0;
      localSpriteTaskParam.g = 3;
      localSpriteTaskParam.e = paramApolloActionData.personNum;
      localSpriteTaskParam.jdField_a_of_type_Long = -10000L;
      localSpriteTaskParam.jdField_a_of_type_Boolean = true;
      localSpriteTaskParam.b = false;
      localSpriteTaskParam.jdField_c_of_type_JavaLangString = paramApolloActionData.bubbleText;
    } while ((this.a == null) || (this.a.a() == null));
    localSpriteTaskParam.jdField_a_of_type_JavaLangString = String.valueOf(this.a.a().getCurrentAccountUin());
    ((ISpriteScriptManager)this.a.a().getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBridge().b(localSpriteTaskParam);
  }
  
  private void a(String paramString)
  {
    SpriteActionScript localSpriteActionScript;
    if ((this.a != null) && (this.a.a() != null))
    {
      localSpriteActionScript = SpriteUtil.a(this.a.a());
      if (localSpriteActionScript != null) {}
    }
    else
    {
      return;
    }
    localSpriteActionScript.a("", paramString);
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if ((this.a == null) || (this.a.a() == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.a.a();
    ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramInt);
    String str = HardCodeUtil.a(2131714197);
    if (localApolloActionData == null)
    {
      a(str);
      return;
    }
    localApolloActionData.bubbleText = str;
    if (!ApolloUtilImpl.isActionResDone(paramInt, localApolloActionData.personNum))
    {
      ((ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).downloadApolloRes(localApolloActionData, 4, null);
      a(str);
      return;
    }
    a(localApolloActionData);
  }
  
  public boolean a(MessageForApollo paramMessageForApollo)
  {
    int k = 2;
    int j = 0;
    if ((paramMessageForApollo.actionType != 5) || (this.a == null) || (this.a.a() == null)) {
      return true;
    }
    QQAppInterface localQQAppInterface = this.a.a();
    String str1 = paramMessageForApollo.extendJson;
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteActionMessage", 2, new Object[] { "rep data:", str1 });
    }
    for (;;)
    {
      int i;
      boolean bool1;
      boolean bool2;
      try
      {
        paramMessageForApollo = new JSONObject(paramMessageForApollo.extendJson);
        if (!paramMessageForApollo.has("data")) {
          break label337;
        }
        String str2 = localQQAppInterface.getCurrentAccountUin();
        JSONObject localJSONObject = paramMessageForApollo.getJSONObject("data");
        JSONArray localJSONArray = localJSONObject.getJSONArray("slaveInfoList");
        Object localObject = null;
        str1 = null;
        paramMessageForApollo = localObject;
        if (localJSONArray != null)
        {
          paramMessageForApollo = localObject;
          if (localJSONArray.length() > 0)
          {
            i = 0;
            paramMessageForApollo = str1;
            if (i < localJSONArray.length())
            {
              paramMessageForApollo = (ApolloSlaveInfo)JSONUtils.a(localJSONArray.getJSONObject(i), ApolloSlaveInfo.class);
              if ((paramMessageForApollo == null) || (!str2.equals(String.valueOf(paramMessageForApollo.uin)))) {
                continue;
              }
            }
          }
        }
        if (paramMessageForApollo == null) {
          break label329;
        }
        i = paramMessageForApollo.slaveTotal;
        if (paramMessageForApollo.isCaptured == 1)
        {
          bool1 = true;
          int m = localJSONObject.optInt("defaultActId");
          a(i, bool1);
          if ((bool1) || (i != 0)) {
            break label323;
          }
          a(m);
          bool2 = false;
          break label348;
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clickslaveaction", j, i, new String[0]);
          return bool2;
          i += 1;
          continue;
        }
        bool1 = false;
        continue;
        if (i > 0) {
          i = k;
        } else {
          i = 3;
        }
      }
      catch (Exception paramMessageForApollo)
      {
        QLog.i("cmshow_scripted_SpriteActionMessage", 1, "[handleSendMsg] Exception", paramMessageForApollo);
        return true;
      }
      if (i == 0)
      {
        i = 0;
      }
      else
      {
        i = 1;
        break label360;
        label323:
        bool2 = true;
        break label348;
        label329:
        bool1 = false;
        i = 0;
        continue;
        label337:
        bool1 = false;
        i = 0;
        bool2 = true;
        break label360;
        label348:
        if (!bool1) {
          continue;
        }
        if (i < 5) {
          continue;
        }
        i = 1;
      }
      label360:
      if (bool1) {
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionMessage
 * JD-Core Version:    0.7.0.1
 */