import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class arbg
  extends arac<arbh>
{
  @NonNull
  public arbh a(int paramInt)
  {
    return new arbh();
  }
  
  @Nullable
  public arbh a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      arbh localarbh = arbh.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AEPituCameraConfigProcessor", 2, "onParsed:" + paramArrayOfaraj[0].a);
      }
      return localarbh;
    }
    return null;
  }
  
  public void a(arbh paramarbh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraConfigProcessor", 2, "onUpdate: " + paramarbh.a());
    }
    ShortVideoUtils.a(paramarbh.a());
  }
  
  public Class<arbh> clazz()
  {
    return arbh.class;
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
      QLog.d("AEPituCameraConfigProcessor", 2, "onSend: " + paramInt + ", isOpen:" + ShortVideoUtils.g());
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 574;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbg
 * JD-Core Version:    0.7.0.1
 */