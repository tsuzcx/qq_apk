import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class astr
  extends aokh<astq>
{
  private asub a()
  {
    try
    {
      asub localasub = asub.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      return localasub;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public int a()
  {
    return 164;
  }
  
  @NonNull
  public astq a(int paramInt)
  {
    astq localastq = new astq();
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return localastq;
  }
  
  @Nullable
  public astq a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      astq localastq = astq.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("HotPicConfProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localastq;
    }
    return null;
  }
  
  public Class<astq> a()
  {
    return astq.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotPicConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(astq paramastq)
  {
    asub localasub = a();
    if (localasub != null) {
      localasub.b(paramastq.a);
    }
  }
  
  public int b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      return asub.a(localQQAppInterface);
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
 * Qualified Name:     astr
 * JD-Core Version:    0.7.0.1
 */