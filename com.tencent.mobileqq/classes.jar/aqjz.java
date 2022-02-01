import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aqjz
  extends aptq<aqjw>
{
  public static aqjw a()
  {
    return (aqjw)apub.a().a(383);
  }
  
  @NonNull
  public aqjw a(int paramInt)
  {
    return new aqjw();
  }
  
  @Nullable
  public aqjw a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return aqjw.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public void a(aqjw paramaqjw)
  {
    if ((paramaqjw != null) && (!TextUtils.isEmpty(paramaqjw.b()))) {
      ((bcxe)BaseApplicationImpl.getApplication().getRuntime().getManager(305)).a(paramaqjw);
    }
  }
  
  public Class<aqjw> clazz()
  {
    return aqjw.class;
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
    return 383;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqjz
 * JD-Core Version:    0.7.0.1
 */