import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aopx
  extends aokh<aopy>
{
  public int a()
  {
    return 568;
  }
  
  @NonNull
  public aopy a(int paramInt)
  {
    return new aopy();
  }
  
  @Nullable
  public aopy a(aoko[] paramArrayOfaoko)
  {
    aopy localaopy = new aopy();
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfaoko.length);
    }
    if (paramArrayOfaoko.length > 0)
    {
      paramArrayOfaoko = paramArrayOfaoko[0];
      localaopy.jdField_a_of_type_Int = paramArrayOfaoko.jdField_a_of_type_Int;
      localaopy.jdField_a_of_type_JavaLangString = paramArrayOfaoko.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed taskId = " + localaopy.jdField_a_of_type_Int + " | content = " + localaopy.jdField_a_of_type_JavaLangString);
    }
    return localaopy;
  }
  
  public Class<aopy> a()
  {
    return aopy.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public void a(aopy paramaopy)
  {
    if ((paramaopy != null) && (paramaopy.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramaopy.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("QAssistantConfigProcessor", 2, "onUpdate content = " + paramaopy.jdField_a_of_type_JavaLangString);
        }
        awzg.a(localQQAppInterface, str);
        paramaopy = (awzi)localQQAppInterface.getManager(352);
        if (paramaopy != null) {
          paramaopy.a();
        }
        return;
      }
      catch (Exception paramaopy)
      {
        paramaopy.printStackTrace();
        QLog.e("QAssistantConfigProcessor", 2, "onUpdate has exception", paramaopy);
        return;
      }
    }
    QLog.e("QAssistantConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "migrateOldVersion");
    }
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
 * Qualified Name:     aopx
 * JD-Core Version:    0.7.0.1
 */