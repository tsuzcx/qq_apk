import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ames
  extends alzl<bhny>
{
  public int a()
  {
    return 304;
  }
  
  @NonNull
  public bhny a(int paramInt)
  {
    return new bhny();
  }
  
  @Nullable
  public bhny a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length == 0)) {
      return null;
    }
    paramArrayOfalzs = paramArrayOfalzs[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onParsed, content:" + paramArrayOfalzs);
    }
    return new bhnv().a(paramArrayOfalzs, bhko.a.getAbsolutePath(), "temp_sticker_zip", new amet(this));
  }
  
  public Class<bhny> a()
  {
    return bhny.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onReqFailed");
    }
  }
  
  public void a(bhny parambhny)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!bhko.a()) {
      return 0;
    }
    return baig.D(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!bhko.a())
    {
      QLog.i("QIMStickerConfigProcessor", 1, "config file not exist");
      alzw.a().a(304, 0);
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
 * Qualified Name:     ames
 * JD-Core Version:    0.7.0.1
 */