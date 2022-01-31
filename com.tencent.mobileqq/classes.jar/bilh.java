import android.text.Editable;
import android.text.TextWatcher;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView;

class bilh
  implements TextWatcher
{
  bilh(bila parambila) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_Bill == null) {}
    bhna localbhna;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramCharSequence == null);
        bila.a(this.a, true);
        if (this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
          this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), paramCharSequence.toString());
        }
      } while (!(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof bhna));
      localbhna = (bhna)this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      if ((localbhna.a(paramCharSequence.toString())) && (paramInt3 != 0) && ((bila.a(this.a) == null) || (!bila.a(this.a).c())))
      {
        bila.a(this.a, bbmy.a(this.a.getContext(), ajjy.a(2131637916), 0));
        bila.a(this.a).a();
      }
    } while ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() == bila.a(this.a)) || (localbhna.f() == bila.b(this.a)));
    if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() > bila.b(this.a)) && (bila.b(this.a) < localbhna.f()))
    {
      boolean bool = localbhna.a(bila.a(this.a), paramCharSequence.toString(), bila.b(this.a), bila.c(this.a));
      bila.a(this.a, localbhna.d());
      bila.a(this.a);
      if ((bool) && ((bila.a(this.a) == null) || (!bila.a(this.a).c())))
      {
        bila.a(this.a, bbmy.a(this.a.getContext(), ajjy.a(2131637915), 0));
        bila.a(this.a).a();
      }
    }
    for (;;)
    {
      bila.a(this.a, this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b());
      bila.b(this.a, localbhna.f());
      return;
      if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() < bila.b(this.a)) && (bila.c(this.a) < bhna.b) && (bila.b(this.a) > localbhna.f()))
      {
        bila.a(this.a, localbhna.a(bila.a(this.a), paramCharSequence.toString(), bila.b(this.a), bila.c(this.a)));
        bila.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilh
 * JD-Core Version:    0.7.0.1
 */