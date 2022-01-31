import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.io.File;

public class ameq
  extends alzl<bhny>
{
  public int a()
  {
    return 305;
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
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onParsed, content:" + paramArrayOfalzs);
    }
    return new bhnv().a(paramArrayOfalzs, QIMMusicConfigManager.a.getAbsolutePath(), "temp_music_zip", new amer(this));
  }
  
  public Class<bhny> a()
  {
    return bhny.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onReqFailed");
    }
  }
  
  public void a(bhny parambhny)
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
    return baig.C(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!QIMMusicConfigManager.a())
    {
      QLog.i("QIMMusicConfigProcessor", 1, "config file not exist");
      alzw.a().a(305, 0);
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
 * Qualified Name:     ameq
 * JD-Core Version:    0.7.0.1
 */