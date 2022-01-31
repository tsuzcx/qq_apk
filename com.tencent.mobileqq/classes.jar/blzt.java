import android.support.annotation.NonNull;
import java.util.Map.Entry;

class blzt<K, V>
  implements Map.Entry<K, V>
{
  blzt<K, V> jdField_a_of_type_Blzt;
  @NonNull
  final K jdField_a_of_type_JavaLangObject;
  blzt<K, V> jdField_b_of_type_Blzt;
  @NonNull
  final V jdField_b_of_type_JavaLangObject;
  
  blzt(@NonNull K paramK, @NonNull V paramV)
  {
    this.a = paramK;
    this.b = paramV;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof blzt)) {
        return false;
      }
      paramObject = (blzt)paramObject;
    } while ((this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)));
    return false;
  }
  
  @NonNull
  public K getKey()
  {
    return this.a;
  }
  
  @NonNull
  public V getValue()
  {
    return this.b;
  }
  
  public V setValue(V paramV)
  {
    throw new UnsupportedOperationException("An entry modification is not supported");
  }
  
  public String toString()
  {
    return this.a + "=" + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzt
 * JD-Core Version:    0.7.0.1
 */