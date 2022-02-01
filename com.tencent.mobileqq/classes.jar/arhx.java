import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arhx
  extends aqwt<arhv>
{
  public static arhv a()
  {
    arhv localarhv2 = (arhv)aqxe.a().a(583);
    arhv localarhv1 = localarhv2;
    if (localarhv2 == null) {
      localarhv1 = new arhv();
    }
    return localarhv1;
  }
  
  @NonNull
  public arhv a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new arhv();
  }
  
  @Nullable
  public arhv a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBannerProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerProcessor", 2, "onParsed " + paramArrayOfaqxa.length);
      }
      return arhv.a(paramArrayOfaqxa[0]);
    }
    return null;
  }
  
  public void a(arhv paramarhv)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramarhv == null) {
        break label43;
      }
    }
    label43:
    for (paramarhv = paramarhv.toString();; paramarhv = " empty")
    {
      QLog.d("ExtendFriendBannerProcessor", 2, paramarhv);
      return;
    }
  }
  
  public Class<arhv> clazz()
  {
    return arhv.class;
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
 * Qualified Name:     arhx
 * JD-Core Version:    0.7.0.1
 */