import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aowk
  extends aokh<aowl>
{
  public int a()
  {
    return 589;
  }
  
  @NonNull
  public aowl a(int paramInt)
  {
    return new aowl();
  }
  
  @Nullable
  public aowl a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      aowl localaowl = aowl.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.i("UinSearchConfProcessor", 2, "onParsed: " + paramArrayOfaoko[0].a);
      }
      return localaowl;
    }
    return new aowl();
  }
  
  public Class<aowl> a()
  {
    return aowl.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UinSearchConfProcessor", 2, "onReqFailed: " + paramInt);
    }
  }
  
  public void a(aowl paramaowl)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UinSearchConfProcessor", 2, "onUpdate");
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
 * Qualified Name:     aowk
 * JD-Core Version:    0.7.0.1
 */