import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class arlo
  extends arac<arln>
{
  @NonNull
  public arln a(int paramInt)
  {
    return new arln();
  }
  
  @Nullable
  public arln a(araj[] paramArrayOfaraj)
  {
    QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaraj != null) {
      try
      {
        if (paramArrayOfaraj.length > 0)
        {
          paramArrayOfaraj = (arln)arax.a(paramArrayOfaraj[0].a, arln.class);
          return paramArrayOfaraj;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaraj)
      {
        QLog.e("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaraj.getMessage());
      }
    }
    return null;
  }
  
  public void a(arln paramarln)
  {
    if (paramarln != null)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label152;
      }
    }
    label152:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        if (TextUtils.isEmpty(paramarln.a)) {
          paramarln.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("c2cfile_excitingdownload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_c2cfile_excitingdownload", paramarln.a);
        localEditor.apply();
        QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-C2C-Download config [" + paramarln.a + "]");
        localObject = (atsh)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((atsh)localObject).a(paramarln);
        }
      }
      return;
    }
  }
  
  public Class<arln> clazz()
  {
    return arln.class;
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
  
  public void onReqFailed(int paramInt)
  {
    QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 556;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arlo
 * JD-Core Version:    0.7.0.1
 */