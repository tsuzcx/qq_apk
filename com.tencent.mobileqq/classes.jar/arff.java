import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class arff
  extends aqwt<arfe>
{
  @NonNull
  public arfe a(int paramInt)
  {
    return new arfe();
  }
  
  @Nullable
  public arfe a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("QuickHeartbeatConfigProcessor", 1, "[onParsed] config");
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      arfe localarfe = arfe.a(paramArrayOfaqxa[0].a);
      QLog.d("QuickHeartbeatConfigProcessor", 1, "onParsed " + paramArrayOfaqxa[0].a);
      return localarfe;
    }
    QLog.d("QuickHeartbeatConfigProcessor", 1, "onParsed is null");
    return new arfe();
  }
  
  public void a(arfe paramarfe)
  {
    if (paramarfe != null)
    {
      bhhr.a(BaseApplicationImpl.getContext(), "common_sp_for_msf", "", true, "isSendQuickHBBackToForeground", Boolean.valueOf(paramarfe.a), 4);
      QLog.d("QuickHeartbeatConfigProcessor", 1, "onUpdate, newConf: " + paramarfe.toString());
    }
  }
  
  public Class<arfe> clazz()
  {
    return arfe.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    QLog.i("QuickHeartbeatConfigProcessor", 1, "[onReqFailed] failCode = " + paramInt);
  }
  
  public int type()
  {
    return 703;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arff
 * JD-Core Version:    0.7.0.1
 */