import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aokw
  extends aofy<aokt>
{
  public static aokt b(int paramInt)
  {
    aokt localaokt = (aokt)aogj.a().a(paramInt);
    if (localaokt != null) {
      return localaokt;
    }
    return new aokt();
  }
  
  public int a()
  {
    return 466;
  }
  
  @NonNull
  public aokt a(int paramInt)
  {
    return new aokt();
  }
  
  @Nullable
  public aokt a(aogf[] paramArrayOfaogf)
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
        QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] type=" + a() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfaogf = (aoku)aogt.a(localObject1, aoku.class);
      localObject1 = new aokt((String)localObject1, paramArrayOfaogf);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaogf)
    {
      for (;;)
      {
        QLog.i("OpenSdkRandomProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfaogf);
        paramArrayOfaogf = null;
      }
    }
    label125:
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + a());
    return null;
  }
  
  public Class<aokt> a()
  {
    return aokt.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aokt paramaokt)
  {
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onUpdate] type=" + a() + ", content = " + paramaokt.a());
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
 * Qualified Name:     aokw
 * JD-Core Version:    0.7.0.1
 */