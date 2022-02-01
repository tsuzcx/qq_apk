import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class arpj
  extends arac<arpg>
{
  public static arpg a()
  {
    arpg localarpg = (arpg)aran.a().a(529);
    if (localarpg != null) {
      return localarpg;
    }
    return new arpg();
  }
  
  @NonNull
  public arpg a(int paramInt)
  {
    return new arpg();
  }
  
  @Nullable
  public arpg a(araj[] paramArrayOfaraj)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    if (paramArrayOfaraj != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaraj.length > 0)
      {
        str = paramArrayOfaraj[0].a;
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
      paramArrayOfaraj = (arph)arax.a(str, arph.class);
      localObject1 = new arpg(str, paramArrayOfaraj);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaraj)
    {
      for (;;)
      {
        QLog.e("SigTopicConfProcessor", 1, "readJsonOrXml failed", paramArrayOfaraj);
        paramArrayOfaraj = null;
      }
    }
  }
  
  public void a(arpg paramarpg) {}
  
  public Class<arpg> clazz()
  {
    return arpg.class;
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
 * Qualified Name:     arpj
 * JD-Core Version:    0.7.0.1
 */