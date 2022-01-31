import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class axdk
  extends ampb<axdj>
{
  private String a()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c();
  }
  
  public int a()
  {
    return 325;
  }
  
  @NonNull
  public axdj a(int paramInt)
  {
    return new axdj();
  }
  
  @Nullable
  public axdj a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      axdj localaxdj = axdj.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localaxdj;
    }
    return null;
  }
  
  public Class<axdj> a()
  {
    return axdj.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(axdj paramaxdj)
  {
    boolean bool2 = true;
    int i = paramaxdj.a;
    int j = paramaxdj.b;
    int k = paramaxdj.c;
    int m = paramaxdj.d;
    paramaxdj = a();
    if (ShortVideoUtils.c(paramaxdj) != j)
    {
      ShortVideoUtils.b(paramaxdj, j);
      if (i == 1)
      {
        bool1 = true;
        ShortVideoUtils.c(paramaxdj, bool1);
        ShortVideoUtils.f = false;
      }
    }
    else if (ShortVideoUtils.b(paramaxdj) != m)
    {
      ShortVideoUtils.a(paramaxdj, m);
      if (k != 1) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ShortVideoUtils.b(paramaxdj, bool1);
      ShortVideoUtils.e = false;
      return;
      bool1 = false;
      break;
    }
  }
  
  public int b()
  {
    return ShortVideoUtils.a(a());
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axdk
 * JD-Core Version:    0.7.0.1
 */