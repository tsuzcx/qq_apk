import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amkj
  extends alzl<amkk>
{
  public int a()
  {
    return 589;
  }
  
  @NonNull
  public amkk a(int paramInt)
  {
    return new amkk();
  }
  
  @Nullable
  public amkk a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      amkk localamkk = amkk.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.i("UinSearchConfProcessor", 2, "onParsed: " + paramArrayOfalzs[0].a);
      }
      return localamkk;
    }
    return new amkk();
  }
  
  public Class<amkk> a()
  {
    return amkk.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UinSearchConfProcessor", 2, "onReqFailed: " + paramInt);
    }
  }
  
  public void a(amkk paramamkk)
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
 * Qualified Name:     amkj
 * JD-Core Version:    0.7.0.1
 */