import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqtm
  extends aqkz<aqtn>
{
  @NonNull
  public aqtn a(int paramInt)
  {
    return new aqtn();
  }
  
  @Nullable
  public aqtn a(aqlg[] paramArrayOfaqlg)
  {
    aqtn localaqtn = new aqtn();
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onParsed confFiles.length = " + paramArrayOfaqlg.length);
    }
    if (paramArrayOfaqlg.length > 0)
    {
      paramArrayOfaqlg = paramArrayOfaqlg[0];
      localaqtn.jdField_a_of_type_Int = paramArrayOfaqlg.jdField_a_of_type_Int;
      localaqtn.jdField_a_of_type_JavaLangString = paramArrayOfaqlg.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScencesEmotionConfigProcessor", 2, "onParsed taskId = " + localaqtn.jdField_a_of_type_Int + " | content = " + localaqtn.jdField_a_of_type_JavaLangString);
    }
    return localaqtn;
  }
  
  public void a(aqtn paramaqtn)
  {
    if ((paramaqtn != null) && (paramaqtn.jdField_a_of_type_JavaLangString != null)) {
      try
      {
        String str = paramaqtn.jdField_a_of_type_JavaLangString;
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (QLog.isColorLevel()) {
          QLog.d("ScencesEmotionConfigProcessor", 2, "onUpdate content = " + paramaqtn.jdField_a_of_type_JavaLangString);
        }
        aikl.a(localQQAppInterface, str);
        ScenesRecommendManager.a(localQQAppInterface).a();
        return;
      }
      catch (Exception paramaqtn)
      {
        paramaqtn.printStackTrace();
        QLog.e("ScencesEmotionConfigProcessor", 2, "onUpdate has exception", paramaqtn);
        return;
      }
    }
    QLog.e("ScencesEmotionConfigProcessor", 2, "onUpdate has empty content newConf is null = " + null);
  }
  
  public Class<aqtn> clazz()
  {
    return aqtn.class;
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
 * Qualified Name:     aqtm
 * JD-Core Version:    0.7.0.1
 */