import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ardm
  extends arac<ardl>
{
  @NonNull
  public ardl a(int paramInt)
  {
    return new ardl().b("0");
  }
  
  @Nullable
  public ardl a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      ardl localardl = ardl.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("C2CLovePushGrayProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localardl;
    }
    return null;
  }
  
  public void a(ardl paramardl) {}
  
  public Class<ardl> clazz()
  {
    return ardl.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CLovePushGrayProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 452;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardm
 * JD-Core Version:    0.7.0.1
 */