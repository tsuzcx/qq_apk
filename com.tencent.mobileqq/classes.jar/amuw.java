import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.io.File;

public class amuw
  extends ampb<bjiq>
{
  public int a()
  {
    return 305;
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
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onParsed, content:" + paramArrayOfampi);
    }
    return new bjin().a(paramArrayOfampi, QIMMusicConfigManager.a.getAbsolutePath(), "temp_music_zip", new amux(this));
  }
  
  public Class<bjiq> a()
  {
    return bjiq.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onReqFailed");
    }
  }
  
  public void a(bjiq parambjiq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!QIMMusicConfigManager.a()) {
      return 0;
    }
    return bbjn.B(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!QIMMusicConfigManager.a())
    {
      QLog.i("QIMMusicConfigProcessor", 1, "config file not exist");
      ampm.a().a(305, 0);
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
 * Qualified Name:     amuw
 * JD-Core Version:    0.7.0.1
 */