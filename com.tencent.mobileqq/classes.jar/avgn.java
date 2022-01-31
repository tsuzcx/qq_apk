import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class avgn
  extends alzl<avgo>
{
  public int a()
  {
    return 485;
  }
  
  @NonNull
  public avgo a(int paramInt)
  {
    return new avgo();
  }
  
  @Nullable
  public avgo a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotConfigProcessor", 2, "onParsed : " + paramArrayOfalzs[0].a);
      }
      return avgo.a(paramArrayOfalzs[0].a);
    }
    return new avgo();
  }
  
  public Class<avgo> a()
  {
    return avgo.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public void a(avgo paramavgo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramavgo);
    }
    avgx.a(paramavgo);
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
 * Qualified Name:     avgn
 * JD-Core Version:    0.7.0.1
 */