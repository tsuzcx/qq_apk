import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amqd
  extends ampb<amqe>
{
  public int a()
  {
    return 537;
  }
  
  @NonNull
  public amqe a(int paramInt)
  {
    return new amqe();
  }
  
  @Nullable
  public amqe a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      paramArrayOfampi = paramArrayOfampi[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed, content:" + paramArrayOfampi);
      }
      return amqe.a(paramArrayOfampi);
    }
    return new amqe();
  }
  
  public Class a()
  {
    return amqe.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(amqe paramamqe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onUpdate");
    }
    axui.a().a(paramamqe);
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
 * Qualified Name:     amqd
 * JD-Core Version:    0.7.0.1
 */