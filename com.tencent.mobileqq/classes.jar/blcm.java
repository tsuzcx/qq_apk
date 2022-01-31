import android.support.annotation.Nullable;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;

class blcm
  implements bmeo<String>
{
  blcm(blcj paramblcj, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
  public void a(@Nullable String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.equals("")) {}
    }
    else
    {
      str = alud.a(2131700347);
    }
    paramString = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLayoutParams();
    if (str.indexOf('\n') > 0) {}
    for (int i = blcj.a(this.jdField_a_of_type_Blcj) * 3 / 10;; i = blcj.a(this.jdField_a_of_type_Blcj) * 11 / 50)
    {
      paramString.height = i;
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextSize(bdaq.c(blcj.a(this.jdField_a_of_type_Blcj), 23.0F));
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineWidth(bdaq.a(blcj.a(this.jdField_a_of_type_Blcj), 2.0F));
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setText(str);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setLayoutParams(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcm
 * JD-Core Version:    0.7.0.1
 */