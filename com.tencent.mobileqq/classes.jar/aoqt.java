import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

public class aoqt
  extends aokh<aoqv>
{
  private void b(aoqv paramaoqv)
  {
    if (paramaoqv == null) {}
    do
    {
      do
      {
        return;
      } while (!paramaoqv.a.a());
      String str = paramaoqv.a.a;
      if (!TextUtils.isEmpty(str)) {
        URLDrawable.getDrawable(str).startDownload(false);
      }
      paramaoqv = paramaoqv.a.b;
    } while (TextUtils.isEmpty(paramaoqv));
    URLDrawable.getDrawable(paramaoqv).startDownload(false);
  }
  
  public int a()
  {
    return 545;
  }
  
  @NonNull
  public aoqv a(int paramInt)
  {
    return new aoqv();
  }
  
  @Nullable
  public aoqv a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0)) {
      return aoqv.a(paramArrayOfaoko);
    }
    return null;
  }
  
  public Class<aoqv> a()
  {
    return aoqv.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoqv paramaoqv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiConfProcessor", 2, "QQSysAndEmojiConfProcessor onUpdate");
    }
    b(paramaoqv);
    apsj.a().a();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqt
 * JD-Core Version:    0.7.0.1
 */