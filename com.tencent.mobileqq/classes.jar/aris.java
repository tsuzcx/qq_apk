import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aris
  extends aqwt<arir>
{
  @NonNull
  public arir a(int paramInt)
  {
    return new arir();
  }
  
  @Nullable
  public arir a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaqxa != null) {
      try
      {
        if (paramArrayOfaqxa.length > 0)
        {
          paramArrayOfaqxa = (arir)aqxo.a(paramArrayOfaqxa[0].a, arir.class);
          return paramArrayOfaqxa;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqxa)
      {
        QLog.e("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaqxa.getMessage());
      }
    }
    return null;
  }
  
  public void a(arir paramarir)
  {
    if (paramarir != null)
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
        if (TextUtils.isEmpty(paramarir.a)) {
          paramarir.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("c2cfile_excitingdownload_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        localEditor.putString("qfile_c2cfile_excitingdownload", paramarir.a);
        localEditor.apply();
        QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-C2C-Download config [" + paramarir.a + "]");
        localObject = (atix)((QQAppInterface)localObject).getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
        if (localObject != null) {
          ((atix)localObject).a(paramarir);
        }
      }
      return;
    }
  }
  
  public Class<arir> clazz()
  {
    return arir.class;
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
 * Qualified Name:     aris
 * JD-Core Version:    0.7.0.1
 */