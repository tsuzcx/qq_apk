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

public class amhz
  extends alzl<amhy>
{
  public int a()
  {
    return 555;
  }
  
  @NonNull
  public amhy a(int paramInt)
  {
    return new amhy();
  }
  
  @Nullable
  public amhy a(alzs[] paramArrayOfalzs)
  {
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfalzs != null) {
      try
      {
        if (paramArrayOfalzs.length > 0)
        {
          paramArrayOfalzs = (amhy)amaf.a(paramArrayOfalzs[0].a, amhy.class);
          return paramArrayOfalzs;
        }
      }
      catch (QStorageInstantiateException paramArrayOfalzs)
      {
        QLog.e("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfalzs.getMessage());
      }
    }
    return null;
  }
  
  public Class<amhy> a()
  {
    return amhy.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amhy paramamhy)
  {
    if (paramamhy != null)
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
        if (TextUtils.isEmpty(paramamhy.a)) {
          paramamhy.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("groupfile_excitingdownload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_groupfile_excitingdownload", paramamhy.a);
        localEditor.apply();
        QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Download config [" + paramamhy.a + "]");
        localObject = (aofy)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aofy)localObject).a(paramamhy);
        }
      }
      return;
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhz
 * JD-Core Version:    0.7.0.1
 */