import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class atrd
  extends alzl<atrf>
{
  public int a()
  {
    return c();
  }
  
  @NonNull
  public atrf a(int paramInt)
  {
    return new atrf();
  }
  
  @Nullable
  public atrf a(alzs[] paramArrayOfalzs)
  {
    atrf localatrf = new atrf();
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0) && (paramArrayOfalzs[0] != null)) {
      atrf.a(localatrf, paramArrayOfalzs[0].a);
    }
    return localatrf;
  }
  
  public Class<atrf> a()
  {
    return atrf.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(atrf paramatrf) {}
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  abstract int c();
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atrd
 * JD-Core Version:    0.7.0.1
 */