import java.lang.ref.WeakReference;

class bgzs<E>
  extends WeakReference<bgzq<E>>
  implements bgzq<E>
{
  public bgzs(bgzq<E> parambgzq)
  {
    super(parambgzq);
  }
  
  public void a(E paramE, Object paramObject)
  {
    bgzq localbgzq = (bgzq)get();
    if (localbgzq != null) {
      localbgzq.a(paramE, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgzs
 * JD-Core Version:    0.7.0.1
 */