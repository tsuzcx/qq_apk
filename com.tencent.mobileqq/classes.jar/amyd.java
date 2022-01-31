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

public class amyd
  extends ampb<amyc>
{
  public int a()
  {
    return 555;
  }
  
  @NonNull
  public amyc a(int paramInt)
  {
    return new amyc();
  }
  
  @Nullable
  public amyc a(ampi[] paramArrayOfampi)
  {
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfampi != null) {
      try
      {
        if (paramArrayOfampi.length > 0)
        {
          paramArrayOfampi = (amyc)ampw.a(paramArrayOfampi[0].a, amyc.class);
          return paramArrayOfampi;
        }
      }
      catch (QStorageInstantiateException paramArrayOfampi)
      {
        QLog.e("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfampi.getMessage());
      }
    }
    return null;
  }
  
  public Class<amyc> a()
  {
    return amyc.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amyc paramamyc)
  {
    if (paramamyc != null)
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
        if (TextUtils.isEmpty(paramamyc.a)) {
          paramamyc.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("groupfile_excitingdownload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_groupfile_excitingdownload", paramamyc.a);
        localEditor.apply();
        QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Download config [" + paramamyc.a + "]");
        localObject = (aows)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aows)localObject).a(paramamyc);
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
 * Qualified Name:     amyd
 * JD-Core Version:    0.7.0.1
 */