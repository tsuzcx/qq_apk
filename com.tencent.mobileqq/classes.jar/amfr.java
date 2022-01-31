import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amfr
  extends alzl<amfs>
{
  public int a()
  {
    return 538;
  }
  
  @NonNull
  public amfs a(int paramInt)
  {
    return new amfs();
  }
  
  @Nullable
  public amfs a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      paramArrayOfalzs = paramArrayOfalzs[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed, content:" + paramArrayOfalzs);
      }
      return amfs.a(paramArrayOfalzs);
    }
    return new amfs();
  }
  
  public Class a()
  {
    return amfs.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(amfs paramamfs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onUpdate");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      localQQAppInterface.a().a = paramamfs;
      localQQAppInterface.getHwEngine().ipv6Switch = paramamfs.a;
      localQQAppInterface.getHwEngine().ipv6SwitchDual = paramamfs.b;
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
 * Qualified Name:     amfr
 * JD-Core Version:    0.7.0.1
 */