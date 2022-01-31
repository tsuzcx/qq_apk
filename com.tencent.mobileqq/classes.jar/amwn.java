import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amwn
  extends ampb<amwm>
{
  @NonNull
  public static amwm a()
  {
    amwm localamwm2 = (amwm)ampm.a().a(550);
    amwm localamwm1 = localamwm2;
    if (localamwm2 == null) {
      localamwm1 = new amwm();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "loadConfig(): bean = " + localamwm1.toString());
    }
    return localamwm1;
  }
  
  public int a()
  {
    return 550;
  }
  
  @NonNull
  public amwm a(int paramInt)
  {
    return new amwm();
  }
  
  @Nullable
  public amwm a(ampi[] paramArrayOfampi)
  {
    return amwm.a(paramArrayOfampi);
  }
  
  public Class a()
  {
    return amwm.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amwm paramamwm)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).a(347))
      {
        ((astm)((QQAppInterface)localObject).getManager(347)).a = paramamwm;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onUpdate bean = " + paramamwm.toString());
        }
      }
    }
  }
  
  public int b()
  {
    return 0;
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
 * Qualified Name:     amwn
 * JD-Core Version:    0.7.0.1
 */