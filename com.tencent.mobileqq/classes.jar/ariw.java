import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ariw
  extends arac<arix>
{
  @NonNull
  public arix a(int paramInt)
  {
    return new arix();
  }
  
  @Nullable
  public arix a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      paramArrayOfaraj = paramArrayOfaraj[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed, content:" + paramArrayOfaraj);
      }
      return arix.a(paramArrayOfaraj);
    }
    return new arix();
  }
  
  public void a(arix paramarix)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onUpdate");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      localQQAppInterface.a().a = paramarix;
      localQQAppInterface.getHwEngine().ipv6Switch = paramarix.a;
    }
  }
  
  public Class clazz()
  {
    return arix.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 538;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ariw
 * JD-Core Version:    0.7.0.1
 */