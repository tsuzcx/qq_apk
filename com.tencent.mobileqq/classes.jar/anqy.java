import android.app.Activity;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class anqy
{
  public static void a(boolean paramBoolean, Activity paramActivity, aiwh paramaiwh, AppInterface paramAppInterface, String paramString, anqz paramanqz)
  {
    a(paramBoolean, paramActivity, paramaiwh, paramAppInterface, paramString, paramanqz, true);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, aiwh paramaiwh, AppInterface paramAppInterface, String paramString, anqz paramanqz, boolean paramBoolean2)
  {
    if (paramanqz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloGameWrapper", 2, "checkApolloGame listener is null");
      }
      return;
    }
    if ((paramActivity == null) || (paramAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.ApolloGameWrapper", 2, "checkApolloGame activity is null OR appInterface is null");
      }
      paramanqz.a(false, null);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramaiwh = andl.a(paramString);
      if ((paramaiwh == null) || (paramaiwh.a == null) || (paramaiwh.a.get() != paramActivity))
      {
        paramanqz.a(false, paramaiwh);
        return;
      }
      paramanqz.a(true, paramaiwh);
      return;
    }
    paramActivity.runOnUiThread(new ApolloGameWrapper.1(paramString, paramActivity, paramanqz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqy
 * JD-Core Version:    0.7.0.1
 */