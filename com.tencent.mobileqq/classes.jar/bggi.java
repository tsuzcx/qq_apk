import java.lang.ref.WeakReference;

class bggi<E>
  extends WeakReference<bggg<E>>
  implements bggg<E>
{
  public bggi(bggg<E> parambggg)
  {
    super(parambggg);
  }
  
  public void a(E paramE, Object paramObject)
  {
    bggg localbggg = (bggg)get();
    if (localbggg != null) {
      localbggg.a(paramE, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggi
 * JD-Core Version:    0.7.0.1
 */