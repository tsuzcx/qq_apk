package com.tencent.mobileqq.apollo.script;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.model.ApolloSlaveActionInfo;
import com.tencent.mobileqq.apollo.model.ApolloSlaveInfo;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.model.ScriptResult;
import com.tencent.mobileqq.apollo.script.callback.ISpriteStatusChanged;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.script.ScriptUtil;
import com.tencent.mobileqq.cmshow.engine.script.task.InitSpriteTask;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpriteBridge
  implements ISpriteBridge
{
  private ISpriteTaskHandler jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteTaskHandler;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private SpriteRscBuilder jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  private SpriteScriptCreator jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator;
  private String jdField_a_of_type_JavaLangString;
  private CopyOnWriteArrayList<WeakReference<ISpriteStatusChanged>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public SpriteBridge(SpriteContext paramSpriteContext, ISpriteTaskHandler paramISpriteTaskHandler, SpriteRscBuilder paramSpriteRscBuilder, SpriteScriptCreator paramSpriteScriptCreator)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteTaskHandler = paramISpriteTaskHandler;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder = paramSpriteRscBuilder;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator = paramSpriteScriptCreator;
  }
  
  private String a()
  {
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.jdField_a_of_type_Int = 0;
    localSpriteTaskParam.f = 4;
    localSpriteTaskParam.k = 2;
    localSpriteTaskParam.g = 5;
    localSpriteTaskParam.jdField_a_of_type_Long = 1000000L;
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a(localSpriteTaskParam, null);
  }
  
  private String a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return a();
    }
    if (!b(paramSpriteTaskParam.jdField_c_of_type_Int))
    {
      QLog.w("[cmshow][scripted]SpriteBridge", 1, "[playAction], fail to load script.");
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return a();
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a(paramSpriteTaskParam, null);
    if (TextUtils.isEmpty(str))
    {
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return a();
    }
    return str;
  }
  
  private void a(SpriteAioScript paramSpriteAioScript, SpriteTaskParam paramSpriteTaskParam)
  {
    paramSpriteAioScript.a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
    paramSpriteAioScript.a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
    if (paramSpriteTaskParam.jdField_c_of_type_Int != 5) {
      return;
    }
    Gson localGson = new Gson();
    try
    {
      paramSpriteTaskParam = (ScriptResult)localGson.fromJson(paramSpriteTaskParam.jdField_d_of_type_JavaLangString, new SpriteBridge.3(this).getType());
      if (paramSpriteTaskParam != null)
      {
        if (paramSpriteTaskParam.data == null) {
          return;
        }
        ApolloSlaveActionInfo localApolloSlaveActionInfo = (ApolloSlaveActionInfo)paramSpriteTaskParam.data;
        localGson = null;
        paramSpriteTaskParam = localGson;
        if (localApolloSlaveActionInfo != null)
        {
          paramSpriteTaskParam = localGson;
          if (localApolloSlaveActionInfo.slaveInfoList != null)
          {
            paramSpriteTaskParam = localGson;
            if (localApolloSlaveActionInfo.slaveInfoList.size() > 0) {
              paramSpriteTaskParam = (ApolloSlaveInfo)localApolloSlaveActionInfo.slaveInfoList.get(0);
            }
          }
        }
        if (paramSpriteTaskParam == null) {
          return;
        }
        paramSpriteTaskParam = paramSpriteTaskParam.slaveList.iterator();
        while (paramSpriteTaskParam.hasNext()) {
          paramSpriteAioScript.a(String.valueOf(((Long)paramSpriteTaskParam.next()).longValue()), false);
        }
      }
      return;
    }
    catch (Exception paramSpriteAioScript)
    {
      QLog.i("[cmshow][scripted]SpriteBridge", 1, "[checkDressRsc] parser slave json error", paramSpriteAioScript);
    }
  }
  
  private boolean a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (localObject1 != null)
    {
      if (((SpriteContext)localObject1).b == null) {
        return false;
      }
      localObject1 = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.b.get();
      bool2 = bool3;
      if (localObject1 != null)
      {
        Object localObject2 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("apollo_action_random", 0);
        localObject1 = String.valueOf(paramInt);
        if (((SharedPreferences)localObject2).getInt((String)localObject1, -1) > 0) {
          bool1 = true;
        }
        bool2 = bool1;
        if (!bool1)
        {
          localObject2 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, paramInt);
          ((SharedPreferences.Editor)localObject2).commit();
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  private boolean b(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a(paramInt) != null;
  }
  
  private void c()
  {
    ThreadManager.getUIHandler().post(new SpriteBridge.4(this));
  }
  
  public void a()
  {
    InitSpriteTask localInitSpriteTask = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("initSprite");
    if (localInitSpriteTask != null) {
      this.jdField_a_of_type_JavaLangString = localInitSpriteTask.a();
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localObject != null)
    {
      if (((CopyOnWriteArrayList)localObject).size() == 0) {
        return;
      }
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ISpriteStatusChanged localISpriteStatusChanged = (ISpriteStatusChanged)((WeakReference)((Iterator)localObject).next()).get();
        if (localISpriteStatusChanged != null) {
          localISpriteStatusChanged.a(paramInt);
        }
      }
    }
  }
  
  public void a(int paramInt, MessageRecord paramMessageRecord)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(ISpriteContext paramISpriteContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteBridge", 2, "[initSprite]");
    }
    int i = TraceReportUtil.a(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder != null) && (paramISpriteContext != null) && (paramISpriteContext.c()))
    {
      if (!b(0)) {
        return;
      }
      boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
      String str = null;
      if (bool)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("initSprite");
        if (localObject != null)
        {
          str = ((InitSpriteTask)localObject).a();
          QLog.d("[cmshow][scripted]SpriteBridge", 1, "get spriteJs");
        }
        else
        {
          QLog.w("[cmshow][scripted]SpriteBridge", 1, "get spriteJs but initSpriteTask null");
        }
      }
      else
      {
        str = this.jdField_a_of_type_JavaLangString;
        QLog.d("[cmshow][scripted]SpriteBridge", 1, "spriteJs from cache");
        this.jdField_a_of_type_JavaLangString = null;
      }
      if (TextUtils.isEmpty(str))
      {
        TraceReportUtil.a(i, 300, 301, new Object[] { "spriteJs is empty" });
        return;
      }
      Object localObject = (SpriteActionScript)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.b(0);
      if (localObject == null) {
        return;
      }
      TraceReportUtil.a(i, 350);
      QLog.d("[cmshow][scripted]SpriteBridge", 1, "TraceReport CmShowStatUtil commitJS:(initSprite )");
      if (!paramISpriteContext.e()) {
        paramISpriteContext.a(str);
      }
      TraceReportUtil.a(i, 350, 0, new Object[] { "enter exeInitSprite" });
      ThreadManager.executeOnSubThread(new SpriteBridge.2(this, (SpriteActionScript)localObject, paramISpriteContext));
      return;
    }
    TraceReportUtil.a(i, 300, 160, new Object[] { "glview is not ready" });
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder != null))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
      if (localObject1 != null)
      {
        if (!((SpriteContext)localObject1).c()) {
          return;
        }
        if ((paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList != null) && (paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList.size() > 0) && (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.g()))
        {
          QLog.w("[cmshow][scripted]SpriteBridge", 2, "[playAction], BackgroundSurface is not ready and add now");
          c();
          return;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
        SpriteRscBuilder.a(paramSpriteTaskParam.k, paramSpriteTaskParam.f, paramSpriteTaskParam.jdField_c_of_type_Int, paramSpriteTaskParam.h, paramSpriteTaskParam.jdField_d_of_type_Int, paramSpriteTaskParam.jdField_d_of_type_JavaLangString, paramSpriteTaskParam.jdField_a_of_type_Long);
        if (!b(paramSpriteTaskParam.jdField_c_of_type_Int))
        {
          QLog.w("[cmshow][scripted]SpriteBridge", 1, "[playAction], fail to load script.");
          paramSpriteTaskParam.jdField_b_of_type_Int = 4;
          return;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a(paramSpriteTaskParam, "playAction");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramSpriteTaskParam.jdField_b_of_type_Int = 4;
          return;
        }
        SpriteScriptManagerImpl localSpriteScriptManagerImpl = (SpriteScriptManagerImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(ISpriteScriptManager.class, "all");
        Object localObject2 = localSpriteScriptManagerImpl.getSpriteCreator();
        if (localObject2 == null) {
          return;
        }
        localObject2 = ((SpriteScriptCreator)localObject2).b(paramSpriteTaskParam.jdField_c_of_type_Int);
        if (localObject2 == null)
        {
          QLog.w("[cmshow][scripted]SpriteBridge", 1, "actionScript == null.");
          paramSpriteTaskParam.jdField_b_of_type_Int = 4;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramSpriteTaskParam.f) });
        }
        paramSpriteTaskParam.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a((String)localObject1);
        a((SpriteAioScript)localObject2, paramSpriteTaskParam);
        ApolloActionHelperImpl.doActionReport(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), paramSpriteTaskParam, TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString) ^ true, paramSpriteTaskParam.jdField_b_of_type_Boolean);
        localObject1 = localSpriteScriptManagerImpl.getSpriteBackgroundManager();
        if ((localObject1 != null) && (!SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a())))
        {
          if ((paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList != null) && (paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList.size() > 0))
          {
            ((SpriteBackgroundManager)localObject1).a(paramSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList);
            return;
          }
          ((SpriteBackgroundManager)localObject1).a();
        }
      }
    }
  }
  
  public void a(ISpriteStatusChanged paramISpriteStatusChanged)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localCopyOnWriteArrayList == null) {
      return;
    }
    localCopyOnWriteArrayList.add(new WeakReference(paramISpriteStatusChanged));
  }
  
  public void a(ChatMessage paramChatMessage, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteBridge", 2, new Object[] { "[buildSpriteTask] actionList:", paramArrayList1, ", backgroundList:", paramArrayList2 });
    }
    if ((paramChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteTaskHandler != null) && (paramArrayList1 != null))
    {
      if (paramArrayList1.size() == 0) {
        return;
      }
      if (!SpriteUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), paramChatMessage.istroop, paramChatMessage.frienduin)) {
        return;
      }
      SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
      localSpriteTaskParam.f = ((Integer)paramArrayList1.get(0)).intValue();
      localSpriteTaskParam.jdField_d_of_type_Int = 1;
      localSpriteTaskParam.jdField_a_of_type_JavaUtilArrayList = paramArrayList1;
      localSpriteTaskParam.jdField_b_of_type_JavaUtilArrayList = paramArrayList2;
      localSpriteTaskParam.jdField_c_of_type_Int = 1;
      localSpriteTaskParam.h = paramChatMessage.istroop;
      if (paramChatMessage.isSend()) {
        localSpriteTaskParam.g = 0;
      } else {
        localSpriteTaskParam.g = 1;
      }
      localSpriteTaskParam.jdField_a_of_type_Boolean = paramChatMessage.isSend();
      localSpriteTaskParam.jdField_a_of_type_Long = paramChatMessage.uniseq;
      if (CmShowAioMatcherImpl.judgeSupported(localSpriteTaskParam.h, 1))
      {
        if (paramChatMessage.isSend())
        {
          localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.selfuin;
          localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.frienduin;
        }
        else
        {
          localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.frienduin;
          localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramChatMessage.selfuin;
        }
      }
      else if (CmShowAioMatcherImpl.judgeSupported(localSpriteTaskParam.h, 2)) {
        localSpriteTaskParam.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
      }
      b(localSpriteTaskParam);
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteBridge", 2, new Object[] { "[sendMsg], msg:", paramMessageRecord });
    }
    try
    {
      if (!(paramMessageRecord instanceof MessageForApollo)) {
        return;
      }
      paramMessageRecord = (MessageForApollo)paramMessageRecord;
      Object localObject;
      if (!b(paramMessageRecord.actionType))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[sendMsg], fail to load script, actionType:");
        ((StringBuilder)localObject).append(paramMessageRecord.actionType);
        QLog.w("[cmshow][scripted]SpriteBridge", 1, ((StringBuilder)localObject).toString());
        return;
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.i()) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d()))
      {
        localObject = ((ISpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(ISpriteScriptManager.class, "all")).getUIHandler();
        if (localObject != null) {
          ((ISpriteUIHandler)localObject).a(false, "none_apollo_play_action");
        }
      }
      paramMessageRecord = ScriptUtil.a(paramMessageRecord, a(paramMessageRecord.mApolloMessage.id));
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(paramMessageRecord.toString());
      return;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.e("[cmshow][scripted]SpriteBridge", 1, paramMessageRecord, new Object[0]);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    if (paramMessageRecord != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
      if (localObject != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteTaskHandler == null) {
          return;
        }
        if (!SpriteUtil.b(((SpriteContext)localObject).a(), paramMessageRecord.istroop, paramMessageRecord.frienduin)) {
          return;
        }
        localObject = new SpriteTaskParam();
        ((SpriteTaskParam)localObject).f = paramInt;
        ApolloActionData localApolloActionData = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), paramInt);
        if (localApolloActionData != null)
        {
          ((SpriteTaskParam)localObject).jdField_c_of_type_Int = localApolloActionData.actionType;
          ((SpriteTaskParam)localObject).e = localApolloActionData.personNum;
        }
        ((SpriteTaskParam)localObject).h = paramMessageRecord.istroop;
        if (paramMessageRecord.isSend()) {
          ((SpriteTaskParam)localObject).g = 0;
        } else {
          ((SpriteTaskParam)localObject).g = 1;
        }
        ((SpriteTaskParam)localObject).jdField_a_of_type_Boolean = paramMessageRecord.isSend();
        ((SpriteTaskParam)localObject).jdField_a_of_type_Long = paramMessageRecord.uniseq;
        if (CmShowAioMatcherImpl.judgeSupported(((SpriteTaskParam)localObject).h, 1))
        {
          if (paramMessageRecord.isSend())
          {
            ((SpriteTaskParam)localObject).jdField_a_of_type_JavaLangString = paramMessageRecord.selfuin;
            ((SpriteTaskParam)localObject).jdField_b_of_type_JavaLangString = paramMessageRecord.frienduin;
          }
          else
          {
            ((SpriteTaskParam)localObject).jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
            ((SpriteTaskParam)localObject).jdField_b_of_type_JavaLangString = paramMessageRecord.selfuin;
          }
        }
        else if (CmShowAioMatcherImpl.judgeSupported(((SpriteTaskParam)localObject).h, 2)) {
          ((SpriteTaskParam)localObject).jdField_a_of_type_JavaLangString = paramMessageRecord.senderuin;
        }
        b((SpriteTaskParam)localObject);
      }
    }
  }
  
  public void a(List<SpriteTaskParam> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
      if (localObject != null)
      {
        if (!((SpriteContext)localObject).c()) {
          return;
        }
        localObject = ((SpriteScriptManagerImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteCreator();
        if (localObject == null) {
          return;
        }
        SpriteAioScript localSpriteAioScript = ((SpriteScriptCreator)localObject).b(0);
        if (localSpriteAioScript == null)
        {
          QLog.w("[cmshow][scripted]SpriteBridge", 1, "actionScript == null.");
          return;
        }
        localObject = new JSONArray();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)paramList.next();
          try
          {
            ((JSONArray)localObject).put(new JSONObject(a(localSpriteTaskParam)));
            localSpriteAioScript.a(localSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
          }
          catch (Exception localException)
          {
            QLog.e("[cmshow][scripted]SpriteBridge", 1, "[playAction] e:", localException);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteBridge", 2, "[playAction], ready to play");
        }
        paramList = new StringBuilder();
        paramList.append("playShowAction('");
        paramList.append(((JSONArray)localObject).toString());
        paramList.append("');");
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(paramList.toString());
      }
    }
  }
  
  public void b()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localCopyOnWriteArrayList != null) {
      localCopyOnWriteArrayList.clear();
    }
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.excute(new SpriteBridge.1(this, paramSpriteTaskParam), 192, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBridge
 * JD-Core Version:    0.7.0.1
 */