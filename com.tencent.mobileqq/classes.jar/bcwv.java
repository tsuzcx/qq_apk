import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class bcwv
  extends aqwt<bcwu>
{
  private String a()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
  }
  
  @NonNull
  public bcwu a(int paramInt)
  {
    return new bcwu();
  }
  
  @Nullable
  public bcwu a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      bcwu localbcwu = bcwu.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localbcwu;
    }
    return null;
  }
  
  public void a(bcwu parambcwu)
  {
    boolean bool2 = true;
    int i = parambcwu.a;
    int j = parambcwu.b;
    int k = parambcwu.c;
    int m = parambcwu.d;
    parambcwu = a();
    if (ShortVideoUtils.getHotPiCRedDotConfigVersion(parambcwu) != j)
    {
      ShortVideoUtils.setHotPiCRedDotConfigVersion(parambcwu, j);
      if (i == 1)
      {
        bool1 = true;
        ShortVideoUtils.setHotPicRedDotStatus(parambcwu, bool1);
        ShortVideoUtils.isHotPicConfiginitied = false;
      }
    }
    else if (ShortVideoUtils.getPtvRedDotConfigVersion(parambcwu) != m)
    {
      ShortVideoUtils.setPtvRedDotConfigVersion(parambcwu, m);
      if (k != 1) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ShortVideoUtils.setPtvRedDotStatus(parambcwu, bool1);
      ShortVideoUtils.isPtvConfiginitied = false;
      return;
      bool1 = false;
      break;
    }
  }
  
  public Class<bcwu> clazz()
  {
    return bcwu.class;
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
    return ShortVideoUtils.getPtvHotPicConfigVersion(a());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 325;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwv
 * JD-Core Version:    0.7.0.1
 */