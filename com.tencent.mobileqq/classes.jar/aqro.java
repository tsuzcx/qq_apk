import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqro
  extends aqkz<aqrp>
{
  @NonNull
  public aqrp a(int paramInt)
  {
    return new aqrp();
  }
  
  @Nullable
  public aqrp a(aqlg[] paramArrayOfaqlg)
  {
    aqrp localaqrp = new aqrp();
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfaqlg.length);
    }
    if (paramArrayOfaqlg.length > 0)
    {
      paramArrayOfaqlg = paramArrayOfaqlg[0];
      localaqrp.jdField_a_of_type_Int = paramArrayOfaqlg.jdField_a_of_type_Int;
      localaqrp.jdField_a_of_type_JavaLangString = paramArrayOfaqlg.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed taskId = " + localaqrp.jdField_a_of_type_Int + " | content = " + localaqrp.jdField_a_of_type_JavaLangString);
    }
    return localaqrp;
  }
  
  public void a(aqrp paramaqrp)
  {
    if ((paramaqrp != null) && (paramaqrp.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramaqrp.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("QAssistantConfigProcessor", 2, "onUpdate content = " + paramaqrp.jdField_a_of_type_JavaLangString);
        }
        azuv.a(localQQAppInterface, str);
        paramaqrp = (azux)localQQAppInterface.getManager(352);
        if (paramaqrp != null) {
          paramaqrp.a();
        }
        return;
      }
      catch (Exception paramaqrp)
      {
        paramaqrp.printStackTrace();
        QLog.e("QAssistantConfigProcessor", 2, "onUpdate has exception", paramaqrp);
        return;
      }
    }
    QLog.e("QAssistantConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
  }
  
  public Class<aqrp> clazz()
  {
    return aqrp.class;
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
 * Qualified Name:     aqro
 * JD-Core Version:    0.7.0.1
 */