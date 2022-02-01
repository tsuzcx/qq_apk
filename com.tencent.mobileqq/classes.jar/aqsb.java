import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aqsb
  extends aqkz<bosi>
{
  @NonNull
  public bosi a(int paramInt)
  {
    return new bosi();
  }
  
  @Nullable
  public bosi a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length == 0)) {
      return null;
    }
    paramArrayOfaqlg = paramArrayOfaqlg[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onParsed, content:" + paramArrayOfaqlg);
    }
    return new bosf().a(paramArrayOfaqlg, booy.a.getAbsolutePath(), "temp_sticker_zip", new aqsc(this));
  }
  
  public void a(bosi parambosi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onUpdate");
    }
  }
  
  public Class<bosi> clazz()
  {
    return bosi.class;
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
    if (!booy.a()) {
      return 0;
    }
    return bgsg.C(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!booy.a())
    {
      QLog.i("QIMStickerConfigProcessor", 1, "config file not exist");
      aqlk.a().a(304, 0);
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
 * Qualified Name:     aqsb
 * JD-Core Version:    0.7.0.1
 */