import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

public class bjol
  implements bjon<K, V>, Iterator<Map.Entry<K, V>>
{
  private bjok<K, V> jdField_a_of_type_Bjok;
  private boolean jdField_a_of_type_Boolean = true;
  
  public bjol(bjoh parambjoh) {}
  
  public Map.Entry<K, V> a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bjok = bjoh.a(this.jdField_a_of_type_Bjoh);
      return this.jdField_a_of_type_Bjok;
    }
    if (this.jdField_a_of_type_Bjok != null) {}
    for (bjok localbjok = this.jdField_a_of_type_Bjok.jdField_a_of_type_Bjok;; localbjok = null)
    {
      this.jdField_a_of_type_Bjok = localbjok;
      break;
    }
  }
  
  public void a(@NonNull bjok<K, V> parambjok)
  {
    if (parambjok == this.jdField_a_of_type_Bjok)
    {
      this.jdField_a_of_type_Bjok = this.jdField_a_of_type_Bjok.b;
      if (this.jdField_a_of_type_Bjok != null) {
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
      if (bjoh.a(this.jdField_a_of_type_Bjoh) == null) {}
    }
    while ((this.jdField_a_of_type_Bjok != null) && (this.jdField_a_of_type_Bjok.jdField_a_of_type_Bjok != null))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjol
 * JD-Core Version:    0.7.0.1
 */