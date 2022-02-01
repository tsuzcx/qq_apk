import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class araf
  extends aqwt<arae>
{
  @NonNull
  public arae a(int paramInt)
  {
    return new arae().b("0");
  }
  
  @Nullable
  public arae a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      arae localarae = arae.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("C2CLovePushGrayProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarae;
    }
    return null;
  }
  
  public void a(arae paramarae) {}
  
  public Class<arae> clazz()
  {
    return arae.class;
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
 * Qualified Name:     araf
 * JD-Core Version:    0.7.0.1
 */