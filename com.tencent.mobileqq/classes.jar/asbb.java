import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.QLog;

class asbb
  implements apuc
{
  asbb(asau paramasau) {}
  
  public void a(apuf paramapuf)
  {
    int i;
    int j;
    if ((paramapuf instanceof apzf))
    {
      i = asau.a(this.a).getSelectionStart();
      j = asau.a(this.a).getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    apza localapza;
    int k;
    int m;
    do
    {
      asau.a(this.a).getEditableText().replace(i, j, banh.c(((apzf)paramapuf).a));
      do
      {
        return;
      } while (!(paramapuf instanceof apza));
      localapza = (apza)paramapuf;
      i = asau.a(this.a).getSelectionStart();
      j = asau.a(this.a).getSelectionEnd();
      k = localapza.a;
      m = localapza.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    String str = "";
    if (k == 1) {}
    try
    {
      for (paramapuf = banh.c(m);; paramapuf = banh.a(m))
      {
        asau.a(this.a).getEditableText().replace(i, j, paramapuf);
        asau.a(this.a).requestFocus();
        localapza.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
        apsj.a().a(k).a(m, 4);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramapuf = str;
        if (QLog.isColorLevel())
        {
          QLog.d("Forward.NewVersion.Dialog", 2, QLog.getStackTraceString(localException));
          paramapuf = str;
        }
      }
    }
  }
  
  public void a(apuf paramapuf1, apuf paramapuf2, Drawable paramDrawable) {}
  
  public boolean a(apuf paramapuf)
  {
    return true;
  }
  
  public void b()
  {
    if (asau.a(this.a).getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = asau.a(this.a).getText();
        int i = asau.a(this.a).getSelectionStart();
        int j = TextUtils.getOffsetBefore(asau.a(this.a).getText(), i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbb
 * JD-Core Version:    0.7.0.1
 */