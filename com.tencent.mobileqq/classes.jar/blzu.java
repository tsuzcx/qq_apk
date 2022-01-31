import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

public class blzu
  implements blzw<K, V>, Iterator<Map.Entry<K, V>>
{
  private blzt<K, V> jdField_a_of_type_Blzt;
  private boolean jdField_a_of_type_Boolean = true;
  
  public blzu(blzq paramblzq) {}
  
  public Map.Entry<K, V> a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Blzt = blzq.a(this.jdField_a_of_type_Blzq);
      return this.jdField_a_of_type_Blzt;
    }
    if (this.jdField_a_of_type_Blzt != null) {}
    for (blzt localblzt = this.jdField_a_of_type_Blzt.jdField_a_of_type_Blzt;; localblzt = null)
    {
      this.jdField_a_of_type_Blzt = localblzt;
      break;
    }
  }
  
  public void a(@NonNull blzt<K, V> paramblzt)
  {
    if (paramblzt == this.jdField_a_of_type_Blzt)
    {
      this.jdField_a_of_type_Blzt = this.jdField_a_of_type_Blzt.b;
      if (this.jdField_a_of_type_Blzt != null) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public boolean hasNext()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (blzq.a(this.jdField_a_of_type_Blzq) == null) {}
    }
    while ((this.jdField_a_of_type_Blzt != null) && (this.jdField_a_of_type_Blzt.jdField_a_of_type_Blzt != null))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzu
 * JD-Core Version:    0.7.0.1
 */