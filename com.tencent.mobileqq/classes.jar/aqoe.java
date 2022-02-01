import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqoe
  extends aqkz<aqod>
{
  public static aqod a()
  {
    return (aqod)aqlk.a().a(452);
  }
  
  @NonNull
  public aqod a(int paramInt)
  {
    return new aqod().b("0");
  }
  
  @Nullable
  public aqod a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      aqod localaqod = aqod.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("C2CLovePushGrayProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaqod;
    }
    return null;
  }
  
  public void a(aqod paramaqod) {}
  
  public Class<aqod> clazz()
  {
    return aqod.class;
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
      QLog.d("C2CLovePushGrayProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 452;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqoe
 * JD-Core Version:    0.7.0.1
 */