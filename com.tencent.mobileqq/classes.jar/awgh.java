import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.widget.RecentDynamicAvatarView;

public class awgh
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public final TextView a;
  private awgf jdField_a_of_type_Awgf;
  public RecentDynamicAvatarView a;
  
  public awgh(awge paramawge, View paramView, awgf paramawgf)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131367679));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370832));
    this.jdField_a_of_type_Awgf = paramawgf;
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Awgf != null) && (awge.a(this.jdField_a_of_type_Awge))) {
      this.jdField_a_of_type_Awgf.a(paramView, getAdapterPosition() - 1);
    }
    while (this.jdField_a_of_type_Awgf == null) {
      return;
    }
    this.jdField_a_of_type_Awgf.a(paramView, getAdapterPosition());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awgh
 * JD-Core Version:    0.7.0.1
 */