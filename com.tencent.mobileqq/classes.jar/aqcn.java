import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqcn
  extends aptq<aqco>
{
  public static aqco a()
  {
    return (aqco)apub.a().a(647);
  }
  
  @NonNull
  public aqco a(int paramInt)
  {
    return new aqco();
  }
  
  @Nullable
  public aqco a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqco.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqco paramaqco)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaHttpsConfProcessor", 2, "RichmediaHttpsConfProcessor onUpdate");
    }
  }
  
  public Class<aqco> clazz()
  {
    return aqco.class;
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
    return 647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqcn
 * JD-Core Version:    0.7.0.1
 */