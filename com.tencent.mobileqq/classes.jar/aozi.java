import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aozi
  extends aokh<aozh>
{
  public int a()
  {
    return 424;
  }
  
  @NonNull
  public aozh a(int paramInt)
  {
    return new aozh();
  }
  
  @Nullable
  public aozh a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      paramArrayOfaoko = paramArrayOfaoko[0].a;
      QLog.i("SafeModeProcessor", 1, "onParsed: invoked.  content: " + paramArrayOfaoko);
      paramArrayOfaoko = aozh.a(paramArrayOfaoko);
      if (paramArrayOfaoko != null)
      {
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash_config", 4).edit().putBoolean("key_test_crash_switch", paramArrayOfaoko.a).apply();
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash", 0).edit().putBoolean("crash", paramArrayOfaoko.a).commit();
      }
      return paramArrayOfaoko;
    }
    return null;
  }
  
  public Class<aozh> a()
  {
    return aozh.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aozh paramaozh) {}
  
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
 * Qualified Name:     aozi
 * JD-Core Version:    0.7.0.1
 */