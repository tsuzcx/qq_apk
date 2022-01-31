import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;

public final class amyx
  implements EmoticonCallback
{
  public amyx(EditText paramEditText) {}
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo == null) || (this.a == null)) {}
    int i;
    int j;
    do
    {
      do
      {
        return;
      } while (!(paramEmoticonInfo instanceof SystemEmoticonInfo));
      i = this.a.getSelectionStart();
      j = this.a.getSelectionEnd();
    } while ((i < 0) || (j < 0) || (j < i) || (this.a == null) || (this.a.getEditableText() == null));
    this.a.getEditableText().replace(i, j, com.tencent.mobileqq.text.TextUtils.c(((SystemEmoticonInfo)paramEmoticonInfo).a));
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void b()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      if (this.a.getSelectionStart() != 0) {
        try
        {
          Editable localEditable = this.a.getText();
          int i = this.a.getSelectionStart();
          int j = android.text.TextUtils.getOffsetBefore(this.a.getText(), i);
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
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void c() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyx
 * JD-Core Version:    0.7.0.1
 */