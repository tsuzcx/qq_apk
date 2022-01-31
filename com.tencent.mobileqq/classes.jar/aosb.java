import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aosb
  extends aofy<aosc>
{
  public int a()
  {
    return 589;
  }
  
  @NonNull
  public aosc a(int paramInt)
  {
    return new aosc();
  }
  
  @Nullable
  public aosc a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      aosc localaosc = aosc.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.i("UinSearchConfProcessor", 2, "onParsed: " + paramArrayOfaogf[0].a);
      }
      return localaosc;
    }
    return new aosc();
  }
  
  public Class<aosc> a()
  {
    return aosc.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UinSearchConfProcessor", 2, "onReqFailed: " + paramInt);
    }
  }
  
  public void a(aosc paramaosc)
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
 * Qualified Name:     aosb
 * JD-Core Version:    0.7.0.1
 */