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

public class aopn
  extends aofy<aopm>
{
  public int a()
  {
    return 554;
  }
  
  @NonNull
  public aopm a(int paramInt)
  {
    return new aopm();
  }
  
  @Nullable
  public aopm a(aogf[] paramArrayOfaogf)
  {
    QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaogf != null) {
      try
      {
        if (paramArrayOfaogf.length > 0)
        {
          paramArrayOfaogf = (aopm)aogt.a(paramArrayOfaogf[0].a, aopm.class);
          return paramArrayOfaogf;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaogf)
      {
        QLog.e("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaogf.getMessage());
      }
    }
    return null;
  }
  
  public Class<aopm> a()
  {
    return aopm.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aopm paramaopm)
  {
    if (paramaopm != null)
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
        if (TextUtils.isEmpty(paramaopm.a)) {
          paramaopm.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("groupfile_excitingupload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_groupfile_excitingupload", paramaopm.a);
        localEditor.apply();
        QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramaopm.a + "]");
        localObject = (aqpu)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aqpu)localObject).a(paramaopm);
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
 * Qualified Name:     aopn
 * JD-Core Version:    0.7.0.1
 */