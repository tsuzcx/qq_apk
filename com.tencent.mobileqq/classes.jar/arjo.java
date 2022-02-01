import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arjo
  extends arac<arjm>
{
  @NonNull
  public arjm a(int paramInt)
  {
    return new arjm();
  }
  
  @Nullable
  public arjm a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      arjm localarjm = arjm.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherEntryConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarjm;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(arjm paramarjm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, "onUpdate " + paramarjm.toString());
    }
  }
  
  public Class<arjm> clazz()
  {
    return arjm.class;
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
      QLog.d("TogetherEntryConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherEntryConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 553;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjo
 * JD-Core Version:    0.7.0.1
 */