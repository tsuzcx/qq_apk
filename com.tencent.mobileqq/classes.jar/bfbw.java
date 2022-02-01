import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.troop.activity.TroopNickRuleFragment;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bfbw
  implements InputFilter
{
  Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[🀀-🏿]|[🐀-🟿]|[☀-⟿]", 66);
  
  public bfbw(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramCharSequence).find()) {
      return "";
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbw
 * JD-Core Version:    0.7.0.1
 */