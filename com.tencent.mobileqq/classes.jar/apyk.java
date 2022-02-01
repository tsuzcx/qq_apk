import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class apyk
  implements apyw
{
  public EIPCResult a(Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = apxv.a();
    if (localQQAppInterface == null)
    {
      QLog.e("ArkApp.GetNicknameHandler", 1, "Handler_GetNickName.onCall, qq app is null");
      return EIPCResult.createResult(-102, new Bundle());
    }
    String str = paramBundle.getString("Uin", localQQAppInterface.getCurrentAccountUin());
    Object localObject = null;
    if (!TextUtils.isEmpty(agyw.a)) {
      localObject = bhlg.h(localQQAppInterface, agyw.a, str);
    }
    if (localObject != null)
    {
      paramBundle = (Bundle)localObject;
      if (!TextUtils.equals((CharSequence)localObject, str)) {}
    }
    else
    {
      localObject = bhlg.q(localQQAppInterface, str);
      paramBundle = (Bundle)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramBundle = bhlg.a(localQQAppInterface, str, 0);
      }
    }
    localObject = new Bundle();
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.i("ArkApp.GetNicknameHandler", 1, "GetNicknameHandler.onCall, nickname is empty");
      ((Bundle)localObject).putString("Nickname", "");
    }
    for (;;)
    {
      return EIPCResult.createResult(0, (Bundle)localObject);
      ((Bundle)localObject).putString("Nickname", paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyk
 * JD-Core Version:    0.7.0.1
 */