import java.lang.ref.WeakReference;

public abstract class atzz<T>
{
  public WeakReference<T> a;
  
  public atzz(T paramT)
  {
    this.a = new WeakReference(paramT);
  }
  
  public abstract void a(T paramT, boolean paramBoolean, atzw paramatzw);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atzz
 * JD-Core Version:    0.7.0.1
 */