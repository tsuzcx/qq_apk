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

public class amya
  extends ampa<amxz>
{
  public int a()
  {
    return 557;
  }
  
  @NonNull
  public amxz a(int paramInt)
  {
    return new amxz();
  }
  
  @Nullable
  public amxz a(amph[] paramArrayOfamph)
  {
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfamph != null) {
      try
      {
        if (paramArrayOfamph.length > 0)
        {
          paramArrayOfamph = (amxz)ampv.a(paramArrayOfamph[0].a, amxz.class);
          return paramArrayOfamph;
        }
      }
      catch (QStorageInstantiateException paramArrayOfamph)
      {
        QLog.e("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfamph.getMessage());
      }
    }
    return null;
  }
  
  public Class<amxz> a()
  {
    return amxz.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amxz paramamxz)
  {
    if (paramamxz != null)
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
        if (TextUtils.isEmpty(paramamxz.a)) {
          paramamxz.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("c2cfile_excitingupload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_c2cfile_excitingupload", paramamxz.a);
        localEditor.apply();
        QLog.i("QFileExcitingC2CUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramamxz.a + "]");
        localObject = (aoww)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aoww)localObject).a(paramamxz);
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
 * Qualified Name:     amya
 * JD-Core Version:    0.7.0.1
 */