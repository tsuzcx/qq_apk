package com.tencent.hippy.qq.adapter;

import android.text.TextUtils;
import asle;
import begp;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;

public class HippyQQFontAdapter
  implements HippyFontScaleAdapter
{
  private StringBuilder decodeEmojiFromString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if ((paramString.charAt(i) == '\024') && (i + 2 < paramString.length()))
      {
        int j = asle.b((paramString.charAt(i + 1) - 'A') * 128 + paramString.charAt(i + 2) - 65);
        if (j >= 0)
        {
          localStringBuilder.append(paramString.charAt(i));
          localStringBuilder.append((char)j);
        }
        i = i + 1 + 1;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder;
  }
  
  public CharSequence getEmoticonText(CharSequence paramCharSequence, int paramInt)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return "";
    }
    return new begp(decodeEmojiFromString(paramCharSequence.toString()), 2, (int)(paramInt / 2.5D));
  }
  
  public float getFontScale()
  {
    return 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQFontAdapter
 * JD-Core Version:    0.7.0.1
 */