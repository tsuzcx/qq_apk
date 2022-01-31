import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aopf
  extends aokh<aopc>
{
  public static aopc b(int paramInt)
  {
    aopc localaopc = (aopc)aoks.a().a(paramInt);
    if (localaopc != null) {
      return localaopc;
    }
    return new aopc();
  }
  
  public int a()
  {
    return 466;
  }
  
  @NonNull
  public aopc a(int paramInt)
  {
    return new aopc();
  }
  
  @Nullable
  public aopc a(aoko[] paramArrayOfaoko)
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
        QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] type=" + a() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfaoko = (aopd)aolc.a(localObject1, aopd.class);
      localObject1 = new aopc((String)localObject1, paramArrayOfaoko);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaoko)
    {
      for (;;)
      {
        QLog.i("OpenSdkRandomProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfaoko);
        paramArrayOfaoko = null;
      }
    }
    label125:
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + a());
    return null;
  }
  
  public Class<aopc> a()
  {
    return aopc.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aopc paramaopc)
  {
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onUpdate] type=" + a() + ", content = " + paramaopc.a());
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
 * Qualified Name:     aopf
 * JD-Core Version:    0.7.0.1
 */