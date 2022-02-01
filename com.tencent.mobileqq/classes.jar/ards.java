import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class ards
  extends arac<ardr>
{
  @NonNull
  public ardr a(int paramInt)
  {
    return new ardr();
  }
  
  @Nullable
  public ardr a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      ardr localardr = ardr.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DonDisturbProcessor", 0, "onParsed don disturb" + paramArrayOfaraj[0].a);
      }
      return localardr;
    }
    return new ardr();
  }
  
  public void a(ardr paramardr)
  {
    bhsi.a(BaseApplicationImpl.getContext(), "open_don_disturb", BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramardr.a());
    if (QLog.isColorLevel()) {
      QLog.d("DonDisturbProcessor", 0, "onUpdate don disturb" + paramardr);
    }
  }
  
  public Class<ardr> clazz()
  {
    return ardr.class;
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
    return 453;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ards
 * JD-Core Version:    0.7.0.1
 */