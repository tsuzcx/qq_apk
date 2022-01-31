import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class awec
  extends alzl<aweb>
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
  public aweb a(int paramInt)
  {
    return new aweb();
  }
  
  @Nullable
  public aweb a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      aweb localaweb = aweb.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localaweb;
    }
    return null;
  }
  
  public Class<aweb> a()
  {
    return aweb.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aweb paramaweb)
  {
    boolean bool2 = true;
    int i = paramaweb.a;
    int j = paramaweb.b;
    int k = paramaweb.c;
    int m = paramaweb.d;
    paramaweb = a();
    if (ShortVideoUtils.c(paramaweb) != j)
    {
      ShortVideoUtils.b(paramaweb, j);
      if (i == 1)
      {
        bool1 = true;
        ShortVideoUtils.c(paramaweb, bool1);
        ShortVideoUtils.f = false;
      }
    }
    else if (ShortVideoUtils.b(paramaweb) != m)
    {
      ShortVideoUtils.a(paramaweb, m);
      if (k != 1) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ShortVideoUtils.b(paramaweb, bool1);
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
 * Qualified Name:     awec
 * JD-Core Version:    0.7.0.1
 */