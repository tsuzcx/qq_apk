import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amwo
  extends ampa<amwn>
{
  @NonNull
  public static amwn a()
  {
    amwn localamwn2 = (amwn)ampl.a().a(435);
    amwn localamwn1 = localamwn2;
    if (localamwn2 == null) {
      localamwn1 = new amwn();
    }
    return localamwn1;
  }
  
  public int a()
  {
    return 435;
  }
  
  @NonNull
  public amwn a(int paramInt)
  {
    return new amwn();
  }
  
  @Nullable
  public amwn a(amph[] paramArrayOfamph)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfamph != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfamph.length > 0) {
        localObject1 = amwn.a(paramArrayOfamph);
      }
    }
    return localObject1;
  }
  
  public Class<amwn> a()
  {
    return amwn.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amwn paramamwn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onUpdate " + paramamwn.toString());
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
 * Qualified Name:     amwo
 * JD-Core Version:    0.7.0.1
 */