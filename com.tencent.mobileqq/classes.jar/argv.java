import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class argv
  extends arac<argu>
{
  @NonNull
  public argu a(int paramInt)
  {
    return new argu();
  }
  
  @Nullable
  public argu a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      argu localargu = argu.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttWithTextSwitchProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localargu;
    }
    return null;
  }
  
  public void a(argu paramargu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttWithTextSwitchProcessor", 2, "onUpdate " + paramargu.toString());
    }
  }
  
  public Class<argu> clazz()
  {
    return argu.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    return 488;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argv
 * JD-Core Version:    0.7.0.1
 */