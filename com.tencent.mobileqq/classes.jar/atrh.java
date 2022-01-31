import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class atrh
  extends alzl<atrl>
{
  public int a()
  {
    return c();
  }
  
  @NonNull
  public atrl a(int paramInt)
  {
    return new atrl();
  }
  
  @Nullable
  public atrl a(alzs[] paramArrayOfalzs)
  {
    atrl localatrl = new atrl();
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0) && (paramArrayOfalzs[0] != null)) {
      atrl.a(localatrl, paramArrayOfalzs[0].a);
    }
    return localatrl;
  }
  
  public Class<atrl> a()
  {
    return atrl.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(atrl paramatrl) {}
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  protected abstract int c();
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atrh
 * JD-Core Version:    0.7.0.1
 */