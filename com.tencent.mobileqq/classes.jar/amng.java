import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class amng
  extends alzl<amnf>
{
  public int a()
  {
    return 424;
  }
  
  @NonNull
  public amnf a(int paramInt)
  {
    return new amnf();
  }
  
  @Nullable
  public amnf a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      paramArrayOfalzs = paramArrayOfalzs[0].a;
      QLog.i("SafeModeProcessor", 1, "onParsed: invoked.  content: " + paramArrayOfalzs);
      paramArrayOfalzs = amnf.a(paramArrayOfalzs);
      if (paramArrayOfalzs != null)
      {
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash_config", 4).edit().putBoolean("key_test_crash_switch", paramArrayOfalzs.a).apply();
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash", 0).edit().putBoolean("crash", paramArrayOfalzs.a).commit();
      }
      return paramArrayOfalzs;
    }
    return null;
  }
  
  public Class<amnf> a()
  {
    return amnf.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amnf paramamnf) {}
  
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
 * Qualified Name:     amng
 * JD-Core Version:    0.7.0.1
 */