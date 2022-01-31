import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class axdm
  extends ampa<axdl>
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
  public axdl a(int paramInt)
  {
    return new axdl();
  }
  
  @Nullable
  public axdl a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      axdl localaxdl = axdl.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localaxdl;
    }
    return null;
  }
  
  public Class<axdl> a()
  {
    return axdl.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(axdl paramaxdl)
  {
    boolean bool2 = true;
    int i = paramaxdl.a;
    int j = paramaxdl.b;
    int k = paramaxdl.c;
    int m = paramaxdl.d;
    paramaxdl = a();
    if (ShortVideoUtils.c(paramaxdl) != j)
    {
      ShortVideoUtils.b(paramaxdl, j);
      if (i == 1)
      {
        bool1 = true;
        ShortVideoUtils.c(paramaxdl, bool1);
        ShortVideoUtils.f = false;
      }
    }
    else if (ShortVideoUtils.b(paramaxdl) != m)
    {
      ShortVideoUtils.a(paramaxdl, m);
      if (k != 1) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ShortVideoUtils.b(paramaxdl, bool1);
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
 * Qualified Name:     axdm
 * JD-Core Version:    0.7.0.1
 */