import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.DrawableImageView;

class bitp
  extends RecyclerView.ViewHolder
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AEGIFOutlineTextView jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView;
  private DrawableImageView jdField_a_of_type_DovComQqImAeGifGiftextDrawableImageView;
  private ImageView b;
  
  public bitp(bitj parambitj, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363647));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372826));
    this.jdField_a_of_type_DovComQqImAeGifGiftextDrawableImageView = ((DrawableImageView)paramView.findViewById(2131362166));
    this.b = ((ImageView)paramView.findViewById(2131362167));
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView = ((AEGIFOutlineTextView)paramView.findViewById(2131371163));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837927);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bitp
 * JD-Core Version:    0.7.0.1
 */