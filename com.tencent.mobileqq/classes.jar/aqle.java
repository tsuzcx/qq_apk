import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aqle
  extends aptq<aqlb>
{
  public static aqlb a()
  {
    return (aqlb)apub.a().a(346);
  }
  
  @NonNull
  public aqlb a(int paramInt)
  {
    return new aqlb();
  }
  
  @Nullable
  public aqlb a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqlb.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqlb paramaqlb)
  {
    if ((paramaqlb != null) && (!TextUtils.isEmpty(paramaqlb.d()))) {
      ((bcws)BaseApplicationImpl.getApplication().getRuntime().getManager(272)).a(paramaqlb);
    }
  }
  
  public Class<aqlb> clazz()
  {
    return aqlb.class;
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
    return 346;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqle
 * JD-Core Version:    0.7.0.1
 */