import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.profile.CustomCoverFragment;

public class azvo
  extends RecyclerView.ViewHolder
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public azvo(CustomCoverFragment paramCustomCoverFragment, View paramView)
  {
    super(paramView);
    this.itemView.setTag(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367040));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367031));
    this.itemView.setBackgroundColor(paramCustomCoverFragment.getResources().getColor(2131167302));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvo
 * JD-Core Version:    0.7.0.1
 */