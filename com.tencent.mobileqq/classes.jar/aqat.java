import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aqat
  extends aptq<aqas>
{
  @NonNull
  public aqas a(int paramInt)
  {
    return new aqas();
  }
  
  @Nullable
  public aqas a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      aqas localaqas = aqas.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QConfPushProcessor", 0, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localaqas;
    }
    return new aqas();
  }
  
  public void a(aqas paramaqas)
  {
    ((avni)BaseApplicationImpl.getApplication().getRuntime().getManager(308)).a(paramaqas);
    if (QLog.isColorLevel()) {
      QLog.d("QConfPushProcessor", 0, "onUpdate " + paramaqas);
    }
  }
  
  public Class<aqas> clazz()
  {
    return aqas.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 390;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqat
 * JD-Core Version:    0.7.0.1
 */