package com.tencent.hippy.qq.adapter;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;

public class HippyQQFontAdapter
  implements HippyFontScaleAdapter
{
  private StringBuilder decodeEmojiFromString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      if (paramString.charAt(i) == '\024')
      {
        int k = i + 2;
        if (k < paramString.length())
        {
          int j = i + 1;
          k = (paramString.charAt(j) - 'A') * 128 + paramString.charAt(k) - 65;
          if (k >= 0)
          {
            k = QQSysFaceUtil.convertToLocal(k);
            if (k >= 0)
            {
              localStringBuilder.append(paramString.charAt(i));
              localStringBuilder.append((char)k);
            }
          }
          i = j + 1;
          break label126;
        }
      }
      localStringBuilder.append(paramString.charAt(i));
      label126:
      i += 1;
    }
    return localStringBuilder;
  }
  
  public CharSequence getEmoticonText(CharSequence paramCharSequence, int paramInt)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return "";
    }
    paramCharSequence = decodeEmojiFromString(paramCharSequence.toString());
    double d = paramInt;
    Double.isNaN(d);
    return new QQText(paramCharSequence, 2, (int)(d / 2.5D));
  }
  
  public float getFontScale()
  {
    return 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQFontAdapter
 * JD-Core Version:    0.7.0.1
 */