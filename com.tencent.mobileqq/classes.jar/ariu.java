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

public class ariu
  extends aqwt<arit>
{
  @NonNull
  public arit a(int paramInt)
  {
    return new arit();
  }
  
  @Nullable
  public arit a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaqxa != null) {
      try
      {
        if (paramArrayOfaqxa.length > 0)
        {
          paramArrayOfaqxa = (arit)aqxo.a(paramArrayOfaqxa[0].a, arit.class);
          return paramArrayOfaqxa;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqxa)
      {
        QLog.e("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaqxa.getMessage());
      }
    }
    return null;
  }
  
  public void a(arit paramarit)
  {
    if (paramarit != null)
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
        if (TextUtils.isEmpty(paramarit.a)) {
          paramarit.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("c2cfile_excitingupload_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        localEditor.putString("qfile_c2cfile_excitingupload", paramarit.a);
        localEditor.apply();
        QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramarit.a + "]");
        localObject = (atix)((QQAppInterface)localObject).getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
        if (localObject != null) {
          ((atix)localObject).a(paramarit);
        }
      }
      return;
    }
  }
  
  public Class<arit> clazz()
  {
    return arit.class;
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
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 557;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ariu
 * JD-Core Version:    0.7.0.1
 */