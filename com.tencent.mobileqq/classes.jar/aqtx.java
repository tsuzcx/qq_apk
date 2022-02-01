import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqtx
  extends aqkz<aqtv>
{
  @NonNull
  public aqtv a(int paramInt)
  {
    return new aqtv();
  }
  
  @Nullable
  public aqtv a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      new aqtv();
      return aqtv.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqtv paramaqtv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocsPushProcessor", 2, "onUpdate " + paramaqtv.toString());
    }
  }
  
  public Class<aqtv> clazz()
  {
    return aqtv.class;
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
    return 418;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqtx
 * JD-Core Version:    0.7.0.1
 */