import java.lang.ref.WeakReference;

public abstract class avrr<T>
{
  public WeakReference<T> a;
  
  public avrr(T paramT)
  {
    this.a = new WeakReference(paramT);
  }
  
  public abstract void a(T paramT, boolean paramBoolean, avro paramavro);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrr
 * JD-Core Version:    0.7.0.1
 */