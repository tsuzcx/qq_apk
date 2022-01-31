import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amvp
  extends ampb<amvq>
{
  public int a()
  {
    return 368;
  }
  
  @NonNull
  public amvq a(int paramInt)
  {
    return new amvq();
  }
  
  @Nullable
  public amvq a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      amvq localamvq = new amvq();
      localamvq.a(paramArrayOfampi);
      return localamvq;
    }
    return new amvq();
  }
  
  public Class<amvq> a()
  {
    return amvq.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amvq paramamvq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[onUpdate]");
    }
  }
  
  public int b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)onk.a();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.c();
      return bbjn.N(localQQAppInterface.getApp(), str);
    }
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amvp
 * JD-Core Version:    0.7.0.1
 */