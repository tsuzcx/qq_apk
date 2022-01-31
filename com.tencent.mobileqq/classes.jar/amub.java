import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amub
  extends ampb<amuc>
{
  public int a()
  {
    return 530;
  }
  
  @NonNull
  public amuc a(int paramInt)
  {
    return new amuc();
  }
  
  @Nullable
  public amuc a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      paramArrayOfampi = paramArrayOfampi[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("PicShareToWXConfigProcessor", 2, "onParsed, content:" + paramArrayOfampi);
      }
      return amuc.a(paramArrayOfampi);
    }
    return new amuc();
  }
  
  public Class a()
  {
    return amuc.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(amuc paramamuc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onUpdate");
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
 * Qualified Name:     amub
 * JD-Core Version:    0.7.0.1
 */