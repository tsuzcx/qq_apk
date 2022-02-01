import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ardo
  extends aqwt<ardn>
{
  @NonNull
  public ardn a(int paramInt)
  {
    return new ardn();
  }
  
  @Nullable
  public ardn a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      ardn localardn = ardn.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttWithTextSwitchProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localardn;
    }
    return null;
  }
  
  public void a(ardn paramardn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttWithTextSwitchProcessor", 2, "onUpdate " + paramardn.toString());
    }
  }
  
  public Class<ardn> clazz()
  {
    return ardn.class;
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
 * Qualified Name:     ardo
 * JD-Core Version:    0.7.0.1
 */