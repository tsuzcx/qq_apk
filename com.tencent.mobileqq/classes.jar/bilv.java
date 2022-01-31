import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class bilv<K, V>
  extends WeakReference<V>
{
  K a;
  
  public bilv(K paramK, V paramV, ReferenceQueue<V> paramReferenceQueue)
  {
    super(paramV, paramReferenceQueue);
    this.a = paramK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bilv
 * JD-Core Version:    0.7.0.1
 */