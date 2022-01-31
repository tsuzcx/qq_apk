import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aoop
  extends aofy<aoon>
{
  public static aoon a()
  {
    aoon localaoon2 = (aoon)aogj.a().a(583);
    aoon localaoon1 = localaoon2;
    if (localaoon2 == null) {
      localaoon1 = new aoon();
    }
    return localaoon1;
  }
  
  public int a()
  {
    return 583;
  }
  
  @NonNull
  public aoon a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aoon();
  }
  
  @Nullable
  public aoon a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBannerProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerProcessor", 2, "onParsed " + paramArrayOfaogf.length);
      }
      return aoon.a(paramArrayOfaogf[0]);
    }
    return null;
  }
  
  public Class<aoon> a()
  {
    return aoon.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aoon paramaoon)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaoon == null) {
        break label43;
      }
    }
    label43:
    for (paramaoon = paramaoon.toString();; paramaoon = " empty")
    {
      QLog.d("ExtendFriendBannerProcessor", 2, paramaoon);
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
 * Qualified Name:     aoop
 * JD-Core Version:    0.7.0.1
 */