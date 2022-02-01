import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class bcwq
  extends arac<bcwp>
{
  private String a()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c();
  }
  
  @NonNull
  public bcwp a(int paramInt)
  {
    return new bcwp();
  }
  
  @Nullable
  public bcwp a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      bcwp localbcwp = bcwp.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localbcwp;
    }
    return null;
  }
  
  public void a(bcwp parambcwp)
  {
    boolean bool2 = true;
    int i = parambcwp.a;
    int j = parambcwp.b;
    int k = parambcwp.c;
    int m = parambcwp.d;
    parambcwp = a();
    if (ShortVideoUtils.c(parambcwp) != j)
    {
      ShortVideoUtils.b(parambcwp, j);
      if (i == 1)
      {
        bool1 = true;
        ShortVideoUtils.c(parambcwp, bool1);
        ShortVideoUtils.f = false;
      }
    }
    else if (ShortVideoUtils.b(parambcwp) != m)
    {
      ShortVideoUtils.a(parambcwp, m);
      if (k != 1) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ShortVideoUtils.b(parambcwp, bool1);
      ShortVideoUtils.e = false;
      return;
      bool1 = false;
      break;
    }
  }
  
  public Class<bcwp> clazz()
  {
    return bcwp.class;
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
    return ShortVideoUtils.a(a());
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
 * Qualified Name:     bcwq
 * JD-Core Version:    0.7.0.1
 */