import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class arhh
  extends arac<bpud>
{
  @NonNull
  public bpud a(int paramInt)
  {
    return new bpud();
  }
  
  @Nullable
  public bpud a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length == 0)) {
      return null;
    }
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onParsed, content:" + paramArrayOfaraj);
    }
    return new bpua().a(paramArrayOfaraj, lbm.e(), "temp_filter_zip", new arhi(this));
  }
  
  public void a(bpud parambpud)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onUpdate");
    }
  }
  
  public Class<bpud> clazz()
  {
    return bpud.class;
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
    if (!new File(brdl.a + "filter_config_new.xml").exists()) {
      return 0;
    }
    return bqzz.a(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMFilterConfigProcessor", 2, "handleGetQIMFilterConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!new File(brdl.a + "filter_config_new.xml").exists())
    {
      QLog.i("QIMFilterConfigProcessor", 1, "config file not exist");
      aran.a().a(306, 0);
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
 * Qualified Name:     arhh
 * JD-Core Version:    0.7.0.1
 */