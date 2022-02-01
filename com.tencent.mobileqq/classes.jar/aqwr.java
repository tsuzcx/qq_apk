import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class aqwr<T>
  extends aqkz<T>
{
  @NonNull
  public abstract T a();
  
  @NonNull
  public abstract T a(@NonNull aqlg[] paramArrayOfaqlg);
  
  @NonNull
  public abstract T b();
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  @NonNull
  public T migrateOldOrDefaultContent(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 1) {
      localObject1 = b();
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        zkb.a(getClass().getName() + ".migrateOldOrDefaultContent return null!! type=" + paramInt, new Object[0]);
        localObject2 = a();
      }
      return localObject2;
      if (paramInt == 0) {
        localObject1 = a();
      } else {
        zkb.a(getClass().getName() + ".migrateOldOrDefaultContent illegal type: " + paramInt, new Object[0]);
      }
    }
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public T onParsed(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0))
    {
      yqp.e("QVipConfigProcessor", getClass().getName() + ".onParsed error: confFiles is empty");
      paramArrayOfaqlg = a();
      if (paramArrayOfaqlg != null) {}
      for (boolean bool = true;; bool = false)
      {
        zkb.a(bool, getClass().getName() + ".onParsed error: confFiles is empty");
        return paramArrayOfaqlg;
      }
    }
    yqp.d("QVipConfigProcessor", getClass().getName() + ".parsed content count=" + paramArrayOfaqlg.length);
    return a(paramArrayOfaqlg);
  }
  
  public void onReqFailed(int paramInt)
  {
    yqp.e("QVipConfigProcessor", getClass().getName() + ".onReqFailed: " + paramInt);
  }
  
  public void onUpdate(T paramT)
  {
    yqp.d("QVipConfigProcessor", getClass().getName() + ".onUpdate: " + paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqwr
 * JD-Core Version:    0.7.0.1
 */