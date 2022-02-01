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
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
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
  protected Script a;
  protected int b;
  protected String c;
  protected boolean d;
  protected ISpriteActionCallback e;
  protected SpriteContext f;
  private ServerSSOPlugin g = null;
  private TraceReportPlugin h = null;
  private SpriteAioPlugin i = null;
  private SpriteUiPlugin j = null;
  
  public SpriteAioScript(int paramInt, SpriteContext paramSpriteContext)
  {
    this.b = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cmshow_script_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".js");
    this.c = localStringBuilder.toString();
    this.f = paramSpriteContext;
    paramSpriteContext = new StringBuilder();
    paramSpriteContext.append("[create script object], bid:");
    paramSpriteContext.append(paramInt);
    paramSpriteContext.append(",scriptName:");
    paramSpriteContext.append(this.c);
    QLog.i("[cmshow][scripted]SpriteAioScript", 1, paramSpriteContext.toString());
  }
  
  private void a(IEventPlugin paramIEventPlugin)
  {
    if (paramIEventPlugin != null)
    {
      Object localObject = this.f;
      if (localObject == null) {
        return;
      }
      localObject = ((SpriteContext)localObject).o();
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
    int k = ((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(paramString);
    if (k != 2)
    {
      if (paramBoolean) {
        a(paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      return;
    }
    IApolloResManager localIApolloResManager = j();
    if (localIApolloResManager == null)
    {
      QLog.e("[cmshow][scripted]SpriteAioScript", 1, "checkThreeFaceDress error, apolloResManager is null!");
      return;
    }
    Object localObject = ApolloActionHelperImpl.get3DRoleDressIdByUin(paramString, k, b(), false, localIApolloResManager);
    k = ((Integer)localObject[0]).intValue();
    if (localObject[1] == null) {
      localObject = null;
    } else {
      localObject = (int[])localObject[1];
    }
    if ((k > 0) && (localObject != null) && (localObject.length != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteAioScript", 2, new Object[] { "checkThreeDress roleId:", Integer.valueOf(paramInt1), ", dressIds:", Arrays.toString((int[])localObject) });
      }
      localIApolloResManager.c(paramQQAppInterface, paramString, k, (int[])localObject, new SpriteAioScript.2(this, paramBoolean, paramInt1, paramArrayOfInt));
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
    IApolloResManager localIApolloResManager = j();
    if (localIApolloResManager == null)
    {
      QLog.e("[cmshow][scripted]SpriteAioScript", 1, "checkThreeFaceDress error, apolloResManager is null!");
      return;
    }
    localIApolloResManager.a(paramQQAppInterface, str, new SpriteAioScript.3(this, paramBoolean, paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2));
  }
  
  private boolean k()
  {
    Object localObject = this.f;
    if ((localObject != null) && (((SpriteContext)localObject).p() != null)) {
      try
      {
        this.a = this.f.p().a(this.b);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Succeed to read script file, bid:");
        ((StringBuilder)localObject).append(this.b);
        QLog.i("[cmshow][scripted]SpriteAioScript", 1, ((StringBuilder)localObject).toString());
        return true;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[cmshow][scripted]SpriteAioScript", 1, "[loadScript]:", localThrowable);
        TraceReportUtil.a(this.f.w(), 300, 30, new Object[] { "loadScript:", localThrowable });
        return false;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("[cmshow][scripted]SpriteAioScript", 1, "[loadScript],OOM:", localOutOfMemoryError);
        TraceReportUtil.a(this.f.w(), 300, 150, new Object[] { "loadScript:", localOutOfMemoryError });
        return false;
      }
      catch (ScriptVerifyException localScriptVerifyException)
      {
        QLog.e("[cmshow][scripted]SpriteAioScript", 1, "Fail to verify script file.", localScriptVerifyException);
        g();
        TraceReportUtil.a(this.f.w(), 300, 201, new Object[] { "Fail to verify script file:", localScriptVerifyException.getPath() });
        return false;
      }
      catch (ScriptNotFoundException localScriptNotFoundException)
      {
        QLog.e("[cmshow][scripted]SpriteAioScript", 1, "Fail to read script file.", localScriptNotFoundException);
        h();
        if (TextUtils.isEmpty(ApolloConstant.U))
        {
          TraceReportUtil.a(this.f.w(), 300, 202, new Object[] { "Fail to read script file:", localScriptNotFoundException.getPath() });
          return false;
        }
        TraceReportUtil.a(this.f.w(), 300, 200, new Object[] { "Fail to read script file:", localScriptNotFoundException.getPath() });
        return false;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readAndVerifyScript failed, spriteContext or resourceService null. bid:");
    localStringBuilder.append(this.b);
    QLog.w("[cmshow][scripted]SpriteAioScript", 1, localStringBuilder.toString());
    return false;
  }
  
  public void a() {}
  
  public void a(ISpriteActionCallback paramISpriteActionCallback)
  {
    this.e = paramISpriteActionCallback;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!this.d)
    {
      QLog.w("[cmshow][scripted]SpriteAioScript", 2, "[checkDressRsc], script is NOT ready.");
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if ("0".equals(paramString)) {
        return;
      }
      QQAppInterface localQQAppInterface = b();
      if (localQQAppInterface == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteAioScript", 2, new Object[] { "[checkDressRsc], uin:", paramString, ",notifyIfExist:", Boolean.valueOf(paramBoolean) });
      }
      IApolloResManager localIApolloResManager = j();
      if (localIApolloResManager == null)
      {
        QLog.e("[cmshow][scripted]SpriteAioScript", 1, "[checkDressRsc] error, apolloResManager is null");
        return;
      }
      Object localObject = ApolloActionHelperImpl.getRoleDressIdByUin(paramString, b(), false, localIApolloResManager);
      if (localObject != null)
      {
        if (localObject.length != 2) {
          return;
        }
        int k = ((Integer)localObject[0]).intValue();
        localObject = (int[])localObject[1];
        if (localObject != null)
        {
          if (localObject.length == 0) {
            return;
          }
          if (2 == ((ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(paramString))
          {
            if (paramBoolean) {
              a(localQQAppInterface, paramString, k, (int[])localObject, 0);
            }
            return;
          }
          localIApolloResManager.b(localQQAppInterface, paramString, k, (int[])localObject, new SpriteAioScript.1(this, paramBoolean));
        }
      }
    }
  }
  
  public QQAppInterface b()
  {
    SpriteContext localSpriteContext = this.f;
    if (localSpriteContext == null) {
      return null;
    }
    return localSpriteContext.l();
  }
  
  public int c()
  {
    return this.b;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteAioScript", 2, new Object[] { "[loadScript], mIsLoaded:", Boolean.valueOf(this.d) });
    }
    SpriteContext localSpriteContext = this.f;
    if (localSpriteContext == null)
    {
      QLog.e("[cmshow][scripted]SpriteAioScript", 2, "[loadScript], error, mSpriteContext null");
      return;
    }
    if (!this.d) {
      return;
    }
    try
    {
      localSpriteContext.a(this.a);
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow][scripted]SpriteAioScript", 1, localThrowable, new Object[0]);
    }
  }
  
  protected void e()
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      QLog.w("[cmshow][scripted]SpriteAioScript", 1, "addEventListener error, mSpriteContext null");
      return;
    }
    localObject = ((SpriteContext)localObject).o();
    if (localObject == null)
    {
      QLog.w("[cmshow][scripted]SpriteAioScript", 1, "addEventListener error, scriptService null");
      return;
    }
    if (this.g == null) {
      this.g = new ServerSSOPlugin();
    }
    if (this.h == null) {
      this.h = new TraceReportPlugin(this.f);
    }
    if (this.i == null) {
      this.i = new SpriteAioPlugin(this.f, this, this.e);
    }
    if (this.j == null) {
      this.j = new SpriteUiPlugin(this.f);
    }
    ((IScriptService)localObject).a(this.g);
    ((IScriptService)localObject).a(this.h);
    ((IScriptService)localObject).a(this.i);
    ((IScriptService)localObject).a(this.j);
  }
  
  public boolean f()
  {
    if (this.d)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("script is already read, scriptName:");
      localStringBuilder.append(this.c);
      QLog.i("[cmshow][scripted]SpriteAioScript", 1, localStringBuilder.toString());
      return true;
    }
    this.d = k();
    return this.d;
  }
  
  public void g()
  {
    QLog.w("[cmshow][scripted]SpriteAioScript", 1, "[onVerifyFailure], check base.zip");
    ApolloContentUpdateHandler.a(b());
  }
  
  public void h()
  {
    QLog.w("[cmshow][scripted]SpriteAioScript", 1, "[onScriptNotExists], redownload base.zip");
    ApolloContentUpdateHandler.a(b());
  }
  
  public void i()
  {
    a(this.g);
    a(this.h);
    a(this.i);
    a(this.j);
    this.e = null;
    this.d = false;
  }
  
  protected IApolloResManager j()
  {
    SpriteContext localSpriteContext = this.f;
    if (localSpriteContext != null) {
      return localSpriteContext.q();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteAioScript
 * JD-Core Version:    0.7.0.1
 */