import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class anhr
  extends anht
{
  public static int b = 165;
  public int a;
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return axku.a(this.a);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    int i = paramEditText.getSelectionStart();
    int j = paramEditText.getSelectionEnd();
    paramEditText.getEditableText().replace(i, j, axku.a(this.a));
    paramEditText.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anhr
 * JD-Core Version:    0.7.0.1
 */