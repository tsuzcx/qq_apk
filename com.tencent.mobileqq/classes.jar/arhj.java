import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.io.File;

public class arhj
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
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onParsed, content:" + paramArrayOfaraj);
    }
    return new bpua().a(paramArrayOfaraj, QIMMusicConfigManager.a.getAbsolutePath(), "temp_music_zip", new arhk(this));
  }
  
  public void a(bpud parambpud)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onUpdate");
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
    if (!QIMMusicConfigManager.a()) {
      return 0;
    }
    return bhsi.B(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!QIMMusicConfigManager.a())
    {
      QLog.i("QIMMusicConfigProcessor", 1, "config file not exist");
      aran.a().a(305, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 305;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhj
 * JD-Core Version:    0.7.0.1
 */