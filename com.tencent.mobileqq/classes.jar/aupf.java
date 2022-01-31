import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class aupf
  extends ampb<aupj>
{
  public int a()
  {
    return c();
  }
  
  @NonNull
  public aupj a(int paramInt)
  {
    return new aupj();
  }
  
  @Nullable
  public aupj a(ampi[] paramArrayOfampi)
  {
    aupj localaupj = new aupj();
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0) && (paramArrayOfampi[0] != null)) {
      aupj.a(localaupj, paramArrayOfampi[0].a);
    }
    return localaupj;
  }
  
  public Class<aupj> a()
  {
    return aupj.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aupj paramaupj) {}
  
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
 * Qualified Name:     aupf
 * JD-Core Version:    0.7.0.1
 */