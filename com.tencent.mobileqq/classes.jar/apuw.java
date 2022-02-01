import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class apuw
  extends aptq<apux>
{
  @NonNull
  public apux a(int paramInt)
  {
    return new apux();
  }
  
  @Nullable
  public apux a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      apux localapux = apux.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AEPituCameraConfigProcessor", 2, "onParsed:" + paramArrayOfaptx[0].a);
      }
      return localapux;
    }
    return null;
  }
  
  public void a(apux paramapux)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraConfigProcessor", 2, "onUpdate: " + paramapux.a());
    }
    ShortVideoUtils.setAEPituCameraTaKeSameSwitch(paramapux.a());
  }
  
  public Class<apux> clazz()
  {
    return apux.class;
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
  
  public int onSend(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraConfigProcessor", 2, "onSend: " + paramInt + ", isOpen:" + ShortVideoUtils.isAEPituTakeSameOpen());
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 574;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apuw
 * JD-Core Version:    0.7.0.1
 */