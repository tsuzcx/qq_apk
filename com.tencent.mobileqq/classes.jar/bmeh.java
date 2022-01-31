import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class bmeh<K, V>
  implements bmei<K, V>, Iterator<Map.Entry<K, V>>
{
  bmef<K, V> a;
  bmef<K, V> b;
  
  bmeh(bmef<K, V> parambmef1, bmef<K, V> parambmef2)
  {
    this.a = parambmef2;
    this.b = parambmef1;
  }
  
  private bmef<K, V> a()
  {
    if ((this.b == this.a) || (this.a == null)) {
      return null;
    }
    return a(this.b);
  }
  
  abstract bmef<K, V> a(bmef<K, V> parambmef);
  
  public Map.Entry<K, V> a()
  {
    bmef localbmef = this.b;
    this.b = a();
    return localbmef;
  }
  
  public void a(@NonNull bmef<K, V> parambmef)
  {
    if ((this.a == parambmef) && (parambmef == this.b))
    {
      this.b = null;
      this.a = null;
    }
    if (this.a == parambmef) {
      this.a = b(this.a);
    }
    if (this.b == parambmef) {
      this.b = a();
    }
  }
  
  abstract bmef<K, V> b(bmef<K, V> parambmef);
  
  public boolean hasNext()
  {
    return this.b != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmeh
 * JD-Core Version:    0.7.0.1
 */