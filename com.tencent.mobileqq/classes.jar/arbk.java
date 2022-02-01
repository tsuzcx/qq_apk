import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arbk
  extends arac<arbl>
{
  public static arbl a()
  {
    return (arbl)aran.a().a(655);
  }
  
  @NonNull
  public arbl a(int paramInt)
  {
    return new arbl();
  }
  
  @Nullable
  public arbl a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arbl.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arbl paramarbl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORelatedEmotionConfProcessor", 2, "AIORelatedEmotionConfProcessor onUpdate");
    }
  }
  
  public Class<arbl> clazz()
  {
    return arbl.class;
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
    return 655;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbk
 * JD-Core Version:    0.7.0.1
 */