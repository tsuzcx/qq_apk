import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amhf
  extends alzl<amhd>
{
  public static amhd a()
  {
    amhd localamhd2 = (amhd)alzw.a().a(583);
    amhd localamhd1 = localamhd2;
    if (localamhd2 == null) {
      localamhd1 = new amhd();
    }
    return localamhd1;
  }
  
  public int a()
  {
    return 583;
  }
  
  @NonNull
  public amhd a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new amhd();
  }
  
  @Nullable
  public amhd a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBannerProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerProcessor", 2, "onParsed " + paramArrayOfalzs.length);
      }
      return amhd.a(paramArrayOfalzs[0]);
    }
    return null;
  }
  
  public Class<amhd> a()
  {
    return amhd.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amhd paramamhd)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramamhd == null) {
        break label43;
      }
    }
    label43:
    for (paramamhd = paramamhd.toString();; paramamhd = " empty")
    {
      QLog.d("ExtendFriendBannerProcessor", 2, paramamhd);
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
 * Qualified Name:     amhf
 * JD-Core Version:    0.7.0.1
 */