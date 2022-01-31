import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqyu
  extends ampa<aqyt>
{
  private aqze a()
  {
    try
    {
      aqze localaqze = aqze.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      return localaqze;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public int a()
  {
    return 164;
  }
  
  @NonNull
  public aqyt a(int paramInt)
  {
    aqyt localaqyt = new aqyt();
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return localaqyt;
  }
  
  @Nullable
  public aqyt a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      aqyt localaqyt = aqyt.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("HotPicConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localaqyt;
    }
    return null;
  }
  
  public Class<aqyt> a()
  {
    return aqyt.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(aqyt paramaqyt)
  {
    aqze localaqze = a();
    if (localaqze != null) {
      localaqze.b(paramaqyt.a);
    }
  }
  
  public int b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      return aqze.a(localQQAppInterface);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqyu
 * JD-Core Version:    0.7.0.1
 */