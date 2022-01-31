import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class anav
  extends ampb<anas>
{
  public static anas a()
  {
    anas localanas = (anas)ampm.a().a(529);
    if (localanas != null) {
      return localanas;
    }
    return new anas();
  }
  
  public int a()
  {
    return 529;
  }
  
  @NonNull
  public anas a(int paramInt)
  {
    return new anas();
  }
  
  @Nullable
  public anas a(ampi[] paramArrayOfampi)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    if (paramArrayOfampi != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfampi.length > 0)
      {
        str = paramArrayOfampi[0].a;
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
      paramArrayOfampi = (anat)ampw.a(str, anat.class);
      localObject1 = new anas(str, paramArrayOfampi);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfampi)
    {
      for (;;)
      {
        QLog.e("SigTopicConfProcessor", 1, "readJsonOrXml failed", paramArrayOfampi);
        paramArrayOfampi = null;
      }
    }
  }
  
  public Class<anas> a()
  {
    return anas.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(anas paramanas) {}
  
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
 * Qualified Name:     anav
 * JD-Core Version:    0.7.0.1
 */