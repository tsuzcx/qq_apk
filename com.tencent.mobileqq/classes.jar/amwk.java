import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amwk
  extends ampa<amwi>
{
  public int a()
  {
    return 553;
  }
  
  @NonNull
  public amwi a(int paramInt)
  {
    return new amwi();
  }
  
  @Nullable
  public amwi a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amwi localamwi = amwi.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherEntryConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamwi;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amwi> a()
  {
    return amwi.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amwi paramamwi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, "onUpdate " + paramamwi.toString());
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, "migrateOldVersion");
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
 * Qualified Name:     amwk
 * JD-Core Version:    0.7.0.1
 */