import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class aral
  extends aqwt<arak>
{
  @NonNull
  public arak a(int paramInt)
  {
    return new arak();
  }
  
  @Nullable
  public arak a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      arak localarak = arak.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DonDisturbProcessor", 0, "onParsed don disturb" + paramArrayOfaqxa[0].a);
      }
      return localarak;
    }
    return new arak();
  }
  
  public void a(arak paramarak)
  {
    bhhr.a(BaseApplicationImpl.getContext(), "open_don_disturb", BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramarak.a());
    if (QLog.isColorLevel()) {
      QLog.d("DonDisturbProcessor", 0, "onUpdate don disturb" + paramarak);
    }
  }
  
  public Class<arak> clazz()
  {
    return arak.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 453;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aral
 * JD-Core Version:    0.7.0.1
 */