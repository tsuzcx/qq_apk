import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aolo
  extends aofy<aolp>
{
  public int a()
  {
    return 568;
  }
  
  @NonNull
  public aolp a(int paramInt)
  {
    return new aolp();
  }
  
  @Nullable
  public aolp a(aogf[] paramArrayOfaogf)
  {
    aolp localaolp = new aolp();
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfaogf.length);
    }
    if (paramArrayOfaogf.length > 0)
    {
      paramArrayOfaogf = paramArrayOfaogf[0];
      localaolp.jdField_a_of_type_Int = paramArrayOfaogf.jdField_a_of_type_Int;
      localaolp.jdField_a_of_type_JavaLangString = paramArrayOfaogf.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed taskId = " + localaolp.jdField_a_of_type_Int + " | content = " + localaolp.jdField_a_of_type_JavaLangString);
    }
    return localaolp;
  }
  
  public Class<aolp> a()
  {
    return aolp.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public void a(aolp paramaolp)
  {
    if ((paramaolp != null) && (paramaolp.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramaolp.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("QAssistantConfigProcessor", 2, "onUpdate content = " + paramaolp.jdField_a_of_type_JavaLangString);
        }
        awux.a(localQQAppInterface, str);
        paramaolp = (awuz)localQQAppInterface.getManager(352);
        if (paramaolp != null) {
          paramaolp.a();
        }
        return;
      }
      catch (Exception paramaolp)
      {
        paramaolp.printStackTrace();
        QLog.e("QAssistantConfigProcessor", 2, "onUpdate has exception", paramaolp);
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
 * Qualified Name:     aolo
 * JD-Core Version:    0.7.0.1
 */