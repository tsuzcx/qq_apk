import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amvw
  extends ampa<amvx>
{
  public int a()
  {
    return 538;
  }
  
  @NonNull
  public amvx a(int paramInt)
  {
    return new amvx();
  }
  
  @Nullable
  public amvx a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      paramArrayOfamph = paramArrayOfamph[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed, content:" + paramArrayOfamph);
      }
      return amvx.a(paramArrayOfamph);
    }
    return new amvx();
  }
  
  public Class a()
  {
    return amvx.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(amvx paramamvx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onUpdate");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      localQQAppInterface.a().a = paramamvx;
      localQQAppInterface.getHwEngine().ipv6Switch = paramamvx.a;
      localQQAppInterface.getHwEngine().ipv6SwitchDual = paramamvx.b;
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
 * Qualified Name:     amvw
 * JD-Core Version:    0.7.0.1
 */