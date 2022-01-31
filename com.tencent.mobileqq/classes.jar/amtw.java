import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amtw
  extends ampb<amtu>
{
  public static amtu b(int paramInt)
  {
    amtu localamtu = (amtu)ampm.a().a(paramInt);
    if (localamtu != null) {
      return localamtu;
    }
    return new amtu();
  }
  
  public int a()
  {
    return 467;
  }
  
  @NonNull
  public amtu a(int paramInt)
  {
    return new amtu();
  }
  
  @Nullable
  public amtu a(ampi[] paramArrayOfampi)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfampi != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfampi.length > 0)
      {
        localObject1 = paramArrayOfampi[0].a;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label125;
        }
        QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] type=" + a() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfampi = (amtv)ampw.a(localObject1, amtv.class);
      localObject1 = new amtu((String)localObject1, paramArrayOfampi);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfampi)
    {
      for (;;)
      {
        QLog.i("OpenSdkSwitchProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfampi);
        paramArrayOfampi = null;
      }
    }
    label125:
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + a());
    return null;
  }
  
  public Class<amtu> a()
  {
    return amtu.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amtu paramamtu)
  {
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onUpdate] type=" + a() + ", content = " + paramamtu.a());
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
 * Qualified Name:     amtw
 * JD-Core Version:    0.7.0.1
 */