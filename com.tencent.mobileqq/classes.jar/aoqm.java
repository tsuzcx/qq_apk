import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aoqm
  extends aokh<blze>
{
  public int a()
  {
    return 307;
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
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onParsed, content:" + paramArrayOfaoko);
    }
    return new blzb().a(paramArrayOfaoko, bnpl.a.getAbsolutePath(), "temp_faceu_zip", new aoqn(this));
  }
  
  public Class<blze> a()
  {
    return blze.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onReqFailed");
    }
  }
  
  public void a(blze paramblze)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!bnpl.a()) {
      return 0;
    }
    return bdne.E(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!bnpl.a())
    {
      QLog.i("QIMTemplateConfigProcessor", 1, "config file not exist");
      aoks.a().a(307, 0);
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
 * Qualified Name:     aoqm
 * JD-Core Version:    0.7.0.1
 */