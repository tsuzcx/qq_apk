import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

public class bhvz
  implements bhwb<K, V>, Iterator<Map.Entry<K, V>>
{
  private bhvy<K, V> jdField_a_of_type_Bhvy;
  private boolean jdField_a_of_type_Boolean = true;
  
  public bhvz(bhvv parambhvv) {}
  
  public Map.Entry<K, V> a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bhvy = bhvv.a(this.jdField_a_of_type_Bhvv);
      return this.jdField_a_of_type_Bhvy;
    }
    if (this.jdField_a_of_type_Bhvy != null) {}
    for (bhvy localbhvy = this.jdField_a_of_type_Bhvy.jdField_a_of_type_Bhvy;; localbhvy = null)
    {
      this.jdField_a_of_type_Bhvy = localbhvy;
      break;
    }
  }
  
  public void a(@NonNull bhvy<K, V> parambhvy)
  {
    if (parambhvy == this.jdField_a_of_type_Bhvy)
    {
      this.jdField_a_of_type_Bhvy = this.jdField_a_of_type_Bhvy.b;
      if (this.jdField_a_of_type_Bhvy != null) {
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
      if (bhvv.a(this.jdField_a_of_type_Bhvv) == null) {}
    }
    while ((this.jdField_a_of_type_Bhvy != null) && (this.jdField_a_of_type_Bhvy.jdField_a_of_type_Bhvy != null))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhvz
 * JD-Core Version:    0.7.0.1
 */