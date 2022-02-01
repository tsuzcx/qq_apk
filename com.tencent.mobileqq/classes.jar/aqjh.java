import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aqjh
  extends aptq<aqje>
{
  public static aqje a()
  {
    aqje localaqje = (aqje)apub.a().a(529);
    if (localaqje != null) {
      return localaqje;
    }
    return new aqje();
  }
  
  @NonNull
  public aqje a(int paramInt)
  {
    return new aqje();
  }
  
  @Nullable
  public aqje a(aptx[] paramArrayOfaptx)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    if (paramArrayOfaptx != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaptx.length > 0)
      {
        str = paramArrayOfaptx[0].a;
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
      paramArrayOfaptx = (aqjf)apul.a(str, aqjf.class);
      localObject1 = new aqje(str, paramArrayOfaptx);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaptx)
    {
      for (;;)
      {
        QLog.e("SigTopicConfProcessor", 1, "readJsonOrXml failed", paramArrayOfaptx);
        paramArrayOfaptx = null;
      }
    }
  }
  
  public void a(aqje paramaqje) {}
  
  public Class<aqje> clazz()
  {
    return aqje.class;
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
 * Qualified Name:     aqjh
 * JD-Core Version:    0.7.0.1
 */