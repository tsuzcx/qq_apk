import java.lang.ref.WeakReference;

class bdur<E>
  extends WeakReference<bdup<E>>
  implements bdup<E>
{
  public bdur(bdup<E> parambdup)
  {
    super(parambdup);
  }
  
  public void a(E paramE, Object paramObject)
  {
    bdup localbdup = (bdup)get();
    if (localbdup != null) {
      localbdup.a(paramE, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdur
 * JD-Core Version:    0.7.0.1
 */