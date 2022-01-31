import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.Map.Entry;

public class bjnu
  implements bjnw<K, V>, Iterator<Map.Entry<K, V>>
{
  private bjnt<K, V> jdField_a_of_type_Bjnt;
  private boolean jdField_a_of_type_Boolean = true;
  
  public bjnu(bjnq parambjnq) {}
  
  public Map.Entry<K, V> a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bjnt = bjnq.a(this.jdField_a_of_type_Bjnq);
      return this.jdField_a_of_type_Bjnt;
    }
    if (this.jdField_a_of_type_Bjnt != null) {}
    for (bjnt localbjnt = this.jdField_a_of_type_Bjnt.jdField_a_of_type_Bjnt;; localbjnt = null)
    {
      this.jdField_a_of_type_Bjnt = localbjnt;
      break;
    }
  }
  
  public void a(@NonNull bjnt<K, V> parambjnt)
  {
    if (parambjnt == this.jdField_a_of_type_Bjnt)
    {
      this.jdField_a_of_type_Bjnt = this.jdField_a_of_type_Bjnt.b;
      if (this.jdField_a_of_type_Bjnt != null) {
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
      if (bjnq.a(this.jdField_a_of_type_Bjnq) == null) {}
    }
    while ((this.jdField_a_of_type_Bjnt != null) && (this.jdField_a_of_type_Bjnt.jdField_a_of_type_Bjnt != null))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnu
 * JD-Core Version:    0.7.0.1
 */