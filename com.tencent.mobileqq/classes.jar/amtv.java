import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amtv
  extends ampa<amtt>
{
  public static amtt b(int paramInt)
  {
    amtt localamtt = (amtt)ampl.a().a(paramInt);
    if (localamtt != null) {
      return localamtt;
    }
    return new amtt();
  }
  
  public int a()
  {
    return 467;
  }
  
  @NonNull
  public amtt a(int paramInt)
  {
    return new amtt();
  }
  
  @Nullable
  public amtt a(amph[] paramArrayOfamph)
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
        QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] type=" + a() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfamph = (amtu)ampv.a(localObject1, amtu.class);
      localObject1 = new amtt((String)localObject1, paramArrayOfamph);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfamph)
    {
      for (;;)
      {
        QLog.i("OpenSdkSwitchProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfamph);
        paramArrayOfamph = null;
      }
    }
    label125:
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + a());
    return null;
  }
  
  public Class<amtt> a()
  {
    return amtt.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amtt paramamtt)
  {
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onUpdate] type=" + a() + ", content = " + paramamtt.a());
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
 * Qualified Name:     amtv
 * JD-Core Version:    0.7.0.1
 */