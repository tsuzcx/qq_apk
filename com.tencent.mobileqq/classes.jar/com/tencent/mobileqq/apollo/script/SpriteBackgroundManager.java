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
import com.tencent.mobileqq.cmshow.engine.script.Script;
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
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private ICMShowEngine jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentLinkedQueue jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public SpriteBackgroundManager(SpriteContext paramSpriteContext, ICMShowEngine paramICMShowEngine)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine = paramICMShowEngine;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteBackgroundManager", 2, new Object[] { "[execAction], ready to play, actionId:", Integer.valueOf(paramInt) });
    }
    IScriptService localIScriptService = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine.a();
    BackgroundPlayActionTask localBackgroundPlayActionTask = (BackgroundPlayActionTask)localIScriptService.a().a(ScriptTaskType.BACKGROUND_PLAY_ACTION);
    localBackgroundPlayActionTask.a(paramInt);
    localIScriptService.a(new Script(localBackgroundPlayActionTask.a()));
    this.jdField_a_of_type_JavaLangString = localBackgroundPlayActionTask.f();
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
    if (localObject == null)
    {
      QLog.e("[cmshow][scripted]SpriteBackgroundManager", 1, "[setBackgroundSurfaceVisibility] mCMShowEngine is null");
      return;
    }
    localObject = ((ICMShowEngine)localObject).a().a();
    if (localObject == null)
    {
      QLog.e("[cmshow][scripted]SpriteBackgroundManager", 1, "[setBackgroundSurfaceVisibility] cmShowView is null");
      return;
    }
    ThreadManager.getUIHandler().post(new SpriteBackgroundManager.1(this, (ICMShowView)localObject, paramInt));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine != null)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteBackgroundManager", 2, new Object[] { "removeBackgroundAction isRunning:", Boolean.valueOf(this.jdField_a_of_type_Boolean), ",actionName:", this.jdField_a_of_type_JavaLangString });
      }
      ConcurrentLinkedQueue localConcurrentLinkedQueue = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
      if ((localConcurrentLinkedQueue != null) && (!localConcurrentLinkedQueue.isEmpty())) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      }
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteBackgroundManager", 2, "[onCompleteRender]");
    }
    this.jdField_a_of_type_Boolean = false;
    paramString = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (paramString != null) {
        a(paramString.intValue());
      }
    }
    else if (!this.jdField_a_of_type_Boolean)
    {
      b(8);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteBackgroundManager", 2, "[onStartRender]");
    }
    this.jdField_a_of_type_Boolean = true;
    b(0);
  }
  
  public void a(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[execBackgroundListAction], actionList:");
      localStringBuilder.append(paramList);
      QLog.i("[cmshow][scripted]SpriteBackgroundManager", 1, localStringBuilder.toString());
      if (this.jdField_a_of_type_Boolean) {
        a();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.addAll(paramList);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
        return;
      }
      paramList = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (paramList != null) {
        a(paramList.intValue());
      }
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
    if (localObject != null)
    {
      if (((SpriteContext)localObject).a() == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteBackgroundManager", 2, "[onSurfaceReady]");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.h(true);
      localObject = (SpriteScriptManagerImpl)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(ISpriteScriptManager.class, "all");
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c()) && (!((SpriteScriptManagerImpl)localObject).getTaskHandler().a(null))) {
        e();
      }
    }
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ICMShowEngine localICMShowEngine = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
    if (localICMShowEngine != null) {
      localICMShowEngine.b();
    }
  }
  
  public void d()
  {
    ICMShowEngine localICMShowEngine = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
    if (localICMShowEngine != null) {
      localICMShowEngine.a();
    }
  }
  
  public void e()
  {
    b(8);
    a();
  }
  
  public void f()
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
    if (localConcurrentLinkedQueue != null) {
      localConcurrentLinkedQueue.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteBackgroundManager
 * JD-Core Version:    0.7.0.1
 */