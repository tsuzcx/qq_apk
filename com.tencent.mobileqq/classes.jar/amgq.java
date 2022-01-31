import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amgq
  extends alzl<amgp>
{
  public int a()
  {
    return 585;
  }
  
  @NonNull
  public amgp a(int paramInt)
  {
    return new amgp();
  }
  
  @Nullable
  public amgp a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0) && (paramArrayOfalzs[0] != null))
    {
      amgp localamgp = amgp.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVPreloadPskeyConfProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localamgp;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amgp> a()
  {
    return amgp.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amgp paramamgp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, "onUpdate " + paramamgp.toString());
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, "migrateOldVersion");
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
 * Qualified Name:     amgq
 * JD-Core Version:    0.7.0.1
 */