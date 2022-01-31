import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiBaseInfo;
import com.tencent.qphone.base.util.QLog;

class aqdk
  implements anyg
{
  aqdk(aqdd paramaqdd) {}
  
  public void a(anyh paramanyh)
  {
    int i;
    int j;
    if ((paramanyh instanceof aocw))
    {
      i = aqdd.a(this.a).getSelectionStart();
      j = aqdd.a(this.a).getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    aocu localaocu;
    int k;
    int m;
    do
    {
      aqdd.a(this.a).getEditableText().replace(i, j, aylc.c(((aocw)paramanyh).a));
      do
      {
        return;
      } while (!(paramanyh instanceof aocu));
      localaocu = (aocu)paramanyh;
      i = aqdd.a(this.a).getSelectionStart();
      j = aqdd.a(this.a).getSelectionEnd();
      k = localaocu.a;
      m = localaocu.b;
      if ((i < 0) || (j < 0) || (j < i)) {
        break;
      }
    } while ((k == 2) && (m == -1));
    String str = "";
    if (k == 1) {}
    try
    {
      for (paramanyh = aylc.c(m);; paramanyh = aylc.a(m))
      {
        aqdd.a(this.a).getEditableText().replace(i, j, paramanyh);
        aqdd.a(this.a).requestFocus();
        localaocu.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), null);
        anwr.a().a(k).a(m, 4);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramanyh = str;
        if (QLog.isColorLevel())
        {
          QLog.d("Forward.NewVersion.Dialog", 2, QLog.getStackTraceString(localException));
          paramanyh = str;
        }
      }
    }
  }
  
  public void a(anyh paramanyh1, anyh paramanyh2, Drawable paramDrawable) {}
  
  public boolean a(anyh paramanyh)
  {
    return true;
  }
  
  public void b()
  {
    if (aqdd.a(this.a).getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = aqdd.a(this.a).getText();
        int i = aqdd.a(this.a).getSelectionStart();
        int j = TextUtils.getOffsetBefore(aqdd.a(this.a).getText(), i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqdk
 * JD-Core Version:    0.7.0.1
 */