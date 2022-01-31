import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment;

public class aqam
  extends RecyclerView.AdapterDataObserver
{
  public aqam(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_Aqay.a() == 0)
    {
      this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeItemDecoration(this.a.jdField_a_of_type_Aqaz);
      return;
    }
    this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeItemDecoration(this.a.jdField_a_of_type_Aqaz);
    this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(this.a.jdField_a_of_type_Aqaz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqam
 * JD-Core Version:    0.7.0.1
 */