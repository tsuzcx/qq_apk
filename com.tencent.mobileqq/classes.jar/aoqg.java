import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aoqg
  extends aokh<blze>
{
  public int a()
  {
    return 306;
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
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onParsed, content:" + paramArrayOfaoko);
    }
    return new blzb().a(paramArrayOfaoko, len.e(), "temp_filter_zip", new aoqh(this));
  }
  
  public Class<blze> a()
  {
    return blze.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onReqFailed");
    }
  }
  
  public void a(blze paramblze)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onUpdate");
    }
  }
  
  public int b()
  {
    if (!new File(bnkr.a + "filter_config_new.xml").exists()) {
      return 0;
    }
    return bnhb.a(BaseApplicationImpl.getContext());
  }
  
  public int b(int paramInt)
  {
    if (!new File(bnkr.a + "filter_config_new.xml").exists())
    {
      QLog.i("QIMFilterConfigProcessor", 1, "config file not exist");
      aoks.a().a(306, 0);
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
 * Qualified Name:     aoqg
 * JD-Core Version:    0.7.0.1
 */