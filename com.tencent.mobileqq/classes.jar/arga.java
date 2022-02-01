import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arga
  extends aqwt<argb>
{
  @NonNull
  public argb a(int paramInt)
  {
    return new argb();
  }
  
  @Nullable
  public argb a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null)) {
      return argb.a(paramArrayOfaqxa[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(argb paramargb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, "onUpdate " + paramargb.toString());
    }
  }
  
  public Class<argb> clazz()
  {
    return argb.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 551;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arga
 * JD-Core Version:    0.7.0.1
 */