import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class anbc
  extends ampa<anaz>
{
  public static anaz a()
  {
    anaz localanaz = (anaz)ampl.a().a(529);
    if (localanaz != null) {
      return localanaz;
    }
    return new anaz();
  }
  
  public int a()
  {
    return 529;
  }
  
  @NonNull
  public anaz a(int paramInt)
  {
    return new anaz();
  }
  
  @Nullable
  public anaz a(amph[] paramArrayOfamph)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    if (paramArrayOfamph != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfamph.length > 0)
      {
        str = paramArrayOfamph[0].a;
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
      paramArrayOfamph = (anba)ampv.a(str, anba.class);
      localObject1 = new anaz(str, paramArrayOfamph);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfamph)
    {
      for (;;)
      {
        QLog.e("SigTopicConfProcessor", 1, "readJsonOrXml failed", paramArrayOfamph);
        paramArrayOfamph = null;
      }
    }
  }
  
  public Class<anaz> a()
  {
    return anaz.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(anaz paramanaz) {}
  
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
 * Qualified Name:     anbc
 * JD-Core Version:    0.7.0.1
 */