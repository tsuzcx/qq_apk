import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ameo
  extends alzl<bhny>
{
  public int a()
  {
    return 306;
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
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onParsed, content:" + paramArrayOfalzs);
    }
    return new bhnv().a(paramArrayOfalzs, lfh.b, "temp_filter_zip", new amep(this));
  }
  
  public Class<bhny> a()
  {
    return bhny.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onReqFailed");
    }
  }
  
  public void a(bhny parambhny)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!new File(bjds.a + "filter_config_new.xml").exists()) {
      return 0;
    }
    return bjac.a(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!new File(bjds.a + "filter_config_new.xml").exists())
    {
      QLog.i("QIMFilterConfigProcessor", 1, "config file not exist");
      alzw.a().a(306, 0);
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
 * Qualified Name:     ameo
 * JD-Core Version:    0.7.0.1
 */