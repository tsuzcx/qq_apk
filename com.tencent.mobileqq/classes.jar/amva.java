import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class amva
  extends ampb<bjiq>
{
  public int a()
  {
    return 307;
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
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onParsed, content:" + paramArrayOfampi);
    }
    return new bjin().a(paramArrayOfampi, bkyy.a.getAbsolutePath(), "temp_faceu_zip", new amvb(this));
  }
  
  public Class<bjiq> a()
  {
    return bjiq.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onReqFailed");
    }
  }
  
  public void a(bjiq parambjiq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!bkyy.a()) {
      return 0;
    }
    return bbjn.D(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!bkyy.a())
    {
      QLog.i("QIMTemplateConfigProcessor", 1, "config file not exist");
      ampm.a().a(307, 0);
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
 * Qualified Name:     amva
 * JD-Core Version:    0.7.0.1
 */