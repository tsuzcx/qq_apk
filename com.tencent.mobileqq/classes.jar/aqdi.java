import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo;
import com.tencent.qphone.base.util.QLog;

class aqdi
  implements anyb
{
  aqdi(aqdb paramaqdb) {}
  
  public void a(anyc paramanyc)
  {
    int i;
    int j;
    if ((paramanyc instanceof aocr))
    {
      i = aqdb.a(this.a).getSelectionStart();
      j = aqdb.a(this.a).getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    aocp localaocp;
    int k;
    int m;
    do
    {
      aqdb.a(this.a).getEditableText().replace(i, j, ayla.c(((aocr)paramanyc).a));
      do
      {
        return;
      } while (!(paramanyc instanceof aocp));
      localaocp = (aocp)paramanyc;
      i = aqdb.a(this.a).getSelectionStart();
      j = aqdb.a(this.a).getSelectionEnd();
      k = localaocp.a;
      m = localaocp.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    String str = "";
    if (k == 1) {}
    try
    {
      for (paramanyc = ayla.c(m);; paramanyc = ayla.a(m))
      {
        aqdb.a(this.a).getEditableText().replace(i, j, paramanyc);
        aqdb.a(this.a).requestFocus();
        localaocp.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
        anwm.a().a(k).a(m, 4);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramanyc = str;
        if (QLog.isColorLevel())
        {
          QLog.d("Forward.NewVersion.Dialog", 2, QLog.getStackTraceString(localException));
          paramanyc = str;
        }
      }
    }
  }
  
  public void a(anyc paramanyc1, anyc paramanyc2, Drawable paramDrawable) {}
  
  public boolean a(anyc paramanyc)
  {
    return true;
  }
  
  public void b()
  {
    if (aqdb.a(this.a).getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = aqdb.a(this.a).getText();
        int i = aqdb.a(this.a).getSelectionStart();
        int j = TextUtils.getOffsetBefore(aqdb.a(this.a).getText(), i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqdi
 * JD-Core Version:    0.7.0.1
 */