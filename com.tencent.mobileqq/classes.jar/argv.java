import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class argv
  extends aqwt<argu>
{
  @NonNull
  public static argu a()
  {
    argu localargu2 = (argu)aqxe.a().a(435);
    argu localargu1 = localargu2;
    if (localargu2 == null) {
      localargu1 = new argu();
    }
    return localargu1;
  }
  
  @NonNull
  public argu a(int paramInt)
  {
    return new argu();
  }
  
  @Nullable
  public argu a(aqxa[] paramArrayOfaqxa)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqxa != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaqxa.length > 0) {
        localObject1 = argu.a(paramArrayOfaqxa);
      }
    }
    return localObject1;
  }
  
  public void a(argu paramargu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onUpdate " + paramargu.toString());
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopUrlConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 435;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argv
 * JD-Core Version:    0.7.0.1
 */