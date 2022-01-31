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

public class aoph
  extends aofy<aopg>
{
  public int a()
  {
    return 557;
  }
  
  @NonNull
  public aopg a(int paramInt)
  {
    return new aopg();
  }
  
  @Nullable
  public aopg a(aogf[] paramArrayOfaogf)
  {
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaogf != null) {
      try
      {
        if (paramArrayOfaogf.length > 0)
        {
          paramArrayOfaogf = (aopg)aogt.a(paramArrayOfaogf[0].a, aopg.class);
          return paramArrayOfaogf;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaogf)
      {
        QLog.e("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaogf.getMessage());
      }
    }
    return null;
  }
  
  public Class<aopg> a()
  {
    return aopg.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aopg paramaopg)
  {
    if (paramaopg != null)
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
        if (TextUtils.isEmpty(paramaopg.a)) {
          paramaopg.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("c2cfile_excitingupload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_c2cfile_excitingupload", paramaopg.a);
        localEditor.apply();
        QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramaopg.a + "]");
        localObject = (aqpu)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aqpu)localObject).a(paramaopg);
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
 * Qualified Name:     aoph
 * JD-Core Version:    0.7.0.1
 */