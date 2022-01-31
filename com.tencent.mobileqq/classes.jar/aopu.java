import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aopu
  extends aokh<aopt>
{
  public int a()
  {
    return 488;
  }
  
  @NonNull
  public aopt a(int paramInt)
  {
    return new aopt();
  }
  
  @Nullable
  public aopt a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0) && (paramArrayOfaoko[0] != null))
    {
      aopt localaopt = aopt.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttWithTextSwitchProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaopt;
    }
    return null;
  }
  
  public Class<aopt> a()
  {
    return aopt.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aopt paramaopt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttWithTextSwitchProcessor", 2, "onUpdate " + paramaopt.toString());
    }
  }
  
  public boolean a()
  {
    return true;
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
 * Qualified Name:     aopu
 * JD-Core Version:    0.7.0.1
 */