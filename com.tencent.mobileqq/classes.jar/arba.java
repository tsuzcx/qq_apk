import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arba
  extends arac<arbb>
{
  public static arbb a()
  {
    return (arbb)aran.a().a(457);
  }
  
  @NonNull
  public arbb a(int paramInt)
  {
    return new arbb();
  }
  
  @Nullable
  public arbb a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length == 0)) {
      return null;
    }
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor onParsed, content:" + paramArrayOfaraj);
    }
    return arbb.a(paramArrayOfaraj);
  }
  
  public void a(arbb paramarbb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor update.");
    }
    ((aobl)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(159)).a();
  }
  
  public Class<arbb> clazz()
  {
    return arbb.class;
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
    return 457;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arba
 * JD-Core Version:    0.7.0.1
 */