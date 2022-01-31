import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;

public class bghw
  extends RemoteCommand
{
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  boolean jdField_a_of_type_Boolean;
  
  public bghw(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static Bundle a(Bundle paramBundle)
  {
    try
    {
      Bundle localBundle = jdField_a_of_type_AndroidOsBundle;
      jdField_a_of_type_AndroidOsBundle = paramBundle;
      return localBundle;
    }
    finally
    {
      paramBundle = finally;
      throw paramBundle;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = PluginCommunicationHandler.getInstance();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.register(new bghw("cacomicetinfo", true));
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(268435456);
    sgg.a(localIntent, paramQQAppInterface, BaseApplication.getContext(), paramString, -1);
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (akdh)paramQQAppInterface.getManager(56);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.b(paramString) != null;
    }
    return false;
  }
  
  private Bundle b(Bundle paramBundle)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicRemoteCommand", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    localObject = (QQAppInterface)localObject;
    String str = paramBundle.getString("cacomicetinfo");
    if ("Remotecall_getPublicAccountState".equals(str))
    {
      paramBundle = paramBundle.getString("uin");
      if (!TextUtils.isEmpty(paramBundle))
      {
        boolean bool = a((QQAppInterface)localObject, paramBundle);
        paramBundle = new Bundle();
        paramBundle.putBoolean("state", bool);
        return paramBundle;
      }
    }
    else
    {
      if (!"Remotecall_showPublicAccountDetail".equals(str)) {
        break label123;
      }
      paramBundle = paramBundle.getString("uin");
      if (!TextUtils.isEmpty(paramBundle)) {
        a((QQAppInterface)localObject, paramBundle);
      }
    }
    for (;;)
    {
      return null;
      label123:
      if ("Remotecall_getUserStatus".equals(str))
      {
        paramBundle = new Bundle();
        if (VipUtils.b((QQAppInterface)localObject)) {
          paramBundle.putInt("userStatus", 3);
        }
        for (;;)
        {
          return paramBundle;
          if (VipUtils.c((QQAppInterface)localObject)) {
            paramBundle.putInt("userStatus", 2);
          } else {
            paramBundle.putInt("userStatus", 1);
          }
        }
      }
      if ("Remotecall_initQbPlugin".equals(str)) {
        try
        {
          QWalletHelper.preloadQWallet((AppInterface)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("VipComicRemoteCommand", 2, "preloadQWallet()");
          }
          paramBundle = new Bundle();
          paramBundle.putBoolean("success", true);
          return paramBundle;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
      } else if ("Remotecall_showComicBar".equals(str))
      {
        if (((QQAppInterface)localObject).getHandler(Conversation.class) != null) {
          a(paramBundle);
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("VipComicRemoteCommand", 2, "onRemoteInvoke unknow invokeCmd");
      }
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramBundle = b(paramBundle);
    if (paramOnInvokeFinishLinstener != null) {
      paramOnInvokeFinishLinstener.onInvokeFinish(paramBundle);
    }
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghw
 * JD-Core Version:    0.7.0.1
 */