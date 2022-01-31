import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class aupd
  extends ampa<aupf>
{
  public int a()
  {
    return c();
  }
  
  @NonNull
  public aupf a(int paramInt)
  {
    return new aupf();
  }
  
  @Nullable
  public aupf a(amph[] paramArrayOfamph)
  {
    aupf localaupf = new aupf();
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null)) {
      aupf.a(localaupf, paramArrayOfamph[0].a);
    }
    return localaupf;
  }
  
  public Class<aupf> a()
  {
    return aupf.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aupf paramaupf) {}
  
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
 * Qualified Name:     aupd
 * JD-Core Version:    0.7.0.1
 */