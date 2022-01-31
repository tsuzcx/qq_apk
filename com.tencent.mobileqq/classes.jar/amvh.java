import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amvh
  extends ampb<amvi>
{
  public int a()
  {
    return 545;
  }
  
  @NonNull
  public amvi a(int paramInt)
  {
    return new amvi();
  }
  
  @Nullable
  public amvi a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return amvi.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<amvi> a()
  {
    return amvi.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amvi paramamvi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiConfProcessor", 2, "QQSysAndEmojiConfProcessor onUpdate");
    }
    anwm.a().a();
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
 * Qualified Name:     amvh
 * JD-Core Version:    0.7.0.1
 */