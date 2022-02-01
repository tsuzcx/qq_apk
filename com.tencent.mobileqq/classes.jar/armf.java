import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class armf<T>
  extends arac<T>
{
  @NonNull
  public abstract T a();
  
  @NonNull
  public abstract T a(@NonNull araj[] paramArrayOfaraj);
  
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
        znw.a(getClass().getName() + ".migrateOldOrDefaultContent return null!! type=" + paramInt, new Object[0]);
        localObject2 = a();
      }
      return localObject2;
      if (paramInt == 0) {
        localObject1 = a();
      } else {
        znw.a(getClass().getName() + ".migrateOldOrDefaultContent illegal type: " + paramInt, new Object[0]);
      }
    }
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public T onParsed(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0))
    {
      yuk.e("QVipConfigProcessor", getClass().getName() + ".onParsed error: confFiles is empty");
      paramArrayOfaraj = a();
      if (paramArrayOfaraj != null) {}
      for (boolean bool = true;; bool = false)
      {
        znw.a(bool, getClass().getName() + ".onParsed error: confFiles is empty");
        return paramArrayOfaraj;
      }
    }
    yuk.d("QVipConfigProcessor", getClass().getName() + ".parsed content count=" + paramArrayOfaraj.length);
    return a(paramArrayOfaraj);
  }
  
  public void onReqFailed(int paramInt)
  {
    yuk.e("QVipConfigProcessor", getClass().getName() + ".onReqFailed: " + paramInt);
  }
  
  public void onUpdate(T paramT)
  {
    yuk.d("QVipConfigProcessor", getClass().getName() + ".onUpdate: " + paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armf
 * JD-Core Version:    0.7.0.1
 */