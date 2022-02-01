import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;

public class bbeb
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public final TextView a;
  private bbdz jdField_a_of_type_Bbdz;
  public RecentDynamicAvatarView a;
  
  public bbeb(bbdy parambbdy, View paramView, bbdz parambbdz)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368138));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371720));
    this.jdField_a_of_type_Bbdz = parambbdz;
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Bbdz != null) && (bbdy.a(this.jdField_a_of_type_Bbdy))) {
      this.jdField_a_of_type_Bbdz.a(paramView, getAdapterPosition() - 1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Bbdz != null) {
        this.jdField_a_of_type_Bbdz.a(paramView, getAdapterPosition());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbeb
 * JD-Core Version:    0.7.0.1
 */