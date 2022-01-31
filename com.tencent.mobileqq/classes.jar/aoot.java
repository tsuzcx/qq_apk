import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aoot
  extends aokh<aoor>
{
  @NonNull
  public static aoor a()
  {
    aoor localaoor2 = (aoor)aoks.a().a(458);
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "loadConfig bean: " + localaoor2);
    }
    aoor localaoor1 = localaoor2;
    if (localaoor2 == null) {
      localaoor1 = new aoor();
    }
    return localaoor1;
  }
  
  public int a()
  {
    return 458;
  }
  
  @NonNull
  public aoor a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return new aoor();
  }
  
  @Nullable
  public aoor a(aoko[] paramArrayOfaoko)
  {
    return aoor.a(paramArrayOfaoko);
  }
  
  public Class<aoor> a()
  {
    return aoor.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aoor paramaoor)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate " + paramaoor.toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).a(34))
      {
        ((alxr)((QQAppInterface)localObject).getManager(34)).a = paramaoor;
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate bean");
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
 * Qualified Name:     aoot
 * JD-Core Version:    0.7.0.1
 */