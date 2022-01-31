import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.widget.MessageProgressView;

public class awpx
  extends RecyclerView.ViewHolder
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  public MessageProgressView a;
  public ImageView b;
  
  public awpx(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, View paramView)
  {
    super(paramView);
    float f = 2.0F * PersonalityLabelGalleryActivity.a(paramPersonalityLabelGalleryActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371856));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371796));
    ((CornerImageView)this.jdField_a_of_type_AndroidWidgetImageView).setRadius(f);
    ((CornerImageView)this.jdField_a_of_type_AndroidWidgetImageView).setPressMask(true);
    this.b = ((ImageView)paramView.findViewById(2131365978));
    ((CornerImageView)this.b).setRadius(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awpx
 * JD-Core Version:    0.7.0.1
 */