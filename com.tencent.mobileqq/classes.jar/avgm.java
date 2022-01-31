import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.widget.RecentDynamicAvatarView;

public class avgm
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public final TextView a;
  private avgk jdField_a_of_type_Avgk;
  public RecentDynamicAvatarView a;
  
  public avgm(avgj paramavgj, View paramView, avgk paramavgk)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131302061));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305159));
    this.jdField_a_of_type_Avgk = paramavgk;
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Avgk != null) && (avgj.a(this.jdField_a_of_type_Avgj))) {
      this.jdField_a_of_type_Avgk.a(paramView, getAdapterPosition() - 1);
    }
    while (this.jdField_a_of_type_Avgk == null) {
      return;
    }
    this.jdField_a_of_type_Avgk.a(paramView, getAdapterPosition());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avgm
 * JD-Core Version:    0.7.0.1
 */