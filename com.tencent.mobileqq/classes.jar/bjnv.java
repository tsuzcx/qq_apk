import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class bjnv<K, V>
  implements bjnw<K, V>, Iterator<Map.Entry<K, V>>
{
  bjnt<K, V> a;
  bjnt<K, V> b;
  
  bjnv(bjnt<K, V> parambjnt1, bjnt<K, V> parambjnt2)
  {
    this.a = parambjnt2;
    this.b = parambjnt1;
  }
  
  private bjnt<K, V> a()
  {
    if ((this.b == this.a) || (this.a == null)) {
      return null;
    }
    return a(this.b);
  }
  
  abstract bjnt<K, V> a(bjnt<K, V> parambjnt);
  
  public Map.Entry<K, V> a()
  {
    bjnt localbjnt = this.b;
    this.b = a();
    return localbjnt;
  }
  
  public void a(@NonNull bjnt<K, V> parambjnt)
  {
    if ((this.a == parambjnt) && (parambjnt == this.b))
    {
      this.b = null;
      this.a = null;
    }
    if (this.a == parambjnt) {
      this.a = b(this.a);
    }
    if (this.b == parambjnt) {
      this.b = a();
    }
  }
  
  abstract bjnt<K, V> b(bjnt<K, V> parambjnt);
  
  public boolean hasNext()
  {
    return this.b != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnv
 * JD-Core Version:    0.7.0.1
 */