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
public class amyb
  extends ampb<amya>
{
  public int a()
  {
    return 533;
  }
  
  @NonNull
  public amya a(int paramInt)
  {
    return new amya();
  }
  
  @Nullable
  public amya a(ampi[] paramArrayOfampi)
  {
    QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfampi != null) {
      try
      {
        if (paramArrayOfampi.length > 0)
        {
          paramArrayOfampi = (amya)ampw.a(paramArrayOfampi[0].a, amya.class);
          return paramArrayOfampi;
        }
      }
      catch (QStorageInstantiateException paramArrayOfampi)
      {
        QLog.e("QFileExcitingConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfampi.getMessage());
      }
    }
    return null;
  }
  
  public Class<amya> a()
  {
    return amya.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amya paramamya)
  {
    if (paramamya != null)
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
        if (TextUtils.isEmpty(paramamya.a)) {
          paramamya.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_exciting_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_file_exciting", paramamya.a);
        localEditor.apply();
        QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "save download config [" + paramamya.a + "]");
        localObject = (aows)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aows)localObject).a(paramamya);
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
 * Qualified Name:     amyb
 * JD-Core Version:    0.7.0.1
 */