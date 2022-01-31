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
public class amhx
  extends alzl<amhw>
{
  public int a()
  {
    return 533;
  }
  
  @NonNull
  public amhw a(int paramInt)
  {
    return new amhw();
  }
  
  @Nullable
  public amhw a(alzs[] paramArrayOfalzs)
  {
    QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfalzs != null) {
      try
      {
        if (paramArrayOfalzs.length > 0)
        {
          paramArrayOfalzs = (amhw)amaf.a(paramArrayOfalzs[0].a, amhw.class);
          return paramArrayOfalzs;
        }
      }
      catch (QStorageInstantiateException paramArrayOfalzs)
      {
        QLog.e("QFileExcitingConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfalzs.getMessage());
      }
    }
    return null;
  }
  
  public Class<amhw> a()
  {
    return amhw.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amhw paramamhw)
  {
    if (paramamhw != null)
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
        if (TextUtils.isEmpty(paramamhw.a)) {
          paramamhw.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_exciting_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_file_exciting", paramamhw.a);
        localEditor.apply();
        QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "save download config [" + paramamhw.a + "]");
        localObject = (aofy)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aofy)localObject).a(paramamhw);
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
 * Qualified Name:     amhx
 * JD-Core Version:    0.7.0.1
 */