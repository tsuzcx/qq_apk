import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class blzv<K, V>
  implements blzw<K, V>, Iterator<Map.Entry<K, V>>
{
  blzt<K, V> a;
  blzt<K, V> b;
  
  blzv(blzt<K, V> paramblzt1, blzt<K, V> paramblzt2)
  {
    this.a = paramblzt2;
    this.b = paramblzt1;
  }
  
  private blzt<K, V> a()
  {
    if ((this.b == this.a) || (this.a == null)) {
      return null;
    }
    return a(this.b);
  }
  
  abstract blzt<K, V> a(blzt<K, V> paramblzt);
  
  public Map.Entry<K, V> a()
  {
    blzt localblzt = this.b;
    this.b = a();
    return localblzt;
  }
  
  public void a(@NonNull blzt<K, V> paramblzt)
  {
    if ((this.a == paramblzt) && (paramblzt == this.b))
    {
      this.b = null;
      this.a = null;
    }
    if (this.a == paramblzt) {
      this.a = b(this.a);
    }
    if (this.b == paramblzt) {
      this.b = a();
    }
  }
  
  abstract blzt<K, V> b(blzt<K, V> paramblzt);
  
  public boolean hasNext()
  {
    return this.b != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzv
 * JD-Core Version:    0.7.0.1
 */