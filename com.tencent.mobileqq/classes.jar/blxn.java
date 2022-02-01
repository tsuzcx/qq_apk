import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.util.DisplayUtil;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;

class blxn
  implements Observer<String>
{
  blxn(blxk paramblxk, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
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
      str = amtj.a(2131699115);
    }
    paramString = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLayoutParams();
    if (str.indexOf('\n') > 0) {}
    for (int i = blxk.a(this.jdField_a_of_type_Blxk) * 3 / 10;; i = blxk.a(this.jdField_a_of_type_Blxk) * 11 / 50)
    {
      paramString.height = i;
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextSize(DisplayUtil.sp2px(blxk.a(this.jdField_a_of_type_Blxk), 23.0F));
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineWidth(DisplayUtil.dip2px(blxk.a(this.jdField_a_of_type_Blxk), 2.0F));
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setText(str);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setLayoutParams(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxn
 * JD-Core Version:    0.7.0.1
 */