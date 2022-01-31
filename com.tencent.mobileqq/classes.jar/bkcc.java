import android.text.Editable;
import android.text.TextWatcher;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView;

class bkcc
  implements TextWatcher
{
  bkcc(bkbv parambkbv) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_Bkcg == null) {}
    bjhs localbjhs;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramCharSequence == null);
        bkbv.a(this.a, true);
        if (this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
          this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), paramCharSequence.toString());
        }
      } while (!(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof bjhs));
      localbjhs = (bjhs)this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      if ((localbjhs.a(paramCharSequence.toString())) && (paramInt3 != 0) && ((bkbv.a(this.a) == null) || (!bkbv.a(this.a).c())))
      {
        bkbv.a(this.a, bcpw.a(this.a.getContext(), ajyc.a(2131703701), 0));
        bkbv.a(this.a).a();
      }
    } while ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() == bkbv.a(this.a)) || (localbjhs.f() == bkbv.b(this.a)));
    if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() > bkbv.b(this.a)) && (bkbv.b(this.a) < localbjhs.f()))
    {
      boolean bool = localbjhs.a(bkbv.a(this.a), paramCharSequence.toString(), bkbv.b(this.a), bkbv.c(this.a));
      bkbv.a(this.a, localbjhs.d());
      bkbv.a(this.a);
      if ((bool) && ((bkbv.a(this.a) == null) || (!bkbv.a(this.a).c())))
      {
        bkbv.a(this.a, bcpw.a(this.a.getContext(), ajyc.a(2131703700), 0));
        bkbv.a(this.a).a();
      }
    }
    for (;;)
    {
      bkbv.a(this.a, this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b());
      bkbv.b(this.a, localbjhs.f());
      return;
      if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b() < bkbv.b(this.a)) && (bkbv.c(this.a) < bjhs.b) && (bkbv.b(this.a) > localbjhs.f()))
      {
        bkbv.a(this.a, localbjhs.a(bkbv.a(this.a), paramCharSequence.toString(), bkbv.b(this.a), bkbv.c(this.a)));
        bkbv.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkcc
 * JD-Core Version:    0.7.0.1
 */