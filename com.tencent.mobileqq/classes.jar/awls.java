import java.lang.ref.WeakReference;

public abstract class awls<T>
{
  public WeakReference<T> a;
  
  public awls(T paramT)
  {
    this.a = new WeakReference(paramT);
  }
  
  public abstract void a(T paramT, boolean paramBoolean, awlp paramawlp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awls
 * JD-Core Version:    0.7.0.1
 */