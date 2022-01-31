import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class aupb
  extends ampb<aupd>
{
  public int a()
  {
    return c();
  }
  
  @NonNull
  public aupd a(int paramInt)
  {
    return new aupd();
  }
  
  @Nullable
  public aupd a(ampi[] paramArrayOfampi)
  {
    aupd localaupd = new aupd();
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0) && (paramArrayOfampi[0] != null)) {
      aupd.a(localaupd, paramArrayOfampi[0].a);
    }
    return localaupd;
  }
  
  public Class<aupd> a()
  {
    return aupd.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aupd paramaupd) {}
  
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
 * Qualified Name:     aupb
 * JD-Core Version:    0.7.0.1
 */