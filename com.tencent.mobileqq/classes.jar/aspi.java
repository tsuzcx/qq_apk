import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aspi
  extends aofy<asph>
{
  private asps a()
  {
    try
    {
      asps localasps = asps.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      return localasps;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public int a()
  {
    return 164;
  }
  
  @NonNull
  public asph a(int paramInt)
  {
    asph localasph = new asph();
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return localasph;
  }
  
  @Nullable
  public asph a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      asph localasph = asph.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("HotPicConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localasph;
    }
    return null;
  }
  
  public Class<asph> a()
  {
    return asph.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(asph paramasph)
  {
    asps localasps = a();
    if (localasps != null) {
      localasps.b(paramasph.a);
    }
  }
  
  public int b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      return asps.a(localQQAppInterface);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspi
 * JD-Core Version:    0.7.0.1
 */