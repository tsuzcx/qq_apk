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

public class arlq
  extends arac<arlp>
{
  @NonNull
  public arlp a(int paramInt)
  {
    return new arlp();
  }
  
  @Nullable
  public arlp a(araj[] paramArrayOfaraj)
  {
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaraj != null) {
      try
      {
        if (paramArrayOfaraj.length > 0)
        {
          paramArrayOfaraj = (arlp)arax.a(paramArrayOfaraj[0].a, arlp.class);
          return paramArrayOfaraj;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaraj)
      {
        QLog.e("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaraj.getMessage());
      }
    }
    return null;
  }
  
  public void a(arlp paramarlp)
  {
    if (paramarlp != null)
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
        if (TextUtils.isEmpty(paramarlp.a)) {
          paramarlp.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("c2cfile_excitingupload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_c2cfile_excitingupload", paramarlp.a);
        localEditor.apply();
        QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramarlp.a + "]");
        localObject = (atsh)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((atsh)localObject).a(paramarlp);
        }
      }
      return;
    }
  }
  
  public Class<arlp> clazz()
  {
    return arlp.class;
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
 * Qualified Name:     arlq
 * JD-Core Version:    0.7.0.1
 */