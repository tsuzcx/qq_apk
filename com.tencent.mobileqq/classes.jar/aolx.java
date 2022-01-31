import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aolx
  extends aofy<blus>
{
  public int a()
  {
    return 306;
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
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onParsed, content:" + paramArrayOfaogf);
    }
    return new blup().a(paramArrayOfaogf, len.e(), "temp_filter_zip", new aoly(this));
  }
  
  public Class<blus> a()
  {
    return blus.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onReqFailed");
    }
  }
  
  public void a(blus paramblus)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!new File(bngf.a + "filter_config_new.xml").exists()) {
      return 0;
    }
    return bncp.a(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!new File(bngf.a + "filter_config_new.xml").exists())
    {
      QLog.i("QIMFilterConfigProcessor", 1, "config file not exist");
      aogj.a().a(306, 0);
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
 * Qualified Name:     aolx
 * JD-Core Version:    0.7.0.1
 */