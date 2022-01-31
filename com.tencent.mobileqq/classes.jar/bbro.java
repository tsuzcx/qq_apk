import java.lang.ref.WeakReference;

class bbro<E>
  extends WeakReference<bbrm<E>>
  implements bbrm<E>
{
  public bbro(bbrm<E> parambbrm)
  {
    super(parambbrm);
  }
  
  public void a(E paramE, Object paramObject)
  {
    bbrm localbbrm = (bbrm)get();
    if (localbbrm != null) {
      localbbrm.a(paramE, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbro
 * JD-Core Version:    0.7.0.1
 */