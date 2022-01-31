import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amts
  extends ampa<amtp>
{
  public static amtp b(int paramInt)
  {
    amtp localamtp = (amtp)ampl.a().a(paramInt);
    if (localamtp != null) {
      return localamtp;
    }
    return new amtp();
  }
  
  public int a()
  {
    return 466;
  }
  
  @NonNull
  public amtp a(int paramInt)
  {
    return new amtp();
  }
  
  @Nullable
  public amtp a(amph[] paramArrayOfamph)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfamph != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfamph.length > 0)
      {
        localObject1 = paramArrayOfamph[0].a;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label125;
        }
        QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] type=" + a() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfamph = (amtq)ampv.a(localObject1, amtq.class);
      localObject1 = new amtp((String)localObject1, paramArrayOfamph);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfamph)
    {
      for (;;)
      {
        QLog.i("OpenSdkRandomProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfamph);
        paramArrayOfamph = null;
      }
    }
    label125:
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + a());
    return null;
  }
  
  public Class<amtp> a()
  {
    return amtp.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amtp paramamtp)
  {
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onUpdate] type=" + a() + ", content = " + paramamtp.a());
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
 * Qualified Name:     amts
 * JD-Core Version:    0.7.0.1
 */