import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bdvq
  extends aqwt<bdvr>
{
  public static bdvr a()
  {
    return (bdvr)aqxe.a().a(615);
  }
  
  @NonNull
  public bdvr a(int paramInt)
  {
    return new bdvr();
  }
  
  @Nullable
  public bdvr a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StudyModePushConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return bdvr.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(bdvr parambdvr) {}
  
  public Class<bdvr> clazz()
  {
    return bdvr.class;
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
 * Qualified Name:     bdvq
 * JD-Core Version:    0.7.0.1
 */