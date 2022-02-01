import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arfu
  extends aqwt<arfv>
{
  @NonNull
  public arfv a(int paramInt)
  {
    return new arfv();
  }
  
  @Nullable
  public arfv a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      paramArrayOfaqxa = paramArrayOfaqxa[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed, content:" + paramArrayOfaqxa);
      }
      return arfv.a(paramArrayOfaqxa);
    }
    return new arfv();
  }
  
  public void a(arfv paramarfv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onUpdate");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      localQQAppInterface.getTransFileController().mRichmediaIpv6ConifgBean = paramarfv;
      localQQAppInterface.getHwEngine().ipv6Switch = paramarfv.a;
    }
  }
  
  public Class clazz()
  {
    return arfv.class;
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
 * Qualified Name:     arfu
 * JD-Core Version:    0.7.0.1
 */