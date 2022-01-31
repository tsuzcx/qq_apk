import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.io.File;

public class amem
  extends alzl<bhny>
{
  public int a()
  {
    return 309;
  }
  
  @NonNull
  public bhny a(int paramInt)
  {
    return new bhny();
  }
  
  @Nullable
  public bhny a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length == 0)) {
      return null;
    }
    paramArrayOfalzs = paramArrayOfalzs[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onParsed, content:" + paramArrayOfalzs);
    }
    return new bhnv().a(paramArrayOfalzs, DynamicTextConfigManager.a.getAbsolutePath(), "temp_dynamic_text_zip", new amen(this));
  }
  
  public Class<bhny> a()
  {
    return bhny.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onReqFailed");
    }
  }
  
  public void a(bhny parambhny)
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
    return baig.a(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!DynamicTextConfigManager.b())
    {
      QLog.i("QIMDynamicTextConfigProcessor", 1, "config file not exist");
      alzw.a().a(309, 0);
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
 * Qualified Name:     amem
 * JD-Core Version:    0.7.0.1
 */