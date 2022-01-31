import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class amuz
  extends ampa<bjjh>
{
  public int a()
  {
    return 307;
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
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onParsed, content:" + paramArrayOfamph);
    }
    return new bjje().a(paramArrayOfamph, bkzp.a.getAbsolutePath(), "temp_faceu_zip", new amva(this));
  }
  
  public Class<bjjh> a()
  {
    return bjjh.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onReqFailed");
    }
  }
  
  public void a(bjjh parambjjh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!bkzp.a()) {
      return 0;
    }
    return bbkb.D(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!bkzp.a())
    {
      QLog.i("QIMTemplateConfigProcessor", 1, "config file not exist");
      ampl.a().a(307, 0);
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
 * Qualified Name:     amuz
 * JD-Core Version:    0.7.0.1
 */