import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

public class aomk
  extends aofy<aomm>
{
  private void b(aomm paramaomm)
  {
    if (paramaomm == null) {}
    do
    {
      do
      {
        return;
      } while (!paramaomm.a.a());
      String str = paramaomm.a.a;
      if (!TextUtils.isEmpty(str)) {
        URLDrawable.getDrawable(str).startDownload(false);
      }
      paramaomm = paramaomm.a.b;
    } while (TextUtils.isEmpty(paramaomm));
    URLDrawable.getDrawable(paramaomm).startDownload(false);
  }
  
  public int a()
  {
    return 545;
  }
  
  @NonNull
  public aomm a(int paramInt)
  {
    return new aomm();
  }
  
  @Nullable
  public aomm a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return aomm.a(paramArrayOfaogf);
    }
    return null;
  }
  
  public Class<aomm> a()
  {
    return aomm.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aomm paramaomm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiConfProcessor", 2, "QQSysAndEmojiConfProcessor onUpdate");
    }
    b(paramaomm);
    apoa.a().a();
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
 * Qualified Name:     aomk
 * JD-Core Version:    0.7.0.1
 */