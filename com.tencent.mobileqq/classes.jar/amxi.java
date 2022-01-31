import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amxi
  extends ampa<amxg>
{
  public static amxg a()
  {
    amxg localamxg2 = (amxg)ampl.a().a(583);
    amxg localamxg1 = localamxg2;
    if (localamxg2 == null) {
      localamxg1 = new amxg();
    }
    return localamxg1;
  }
  
  public int a()
  {
    return 583;
  }
  
  @NonNull
  public amxg a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new amxg();
  }
  
  @Nullable
  public amxg a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBannerProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerProcessor", 2, "onParsed " + paramArrayOfamph.length);
      }
      return amxg.a(paramArrayOfamph[0]);
    }
    return null;
  }
  
  public Class<amxg> a()
  {
    return amxg.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amxg paramamxg)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramamxg == null) {
        break label43;
      }
    }
    label43:
    for (paramamxg = paramamxg.toString();; paramamxg = " empty")
    {
      QLog.d("ExtendFriendBannerProcessor", 2, paramamxg);
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
 * Qualified Name:     amxi
 * JD-Core Version:    0.7.0.1
 */