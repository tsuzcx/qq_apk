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

public class arlu
  extends arac<arlt>
{
  @NonNull
  public arlt a(int paramInt)
  {
    return new arlt();
  }
  
  @Nullable
  public arlt a(araj[] paramArrayOfaraj)
  {
    QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaraj != null) {
      try
      {
        if (paramArrayOfaraj.length > 0)
        {
          paramArrayOfaraj = (arlt)arax.a(paramArrayOfaraj[0].a, arlt.class);
          return paramArrayOfaraj;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaraj)
      {
        QLog.e("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaraj.getMessage());
      }
    }
    return null;
  }
  
  public void a(arlt paramarlt)
  {
    if (paramarlt != null)
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
        if (TextUtils.isEmpty(paramarlt.a)) {
          paramarlt.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("groupfile_excitingupload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_groupfile_excitingupload", paramarlt.a);
        localEditor.apply();
        QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramarlt.a + "]");
        localObject = (atsh)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((atsh)localObject).a(paramarlt);
        }
      }
      return;
    }
  }
  
  public Class<arlt> clazz()
  {
    return arlt.class;
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
 * Qualified Name:     arlu
 * JD-Core Version:    0.7.0.1
 */