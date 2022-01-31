import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ameu
  extends alzl<bhny>
{
  public int a()
  {
    return 307;
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
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onParsed, content:" + paramArrayOfalzs);
    }
    return new bhnv().a(paramArrayOfalzs, bjin.a.getAbsolutePath(), "temp_faceu_zip", new amev(this));
  }
  
  public Class<bhny> a()
  {
    return bhny.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onReqFailed");
    }
  }
  
  public void a(bhny parambhny)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!bjin.a()) {
      return 0;
    }
    return baig.E(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!bjin.a())
    {
      QLog.i("QIMTemplateConfigProcessor", 1, "config file not exist");
      alzw.a().a(307, 0);
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
 * Qualified Name:     ameu
 * JD-Core Version:    0.7.0.1
 */