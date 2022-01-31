import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class amqa
  extends ampa<amqb>
{
  public int a()
  {
    return 574;
  }
  
  @NonNull
  public amqb a(int paramInt)
  {
    return new amqb();
  }
  
  @Nullable
  public amqb a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      amqb localamqb = amqb.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AEPituCameraConfigProcessor", 2, "onParsed:" + paramArrayOfamph[0].a);
      }
      return localamqb;
    }
    return null;
  }
  
  public Class<amqb> a()
  {
    return amqb.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amqb paramamqb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraConfigProcessor", 2, "onUpdate: " + paramamqb.a());
    }
    ShortVideoUtils.a(paramamqb.a());
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
 * Qualified Name:     amqa
 * JD-Core Version:    0.7.0.1
 */