import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView;

class bmsp
  implements TextWatcher
{
  bmsp(bmsi parambmsi) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_Bmst == null) {}
    blyg localblyg;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramCharSequence == null);
        bmsi.a(this.a, true);
        if (this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
          this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), paramCharSequence.toString());
        }
      } while (!(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof blyg));
      localblyg = (blyg)this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      if ((localblyg.a(paramCharSequence.toString())) && (paramInt3 != 0) && ((bmsi.a(this.a) == null) || (!bmsi.a(this.a).c())))
      {
        bmsi.a(this.a, QQToast.a(this.a.getContext(), alud.a(2131704096), 0));
        bmsi.a(this.a).a();
      }
    } while ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() == bmsi.a(this.a)) || (localblyg.f() == bmsi.b(this.a)));
    if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() > bmsi.b(this.a)) && (bmsi.b(this.a) < localblyg.f()))
    {
      boolean bool = localblyg.a(bmsi.a(this.a), paramCharSequence.toString(), bmsi.b(this.a), bmsi.c(this.a));
      bmsi.a(this.a, localblyg.d());
      bmsi.a(this.a);
      if ((bool) && ((bmsi.a(this.a) == null) || (!bmsi.a(this.a).c())))
      {
        bmsi.a(this.a, QQToast.a(this.a.getContext(), alud.a(2131704095), 0));
        bmsi.a(this.a).a();
      }
    }
    for (;;)
    {
      bmsi.a(this.a, this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b());
      bmsi.b(this.a, localblyg.f());
      return;
      if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() < bmsi.b(this.a)) && (bmsi.c(this.a) < blyg.b) && (bmsi.b(this.a) > localblyg.f()))
      {
        bmsi.a(this.a, localblyg.a(bmsi.a(this.a), paramCharSequence.toString(), bmsi.b(this.a), bmsi.c(this.a)));
        bmsi.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsp
 * JD-Core Version:    0.7.0.1
 */