import android.app.Activity;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class anfd
{
  public static void a(boolean paramBoolean, Activity paramActivity, aimj paramaimj, AppInterface paramAppInterface, String paramString, anfe paramanfe)
  {
    a(paramBoolean, paramActivity, paramaimj, paramAppInterface, paramString, paramanfe, true);
  }
  
  public static void a(boolean paramBoolean1, Activity paramActivity, aimj paramaimj, AppInterface paramAppInterface, String paramString, anfe paramanfe, boolean paramBoolean2)
  {
    if (paramanfe == null)
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
      paramanfe.a(false, null);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramaimj = amrr.a(paramString);
      if ((paramaimj == null) || (paramaimj.a == null) || (paramaimj.a.get() != paramActivity))
      {
        paramanfe.a(false, paramaimj);
        return;
      }
      paramanfe.a(true, paramaimj);
      return;
    }
    paramActivity.runOnUiThread(new ApolloGameWrapper.1(paramString, paramActivity, paramanfe));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfd
 * JD-Core Version:    0.7.0.1
 */