import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aoqk
  extends aokh<blze>
{
  public int a()
  {
    return 304;
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
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onParsed, content:" + paramArrayOfaoko);
    }
    return new blzb().a(paramArrayOfaoko, blvu.a.getAbsolutePath(), "temp_sticker_zip", new aoql(this));
  }
  
  public Class<blze> a()
  {
    return blze.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onReqFailed");
    }
  }
  
  public void a(blze paramblze)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!blvu.a()) {
      return 0;
    }
    return bdne.D(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!blvu.a())
    {
      QLog.i("QIMStickerConfigProcessor", 1, "config file not exist");
      aoks.a().a(304, 0);
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
 * Qualified Name:     aoqk
 * JD-Core Version:    0.7.0.1
 */