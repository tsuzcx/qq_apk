import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqvf
  extends aqkz<aqvd>
{
  public static aqvd a()
  {
    aqvd localaqvd2 = (aqvd)aqlk.a().a(583);
    aqvd localaqvd1 = localaqvd2;
    if (localaqvd2 == null) {
      localaqvd1 = new aqvd();
    }
    return localaqvd1;
  }
  
  @NonNull
  public aqvd a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aqvd();
  }
  
  @Nullable
  public aqvd a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBannerProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerProcessor", 2, "onParsed " + paramArrayOfaqlg.length);
      }
      return aqvd.a(paramArrayOfaqlg[0]);
    }
    return null;
  }
  
  public void a(aqvd paramaqvd)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaqvd == null) {
        break label43;
      }
    }
    label43:
    for (paramaqvd = paramaqvd.toString();; paramaqvd = " empty")
    {
      QLog.d("ExtendFriendBannerProcessor", 2, paramaqvd);
      return;
    }
  }
  
  public Class<aqvd> clazz()
  {
    return aqvd.class;
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
 * Qualified Name:     aqvf
 * JD-Core Version:    0.7.0.1
 */