import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class arjj<T>
  extends aqwt<T>
{
  @NonNull
  public abstract T a();
  
  @NonNull
  public abstract T a(@NonNull aqxa[] paramArrayOfaqxa);
  
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
        zdl.a(getClass().getName() + ".migrateOldOrDefaultContent return null!! type=" + paramInt, new Object[0]);
        localObject2 = a();
      }
      return localObject2;
      if (paramInt == 0) {
        localObject1 = a();
      } else {
        zdl.a(getClass().getName() + ".migrateOldOrDefaultContent illegal type: " + paramInt, new Object[0]);
      }
    }
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public T onParsed(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0))
    {
      ykq.e("QVipConfigProcessor", getClass().getName() + ".onParsed error: confFiles is empty");
      paramArrayOfaqxa = a();
      if (paramArrayOfaqxa != null) {}
      for (boolean bool = true;; bool = false)
      {
        zdl.a(bool, getClass().getName() + ".onParsed error: confFiles is empty");
        return paramArrayOfaqxa;
      }
    }
    ykq.d("QVipConfigProcessor", getClass().getName() + ".parsed content count=" + paramArrayOfaqxa.length);
    return a(paramArrayOfaqxa);
  }
  
  public void onReqFailed(int paramInt)
  {
    ykq.e("QVipConfigProcessor", getClass().getName() + ".onReqFailed: " + paramInt);
  }
  
  public void onUpdate(T paramT)
  {
    ykq.d("QVipConfigProcessor", getClass().getName() + ".onUpdate: " + paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjj
 * JD-Core Version:    0.7.0.1
 */