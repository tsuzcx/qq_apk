import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amwg
  extends ampa<amwh>
{
  public int a()
  {
    return 535;
  }
  
  @NonNull
  public amwh a(int paramInt)
  {
    return new amwh();
  }
  
  @Nullable
  public amwh a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amwh localamwh = amwh.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamwh;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amwh> a()
  {
    return amwh.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amwh paramamwh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, "onUpdate " + paramamwh.toString());
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, "migrateOldVersion");
    }
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
 * Qualified Name:     amwg
 * JD-Core Version:    0.7.0.1
 */