import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bdcj
  extends aqkz<bdck>
{
  public static bdck a()
  {
    return (bdck)aqlk.a().a(615);
  }
  
  @NonNull
  public bdck a(int paramInt)
  {
    return new bdck();
  }
  
  @Nullable
  public bdck a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StudyModePushConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return bdck.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(bdck parambdck) {}
  
  public Class<bdck> clazz()
  {
    return bdck.class;
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
 * Qualified Name:     bdcj
 * JD-Core Version:    0.7.0.1
 */