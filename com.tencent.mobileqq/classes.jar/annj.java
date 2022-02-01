import android.app.Activity;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class annj
{
  public static void a(boolean paramBoolean, Activity paramActivity, ailr paramailr, AppInterface paramAppInterface, String paramString, annk paramannk)
  {
    a(paramBoolean, paramActivity, paramailr, paramAppInterface, paramString, paramannk, true);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, ailr paramailr, AppInterface paramAppInterface, String paramString, annk paramannk, boolean paramBoolean2)
  {
    if (paramannk == null)
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
      paramannk.a(false, null);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramailr = amyv.a(paramString);
      if ((paramailr == null) || (paramailr.a == null) || (paramailr.a.get() != paramActivity))
      {
        paramannk.a(false, paramailr);
        return;
      }
      paramannk.a(true, paramailr);
      return;
    }
    paramActivity.runOnUiThread(new ApolloGameWrapper.1(paramString, paramActivity, paramannk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annj
 * JD-Core Version:    0.7.0.1
 */