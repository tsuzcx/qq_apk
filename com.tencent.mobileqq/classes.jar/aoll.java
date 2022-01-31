import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aoll
  extends aofy<aolk>
{
  public int a()
  {
    return 488;
  }
  
  @NonNull
  public aolk a(int paramInt)
  {
    return new aolk();
  }
  
  @Nullable
  public aolk a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null))
    {
      aolk localaolk = aolk.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttWithTextSwitchProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaolk;
    }
    return null;
  }
  
  public Class<aolk> a()
  {
    return aolk.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aolk paramaolk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttWithTextSwitchProcessor", 2, "onUpdate " + paramaolk.toString());
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
 * Qualified Name:     aoll
 * JD-Core Version:    0.7.0.1
 */