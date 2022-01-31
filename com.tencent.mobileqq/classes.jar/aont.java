import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aont
  extends aofy<aons>
{
  @NonNull
  public static aons a()
  {
    aons localaons2 = (aons)aogj.a().a(550);
    aons localaons1 = localaons2;
    if (localaons2 == null) {
      localaons1 = new aons();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "loadConfig(): bean = " + localaons1.toString());
    }
    return localaons1;
  }
  
  public int a()
  {
    return 550;
  }
  
  @NonNull
  public aons a(int paramInt)
  {
    return new aons();
  }
  
  @Nullable
  public aons a(aogf[] paramArrayOfaogf)
  {
    return aons.a(paramArrayOfaogf);
  }
  
  public Class a()
  {
    return aons.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aons paramaons)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).a(347))
      {
        ((aukl)((QQAppInterface)localObject).getManager(347)).a = paramaons;
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onUpdate bean = " + paramaons.toString());
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
 * Qualified Name:     aont
 * JD-Core Version:    0.7.0.1
 */