import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arkg
  extends arac<arkf>
{
  @NonNull
  public arkf a(int paramInt)
  {
    return new arkf();
  }
  
  @Nullable
  public arkf a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      arkf localarkf = arkf.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVWhiteListConfProcessor", 2, "onParsed  " + paramArrayOfaraj[0].a);
      }
      return localarkf;
    }
    return null;
  }
  
  public void a(arkf paramarkf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVWhiteListConfProcessor", 2, "onUpdate " + paramarkf.toString());
    }
  }
  
  public Class<arkf> clazz()
  {
    return arkf.class;
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
    return 207;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arkg
 * JD-Core Version:    0.7.0.1
 */