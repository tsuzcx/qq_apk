import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class aouf<T>
  extends aokh<T>
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
        xqq.a(getClass().getName() + ".migrateOldOrDefaultContent return null!! type=" + paramInt, new Object[0]);
        localObject2 = b();
      }
      return localObject2;
      if (paramInt == 0) {
        localObject1 = b();
      } else {
        xqq.a(getClass().getName() + ".migrateOldOrDefaultContent illegal type: " + paramInt, new Object[0]);
      }
    }
  }
  
  @NonNull
  public abstract T a(@NonNull aoko[] paramArrayOfaoko);
  
  public void a(int paramInt)
  {
    wxe.e("QVipConfigProcessor", getClass().getName() + ".onReqFailed: " + paramInt);
  }
  
  public void a(T paramT)
  {
    wxe.d("QVipConfigProcessor", getClass().getName() + ".onUpdate: " + paramT);
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
  public T b(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0))
    {
      wxe.e("QVipConfigProcessor", getClass().getName() + ".onParsed error: confFiles is empty");
      paramArrayOfaoko = b();
      if (paramArrayOfaoko != null) {}
      for (boolean bool = true;; bool = false)
      {
        xqq.a(bool, getClass().getName() + ".onParsed error: confFiles is empty");
        return paramArrayOfaoko;
      }
    }
    wxe.d("QVipConfigProcessor", getClass().getName() + ".parsed content count=" + paramArrayOfaoko.length);
    return a(paramArrayOfaoko);
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
 * Qualified Name:     aouf
 * JD-Core Version:    0.7.0.1
 */