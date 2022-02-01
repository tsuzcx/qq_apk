package com.tencent.mobileqq.activity.editservice;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditTroopMemberNickService$EmojiFilter
  implements InputFilter
{
  Pattern a = Pattern.compile("[🀀-🏿]|[🐀-🟿]|[☀-⟿]", 66);
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (this.a.matcher(paramCharSequence).find()) {
      return "";
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.EmojiFilter
 * JD-Core Version:    0.7.0.1
 */