import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class argy
  extends arac<argz>
{
  @NonNull
  public argz a(int paramInt)
  {
    return new argz();
  }
  
  @Nullable
  public argz a(araj[] paramArrayOfaraj)
  {
    argz localargz = new argz();
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfaraj.length);
    }
    if (paramArrayOfaraj.length > 0)
    {
      paramArrayOfaraj = paramArrayOfaraj[0];
      localargz.jdField_a_of_type_Int = paramArrayOfaraj.jdField_a_of_type_Int;
      localargz.jdField_a_of_type_JavaLangString = paramArrayOfaraj.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed taskId = " + localargz.jdField_a_of_type_Int + " | content = " + localargz.jdField_a_of_type_JavaLangString);
    }
    return localargz;
  }
  
  public void a(argz paramargz)
  {
    if ((paramargz != null) && (paramargz.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramargz.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("QAssistantConfigProcessor", 2, "onUpdate content = " + paramargz.jdField_a_of_type_JavaLangString);
        }
        banl.a(localQQAppInterface, str);
        paramargz = (bann)localQQAppInterface.getManager(352);
        if (paramargz != null) {
          paramargz.a();
        }
        return;
      }
      catch (Exception paramargz)
      {
        paramargz.printStackTrace();
        QLog.e("QAssistantConfigProcessor", 2, "onUpdate has exception", paramargz);
        return;
      }
    }
    QLog.e("QAssistantConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
  }
  
  public Class<argz> clazz()
  {
    return argz.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public int type()
  {
    return 568;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argy
 * JD-Core Version:    0.7.0.1
 */