import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo;

class bbhk
  implements anyb
{
  bbhk(bbhb parambbhb) {}
  
  public void a(anyc paramanyc)
  {
    int i;
    int j;
    if ((paramanyc instanceof aocr))
    {
      i = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      j = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    aocp localaocp;
    int k;
    int m;
    do
    {
      this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, ayla.c(((aocr)paramanyc).a));
      do
      {
        return;
      } while (!(paramanyc instanceof aocp));
      localaocp = (aocp)paramanyc;
      i = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      j = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
      k = localaocp.a;
      m = localaocp.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    if (k == 1) {}
    for (paramanyc = ayla.c(m);; paramanyc = ayla.a(m))
    {
      this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, paramanyc);
      this.a.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      if (this.a.jdField_a_of_type_Boolean) {
        localaocp.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      }
      anwm.a().a(k).a(m, 5);
      return;
    }
  }
  
  public void a(anyc paramanyc1, anyc paramanyc2, Drawable paramDrawable) {}
  
  public boolean a(anyc paramanyc)
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
  
  public void b(anyc paramanyc) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbhk
 * JD-Core Version:    0.7.0.1
 */