import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import java.io.UnsupportedEncodingException;

public class aqfh
  implements TextWatcher
{
  public aqfh(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  private int a(String paramString)
  {
    byte[] arrayOfByte = new byte[0];
    try
    {
      paramString = paramString.getBytes("utf-8");
      if (paramString.length % 3 == 0) {
        return paramString.length / 3;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = arrayOfByte;
      }
    }
    return paramString.length / 3 + 1;
  }
  
  private String a(String paramString)
  {
    while (a(paramString) > 32)
    {
      int i = paramString.length();
      if ((i >= 2) && (Character.isHighSurrogate(paramString.charAt(i - 2)))) {
        paramString = paramString.substring(0, i - 2);
      } else {
        paramString = paramString.substring(0, i - 1);
      }
    }
    return paramString;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.a.getText().toString();
    if (a(paramEditable) > 32)
    {
      int i = this.a.a.getSelectionStart();
      paramEditable = a(paramEditable);
      this.a.a.setText(paramEditable);
      if (i >= paramEditable.length()) {
        this.a.a.setSelection(paramEditable.length());
      }
    }
    if (this.a.h)
    {
      azmj.b(null, "CliOper", "", "", "0X80050F0", "0X80050F0", 0, 0, "", "", "", "");
      this.a.h = false;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqfh
 * JD-Core Version:    0.7.0.1
 */