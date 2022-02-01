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
import com.tencent.mobileqq.cmshow.engine.action.PlayActionScript;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.ScriptUtils;
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
  private SpriteContext a;
  private ISpriteTaskHandler b;
  private SpriteRscBuilder c;
  private CopyOnWriteArrayList<WeakReference<ISpriteStatusChanged>> d;
  private SpriteScriptCreator e;
  private Script f;
  
  public SpriteBridge(SpriteContext paramSpriteContext, ISpriteTaskHandler paramISpriteTaskHandler, SpriteRscBuilder paramSpriteRscBuilder, SpriteScriptCreator paramSpriteScriptCreator)
  {
    this.a = paramSpriteContext;
    this.b = paramISpriteTaskHandler;
    this.c = paramSpriteRscBuilder;
    this.d = new CopyOnWriteArrayList();
    this.e = paramSpriteScriptCreator;
  }
  
  private void a(SpriteAioScript paramSpriteAioScript, SpriteTaskParam paramSpriteTaskParam)
  {
    paramSpriteAioScript.a(paramSpriteTaskParam.j, false);
    paramSpriteAioScript.a(paramSpriteTaskParam.k, false);
    if (paramSpriteTaskParam.c != 5) {
      return;
    }
    Gson localGson = new Gson();
    try
    {
      paramSpriteTaskParam = (ScriptResult)localGson.fromJson(paramSpriteTaskParam.t, new SpriteBridge.3(this).getType());
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
  
  private boolean b(int paramInt)
  {
    Object localObject1 = this.a;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (localObject1 != null)
    {
      if (((SpriteContext)localObject1).h == null) {
        return false;
      }
      localObject1 = (QQAppInterface)this.a.h.get();
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
  
  private String c(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return d();
    }
    if (!c(paramSpriteTaskParam.c))
    {
      QLog.w("[cmshow][scripted]SpriteBridge", 1, "[playAction], fail to load script.");
      paramSpriteTaskParam.b = 4;
      return d();
    }
    String str = this.c.a(paramSpriteTaskParam, null).e();
    if (TextUtils.isEmpty(str))
    {
      paramSpriteTaskParam.b = 4;
      return d();
    }
    return str;
  }
  
  private boolean c(int paramInt)
  {
    return this.e.a(paramInt) != null;
  }
  
  private String d()
  {
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.a = 0;
    localSpriteTaskParam.f = 4;
    localSpriteTaskParam.v = 2;
    localSpriteTaskParam.g = 5;
    localSpriteTaskParam.h = 1000000L;
    return this.c.a(localSpriteTaskParam, null).e();
  }
  
  private void e()
  {
    ThreadManager.getUIHandler().post(new SpriteBridge.4(this));
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((CopyOnWriteArrayList)localObject).size() == 0) {
        return;
      }
      localObject = this.d.iterator();
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
    int i = TraceReportUtil.c(0);
    if ((this.c != null) && ((paramISpriteContext instanceof SpriteContext)) && (paramISpriteContext.c()))
    {
      if (!c(0)) {
        return;
      }
      Object localObject = this.f;
      if (localObject == null)
      {
        localObject = this.a.d("initSprite");
        if (localObject != null)
        {
          localObject = ((InitSpriteTask)localObject).a();
          QLog.d("[cmshow][scripted]SpriteBridge", 1, "get spriteJs");
        }
        else
        {
          QLog.w("[cmshow][scripted]SpriteBridge", 1, "get spriteJs but initSpriteTask null");
          localObject = null;
        }
      }
      else
      {
        QLog.d("[cmshow][scripted]SpriteBridge", 1, "spriteJs from cache");
        this.f = null;
      }
      if (localObject == null)
      {
        TraceReportUtil.a(i, 300, 301, new Object[] { "spriteJs is empty" });
        return;
      }
      SpriteActionScript localSpriteActionScript = (SpriteActionScript)this.e.b(0);
      if (localSpriteActionScript == null) {
        return;
      }
      TraceReportUtil.a(i, 350);
      QLog.d("[cmshow][scripted]SpriteBridge", 1, "TraceReport CmShowStatUtil commitJS:(initSprite )");
      if (!paramISpriteContext.f()) {
        ((SpriteContext)paramISpriteContext).a((Script)localObject);
      }
      TraceReportUtil.a(i, 350, 0, new Object[] { "enter exeInitSprite" });
      ThreadManager.executeOnSubThread(new SpriteBridge.2(this, localSpriteActionScript, paramISpriteContext));
      return;
    }
    TraceReportUtil.a(i, 300, 160, new Object[] { "glview is not ready" });
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam != null) && (this.c != null))
    {
      Object localObject1 = this.a;
      if (localObject1 != null)
      {
        if (!((SpriteContext)localObject1).c()) {
          return;
        }
        if ((paramSpriteTaskParam.s != null) && (paramSpriteTaskParam.s.size() > 0) && (!this.a.s()))
        {
          QLog.w("[cmshow][scripted]SpriteBridge", 2, "[playAction], BackgroundSurface is not ready and add now");
          e();
          return;
        }
        localObject1 = this.a.q();
        if (localObject1 != null) {
          ((IApolloResManager)localObject1).a(paramSpriteTaskParam.v, paramSpriteTaskParam.f, paramSpriteTaskParam.c, paramSpriteTaskParam.i, paramSpriteTaskParam.d, paramSpriteTaskParam.t, paramSpriteTaskParam.h);
        }
        if (!c(paramSpriteTaskParam.c))
        {
          QLog.w("[cmshow][scripted]SpriteBridge", 1, "[playAction], fail to load script.");
          paramSpriteTaskParam.b = 4;
          return;
        }
        localObject1 = this.c.a(paramSpriteTaskParam, "playAction");
        if (localObject1 == null)
        {
          paramSpriteTaskParam.b = 4;
          return;
        }
        SpriteScriptManagerImpl localSpriteScriptManagerImpl = (SpriteScriptManagerImpl)this.a.l().getRuntimeService(ISpriteScriptManager.class, "all");
        Object localObject2 = localSpriteScriptManagerImpl.getSpriteCreator();
        if (localObject2 == null) {
          return;
        }
        localObject2 = ((SpriteScriptCreator)localObject2).b(paramSpriteTaskParam.c);
        if (localObject2 == null)
        {
          QLog.w("[cmshow][scripted]SpriteBridge", 1, "actionScript == null.");
          paramSpriteTaskParam.b = 4;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramSpriteTaskParam.f) });
        }
        paramSpriteTaskParam.b = 2;
        this.a.a((Script)localObject1);
        a((SpriteAioScript)localObject2, paramSpriteTaskParam);
        ApolloActionHelperImpl.doActionReport(this.a.l(), paramSpriteTaskParam, TextUtils.isEmpty(paramSpriteTaskParam.o) ^ true, paramSpriteTaskParam.q);
        localObject1 = localSpriteScriptManagerImpl.getSpriteBackgroundManager();
        if ((localObject1 != null) && (!SpriteUtil.d(this.a.l())))
        {
          if ((paramSpriteTaskParam.s != null) && (paramSpriteTaskParam.s.size() > 0))
          {
            ((SpriteBackgroundManager)localObject1).a(paramSpriteTaskParam.s);
            return;
          }
          ((SpriteBackgroundManager)localObject1).a();
        }
      }
    }
  }
  
  public void a(ISpriteStatusChanged paramISpriteStatusChanged)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.d;
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
    if ((paramChatMessage != null) && (this.a != null) && (this.b != null) && (paramArrayList1 != null))
    {
      if (paramArrayList1.size() == 0) {
        return;
      }
      if (!SpriteUtil.b(this.a.l(), paramChatMessage.istroop, paramChatMessage.frienduin)) {
        return;
      }
      SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
      localSpriteTaskParam.f = ((Integer)paramArrayList1.get(0)).intValue();
      localSpriteTaskParam.d = 1;
      localSpriteTaskParam.r = paramArrayList1;
      localSpriteTaskParam.s = paramArrayList2;
      localSpriteTaskParam.c = 1;
      localSpriteTaskParam.i = paramChatMessage.istroop;
      if (paramChatMessage.isSend()) {
        localSpriteTaskParam.g = 0;
      } else {
        localSpriteTaskParam.g = 1;
      }
      localSpriteTaskParam.l = paramChatMessage.isSend();
      localSpriteTaskParam.h = paramChatMessage.uniseq;
      if (CmShowAioMatcherImpl.judgeSupported(localSpriteTaskParam.i, 1))
      {
        if (paramChatMessage.isSend())
        {
          localSpriteTaskParam.j = paramChatMessage.selfuin;
          localSpriteTaskParam.k = paramChatMessage.frienduin;
        }
        else
        {
          localSpriteTaskParam.j = paramChatMessage.frienduin;
          localSpriteTaskParam.k = paramChatMessage.selfuin;
        }
      }
      else if (CmShowAioMatcherImpl.judgeSupported(localSpriteTaskParam.i, 2)) {
        localSpriteTaskParam.j = paramChatMessage.senderuin;
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
      if (!c(paramMessageRecord.actionType))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[sendMsg], fail to load script, actionType:");
        ((StringBuilder)localObject).append(paramMessageRecord.actionType);
        QLog.w("[cmshow][scripted]SpriteBridge", 1, ((StringBuilder)localObject).toString());
        return;
      }
      if ((!this.a.x()) && (this.a.d()))
      {
        localObject = ((ISpriteScriptManager)this.a.l().getRuntimeService(ISpriteScriptManager.class, "all")).getUIHandler();
        if (localObject != null) {
          ((ISpriteUIHandler)localObject).a(false, "none_apollo_play_action");
        }
      }
      paramMessageRecord = ScriptUtils.a(paramMessageRecord, b(paramMessageRecord.mApolloMessage.id));
      this.a.b(paramMessageRecord.toString());
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
      Object localObject = this.a;
      if (localObject != null)
      {
        if (this.b == null) {
          return;
        }
        if (!SpriteUtil.b(((SpriteContext)localObject).l(), paramMessageRecord.istroop, paramMessageRecord.frienduin)) {
          return;
        }
        localObject = new SpriteTaskParam();
        ((SpriteTaskParam)localObject).f = paramInt;
        ApolloActionData localApolloActionData = SpriteUtil.a(this.a.l(), paramInt);
        if (localApolloActionData != null)
        {
          ((SpriteTaskParam)localObject).c = localApolloActionData.actionType;
          ((SpriteTaskParam)localObject).e = localApolloActionData.personNum;
        }
        ((SpriteTaskParam)localObject).i = paramMessageRecord.istroop;
        if (paramMessageRecord.isSend()) {
          ((SpriteTaskParam)localObject).g = 0;
        } else {
          ((SpriteTaskParam)localObject).g = 1;
        }
        ((SpriteTaskParam)localObject).l = paramMessageRecord.isSend();
        ((SpriteTaskParam)localObject).h = paramMessageRecord.uniseq;
        if (CmShowAioMatcherImpl.judgeSupported(((SpriteTaskParam)localObject).i, 1))
        {
          if (paramMessageRecord.isSend())
          {
            ((SpriteTaskParam)localObject).j = paramMessageRecord.selfuin;
            ((SpriteTaskParam)localObject).k = paramMessageRecord.frienduin;
          }
          else
          {
            ((SpriteTaskParam)localObject).j = paramMessageRecord.frienduin;
            ((SpriteTaskParam)localObject).k = paramMessageRecord.selfuin;
          }
        }
        else if (CmShowAioMatcherImpl.judgeSupported(((SpriteTaskParam)localObject).i, 2)) {
          ((SpriteTaskParam)localObject).j = paramMessageRecord.senderuin;
        }
        b((SpriteTaskParam)localObject);
      }
    }
  }
  
  public void a(List<SpriteTaskParam> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0) && (this.c != null))
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        if (!((SpriteContext)localObject).c()) {
          return;
        }
        localObject = ((SpriteScriptManagerImpl)this.a.l().getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteCreator();
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
            ((JSONArray)localObject).put(new JSONObject(c(localSpriteTaskParam)));
            localSpriteAioScript.a(localSpriteTaskParam.j, false);
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
        this.a.b(paramList.toString());
      }
    }
  }
  
  public boolean a()
  {
    ISpriteTaskHandler localISpriteTaskHandler = this.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localISpriteTaskHandler != null) {
      if (!localISpriteTaskHandler.c())
      {
        bool1 = bool2;
        if (this.b.b() == null) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    InitSpriteTask localInitSpriteTask = this.a.d("initSprite");
    if (localInitSpriteTask != null) {
      this.f = localInitSpriteTask.a();
    }
  }
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.excute(new SpriteBridge.1(this, paramSpriteTaskParam), 192, null, true);
  }
  
  public void c()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.d;
    if (localCopyOnWriteArrayList != null) {
      localCopyOnWriteArrayList.clear();
    }
    this.f = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBridge
 * JD-Core Version:    0.7.0.1
 */