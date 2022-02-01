import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class arak
  extends aqkz<arah>
{
  public static arah a()
  {
    return (arah)aqlk.a().a(383);
  }
  
  @NonNull
  public arah a(int paramInt)
  {
    return new arah();
  }
  
  @Nullable
  public arah a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return arah.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(arah paramarah)
  {
    if ((paramarah != null) && (!TextUtils.isEmpty(paramarah.b()))) {
      ((bdks)BaseApplicationImpl.getApplication().getRuntime().getManager(305)).a(paramarah);
    }
  }
  
  public Class<arah> clazz()
  {
    return arah.class;
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
    return 383;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arak
 * JD-Core Version:    0.7.0.1
 */