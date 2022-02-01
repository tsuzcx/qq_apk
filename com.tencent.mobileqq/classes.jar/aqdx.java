import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqdx
  extends aptq<aqdw>
{
  @NonNull
  public aqdw a(int paramInt)
  {
    return new aqdw();
  }
  
  @Nullable
  public aqdw a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null))
    {
      aqdw localaqdw = aqdw.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVStatisticsConfProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localaqdw;
    }
    return null;
  }
  
  public void a(aqdw paramaqdw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVStatisticsConfProcessor", 2, "onUpdate " + paramaqdw.toString());
    }
  }
  
  public Class<aqdw> clazz()
  {
    return aqdw.class;
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
    return 361;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqdx
 * JD-Core Version:    0.7.0.1
 */