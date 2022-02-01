import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;

public class baqp
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public final TextView a;
  private baqn jdField_a_of_type_Baqn;
  public RecentDynamicAvatarView a;
  
  public baqp(baqm parambaqm, View paramView, baqn parambaqn)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368236));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371791));
    this.jdField_a_of_type_Baqn = parambaqn;
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Baqn != null) && (baqm.a(this.jdField_a_of_type_Baqm))) {
      this.jdField_a_of_type_Baqn.a(paramView, getAdapterPosition() - 1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Baqn != null) {
        this.jdField_a_of_type_Baqn.a(paramView, getAdapterPosition());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqp
 * JD-Core Version:    0.7.0.1
 */