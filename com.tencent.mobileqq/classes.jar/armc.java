import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class armc
  extends aqwt<armb>
{
  @NonNull
  public armb a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TroopRobotConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new armb();
  }
  
  @Nullable
  public armb a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfProcessor", 2, "onParsed " + paramArrayOfaqxa.length);
      }
      return armb.a(paramArrayOfaqxa[0]);
    }
    return null;
  }
  
  public void a(armb paramarmb)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramarmb == null) {
        break label58;
      }
    }
    label58:
    for (String str = paramarmb.toString();; str = " empty")
    {
      QLog.d("TroopRobotConfProcessor", 2, str);
      if (paramarmb != null) {
        bghs.a(paramarmb.a(), paramarmb.a());
      }
      return;
    }
  }
  
  public Class<armb> clazz()
  {
    return armb.class;
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
      QLog.e("TroopRobotConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 460;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armc
 * JD-Core Version:    0.7.0.1
 */