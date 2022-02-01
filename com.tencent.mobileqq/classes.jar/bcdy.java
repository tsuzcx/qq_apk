import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class bcdy
  extends aqkz<bcdx>
{
  private String a()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c();
  }
  
  @NonNull
  public bcdx a(int paramInt)
  {
    return new bcdx();
  }
  
  @Nullable
  public bcdx a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      bcdx localbcdx = bcdx.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localbcdx;
    }
    return null;
  }
  
  public void a(bcdx parambcdx)
  {
    boolean bool2 = true;
    int i = parambcdx.a;
    int j = parambcdx.b;
    int k = parambcdx.c;
    int m = parambcdx.d;
    parambcdx = a();
    if (ShortVideoUtils.c(parambcdx) != j)
    {
      ShortVideoUtils.b(parambcdx, j);
      if (i == 1)
      {
        bool1 = true;
        ShortVideoUtils.c(parambcdx, bool1);
        ShortVideoUtils.f = false;
      }
    }
    else if (ShortVideoUtils.b(parambcdx) != m)
    {
      ShortVideoUtils.a(parambcdx, m);
      if (k != 1) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ShortVideoUtils.b(parambcdx, bool1);
      ShortVideoUtils.e = false;
      return;
      bool1 = false;
      break;
    }
  }
  
  public Class<bcdx> clazz()
  {
    return bcdx.class;
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
 * Qualified Name:     bcdy
 * JD-Core Version:    0.7.0.1
 */