package com.tencent.mobileqq.apollo.script;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.script.callback.ISpriteActionCallback;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.RSAVerify;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;

public class SpriteAioScript
  implements IRequestHandler
{
  protected int a;
  protected SpriteContext a;
  protected ISpriteActionCallback a;
  protected String a;
  protected boolean a;
  protected String b;
  
  public SpriteAioScript(int paramInt, SpriteContext paramSpriteContext)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = ("cmshow_script_" + paramInt + ".js");
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    QLog.i("cmshow_scripted_SpriteAioScript", 1, "[create script object], bid:" + paramInt + ",scriptName:" + this.b);
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
      QLog.d("cmshow_scripted_SpriteAioScript", 2, new Object[] { "checkThreeFaceDress faceData:", str });
    }
    SpriteRscBuilder.a(paramQQAppInterface, str, new SpriteAioScript.4(this, paramBoolean, paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2));
  }
  
  public int a()
  {
    return 300;
  }
  
  public IApolloRenderView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
  }
  
  public HandleResult a(long paramLong, String paramString1, String paramString2)
  {
    return null;
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ApolloConstant.I).append(this.b);
    return localStringBuilder.toString();
  }
  
  public void a() {}
  
  public void a(ISpriteActionCallback paramISpriteActionCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback = paramISpriteActionCallback;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2) {}
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null)) {
      QLog.w("cmshow_scripted_SpriteAioScript", 1, "[execScriptInRenderThread], script is null.");
    }
    IApolloRenderView localIApolloRenderView;
    do
    {
      return;
      localIApolloRenderView = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    } while (localIApolloRenderView == null);
    localIApolloRenderView.runRenderTask(new SpriteAioScript.1(this, paramString, localIApolloRenderView, paramInt, paramBoolean));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      QLog.w("cmshow_scripted_SpriteAioScript", 2, "[checkDressRsc], script is NOT ready.");
    }
    label15:
    QQAppInterface localQQAppInterface;
    Object localObject;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            break label15;
            break label15;
            do
            {
              return;
            } while ((TextUtils.isEmpty(paramString)) || ("0".equals(paramString)));
            localQQAppInterface = a();
          } while (localQQAppInterface == null);
          if (QLog.isColorLevel()) {
            QLog.d("cmshow_scripted_SpriteAioScript", 2, new Object[] { "[checkDressRsc], uin:", paramString, ",notifyIfExist:", Boolean.valueOf(paramBoolean) });
          }
          localObject = ApolloActionHelperImpl.getRoleDressIdByUin(paramString, a(), false);
        } while ((localObject == null) || (localObject.length != 2));
        i = ((Integer)localObject[0]).intValue();
        localObject = (int[])localObject[1];
      } while ((localObject == null) || (localObject.length == 0));
      if (2 != ((ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(paramString)) {
        break;
      }
    } while (!paramBoolean);
    a(localQQAppInterface, paramString, i, (int[])localObject, 0);
    return;
    SpriteRscBuilder.a(localQQAppInterface, paramString, i, (int[])localObject, new SpriteAioScript.2(this, paramBoolean));
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramQQAppInterface == null) {
      QLog.e("cmshow_scripted_SpriteAioScript", 1, "[checkThreeDress] error, app is null!");
    }
    do
    {
      return;
      i = ((IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus(a(), paramString);
      if (i == 2) {
        break;
      }
    } while (!paramBoolean);
    a(paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2);
    return;
    Object localObject = ApolloActionHelperImpl.get3DRoleDressIdByUin(paramString, i, a(), false);
    int i = ((Integer)localObject[0]).intValue();
    if (localObject[1] == null) {}
    for (localObject = null;; localObject = (int[])localObject[1])
    {
      if ((i > 0) && (localObject != null) && (localObject.length != 0)) {
        break label142;
      }
      if (!paramBoolean) {
        break;
      }
      a(paramQQAppInterface, paramString, paramInt1, paramArrayOfInt, paramInt2);
      return;
    }
    label142:
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteAioScript", 2, new Object[] { "checkThreeDress roleId:", Integer.valueOf(paramInt1), ", dressIds:", Arrays.toString((int[])localObject) });
    }
    SpriteRscBuilder.b(paramQQAppInterface, paramString, i, (int[])localObject, new SpriteAioScript.3(this, paramBoolean, paramInt1, paramArrayOfInt));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.i("cmshow_scripted_SpriteAioScript", 1, "script is already read, scriptName:" + this.b);
      return true;
    }
    this.jdField_a_of_type_Boolean = b();
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(Activity paramActivity)
  {
    return false;
  }
  
  protected boolean a(String paramString)
  {
    boolean bool = true;
    if (!new RSAVerify(paramString + ".sig", paramString).a(1))
    {
      QLog.w("cmshow_scripted_SpriteAioScript", 1, "verify fails, path:" + paramString);
      e();
      bool = false;
    }
    return bool;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b() {}
  
  public void b(String paramString)
  {
    a(paramString, 0, false);
  }
  
  public boolean b()
  {
    try
    {
      if ((this.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(ApolloManagerServiceImpl.sBasicScript)))
      {
        this.jdField_a_of_type_JavaLangString = ApolloManagerServiceImpl.sBasicScript;
        QLog.i("cmshow_scripted_SpriteAioScript", 1, "Succeed to read script 0 from cache");
        return true;
      }
      String str = a();
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      localFile = new File(str);
      if (!localFile.exists())
      {
        QLog.w("cmshow_scripted_SpriteAioScript", 1, "Fail to read script file. " + localFile.getAbsolutePath());
        f();
        if (TextUtils.isEmpty(ApolloConstant.H)) {
          TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d(), 300, 202, new Object[] { "Fail to read script file:", str });
        } else {
          TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d(), 300, 200, new Object[] { "Fail to read script file:", str });
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      File localFile;
      QLog.e("cmshow_scripted_SpriteAioScript", 1, "[loadScript],OOM:", localOutOfMemoryError);
      TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d(), 300, 150, new Object[] { "loadScript:", localOutOfMemoryError });
      return false;
      if (!a(localOutOfMemoryError))
      {
        TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d(), 300, 201, new Object[] { "Fail to verify script file:", localOutOfMemoryError });
        return false;
      }
      this.jdField_a_of_type_JavaLangString = FileUtils.b(localFile);
      QLog.i("cmshow_scripted_SpriteAioScript", 1, "Succeed to read script file, bid:" + this.jdField_a_of_type_Int);
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteAioScript", 1, "[loadScript]:", localThrowable);
      TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d(), 300, 30, new Object[] { "loadScript:", localThrowable });
      return false;
    }
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteAioScript", 2, new Object[] { "[loadScript], mIsLoaded:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Int == 0)
        {
          QLog.d("cmshow_scripted_SpriteAioScript", 1, "sava TraceReport CmShowStatUtil commitJS:(cmshow_0)");
          a(this.jdField_a_of_type_JavaLangString, 3, false);
        }
        for (;;)
        {
          b();
          return;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("(function(){").append(this.jdField_a_of_type_JavaLangString).append(";registerFunction(\"playAction_bid_").append(this.jdField_a_of_type_Int).append("\", playSpriteAction);").append("registerFunction(\"sendMsg_bid_").append(this.jdField_a_of_type_Int).append("\", sendSpriteMsg);").append("registerFunction(\"stopAction_bid_").append(this.jdField_a_of_type_Int).append("\", stopSpriteAction);").append("})();");
          b(localStringBuilder.toString());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteAioScript", 1, localThrowable, new Object[0]);
    }
  }
  
  public boolean c()
  {
    if (TextUtils.isEmpty(ApolloConstant.H)) {}
    while (new File(ApolloConstant.I + "cm3d.js").exists()) {
      return true;
    }
    return false;
  }
  
  public void d()
  {
    ApolloUtilImpl.getCmdChannel().addCmdHandler(this);
  }
  
  public void e()
  {
    QLog.w("cmshow_scripted_SpriteAioScript", 1, "[onVerifyFailure], check base.zip");
    ApolloContentUpdateHandler.a(a());
  }
  
  public void f()
  {
    QLog.w("cmshow_scripted_SpriteAioScript", 1, "[onScriptNotExists], redownload base.zip");
    ApolloContentUpdateHandler.a(a());
  }
  
  public void g()
  {
    ApolloUtilImpl.getCmdChannel().removeCmdHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback = null;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteAioScript
 * JD-Core Version:    0.7.0.1
 */