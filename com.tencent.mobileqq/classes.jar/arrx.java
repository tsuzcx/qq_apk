import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arrx
  extends arac<arrw>
{
  @NonNull
  public arrw a(int paramInt)
  {
    return new arrw();
  }
  
  @Nullable
  public arrw a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      paramArrayOfaraj = paramArrayOfaraj[0].a;
      QLog.i("SafeModeProcessor", 1, "onParsed: invoked.  content: " + paramArrayOfaraj);
      paramArrayOfaraj = arrw.a(paramArrayOfaraj);
      if (paramArrayOfaraj != null)
      {
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash_config", 4).edit().putBoolean("key_test_crash_switch", paramArrayOfaraj.a).apply();
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash", 0).edit().putBoolean("crash", paramArrayOfaraj.a).commit();
      }
      return paramArrayOfaraj;
    }
    return null;
  }
  
  public void a(arrw paramarrw) {}
  
  public Class<arrw> clazz()
  {
    return arrw.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 424;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arrx
 * JD-Core Version:    0.7.0.1
 */