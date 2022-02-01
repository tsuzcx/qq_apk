import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bbwv
  extends arac<bbww>
{
  @NonNull
  public bbww a(int paramInt)
  {
    return new bbww();
  }
  
  @Nullable
  public bbww a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotConfigProcessor", 2, "onParsed : " + paramArrayOfaraj[0].a);
      }
      return bbww.a(paramArrayOfaraj[0].a);
    }
    return new bbww();
  }
  
  public void a(bbww parambbww)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + parambbww);
    }
    bbxg.a(parambbww);
  }
  
  public Class<bbww> clazz()
  {
    return bbww.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public int type()
  {
    return 485;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwv
 * JD-Core Version:    0.7.0.1
 */