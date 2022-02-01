import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class arms
  extends aqwt<armp>
{
  public static armp a()
  {
    armp localarmp = (armp)aqxe.a().a(529);
    if (localarmp != null) {
      return localarmp;
    }
    return new armp();
  }
  
  @NonNull
  public armp a(int paramInt)
  {
    return new armp();
  }
  
  @Nullable
  public armp a(aqxa[] paramArrayOfaqxa)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    if (paramArrayOfaqxa != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaqxa.length > 0)
      {
        str = paramArrayOfaqxa[0].a;
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
      paramArrayOfaqxa = (armq)aqxo.a(str, armq.class);
      localObject1 = new armp(str, paramArrayOfaqxa);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaqxa)
    {
      for (;;)
      {
        QLog.e("SigTopicConfProcessor", 1, "readJsonOrXml failed", paramArrayOfaqxa);
        paramArrayOfaqxa = null;
      }
    }
  }
  
  public void a(armp paramarmp) {}
  
  public Class<armp> clazz()
  {
    return armp.class;
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
 * Qualified Name:     arms
 * JD-Core Version:    0.7.0.1
 */