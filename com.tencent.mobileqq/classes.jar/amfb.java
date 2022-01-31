import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amfb
  extends alzl<amfc>
{
  public int a()
  {
    return 545;
  }
  
  @NonNull
  public amfc a(int paramInt)
  {
    return new amfc();
  }
  
  @Nullable
  public amfc a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0)) {
      return amfc.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public Class<amfc> a()
  {
    return amfc.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amfc paramamfc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiConfProcessor", 2, "QQSysAndEmojiConfProcessor onUpdate");
    }
    angd.a().a();
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
 * Qualified Name:     amfb
 * JD-Core Version:    0.7.0.1
 */