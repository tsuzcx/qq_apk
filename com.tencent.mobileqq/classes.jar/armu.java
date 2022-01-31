import java.lang.ref.WeakReference;

public abstract class armu<T>
{
  public WeakReference<T> a;
  
  public armu(T paramT)
  {
    this.a = new WeakReference(paramT);
  }
  
  public abstract void a(T paramT, boolean paramBoolean, armr paramarmr);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     armu
 * JD-Core Version:    0.7.0.1
 */