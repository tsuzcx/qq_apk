import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class aonu
  extends aokh<aont>
{
  public static final String a = asne.a + "GameCenterMsgConfigProcessor";
  
  public static aont a()
  {
    return (aont)aoks.a().a(608);
  }
  
  public int a()
  {
    return 608;
  }
  
  @NonNull
  public aont a(int paramInt)
  {
    return new aont();
  }
  
  @Nullable
  public aont a(aoko[] paramArrayOfaoko)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "[onParsed]");
    }
    Object localObject1 = localObject2;
    if (paramArrayOfaoko != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaoko.length > 0)
      {
        localObject1 = aont.a(paramArrayOfaoko);
        paramArrayOfaoko = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if ((paramArrayOfaoko != null) && (localObject1 != null)) {
          ((asmu)paramArrayOfaoko.getManager(358)).a((aont)localObject1);
        }
      }
    }
    return localObject1;
  }
  
  public Class<aont> a()
  {
    return aont.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onReqNoReceive: type=" + a());
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(aont paramaont)
  {
    QLog.i(a, 1, "[onUpdate]");
  }
  
  public boolean a()
  {
    return true;
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
 * Qualified Name:     aonu
 * JD-Core Version:    0.7.0.1
 */