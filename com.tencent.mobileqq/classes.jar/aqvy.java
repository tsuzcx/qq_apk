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

public class aqvy
  extends aqkz<aqvw>
{
  @NonNull
  public aqvw a(int paramInt)
  {
    return new aqvw();
  }
  
  @Nullable
  public aqvw a(aqlg[] paramArrayOfaqlg)
  {
    QLog.i("QFileDownloadConfigProcessor", 1, "onParsed");
    if (paramArrayOfaqlg != null) {
      try
      {
        if (paramArrayOfaqlg.length > 0)
        {
          paramArrayOfaqlg = (aqvw)aqlu.a(paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString, aqvw.class);
          return paramArrayOfaqlg;
        }
      }
      catch (QStorageInstantiateException paramArrayOfaqlg)
      {
        QLog.e("QFileDownloadConfigProcessor", 1, "onParsed : error " + paramArrayOfaqlg.getMessage());
      }
    }
    return null;
  }
  
  public void a(aqvw paramaqvw)
  {
    if ((paramaqvw != null) && (paramaqvw.jdField_a_of_type_JavaUtilHashMap != null))
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
        if (!TextUtils.isEmpty(paramaqvw.jdField_a_of_type_JavaLangString))
        {
          SharedPreferences.Editor localEditor = ((QQAppInterface)localObject).getApp().getSharedPreferences("file_config_" + ((QQAppInterface)localObject).c(), 0).edit();
          localEditor.putString("qfile_file_auto_download", paramaqvw.jdField_a_of_type_JavaLangString);
          localEditor.apply();
          QLog.i("QFileDownloadConfigProcessor", 1, "save download config [" + paramaqvw.jdField_a_of_type_JavaLangString + "]");
        }
        localObject = (atam)((QQAppInterface)localObject).getManager(317);
        if (localObject != null) {
          ((atam)localObject).a(paramaqvw.jdField_a_of_type_JavaUtilHashMap);
        }
      }
      return;
    }
  }
  
  public Class<aqvw> clazz()
  {
    return aqvw.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
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
    QLog.i("QFileDownloadConfigProcessor", 1, "onReqFailed: failCode[" + paramInt + "]");
  }
  
  public int type()
  {
    return 85;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqvy
 * JD-Core Version:    0.7.0.1
 */