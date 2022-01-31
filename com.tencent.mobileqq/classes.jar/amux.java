import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class amux
  extends ampa<bjjh>
{
  public int a()
  {
    return 304;
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
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onParsed, content:" + paramArrayOfamph);
    }
    return new bjje().a(paramArrayOfamph, bjfx.a.getAbsolutePath(), "temp_sticker_zip", new amuy(this));
  }
  
  public Class<bjjh> a()
  {
    return bjjh.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onReqFailed");
    }
  }
  
  public void a(bjjh parambjjh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!bjfx.a()) {
      return 0;
    }
    return bbkb.C(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!bjfx.a())
    {
      QLog.i("QIMStickerConfigProcessor", 1, "config file not exist");
      ampl.a().a(304, 0);
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
 * Qualified Name:     amux
 * JD-Core Version:    0.7.0.1
 */