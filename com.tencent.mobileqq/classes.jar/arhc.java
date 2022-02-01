import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arhc
  extends aqwt<arhb>
{
  @NonNull
  public arhb a(int paramInt)
  {
    return new arhb();
  }
  
  @Nullable
  public arhb a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      arhb localarhb = arhb.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVSecurityConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarhb;
    }
    return null;
  }
  
  public void a(arhb paramarhb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVSecurityConfProcessor", 2, "onUpdate " + paramarhb.toString());
    }
  }
  
  public Class<arhb> clazz()
  {
    return arhb.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 158;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhc
 * JD-Core Version:    0.7.0.1
 */