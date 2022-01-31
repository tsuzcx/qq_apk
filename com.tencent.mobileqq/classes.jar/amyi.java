import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class amyi<T>
  extends ampb<T>
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
        vxs.a(getClass().getName() + ".migrateOldOrDefaultContent return null!! type=" + paramInt, new Object[0]);
        localObject2 = b();
      }
      return localObject2;
      if (paramInt == 0) {
        localObject1 = b();
      } else {
        vxs.a(getClass().getName() + ".migrateOldOrDefaultContent illegal type: " + paramInt, new Object[0]);
      }
    }
  }
  
  @NonNull
  public abstract T a(@NonNull ampi[] paramArrayOfampi);
  
  public void a(int paramInt)
  {
    veg.e("QVipConfigProcessor", getClass().getName() + ".onReqFailed: " + paramInt);
  }
  
  public void a(T paramT)
  {
    veg.d("QVipConfigProcessor", getClass().getName() + ".onUpdate: " + paramT);
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
  public T b(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0))
    {
      veg.e("QVipConfigProcessor", getClass().getName() + ".onParsed error: confFiles is empty");
      paramArrayOfampi = b();
      if (paramArrayOfampi != null) {}
      for (boolean bool = true;; bool = false)
      {
        vxs.a(bool, getClass().getName() + ".onParsed error: confFiles is empty");
        return paramArrayOfampi;
      }
    }
    veg.d("QVipConfigProcessor", getClass().getName() + ".parsed content count=" + paramArrayOfampi.length);
    return a(paramArrayOfampi);
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
 * Qualified Name:     amyi
 * JD-Core Version:    0.7.0.1
 */