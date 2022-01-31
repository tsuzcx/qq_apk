import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.widget.RecentDynamicAvatarView;

public class aybk
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public final TextView a;
  private aybi jdField_a_of_type_Aybi;
  public RecentDynamicAvatarView a;
  
  public aybk(aybh paramaybh, View paramView, aybi paramaybi)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131367808));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371142));
    this.jdField_a_of_type_Aybi = paramaybi;
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Aybi != null) && (aybh.a(this.jdField_a_of_type_Aybh))) {
      this.jdField_a_of_type_Aybi.a(paramView, getAdapterPosition() - 1);
    }
    while (this.jdField_a_of_type_Aybi == null) {
      return;
    }
    this.jdField_a_of_type_Aybi.a(paramView, getAdapterPosition());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybk
 * JD-Core Version:    0.7.0.1
 */