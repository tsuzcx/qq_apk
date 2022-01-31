import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class bhwa<K, V>
  implements bhwb<K, V>, Iterator<Map.Entry<K, V>>
{
  bhvy<K, V> a;
  bhvy<K, V> b;
  
  bhwa(bhvy<K, V> parambhvy1, bhvy<K, V> parambhvy2)
  {
    this.a = parambhvy2;
    this.b = parambhvy1;
  }
  
  private bhvy<K, V> a()
  {
    if ((this.b == this.a) || (this.a == null)) {
      return null;
    }
    return a(this.b);
  }
  
  abstract bhvy<K, V> a(bhvy<K, V> parambhvy);
  
  public Map.Entry<K, V> a()
  {
    bhvy localbhvy = this.b;
    this.b = a();
    return localbhvy;
  }
  
  public void a(@NonNull bhvy<K, V> parambhvy)
  {
    if ((this.a == parambhvy) && (parambhvy == this.b))
    {
      this.b = null;
      this.a = null;
    }
    if (this.a == parambhvy) {
      this.a = b(this.a);
    }
    if (this.b == parambhvy) {
      this.b = a();
    }
  }
  
  abstract bhvy<K, V> b(bhvy<K, V> parambhvy);
  
  public boolean hasNext()
  {
    return this.b != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhwa
 * JD-Core Version:    0.7.0.1
 */