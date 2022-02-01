import java.lang.ref.WeakReference;

class bhpc<E>
  extends WeakReference<bhpa<E>>
  implements bhpa<E>
{
  public bhpc(bhpa<E> parambhpa)
  {
    super(parambhpa);
  }
  
  public void a(E paramE, Object paramObject)
  {
    bhpa localbhpa = (bhpa)get();
    if (localbhpa != null) {
      localbhpa.a(paramE, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhpc
 * JD-Core Version:    0.7.0.1
 */