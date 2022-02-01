import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class bfyb
  extends aqwt<bfya>
{
  @NonNull
  public bfya a(int paramInt)
  {
    QLog.d("TroopLuckyCharacterConfigProcess", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new bfya();
  }
  
  @Nullable
  public bfya a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopLuckyCharacterConfigProcess", 2, "onParsed");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return bfya.a(paramArrayOfaqxa[0].a);
    }
    return null;
  }
  
  public void a(bfya parambfya) {}
  
  public Class<bfya> clazz()
  {
    return bfya.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("TroopLuckyCharacterConfigProcess", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 696;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfyb
 * JD-Core Version:    0.7.0.1
 */