import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arfs
  extends aqwt<arft>
{
  public static arft a()
  {
    return (arft)aqxe.a().a(647);
  }
  
  @NonNull
  public arft a(int paramInt)
  {
    return new arft();
  }
  
  @Nullable
  public arft a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return arft.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(arft paramarft)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaHttpsConfProcessor", 2, "RichmediaHttpsConfProcessor onUpdate");
    }
  }
  
  public Class<arft> clazz()
  {
    return arft.class;
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
    return 647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfs
 * JD-Core Version:    0.7.0.1
 */