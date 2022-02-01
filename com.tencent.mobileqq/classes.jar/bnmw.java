import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;

class bnmw
  implements Observer<bnmo>
{
  bnmw(bnmu parambnmu, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
  public void a(@Nullable bnmo parambnmo)
  {
    if (parambnmo != null)
    {
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextColor(parambnmo.a);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineColor(parambnmo.b);
      if (parambnmo.a.equals("#ccffffff"))
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
 * Qualified Name:     bnmw
 * JD-Core Version:    0.7.0.1
 */