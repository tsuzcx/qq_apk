import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;

public class asqf
  extends RecyclerView.AdapterDataObserver
{
  public asqf(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_Asqk.a() == 0)
    {
      this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeItemDecoration(this.a.jdField_a_of_type_Asql);
      return;
    }
    this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeItemDecoration(this.a.jdField_a_of_type_Asql);
    this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(this.a.jdField_a_of_type_Asql);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqf
 * JD-Core Version:    0.7.0.1
 */