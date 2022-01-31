import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amul
  extends ampb<amum>
{
  public int a()
  {
    return 568;
  }
  
  @NonNull
  public amum a(int paramInt)
  {
    return new amum();
  }
  
  @Nullable
  public amum a(ampi[] paramArrayOfampi)
  {
    amum localamum = new amum();
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfampi.length);
    }
    if (paramArrayOfampi.length > 0)
    {
      paramArrayOfampi = paramArrayOfampi[0];
      localamum.jdField_a_of_type_Int = paramArrayOfampi.jdField_a_of_type_Int;
      localamum.jdField_a_of_type_JavaLangString = paramArrayOfampi.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed taskId = " + localamum.jdField_a_of_type_Int + " | content = " + localamum.jdField_a_of_type_JavaLangString);
    }
    return localamum;
  }
  
  public Class<amum> a()
  {
    return amum.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public void a(amum paramamum)
  {
    if ((paramamum != null) && (paramamum.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramamum.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("QAssistantConfigProcessor", 2, "onUpdate content = " + paramamum.jdField_a_of_type_JavaLangString);
        }
        avdi.a(localQQAppInterface, str);
        paramamum = (avdk)localQQAppInterface.getManager(352);
        if (paramamum != null) {
          paramamum.a();
        }
        return;
      }
      catch (Exception paramamum)
      {
        paramamum.printStackTrace();
        QLog.e("QAssistantConfigProcessor", 2, "onUpdate has exception", paramamum);
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
 * Qualified Name:     amul
 * JD-Core Version:    0.7.0.1
 */