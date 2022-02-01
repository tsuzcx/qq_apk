package com.tencent.mobileqq.apollo.script;

import com.google.gson.Gson;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloSlaveActionInfo;
import com.tencent.mobileqq.apollo.model.ApolloSlaveInfo;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.model.ScriptResult;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class SpriteActionMessage
{
  private SpriteContext a;
  
  public SpriteActionMessage(SpriteContext paramSpriteContext)
  {
    this.a = paramSpriteContext;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new SpriteActionMessage.2(this, paramInt, paramBoolean));
  }
  
  private void a(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null)
    {
      QLog.e("[cmshow][scripted]SpriteActionMessage", 1, "[tiggerAction] actionData is null,return.");
      return;
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((SpriteContext)localObject).a() == null) {
        return;
      }
      localObject = new SpriteTaskParam();
      ((SpriteTaskParam)localObject).f = paramApolloActionData.actionId;
      ((SpriteTaskParam)localObject).jdField_c_of_type_Int = 0;
      ((SpriteTaskParam)localObject).g = 3;
      ((SpriteTaskParam)localObject).e = paramApolloActionData.personNum;
      ((SpriteTaskParam)localObject).jdField_a_of_type_Long = -10000L;
      ((SpriteTaskParam)localObject).jdField_a_of_type_Boolean = true;
      ((SpriteTaskParam)localObject).b = false;
      ((SpriteTaskParam)localObject).jdField_c_of_type_JavaLangString = paramApolloActionData.bubbleText;
      ((SpriteTaskParam)localObject).jdField_a_of_type_JavaLangString = String.valueOf(this.a.a().getCurrentAccountUin());
      ((ISpriteScriptManager)this.a.a().getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBridge().b((SpriteTaskParam)localObject);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(String paramString)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((SpriteContext)localObject).a() == null) {
        return;
      }
      localObject = SpriteUtil.a(this.a.a());
      if (localObject == null) {
        return;
      }
      ((SpriteActionScript)localObject).b("", paramString);
    }
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((SpriteContext)localObject).a() == null) {
        return;
      }
      localObject = this.a.a();
      ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(paramInt);
      String str = HardCodeUtil.a(2131714126);
      if (localApolloActionData == null)
      {
        a(str);
        return;
      }
      localApolloActionData.bubbleText = str;
      if (!CMResUtil.a(paramInt, localApolloActionData.personNum))
      {
        ((ApolloResManagerImpl)((QQAppInterface)localObject).getRuntimeService(IApolloResManager.class, "all")).downloadApolloRes(localApolloActionData, 4, null);
        a(str);
        return;
      }
      a(localApolloActionData);
    }
  }
  
  public boolean a(MessageForApollo paramMessageForApollo)
  {
    int i = paramMessageForApollo.actionType;
    boolean bool1 = true;
    boolean bool4 = true;
    boolean bool2 = bool1;
    if (i == 5)
    {
      Object localObject1 = this.a;
      bool2 = bool1;
      if (localObject1 != null)
      {
        if (((SpriteContext)localObject1).a() == null) {
          return true;
        }
        QQAppInterface localQQAppInterface = this.a.a();
        localObject1 = paramMessageForApollo.extendJson;
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteActionMessage", 2, new Object[] { "rep data:", localObject1 });
        }
        Object localObject2 = new Gson();
        localObject1 = null;
        try
        {
          paramMessageForApollo = (ScriptResult)((Gson)localObject2).fromJson(paramMessageForApollo.extendJson, new SpriteActionMessage.1(this).getType());
        }
        catch (Exception paramMessageForApollo)
        {
          QLog.e("[cmshow][scripted]SpriteActionMessage", 1, "[handleSendMsg] Exception", paramMessageForApollo);
          paramMessageForApollo = null;
        }
        int j;
        label273:
        boolean bool3;
        if ((paramMessageForApollo != null) && (paramMessageForApollo.data != null))
        {
          localObject2 = (ApolloSlaveActionInfo)paramMessageForApollo.data;
          paramMessageForApollo = (MessageForApollo)localObject1;
          if (localObject2 != null)
          {
            paramMessageForApollo = (MessageForApollo)localObject1;
            if (((ApolloSlaveActionInfo)localObject2).slaveInfoList != null)
            {
              paramMessageForApollo = (MessageForApollo)localObject1;
              if (((ApolloSlaveActionInfo)localObject2).slaveInfoList.size() > 0)
              {
                paramMessageForApollo = (MessageForApollo)localObject1;
                if (localQQAppInterface.getCurrentAccountUin().equals(String.valueOf(((ApolloSlaveInfo)((ApolloSlaveActionInfo)localObject2).slaveInfoList.get(0)).uin))) {
                  paramMessageForApollo = (ApolloSlaveInfo)((ApolloSlaveActionInfo)localObject2).slaveInfoList.get(0);
                }
              }
            }
          }
          if (paramMessageForApollo != null)
          {
            j = paramMessageForApollo.slaveTotal;
            i = j;
            if (paramMessageForApollo.isCaptured == 1)
            {
              bool1 = true;
              i = j;
              break label273;
            }
          }
          else
          {
            i = 0;
          }
          bool1 = false;
          a(i, bool1);
          bool2 = bool4;
          j = i;
          bool3 = bool1;
          if (!bool1)
          {
            bool2 = bool4;
            j = i;
            bool3 = bool1;
            if (i == 0)
            {
              a(((ApolloSlaveActionInfo)localObject2).defaultActId);
              bool2 = false;
              j = i;
              bool3 = bool1;
            }
          }
        }
        else
        {
          j = 0;
          bool3 = false;
          bool2 = bool4;
        }
        a(localQQAppInterface, j, bool3);
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteActionMessage
 * JD-Core Version:    0.7.0.1
 */