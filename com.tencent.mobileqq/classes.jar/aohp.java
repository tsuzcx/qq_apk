import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;
import com.tencent.widget.SingleLineTextView;

public class aohp
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  View jdField_a_of_type_AndroidViewView;
  private aoiy jdField_a_of_type_Aoiy;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  SingleLineTextView jdField_a_of_type_ComTencentWidgetSingleLineTextView;
  SingleLineTextView b;
  
  public aohp(ExtendFriendGroupFragment paramExtendFriendGroupFragment, ViewGroup paramViewGroup, aoiy paramaoiy)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_Aoiy = paramaoiy;
    this.jdField_a_of_type_AndroidViewView = paramViewGroup;
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131367376));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131377350));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramViewGroup.findViewById(2131368882));
    this.b = ((SingleLineTextView)paramViewGroup.findViewById(2131365017));
    paramViewGroup = new aoho(paramExtendFriendGroupFragment, null);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(paramViewGroup);
    paramViewGroup = new StaggeredGridLayoutManager(1, 0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramViewGroup);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnTouchListener(new aohq(this, paramExtendFriendGroupFragment));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aohr(this, paramExtendFriendGroupFragment));
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aohp
 * JD-Core Version:    0.7.0.1
 */