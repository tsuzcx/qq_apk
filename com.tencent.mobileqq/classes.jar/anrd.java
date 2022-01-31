import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;
import com.tencent.widget.RoundBGTextView;

public class anrd
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public RoundBGTextView a;
  
  public anrd(ExtendFriendGroupFragment paramExtendFriendGroupFragment, ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_ComTencentWidgetRoundBGTextView = ((RoundBGTextView)paramViewGroup.findViewById(2131303206));
    this.jdField_a_of_type_ComTencentWidgetRoundBGTextView.setRoundCornerSize(2);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anrd
 * JD-Core Version:    0.7.0.1
 */