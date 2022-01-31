import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amwt
  extends ampa<amws>
{
  public int a()
  {
    return 585;
  }
  
  @NonNull
  public amws a(int paramInt)
  {
    return new amws();
  }
  
  @Nullable
  public amws a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amws localamws = amws.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVPreloadPskeyConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamws;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amws> a()
  {
    return amws.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amws paramamws)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, "onUpdate " + paramamws.toString());
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
 * Qualified Name:     amwt
 * JD-Core Version:    0.7.0.1
 */