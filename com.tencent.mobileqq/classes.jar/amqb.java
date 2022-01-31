import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class amqb
  extends ampb<amqc>
{
  public int a()
  {
    return 574;
  }
  
  @NonNull
  public amqc a(int paramInt)
  {
    return new amqc();
  }
  
  @Nullable
  public amqc a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      amqc localamqc = amqc.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AEPituCameraConfigProcessor", 2, "onParsed:" + paramArrayOfampi[0].a);
      }
      return localamqc;
    }
    return null;
  }
  
  public Class<amqc> a()
  {
    return amqc.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amqc paramamqc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraConfigProcessor", 2, "onUpdate: " + paramamqc.a());
    }
    ShortVideoUtils.a(paramamqc.a());
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public int b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraConfigProcessor", 2, "onSend: " + paramInt + ", isOpen:" + ShortVideoUtils.g());
    }
    return super.b(paramInt);
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
 * Qualified Name:     amqb
 * JD-Core Version:    0.7.0.1
 */