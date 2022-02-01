import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bdvl
  extends aqwt<bdvm>
{
  public static bdvm a()
  {
    return (bdvm)aqxe.a().a(610);
  }
  
  @NonNull
  public bdvm a(int paramInt)
  {
    return new bdvm();
  }
  
  @Nullable
  public bdvm a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StudyModeConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return bdvm.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public void a(bdvm parambdvm) {}
  
  public Class<bdvm> clazz()
  {
    return bdvm.class;
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
    return 610;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvl
 * JD-Core Version:    0.7.0.1
 */