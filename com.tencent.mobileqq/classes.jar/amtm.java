import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amtm
  extends ampa<amtl>
{
  public int a()
  {
    return 578;
  }
  
  @NonNull
  public amtl a(int paramInt)
  {
    return new amtl();
  }
  
  @Nullable
  public amtl a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amtl localamtl = amtl.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamtl;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amtl> a()
  {
    return amtl.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amtl paramamtl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, "onUpdate " + paramamtl.toString());
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, "migrateOldVersion");
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
 * Qualified Name:     amtm
 * JD-Core Version:    0.7.0.1
 */