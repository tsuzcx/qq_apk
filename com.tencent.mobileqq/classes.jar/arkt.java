import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arkt
  extends arac<arkr>
{
  public static arkr a()
  {
    arkr localarkr2 = (arkr)aran.a().a(583);
    arkr localarkr1 = localarkr2;
    if (localarkr2 == null) {
      localarkr1 = new arkr();
    }
    return localarkr1;
  }
  
  @NonNull
  public arkr a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new arkr();
  }
  
  @Nullable
  public arkr a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBannerProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerProcessor", 2, "onParsed " + paramArrayOfaraj.length);
      }
      return arkr.a(paramArrayOfaraj[0]);
    }
    return null;
  }
  
  public void a(arkr paramarkr)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramarkr == null) {
        break label43;
      }
    }
    label43:
    for (paramarkr = paramarkr.toString();; paramarkr = " empty")
    {
      QLog.d("ExtendFriendBannerProcessor", 2, paramarkr);
      return;
    }
  }
  
  public Class<arkr> clazz()
  {
    return arkr.class;
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
 * Qualified Name:     arkt
 * JD-Core Version:    0.7.0.1
 */