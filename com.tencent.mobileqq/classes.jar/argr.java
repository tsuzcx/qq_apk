import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class argr
  extends aqwt<argq>
{
  public static argq a()
  {
    return (argq)aqxe.a().a(635);
  }
  
  @NonNull
  public argq a(int paramInt)
  {
    return new argq();
  }
  
  @Nullable
  public argq a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onParsed] config");
    argq localargq2 = null;
    argq localargq1;
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      localargq2 = argq.a(paramArrayOfaqxa[0].a);
      localargq1 = localargq2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
        localargq1 = localargq2;
      }
    }
    for (;;)
    {
      paramArrayOfaqxa = localargq1;
      if (localargq1 == null) {
        paramArrayOfaqxa = new argq();
      }
      return paramArrayOfaqxa;
      localargq1 = localargq2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed is null");
        localargq1 = localargq2;
      }
    }
  }
  
  public void a(argq paramargq)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onUpdate]");
  }
  
  public Class<argq> clazz()
  {
    return argq.class;
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
    return 635;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argr
 * JD-Core Version:    0.7.0.1
 */