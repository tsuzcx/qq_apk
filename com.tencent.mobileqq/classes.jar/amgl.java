import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amgl
  extends alzl<amgk>
{
  @NonNull
  public static amgk a()
  {
    amgk localamgk2 = (amgk)alzw.a().a(435);
    amgk localamgk1 = localamgk2;
    if (localamgk2 == null) {
      localamgk1 = new amgk();
    }
    return localamgk1;
  }
  
  public int a()
  {
    return 435;
  }
  
  @NonNull
  public amgk a(int paramInt)
  {
    return new amgk();
  }
  
  @Nullable
  public amgk a(alzs[] paramArrayOfalzs)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfalzs != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfalzs.length > 0) {
        localObject1 = amgk.a(paramArrayOfalzs);
      }
    }
    return localObject1;
  }
  
  public Class<amgk> a()
  {
    return amgk.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amgk paramamgk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onUpdate " + paramamgk.toString());
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
 * Qualified Name:     amgl
 * JD-Core Version:    0.7.0.1
 */