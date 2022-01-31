import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

public class bmeg
  implements bmei<K, V>, Iterator<Map.Entry<K, V>>
{
  private bmef<K, V> jdField_a_of_type_Bmef;
  private boolean jdField_a_of_type_Boolean = true;
  
  public bmeg(bmec parambmec) {}
  
  public Map.Entry<K, V> a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bmef = bmec.a(this.jdField_a_of_type_Bmec);
      return this.jdField_a_of_type_Bmef;
    }
    if (this.jdField_a_of_type_Bmef != null) {}
    for (bmef localbmef = this.jdField_a_of_type_Bmef.jdField_a_of_type_Bmef;; localbmef = null)
    {
      this.jdField_a_of_type_Bmef = localbmef;
      break;
    }
  }
  
  public void a(@NonNull bmef<K, V> parambmef)
  {
    if (parambmef == this.jdField_a_of_type_Bmef)
    {
      this.jdField_a_of_type_Bmef = this.jdField_a_of_type_Bmef.b;
      if (this.jdField_a_of_type_Bmef != null) {
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
      if (bmec.a(this.jdField_a_of_type_Bmec) == null) {}
    }
    while ((this.jdField_a_of_type_Bmef != null) && (this.jdField_a_of_type_Bmef.jdField_a_of_type_Bmef != null))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmeg
 * JD-Core Version:    0.7.0.1
 */