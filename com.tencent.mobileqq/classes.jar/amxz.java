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

public class amxz
  extends ampb<amxy>
{
  public int a()
  {
    return 557;
  }
  
  @NonNull
  public amxy a(int paramInt)
  {
    return new amxy();
  }
  
  @Nullable
  public amxy a(ampi[] paramArrayOfampi)
  {
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfampi != null) {
      try
      {
        if (paramArrayOfampi.length > 0)
        {
          paramArrayOfampi = (amxy)ampw.a(paramArrayOfampi[0].a, amxy.class);
          return paramArrayOfampi;
        }
      }
      catch (QStorageInstantiateException paramArrayOfampi)
      {
        QLog.e("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfampi.getMessage());
      }
    }
    return null;
  }
  
  public Class<amxy> a()
  {
    return amxy.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amxy paramamxy)
  {
    if (paramamxy != null)
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
        if (TextUtils.isEmpty(paramamxy.a)) {
          paramamxy.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("c2cfile_excitingupload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_c2cfile_excitingupload", paramamxy.a);
        localEditor.apply();
        QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramamxy.a + "]");
        localObject = (aows)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aows)localObject).a(paramamxy);
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
 * Qualified Name:     amxz
 * JD-Core Version:    0.7.0.1
 */