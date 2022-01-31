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

public class amxv
  extends ampb<amxt>
{
  public int a()
  {
    return 85;
  }
  
  @NonNull
  public amxt a(int paramInt)
  {
    return new amxt();
  }
  
  @Nullable
  public amxt a(ampi[] paramArrayOfampi)
  {
    QLog.i("QFileDownloadConfigProcessor", 1, "onParsed");
    if (paramArrayOfampi != null) {
      try
      {
        if (paramArrayOfampi.length > 0)
        {
          paramArrayOfampi = (amxt)ampw.a(paramArrayOfampi[0].jdField_a_of_type_JavaLangString, amxt.class);
          return paramArrayOfampi;
        }
      }
      catch (QStorageInstantiateException paramArrayOfampi)
      {
        QLog.e("QFileDownloadConfigProcessor", 1, "onParsed : error " + paramArrayOfampi.getMessage());
      }
    }
    return null;
  }
  
  public Class<amxt> a()
  {
    return amxt.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileDownloadConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amxt paramamxt)
  {
    if ((paramamxt != null) && (paramamxt.jdField_a_of_type_JavaUtilHashMap != null))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label156;
      }
    }
    label156:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(paramamxt.jdField_a_of_type_JavaLangString))
        {
          SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).c(), 0).edit();
          localEditor.putString("qfile_file_auto_download", paramamxt.jdField_a_of_type_JavaLangString);
          localEditor.apply();
          QLog.i("QFileDownloadConfigProcessor", 1, "save download config [" + paramamxt.jdField_a_of_type_JavaLangString + "]");
        }
        localObject = (aows)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aows)localObject).a(paramamxt.jdField_a_of_type_JavaUtilHashMap);
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amxv
 * JD-Core Version:    0.7.0.1
 */