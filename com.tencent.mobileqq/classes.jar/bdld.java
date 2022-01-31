import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;

class bdld
  implements apuc
{
  bdld(bdku parambdku) {}
  
  public void a(apuf paramapuf)
  {
    int i;
    int j;
    if ((paramapuf instanceof apzf))
    {
      i = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      j = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    apza localapza;
    int k;
    int m;
    do
    {
      this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, banh.c(((apzf)paramapuf).a));
      do
      {
        return;
      } while (!(paramapuf instanceof apza));
      localapza = (apza)paramapuf;
      i = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      j = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
      k = localapza.a;
      m = localapza.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    if (k == 1) {}
    for (paramapuf = banh.c(m);; paramapuf = banh.a(m))
    {
      this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, paramapuf);
      this.a.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      if (this.a.jdField_a_of_type_Boolean) {
        localapza.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      }
      apsj.a().a(k).a(m, 5);
      return;
    }
  }
  
  public void a(apuf paramapuf1, apuf paramapuf2, Drawable paramDrawable) {}
  
  public boolean a(apuf paramapuf)
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
  
  public void b(apuf paramapuf) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdld
 * JD-Core Version:    0.7.0.1
 */