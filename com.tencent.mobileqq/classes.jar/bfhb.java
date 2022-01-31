import android.text.Editable;
import com.tencent.open.agent.datamodel.Friend;
import java.util.Comparator;

class bfhb
  implements Comparator<Friend>
{
  bfhb(bfha parambfha, Editable paramEditable) {}
  
  public int a(Friend paramFriend1, Friend paramFriend2)
  {
    return this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramFriend2) - this.jdField_a_of_type_AndroidTextEditable.getSpanStart(paramFriend1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfhb
 * JD-Core Version:    0.7.0.1
 */