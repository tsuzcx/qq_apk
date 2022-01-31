import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aybl
  extends aofy<aybm>
{
  public int a()
  {
    return 485;
  }
  
  @NonNull
  public aybm a(int paramInt)
  {
    return new aybm();
  }
  
  @Nullable
  public aybm a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotConfigProcessor", 2, "onParsed : " + paramArrayOfaogf[0].a);
      }
      return aybm.a(paramArrayOfaogf[0].a);
    }
    return new aybm();
  }
  
  public Class<aybm> a()
  {
    return aybm.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public void a(aybm paramaybm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramaybm);
    }
    aybw.a(paramaybm);
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
 * Qualified Name:     aybl
 * JD-Core Version:    0.7.0.1
 */