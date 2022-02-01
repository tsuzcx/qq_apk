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

public class arls
  extends arac<arlr>
{
  @NonNull
  public arlr a(int paramInt)
  {
    return new arlr();
  }
  
  @Nullable
  public arlr a(araj[] paramArrayOfaraj)
  {
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaraj != null) {
      try
      {
        if (paramArrayOfaraj.length > 0)
        {
          paramArrayOfaraj = (arlr)arax.a(paramArrayOfaraj[0].a, arlr.class);
          return paramArrayOfaraj;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaraj)
      {
        QLog.e("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaraj.getMessage());
      }
    }
    return null;
  }
  
  public void a(arlr paramarlr)
  {
    if (paramarlr != null)
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
        if (TextUtils.isEmpty(paramarlr.a)) {
          paramarlr.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("groupfile_excitingdownload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_groupfile_excitingdownload", paramarlr.a);
        localEditor.apply();
        QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Download config [" + paramarlr.a + "]");
        localObject = (atsh)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((atsh)localObject).a(paramarlr);
        }
      }
      return;
    }
  }
  
  public Class<arlr> clazz()
  {
    return arlr.class;
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
 * Qualified Name:     arls
 * JD-Core Version:    0.7.0.1
 */