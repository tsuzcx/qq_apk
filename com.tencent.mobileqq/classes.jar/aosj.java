import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aosj
  extends aofy<aosg>
{
  public static aosg a()
  {
    aosg localaosg = (aosg)aogj.a().a(529);
    if (localaosg != null) {
      return localaosg;
    }
    return new aosg();
  }
  
  public int a()
  {
    return 529;
  }
  
  @NonNull
  public aosg a(int paramInt)
  {
    return new aosg();
  }
  
  @Nullable
  public aosg a(aogf[] paramArrayOfaogf)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    if (paramArrayOfaogf != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaogf.length > 0)
      {
        str = paramArrayOfaogf[0].a;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str)) {
          if (QLog.isColorLevel()) {
            QLog.e("SigTopicConfProcessor", 1, "SigTopic.[onParsed] type=" + a() + ", content = " + str);
          }
        }
      }
    }
    try
    {
      paramArrayOfaogf = (aosh)aogt.a(str, aosh.class);
      localObject1 = new aosg(str, paramArrayOfaogf);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaogf)
    {
      for (;;)
      {
        QLog.e("SigTopicConfProcessor", 1, "readJsonOrXml failed", paramArrayOfaogf);
        paramArrayOfaogf = null;
      }
    }
  }
  
  public Class<aosg> a()
  {
    return aosg.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aosg paramaosg) {}
  
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
 * Qualified Name:     aosj
 * JD-Core Version:    0.7.0.1
 */