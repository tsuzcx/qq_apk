import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.KCWraper.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import dualsim.common.OrderCheckResult;
import mqq.os.MqqHandler;

public class bbwo
{
  private static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_sdk", 4);
  }
  
  protected static Pair<Boolean, Integer> a()
  {
    SharedPreferences localSharedPreferences = a();
    return new Pair(Boolean.valueOf(localSharedPreferences.getBoolean("kingCard", false)), Integer.valueOf(localSharedPreferences.getInt("kingCardProduct", 0)));
  }
  
  public static void a(boolean paramBoolean)
  {
    a().edit().putBoolean("supportActivationView", paramBoolean).apply();
  }
  
  protected static boolean a(@NonNull String paramString, @NonNull OrderCheckResult paramOrderCheckResult)
  {
    Object localObject = a();
    boolean bool;
    int j;
    int i;
    if (((SharedPreferences)localObject).getInt("kingCardProduct", -1) != paramOrderCheckResult.product)
    {
      localObject = ((SharedPreferences)localObject).edit().putInt("kingCardProduct", paramOrderCheckResult.product);
      if (paramOrderCheckResult.kingcard > 0)
      {
        bool = true;
        ((SharedPreferences.Editor)localObject).putBoolean("kingCard", bool).apply();
      }
    }
    else
    {
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + paramString, 4);
      j = paramString.getInt("kingCardSdk", -1);
      if (paramOrderCheckResult.kingcard != 0) {
        break label163;
      }
      i = -1;
    }
    for (;;)
    {
      if (j == i) {
        break label195;
      }
      paramString.edit().putInt("kingCardSdk", i).putInt("toast_version", 0).putInt("popup_version_v2", 0).commit();
      return true;
      bool = false;
      break;
      label163:
      if (paramOrderCheckResult.kingcard == 1)
      {
        if (paramOrderCheckResult.product == 90155946) {
          i = 2;
        } else {
          i = 1;
        }
      }
      else {
        i = 0;
      }
    }
    label195:
    return false;
  }
  
  protected static boolean c()
  {
    return a().getBoolean("supportActivationView", false);
  }
  
  String a()
  {
    return "KC.KCWraper";
  }
  
  void a(ViewGroup paramViewGroup) {}
  
  void a(bbwy parambbwy, boolean paramBoolean)
  {
    if (parambbwy != null)
    {
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new KCWraper.1(this, parambbwy));
      }
    }
    else {
      return;
    }
    parambbwy.a(false, false, 0);
  }
  
  void a(Runnable paramRunnable)
  {
    a("tryLoad : disable kingcard");
  }
  
  public final void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a(), 2, paramString);
    }
  }
  
  boolean a()
  {
    a("isReady : disable kingcard");
    return false;
  }
  
  boolean a(Activity paramActivity)
  {
    return false;
  }
  
  boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbwo
 * JD-Core Version:    0.7.0.1
 */