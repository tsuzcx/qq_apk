import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class amyp<T>
  extends ampa<T>
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
        vxp.a(getClass().getName() + ".migrateOldOrDefaultContent return null!! type=" + paramInt, new Object[0]);
        localObject2 = b();
      }
      return localObject2;
      if (paramInt == 0) {
        localObject1 = b();
      } else {
        vxp.a(getClass().getName() + ".migrateOldOrDefaultContent illegal type: " + paramInt, new Object[0]);
      }
    }
  }
  
  @NonNull
  public abstract T a(@NonNull amph[] paramArrayOfamph);
  
  public void a(int paramInt)
  {
    ved.e("QVipConfigProcessor", getClass().getName() + ".onReqFailed: " + paramInt);
  }
  
  public void a(T paramT)
  {
    ved.d("QVipConfigProcessor", getClass().getName() + ".onUpdate: " + paramT);
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
  public T b(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0))
    {
      ved.e("QVipConfigProcessor", getClass().getName() + ".onParsed error: confFiles is empty");
      paramArrayOfamph = b();
      if (paramArrayOfamph != null) {}
      for (boolean bool = true;; bool = false)
      {
        vxp.a(bool, getClass().getName() + ".onParsed error: confFiles is empty");
        return paramArrayOfamph;
      }
    }
    ved.d("QVipConfigProcessor", getClass().getName() + ".parsed content count=" + paramArrayOfamph.length);
    return a(paramArrayOfamph);
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
 * Qualified Name:     amyp
 * JD-Core Version:    0.7.0.1
 */