import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arjp
  extends arac<arej>
{
  public static arej a()
  {
    return (arej)aran.a().a(633);
  }
  
  @NonNull
  public arej a(int paramInt)
  {
    return new arej();
  }
  
  @Nullable
  public arej a(araj[] paramArrayOfaraj)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onParsed] config");
    Object localObject = null;
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      localarej = arej.a(paramArrayOfaraj[0].a);
      localObject = localarej;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
        localObject = localarej;
      }
    }
    while (!QLog.isColorLevel())
    {
      arej localarej;
      return localObject;
    }
    QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed is null");
    return null;
  }
  
  public void a(arej paramarej)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onUpdate]");
  }
  
  public Class<arej> clazz()
  {
    return arej.class;
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
 * Qualified Name:     arjp
 * JD-Core Version:    0.7.0.1
 */