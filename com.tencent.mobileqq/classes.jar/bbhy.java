import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo;

class bbhy
  implements anyg
{
  bbhy(bbhp parambbhp) {}
  
  public void a(anyh paramanyh)
  {
    int i;
    int j;
    if ((paramanyh instanceof aocw))
    {
      i = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      j = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    aocu localaocu;
    int k;
    int m;
    do
    {
      this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, aylc.c(((aocw)paramanyh).a));
      do
      {
        return;
      } while (!(paramanyh instanceof aocu));
      localaocu = (aocu)paramanyh;
      i = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      j = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
      k = localaocu.a;
      m = localaocu.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    if (k == 1) {}
    for (paramanyh = aylc.c(m);; paramanyh = aylc.a(m))
    {
      this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().replace(i, j, paramanyh);
      this.a.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      if (this.a.jdField_a_of_type_Boolean) {
        localaocu.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
      }
      anwr.a().a(k).a(m, 5);
      return;
    }
  }
  
  public void a(anyh paramanyh1, anyh paramanyh2, Drawable paramDrawable) {}
  
  public boolean a(anyh paramanyh)
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
  
  public void b(anyh paramanyh) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbhy
 * JD-Core Version:    0.7.0.1
 */