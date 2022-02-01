import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;

public class bbwu
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public final TextView a;
  private bbws jdField_a_of_type_Bbws;
  public RecentDynamicAvatarView a;
  
  public bbwu(bbwr parambbwr, View paramView, bbws parambbws)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368212));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371827));
    this.jdField_a_of_type_Bbws = parambbws;
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Bbws != null) && (bbwr.a(this.jdField_a_of_type_Bbwr))) {
      this.jdField_a_of_type_Bbws.a(paramView, getAdapterPosition() - 1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Bbws != null) {
        this.jdField_a_of_type_Bbws.a(paramView, getAdapterPosition());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwu
 * JD-Core Version:    0.7.0.1
 */