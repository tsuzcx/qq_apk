import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amwm
  extends ampa<amwl>
{
  @NonNull
  public static amwl a()
  {
    amwl localamwl2 = (amwl)ampl.a().a(550);
    amwl localamwl1 = localamwl2;
    if (localamwl2 == null) {
      localamwl1 = new amwl();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "loadConfig(): bean = " + localamwl1.toString());
    }
    return localamwl1;
  }
  
  public int a()
  {
    return 550;
  }
  
  @NonNull
  public amwl a(int paramInt)
  {
    return new amwl();
  }
  
  @Nullable
  public amwl a(amph[] paramArrayOfamph)
  {
    return amwl.a(paramArrayOfamph);
  }
  
  public Class a()
  {
    return amwl.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amwl paramamwl)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).a(347))
      {
        ((asto)((QQAppInterface)localObject).getManager(347)).a = paramamwl;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onUpdate bean = " + paramamwl.toString());
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
 * Qualified Name:     amwm
 * JD-Core Version:    0.7.0.1
 */