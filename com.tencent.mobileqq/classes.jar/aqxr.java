import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class aqxr
  extends aqwt<aqxs>
{
  public static aqxs a()
  {
    return (aqxs)aqxe.a().a(457);
  }
  
  @NonNull
  public aqxs a(int paramInt)
  {
    return new aqxs();
  }
  
  @Nullable
  public aqxs a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length == 0)) {
      return null;
    }
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor onParsed, content:" + paramArrayOfaqxa);
    }
    return aqxs.a(paramArrayOfaqxa);
  }
  
  public void a(aqxs paramaqxs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor update.");
    }
    ((anyb)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a();
  }
  
  public Class<aqxs> clazz()
  {
    return aqxs.class;
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
 * Qualified Name:     aqxr
 * JD-Core Version:    0.7.0.1
 */