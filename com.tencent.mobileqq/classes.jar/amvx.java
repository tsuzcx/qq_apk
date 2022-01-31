import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amvx
  extends ampb<amvy>
{
  public int a()
  {
    return 538;
  }
  
  @NonNull
  public amvy a(int paramInt)
  {
    return new amvy();
  }
  
  @Nullable
  public amvy a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      paramArrayOfampi = paramArrayOfampi[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed, content:" + paramArrayOfampi);
      }
      return amvy.a(paramArrayOfampi);
    }
    return new amvy();
  }
  
  public Class a()
  {
    return amvy.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(amvy paramamvy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onUpdate");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      localQQAppInterface.a().a = paramamvy;
      localQQAppInterface.getHwEngine().ipv6Switch = paramamvy.a;
      localQQAppInterface.getHwEngine().ipv6SwitchDual = paramamvy.b;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amvx
 * JD-Core Version:    0.7.0.1
 */