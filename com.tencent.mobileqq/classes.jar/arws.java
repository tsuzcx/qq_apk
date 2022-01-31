import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.QLog;

class arws
  implements appt
{
  arws(arwl paramarwl) {}
  
  public void a(appw paramappw)
  {
    int i;
    int j;
    if ((paramappw instanceof apuw))
    {
      i = arwl.a(this.a).getSelectionStart();
      j = arwl.a(this.a).getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    apur localapur;
    int k;
    int m;
    do
    {
      arwl.a(this.a).getEditableText().replace(i, j, baiy.c(((apuw)paramappw).a));
      do
      {
        return;
      } while (!(paramappw instanceof apur));
      localapur = (apur)paramappw;
      i = arwl.a(this.a).getSelectionStart();
      j = arwl.a(this.a).getSelectionEnd();
      k = localapur.a;
      m = localapur.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    String str = "";
    if (k == 1) {}
    try
    {
      for (paramappw = baiy.c(m);; paramappw = baiy.a(m))
      {
        arwl.a(this.a).getEditableText().replace(i, j, paramappw);
        arwl.a(this.a).requestFocus();
        localapur.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
        apoa.a().a(k).a(m, 4);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramappw = str;
        if (QLog.isColorLevel())
        {
          QLog.d("Forward.NewVersion.Dialog", 2, QLog.getStackTraceString(localException));
          paramappw = str;
        }
      }
    }
  }
  
  public void a(appw paramappw1, appw paramappw2, Drawable paramDrawable) {}
  
  public boolean a(appw paramappw)
  {
    return true;
  }
  
  public void b()
  {
    if (arwl.a(this.a).getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = arwl.a(this.a).getText();
        int i = arwl.a(this.a).getSelectionStart();
        int j = TextUtils.getOffsetBefore(arwl.a(this.a).getText(), i);
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
  
  public void b(appw paramappw) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arws
 * JD-Core Version:    0.7.0.1
 */