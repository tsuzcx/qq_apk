import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apvf
  extends aptq<apve>
{
  public static void a()
  {
    apve localapve = (apve)apub.a().a(67);
    apve.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false, localapve);
  }
  
  public static void b()
  {
    int i = apub.a().a(67, "");
    QLog.w("ApolloConfig_GlobalProcessor", 1, "resetApolloConfVersion localVersion:" + i);
    apub.a().a(67, 0);
  }
  
  @NonNull
  public apve a(int paramInt)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    if (paramInt == 1) {
      return new apve();
    }
    apve.a();
    return new apve();
  }
  
  @Nullable
  public apve a(aptx[] paramArrayOfaptx)
  {
    return apve.a(paramArrayOfaptx);
  }
  
  public void a(apve paramapve)
  {
    QLog.w("ApolloConfig_GlobalProcessor", 1, "onUpdate");
    apve.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true, paramapve);
  }
  
  public Class<apve> clazz()
  {
    return apve.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.e("ApolloConfig_GlobalProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloConfig_GlobalProcessor", 2, "onReqNoReceive");
    }
  }
  
  public int type()
  {
    return 67;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apvf
 * JD-Core Version:    0.7.0.1
 */