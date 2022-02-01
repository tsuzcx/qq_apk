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

public class ariy
  extends aqwt<arix>
{
  @NonNull
  public arix a(int paramInt)
  {
    return new arix();
  }
  
  @Nullable
  public arix a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaqxa != null) {
      try
      {
        if (paramArrayOfaqxa.length > 0)
        {
          paramArrayOfaqxa = (arix)aqxo.a(paramArrayOfaqxa[0].a, arix.class);
          return paramArrayOfaqxa;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqxa)
      {
        QLog.e("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaqxa.getMessage());
      }
    }
    return null;
  }
  
  public void a(arix paramarix)
  {
    if (paramarix != null)
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
        if (TextUtils.isEmpty(paramarix.a)) {
          paramarix.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("groupfile_excitingupload_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        localEditor.putString("qfile_groupfile_excitingupload", paramarix.a);
        localEditor.apply();
        QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramarix.a + "]");
        localObject = (atix)((QQAppInterface)localObject).getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
        if (localObject != null) {
          ((atix)localObject).a(paramarix);
        }
      }
      return;
    }
  }
  
  public Class<arix> clazz()
  {
    return arix.class;
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
    QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 554;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ariy
 * JD-Core Version:    0.7.0.1
 */