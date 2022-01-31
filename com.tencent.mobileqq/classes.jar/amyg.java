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

public class amyg
  extends ampa<amyf>
{
  public int a()
  {
    return 554;
  }
  
  @NonNull
  public amyf a(int paramInt)
  {
    return new amyf();
  }
  
  @Nullable
  public amyf a(amph[] paramArrayOfamph)
  {
    QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfamph != null) {
      try
      {
        if (paramArrayOfamph.length > 0)
        {
          paramArrayOfamph = (amyf)ampv.a(paramArrayOfamph[0].a, amyf.class);
          return paramArrayOfamph;
        }
      }
      catch (QStorageInstantiateException paramArrayOfamph)
      {
        QLog.e("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfamph.getMessage());
      }
    }
    return null;
  }
  
  public Class<amyf> a()
  {
    return amyf.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amyf paramamyf)
  {
    if (paramamyf != null)
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
        if (TextUtils.isEmpty(paramamyf.a)) {
          paramamyf.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("groupfile_excitingupload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_groupfile_excitingupload", paramamyf.a);
        localEditor.apply();
        QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramamyf.a + "]");
        localObject = (aoww)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aoww)localObject).a(paramamyf);
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
 * Qualified Name:     amyg
 * JD-Core Version:    0.7.0.1
 */