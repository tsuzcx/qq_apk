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
import com.tencent.mobileqq.cmshow.engine.script.task.InitSpriteTask;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class SpriteDrawerInfoBridge
  implements ISpriteBridge
{
  private ISpriteTaskHandler jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteTaskHandler;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private SpriteRscBuilder jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  private SpriteScriptCreator jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator;
  private String jdField_a_of_type_JavaLangString;
  
  public SpriteDrawerInfoBridge(SpriteContext paramSpriteContext, ISpriteTaskHandler paramISpriteTaskHandler, SpriteRscBuilder paramSpriteRscBuilder, SpriteScriptCreator paramSpriteScriptCreator)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteTaskHandler = paramISpriteTaskHandler;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder = paramSpriteRscBuilder;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator = paramSpriteScriptCreator;
  }
  
  private boolean a(int paramInt)
  {
    SpriteContext localSpriteContext = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localSpriteContext != null)
    {
      if (localSpriteContext.a() == null) {
        return false;
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a(paramInt) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a() {}
  
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
    int i = localSpriteContext.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder != null) && (localSpriteContext.c()))
    {
      if (!a(0))
      {
        QLog.w("[cmshow][scripted]SpriteDrawerInfoBridge", 1, "[initSprite], fail to load script.");
        if (localSpriteContext.jdField_d_of_type_Int == 1) {
          ThreadManager.getUIHandler().post(new SpriteDrawerInfoBridge.2(this, localSpriteContext));
        }
        return;
      }
      boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
      paramISpriteContext = null;
      if (bool)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("initDrawerInfoSprite");
        if (localObject != null)
        {
          paramISpriteContext = ((InitSpriteTask)localObject).a();
          QLog.d("[cmshow][scripted]SpriteDrawerInfoBridge", 1, "drawer get spriteJs");
        }
        else
        {
          QLog.w("[cmshow][scripted]SpriteDrawerInfoBridge", 1, "drawer get spriteJs but initSpriteTask null");
        }
      }
      else
      {
        paramISpriteContext = this.jdField_a_of_type_JavaLangString;
        QLog.d("CmShowStatUtil", 1, "drawer spriteJs from cache");
        this.jdField_a_of_type_JavaLangString = null;
      }
      if (TextUtils.isEmpty(paramISpriteContext))
      {
        TraceReportUtil.a(i, 300, 301, new Object[] { "spriteJs is empty" });
        return;
      }
      Object localObject = (SpriteActionScript)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.b(0);
      if (localObject == null) {
        return;
      }
      TraceReportUtil.a(i, 350);
      localSpriteContext.a(paramISpriteContext);
      TraceReportUtil.a(i, 350, 0, new Object[] { "enter exeInitDrawerInfoSprite" });
      ThreadManager.executeOnSubThread(new SpriteDrawerInfoBridge.3(this, (SpriteActionScript)localObject, localSpriteContext));
      return;
    }
    TraceReportUtil.a(i, 300, 160, new Object[] { "glview is not ready" });
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
      if (localObject != null)
      {
        if (!((SpriteContext)localObject).c()) {
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
        SpriteRscBuilder.a(paramSpriteTaskParam.k, paramSpriteTaskParam.f, paramSpriteTaskParam.jdField_c_of_type_Int, paramSpriteTaskParam.h, paramSpriteTaskParam.jdField_d_of_type_Int, paramSpriteTaskParam.jdField_d_of_type_JavaLangString, paramSpriteTaskParam.jdField_a_of_type_Long);
        if (!a(paramSpriteTaskParam.jdField_c_of_type_Int))
        {
          QLog.w("[cmshow][scripted]SpriteDrawerInfoBridge", 1, "[playAction], fail to load script.");
          paramSpriteTaskParam.jdField_b_of_type_Int = 4;
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a(paramSpriteTaskParam, "playDrawerInfoAction");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramSpriteTaskParam.jdField_b_of_type_Int = 4;
          return;
        }
        SpriteAioScript localSpriteAioScript = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.b(paramSpriteTaskParam.jdField_c_of_type_Int);
        if (localSpriteAioScript == null)
        {
          QLog.w("[cmshow][scripted]SpriteDrawerInfoBridge", 1, "actionScript == null.");
          paramSpriteTaskParam.jdField_b_of_type_Int = 4;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteDrawerInfoBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramSpriteTaskParam.f) });
        }
        paramSpriteTaskParam.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a((String)localObject);
        localSpriteAioScript.a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
        localSpriteAioScript.a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
        ApolloActionHelperImpl.doActionReport(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), paramSpriteTaskParam, TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString) ^ true, paramSpriteTaskParam.jdField_b_of_type_Boolean);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteDrawerInfoBridge", 2, new Object[] { "[sendMsg], msg:", paramMessageRecord });
    }
  }
  
  public void b()
  {
    InitSpriteTask localInitSpriteTask = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a("initDrawerInfoSprite");
    if (localInitSpriteTask != null) {
      this.jdField_a_of_type_JavaLangString = localInitSpriteTask.a();
    }
  }
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.excute(new SpriteDrawerInfoBridge.1(this, paramSpriteTaskParam), 192, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoBridge
 * JD-Core Version:    0.7.0.1
 */