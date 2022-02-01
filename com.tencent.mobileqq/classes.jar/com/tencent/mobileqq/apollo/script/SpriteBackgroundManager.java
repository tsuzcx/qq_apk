package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderCallback;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.script.task.BackgroundPlayActionTask;
import com.tencent.mobileqq.cmshow.engine.script.task.IScriptTaskBuilder;
import com.tencent.mobileqq.cmshow.engine.script.task.ScriptTaskType;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class SpriteBackgroundManager
  implements IRenderCallback
{
  private SpriteContext a;
  private ICMShowEngine b;
  private ConcurrentLinkedQueue c = new ConcurrentLinkedQueue();
  private String d;
  private volatile boolean e = false;
  
  public SpriteBackgroundManager(SpriteContext paramSpriteContext, ICMShowEngine paramICMShowEngine)
  {
    this.a = paramSpriteContext;
    this.b = paramICMShowEngine;
  }
  
  private void a(int paramInt)
  {
    if (this.b == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteBackgroundManager", 2, new Object[] { "[execAction], ready to play, actionId:", Integer.valueOf(paramInt) });
    }
    IScriptService localIScriptService = this.b.e();
    BackgroundPlayActionTask localBackgroundPlayActionTask = (BackgroundPlayActionTask)localIScriptService.b().a(ScriptTaskType.BACKGROUND_PLAY_ACTION);
    localBackgroundPlayActionTask.d(paramInt);
    localIScriptService.a(localBackgroundPlayActionTask.a());
    this.d = localBackgroundPlayActionTask.s();
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      QLog.e("[cmshow][scripted]SpriteBackgroundManager", 1, "[setBackgroundSurfaceVisibility] mCMShowEngine is null");
      return;
    }
    localObject = ((ICMShowEngine)localObject).c().a();
    if (localObject == null)
    {
      QLog.e("[cmshow][scripted]SpriteBackgroundManager", 1, "[setBackgroundSurfaceVisibility] cmShowView is null");
      return;
    }
    ThreadManager.getUIHandler().post(new SpriteBackgroundManager.1(this, (ICMShowView)localObject, paramInt));
  }
  
  public void a()
  {
    if (this.b != null)
    {
      if (this.d == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteBackgroundManager", 2, new Object[] { "removeBackgroundAction isRunning:", Boolean.valueOf(this.e), ",actionName:", this.d });
      }
      ConcurrentLinkedQueue localConcurrentLinkedQueue = this.c;
      if ((localConcurrentLinkedQueue != null) && (!localConcurrentLinkedQueue.isEmpty())) {
        this.c.clear();
      }
      if (this.e) {
        this.e = false;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteBackgroundManager", 2, "[onCompleteRender]");
    }
    this.e = false;
    paramString = this.c;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = (Integer)this.c.poll();
      if (paramString != null) {
        a(paramString.intValue());
      }
    }
    else if (!this.e)
    {
      b(8);
    }
  }
  
  public void a(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (this.c == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[execBackgroundListAction], actionList:");
      localStringBuilder.append(paramList);
      QLog.i("[cmshow][scripted]SpriteBackgroundManager", 1, localStringBuilder.toString());
      if (this.e) {
        a();
      }
      this.c.clear();
      this.c.addAll(paramList);
      if (this.c.isEmpty()) {
        return;
      }
      paramList = (Integer)this.c.poll();
      if (paramList != null) {
        a(paramList.intValue());
      }
    }
  }
  
  public void b()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((SpriteContext)localObject).l() == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteBackgroundManager", 2, "[onSurfaceReady]");
      }
      this.a.h(true);
      localObject = (SpriteScriptManagerImpl)this.a.l().getRuntimeService(ISpriteScriptManager.class, "all");
      if ((this.a.c()) && (!((SpriteScriptManagerImpl)localObject).getTaskHandler().a(null))) {
        e();
      }
    }
  }
  
  public void b_(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteBackgroundManager", 2, "[onStartRender]");
    }
    this.e = true;
    b(0);
  }
  
  public void c()
  {
    if (!this.e) {
      return;
    }
    ICMShowEngine localICMShowEngine = this.b;
    if (localICMShowEngine != null) {
      localICMShowEngine.l();
    }
  }
  
  public void d()
  {
    ICMShowEngine localICMShowEngine = this.b;
    if (localICMShowEngine != null) {
      localICMShowEngine.k();
    }
  }
  
  public void e()
  {
    b(8);
    a();
  }
  
  public void f()
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue = this.c;
    if (localConcurrentLinkedQueue != null) {
      localConcurrentLinkedQueue.clear();
    }
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBackgroundManager
 * JD-Core Version:    0.7.0.1
 */