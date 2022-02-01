import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqdd
  extends aptq<aqde>
{
  @NonNull
  public aqde a(int paramInt)
  {
    return new aqde();
  }
  
  @Nullable
  public aqde a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null))
    {
      aqde localaqde = aqde.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessConfProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localaqde;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(aqde paramaqde)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, "onUpdate " + paramaqde.toString());
    }
  }
  
  public Class<aqde> clazz()
  {
    return aqde.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 535;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqdd
 * JD-Core Version:    0.7.0.1
 */