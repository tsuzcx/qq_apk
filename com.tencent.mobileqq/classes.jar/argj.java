import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class argj
  extends aqwt<argh>
{
  @NonNull
  public argh a(int paramInt)
  {
    return new argh();
  }
  
  @Nullable
  public argh a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      new argh();
      return argh.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(argh paramargh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocsPushProcessor", 2, "onUpdate " + paramargh.toString());
    }
  }
  
  public Class<argh> clazz()
  {
    return argh.class;
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
    return 418;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argj
 * JD-Core Version:    0.7.0.1
 */