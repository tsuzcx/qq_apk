import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aqwi
  extends aqkz<aqwh>
{
  @NonNull
  public aqwh a(int paramInt)
  {
    return new aqwh();
  }
  
  @Nullable
  public aqwh a(aqlg[] paramArrayOfaqlg)
  {
    QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onParsed");
    if (paramArrayOfaqlg != null) {
      try
      {
        if (paramArrayOfaqlg.length > 0)
        {
          paramArrayOfaqlg = (aqwh)aqlu.a(paramArrayOfaqlg[0].a, aqwh.class);
          return paramArrayOfaqlg;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqlg) {}
    }
    return null;
  }
  
  public void a(aqwh paramaqwh)
  {
    if (paramaqwh == null) {
      QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onUpdate: newConf is null.");
    }
    label123:
    for (;;)
    {
      return;
      QLog.i("QFileFileReaderConfigProcessor<QFile>", 1, "onUpdate");
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {}
      for (localObject = (QQAppInterface)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label123;
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("file_reader_key", paramaqwh.a);
        localEditor.apply();
        localObject = (atam)((QQAppInterface)localObject).getManager(317);
        if (localObject == null) {
          break;
        }
        ((atam)localObject).a(paramaqwh);
        return;
      }
    }
  }
  
  public Class<aqwh> clazz()
  {
    return aqwh.class;
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
    return 645;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqwi
 * JD-Core Version:    0.7.0.1
 */