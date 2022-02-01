import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bdcf
  extends aqkz<bdcg>
{
  public static bdcg a()
  {
    return (bdcg)aqlk.a().a(610);
  }
  
  @NonNull
  public bdcg a(int paramInt)
  {
    return new bdcg();
  }
  
  @Nullable
  public bdcg a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StudyModeConfigProcessor", 2, "[onParsed]");
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return bdcg.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(bdcg parambdcg) {}
  
  public Class<bdcg> clazz()
  {
    return bdcg.class;
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
 * Qualified Name:     bdcf
 * JD-Core Version:    0.7.0.1
 */