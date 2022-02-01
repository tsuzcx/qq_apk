import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arjt
  extends arac<arjs>
{
  @NonNull
  public static arjs a()
  {
    arjs localarjs2 = (arjs)aran.a().a(550);
    arjs localarjs1 = localarjs2;
    if (localarjs2 == null) {
      localarjs1 = new arjs();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "loadConfig(): bean = " + localarjs1.toString());
    }
    return localarjs1;
  }
  
  @NonNull
  public arjs a(int paramInt)
  {
    return new arjs();
  }
  
  @Nullable
  public arjs a(araj[] paramArrayOfaraj)
  {
    return arjs.a(paramArrayOfaraj);
  }
  
  public void a(arjs paramarjs)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).a(347))
      {
        ((axor)((QQAppInterface)localObject).getManager(347)).a = paramarjs;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onUpdate bean = " + paramarjs.toString());
        }
      }
    }
  }
  
  public Class clazz()
  {
    return arjs.class;
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
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 550;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjt
 * JD-Core Version:    0.7.0.1
 */