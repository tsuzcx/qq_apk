import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aosp
  extends aokh<aoso>
{
  public int a()
  {
    return 207;
  }
  
  @NonNull
  public aoso a(int paramInt)
  {
    return new aoso();
  }
  
  @Nullable
  public aoso a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0) && (paramArrayOfaoko[0] != null))
    {
      aoso localaoso = aoso.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVWhiteListConfProcessor", 2, "onParsed  " + paramArrayOfaoko[0].a);
      }
      return localaoso;
    }
    return null;
  }
  
  public Class<aoso> a()
  {
    return aoso.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoso paramaoso)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVWhiteListConfProcessor", 2, "onUpdate " + paramaoso.toString());
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
 * Qualified Name:     aosp
 * JD-Core Version:    0.7.0.1
 */