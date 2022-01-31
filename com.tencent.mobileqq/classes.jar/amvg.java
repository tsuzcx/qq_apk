import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amvg
  extends ampa<amvh>
{
  public int a()
  {
    return 545;
  }
  
  @NonNull
  public amvh a(int paramInt)
  {
    return new amvh();
  }
  
  @Nullable
  public amvh a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0)) {
      return amvh.a(paramArrayOfamph);
    }
    return null;
  }
  
  public Class<amvh> a()
  {
    return amvh.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amvh paramamvh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiConfProcessor", 2, "QQSysAndEmojiConfProcessor onUpdate");
    }
    anwr.a().a();
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
 * Qualified Name:     amvg
 * JD-Core Version:    0.7.0.1
 */