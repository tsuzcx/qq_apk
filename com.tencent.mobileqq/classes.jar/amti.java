import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amti
  extends ampa<amtg>
{
  @NonNull
  public static amtg a()
  {
    amtg localamtg2 = (amtg)ampl.a().a(458);
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "loadConfig bean: " + localamtg2);
    }
    amtg localamtg1 = localamtg2;
    if (localamtg2 == null) {
      localamtg1 = new amtg();
    }
    return localamtg1;
  }
  
  public int a()
  {
    return 458;
  }
  
  @NonNull
  public amtg a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return new amtg();
  }
  
  @Nullable
  public amtg a(amph[] paramArrayOfamph)
  {
    return amtg.a(paramArrayOfamph);
  }
  
  public Class<amtg> a()
  {
    return amtg.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amtg paramamtg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate " + paramamtg.toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).a(34))
      {
        ((akbn)((QQAppInterface)localObject).getManager(34)).a = paramamtg;
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
 * Qualified Name:     amti
 * JD-Core Version:    0.7.0.1
 */