import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqrj
  extends aqkz<aqri>
{
  @NonNull
  public aqri a(int paramInt)
  {
    return new aqri();
  }
  
  @Nullable
  public aqri a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null))
    {
      aqri localaqri = aqri.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttAutoChangeProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaqri;
    }
    return null;
  }
  
  public void a(aqri paramaqri)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttAutoChangeProcessor", 2, "onUpdate " + paramaqri.toString());
    }
  }
  
  public Class<aqri> clazz()
  {
    return aqri.class;
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
    return 442;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqrj
 * JD-Core Version:    0.7.0.1
 */