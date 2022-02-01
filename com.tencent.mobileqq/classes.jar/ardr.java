import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class ardr
  extends aqwt<ards>
{
  @NonNull
  public ards a(int paramInt)
  {
    return new ards();
  }
  
  @Nullable
  public ards a(aqxa[] paramArrayOfaqxa)
  {
    ards localards = new ards();
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfaqxa.length);
    }
    if (paramArrayOfaqxa.length > 0)
    {
      paramArrayOfaqxa = paramArrayOfaqxa[0];
      localards.jdField_a_of_type_Int = paramArrayOfaqxa.jdField_a_of_type_Int;
      localards.jdField_a_of_type_JavaLangString = paramArrayOfaqxa.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed taskId = " + localards.jdField_a_of_type_Int + " | content = " + localards.jdField_a_of_type_JavaLangString);
    }
    return localards;
  }
  
  public void a(ards paramards)
  {
    if ((paramards != null) && (paramards.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramards.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("QAssistantConfigProcessor", 2, "onUpdate content = " + paramards.jdField_a_of_type_JavaLangString);
        }
        bakg.a(localQQAppInterface, str);
        paramards = (baki)localQQAppInterface.getManager(QQManagerFactory.QASSISTANT_MANAGER);
        if (paramards != null) {
          paramards.a();
        }
        return;
      }
      catch (Exception paramards)
      {
        paramards.printStackTrace();
        QLog.e("QAssistantConfigProcessor", 2, "onUpdate has exception", paramards);
        return;
      }
    }
    QLog.e("QAssistantConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
  }
  
  public Class<ards> clazz()
  {
    return ards.class;
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
 * Qualified Name:     ardr
 * JD-Core Version:    0.7.0.1
 */