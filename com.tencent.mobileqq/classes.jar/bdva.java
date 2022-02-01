import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bdva
  extends arac<bdvb>
{
  public static bdvb a()
  {
    return (bdvb)aran.a().a(615);
  }
  
  @NonNull
  public bdvb a(int paramInt)
  {
    return new bdvb();
  }
  
  @Nullable
  public bdvb a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StudyModePushConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return bdvb.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(bdvb parambdvb) {}
  
  public Class<bdvb> clazz()
  {
    return bdvb.class;
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
    return 615;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdva
 * JD-Core Version:    0.7.0.1
 */