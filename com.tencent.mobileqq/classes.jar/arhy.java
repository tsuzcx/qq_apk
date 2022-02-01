import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arhy
  extends arac<arib>
{
  @NonNull
  public arib a(int paramInt)
  {
    return new arib();
  }
  
  @Nullable
  public arib a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arib.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arib paramarib)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiConfProcessor", 2, "QQSysAndEmojiConfProcessor onUpdate");
    }
    if (paramarib != null) {
      arib.a(paramarib);
    }
    asky.a().a();
  }
  
  public Class<arib> clazz()
  {
    return arib.class;
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
    return 545;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhy
 * JD-Core Version:    0.7.0.1
 */