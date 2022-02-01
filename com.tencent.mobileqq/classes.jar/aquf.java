import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aquf
  extends aqkz<aque>
{
  public static aque a()
  {
    return (aque)aqlk.a().a(635);
  }
  
  @NonNull
  public aque a(int paramInt)
  {
    return new aque();
  }
  
  @Nullable
  public aque a(aqlg[] paramArrayOfaqlg)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onParsed] config");
    aque localaque2 = null;
    aque localaque1;
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null))
    {
      localaque2 = aque.a(paramArrayOfaqlg[0].a);
      localaque1 = localaque2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
        localaque1 = localaque2;
      }
    }
    for (;;)
    {
      paramArrayOfaqlg = localaque1;
      if (localaque1 == null) {
        paramArrayOfaqlg = new aque();
      }
      return paramArrayOfaqlg;
      localaque1 = localaque2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed is null");
        localaque1 = localaque2;
      }
    }
  }
  
  public void a(aque paramaque)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onUpdate]");
  }
  
  public Class<aque> clazz()
  {
    return aque.class;
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
 * Qualified Name:     aquf
 * JD-Core Version:    0.7.0.1
 */