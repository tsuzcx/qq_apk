import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import mqq.app.AppRuntime;

public class arop
  extends aqwt<arom>
{
  public static arom a()
  {
    return (arom)aqxe.a().a(346);
  }
  
  @NonNull
  public arom a(int paramInt)
  {
    return new arom();
  }
  
  @Nullable
  public arom a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arom.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arom paramarom)
  {
    if ((paramarom != null) && (!TextUtils.isEmpty(paramarom.d()))) {
      ((bedr)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a(paramarom);
    }
  }
  
  public Class<arom> clazz()
  {
    return arom.class;
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
 * Qualified Name:     arop
 * JD-Core Version:    0.7.0.1
 */