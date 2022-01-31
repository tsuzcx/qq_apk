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

@Deprecated
public class aots
  extends aokh<aotr>
{
  public int a()
  {
    return 533;
  }
  
  @NonNull
  public aotr a(int paramInt)
  {
    return new aotr();
  }
  
  @Nullable
  public aotr a(aoko[] paramArrayOfaoko)
  {
    QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "onParsed");
    if (paramArrayOfaoko != null) {
      try
      {
        if (paramArrayOfaoko.length > 0)
        {
          paramArrayOfaoko = (aotr)aolc.a(paramArrayOfaoko[0].a, aotr.class);
          return paramArrayOfaoko;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaoko)
      {
        QLog.e("QFileExcitingConfigProcessor<FileAssistant>", 1, "onParsed : error " + paramArrayOfaoko.getMessage());
      }
    }
    return null;
  }
  
  public Class<aotr> a()
  {
    return aotr.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aotr paramaotr)
  {
    if (paramaotr != null)
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
        if (TextUtils.isEmpty(paramaotr.a)) {
          paramaotr.a = "{}";
        }
        SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_exciting_" + ((QQAppInterface)localObject).c(), 0).edit();
        localEditor.putString("qfile_file_exciting", paramaotr.a);
        localEditor.apply();
        QLog.i("QFileExcitingConfigProcessor<FileAssistant>", 1, "save download config [" + paramaotr.a + "]");
        localObject = (aqud)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aqud)localObject).a(paramaotr);
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
 * Qualified Name:     aots
 * JD-Core Version:    0.7.0.1
 */