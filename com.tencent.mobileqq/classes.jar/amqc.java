import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amqc
  extends ampa<amqd>
{
  public int a()
  {
    return 537;
  }
  
  @NonNull
  public amqd a(int paramInt)
  {
    return new amqd();
  }
  
  @Nullable
  public amqd a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      paramArrayOfamph = paramArrayOfamph[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed, content:" + paramArrayOfamph);
      }
      return amqd.a(paramArrayOfamph);
    }
    return new amqd();
  }
  
  public Class a()
  {
    return amqd.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public void a(amqd paramamqd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onUpdate");
    }
    axuk.a().a(paramamqd);
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
 * Qualified Name:     amqc
 * JD-Core Version:    0.7.0.1
 */