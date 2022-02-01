import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aree
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
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onParsed, content:" + paramArrayOfaqxa);
    }
    return new bomy().a(paramArrayOfaqxa, boke.a.getAbsolutePath(), "temp_sticker_zip", new aref(this));
  }
  
  public void a(bonb parambonb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onUpdate");
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
    if (!boke.a()) {
      return 0;
    }
    return bhhr.C(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!boke.a())
    {
      QLog.i("QIMStickerConfigProcessor", 1, "config file not exist");
      aqxe.a().a(304, 0);
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
 * Qualified Name:     aree
 * JD-Core Version:    0.7.0.1
 */