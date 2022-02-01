import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqdm
  extends aptq<aqdl>
{
  @NonNull
  public static aqdl a()
  {
    aqdl localaqdl2 = (aqdl)apub.a().a(550);
    aqdl localaqdl1 = localaqdl2;
    if (localaqdl2 == null) {
      localaqdl1 = new aqdl();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "loadConfig(): bean = " + localaqdl1.toString());
    }
    return localaqdl1;
  }
  
  @NonNull
  public aqdl a(int paramInt)
  {
    return new aqdl();
  }
  
  @Nullable
  public aqdl a(aptx[] paramArrayOfaptx)
  {
    return aqdl.a(paramArrayOfaptx);
  }
  
  public void a(aqdl paramaqdl)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).isCreateManager(347))
      {
        ((awby)((QQAppInterface)localObject).getManager(347)).a = paramaqdl;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onUpdate bean = " + paramaqdl.toString());
        }
      }
    }
  }
  
  public Class clazz()
  {
    return aqdl.class;
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
 * Qualified Name:     aqdm
 * JD-Core Version:    0.7.0.1
 */