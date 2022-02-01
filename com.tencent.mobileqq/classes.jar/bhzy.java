import java.lang.ref.WeakReference;

class bhzy<E>
  extends WeakReference<bhzw<E>>
  implements bhzw<E>
{
  public bhzy(bhzw<E> parambhzw)
  {
    super(parambhzw);
  }
  
  public void a(E paramE, Object paramObject)
  {
    bhzw localbhzw = (bhzw)get();
    if (localbhzw != null) {
      localbhzw.a(paramE, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhzy
 * JD-Core Version:    0.7.0.1
 */