import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;

public class aqfc
  extends RecyclerView.AdapterDataObserver
{
  public aqfc(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onChanged()
  {
    if (this.a.jdField_a_of_type_Aqfh.a() == 0)
    {
      this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeItemDecoration(this.a.jdField_a_of_type_Aqfi);
      return;
    }
    this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeItemDecoration(this.a.jdField_a_of_type_Aqfi);
    this.a.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(this.a.jdField_a_of_type_Aqfi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfc
 * JD-Core Version:    0.7.0.1
 */