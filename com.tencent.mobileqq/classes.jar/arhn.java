import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class arhn
  extends arac<bpud>
{
  @NonNull
  public bpud a(int paramInt)
  {
    return new bpud();
  }
  
  @Nullable
  public bpud a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length == 0)) {
      return null;
    }
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onParsed, content:" + paramArrayOfaraj);
    }
    return new bpua().a(paramArrayOfaraj, brhn.a.getAbsolutePath(), "temp_faceu_zip", new arho(this));
  }
  
  public void a(bpud parambpud)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onUpdate");
    }
  }
  
  public Class<bpud> clazz()
  {
    return bpud.class;
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
    if (!brhn.a()) {
      return 0;
    }
    return bhsi.D(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!brhn.a())
    {
      QLog.i("QIMTemplateConfigProcessor", 1, "config file not exist");
      aran.a().a(307, 0);
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
 * Qualified Name:     arhn
 * JD-Core Version:    0.7.0.1
 */