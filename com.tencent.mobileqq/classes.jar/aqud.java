import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqud
  extends aqkz<aqpb>
{
  public static aqpb a()
  {
    return (aqpb)aqlk.a().a(633);
  }
  
  @NonNull
  public aqpb a(int paramInt)
  {
    return new aqpb();
  }
  
  @Nullable
  public aqpb a(aqlg[] paramArrayOfaqlg)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onParsed] config");
    Object localObject = null;
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null))
    {
      localaqpb = aqpb.a(paramArrayOfaqlg[0].a);
      localObject = localaqpb;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
        localObject = localaqpb;
      }
    }
    while (!QLog.isColorLevel())
    {
      aqpb localaqpb;
      return localObject;
    }
    QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed is null");
    return null;
  }
  
  public void a(aqpb paramaqpb)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onUpdate]");
  }
  
  public Class<aqpb> clazz()
  {
    return aqpb.class;
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
 * Qualified Name:     aqud
 * JD-Core Version:    0.7.0.1
 */