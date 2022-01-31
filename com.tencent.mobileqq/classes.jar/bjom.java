import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class bjom<K, V>
  implements bjon<K, V>, Iterator<Map.Entry<K, V>>
{
  bjok<K, V> a;
  bjok<K, V> b;
  
  bjom(bjok<K, V> parambjok1, bjok<K, V> parambjok2)
  {
    this.a = parambjok2;
    this.b = parambjok1;
  }
  
  private bjok<K, V> a()
  {
    if ((this.b == this.a) || (this.a == null)) {
      return null;
    }
    return a(this.b);
  }
  
  abstract bjok<K, V> a(bjok<K, V> parambjok);
  
  public Map.Entry<K, V> a()
  {
    bjok localbjok = this.b;
    this.b = a();
    return localbjok;
  }
  
  public void a(@NonNull bjok<K, V> parambjok)
  {
    if ((this.a == parambjok) && (parambjok == this.b))
    {
      this.b = null;
      this.a = null;
    }
    if (this.a == parambjok) {
      this.a = b(this.a);
    }
    if (this.b == parambjok) {
      this.b = a();
    }
  }
  
  abstract bjok<K, V> b(bjok<K, V> parambjok);
  
  public boolean hasNext()
  {
    return this.b != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjom
 * JD-Core Version:    0.7.0.1
 */