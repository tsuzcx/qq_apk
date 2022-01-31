import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ayfu
  extends aokh<ayfv>
{
  public int a()
  {
    return 485;
  }
  
  @NonNull
  public ayfv a(int paramInt)
  {
    return new ayfv();
  }
  
  @Nullable
  public ayfv a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotConfigProcessor", 2, "onParsed : " + paramArrayOfaoko[0].a);
      }
      return ayfv.a(paramArrayOfaoko[0].a);
    }
    return new ayfv();
  }
  
  public Class<ayfv> a()
  {
    return ayfv.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public void a(ayfv paramayfv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramayfv);
    }
    aygf.a(paramayfv);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfu
 * JD-Core Version:    0.7.0.1
 */