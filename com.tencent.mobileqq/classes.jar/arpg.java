import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arpg
  extends aqwt<arpf>
{
  @NonNull
  public arpf a(int paramInt)
  {
    return new arpf();
  }
  
  @Nullable
  public arpf a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      paramArrayOfaqxa = paramArrayOfaqxa[0].a;
      QLog.i("SafeModeProcessor", 1, "onParsed: invoked.  content: " + paramArrayOfaqxa);
      paramArrayOfaqxa = arpf.a(paramArrayOfaqxa);
      if (paramArrayOfaqxa != null)
      {
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash_config", 4).edit().putBoolean("key_test_crash_switch", paramArrayOfaqxa.a).apply();
        BaseApplicationImpl.getContext().getSharedPreferences("sp_safemode_test_crash", 0).edit().putBoolean("crash", paramArrayOfaqxa.a).commit();
      }
      return paramArrayOfaqxa;
    }
    return null;
  }
  
  public void a(arpf paramarpf) {}
  
  public Class<arpf> clazz()
  {
    return arpf.class;
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
 * Qualified Name:     arpg
 * JD-Core Version:    0.7.0.1
 */