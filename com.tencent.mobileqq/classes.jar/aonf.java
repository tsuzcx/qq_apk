import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aonf
  extends aokh<aong>
{
  public static boolean a;
  private static boolean b;
  
  public static boolean e()
  {
    if (b) {
      return a;
    }
    b = true;
    a = f();
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean isSwitchOpened = " + a);
    }
    return a;
  }
  
  private static boolean f()
  {
    aong localaong2 = (aong)aoks.a().a(531);
    aong localaong1 = localaong2;
    if (localaong2 == null)
    {
      localaong2 = new aong();
      localaong1 = localaong2;
      if (QLog.isColorLevel())
      {
        QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean = null, general new bean, so switch default");
        localaong1 = localaong2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean switch isOpened = " + localaong1);
    }
    return localaong1.a();
  }
  
  public int a()
  {
    return 531;
  }
  
  @NonNull
  public aong a(int paramInt)
  {
    return new aong();
  }
  
  @Nullable
  public aong a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeConfigProcessor", 2, "onParsed : " + paramArrayOfaoko[0].a);
      }
      return aong.a(paramArrayOfaoko[0].a);
    }
    return new aong();
  }
  
  public Class<aong> a()
  {
    return aong.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aong paramaong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "onUpdate : " + paramaong);
    }
    if (paramaong != null) {
      a = paramaong.a();
    }
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
 * Qualified Name:     aonf
 * JD-Core Version:    0.7.0.1
 */