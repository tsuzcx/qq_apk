import android.text.Editable;
import android.text.TextWatcher;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView;

class bkct
  implements TextWatcher
{
  bkct(bkcm parambkcm) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_Bkcx == null) {}
    bjij localbjij;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramCharSequence == null);
        bkcm.a(this.a, true);
        if (this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
          this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), paramCharSequence.toString());
        }
      } while (!(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof bjij));
      localbjij = (bjij)this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      if ((localbjij.a(paramCharSequence.toString())) && (paramInt3 != 0) && ((bkcm.a(this.a) == null) || (!bkcm.a(this.a).c())))
      {
        bkcm.a(this.a, bcql.a(this.a.getContext(), ajya.a(2131703712), 0));
        bkcm.a(this.a).a();
      }
    } while ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() == bkcm.a(this.a)) || (localbjij.f() == bkcm.b(this.a)));
    if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() > bkcm.b(this.a)) && (bkcm.b(this.a) < localbjij.f()))
    {
      boolean bool = localbjij.a(bkcm.a(this.a), paramCharSequence.toString(), bkcm.b(this.a), bkcm.c(this.a));
      bkcm.a(this.a, localbjij.d());
      bkcm.a(this.a);
      if ((bool) && ((bkcm.a(this.a) == null) || (!bkcm.a(this.a).c())))
      {
        bkcm.a(this.a, bcql.a(this.a.getContext(), ajya.a(2131703711), 0));
        bkcm.a(this.a).a();
      }
    }
    for (;;)
    {
      bkcm.a(this.a, this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b());
      bkcm.b(this.a, localbjij.f());
      return;
      if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() < bkcm.b(this.a)) && (bkcm.c(this.a) < bjij.b) && (bkcm.b(this.a) > localbjij.f()))
      {
        bkcm.a(this.a, localbjij.a(bkcm.a(this.a), paramCharSequence.toString(), bkcm.b(this.a), bkcm.c(this.a)));
        bkcm.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkct
 * JD-Core Version:    0.7.0.1
 */