import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class aqgc<T>
  extends aptq<T>
{
  @NonNull
  public abstract T a();
  
  @NonNull
  public abstract T a(@NonNull aptx[] paramArrayOfaptx);
  
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
        yos.a(getClass().getName() + ".migrateOldOrDefaultContent return null!! type=" + paramInt, new Object[0]);
        localObject2 = a();
      }
      return localObject2;
      if (paramInt == 0) {
        localObject1 = a();
      } else {
        yos.a(getClass().getName() + ".migrateOldOrDefaultContent illegal type: " + paramInt, new Object[0]);
      }
    }
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public T onParsed(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0))
    {
      xvv.e("QVipConfigProcessor", getClass().getName() + ".onParsed error: confFiles is empty");
      paramArrayOfaptx = a();
      if (paramArrayOfaptx != null) {}
      for (boolean bool = true;; bool = false)
      {
        yos.a(bool, getClass().getName() + ".onParsed error: confFiles is empty");
        return paramArrayOfaptx;
      }
    }
    xvv.d("QVipConfigProcessor", getClass().getName() + ".parsed content count=" + paramArrayOfaptx.length);
    return a(paramArrayOfaptx);
  }
  
  public void onReqFailed(int paramInt)
  {
    xvv.e("QVipConfigProcessor", getClass().getName() + ".onReqFailed: " + paramInt);
  }
  
  public void onUpdate(T paramT)
  {
    xvv.d("QVipConfigProcessor", getClass().getName() + ".onUpdate: " + paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqgc
 * JD-Core Version:    0.7.0.1
 */