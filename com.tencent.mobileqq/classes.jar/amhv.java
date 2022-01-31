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

public class amhv
  extends alzl<amhu>
{
  public int a()
  {
    return 557;
  }
  
  @NonNull
  public amhu a(int paramInt)
  {
    return new amhu();
  }
  
  @Nullable
  public amhu a(alzs[] paramArrayOfalzs)
  {
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfalzs != null) {
      try
      {
        if (paramArrayOfalzs.length > 0)
        {
          paramArrayOfalzs = (amhu)amaf.a(paramArrayOfalzs[0].a, amhu.class);
          return paramArrayOfalzs;
        }
      }
      catch (QStorageInstantiateException paramArrayOfalzs)
      {
        QLog.e("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfalzs.getMessage());
      }
    }
    return null;
  }
  
  public Class<amhu> a()
  {
    return amhu.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amhu paramamhu)
  {
    if (paramamhu != null)
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
        if (TextUtils.isEmpty(paramamhu.a)) {
          paramamhu.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("c2cfile_excitingupload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_c2cfile_excitingupload", paramamhu.a);
        localEditor.apply();
        QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramamhu.a + "]");
        localObject = (aofy)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aofy)localObject).a(paramamhu);
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
 * Qualified Name:     amhv
 * JD-Core Version:    0.7.0.1
 */