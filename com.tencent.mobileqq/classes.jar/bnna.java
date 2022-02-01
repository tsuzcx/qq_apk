import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.DrawableImageView;

class bnna
  extends RecyclerView.ViewHolder
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AEGIFOutlineTextView jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView;
  private DrawableImageView jdField_a_of_type_DovComQqImAeGifGiftextDrawableImageView;
  private ImageView b;
  
  public bnna(bnmu parambnmu, View paramView, String paramString)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364029));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131374127));
    this.jdField_a_of_type_DovComQqImAeGifGiftextDrawableImageView = ((DrawableImageView)paramView.findViewById(2131362272));
    this.b = ((ImageView)paramView.findViewById(2131362273));
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView = ((AEGIFOutlineTextView)paramView.findViewById(2131372336));
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setFontId(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838127);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnna
 * JD-Core Version:    0.7.0.1
 */