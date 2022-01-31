import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aork
  extends aokh<aorl>
{
  public int a()
  {
    return 538;
  }
  
  @NonNull
  public aorl a(int paramInt)
  {
    return new aorl();
  }
  
  @Nullable
  public aorl a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      paramArrayOfaoko = paramArrayOfaoko[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed, content:" + paramArrayOfaoko);
      }
      return aorl.a(paramArrayOfaoko);
    }
    return new aorl();
  }
  
  public Class a()
  {
    return aorl.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(aorl paramaorl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onUpdate");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      localQQAppInterface.a().a = paramaorl;
      localQQAppInterface.getHwEngine().ipv6Switch = paramaorl.a;
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
 * Qualified Name:     aork
 * JD-Core Version:    0.7.0.1
 */