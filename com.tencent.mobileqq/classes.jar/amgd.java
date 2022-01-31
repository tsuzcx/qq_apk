import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amgd
  extends alzl<amge>
{
  public int a()
  {
    return 535;
  }
  
  @NonNull
  public amge a(int paramInt)
  {
    return new amge();
  }
  
  @Nullable
  public amge a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0) && (paramArrayOfalzs[0] != null))
    {
      amge localamge = amge.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessConfProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localamge;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amge> a()
  {
    return amge.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amge paramamge)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, "onUpdate " + paramamge.toString());
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
 * Qualified Name:     amgd
 * JD-Core Version:    0.7.0.1
 */