import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aomb
  extends aofy<blus>
{
  public int a()
  {
    return 304;
  }
  
  @NonNull
  public blus a(int paramInt)
  {
    return new blus();
  }
  
  @Nullable
  public blus a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length == 0)) {
      return null;
    }
    paramArrayOfaogf = paramArrayOfaogf[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onParsed, content:" + paramArrayOfaogf);
    }
    return new blup().a(paramArrayOfaogf, blri.a.getAbsolutePath(), "temp_sticker_zip", new aomc(this));
  }
  
  public Class<blus> a()
  {
    return blus.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onReqFailed");
    }
  }
  
  public void a(blus paramblus)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!blri.a()) {
      return 0;
    }
    return bdiv.D(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!blri.a())
    {
      QLog.i("QIMStickerConfigProcessor", 1, "config file not exist");
      aogj.a().a(304, 0);
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
 * Qualified Name:     aomb
 * JD-Core Version:    0.7.0.1
 */