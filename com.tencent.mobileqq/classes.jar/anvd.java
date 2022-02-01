import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class anvd
  extends QIPCModule
{
  public static anvd a;
  
  private anvd()
  {
    super("CommonModule");
  }
  
  public static anvd a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new anvd();
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
        localBundle.putInt("selfBindState", ((axfr)((QQAppInterface)paramString).getManager(11)).d());
        return EIPCResult.createSuccessResult(localBundle);
      }
    }
    else if ("set_avatar".equals(paramString))
    {
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
        paramString = bhhz.a((QQAppInterface)localAppRuntime, paramString, paramBundle);
        if (paramString.jdField_a_of_type_Int == 0) {
          break label231;
        }
        localBundle.putInt("param_result_code", paramString.jdField_a_of_type_Int);
        localBundle.putString("param_result_desc", paramString.jdField_a_of_type_JavaLangString);
        localBundle.putString("param_action", "set_avatar");
        callbackResult(paramInt, EIPCResult.createSuccessResult(localBundle));
      }
    }
    return EIPCResult.createSuccessResult(localBundle);
    label231:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvd
 * JD-Core Version:    0.7.0.1
 */