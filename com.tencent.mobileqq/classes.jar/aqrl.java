import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqrl
  extends aqkz<aqrk>
{
  @NonNull
  public aqrk a(int paramInt)
  {
    return new aqrk();
  }
  
  @Nullable
  public aqrk a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null))
    {
      aqrk localaqrk = aqrk.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttWithTextSwitchProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaqrk;
    }
    return null;
  }
  
  public void a(aqrk paramaqrk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttWithTextSwitchProcessor", 2, "onUpdate " + paramaqrk.toString());
    }
  }
  
  public Class<aqrk> clazz()
  {
    return aqrk.class;
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
    return 488;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqrl
 * JD-Core Version:    0.7.0.1
 */