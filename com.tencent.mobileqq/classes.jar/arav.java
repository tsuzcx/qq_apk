import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arav
  extends aqwt<arau>
{
  @NonNull
  public static arau a()
  {
    arau localarau2 = (arau)aqxe.a().a(455);
    arau localarau1 = localarau2;
    if (localarau2 == null) {
      localarau1 = new arau();
    }
    return localarau1;
  }
  
  @NonNull
  public arau a(int paramInt)
  {
    return new arau();
  }
  
  @Nullable
  public arau a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      arau localarau = arau.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarau;
    }
    return new arau();
  }
  
  public void a(arau paramarau)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramarau);
    }
  }
  
  public Class<arau> clazz()
  {
    return arau.class;
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
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public int type()
  {
    return 455;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arav
 * JD-Core Version:    0.7.0.1
 */