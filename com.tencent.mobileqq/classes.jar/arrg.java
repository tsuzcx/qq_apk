import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class arrg
  extends arac<arrd>
{
  public static arrd a()
  {
    return (arrd)aran.a().a(346);
  }
  
  @NonNull
  public arrd a(int paramInt)
  {
    return new arrd();
  }
  
  @Nullable
  public arrd a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arrd.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arrd paramarrd)
  {
    if ((paramarrd != null) && (!TextUtils.isEmpty(paramarrd.d()))) {
      ((bedb)BaseApplicationImpl.getApplication().getRuntime().getManager(272)).a(paramarrd);
    }
  }
  
  public Class<arrd> clazz()
  {
    return arrd.class;
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
    return 346;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arrg
 * JD-Core Version:    0.7.0.1
 */