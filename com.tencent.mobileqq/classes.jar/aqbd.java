import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aqbd
  extends aptq<bmxj>
{
  @NonNull
  public bmxj a(int paramInt)
  {
    return new bmxj();
  }
  
  @Nullable
  public bmxj a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length == 0)) {
      return null;
    }
    paramArrayOfaptx = paramArrayOfaptx[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onParsed, content:" + paramArrayOfaptx);
    }
    return new bmxg().a(paramArrayOfaptx, boba.a.getAbsolutePath(), "temp_faceu_zip", new aqbe(this));
  }
  
  public void a(bmxj parambmxj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onUpdate");
    }
  }
  
  public Class<bmxj> clazz()
  {
    return bmxj.class;
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
    if (!boba.a()) {
      return 0;
    }
    return bfyz.D(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMTemplateConfigProcessor", 2, "handleQIMTemplateConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!boba.a())
    {
      QLog.i("QIMTemplateConfigProcessor", 1, "config file not exist");
      apub.a().a(307, 0);
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
 * Qualified Name:     aqbd
 * JD-Core Version:    0.7.0.1
 */