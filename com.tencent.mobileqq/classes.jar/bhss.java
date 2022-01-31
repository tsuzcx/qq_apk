import android.support.annotation.Nullable;
import dov.com.qq.im.giftext.AEGIFOutlineTextView;

class bhss
  implements bhwg<String>
{
  bhss(bhsp parambhsp, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
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
      str = ajjy.a(2131634167);
    }
    paramString = this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.getLayoutParams();
    if (str.indexOf('\n') > 0) {}
    for (int i = bhsp.a(this.jdField_a_of_type_Bhsp) * 3 / 10;; i = bhsp.a(this.jdField_a_of_type_Bhsp) * 11 / 50)
    {
      paramString.height = i;
      this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setTextSize(azvv.c(bhsp.a(this.jdField_a_of_type_Bhsp), 23.0F));
      this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setOutlineWidth(azvv.a(bhsp.a(this.jdField_a_of_type_Bhsp), 2.0F));
      this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setText(str);
      this.jdField_a_of_type_DovComQqImGiftextAEGIFOutlineTextView.setLayoutParams(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhss
 * JD-Core Version:    0.7.0.1
 */