import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView;

class bnic
  implements TextWatcher
{
  bnic(bnhv parambnhv) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_Bnig == null) {}
    bmwl localbmwl;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramCharSequence == null);
        bnhv.a(this.a, true);
        if (this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
          this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), paramCharSequence.toString());
        }
      } while (!(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof bmwl));
      localbmwl = (bmwl)this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      if ((localbmwl.a(paramCharSequence.toString())) && (paramInt3 != 0) && ((bnhv.a(this.a) == null) || (!bnhv.a(this.a).c())))
      {
        bnhv.a(this.a, QQToast.a(this.a.getContext(), amtj.a(2131702835), 0));
        bnhv.a(this.a).a();
      }
    } while ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() == bnhv.a(this.a)) || (localbmwl.f() == bnhv.b(this.a)));
    if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() > bnhv.b(this.a)) && (bnhv.b(this.a) < localbmwl.f()))
    {
      boolean bool = localbmwl.a(bnhv.a(this.a), paramCharSequence.toString(), bnhv.b(this.a), bnhv.c(this.a));
      bnhv.a(this.a, localbmwl.d());
      bnhv.a(this.a);
      if ((bool) && ((bnhv.a(this.a) == null) || (!bnhv.a(this.a).c())))
      {
        bnhv.a(this.a, QQToast.a(this.a.getContext(), amtj.a(2131702834), 0));
        bnhv.a(this.a).a();
      }
    }
    for (;;)
    {
      bnhv.a(this.a, this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b());
      bnhv.b(this.a, localbmwl.f());
      return;
      if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() < bnhv.b(this.a)) && (bnhv.c(this.a) < bmwl.b) && (bnhv.b(this.a) > localbmwl.f()))
      {
        bnhv.a(this.a, localbmwl.a(bnhv.a(this.a), paramCharSequence.toString(), bnhv.b(this.a), bnhv.c(this.a)));
        bnhv.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnic
 * JD-Core Version:    0.7.0.1
 */