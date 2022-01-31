import android.text.Editable;
import android.text.Spanned;
import android.widget.EditText;
import com.tencent.open.agent.SendStoryActivity;
import com.tencent.open.agent.datamodel.Friend;
import java.util.Arrays;

public class bfcr
  extends bfhf
{
  public bfcr(SendStoryActivity paramSendStoryActivity, EditText paramEditText, int paramInt)
  {
    super(paramEditText, paramInt);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramInt3 = 0;
    paramSpanned = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
    StringBuilder localStringBuilder = new StringBuilder(paramSpanned.toString());
    Friend[] arrayOfFriend = (Friend[])paramSpanned.getSpans(0, paramSpanned.length(), Friend.class);
    Arrays.sort(arrayOfFriend, new bfcs(this, paramSpanned));
    paramInt4 = arrayOfFriend.length;
    while (paramInt3 < paramInt4)
    {
      Friend localFriend = arrayOfFriend[paramInt3];
      localStringBuilder.delete(paramSpanned.getSpanStart(localFriend), paramSpanned.getSpanEnd(localFriend));
      paramInt3 += 1;
    }
    paramInt4 = this.jdField_a_of_type_Int - bfhm.a(localStringBuilder.toString());
    paramInt3 = bfhm.a(paramCharSequence.subSequence(paramInt1, paramInt2).toString());
    if (paramInt4 <= 0) {
      return "";
    }
    if (paramInt4 >= paramInt3) {
      return null;
    }
    paramInt3 = paramInt1;
    if (paramInt3 < paramInt2)
    {
      int j;
      if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3))) {
        j = bfhm.a(paramCharSequence.subSequence(paramInt3, paramInt3 + 2).toString());
      }
      for (int i = 2;; i = 1)
      {
        paramInt4 -= j;
        if (paramInt4 < 0) {
          break label257;
        }
        paramInt3 = i + paramInt3;
        break;
        j = bfhm.a(String.valueOf(paramCharSequence.charAt(paramInt3)));
      }
    }
    label257:
    if (paramInt3 == paramInt1) {
      return "";
    }
    return paramCharSequence.subSequence(paramInt1, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfcr
 * JD-Core Version:    0.7.0.1
 */