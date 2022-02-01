import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arjr
  extends arac<arjq>
{
  public static arjq a()
  {
    return (arjq)aran.a().a(635);
  }
  
  @NonNull
  public arjq a(int paramInt)
  {
    return new arjq();
  }
  
  @Nullable
  public arjq a(araj[] paramArrayOfaraj)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onParsed] config");
    arjq localarjq2 = null;
    arjq localarjq1;
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      localarjq2 = arjq.a(paramArrayOfaraj[0].a);
      localarjq1 = localarjq2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
        localarjq1 = localarjq2;
      }
    }
    for (;;)
    {
      paramArrayOfaraj = localarjq1;
      if (localarjq1 == null) {
        paramArrayOfaraj = new arjq();
      }
      return paramArrayOfaraj;
      localarjq1 = localarjq2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed is null");
        localarjq1 = localarjq2;
      }
    }
  }
  
  public void a(arjq paramarjq)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onUpdate]");
  }
  
  public Class<arjq> clazz()
  {
    return arjq.class;
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
 * Qualified Name:     arjr
 * JD-Core Version:    0.7.0.1
 */