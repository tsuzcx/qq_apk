import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aokz
  extends aofy<aokx>
{
  public static aokx b(int paramInt)
  {
    aokx localaokx = (aokx)aogj.a().a(paramInt);
    if (localaokx != null) {
      return localaokx;
    }
    return new aokx();
  }
  
  public int a()
  {
    return 467;
  }
  
  @NonNull
  public aokx a(int paramInt)
  {
    return new aokx();
  }
  
  @Nullable
  public aokx a(aogf[] paramArrayOfaogf)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaogf != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaogf.length > 0)
      {
        localObject1 = paramArrayOfaogf[0].a;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label125;
        }
        QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] type=" + a() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfaogf = (aoky)aogt.a(localObject1, aoky.class);
      localObject1 = new aokx((String)localObject1, paramArrayOfaogf);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaogf)
    {
      for (;;)
      {
        QLog.i("OpenSdkSwitchProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfaogf);
        paramArrayOfaogf = null;
      }
    }
    label125:
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + a());
    return null;
  }
  
  public Class<aokx> a()
  {
    return aokx.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aokx paramaokx)
  {
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onUpdate] type=" + a() + ", content = " + paramaokx.a());
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
 * Qualified Name:     aokz
 * JD-Core Version:    0.7.0.1
 */