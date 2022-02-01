import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ariy
  extends arac<ariz>
{
  @NonNull
  public ariz a(int paramInt)
  {
    return new ariz();
  }
  
  @Nullable
  public ariz a(araj[] paramArrayOfaraj)
  {
    ariz localariz = new ariz();
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfaraj.length);
    }
    if (paramArrayOfaraj.length > 0)
    {
      paramArrayOfaraj = paramArrayOfaraj[0];
      localariz.jdField_a_of_type_Int = paramArrayOfaraj.jdField_a_of_type_Int;
      localariz.jdField_a_of_type_JavaLangString = paramArrayOfaraj.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onParsed taskId = " + localariz.jdField_a_of_type_Int + " | content = " + localariz.jdField_a_of_type_JavaLangString);
    }
    return localariz;
  }
  
  public void a(ariz paramariz)
  {
    if ((paramariz != null) && (paramariz.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramariz.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("ScencesEmotionConfigProcessor", 2, "onUpdate content = " + paramariz.jdField_a_of_type_JavaLangString);
        }
        aiue.a(localQQAppInterface, str);
        ScenesRecommendManager.a(localQQAppInterface).a();
        return;
      }
      catch (Exception paramariz)
      {
        paramariz.printStackTrace();
        QLog.e("ScencesEmotionConfigProcessor", 2, "onUpdate has exception", paramariz);
        return;
      }
    }
    QLog.e("ScencesEmotionConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
  }
  
  public Class<ariz> clazz()
  {
    return ariz.class;
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
      QLog.d("ScencesEmotionConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onReqFailed, code = " + paramInt);
    }
  }
  
  public int type()
  {
    return 621;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ariy
 * JD-Core Version:    0.7.0.1
 */