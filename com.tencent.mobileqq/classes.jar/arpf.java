import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arpf
  extends arac<arpd>
{
  @NonNull
  public arpd a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VerticalSearchConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new arpd();
  }
  
  @Nullable
  public arpd a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerticalSearchConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalSearchConfProcessor", 2, "onParsed " + paramArrayOfaraj.length);
      }
      return arpd.a(paramArrayOfaraj[0]);
    }
    return null;
  }
  
  public void a(arpd paramarpd)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramarpd == null) {
        break label43;
      }
    }
    label43:
    for (paramarpd = paramarpd.toString();; paramarpd = " empty")
    {
      QLog.d("VerticalSearchConfProcessor", 2, paramarpd);
      return;
    }
  }
  
  public Class clazz()
  {
    return arpd.class;
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
      QLog.e("VerticalSearchConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 456;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arpf
 * JD-Core Version:    0.7.0.1
 */