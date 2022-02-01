import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqao
  extends aptq<aqap>
{
  @NonNull
  public aqap a(int paramInt)
  {
    return new aqap();
  }
  
  @Nullable
  public aqap a(aptx[] paramArrayOfaptx)
  {
    aqap localaqap = new aqap();
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfaptx.length);
    }
    if (paramArrayOfaptx.length > 0)
    {
      paramArrayOfaptx = paramArrayOfaptx[0];
      localaqap.jdField_a_of_type_Int = paramArrayOfaptx.jdField_a_of_type_Int;
      localaqap.jdField_a_of_type_JavaLangString = paramArrayOfaptx.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigProcessor", 2, "onParsed taskId = " + localaqap.jdField_a_of_type_Int + " | content = " + localaqap.jdField_a_of_type_JavaLangString);
    }
    return localaqap;
  }
  
  public void a(aqap paramaqap)
  {
    if ((paramaqap != null) && (paramaqap.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramaqap.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("QAssistantConfigProcessor", 2, "onUpdate content = " + paramaqap.jdField_a_of_type_JavaLangString);
        }
        azep.a(localQQAppInterface, str);
        paramaqap = (azer)localQQAppInterface.getManager(352);
        if (paramaqap != null) {
          paramaqap.a();
        }
        return;
      }
      catch (Exception paramaqap)
      {
        paramaqap.printStackTrace();
        QLog.e("QAssistantConfigProcessor", 2, "onUpdate has exception", paramaqap);
        return;
      }
    }
    QLog.e("QAssistantConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
  }
  
  public Class<aqap> clazz()
  {
    return aqap.class;
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
 * Qualified Name:     aqao
 * JD-Core Version:    0.7.0.1
 */