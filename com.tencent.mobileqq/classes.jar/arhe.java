import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;

public class arhe
  extends arac<Object>
{
  public Class<Object> clazz()
  {
    return Object.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  @NonNull
  public Object migrateOldOrDefaultContent(int paramInt)
  {
    return new Object();
  }
  
  public int migrateOldVersion()
  {
    PtvTemplateManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    if (!PtvTemplateManager.a()) {
      return 0;
    }
    return bhsi.k(BaseApplicationImpl.getContext());
  }
  
  @Nullable
  public Object onParsed(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length == 0)) {
      return null;
    }
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onParsed, content:" + paramArrayOfaraj);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    PtvTemplateManager.a(localQQAppInterface).a(paramArrayOfaraj, localQQAppInterface);
    return new Object();
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    PtvTemplateManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    if (!PtvTemplateManager.a())
    {
      QLog.i("QIMDoodleConfigProcessor", 1, "config file not exist");
      aran.a().a(310, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public void onUpdate(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onUpdate");
    }
  }
  
  public int type()
  {
    return 310;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhe
 * JD-Core Version:    0.7.0.1
 */