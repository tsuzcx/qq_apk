import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class areg
  extends aqwt<bonb>
{
  @NonNull
  public bonb a(int paramInt)
  {
    return new bonb();
  }
  
  @Nullable
  public bonb a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length == 0)) {
      return null;
    }
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onParsed, content:" + paramArrayOfaqxa);
    }
    return new bomy().a(paramArrayOfaqxa, bpqs.a.getAbsolutePath(), "temp_faceu_zip", new areh(this));
  }
  
  public void a(bonb parambonb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onUpdate");
    }
  }
  
  public Class<bonb> clazz()
  {
    return bonb.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (!bpqs.a()) {
      return 0;
    }
    return bhhr.D(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!bpqs.a())
    {
      QLog.i("QIMTemplateConfigProcessor", 1, "config file not exist");
      aqxe.a().a(307, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 307;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     areg
 * JD-Core Version:    0.7.0.1
 */