import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class aojl
  extends aofy<aojk>
{
  public static final String a = asiv.a + "GameCenterMsgConfigProcessor";
  
  public static aojk a()
  {
    return (aojk)aogj.a().a(608);
  }
  
  public int a()
  {
    return 608;
  }
  
  @NonNull
  public aojk a(int paramInt)
  {
    return new aojk();
  }
  
  @Nullable
  public aojk a(aogf[] paramArrayOfaogf)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "[onParsed]");
    }
    Object localObject1 = localObject2;
    if (paramArrayOfaogf != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaogf.length > 0)
      {
        localObject1 = aojk.a(paramArrayOfaogf);
        paramArrayOfaogf = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if ((paramArrayOfaogf != null) && (localObject1 != null)) {
          ((asil)paramArrayOfaogf.getManager(358)).a((aojk)localObject1);
        }
      }
    }
    return localObject1;
  }
  
  public Class<aojk> a()
  {
    return aojk.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onReqNoReceive: type=" + a());
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(aojk paramaojk)
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
 * Qualified Name:     aojl
 * JD-Core Version:    0.7.0.1
 */