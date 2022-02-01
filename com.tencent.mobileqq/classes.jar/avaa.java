import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.QLog;

class avaa
  implements asmr
{
  avaa(auzt paramauzt) {}
  
  public void a(asmu paramasmu)
  {
    int i;
    int j;
    if ((paramasmu instanceof assp))
    {
      i = auzt.a(this.a).getSelectionStart();
      j = auzt.a(this.a).getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    assj localassj;
    int k;
    int m;
    do
    {
      auzt.a(this.a).getEditableText().replace(i, j, behh.b(((assp)paramasmu).a));
      do
      {
        return;
      } while (!(paramasmu instanceof assj));
      localassj = (assj)paramasmu;
      i = auzt.a(this.a).getSelectionStart();
      j = auzt.a(this.a).getSelectionEnd();
      k = localassj.a;
      m = localassj.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    String str = "";
    if (k == 1) {}
    try
    {
      for (paramasmu = behh.b(m);; paramasmu = behh.a(m))
      {
        auzt.a(this.a).getEditableText().replace(i, j, paramasmu);
        auzt.a(this.a).requestFocus();
        localassj.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
        asky.a().a(k).a(m, 4);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramasmu = str;
        if (QLog.isColorLevel())
        {
          QLog.d("Forward.NewVersion.Dialog", 2, QLog.getStackTraceString(localException));
          paramasmu = str;
        }
      }
    }
  }
  
  public void a(asmu paramasmu1, asmu paramasmu2, Drawable paramDrawable) {}
  
  public boolean a(asmu paramasmu)
  {
    return true;
  }
  
  public void b()
  {
    if (auzt.a(this.a).getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = auzt.a(this.a).getText();
        int i = auzt.a(this.a).getSelectionStart();
        int j = TextUtils.getOffsetBefore(auzt.a(this.a).getText(), i);
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
  
  public void b(asmu paramasmu) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avaa
 * JD-Core Version:    0.7.0.1
 */