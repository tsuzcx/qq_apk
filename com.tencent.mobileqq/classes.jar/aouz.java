import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aouz
  extends aofy<aouy>
{
  public int a()
  {
    return 424;
  }
  
  @NonNull
  public aouy a(int paramInt)
  {
    return new aouy();
  }
  
  @Nullable
  public aouy a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      paramArrayOfaogf = paramArrayOfaogf[0].a;
      QLog.i("SafeModeProcessor", 1, "onParsed: invoked.  content: " + paramArrayOfaogf);
      paramArrayOfaogf = aouy.a(paramArrayOfaogf);
      if (paramArrayOfaogf != null)
      {
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash_config", 4).edit().putBoolean("key_test_crash_switch", paramArrayOfaogf.a).apply();
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash", 0).edit().putBoolean("crash", paramArrayOfaogf.a).commit();
      }
      return paramArrayOfaogf;
    }
    return null;
  }
  
  public Class<aouy> a()
  {
    return aouy.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aouy paramaouy) {}
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aouz
 * JD-Core Version:    0.7.0.1
 */