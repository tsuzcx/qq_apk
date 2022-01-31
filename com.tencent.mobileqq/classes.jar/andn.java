import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class andn
  extends ampb<andm>
{
  public int a()
  {
    return 424;
  }
  
  @NonNull
  public andm a(int paramInt)
  {
    return new andm();
  }
  
  @Nullable
  public andm a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      paramArrayOfampi = paramArrayOfampi[0].a;
      QLog.i("SafeModeProcessor", 1, "onParsed: invoked.  content: " + paramArrayOfampi);
      paramArrayOfampi = andm.a(paramArrayOfampi);
      if (paramArrayOfampi != null)
      {
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash_config", 4).edit().putBoolean("key_test_crash_switch", paramArrayOfampi.a).apply();
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash", 0).edit().putBoolean("crash", paramArrayOfampi.a).commit();
      }
      return paramArrayOfampi;
    }
    return null;
  }
  
  public Class<andm> a()
  {
    return andm.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(andm paramandm) {}
  
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
 * Qualified Name:     andn
 * JD-Core Version:    0.7.0.1
 */