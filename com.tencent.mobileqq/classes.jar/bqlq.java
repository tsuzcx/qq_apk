import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView;

class bqlq
  implements TextWatcher
{
  bqlq(bqlj parambqlj) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_Bqlu == null) {}
    bptf localbptf;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramCharSequence == null);
        bqlj.a(this.a, true);
        if (this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
          this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), paramCharSequence.toString());
        }
      } while (!(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof bptf));
      localbptf = (bptf)this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      if ((localbptf.a(paramCharSequence.toString())) && (paramInt3 != 0) && ((bqlj.a(this.a) == null) || (!bqlj.a(this.a).c())))
      {
        bqlj.a(this.a, QQToast.a(this.a.getContext(), anzj.a(2131702600), 0));
        bqlj.a(this.a).a();
      }
    } while ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() == bqlj.a(this.a)) || (localbptf.f() == bqlj.b(this.a)));
    if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() > bqlj.b(this.a)) && (bqlj.b(this.a) < localbptf.f()))
    {
      boolean bool = localbptf.a(bqlj.a(this.a), paramCharSequence.toString(), bqlj.b(this.a), bqlj.c(this.a));
      bqlj.a(this.a, localbptf.d());
      bqlj.a(this.a);
      if ((bool) && ((bqlj.a(this.a) == null) || (!bqlj.a(this.a).c())))
      {
        bqlj.a(this.a, QQToast.a(this.a.getContext(), anzj.a(2131702599), 0));
        bqlj.a(this.a).a();
      }
    }
    for (;;)
    {
      bqlj.a(this.a, this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b());
      bqlj.b(this.a, localbptf.f());
      return;
      if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() < bqlj.b(this.a)) && (bqlj.c(this.a) < bptf.b) && (bqlj.b(this.a) > localbptf.f()))
      {
        bqlj.a(this.a, localbptf.a(bqlj.a(this.a), paramCharSequence.toString(), bqlj.b(this.a), bqlj.c(this.a)));
        bqlj.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqlq
 * JD-Core Version:    0.7.0.1
 */