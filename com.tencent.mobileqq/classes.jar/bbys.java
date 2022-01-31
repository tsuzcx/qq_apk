import android.view.View;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;
import com.tencent.widget.AdapterView;
import java.util.Set;

public class bbys
  implements bhqp
{
  public bbys(SelectReciteParagraphFragment paramSelectReciteParagraphFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) {
      this.a.jdField_a_of_type_JavaUtilSet.remove(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Bbyu.notifyDataSetChanged();
      this.a.e();
      return;
      this.a.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbys
 * JD-Core Version:    0.7.0.1
 */