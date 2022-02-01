import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class arqb
  extends arac<arpy>
{
  public static arpy a()
  {
    return (arpy)aran.a().a(383);
  }
  
  @NonNull
  public arpy a(int paramInt)
  {
    return new arpy();
  }
  
  @Nullable
  public arpy a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arpy.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arpy paramarpy)
  {
    if ((paramarpy != null) && (!TextUtils.isEmpty(paramarpy.b()))) {
      ((bedn)BaseApplicationImpl.getApplication().getRuntime().getManager(305)).a(paramarpy);
    }
  }
  
  public Class<arpy> clazz()
  {
    return arpy.class;
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
 * Qualified Name:     arqb
 * JD-Core Version:    0.7.0.1
 */