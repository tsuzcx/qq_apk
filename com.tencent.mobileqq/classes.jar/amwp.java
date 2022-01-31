import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amwp
  extends ampb<amwo>
{
  @NonNull
  public static amwo a()
  {
    amwo localamwo2 = (amwo)ampm.a().a(435);
    amwo localamwo1 = localamwo2;
    if (localamwo2 == null) {
      localamwo1 = new amwo();
    }
    return localamwo1;
  }
  
  public int a()
  {
    return 435;
  }
  
  @NonNull
  public amwo a(int paramInt)
  {
    return new amwo();
  }
  
  @Nullable
  public amwo a(ampi[] paramArrayOfampi)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfampi != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfampi.length > 0) {
        localObject1 = amwo.a(paramArrayOfampi);
      }
    }
    return localObject1;
  }
  
  public Class<amwo> a()
  {
    return amwo.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amwo paramamwo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onUpdate " + paramamwo.toString());
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
 * Qualified Name:     amwp
 * JD-Core Version:    0.7.0.1
 */