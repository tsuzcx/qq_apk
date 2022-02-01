import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView;

class boxu
  implements TextWatcher
{
  boxu(boxn paramboxn) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_Boxy == null) {}
    bomd localbomd;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramCharSequence == null);
        boxn.a(this.a, true);
        if (this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
          this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), paramCharSequence.toString());
        }
      } while (!(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof bomd));
      localbomd = (bomd)this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      if ((localbomd.a(paramCharSequence.toString())) && (paramInt3 != 0) && ((boxn.a(this.a) == null) || (!boxn.a(this.a).c())))
      {
        boxn.a(this.a, QQToast.a(this.a.getContext(), anvx.a(2131703186), 0));
        boxn.a(this.a).a();
      }
    } while ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() == boxn.a(this.a)) || (localbomd.f() == boxn.b(this.a)));
    if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() > boxn.b(this.a)) && (boxn.b(this.a) < localbomd.f()))
    {
      boolean bool = localbomd.a(boxn.a(this.a), paramCharSequence.toString(), boxn.b(this.a), boxn.c(this.a));
      boxn.a(this.a, localbomd.d());
      boxn.a(this.a);
      if ((bool) && ((boxn.a(this.a) == null) || (!boxn.a(this.a).c())))
      {
        boxn.a(this.a, QQToast.a(this.a.getContext(), anvx.a(2131703185), 0));
        boxn.a(this.a).a();
      }
    }
    for (;;)
    {
      boxn.a(this.a, this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b());
      boxn.b(this.a, localbomd.f());
      return;
      if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() < boxn.b(this.a)) && (boxn.c(this.a) < bomd.b) && (boxn.b(this.a) > localbomd.f()))
      {
        boxn.a(this.a, localbomd.a(boxn.a(this.a), paramCharSequence.toString(), boxn.b(this.a), boxn.c(this.a)));
        boxn.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boxu
 * JD-Core Version:    0.7.0.1
 */