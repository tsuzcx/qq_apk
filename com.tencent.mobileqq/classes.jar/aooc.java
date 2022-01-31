import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aooc
  extends aofy<aoob>
{
  public int a()
  {
    return 158;
  }
  
  @NonNull
  public aoob a(int paramInt)
  {
    return new aoob();
  }
  
  @Nullable
  public aoob a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null))
    {
      aoob localaoob = aoob.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVSecurityConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaoob;
    }
    return null;
  }
  
  public Class<aoob> a()
  {
    return aoob.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoob paramaoob)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVSecurityConfProcessor", 2, "onUpdate " + paramaoob.toString());
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
 * Qualified Name:     aooc
 * JD-Core Version:    0.7.0.1
 */