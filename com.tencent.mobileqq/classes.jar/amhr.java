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

public class amhr
  extends alzl<amhp>
{
  public int a()
  {
    return 85;
  }
  
  @NonNull
  public amhp a(int paramInt)
  {
    return new amhp();
  }
  
  @Nullable
  public amhp a(alzs[] paramArrayOfalzs)
  {
    QLog.i("QFileDownloadConfigProcessor", 1, "onParsed");
    if (paramArrayOfalzs != null) {
      try
      {
        if (paramArrayOfalzs.length > 0)
        {
          paramArrayOfalzs = (amhp)amaf.a(paramArrayOfalzs[0].jdField_a_of_type_JavaLangString, amhp.class);
          return paramArrayOfalzs;
        }
      }
      catch (QStorageInstantiateException paramArrayOfalzs)
      {
        QLog.e("QFileDownloadConfigProcessor", 1, "onParsed : error " + paramArrayOfalzs.getMessage());
      }
    }
    return null;
  }
  
  public Class<amhp> a()
  {
    return amhp.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileDownloadConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(amhp paramamhp)
  {
    if ((paramamhp != null) && (paramamhp.jdField_a_of_type_JavaUtilHashMap != null))
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
        if (!TextUtils.isEmpty(paramamhp.jdField_a_of_type_JavaLangString))
        {
          SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).c(), 0).edit();
          localEditor.putString("qfile_file_auto_download", paramamhp.jdField_a_of_type_JavaLangString);
          localEditor.apply();
          QLog.i("QFileDownloadConfigProcessor", 1, "save download config [" + paramamhp.jdField_a_of_type_JavaLangString + "]");
        }
        localObject = (aofy)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aofy)localObject).a(paramamhp.jdField_a_of_type_JavaUtilHashMap);
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
 * Qualified Name:     amhr
 * JD-Core Version:    0.7.0.1
 */