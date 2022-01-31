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

public class aoto
  extends aokh<aotn>
{
  public int a()
  {
    return 556;
  }
  
  @NonNull
  public aotn a(int paramInt)
  {
    return new aotn();
  }
  
  @Nullable
  public aotn a(aoko[] paramArrayOfaoko)
  {
    QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaoko != null) {
      try
      {
        if (paramArrayOfaoko.length > 0)
        {
          paramArrayOfaoko = (aotn)aolc.a(paramArrayOfaoko[0].a, aotn.class);
          return paramArrayOfaoko;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaoko)
      {
        QLog.e("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaoko.getMessage());
      }
    }
    return null;
  }
  
  public Class<aotn> a()
  {
    return aotn.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aotn paramaotn)
  {
    if (paramaotn != null)
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
        if (TextUtils.isEmpty(paramaotn.a)) {
          paramaotn.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("c2cfile_excitingdownload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_c2cfile_excitingdownload", paramaotn.a);
        localEditor.apply();
        QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-C2C-Download config [" + paramaotn.a + "]");
        localObject = (aqud)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aqud)localObject).a(paramaotn);
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
 * Qualified Name:     aoto
 * JD-Core Version:    0.7.0.1
 */