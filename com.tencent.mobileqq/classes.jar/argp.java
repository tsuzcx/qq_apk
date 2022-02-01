import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class argp
  extends aqwt<arbc>
{
  public static arbc a()
  {
    return (arbc)aqxe.a().a(633);
  }
  
  @NonNull
  public arbc a(int paramInt)
  {
    return new arbc();
  }
  
  @Nullable
  public arbc a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onParsed] config");
    Object localObject = null;
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      localarbc = arbc.a(paramArrayOfaqxa[0].a);
      localObject = localarbc;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
        localObject = localarbc;
      }
    }
    while (!QLog.isColorLevel())
    {
      arbc localarbc;
      return localObject;
    }
    QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed is null");
    return null;
  }
  
  public void a(arbc paramarbc)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onUpdate]");
  }
  
  public Class<arbc> clazz()
  {
    return arbc.class;
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
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 633;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argp
 * JD-Core Version:    0.7.0.1
 */