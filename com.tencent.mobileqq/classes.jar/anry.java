import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.transfile.TransFileController.AvatarUploadResult;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class anry
  extends QIPCModule
{
  public static anry a;
  
  private anry()
  {
    super("CommonModule");
  }
  
  public static anry a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new anry();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonModule", 2, "onSetAvatarBackResult， intent=" + paramIntent);
    }
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("param_callback_id", -1);
      int j = paramIntent.getIntExtra("param_result_code", -99999);
      paramIntent = paramIntent.getStringExtra("param_result_desc");
      if (i > 0)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("param_result_code", j);
        localBundle.putString("param_result_desc", paramIntent);
        localBundle.putString("param_action", "set_avatar");
        callbackResult(i, EIPCResult.createSuccessResult(localBundle));
      }
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonModule", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    Bundle localBundle = new Bundle();
    if ("getPhoneBindState".equals(paramString))
    {
      paramString = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramString instanceof QQAppInterface))
      {
        localBundle.putInt("selfBindState", ((awyz)((QQAppInterface)paramString).getManager(QQManagerFactory.CONTACT_MANAGER)).d());
        return EIPCResult.createSuccessResult(localBundle);
      }
    }
    else
    {
      if (!"set_avatar".equals(paramString)) {
        break label234;
      }
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        paramString = "";
        if (paramBundle != null) {
          paramString = paramBundle.getString("param_avatar_path");
        }
        paramBundle = new Intent();
        paramBundle.putExtra("PhotoConst.SOURCE_FROM", "FROM_MINI_APP");
        paramBundle.putExtra("param_callback_id", paramInt);
        paramString = bhaa.a((QQAppInterface)localAppRuntime, paramString, paramBundle);
        if (paramString.errCode == 0) {
          break label232;
        }
        localBundle.putInt("param_result_code", paramString.errCode);
        localBundle.putString("param_result_desc", paramString.errDesc);
        localBundle.putString("param_action", "set_avatar");
        callbackResult(paramInt, EIPCResult.createSuccessResult(localBundle));
      }
    }
    for (;;)
    {
      return EIPCResult.createSuccessResult(localBundle);
      label232:
      return null;
      label234:
      if ("jumpToCommonGroup".equals(paramString))
      {
        paramString = BaseApplicationImpl.getApplication().getRuntime();
        if (((paramString instanceof QQAppInterface)) && (paramBundle != null))
        {
          paramBundle = paramBundle.getString("cur_friend_uin");
          ((bbcx)paramString.getManager(QQManagerFactory.FRIEND_CLUE_MANAGER)).b(paramBundle);
        }
      }
      else if ("jumpToRemarkEdit".equals(paramString))
      {
        paramString = BaseApplicationImpl.getApplication().getRuntime();
        if (((paramString instanceof QQAppInterface)) && (paramBundle != null))
        {
          paramBundle = paramBundle.getString("cur_friend_uin");
          ((bbcx)paramString.getManager(QQManagerFactory.FRIEND_CLUE_MANAGER)).a(paramBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anry
 * JD-Core Version:    0.7.0.1
 */