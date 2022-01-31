import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map.Entry;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bhvu<K, V>
  extends bhvv<K, V>
{
  private HashMap<K, bhvy<K, V>> a = new HashMap();
  
  protected bhvy<K, V> a(K paramK)
  {
    return (bhvy)this.a.get(paramK);
  }
  
  public V a(@NonNull K paramK)
  {
    Object localObject = super.a(paramK);
    this.a.remove(paramK);
    return localObject;
  }
  
  public V a(@NonNull K paramK, @NonNull V paramV)
  {
    bhvy localbhvy = a(paramK);
    if (localbhvy != null) {
      return localbhvy.jdField_b_of_type_JavaLangObject;
    }
    this.a.put(paramK, a(paramK, paramV));
    return null;
  }
  
  public Map.Entry<K, V> a(K paramK)
  {
    if (a(paramK)) {
      return ((bhvy)this.a.get(paramK)).jdField_b_of_type_Bhvy;
    }
    return null;
  }
  
  public boolean a(K paramK)
  {
    return this.a.containsKey(paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhvu
 * JD-Core Version:    0.7.0.1
 */