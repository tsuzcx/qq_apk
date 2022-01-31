import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amkr
  extends alzl<amko>
{
  public static amko a()
  {
    amko localamko = (amko)alzw.a().a(529);
    if (localamko != null) {
      return localamko;
    }
    return new amko();
  }
  
  public int a()
  {
    return 529;
  }
  
  @NonNull
  public amko a(int paramInt)
  {
    return new amko();
  }
  
  @Nullable
  public amko a(alzs[] paramArrayOfalzs)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    if (paramArrayOfalzs != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfalzs.length > 0)
      {
        str = paramArrayOfalzs[0].a;
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
      paramArrayOfalzs = (amkp)amaf.a(str, amkp.class);
      localObject1 = new amko(str, paramArrayOfalzs);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfalzs)
    {
      for (;;)
      {
        QLog.e("SigTopicConfProcessor", 1, "readJsonOrXml failed", paramArrayOfalzs);
        paramArrayOfalzs = null;
      }
    }
  }
  
  public Class<amko> a()
  {
    return amko.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amko paramamko) {}
  
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
 * Qualified Name:     amkr
 * JD-Core Version:    0.7.0.1
 */