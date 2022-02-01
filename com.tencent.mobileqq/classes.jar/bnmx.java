import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.util.DisplayUtil;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;

class bnmx
  implements Observer<String>
{
  bnmx(bnmu parambnmu, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
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
      str = anvx.a(2131699466);
    }
    paramString = this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLayoutParams();
    if (str.indexOf('\n') > 0) {}
    for (int i = bnmu.a(this.jdField_a_of_type_Bnmu) * 3 / 10;; i = bnmu.a(this.jdField_a_of_type_Bnmu) * 11 / 50)
    {
      paramString.height = i;
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setTextSize(DisplayUtil.sp2px(bnmu.a(this.jdField_a_of_type_Bnmu), 23.0F));
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOutlineWidth(DisplayUtil.dip2px(bnmu.a(this.jdField_a_of_type_Bnmu), 2.0F));
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setText(str);
      this.jdField_a_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setLayoutParams(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmx
 * JD-Core Version:    0.7.0.1
 */