import java.lang.ref.WeakReference;

class bapd<E>
  extends WeakReference<bapb<E>>
  implements bapb<E>
{
  public bapd(bapb<E> parambapb)
  {
    super(parambapb);
  }
  
  public void a(E paramE, Object paramObject)
  {
    bapb localbapb = (bapb)get();
    if (localbapb != null) {
      localbapb.a(paramE, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bapd
 * JD-Core Version:    0.7.0.1
 */