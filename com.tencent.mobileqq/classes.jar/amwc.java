import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amwc
  extends ampb<amwd>
{
  public int a()
  {
    return 362;
  }
  
  @NonNull
  public amwd a(int paramInt)
  {
    return new amwd();
  }
  
  @Nullable
  public amwd a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      amwd localamwd = amwd.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowStoryConfig", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamwd;
    }
    return null;
  }
  
  public Class<amwd> a()
  {
    return amwd.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, "onReqFailed");
    }
  }
  
  public void a(amwd paramamwd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, new Object[] { paramamwd });
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
 * Qualified Name:     amwc
 * JD-Core Version:    0.7.0.1
 */