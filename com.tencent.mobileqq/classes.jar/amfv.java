import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amfv
  extends alzl<amfw>
{
  public int a()
  {
    return 551;
  }
  
  @NonNull
  public amfw a(int paramInt)
  {
    return new amfw();
  }
  
  @Nullable
  public amfw a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0) && (paramArrayOfalzs[0] != null)) {
      return amfw.a(paramArrayOfalzs[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amfw> a()
  {
    return amfw.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amfw paramamfw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, "onUpdate " + paramamfw.toString());
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, "migrateOldVersion");
    }
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
 * Qualified Name:     amfv
 * JD-Core Version:    0.7.0.1
 */