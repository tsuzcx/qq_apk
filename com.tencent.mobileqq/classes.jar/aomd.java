import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aomd
  extends aofy<blus>
{
  public int a()
  {
    return 307;
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
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onParsed, content:" + paramArrayOfaogf);
    }
    return new blup().a(paramArrayOfaogf, bnkz.a.getAbsolutePath(), "temp_faceu_zip", new aome(this));
  }
  
  public Class<blus> a()
  {
    return blus.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onReqFailed");
    }
  }
  
  public void a(blus paramblus)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!bnkz.a()) {
      return 0;
    }
    return bdiv.E(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!bnkz.a())
    {
      QLog.i("QIMTemplateConfigProcessor", 1, "config file not exist");
      aogj.a().a(307, 0);
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
 * Qualified Name:     aomd
 * JD-Core Version:    0.7.0.1
 */