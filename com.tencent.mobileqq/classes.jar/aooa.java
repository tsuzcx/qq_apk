import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aooa
  extends aofy<aonz>
{
  public int a()
  {
    return 585;
  }
  
  @NonNull
  public aonz a(int paramInt)
  {
    return new aonz();
  }
  
  @Nullable
  public aonz a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null))
    {
      aonz localaonz = aonz.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVPreloadPskeyConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaonz;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<aonz> a()
  {
    return aonz.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aonz paramaonz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, "onUpdate " + paramaonz.toString());
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, "migrateOldVersion");
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
 * Qualified Name:     aooa
 * JD-Core Version:    0.7.0.1
 */