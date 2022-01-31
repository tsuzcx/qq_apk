import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.io.File;

public class amur
  extends ampa<bjjh>
{
  public int a()
  {
    return 309;
  }
  
  @NonNull
  public bjjh a(int paramInt)
  {
    return new bjjh();
  }
  
  @Nullable
  public bjjh a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length == 0)) {
      return null;
    }
    paramArrayOfamph = paramArrayOfamph[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onParsed, content:" + paramArrayOfamph);
    }
    return new bjje().a(paramArrayOfamph, DynamicTextConfigManager.a.getAbsolutePath(), "temp_dynamic_text_zip", new amus(this));
  }
  
  public Class<bjjh> a()
  {
    return bjjh.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onReqFailed");
    }
  }
  
  public void a(bjjh parambjjh)
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
    return bbkb.a(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!DynamicTextConfigManager.b())
    {
      QLog.i("QIMDynamicTextConfigProcessor", 1, "config file not exist");
      ampl.a().a(309, 0);
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
 * Qualified Name:     amur
 * JD-Core Version:    0.7.0.1
 */