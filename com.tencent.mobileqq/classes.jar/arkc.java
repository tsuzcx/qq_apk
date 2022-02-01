import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arkc
  extends arac<arkb>
{
  @NonNull
  public arkb a(int paramInt)
  {
    return new arkb();
  }
  
  @Nullable
  public arkb a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      arkb localarkb = arkb.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVSecurityConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarkb;
    }
    return null;
  }
  
  public void a(arkb paramarkb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVSecurityConfProcessor", 2, "onUpdate " + paramarkb.toString());
    }
  }
  
  public Class<arkb> clazz()
  {
    return arkb.class;
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
 * Qualified Name:     arkc
 * JD-Core Version:    0.7.0.1
 */