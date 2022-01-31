import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class awgg
  extends ampb<awgh>
{
  public int a()
  {
    return 485;
  }
  
  @NonNull
  public awgh a(int paramInt)
  {
    return new awgh();
  }
  
  @Nullable
  public awgh a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotConfigProcessor", 2, "onParsed : " + paramArrayOfampi[0].a);
      }
      return awgh.a(paramArrayOfampi[0].a);
    }
    return new awgh();
  }
  
  public Class<awgh> a()
  {
    return awgh.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public void a(awgh paramawgh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramawgh);
    }
    awgq.a(paramawgh);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awgg
 * JD-Core Version:    0.7.0.1
 */