import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.widget.RecentDynamicAvatarView;

public class awgf
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public final TextView a;
  private awgd jdField_a_of_type_Awgd;
  public RecentDynamicAvatarView a;
  
  public awgf(awgc paramawgc, View paramView, awgd paramawgd)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131367679));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370832));
    this.jdField_a_of_type_Awgd = paramawgd;
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Awgd != null) && (awgc.a(this.jdField_a_of_type_Awgc))) {
      this.jdField_a_of_type_Awgd.a(paramView, getAdapterPosition() - 1);
    }
    while (this.jdField_a_of_type_Awgd == null) {
      return;
    }
    this.jdField_a_of_type_Awgd.a(paramView, getAdapterPosition());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awgf
 * JD-Core Version:    0.7.0.1
 */