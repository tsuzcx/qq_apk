import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqdv
  extends aptq<aqdu>
{
  @NonNull
  public aqdu a(int paramInt)
  {
    return new aqdu();
  }
  
  @Nullable
  public aqdu a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null))
    {
      aqdu localaqdu = aqdu.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVSecurityConfProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localaqdu;
    }
    return null;
  }
  
  public void a(aqdu paramaqdu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVSecurityConfProcessor", 2, "onUpdate " + paramaqdu.toString());
    }
  }
  
  public Class<aqdu> clazz()
  {
    return aqdu.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 158;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqdv
 * JD-Core Version:    0.7.0.1
 */