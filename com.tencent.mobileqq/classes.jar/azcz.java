import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class azcz
  extends aokh<azcy>
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
  public azcy a(int paramInt)
  {
    return new azcy();
  }
  
  @Nullable
  public azcy a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      azcy localazcy = azcy.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localazcy;
    }
    return null;
  }
  
  public Class<azcy> a()
  {
    return azcy.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoAndHotPicRedDotConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(azcy paramazcy)
  {
    boolean bool2 = true;
    int i = paramazcy.a;
    int j = paramazcy.b;
    int k = paramazcy.c;
    int m = paramazcy.d;
    paramazcy = a();
    if (ShortVideoUtils.c(paramazcy) != j)
    {
      ShortVideoUtils.b(paramazcy, j);
      if (i == 1)
      {
        bool1 = true;
        ShortVideoUtils.c(paramazcy, bool1);
        ShortVideoUtils.f = false;
      }
    }
    else if (ShortVideoUtils.b(paramazcy) != m)
    {
      ShortVideoUtils.a(paramazcy, m);
      if (k != 1) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ShortVideoUtils.b(paramazcy, bool1);
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
 * Qualified Name:     azcz
 * JD-Core Version:    0.7.0.1
 */