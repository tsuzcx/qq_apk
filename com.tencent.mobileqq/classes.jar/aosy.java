import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aosy
  extends aokh<aosw>
{
  public static aosw a()
  {
    aosw localaosw2 = (aosw)aoks.a().a(583);
    aosw localaosw1 = localaosw2;
    if (localaosw2 == null) {
      localaosw1 = new aosw();
    }
    return localaosw1;
  }
  
  public int a()
  {
    return 583;
  }
  
  @NonNull
  public aosw a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aosw();
  }
  
  @Nullable
  public aosw a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBannerProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerProcessor", 2, "onParsed " + paramArrayOfaoko.length);
      }
      return aosw.a(paramArrayOfaoko[0]);
    }
    return null;
  }
  
  public Class<aosw> a()
  {
    return aosw.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aosw paramaosw)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaosw == null) {
        break label43;
      }
    }
    label43:
    for (paramaosw = paramaosw.toString();; paramaosw = " empty")
    {
      QLog.d("ExtendFriendBannerProcessor", 2, paramaosw);
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
 * Qualified Name:     aosy
 * JD-Core Version:    0.7.0.1
 */