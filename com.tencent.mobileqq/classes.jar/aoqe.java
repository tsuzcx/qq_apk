import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.io.File;

public class aoqe
  extends aokh<blze>
{
  public int a()
  {
    return 309;
  }
  
  @NonNull
  public blze a(int paramInt)
  {
    return new blze();
  }
  
  @Nullable
  public blze a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length == 0)) {
      return null;
    }
    paramArrayOfaoko = paramArrayOfaoko[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onParsed, content:" + paramArrayOfaoko);
    }
    return new blzb().a(paramArrayOfaoko, DynamicTextConfigManager.a.getAbsolutePath(), "temp_dynamic_text_zip", new aoqf(this));
  }
  
  public Class<blze> a()
  {
    return blze.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onReqFailed");
    }
  }
  
  public void a(blze paramblze)
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
    return bdne.a(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!DynamicTextConfigManager.b())
    {
      QLog.i("QIMDynamicTextConfigProcessor", 1, "config file not exist");
      aoks.a().a(309, 0);
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
 * Qualified Name:     aoqe
 * JD-Core Version:    0.7.0.1
 */