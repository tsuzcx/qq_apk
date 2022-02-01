import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aqzs
  extends aqkz<aqzp>
{
  public static aqzp a()
  {
    aqzp localaqzp = (aqzp)aqlk.a().a(529);
    if (localaqzp != null) {
      return localaqzp;
    }
    return new aqzp();
  }
  
  @NonNull
  public aqzp a(int paramInt)
  {
    return new aqzp();
  }
  
  @Nullable
  public aqzp a(aqlg[] paramArrayOfaqlg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    if (paramArrayOfaqlg != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaqlg.length > 0)
      {
        str = paramArrayOfaqlg[0].a;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str)) {
          if (QLog.isColorLevel()) {
            QLog.e("SigTopicConfProcessor", 1, "SigTopic.[onParsed] type=" + type() + ", content = " + str);
          }
        }
      }
    }
    try
    {
      paramArrayOfaqlg = (aqzq)aqlu.a(str, aqzq.class);
      localObject1 = new aqzp(str, paramArrayOfaqlg);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaqlg)
    {
      for (;;)
      {
        QLog.e("SigTopicConfProcessor", 1, "readJsonOrXml failed", paramArrayOfaqlg);
        paramArrayOfaqlg = null;
      }
    }
  }
  
  public void a(aqzp paramaqzp) {}
  
  public Class<aqzp> clazz()
  {
    return aqzp.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 529;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqzs
 * JD-Core Version:    0.7.0.1
 */