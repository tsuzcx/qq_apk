import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;

final class bngv
  implements asmr
{
  bngv(EditText paramEditText) {}
  
  public void a(asmu paramasmu)
  {
    if ((paramasmu == null) || (this.a == null)) {}
    int i;
    int j;
    do
    {
      do
      {
        return;
      } while (!(paramasmu instanceof assp));
      i = this.a.getSelectionStart();
      j = this.a.getSelectionEnd();
    } while ((i < 0) || (j < 0) || (j < i) || (this.a == null) || (this.a.getEditableText() == null));
    this.a.getEditableText().replace(i, j, behh.b(((assp)paramasmu).a));
  }
  
  public void a(asmu paramasmu1, asmu paramasmu2, Drawable paramDrawable) {}
  
  public boolean a(asmu paramasmu)
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
          int j = TextUtils.getOffsetBefore(this.a.getText(), i);
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
  
  public void b(asmu paramasmu) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngv
 * JD-Core Version:    0.7.0.1
 */