import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class aopw<T>
  extends aofy<T>
{
  @NonNull
  public abstract T a();
  
  @NonNull
  public T a(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 1) {
      localObject1 = a();
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        xmh.a(getClass().getName() + ".migrateOldOrDefaultContent return null!! type=" + paramInt, new Object[0]);
        localObject2 = b();
      }
      return localObject2;
      if (paramInt == 0) {
        localObject1 = b();
      } else {
        xmh.a(getClass().getName() + ".migrateOldOrDefaultContent illegal type: " + paramInt, new Object[0]);
      }
    }
  }
  
  @NonNull
  public abstract T a(@NonNull aogf[] paramArrayOfaogf);
  
  public void a(int paramInt)
  {
    wsv.e("QVipConfigProcessor", getClass().getName() + ".onReqFailed: " + paramInt);
  }
  
  public void a(T paramT)
  {
    wsv.d("QVipConfigProcessor", getClass().getName() + ".onUpdate: " + paramT);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return 0;
  }
  
  @NonNull
  public abstract T b();
  
  @Nullable
  public T b(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0))
    {
      wsv.e("QVipConfigProcessor", getClass().getName() + ".onParsed error: confFiles is empty");
      paramArrayOfaogf = b();
      if (paramArrayOfaogf != null) {}
      for (boolean bool = true;; bool = false)
      {
        xmh.a(bool, getClass().getName() + ".onParsed error: confFiles is empty");
        return paramArrayOfaogf;
      }
    }
    wsv.d("QVipConfigProcessor", getClass().getName() + ".parsed content count=" + paramArrayOfaogf.length);
    return a(paramArrayOfaogf);
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
 * Qualified Name:     aopw
 * JD-Core Version:    0.7.0.1
 */