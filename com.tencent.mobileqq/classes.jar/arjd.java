import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arjd
  extends arac<arje>
{
  @NonNull
  public arje a(int paramInt)
  {
    return new arje();
  }
  
  @Nullable
  public arje a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      arje localarje = arje.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowStoryConfig", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarje;
    }
    return null;
  }
  
  public void a(arje paramarje)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, new Object[] { paramarje });
    }
  }
  
  public Class<arje> clazz()
  {
    return arje.class;
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
      QLog.d("SlideShowStoryConfig", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 362;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjd
 * JD-Core Version:    0.7.0.1
 */