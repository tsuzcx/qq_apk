import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amsm
  extends ampb<amsl>
{
  public int a()
  {
    return 417;
  }
  
  @NonNull
  public amsl a(int paramInt)
  {
    return new amsl();
  }
  
  @Nullable
  public amsl a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      amsl localamsl = new amsl();
      localamsl.a = paramArrayOfampi[0].a;
      return localamsl;
    }
    return null;
  }
  
  public Class<amsl> a()
  {
    return amsl.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onReqNoReceive]");
    }
    amsl localamsl = (amsl)ampm.a().a(417);
    if (localamsl != null) {
      ((airz)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153)).d(localamsl.a);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amsl paramamsl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onUpdate]");
    }
    airz localairz = (airz)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(153);
    if (paramamsl != null) {}
    for (paramamsl = paramamsl.a;; paramamsl = null)
    {
      localairz.d(paramamsl);
      return;
    }
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
 * Qualified Name:     amsm
 * JD-Core Version:    0.7.0.1
 */