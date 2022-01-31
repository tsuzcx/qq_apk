import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map.Entry;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class blzp<K, V>
  extends blzq<K, V>
{
  private HashMap<K, blzt<K, V>> a = new HashMap();
  
  protected blzt<K, V> a(K paramK)
  {
    return (blzt)this.a.get(paramK);
  }
  
  public V a(@NonNull K paramK)
  {
    Object localObject = super.a(paramK);
    this.a.remove(paramK);
    return localObject;
  }
  
  public V a(@NonNull K paramK, @NonNull V paramV)
  {
    blzt localblzt = a(paramK);
    if (localblzt != null) {
      return localblzt.jdField_b_of_type_JavaLangObject;
    }
    this.a.put(paramK, a(paramK, paramV));
    return null;
  }
  
  public Map.Entry<K, V> a(K paramK)
  {
    if (a(paramK)) {
      return ((blzt)this.a.get(paramK)).jdField_b_of_type_Blzt;
    }
    return null;
  }
  
  public boolean a(K paramK)
  {
    return this.a.containsKey(paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzp
 * JD-Core Version:    0.7.0.1
 */