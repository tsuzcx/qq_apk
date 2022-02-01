import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.io.File;

public class ardy
  extends aqwt<bonb>
{
  @NonNull
  public bonb a(int paramInt)
  {
    return new bonb();
  }
  
  @Nullable
  public bonb a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length == 0)) {
      return null;
    }
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onParsed, content:" + paramArrayOfaqxa);
    }
    return new bomy().a(paramArrayOfaqxa, DynamicTextConfigManager.a.getAbsolutePath(), "temp_dynamic_text_zip", new ardz(this));
  }
  
  public void a(bonb parambonb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onUpdate");
    }
  }
  
  public Class<bonb> clazz()
  {
    return bonb.class;
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
    if (!DynamicTextConfigManager.b()) {
      return 0;
    }
    return bhhr.a(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!DynamicTextConfigManager.b())
    {
      QLog.i("QIMDynamicTextConfigProcessor", 1, "config file not exist");
      aqxe.a().a(309, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 309;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardy
 * JD-Core Version:    0.7.0.1
 */