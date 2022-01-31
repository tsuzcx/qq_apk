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

public class aopf
  extends aofy<aope>
{
  public int a()
  {
    return 556;
  }
  
  @NonNull
  public aope a(int paramInt)
  {
    return new aope();
  }
  
  @Nullable
  public aope a(aogf[] paramArrayOfaogf)
  {
    QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaogf != null) {
      try
      {
        if (paramArrayOfaogf.length > 0)
        {
          paramArrayOfaogf = (aope)aogt.a(paramArrayOfaogf[0].a, aope.class);
          return paramArrayOfaogf;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaogf)
      {
        QLog.e("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaogf.getMessage());
      }
    }
    return null;
  }
  
  public Class<aope> a()
  {
    return aope.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aope paramaope)
  {
    if (paramaope != null)
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
        if (TextUtils.isEmpty(paramaope.a)) {
          paramaope.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("c2cfile_excitingdownload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_c2cfile_excitingdownload", paramaope.a);
        localEditor.apply();
        QLog.i("QFileExcitingC2CDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-C2C-Download config [" + paramaope.a + "]");
        localObject = (aqpu)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aqpu)localObject).a(paramaope);
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
 * Qualified Name:     aopf
 * JD-Core Version:    0.7.0.1
 */