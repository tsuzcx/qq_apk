import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.io.File;

public class amus
  extends ampb<bjiq>
{
  public int a()
  {
    return 309;
  }
  
  @NonNull
  public bjiq a(int paramInt)
  {
    return new bjiq();
  }
  
  @Nullable
  public bjiq a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length == 0)) {
      return null;
    }
    paramArrayOfampi = paramArrayOfampi[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onParsed, content:" + paramArrayOfampi);
    }
    return new bjin().a(paramArrayOfampi, DynamicTextConfigManager.a.getAbsolutePath(), "temp_dynamic_text_zip", new amut(this));
  }
  
  public Class<bjiq> a()
  {
    return bjiq.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onReqFailed");
    }
  }
  
  public void a(bjiq parambjiq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!DynamicTextConfigManager.b()) {
      return 0;
    }
    return bbjn.a(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!DynamicTextConfigManager.b())
    {
      QLog.i("QIMDynamicTextConfigProcessor", 1, "config file not exist");
      ampm.a().a(309, 0);
      return 0;
    }
    return super.b(paramInt);
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
 * Qualified Name:     amus
 * JD-Core Version:    0.7.0.1
 */