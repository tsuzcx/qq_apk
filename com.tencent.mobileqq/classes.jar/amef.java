import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amef
  extends alzl<ameg>
{
  public int a()
  {
    return 568;
  }
  
  @NonNull
  public ameg a(int paramInt)
  {
    return new ameg();
  }
  
  @Nullable
  public ameg a(alzs[] paramArrayOfalzs)
  {
    ameg localameg = new ameg();
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfalzs.length);
    }
    if (paramArrayOfalzs.length > 0)
    {
      paramArrayOfalzs = paramArrayOfalzs[0];
      localameg.jdField_a_of_type_Int = paramArrayOfalzs.jdField_a_of_type_Int;
      localameg.jdField_a_of_type_JavaLangString = paramArrayOfalzs.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed taskId = " + localameg.jdField_a_of_type_Int + " | content = " + localameg.jdField_a_of_type_JavaLangString);
    }
    return localameg;
  }
  
  public Class<ameg> a()
  {
    return ameg.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public void a(ameg paramameg)
  {
    if ((paramameg != null) && (paramameg.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramameg.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("QAssistantConfigProcessor", 2, "onUpdate content = " + paramameg.jdField_a_of_type_JavaLangString);
        }
        auec.a(localQQAppInterface, str);
        paramameg = (auee)localQQAppInterface.getManager(352);
        if (paramameg != null) {
          paramameg.a();
        }
        return;
      }
      catch (Exception paramameg)
      {
        paramameg.printStackTrace();
        QLog.e("QAssistantConfigProcessor", 2, "onUpdate has exception", paramameg);
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
 * Qualified Name:     amef
 * JD-Core Version:    0.7.0.1
 */