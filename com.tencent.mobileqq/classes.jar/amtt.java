import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amtt
  extends ampb<amtq>
{
  public static amtq b(int paramInt)
  {
    amtq localamtq = (amtq)ampm.a().a(paramInt);
    if (localamtq != null) {
      return localamtq;
    }
    return new amtq();
  }
  
  public int a()
  {
    return 466;
  }
  
  @NonNull
  public amtq a(int paramInt)
  {
    return new amtq();
  }
  
  @Nullable
  public amtq a(ampi[] paramArrayOfampi)
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
        QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] type=" + a() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfampi = (amtr)ampw.a(localObject1, amtr.class);
      localObject1 = new amtq((String)localObject1, paramArrayOfampi);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfampi)
    {
      for (;;)
      {
        QLog.i("OpenSdkRandomProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfampi);
        paramArrayOfampi = null;
      }
    }
    label125:
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + a());
    return null;
  }
  
  public Class<amtq> a()
  {
    return amtq.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amtq paramamtq)
  {
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onUpdate] type=" + a() + ", content = " + paramamtq.a());
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
 * Qualified Name:     amtt
 * JD-Core Version:    0.7.0.1
 */