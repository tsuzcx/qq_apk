import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class auph
  extends ampa<aupl>
{
  public int a()
  {
    return c();
  }
  
  @NonNull
  public aupl a(int paramInt)
  {
    return new aupl();
  }
  
  @Nullable
  public aupl a(amph[] paramArrayOfamph)
  {
    aupl localaupl = new aupl();
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null)) {
      aupl.a(localaupl, paramArrayOfamph[0].a);
    }
    return localaupl;
  }
  
  public Class<aupl> a()
  {
    return aupl.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aupl paramaupl) {}
  
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
 * Qualified Name:     auph
 * JD-Core Version:    0.7.0.1
 */