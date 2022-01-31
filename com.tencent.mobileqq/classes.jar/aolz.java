import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.io.File;

public class aolz
  extends aofy<blus>
{
  public int a()
  {
    return 305;
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
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onParsed, content:" + paramArrayOfaogf);
    }
    return new blup().a(paramArrayOfaogf, QIMMusicConfigManager.a.getAbsolutePath(), "temp_music_zip", new aoma(this));
  }
  
  public Class<blus> a()
  {
    return blus.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onReqFailed");
    }
  }
  
  public void a(blus paramblus)
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
    return bdiv.C(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!QIMMusicConfigManager.a())
    {
      QLog.i("QIMMusicConfigProcessor", 1, "config file not exist");
      aogj.a().a(305, 0);
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
 * Qualified Name:     aolz
 * JD-Core Version:    0.7.0.1
 */