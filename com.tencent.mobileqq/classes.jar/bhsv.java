import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import dov.com.qq.im.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.giftext.DrawableImageView;

class bhsv
  extends RecyclerView.ViewHolder
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AEGIFOutlineTextView jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView;
  private DrawableImageView jdField_a_of_type_DovComQqImGiftextDrawableImageView;
  private ImageView b;
  
  public bhsv(bhsp parambhsp, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298096));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131307112));
    this.jdField_a_of_type_DovComQqImGiftextDrawableImageView = ((DrawableImageView)paramView.findViewById(2131296626));
    this.b = ((ImageView)paramView.findViewById(2131296627));
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView = ((AEGIFOutlineTextView)paramView.findViewById(2131305470));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837918);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhsv
 * JD-Core Version:    0.7.0.1
 */