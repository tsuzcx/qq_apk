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

public class aotw
  extends aokh<aotv>
{
  public int a()
  {
    return 554;
  }
  
  @NonNull
  public aotv a(int paramInt)
  {
    return new aotv();
  }
  
  @Nullable
  public aotv a(aoko[] paramArrayOfaoko)
  {
    QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaoko != null) {
      try
      {
        if (paramArrayOfaoko.length > 0)
        {
          paramArrayOfaoko = (aotv)aolc.a(paramArrayOfaoko[0].a, aotv.class);
          return paramArrayOfaoko;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaoko)
      {
        QLog.e("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaoko.getMessage());
      }
    }
    return null;
  }
  
  public Class<aotv> a()
  {
    return aotv.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aotv paramaotv)
  {
    if (paramaotv != null)
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
        if (TextUtils.isEmpty(paramaotv.a)) {
          paramaotv.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("groupfile_excitingupload_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_groupfile_excitingupload", paramaotv.a);
        localEditor.apply();
        QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramaotv.a + "]");
        localObject = (aqud)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aqud)localObject).a(paramaotv);
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
 * Qualified Name:     aotw
 * JD-Core Version:    0.7.0.1
 */