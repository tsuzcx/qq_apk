import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aose
  extends aokh<aosd>
{
  @NonNull
  public static aosd a()
  {
    aosd localaosd2 = (aosd)aoks.a().a(435);
    aosd localaosd1 = localaosd2;
    if (localaosd2 == null) {
      localaosd1 = new aosd();
    }
    return localaosd1;
  }
  
  public int a()
  {
    return 435;
  }
  
  @NonNull
  public aosd a(int paramInt)
  {
    return new aosd();
  }
  
  @Nullable
  public aosd a(aoko[] paramArrayOfaoko)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaoko != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaoko.length > 0) {
        localObject1 = aosd.a(paramArrayOfaoko);
      }
    }
    return localObject1;
  }
  
  public Class<aosd> a()
  {
    return aosd.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aosd paramaosd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onUpdate " + paramaosd.toString());
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
 * Qualified Name:     aose
 * JD-Core Version:    0.7.0.1
 */