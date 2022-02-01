import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.QLog;

class auic
  implements arxd
{
  auic(auhv paramauhv) {}
  
  public void a(arxg paramarxg)
  {
    int i;
    int j;
    if ((paramarxg instanceof asdb))
    {
      i = auhv.a(this.a).getSelectionStart();
      j = auhv.a(this.a).getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    ascv localascv;
    int k;
    int m;
    do
    {
      auhv.a(this.a).getEditableText().replace(i, j, bdol.b(((asdb)paramarxg).a));
      do
      {
        return;
      } while (!(paramarxg instanceof ascv));
      localascv = (ascv)paramarxg;
      i = auhv.a(this.a).getSelectionStart();
      j = auhv.a(this.a).getSelectionEnd();
      k = localascv.a;
      m = localascv.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    String str = "";
    if (k == 1) {}
    try
    {
      for (paramarxg = bdol.b(m);; paramarxg = bdol.a(m))
      {
        auhv.a(this.a).getEditableText().replace(i, j, paramarxg);
        auhv.a(this.a).requestFocus();
        localascv.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
        arvk.a().a(k).a(m, 4);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramarxg = str;
        if (QLog.isColorLevel())
        {
          QLog.d("Forward.NewVersion.Dialog", 2, QLog.getStackTraceString(localException));
          paramarxg = str;
        }
      }
    }
  }
  
  public void a(arxg paramarxg1, arxg paramarxg2, Drawable paramDrawable) {}
  
  public boolean a(arxg paramarxg)
  {
    return true;
  }
  
  public void b()
  {
    if (auhv.a(this.a).getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = auhv.a(this.a).getText();
        int i = auhv.a(this.a).getSelectionStart();
        int j = TextUtils.getOffsetBefore(auhv.a(this.a).getText(), i);
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
  
  public void b(arxg paramarxg) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auic
 * JD-Core Version:    0.7.0.1
 */