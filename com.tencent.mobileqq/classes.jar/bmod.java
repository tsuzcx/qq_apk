import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView;

class bmod
  implements TextWatcher
{
  bmod(bmnw parambmnw) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_Bmoh == null) {}
    bltu localbltu;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramCharSequence == null);
        bmnw.a(this.a, true);
        if (this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
          this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), paramCharSequence.toString());
        }
      } while (!(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof bltu));
      localbltu = (bltu)this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      if ((localbltu.a(paramCharSequence.toString())) && (paramInt3 != 0) && ((bmnw.a(this.a) == null) || (!bmnw.a(this.a).c())))
      {
        bmnw.a(this.a, QQToast.a(this.a.getContext(), alpo.a(2131704084), 0));
        bmnw.a(this.a).a();
      }
    } while ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() == bmnw.a(this.a)) || (localbltu.f() == bmnw.b(this.a)));
    if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() > bmnw.b(this.a)) && (bmnw.b(this.a) < localbltu.f()))
    {
      boolean bool = localbltu.a(bmnw.a(this.a), paramCharSequence.toString(), bmnw.b(this.a), bmnw.c(this.a));
      bmnw.a(this.a, localbltu.d());
      bmnw.a(this.a);
      if ((bool) && ((bmnw.a(this.a) == null) || (!bmnw.a(this.a).c())))
      {
        bmnw.a(this.a, QQToast.a(this.a.getContext(), alpo.a(2131704083), 0));
        bmnw.a(this.a).a();
      }
    }
    for (;;)
    {
      bmnw.a(this.a, this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b());
      bmnw.b(this.a, localbltu.f());
      return;
      if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() < bmnw.b(this.a)) && (bmnw.c(this.a) < bltu.b) && (bmnw.b(this.a) > localbltu.f()))
      {
        bmnw.a(this.a, localbltu.a(bmnw.a(this.a), paramCharSequence.toString(), bmnw.b(this.a), bmnw.c(this.a)));
        bmnw.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmod
 * JD-Core Version:    0.7.0.1
 */