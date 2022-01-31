import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.widget.RecentDynamicAvatarView;

public class ayft
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public final TextView a;
  private ayfr jdField_a_of_type_Ayfr;
  public RecentDynamicAvatarView a;
  
  public ayft(ayfq paramayfq, View paramView, ayfr paramayfr)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131367819));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371161));
    this.jdField_a_of_type_Ayfr = paramayfr;
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Ayfr != null) && (ayfq.a(this.jdField_a_of_type_Ayfq))) {
      this.jdField_a_of_type_Ayfr.a(paramView, getAdapterPosition() - 1);
    }
    while (this.jdField_a_of_type_Ayfr == null) {
      return;
    }
    this.jdField_a_of_type_Ayfr.a(paramView, getAdapterPosition());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayft
 * JD-Core Version:    0.7.0.1
 */