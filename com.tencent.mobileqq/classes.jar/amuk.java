import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class amuk
  extends ampa<amul>
{
  public int a()
  {
    return 568;
  }
  
  @NonNull
  public amul a(int paramInt)
  {
    return new amul();
  }
  
  @Nullable
  public amul a(amph[] paramArrayOfamph)
  {
    amul localamul = new amul();
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfamph.length);
    }
    if (paramArrayOfamph.length > 0)
    {
      paramArrayOfamph = paramArrayOfamph[0];
      localamul.jdField_a_of_type_Int = paramArrayOfamph.jdField_a_of_type_Int;
      localamul.jdField_a_of_type_JavaLangString = paramArrayOfamph.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed taskId = " + localamul.jdField_a_of_type_Int + " | content = " + localamul.jdField_a_of_type_JavaLangString);
    }
    return localamul;
  }
  
  public Class<amul> a()
  {
    return amul.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public void a(amul paramamul)
  {
    if ((paramamul != null) && (paramamul.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramamul.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("QAssistantConfigProcessor", 2, "onUpdate content = " + paramamul.jdField_a_of_type_JavaLangString);
        }
        avdk.a(localQQAppInterface, str);
        paramamul = (avdm)localQQAppInterface.getManager(352);
        if (paramamul != null) {
          paramamul.a();
        }
        return;
      }
      catch (Exception paramamul)
      {
        paramamul.printStackTrace();
        QLog.e("QAssistantConfigProcessor", 2, "onUpdate has exception", paramamul);
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
 * Qualified Name:     amuk
 * JD-Core Version:    0.7.0.1
 */