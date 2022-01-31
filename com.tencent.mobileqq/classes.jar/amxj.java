import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amxj
  extends ampb<amxh>
{
  public static amxh a()
  {
    amxh localamxh2 = (amxh)ampm.a().a(583);
    amxh localamxh1 = localamxh2;
    if (localamxh2 == null) {
      localamxh1 = new amxh();
    }
    return localamxh1;
  }
  
  public int a()
  {
    return 583;
  }
  
  @NonNull
  public amxh a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new amxh();
  }
  
  @Nullable
  public amxh a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBannerProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerProcessor", 2, "onParsed " + paramArrayOfampi.length);
      }
      return amxh.a(paramArrayOfampi[0]);
    }
    return null;
  }
  
  public Class<amxh> a()
  {
    return amxh.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amxh paramamxh)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramamxh == null) {
        break label43;
      }
    }
    label43:
    for (paramamxh = paramamxh.toString();; paramamxh = " empty")
    {
      QLog.d("ExtendFriendBannerProcessor", 2, paramamxh);
      return;
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amxj
 * JD-Core Version:    0.7.0.1
 */