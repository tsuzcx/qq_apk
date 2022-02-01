import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class arax
  extends aqwt<araw>
{
  @NonNull
  public araw a(int paramInt)
  {
    return new araw();
  }
  
  @Nullable
  public araw a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      araw localaraw = new araw();
      localaraw.a = paramArrayOfaqxa[0].a;
      return localaraw;
    }
    return null;
  }
  
  public void a(araw paramaraw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onUpdate]");
    }
    amme localamme = (amme)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.APOLLO_MANAGER);
    if (paramaraw != null) {}
    for (paramaraw = paramaraw.a;; paramaraw = null)
    {
      localamme.d(paramaraw);
      return;
    }
  }
  
  public Class<araw> clazz()
  {
    return araw.class;
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
      QLog.d("GameCenterConfProcessor", 2, new Object[] { "[onReqFailed] failCode=", Integer.valueOf(paramInt) });
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterConfProcessor", 2, "[onReqNoReceive]");
    }
    araw localaraw = (araw)aqxe.a().a(417);
    if (localaraw != null) {
      ((amme)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.APOLLO_MANAGER)).d(localaraw.a);
    }
  }
  
  public int type()
  {
    return 417;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arax
 * JD-Core Version:    0.7.0.1
 */