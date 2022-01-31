import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aonv
  extends aofy<aonu>
{
  @NonNull
  public static aonu a()
  {
    aonu localaonu2 = (aonu)aogj.a().a(435);
    aonu localaonu1 = localaonu2;
    if (localaonu2 == null) {
      localaonu1 = new aonu();
    }
    return localaonu1;
  }
  
  public int a()
  {
    return 435;
  }
  
  @NonNull
  public aonu a(int paramInt)
  {
    return new aonu();
  }
  
  @Nullable
  public aonu a(aogf[] paramArrayOfaogf)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaogf != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaogf.length > 0) {
        localObject1 = aonu.a(paramArrayOfaogf);
      }
    }
    return localObject1;
  }
  
  public Class<aonu> a()
  {
    return aonu.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aonu paramaonu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onUpdate " + paramaonu.toString());
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
 * Qualified Name:     aonv
 * JD-Core Version:    0.7.0.1
 */