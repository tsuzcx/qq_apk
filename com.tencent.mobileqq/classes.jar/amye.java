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

public class amye
  extends ampa<amyd>
{
  public int a()
  {
    return 555;
  }
  
  @NonNull
  public amyd a(int paramInt)
  {
    return new amyd();
  }
  
  @Nullable
  public amyd a(amph[] paramArrayOfamph)
  {
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfamph != null) {
      try
      {
        if (paramArrayOfamph.length > 0)
        {
          paramArrayOfamph = (amyd)ampv.a(paramArrayOfamph[0].a, amyd.class);
          return paramArrayOfamph;
        }
      }
      catch (QStorageInstantiateException paramArrayOfamph)
      {
        QLog.e("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfamph.getMessage());
      }
    }
    return null;
  }
  
  public Class<amyd> a()
  {
    return amyd.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amyd paramamyd)
  {
    if (paramamyd != null)
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
        if (TextUtils.isEmpty(paramamyd.a)) {
          paramamyd.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("groupfile_excitingdownload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_groupfile_excitingdownload", paramamyd.a);
        localEditor.apply();
        QLog.i("QFileExcitingGroupDownloadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Download config [" + paramamyd.a + "]");
        localObject = (aoww)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aoww)localObject).a(paramamyd);
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
 * Qualified Name:     amye
 * JD-Core Version:    0.7.0.1
 */