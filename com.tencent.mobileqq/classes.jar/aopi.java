import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aopi
  extends aokh<aopg>
{
  public static aopg b(int paramInt)
  {
    aopg localaopg = (aopg)aoks.a().a(paramInt);
    if (localaopg != null) {
      return localaopg;
    }
    return new aopg();
  }
  
  public int a()
  {
    return 467;
  }
  
  @NonNull
  public aopg a(int paramInt)
  {
    return new aopg();
  }
  
  @Nullable
  public aopg a(aoko[] paramArrayOfaoko)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaoko != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaoko.length > 0)
      {
        localObject1 = paramArrayOfaoko[0].a;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label125;
        }
        QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] type=" + a() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfaoko = (aoph)aolc.a(localObject1, aoph.class);
      localObject1 = new aopg((String)localObject1, paramArrayOfaoko);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaoko)
    {
      for (;;)
      {
        QLog.i("OpenSdkSwitchProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfaoko);
        paramArrayOfaoko = null;
      }
    }
    label125:
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + a());
    return null;
  }
  
  public Class<aopg> a()
  {
    return aopg.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aopg paramaopg)
  {
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onUpdate] type=" + a() + ", content = " + paramaopg.a());
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
 * Qualified Name:     aopi
 * JD-Core Version:    0.7.0.1
 */