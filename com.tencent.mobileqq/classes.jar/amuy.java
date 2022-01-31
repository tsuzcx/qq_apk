import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class amuy
  extends ampb<bjiq>
{
  public int a()
  {
    return 304;
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
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onParsed, content:" + paramArrayOfampi);
    }
    return new bjin().a(paramArrayOfampi, bjfg.a.getAbsolutePath(), "temp_sticker_zip", new amuz(this));
  }
  
  public Class<bjiq> a()
  {
    return bjiq.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onReqFailed");
    }
  }
  
  public void a(bjiq parambjiq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!bjfg.a()) {
      return 0;
    }
    return bbjn.C(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!bjfg.a())
    {
      QLog.i("QIMStickerConfigProcessor", 1, "config file not exist");
      ampm.a().a(304, 0);
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
 * Qualified Name:     amuy
 * JD-Core Version:    0.7.0.1
 */