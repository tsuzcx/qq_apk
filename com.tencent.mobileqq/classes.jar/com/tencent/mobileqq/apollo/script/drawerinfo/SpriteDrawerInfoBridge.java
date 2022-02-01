package com.tencent.mobileqq.apollo.script.drawerinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteAioScript;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.script.SpriteScriptCreator;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.task.InitSpriteTask;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class SpriteDrawerInfoBridge
  implements ISpriteBridge
{
  private SpriteContext a;
  private ISpriteTaskHandler b;
  private SpriteRscBuilder c;
  private SpriteScriptCreator d;
  private Script e;
  
  public SpriteDrawerInfoBridge(SpriteContext paramSpriteContext, ISpriteTaskHandler paramISpriteTaskHandler, SpriteRscBuilder paramSpriteRscBuilder, SpriteScriptCreator paramSpriteScriptCreator)
  {
    this.a = paramSpriteContext;
    this.b = paramISpriteTaskHandler;
    this.c = paramSpriteRscBuilder;
    this.d = paramSpriteScriptCreator;
  }
  
  private boolean a(int paramInt)
  {
    SpriteContext localSpriteContext = this.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localSpriteContext != null)
    {
      if (localSpriteContext.l() == null) {
        return false;
      }
      bool1 = bool2;
      if (this.d.a(paramInt) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a(int paramInt, @NotNull MessageRecord paramMessageRecord) {}
  
  public void a(ISpriteContext paramISpriteContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteDrawerInfoBridge", 2, "[initSprite]");
    }
    if (!(paramISpriteContext instanceof SpriteContext)) {
      return;
    }
    SpriteContext localSpriteContext = (SpriteContext)paramISpriteContext;
    int i = localSpriteContext.w();
    if ((this.c != null) && (localSpriteContext.c()))
    {
      if (!a(0))
      {
        QLog.w("[cmshow][scripted]SpriteDrawerInfoBridge", 1, "[initSprite], fail to load script.");
        if (localSpriteContext.i == 1) {
          ThreadManager.getUIHandler().post(new SpriteDrawerInfoBridge.2(this, localSpriteContext));
        }
        return;
      }
      paramISpriteContext = this.e;
      if (paramISpriteContext == null)
      {
        paramISpriteContext = this.a.d("initDrawerInfoSprite");
        if (paramISpriteContext != null)
        {
          paramISpriteContext = paramISpriteContext.a();
          QLog.d("[cmshow][scripted]SpriteDrawerInfoBridge", 1, "drawer get spriteJs");
        }
        else
        {
          QLog.w("[cmshow][scripted]SpriteDrawerInfoBridge", 1, "drawer get spriteJs but initSpriteTask null");
          paramISpriteContext = null;
        }
      }
      else
      {
        QLog.d("CmShowStatUtil", 1, "drawer spriteJs from cache");
        this.e = null;
      }
      if (paramISpriteContext == null)
      {
        TraceReportUtil.a(i, 300, 301, new Object[] { "spriteJs is empty" });
        return;
      }
      SpriteActionScript localSpriteActionScript = (SpriteActionScript)this.d.b(0);
      if (localSpriteActionScript == null) {
        return;
      }
      TraceReportUtil.a(i, 350);
      localSpriteContext.a(paramISpriteContext);
      TraceReportUtil.a(i, 350, 0, new Object[] { "enter exeInitDrawerInfoSprite" });
      ThreadManager.executeOnSubThread(new SpriteDrawerInfoBridge.3(this, localSpriteActionScript, localSpriteContext));
      return;
    }
    TraceReportUtil.a(i, 300, 160, new Object[] { "glview is not ready" });
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam != null) && (this.c != null))
    {
      Object localObject = this.a;
      if (localObject != null)
      {
        if (!((SpriteContext)localObject).c()) {
          return;
        }
        this.a.q().a(paramSpriteTaskParam.v, paramSpriteTaskParam.f, paramSpriteTaskParam.c, paramSpriteTaskParam.i, paramSpriteTaskParam.d, paramSpriteTaskParam.t, paramSpriteTaskParam.h);
        if (!a(paramSpriteTaskParam.c))
        {
          QLog.w("[cmshow][scripted]SpriteDrawerInfoBridge", 1, "[playAction], fail to load script.");
          paramSpriteTaskParam.b = 4;
          return;
        }
        localObject = this.c.a(paramSpriteTaskParam, "playDrawerInfoAction");
        if (localObject == null)
        {
          paramSpriteTaskParam.b = 4;
          return;
        }
        SpriteAioScript localSpriteAioScript = this.d.b(paramSpriteTaskParam.c);
        if (localSpriteAioScript == null)
        {
          QLog.w("[cmshow][scripted]SpriteDrawerInfoBridge", 1, "actionScript == null.");
          paramSpriteTaskParam.b = 4;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteDrawerInfoBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramSpriteTaskParam.f) });
        }
        paramSpriteTaskParam.b = 2;
        this.a.a((Script)localObject);
        localSpriteAioScript.a(paramSpriteTaskParam.j, false);
        localSpriteAioScript.a(paramSpriteTaskParam.k, false);
        ApolloActionHelperImpl.doActionReport(this.a.l(), paramSpriteTaskParam, TextUtils.isEmpty(paramSpriteTaskParam.o) ^ true, paramSpriteTaskParam.q);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteDrawerInfoBridge", 2, new Object[] { "[sendMsg], msg:", paramMessageRecord });
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.excute(new SpriteDrawerInfoBridge.1(this, paramSpriteTaskParam), 192, null, true);
  }
  
  public void c()
  {
    InitSpriteTask localInitSpriteTask = this.a.d("initDrawerInfoSprite");
    if (localInitSpriteTask != null) {
      this.e = localInitSpriteTask.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoBridge
 * JD-Core Version:    0.7.0.1
 */