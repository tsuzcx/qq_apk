import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqeq
  extends aptq<aqeo>
{
  public static aqeo a()
  {
    aqeo localaqeo2 = (aqeo)apub.a().a(583);
    aqeo localaqeo1 = localaqeo2;
    if (localaqeo2 == null) {
      localaqeo1 = new aqeo();
    }
    return localaqeo1;
  }
  
  @NonNull
  public aqeo a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aqeo();
  }
  
  @Nullable
  public aqeo a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBannerProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerProcessor", 2, "onParsed " + paramArrayOfaptx.length);
      }
      return aqeo.a(paramArrayOfaptx[0]);
    }
    return null;
  }
  
  public void a(aqeo paramaqeo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaqeo == null) {
        break label43;
      }
    }
    label43:
    for (paramaqeo = paramaqeo.toString();; paramaqeo = " empty")
    {
      QLog.d("ExtendFriendBannerProcessor", 2, paramaqeo);
      return;
    }
  }
  
  public Class<aqeo> clazz()
  {
    return aqeo.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 583;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqeq
 * JD-Core Version:    0.7.0.1
 */