import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;

public class bbxe
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public final TextView a;
  private bbxc jdField_a_of_type_Bbxc;
  public RecentDynamicAvatarView a;
  
  public bbxe(bbxb parambbxb, View paramView, bbxc parambbxc)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368381));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371981));
    this.jdField_a_of_type_Bbxc = parambbxc;
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Bbxc != null) && (bbxb.a(this.jdField_a_of_type_Bbxb))) {
      this.jdField_a_of_type_Bbxc.a(paramView, getAdapterPosition() - 1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Bbxc != null) {
        this.jdField_a_of_type_Bbxc.a(paramView, getAdapterPosition());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxe
 * JD-Core Version:    0.7.0.1
 */