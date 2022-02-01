import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aqbb
  extends aptq<bmxj>
{
  @NonNull
  public bmxj a(int paramInt)
  {
    return new bmxj();
  }
  
  @Nullable
  public bmxj a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length == 0)) {
      return null;
    }
    paramArrayOfaptx = paramArrayOfaptx[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onParsed, content:" + paramArrayOfaptx);
    }
    return new bmxg().a(paramArrayOfaptx, bmum.a.getAbsolutePath(), "temp_sticker_zip", new aqbc(this));
  }
  
  public void a(bmxj parambmxj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onUpdate");
    }
  }
  
  public Class<bmxj> clazz()
  {
    return bmxj.class;
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
    if (!bmum.a()) {
      return 0;
    }
    return bfyz.C(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!bmum.a())
    {
      QLog.i("QIMStickerConfigProcessor", 1, "config file not exist");
      apub.a().a(304, 0);
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
 * Qualified Name:     aqbb
 * JD-Core Version:    0.7.0.1
 */