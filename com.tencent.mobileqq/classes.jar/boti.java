import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;

class boti
  implements Observer<String>
{
  boti(botf parambotf, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
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
      str = anzj.a(2131698880);
    }
    paramString = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLayoutParams();
    if (str.indexOf('\n') > 0) {}
    for (int i = botf.a(this.jdField_a_of_type_Botf) * 3 / 10;; i = botf.a(this.jdField_a_of_type_Botf) * 11 / 50)
    {
      paramString.height = i;
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextSize(bhgr.c(botf.a(this.jdField_a_of_type_Botf), 23.0F));
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineWidth(bhgr.a(botf.a(this.jdField_a_of_type_Botf), 2.0F));
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setText(str);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setLayoutParams(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boti
 * JD-Core Version:    0.7.0.1
 */