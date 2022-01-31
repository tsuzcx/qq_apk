import java.lang.ref.WeakReference;

class bdqi<E>
  extends WeakReference<bdqg<E>>
  implements bdqg<E>
{
  public bdqi(bdqg<E> parambdqg)
  {
    super(parambdqg);
  }
  
  public void a(E paramE, Object paramObject)
  {
    bdqg localbdqg = (bdqg)get();
    if (localbdqg != null) {
      localbdqg.a(paramE, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqi
 * JD-Core Version:    0.7.0.1
 */