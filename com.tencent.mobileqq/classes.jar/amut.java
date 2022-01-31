import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class amut
  extends ampa<bjjh>
{
  public int a()
  {
    return 306;
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
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onParsed, content:" + paramArrayOfamph);
    }
    return new bjje().a(paramArrayOfamph, lcj.e(), "temp_filter_zip", new amuu(this));
  }
  
  public Class<bjjh> a()
  {
    return bjjh.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onReqFailed");
    }
  }
  
  public void a(bjjh parambjjh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!new File(bkuv.a + "filter_config_new.xml").exists()) {
      return 0;
    }
    return bkrf.a(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!new File(bkuv.a + "filter_config_new.xml").exists())
    {
      QLog.i("QIMFilterConfigProcessor", 1, "config file not exist");
      ampl.a().a(306, 0);
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
 * Qualified Name:     amut
 * JD-Core Version:    0.7.0.1
 */