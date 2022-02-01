package com.tencent.mobileqq.apollo.script;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.script.callback.ISpriteActionCallback;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.resource.IResourceService;
import com.tencent.mobileqq.cmshow.engine.resource.exception.ScriptNotFoundException;
import com.tencent.mobileqq.cmshow.engine.resource.exception.ScriptVerifyException;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.plugin.IEventPlugin;
import com.tencent.mobileqq.cmshow.engine.script.plugin.ServerSSOPlugin;
import com.tencent.mobileqq.cmshow.engine.script.plugin.SpriteAioPlugin;
import com.tencent.mobileqq.cmshow.engine.script.plugin.SpriteUiPlugin;
import com.tencent.mobileqq.cmshow.engine.script.plugin.TraceReportPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class SpriteAioScript
{
  protected int a;
  protected SpriteContext a;
  protected ISpriteActionCallback a;
  protected Script a;
  private ServerSSOPlugin jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginServerSSOPlugin = null;
  private SpriteAioPlugin jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginSpriteAioPlugin = null;
  private SpriteUiPlugin jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginSpriteUiPlugin = null;
  private TraceReportPlugin jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginTraceReportPlugin = null;
  protected String a;
  protected boolean a;
  
  public SpriteAioScript(int paramInt, SpriteContext paramSpriteContext)
  {
    this.jdField_a_of_type_Int = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cmshow_script_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".js");
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    paramSpriteContext = new StringBuilder();
    paramSpriteContext.append("[create script object], bid:");
    paramSpriteContext.append(paramInt);
    paramSpriteContext.append(",scriptName:");
    paramSpriteContext.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("[cmshow][scripted]SpriteAioScript", 1, paramSpriteContext.toString());
  }
  
  private void a(IEventPlugin paramIEventPlugin)
  {
    if (paramIEventPlugin != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
      if (localObject == null) {
        return;
      }
      localObject = ((SpriteContext)localObject).a();
      if (localObject != null) {
        ((IScriptService)localObject).b(paramIEventPlugin);
      }
    }
  }
  
  private void a(boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("[cmshow][scripted]SpriteAioScript", 1, "[checkThreeDress] error, app is null!");
      return;
    }
    int i = ((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramString);
    if (i != 2)
    {
      if (paramBoolean) {
        a(paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      return;
    }
    Object localObject = ApolloActionHelperImpl.get3DRoleDressIdByUin(paramString, i, a(), false);
    i = ((Integer)localObject[0]).intValue();
    if (localObject[1] == null) {
      localObject = null;
    } else {
      localObject = (int[])localObject[1];
    }
    if ((i > 0) && (localObject != null) && (localObject.length != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteAioScript", 2, new Object[] { "checkThreeDress roleId:", Integer.valueOf(paramInt1), ", dressIds:", Arrays.toString((int[])localObject) });
      }
      SpriteRscBuilder.b(paramQQAppInterface, paramString, i, (int[])localObject, new SpriteAioScript.2(this, paramBoolean, paramInt1, paramArrayOfInt));
      return;
    }
    if (paramBoolean) {
      a(paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2);
    }
  }
  
  private void b(boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    String str = ApolloActionHelperImpl.get3DFaceDataByUin(paramString, paramQQAppInterface);
    if (TextUtils.isEmpty(str))
    {
      if (paramBoolean) {
        a(paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteAioScript", 2, new Object[] { "checkThreeFaceDress faceData:", str });
    }
    SpriteRscBuilder.a(paramQQAppInterface, str, new SpriteAioScript.3(this, paramBoolean, paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2));
  }
  
  private boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
    if ((localObject != null) && (((SpriteContext)localObject).a() != null)) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptScript = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().a(this.jdField_a_of_type_Int);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Succeed to read script file, bid:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.i("[cmshow][scripted]SpriteAioScript", 1, ((StringBuilder)localObject).toString());
        return true;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[cmshow][scripted]SpriteAioScript", 1, "[loadScript]:", localThrowable);
        TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c(), 300, 30, new Object[] { "loadScript:", localThrowable });
        return false;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("[cmshow][scripted]SpriteAioScript", 1, "[loadScript],OOM:", localOutOfMemoryError);
        TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c(), 300, 150, new Object[] { "loadScript:", localOutOfMemoryError });
        return false;
      }
      catch (ScriptVerifyException localScriptVerifyException)
      {
        QLog.e("[cmshow][scripted]SpriteAioScript", 1, "Fail to verify script file.", localScriptVerifyException);
        d();
        TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c(), 300, 201, new Object[] { "Fail to verify script file:", localScriptVerifyException.getPath() });
        return false;
      }
      catch (ScriptNotFoundException localScriptNotFoundException)
      {
        QLog.e("[cmshow][scripted]SpriteAioScript", 1, "Fail to read script file.", localScriptNotFoundException);
        e();
        if (TextUtils.isEmpty(ApolloConstant.M))
        {
          TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c(), 300, 202, new Object[] { "Fail to read script file:", localScriptNotFoundException.getPath() });
          return false;
        }
        TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c(), 300, 200, new Object[] { "Fail to read script file:", localScriptNotFoundException.getPath() });
        return false;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readAndVerifyScript failed, spriteContext or resourceService null. bid:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.w("[cmshow][scripted]SpriteAioScript", 1, localStringBuilder.toString());
    return false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public QQAppInterface a()
  {
    SpriteContext localSpriteContext = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
    if (localSpriteContext == null) {
      return null;
    }
    return localSpriteContext.a();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ApolloConstant.N);
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public void a() {}
  
  public void a(ISpriteActionCallback paramISpriteActionCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback = paramISpriteActionCallback;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.w("[cmshow][scripted]SpriteAioScript", 2, "[checkDressRsc], script is NOT ready.");
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if ("0".equals(paramString)) {
        return;
      }
      QQAppInterface localQQAppInterface = a();
      if (localQQAppInterface == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteAioScript", 2, new Object[] { "[checkDressRsc], uin:", paramString, ",notifyIfExist:", Boolean.valueOf(paramBoolean) });
      }
      Object localObject = ApolloActionHelperImpl.getRoleDressIdByUin(paramString, a(), false);
      if (localObject != null)
      {
        if (localObject.length != 2) {
          return;
        }
        int i = ((Integer)localObject[0]).intValue();
        localObject = (int[])localObject[1];
        if (localObject != null)
        {
          if (localObject.length == 0) {
            return;
          }
          if (2 == ((ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(paramString))
          {
            if (paramBoolean) {
              a(localQQAppInterface, paramString, i, (int[])localObject, 0);
            }
            return;
          }
          SpriteRscBuilder.a(localQQAppInterface, paramString, i, (int[])localObject, new SpriteAioScript.1(this, paramBoolean));
        }
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("script is already read, scriptName:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("[cmshow][scripted]SpriteAioScript", 1, localStringBuilder.toString());
      return true;
    }
    this.jdField_a_of_type_Boolean = b();
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteAioScript", 2, new Object[] { "[loadScript], mIsLoaded:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    SpriteContext localSpriteContext = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
    if (localSpriteContext == null)
    {
      QLog.e("[cmshow][scripted]SpriteAioScript", 2, "[loadScript], error, mSpriteContext null");
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      localSpriteContext.a(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptScript);
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow][scripted]SpriteAioScript", 1, localThrowable, new Object[0]);
    }
  }
  
  protected void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
    if (localObject == null)
    {
      QLog.w("[cmshow][scripted]SpriteAioScript", 1, "addEventListener error, mSpriteContext null");
      return;
    }
    localObject = ((SpriteContext)localObject).a();
    if (localObject == null)
    {
      QLog.w("[cmshow][scripted]SpriteAioScript", 1, "addEventListener error, scriptService null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginServerSSOPlugin == null) {
      this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginServerSSOPlugin = new ServerSSOPlugin();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginTraceReportPlugin == null) {
      this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginTraceReportPlugin = new TraceReportPlugin(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginSpriteAioPlugin == null) {
      this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginSpriteAioPlugin = new SpriteAioPlugin(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, this, this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginSpriteUiPlugin == null) {
      this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginSpriteUiPlugin = new SpriteUiPlugin(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
    }
    ((IScriptService)localObject).a(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginServerSSOPlugin);
    ((IScriptService)localObject).a(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginTraceReportPlugin);
    ((IScriptService)localObject).a(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginSpriteAioPlugin);
    ((IScriptService)localObject).a(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginSpriteUiPlugin);
  }
  
  public void d()
  {
    QLog.w("[cmshow][scripted]SpriteAioScript", 1, "[onVerifyFailure], check base.zip");
    ApolloContentUpdateHandler.a(a());
  }
  
  public void e()
  {
    QLog.w("[cmshow][scripted]SpriteAioScript", 1, "[onScriptNotExists], redownload base.zip");
    ApolloContentUpdateHandler.a(a());
  }
  
  public void f()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginServerSSOPlugin);
    a(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginTraceReportPlugin);
    a(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginSpriteAioPlugin);
    a(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginSpriteUiPlugin);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback = null;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteAioScript
 * JD-Core Version:    0.7.0.1
 */