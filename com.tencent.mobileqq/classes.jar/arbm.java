import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arbm
  extends arac<arbn>
{
  @NonNull
  public arbn a(int paramInt)
  {
    return new arbn();
  }
  
  @Nullable
  public arbn a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      paramArrayOfaraj = paramArrayOfaraj[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayConfigProcessor", 2, "onParsed, content:" + paramArrayOfaraj);
      }
      return arbn.a(paramArrayOfaraj);
    }
    return new arbn();
  }
  
  public void a(arbn paramarbn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onUpdate");
    }
    bdog.a().a(paramarbn);
  }
  
  public Class clazz()
  {
    return arbn.class;
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
      QLog.d("AIOVideoPlayConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 537;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbm
 * JD-Core Version:    0.7.0.1
 */