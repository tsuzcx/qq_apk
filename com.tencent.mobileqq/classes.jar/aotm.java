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

public class aotm
  extends aokh<aotk>
{
  public int a()
  {
    return 85;
  }
  
  @NonNull
  public aotk a(int paramInt)
  {
    return new aotk();
  }
  
  @Nullable
  public aotk a(aoko[] paramArrayOfaoko)
  {
    QLog.i("QFileDownloadConfigProcessor", 1, "onParsed");
    if (paramArrayOfaoko != null) {
      try
      {
        if (paramArrayOfaoko.length > 0)
        {
          paramArrayOfaoko = (aotk)aolc.a(paramArrayOfaoko[0].jdField_a_of_type_JavaLangString, aotk.class);
          return paramArrayOfaoko;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaoko)
      {
        QLog.e("QFileDownloadConfigProcessor", 1, "onParsed : error " + paramArrayOfaoko.getMessage());
      }
    }
    return null;
  }
  
  public Class<aotk> a()
  {
    return aotk.class;
  }
  
  public void a(int paramInt)
  {
    QLog.i("QFileDownloadConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public void a(aotk paramaotk)
  {
    if ((paramaotk != null) && (paramaotk.jdField_a_of_type_JavaUtilHashMap != null))
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
        if (!TextUtils.isEmpty(paramaotk.jdField_a_of_type_JavaLangString))
        {
          SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).c(), 0).edit();
          localEditor.putString("qfile_file_auto_download", paramaotk.jdField_a_of_type_JavaLangString);
          localEditor.apply();
          QLog.i("QFileDownloadConfigProcessor", 1, "save download config [" + paramaotk.jdField_a_of_type_JavaLangString + "]");
        }
        localObject = (aqud)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((aqud)localObject).a(paramaotk.jdField_a_of_type_JavaUtilHashMap);
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
 * Qualified Name:     aotm
 * JD-Core Version:    0.7.0.1
 */