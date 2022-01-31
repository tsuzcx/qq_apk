import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class amie<T>
  extends alzl<T>
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
        vkw.a(getClass().getName() + ".migrateOldOrDefaultContent return null!! type=" + paramInt, new Object[0]);
        localObject2 = b();
      }
      return localObject2;
      if (paramInt == 0) {
        localObject1 = b();
      } else {
        vkw.a(getClass().getName() + ".migrateOldOrDefaultContent illegal type: " + paramInt, new Object[0]);
      }
    }
  }
  
  @NonNull
  public abstract T a(@NonNull alzs[] paramArrayOfalzs);
  
  public void a(int paramInt)
  {
    urk.e("QVipConfigProcessor", getClass().getName() + ".onReqFailed: " + paramInt);
  }
  
  public void a(T paramT)
  {
    urk.d("QVipConfigProcessor", getClass().getName() + ".onUpdate: " + paramT);
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
  public T b(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0))
    {
      urk.e("QVipConfigProcessor", getClass().getName() + ".onParsed error: confFiles is empty");
      paramArrayOfalzs = b();
      if (paramArrayOfalzs != null) {}
      for (boolean bool = true;; bool = false)
      {
        vkw.a(bool, getClass().getName() + ".onParsed error: confFiles is empty");
        return paramArrayOfalzs;
      }
    }
    urk.d("QVipConfigProcessor", getClass().getName() + ".parsed content count=" + paramArrayOfalzs.length);
    return a(paramArrayOfalzs);
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
 * Qualified Name:     amie
 * JD-Core Version:    0.7.0.1
 */