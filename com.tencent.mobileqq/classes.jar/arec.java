import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.io.File;

public class arec
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
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onParsed, content:" + paramArrayOfaqxa);
    }
    return new bomy().a(paramArrayOfaqxa, QIMMusicConfigManager.a.getAbsolutePath(), "temp_music_zip", new ared(this));
  }
  
  public void a(bonb parambonb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onUpdate");
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
    if (!QIMMusicConfigManager.a()) {
      return 0;
    }
    return bhhr.B(BaseApplicationImpl.getContext());
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
      aqxe.a().a(305, 0);
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
 * Qualified Name:     arec
 * JD-Core Version:    0.7.0.1
 */