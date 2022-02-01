import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class bbqb
  extends aptq<bbqa>
{
  private String a()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
  }
  
  @NonNull
  public bbqa a(int paramInt)
  {
    return new bbqa();
  }
  
  @Nullable
  public bbqa a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      bbqa localbbqa = bbqa.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localbbqa;
    }
    return null;
  }
  
  public void a(bbqa parambbqa)
  {
    boolean bool2 = true;
    int i = parambbqa.a;
    int j = parambbqa.b;
    int k = parambbqa.c;
    int m = parambbqa.d;
    parambbqa = a();
    if (ShortVideoUtils.getHotPiCRedDotConfigVersion(parambbqa) != j)
    {
      ShortVideoUtils.setHotPiCRedDotConfigVersion(parambbqa, j);
      if (i == 1)
      {
        bool1 = true;
        ShortVideoUtils.setHotPicRedDotStatus(parambbqa, bool1);
        ShortVideoUtils.isHotPicConfiginitied = false;
      }
    }
    else if (ShortVideoUtils.getPtvRedDotConfigVersion(parambbqa) != m)
    {
      ShortVideoUtils.setPtvRedDotConfigVersion(parambbqa, m);
      if (k != 1) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ShortVideoUtils.setPtvRedDotStatus(parambbqa, bool1);
      ShortVideoUtils.isPtvConfiginitied = false;
      return;
      bool1 = false;
      break;
    }
  }
  
  public Class<bbqa> clazz()
  {
    return bbqa.class;
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
 * Qualified Name:     bbqb
 * JD-Core Version:    0.7.0.1
 */