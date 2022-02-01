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

public class ariw
  extends aqwt<ariv>
{
  @NonNull
  public ariv a(int paramInt)
  {
    return new ariv();
  }
  
  @Nullable
  public ariv a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaqxa != null) {
      try
      {
        if (paramArrayOfaqxa.length > 0)
        {
          paramArrayOfaqxa = (ariv)aqxo.a(paramArrayOfaqxa[0].a, ariv.class);
          return paramArrayOfaqxa;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqxa)
      {
        QLog.e("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaqxa.getMessage());
      }
    }
    return null;
  }
  
  public void a(ariv paramariv)
  {
    if (paramariv != null)
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
        if (TextUtils.isEmpty(paramariv.a)) {
          paramariv.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("groupfile_excitingdownload_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        localEditor.putString("qfile_groupfile_excitingdownload", paramariv.a);
        localEditor.apply();
        QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Download config [" + paramariv.a + "]");
        localObject = (atix)((QQAppInterface)localObject).getManager(QQManagerFactory.QFILE_CONFIG_MANAGER);
        if (localObject != null) {
          ((atix)localObject).a(paramariv);
        }
      }
      return;
    }
  }
  
  public Class<ariv> clazz()
  {
    return ariv.class;
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
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 555;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ariw
 * JD-Core Version:    0.7.0.1
 */