import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ands
  extends ampa<andr>
{
  public int a()
  {
    return 424;
  }
  
  @NonNull
  public andr a(int paramInt)
  {
    return new andr();
  }
  
  @Nullable
  public andr a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      paramArrayOfamph = paramArrayOfamph[0].a;
      QLog.i("SafeModeProcessor", 1, "onParsed: invoked.  content: " + paramArrayOfamph);
      paramArrayOfamph = andr.a(paramArrayOfamph);
      if (paramArrayOfamph != null)
      {
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash_config", 4).edit().putBoolean("key_test_crash_switch", paramArrayOfamph.a).apply();
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash", 0).edit().putBoolean("crash", paramArrayOfamph.a).commit();
      }
      return paramArrayOfamph;
    }
    return null;
  }
  
  public Class<andr> a()
  {
    return andr.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(andr paramandr) {}
  
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
 * Qualified Name:     ands
 * JD-Core Version:    0.7.0.1
 */