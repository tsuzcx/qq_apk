import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aosc
  extends aokh<aosb>
{
  @NonNull
  public static aosb a()
  {
    aosb localaosb2 = (aosb)aoks.a().a(550);
    aosb localaosb1 = localaosb2;
    if (localaosb2 == null) {
      localaosb1 = new aosb();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "loadConfig(): bean = " + localaosb1.toString());
    }
    return localaosb1;
  }
  
  public int a()
  {
    return 550;
  }
  
  @NonNull
  public aosb a(int paramInt)
  {
    return new aosb();
  }
  
  @Nullable
  public aosb a(aoko[] paramArrayOfaoko)
  {
    return aosb.a(paramArrayOfaoko);
  }
  
  public Class a()
  {
    return aosb.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aosb paramaosb)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).a(347))
      {
        ((auou)((QQAppInterface)localObject).getManager(347)).a = paramaosb;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onUpdate bean = " + paramaosb.toString());
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
 * Qualified Name:     aosc
 * JD-Core Version:    0.7.0.1
 */