import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.io.File;

public class aoqi
  extends aokh<blze>
{
  public int a()
  {
    return 305;
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
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onParsed, content:" + paramArrayOfaoko);
    }
    return new blzb().a(paramArrayOfaoko, QIMMusicConfigManager.a.getAbsolutePath(), "temp_music_zip", new aoqj(this));
  }
  
  public Class<blze> a()
  {
    return blze.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onReqFailed");
    }
  }
  
  public void a(blze paramblze)
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
    return bdne.C(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!QIMMusicConfigManager.a())
    {
      QLog.i("QIMMusicConfigProcessor", 1, "config file not exist");
      aoks.a().a(305, 0);
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
 * Qualified Name:     aoqi
 * JD-Core Version:    0.7.0.1
 */