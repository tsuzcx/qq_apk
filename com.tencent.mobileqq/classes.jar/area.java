import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class area
  extends aqwt<bonb>
{
  @NonNull
  public bonb a(int paramInt)
  {
    return new bonb();
  }
  
  @Nullable
  public bonb a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length == 0)) {
      return null;
    }
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onParsed, content:" + paramArrayOfaqxa);
    }
    return new bomy().a(paramArrayOfaqxa, lbh.e(), "temp_filter_zip", new areb(this));
  }
  
  public void a(bonb parambonb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onUpdate");
    }
  }
  
  public Class<bonb> clazz()
  {
    return bonb.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (!new File(bpnd.a + "filter_config_new.xml").exists()) {
      return 0;
    }
    return bpjt.a(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!new File(bpnd.a + "filter_config_new.xml").exists())
    {
      QLog.i("QIMFilterConfigProcessor", 1, "config file not exist");
      aqxe.a().a(306, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 306;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     area
 * JD-Core Version:    0.7.0.1
 */