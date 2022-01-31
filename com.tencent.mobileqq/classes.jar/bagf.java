import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo;

class bagf
  implements anhs
{
  bagf(bafw parambafw) {}
  
  public void a(anht paramanht)
  {
    int i;
    int j;
    if ((paramanht instanceof anmh))
    {
      i = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      j = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    anmf localanmf;
    int k;
    int m;
    do
    {
      this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, axku.c(((anmh)paramanht).a));
      do
      {
        return;
      } while (!(paramanht instanceof anmf));
      localanmf = (anmf)paramanht;
      i = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      j = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
      k = localanmf.a;
      m = localanmf.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    if (k == 1) {}
    for (paramanht = axku.c(m);; paramanht = axku.a(m))
    {
      this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, paramanht);
      this.a.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      if (this.a.jdField_a_of_type_Boolean) {
        localanmf.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      }
      angd.a().a(k).a(m, 5);
      return;
    }
  }
  
  public void a(anht paramanht1, anht paramanht2, Drawable paramDrawable) {}
  
  public boolean a(anht paramanht)
  {
    return true;
  }
  
  public void b()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = this.a.jdField_a_of_type_AndroidWidgetEditText.getText();
        int i = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
        int j = TextUtils.getOffsetBefore(this.a.jdField_a_of_type_AndroidWidgetEditText.getText(), i);
        if (i != j)
        {
          localEditable.delete(Math.min(i, j), Math.max(i, j));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void b(anht paramanht) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bagf
 * JD-Core Version:    0.7.0.1
 */