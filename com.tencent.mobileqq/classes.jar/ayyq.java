import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class ayyq
  extends aofy<ayyp>
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
  public ayyp a(int paramInt)
  {
    return new ayyp();
  }
  
  @Nullable
  public ayyp a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      ayyp localayyp = ayyp.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localayyp;
    }
    return null;
  }
  
  public Class<ayyp> a()
  {
    return ayyp.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(ayyp paramayyp)
  {
    boolean bool2 = true;
    int i = paramayyp.a;
    int j = paramayyp.b;
    int k = paramayyp.c;
    int m = paramayyp.d;
    paramayyp = a();
    if (ShortVideoUtils.c(paramayyp) != j)
    {
      ShortVideoUtils.b(paramayyp, j);
      if (i == 1)
      {
        bool1 = true;
        ShortVideoUtils.c(paramayyp, bool1);
        ShortVideoUtils.f = false;
      }
    }
    else if (ShortVideoUtils.b(paramayyp) != m)
    {
      ShortVideoUtils.a(paramayyp, m);
      if (k != 1) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ShortVideoUtils.b(paramayyp, bool1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyq
 * JD-Core Version:    0.7.0.1
 */