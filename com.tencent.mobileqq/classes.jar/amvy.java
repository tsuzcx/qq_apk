import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amvy
  extends ampa<amvz>
{
  public int a()
  {
    return 551;
  }
  
  @NonNull
  public amvz a(int paramInt)
  {
    return new amvz();
  }
  
  @Nullable
  public amvz a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null)) {
      return amvz.a(paramArrayOfamph[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amvz> a()
  {
    return amvz.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amvz paramamvz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingTogetherConfProcessor", 2, "onUpdate " + paramamvz.toString());
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
 * Qualified Name:     amvy
 * JD-Core Version:    0.7.0.1
 */