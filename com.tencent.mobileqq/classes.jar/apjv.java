import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo;
import com.tencent.qphone.base.util.QLog;

class apjv
  implements anhs
{
  apjv(apjo paramapjo) {}
  
  public void a(anht paramanht)
  {
    int i;
    int j;
    if ((paramanht instanceof anmh))
    {
      i = apjo.a(this.a).getSelectionStart();
      j = apjo.a(this.a).getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    anmf localanmf;
    int k;
    int m;
    do
    {
      apjo.a(this.a).getEditableText().replace(i, j, axku.c(((anmh)paramanht).a));
      do
      {
        return;
      } while (!(paramanht instanceof anmf));
      localanmf = (anmf)paramanht;
      i = apjo.a(this.a).getSelectionStart();
      j = apjo.a(this.a).getSelectionEnd();
      k = localanmf.a;
      m = localanmf.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    String str = "";
    if (k == 1) {}
    try
    {
      for (paramanht = axku.c(m);; paramanht = axku.a(m))
      {
        apjo.a(this.a).getEditableText().replace(i, j, paramanht);
        apjo.a(this.a).requestFocus();
        localanmf.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
        angd.a().a(k).a(m, 4);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramanht = str;
        if (QLog.isColorLevel())
        {
          QLog.d("Forward.NewVersion.Dialog", 2, QLog.getStackTraceString(localException));
          paramanht = str;
        }
      }
    }
  }
  
  public void a(anht paramanht1, anht paramanht2, Drawable paramDrawable) {}
  
  public boolean a(anht paramanht)
  {
    return true;
  }
  
  public void b()
  {
    if (apjo.a(this.a).getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = apjo.a(this.a).getText();
        int i = apjo.a(this.a).getSelectionStart();
        int j = TextUtils.getOffsetBefore(apjo.a(this.a).getText(), i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apjv
 * JD-Core Version:    0.7.0.1
 */