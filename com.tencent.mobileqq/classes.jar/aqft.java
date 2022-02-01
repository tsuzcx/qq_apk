import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aqft
  extends aptq<aqfs>
{
  @NonNull
  public aqfs a(int paramInt)
  {
    return new aqfs();
  }
  
  @Nullable
  public aqfs a(aptx[] paramArrayOfaptx)
  {
    QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onParsed");
    if (paramArrayOfaptx != null) {
      try
      {
        if (paramArrayOfaptx.length > 0)
        {
          paramArrayOfaptx = (aqfs)apul.a(paramArrayOfaptx[0].a, aqfs.class);
          return paramArrayOfaptx;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaptx) {}
    }
    return null;
  }
  
  public void a(aqfs paramaqfs)
  {
    if (paramaqfs == null) {
      QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onUpdate: newConf is null.");
    }
    label148:
    for (;;)
    {
      return;
      QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onUpdate: config[" + paramaqfs.a + "]");
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {}
      for (localObject = (QQAppInterface)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label148;
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        localEditor.putString("file_reader_key", paramaqfs.a);
        localEditor.apply();
        localObject = (aser)((QQAppInterface)localObject).getManager(317);
        if (localObject == null) {
          break;
        }
        ((aser)localObject).a(paramaqfs);
        return;
      }
    }
  }
  
  public Class<aqfs> clazz()
  {
    return aqfs.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 645;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqft
 * JD-Core Version:    0.7.0.1
 */