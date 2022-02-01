import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class aqxz
  extends aqwt<aqya>
{
  @NonNull
  public aqya a(int paramInt)
  {
    return new aqya();
  }
  
  @Nullable
  public aqya a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      aqya localaqya = aqya.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AEPituCameraConfigProcessor", 2, "onParsed:" + paramArrayOfaqxa[0].a);
      }
      return localaqya;
    }
    return null;
  }
  
  public void a(aqya paramaqya)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraConfigProcessor", 2, "onUpdate: " + paramaqya.a());
    }
    ShortVideoUtils.setAEPituCameraTaKeSameSwitch(paramaqya.a());
  }
  
  public Class<aqya> clazz()
  {
    return aqya.class;
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
 * Qualified Name:     aqxz
 * JD-Core Version:    0.7.0.1
 */