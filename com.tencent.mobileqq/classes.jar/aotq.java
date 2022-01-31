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

public class aotq
  extends aokh<aotp>
{
  public int a()
  {
    return 557;
  }
  
  @NonNull
  public aotp a(int paramInt)
  {
    return new aotp();
  }
  
  @Nullable
  public aotp a(aoko[] paramArrayOfaoko)
  {
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaoko != null) {
      try
      {
        if (paramArrayOfaoko.length > 0)
        {
          paramArrayOfaoko = (aotp)aolc.a(paramArrayOfaoko[0].a, aotp.class);
          return paramArrayOfaoko;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaoko)
      {
        QLog.e("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaoko.getMessage());
      }
    }
    return null;
  }
  
  public Class<aotp> a()
  {
    return aotp.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aotp paramaotp)
  {
    if (paramaotp != null)
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
        if (TextUtils.isEmpty(paramaotp.a)) {
          paramaotp.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("c2cfile_excitingupload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_c2cfile_excitingupload", paramaotp.a);
        localEditor.apply();
        QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramaotp.a + "]");
        localObject = (aqud)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aqud)localObject).a(paramaotp);
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
 * Qualified Name:     aotq
 * JD-Core Version:    0.7.0.1
 */