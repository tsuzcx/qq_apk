import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager;

public class aoqd
  extends aokh<Object>
{
  public int a()
  {
    return 310;
  }
  
  public Class<Object> a()
  {
    return Object.class;
  }
  
  @NonNull
  public Object a(int paramInt)
  {
    return new Object();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onReqFailed");
    }
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onUpdate");
    }
  }
  
  public int b()
  {
    PtvTemplateManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    if (!PtvTemplateManager.a()) {
      return 0;
    }
    return bdne.l(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    PtvTemplateManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    if (!PtvTemplateManager.a())
    {
      QLog.i("QIMDoodleConfigProcessor", 1, "config file not exist");
      aoks.a().a(310, 0);
      return 0;
    }
    return super.b(paramInt);
  }
  
  @Nullable
  public Object b(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length == 0)) {
      return null;
    }
    paramArrayOfaoko = paramArrayOfaoko[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMDoodleConfigProcessor", 2, "handleQIMDoodleConfig onParsed, content:" + paramArrayOfaoko);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    PtvTemplateManager.a(localQQAppInterface).a(paramArrayOfaoko, localQQAppInterface);
    return new Object();
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqd
 * JD-Core Version:    0.7.0.1
 */