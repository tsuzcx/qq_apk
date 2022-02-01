import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class arhl
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
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onParsed, content:" + paramArrayOfaraj);
    }
    return new bpua().a(paramArrayOfaraj, bpqt.a.getAbsolutePath(), "temp_sticker_zip", new arhm(this));
  }
  
  public void a(bpud parambpud)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onUpdate");
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
    if (!bpqt.a()) {
      return 0;
    }
    return bhsi.C(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!bpqt.a())
    {
      QLog.i("QIMStickerConfigProcessor", 1, "config file not exist");
      aran.a().a(304, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 304;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhl
 * JD-Core Version:    0.7.0.1
 */