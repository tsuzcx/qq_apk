import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class blpr<K, V>
  extends WeakReference<V>
{
  K a;
  
  public blpr(K paramK, V paramV, ReferenceQueue<V> paramReferenceQueue)
  {
    super(paramV, paramReferenceQueue);
    this.a = paramK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpr
 * JD-Core Version:    0.7.0.1
 */