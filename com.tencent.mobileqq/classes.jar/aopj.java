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

@Deprecated
public class aopj
  extends aofy<aopi>
{
  public int a()
  {
    return 533;
  }
  
  @NonNull
  public aopi a(int paramInt)
  {
    return new aopi();
  }
  
  @Nullable
  public aopi a(aogf[] paramArrayOfaogf)
  {
    QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaogf != null) {
      try
      {
        if (paramArrayOfaogf.length > 0)
        {
          paramArrayOfaogf = (aopi)aogt.a(paramArrayOfaogf[0].a, aopi.class);
          return paramArrayOfaogf;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaogf)
      {
        QLog.e("QFileExcitingConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaogf.getMessage());
      }
    }
    return null;
  }
  
  public Class<aopi> a()
  {
    return aopi.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aopi paramaopi)
  {
    if (paramaopi != null)
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
        if (TextUtils.isEmpty(paramaopi.a)) {
          paramaopi.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_exciting_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_file_exciting", paramaopi.a);
        localEditor.apply();
        QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "save download config [" + paramaopi.a + "]");
        localObject = (aqpu)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aqpu)localObject).a(paramaopi);
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
 * Qualified Name:     aopj
 * JD-Core Version:    0.7.0.1
 */