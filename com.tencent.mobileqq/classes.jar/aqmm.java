import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqmm
  extends aqkz<aqml>
{
  public static void a()
  {
    aqml localaqml = (aqml)aqlk.a().a(430);
    aqml.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localaqml);
  }
  
  @NonNull
  public aqml a(int paramInt)
  {
    return new aqml();
  }
  
  @Nullable
  public aqml a(aqlg[] paramArrayOfaqlg)
  {
    return aqml.a(paramArrayOfaqlg);
  }
  
  public void a(aqml paramaqml)
  {
    QLog.w("ApolloConfig_GrayProcessor", 1, "onUpdate");
    aqml.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramaqml);
  }
  
  public Class<aqml> clazz()
  {
    return aqml.class;
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
    QLog.e("ApolloConfig_GrayProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public int type()
  {
    return 430;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqmm
 * JD-Core Version:    0.7.0.1
 */