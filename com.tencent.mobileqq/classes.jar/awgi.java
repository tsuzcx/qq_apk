import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class awgi
  extends ampa<awgj>
{
  public int a()
  {
    return 485;
  }
  
  @NonNull
  public awgj a(int paramInt)
  {
    return new awgj();
  }
  
  @Nullable
  public awgj a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotConfigProcessor", 2, "onParsed : " + paramArrayOfamph[0].a);
      }
      return awgj.a(paramArrayOfamph[0].a);
    }
    return new awgj();
  }
  
  public Class<awgj> a()
  {
    return awgj.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public void a(awgj paramawgj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramawgj);
    }
    awgs.a(paramawgj);
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
 * Qualified Name:     awgi
 * JD-Core Version:    0.7.0.1
 */