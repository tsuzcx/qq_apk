import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import mqq.app.AppRuntime;

public class arnk
  extends aqwt<arnh>
{
  public static arnh a()
  {
    return (arnh)aqxe.a().a(383);
  }
  
  @NonNull
  public arnh a(int paramInt)
  {
    return new arnh();
  }
  
  @Nullable
  public arnh a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arnh.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arnh paramarnh)
  {
    if ((paramarnh != null) && (!TextUtils.isEmpty(paramarnh.b()))) {
      ((beed)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER_DATALINE)).a(paramarnh);
    }
  }
  
  public Class<arnh> clazz()
  {
    return arnh.class;
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
 * Qualified Name:     arnk
 * JD-Core Version:    0.7.0.1
 */