import android.support.annotation.Nullable;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;

class blcl
  implements bmeo<blcd>
{
  blcl(blcj paramblcj, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
  public void a(@Nullable blcd paramblcd)
  {
    if (paramblcd != null)
    {
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextColor(paramblcd.a);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineColor(paramblcd.b);
      if (paramblcd.a.equals("#ccffffff"))
      {
        this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setShadowParam(3.0F, 0.0F, 1.0F, "#73000000");
        this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setShadow(true);
        this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setStroke(false);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setShadow(false);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setStroke(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcl
 * JD-Core Version:    0.7.0.1
 */