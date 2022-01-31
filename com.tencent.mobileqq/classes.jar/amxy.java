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

public class amxy
  extends ampa<amxx>
{
  public int a()
  {
    return 556;
  }
  
  @NonNull
  public amxx a(int paramInt)
  {
    return new amxx();
  }
  
  @Nullable
  public amxx a(amph[] paramArrayOfamph)
  {
    QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfamph != null) {
      try
      {
        if (paramArrayOfamph.length > 0)
        {
          paramArrayOfamph = (amxx)ampv.a(paramArrayOfamph[0].a, amxx.class);
          return paramArrayOfamph;
        }
      }
      catch (QStorageInstantiateException paramArrayOfamph)
      {
        QLog.e("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfamph.getMessage());
      }
    }
    return null;
  }
  
  public Class<amxx> a()
  {
    return amxx.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amxx paramamxx)
  {
    if (paramamxx != null)
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
        if (TextUtils.isEmpty(paramamxx.a)) {
          paramamxx.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("c2cfile_excitingdownload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_c2cfile_excitingdownload", paramamxx.a);
        localEditor.apply();
        QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-C2C-Download config [" + paramamxx.a + "]");
        localObject = (aoww)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aoww)localObject).a(paramamxx);
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
 * Qualified Name:     amxy
 * JD-Core Version:    0.7.0.1
 */