import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class arbr
  extends aqkz<arbo>
{
  public static arbo a()
  {
    return (arbo)aqlk.a().a(346);
  }
  
  @NonNull
  public arbo a(int paramInt)
  {
    return new arbo();
  }
  
  @Nullable
  public arbo a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return arbo.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(arbo paramarbo)
  {
    if ((paramarbo != null) && (!TextUtils.isEmpty(paramarbo.d()))) {
      ((bdkg)BaseApplicationImpl.getApplication().getRuntime().getManager(272)).a(paramarbo);
    }
  }
  
  public Class<arbo> clazz()
  {
    return arbo.class;
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
 * Qualified Name:     arbr
 * JD-Core Version:    0.7.0.1
 */