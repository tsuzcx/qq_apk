package com.tencent.mobileqq.apollo.script;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.IRequestHandler;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.script.callback.ISpriteActionCallback;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.RSAVerify;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.ApolloContentUpdateHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import yym;
import yyn;

public class SpriteAioScript
  implements ApolloCmdChannel.IRequestHandler
{
  protected int a;
  protected SpriteContext a;
  protected SpriteScriptManager a;
  protected ISpriteActionCallback a;
  protected String a;
  protected boolean a;
  protected String b;
  
  public SpriteAioScript(int paramInt, SpriteContext paramSpriteContext)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = ("cmshow_script_" + paramInt + ".js");
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    if (paramSpriteContext.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptManager = ((SpriteScriptManager)paramSpriteContext.a().getManager(248));
    }
    QLog.i("cmshow_scripted_SpriteAioScript", 1, "[create script object], bid:" + paramInt + ",scriptName:" + this.b);
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
    localStringBuilder.append(ApolloConstant.o).append(this.b);
    return localStringBuilder.toString();
  }
  
  public void a() {}
  
  public void a(ISpriteActionCallback paramISpriteActionCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback = paramISpriteActionCallback;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2) {}
  
  public void a(String paramString)
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
    localIApolloRenderView.onRunInRenderThread(new yym(this, localIApolloRenderView, paramString));
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
          localObject = ApolloActionHelper.a(paramString, a());
        } while ((localObject == null) || (localObject.length != 2));
        i = ((Integer)localObject[0]).intValue();
        localObject = (int[])localObject[1];
      } while ((localObject == null) || (localObject.length == 0));
      if (2 != ((ApolloManager)localQQAppInterface.getManager(152)).b(paramString)) {
        break;
      }
    } while (!paramBoolean);
    a(localQQAppInterface, paramString, i, (int[])localObject, 0);
    return;
    SpriteRscBuilder.a(localQQAppInterface, paramString, i, (int[])localObject, new yyn(this, paramBoolean));
  }
  
  public boolean a()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        QLog.i("cmshow_scripted_SpriteAioScript", 1, "script is already read, scriptName:" + this.b);
        return true;
      }
      Object localObject = a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return false;
      }
      if (!a((String)localObject)) {
        return false;
      }
      localObject = new File((String)localObject);
      if (((File)localObject).exists())
      {
        this.jdField_a_of_type_JavaLangString = FileUtils.b((File)localObject);
        this.jdField_a_of_type_Boolean = true;
        QLog.i("cmshow_scripted_SpriteAioScript", 1, "Succeed to read script file, bid:" + this.jdField_a_of_type_Int);
        return true;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("cmshow_scripted_SpriteAioScript", 1, "[loadScript],", localOutOfMemoryError);
      return false;
      QLog.w("cmshow_scripted_SpriteAioScript", 1, "Fail to read script file. " + localOutOfMemoryError.getAbsolutePath());
      f();
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteAioScript", 1, "[loadScript],OOM,", localThrowable);
    }
    return false;
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
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteAioScript", 2, new Object[] { "[loadScript], mIsLoaded:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Int == 0) {
          a(this.jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          b();
          return;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("(function(){").append(this.jdField_a_of_type_JavaLangString).append(";registerFunction(\"playAction_bid_").append(this.jdField_a_of_type_Int).append("\", playSpriteAction);").append("registerFunction(\"sendMsg_bid_").append(this.jdField_a_of_type_Int).append("\", sendSpriteMsg);").append("registerFunction(\"stopAction_bid_").append(this.jdField_a_of_type_Int).append("\", stopSpriteAction);").append("})();");
          a(localStringBuilder.toString());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmshow_scripted_SpriteAioScript", 1, localThrowable, new Object[0]);
    }
  }
  
  public void d()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return;
    }
    ApolloCmdChannel.getChannel(localQQAppInterface).addCmdHandler(this);
  }
  
  public void e()
  {
    QLog.w("cmshow_scripted_SpriteAioScript", 1, "[onVerifyFailure], check base.zip");
    ApolloContentUpdateHandler.a(a());
  }
  
  public void f()
  {
    QLog.w("cmshow_scripted_SpriteAioScript", 1, "[onScriptNotExists], redownload base.zip");
    ApolloContentUpdateHandler.b(a());
  }
  
  public void g()
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    localObject = ApolloCmdChannel.getChannel((QQAppInterface)localObject);
    if (localObject != null) {
      ((ApolloCmdChannel)localObject).removeCmdHandler(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback = null;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteAioScript
 * JD-Core Version:    0.7.0.1
 */