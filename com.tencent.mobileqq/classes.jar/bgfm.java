import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.MessageProgressView;

public class bgfm
  extends bgff<bgeg>
{
  public View a;
  public ImageView a;
  public RoundCornerImageView a;
  public URLDrawable a;
  public MessageProgressView a;
  public ImageView b;
  public ImageView c;
  
  public bgfm(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368090);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramView.findViewById(2131368092));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.a = 1;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(10);
    this.b = ((ImageView)paramView.findViewById(2131368095));
    this.c = ((ImageView)paramView.findViewById(2131368093));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368091));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = ((MessageProgressView)paramView.findViewById(2131368094));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(10.0F, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDisplayInTextView(agej.a(17.0F, paramView.getResources()), -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new bgfn(this));
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    this.b.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfm
 * JD-Core Version:    0.7.0.1
 */