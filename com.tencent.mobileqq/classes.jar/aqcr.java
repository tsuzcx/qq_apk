import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqcr
  extends aptq<aqcs>
{
  @NonNull
  public aqcs a(int paramInt)
  {
    return new aqcs();
  }
  
  @Nullable
  public aqcs a(aptx[] paramArrayOfaptx)
  {
    aqcs localaqcs = new aqcs();
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfaptx.length);
    }
    if (paramArrayOfaptx.length > 0)
    {
      paramArrayOfaptx = paramArrayOfaptx[0];
      localaqcs.jdField_a_of_type_Int = paramArrayOfaptx.jdField_a_of_type_Int;
      localaqcs.jdField_a_of_type_JavaLangString = paramArrayOfaptx.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onParsed taskId = " + localaqcs.jdField_a_of_type_Int + " | content = " + localaqcs.jdField_a_of_type_JavaLangString);
    }
    return localaqcs;
  }
  
  public void a(aqcs paramaqcs)
  {
    if ((paramaqcs != null) && (paramaqcs.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramaqcs.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("ScencesEmotionConfigProcessor", 2, "onUpdate content = " + paramaqcs.jdField_a_of_type_JavaLangString);
        }
        ahop.a(localQQAppInterface, str);
        ScenesRecommendManager.a(localQQAppInterface).a();
        return;
      }
      catch (Exception paramaqcs)
      {
        paramaqcs.printStackTrace();
        QLog.e("ScencesEmotionConfigProcessor", 2, "onUpdate has exception", paramaqcs);
        return;
      }
    }
    QLog.e("ScencesEmotionConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
  }
  
  public Class<aqcs> clazz()
  {
    return aqcs.class;
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
 * Qualified Name:     aqcr
 * JD-Core Version:    0.7.0.1
 */