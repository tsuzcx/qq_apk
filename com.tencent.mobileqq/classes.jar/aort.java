import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aort
  extends aofy<aors>
{
  public int a()
  {
    return 460;
  }
  
  @NonNull
  public aors a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopRobotConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aors();
  }
  
  @Nullable
  public aors a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfProcessor", 2, "onParsed " + paramArrayOfaogf.length);
      }
      return aors.a(paramArrayOfaogf[0]);
    }
    return null;
  }
  
  public Class<aors> a()
  {
    return aors.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopRobotConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aors paramaors)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaors == null) {
        break label58;
      }
    }
    label58:
    for (String str = paramaors.toString();; str = " empty")
    {
      QLog.d("TroopRobotConfProcessor", 2, str);
      if (paramaors != null) {
        bcgx.a(paramaors.a(), paramaors.a());
      }
      return;
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
 * Qualified Name:     aort
 * JD-Core Version:    0.7.0.1
 */