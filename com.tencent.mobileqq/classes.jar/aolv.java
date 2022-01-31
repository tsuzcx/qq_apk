import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.io.File;

public class aolv
  extends aofy<blus>
{
  public int a()
  {
    return 309;
  }
  
  @NonNull
  public blus a(int paramInt)
  {
    return new blus();
  }
  
  @Nullable
  public blus a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length == 0)) {
      return null;
    }
    paramArrayOfaogf = paramArrayOfaogf[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onParsed, content:" + paramArrayOfaogf);
    }
    return new blup().a(paramArrayOfaogf, DynamicTextConfigManager.a.getAbsolutePath(), "temp_dynamic_text_zip", new aolw(this));
  }
  
  public Class<blus> a()
  {
    return blus.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onReqFailed");
    }
  }
  
  public void a(blus paramblus)
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
    return bdiv.a(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!DynamicTextConfigManager.b())
    {
      QLog.i("QIMDynamicTextConfigProcessor", 1, "config file not exist");
      aogj.a().a(309, 0);
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
 * Qualified Name:     aolv
 * JD-Core Version:    0.7.0.1
 */