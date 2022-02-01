import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqdi
  extends aptq<apxz>
{
  public static apxz a()
  {
    return (apxz)apub.a().a(633);
  }
  
  @NonNull
  public apxz a(int paramInt)
  {
    return new apxz();
  }
  
  @Nullable
  public apxz a(aptx[] paramArrayOfaptx)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onParsed] config");
    Object localObject = null;
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null))
    {
      localapxz = apxz.a(paramArrayOfaptx[0].a);
      localObject = localapxz;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
        localObject = localapxz;
      }
    }
    while (!QLog.isColorLevel())
    {
      apxz localapxz;
      return localObject;
    }
    QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed is null");
    return null;
  }
  
  public void a(apxz paramapxz)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onUpdate]");
  }
  
  public Class<apxz> clazz()
  {
    return apxz.class;
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
 * Qualified Name:     aqdi
 * JD-Core Version:    0.7.0.1
 */