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

public class aqfr
  extends aptq<aqfq>
{
  @NonNull
  public aqfq a(int paramInt)
  {
    return new aqfq();
  }
  
  @Nullable
  public aqfq a(aptx[] paramArrayOfaptx)
  {
    QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaptx != null) {
      try
      {
        if (paramArrayOfaptx.length > 0)
        {
          paramArrayOfaptx = (aqfq)apul.a(paramArrayOfaptx[0].a, aqfq.class);
          return paramArrayOfaptx;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaptx)
      {
        QLog.e("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaptx.getMessage());
      }
    }
    return null;
  }
  
  public void a(aqfq paramaqfq)
  {
    if (paramaqfq != null)
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
        if (TextUtils.isEmpty(paramaqfq.a)) {
          paramaqfq.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("groupfile_excitingupload_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
        localEditor.putString("qfile_groupfile_excitingupload", paramaqfq.a);
        localEditor.apply();
        QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "save Exciting-Group-Upload config [" + paramaqfq.a + "]");
        localObject = (aser)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aser)localObject).a(paramaqfq);
        }
      }
      return;
    }
  }
  
  public Class<aqfq> clazz()
  {
    return aqfq.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.i("QFileExcitingGroupUploadConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 554;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqfr
 * JD-Core Version:    0.7.0.1
 */