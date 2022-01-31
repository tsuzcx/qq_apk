import android.net.Uri;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.qphone.base.util.QLog;

final class arlp
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = ((Uri)paramMethodHookParam.args[0]).toString();
    if ((paramMethodHookParam.contains(ContactsContract.RawContacts.CONTENT_URI.toString())) || (paramMethodHookParam.contains(ContactsContract.Data.CONTENT_URI.toString())))
    {
      paramMethodHookParam = new StringBuilder(1000);
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      int i = 0;
      while (i < arrayOfStackTraceElement.length)
      {
        paramMethodHookParam.append(arrayOfStackTraceElement[i] + "-");
        i += 1;
      }
      QLog.d("ContactDelete", 1, paramMethodHookParam.toString());
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arlp
 * JD-Core Version:    0.7.0.1
 */