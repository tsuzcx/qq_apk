import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class biho<K, V>
  extends WeakReference<V>
{
  K a;
  
  public biho(K paramK, V paramV, ReferenceQueue<V> paramReferenceQueue)
  {
    super(paramV, paramReferenceQueue);
    this.a = paramK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biho
 * JD-Core Version:    0.7.0.1
 */