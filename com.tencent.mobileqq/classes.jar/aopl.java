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

public class aopl
  extends aofy<aopk>
{
  public int a()
  {
    return 555;
  }
  
  @NonNull
  public aopk a(int paramInt)
  {
    return new aopk();
  }
  
  @Nullable
  public aopk a(aogf[] paramArrayOfaogf)
  {
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaogf != null) {
      try
      {
        if (paramArrayOfaogf.length > 0)
        {
          paramArrayOfaogf = (aopk)aogt.a(paramArrayOfaogf[0].a, aopk.class);
          return paramArrayOfaogf;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaogf)
      {
        QLog.e("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaogf.getMessage());
      }
    }
    return null;
  }
  
  public Class<aopk> a()
  {
    return aopk.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aopk paramaopk)
  {
    if (paramaopk != null)
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
        if (TextUtils.isEmpty(paramaopk.a)) {
          paramaopk.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("groupfile_excitingdownload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_groupfile_excitingdownload", paramaopk.a);
        localEditor.apply();
        QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Download config [" + paramaopk.a + "]");
        localObject = (aqpu)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aqpu)localObject).a(paramaopk);
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
 * Qualified Name:     aopl
 * JD-Core Version:    0.7.0.1
 */