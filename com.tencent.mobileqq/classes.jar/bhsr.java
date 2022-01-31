import android.support.annotation.Nullable;
import dov.com.qq.im.giftext.AEGIFOutlineTextView;

class bhsr
  implements bhwg<bhsi>
{
  bhsr(bhsp parambhsp, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
  public void a(@Nullable bhsi parambhsi)
  {
    if (parambhsi != null)
    {
      this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setTextColor(parambhsi.a);
      this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setOutlineColor(parambhsi.b);
      if (parambhsi.a.equals("#ccffffff"))
      {
        this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setShadowParam(3.0F, 0.0F, 1.0F, "#73000000");
        this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setShadow(true);
        this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setStroke(false);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setShadow(false);
    this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setStroke(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhsr
 * JD-Core Version:    0.7.0.1
 */