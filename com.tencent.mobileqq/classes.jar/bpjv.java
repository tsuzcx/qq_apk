import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView;

class bpjv
  implements TextWatcher
{
  bpjv(bpjo parambpjo) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_Bpjz == null) {}
    bork localbork;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramCharSequence == null);
        bpjo.a(this.a, true);
        if (this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
          this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), paramCharSequence.toString());
        }
      } while (!(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof bork));
      localbork = (bork)this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      if ((localbork.a(paramCharSequence.toString())) && (paramInt3 != 0) && ((bpjo.a(this.a) == null) || (!bpjo.a(this.a).c())))
      {
        bpjo.a(this.a, QQToast.a(this.a.getContext(), anni.a(2131702493), 0));
        bpjo.a(this.a).a();
      }
    } while ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() == bpjo.a(this.a)) || (localbork.f() == bpjo.b(this.a)));
    if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() > bpjo.b(this.a)) && (bpjo.b(this.a) < localbork.f()))
    {
      boolean bool = localbork.a(bpjo.a(this.a), paramCharSequence.toString(), bpjo.b(this.a), bpjo.c(this.a));
      bpjo.a(this.a, localbork.d());
      bpjo.a(this.a);
      if ((bool) && ((bpjo.a(this.a) == null) || (!bpjo.a(this.a).c())))
      {
        bpjo.a(this.a, QQToast.a(this.a.getContext(), anni.a(2131702492), 0));
        bpjo.a(this.a).a();
      }
    }
    for (;;)
    {
      bpjo.a(this.a, this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b());
      bpjo.b(this.a, localbork.f());
      return;
      if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() < bpjo.b(this.a)) && (bpjo.c(this.a) < bork.b) && (bpjo.b(this.a) > localbork.f()))
      {
        bpjo.a(this.a, localbork.a(bpjo.a(this.a), paramCharSequence.toString(), bpjo.b(this.a), bpjo.c(this.a)));
        bpjo.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjv
 * JD-Core Version:    0.7.0.1
 */