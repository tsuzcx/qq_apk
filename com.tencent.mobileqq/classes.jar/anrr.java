import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment;

public class anrr
  extends RecyclerView.AdapterDataObserver
{
  public anrr(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_Ansi.a() == 0)
    {
      this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeItemDecoration(this.a.jdField_a_of_type_Ansj);
      return;
    }
    this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeItemDecoration(this.a.jdField_a_of_type_Ansj);
    this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(this.a.jdField_a_of_type_Ansj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anrr
 * JD-Core Version:    0.7.0.1
 */