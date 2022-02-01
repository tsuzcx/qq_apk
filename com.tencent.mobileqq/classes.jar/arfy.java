import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arfy
  extends aqwt<arfz>
{
  @NonNull
  public arfz a(int paramInt)
  {
    return new arfz();
  }
  
  @Nullable
  public arfz a(aqxa[] paramArrayOfaqxa)
  {
    arfz localarfz = new arfz();
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfaqxa.length);
    }
    if (paramArrayOfaqxa.length > 0)
    {
      paramArrayOfaqxa = paramArrayOfaqxa[0];
      localarfz.jdField_a_of_type_Int = paramArrayOfaqxa.jdField_a_of_type_Int;
      localarfz.jdField_a_of_type_JavaLangString = paramArrayOfaqxa.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onParsed taskId = " + localarfz.jdField_a_of_type_Int + " | content = " + localarfz.jdField_a_of_type_JavaLangString);
    }
    return localarfz;
  }
  
  public void a(arfz paramarfz)
  {
    if ((paramarfz != null) && (paramarfz.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramarfz.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("ScencesEmotionConfigProcessor", 2, "onUpdate content = " + paramarfz.jdField_a_of_type_JavaLangString);
        }
        aijk.a(localQQAppInterface, str);
        ScenesRecommendManager.a(localQQAppInterface).a();
        return;
      }
      catch (Exception paramarfz)
      {
        paramarfz.printStackTrace();
        QLog.e("ScencesEmotionConfigProcessor", 2, "onUpdate has exception", paramarfz);
        return;
      }
    }
    QLog.e("ScencesEmotionConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
  }
  
  public Class<arfz> clazz()
  {
    return arfz.class;
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
 * Qualified Name:     arfy
 * JD-Core Version:    0.7.0.1
 */