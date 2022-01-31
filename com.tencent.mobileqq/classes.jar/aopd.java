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

public class aopd
  extends aofy<aopb>
{
  public int a()
  {
    return 85;
  }
  
  @NonNull
  public aopb a(int paramInt)
  {
    return new aopb();
  }
  
  @Nullable
  public aopb a(aogf[] paramArrayOfaogf)
  {
    QLog.i("QFileDownloadConfigProcessor", 1, "onParsed");
    if (paramArrayOfaogf != null) {
      try
      {
        if (paramArrayOfaogf.length > 0)
        {
          paramArrayOfaogf = (aopb)aogt.a(paramArrayOfaogf[0].jdField_a_of_type_JavaLangString, aopb.class);
          return paramArrayOfaogf;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaogf)
      {
        QLog.e("QFileDownloadConfigProcessor", 1, "onParsed : error " + paramArrayOfaogf.getMessage());
      }
    }
    return null;
  }
  
  public Class<aopb> a()
  {
    return aopb.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileDownloadConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aopb paramaopb)
  {
    if ((paramaopb != null) && (paramaopb.jdField_a_of_type_JavaUtilHashMap != null))
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
        if (!TextUtils.isEmpty(paramaopb.jdField_a_of_type_JavaLangString))
        {
          SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).c(), 0).edit();
          localEditor.putString("qfile_file_auto_download", paramaopb.jdField_a_of_type_JavaLangString);
          localEditor.apply();
          QLog.i("QFileDownloadConfigProcessor", 1, "save download config [" + paramaopb.jdField_a_of_type_JavaLangString + "]");
        }
        localObject = (aqpu)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aqpu)localObject).a(paramaopb.jdField_a_of_type_JavaUtilHashMap);
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
 * Qualified Name:     aopd
 * JD-Core Version:    0.7.0.1
 */