package com.tencent.mobileqq.activity.messagesearch;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class MessageItem
{
  public static String a;
  public MessageRecord b;
  
  public MessageItem(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("MessageItem, messageRecord.senderuin = ");
      paramQQAppInterface.append(paramMessageRecord.senderuin);
      QLog.i("MessageItem", 2, paramQQAppInterface.toString());
    }
    this.b = paramMessageRecord;
  }
  
  public static String a(CharSequence paramCharSequence)
  {
    paramCharSequence = new StringBuilder(paramCharSequence);
    int m = paramCharSequence.length();
    int j;
    for (int i = 0; i < paramCharSequence.length(); i = j + 1)
    {
      int k = paramCharSequence.codePointAt(i);
      if ((k == 20) && (i < m - 1))
      {
        k = i + 1;
        j = i;
        if (paramCharSequence.charAt(k) < EmotcationConstants.VALID_SYS_EMOTCATION_COUNT)
        {
          paramCharSequence.replace(i, i + 2, "\001\001");
          j = k;
        }
      }
      else
      {
        j = i;
        if (EmotcationConstants.EMOJI_MAP.get(k, -1) >= 0)
        {
          if (k > 65535)
          {
            j = i + 2;
            if (m >= j)
            {
              paramCharSequence.replace(i, j, "\001\001");
              j = i;
              continue;
            }
          }
          paramCharSequence.replace(i, i + 1, "\001");
          j = i;
        }
      }
    }
    return paramCharSequence.toString();
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setKeyword, keyword = ");
      localStringBuilder.append(paramString);
      QLog.i("MessageItem", 2, localStringBuilder.toString());
    }
    if ((paramString != null) && (paramString.length() > 0)) {
      a = paramString.toLowerCase(Locale.US);
    }
  }
  
  public CharSequence a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return "";
    }
    paramString = new QQText(b(paramString), 3, 16);
    a(paramString, paramInt);
    return paramString;
  }
  
  public String a(long paramLong)
  {
    return TimeFormatterUtils.a(paramLong * 1000L, true, "yyyy-MM-dd");
  }
  
  public void a(Spannable paramSpannable, int paramInt)
  {
    String str = a(paramSpannable.toString()).toString().toLowerCase(Locale.US);
    int k = a.length();
    int m = paramSpannable.length();
    int i = 0;
    int j = 0;
    String[] arrayOfString = (String[])paramSpannable.getSpans(0, m, String.class);
    if (arrayOfString != null)
    {
      m = arrayOfString.length;
      i = 0;
      while (j < m)
      {
        if ("...".equals(arrayOfString[j])) {
          i = 3;
        }
        j += 1;
      }
    }
    do
    {
      j = str.indexOf(a, i);
      if ((j >= 0) && (j < str.length()))
      {
        i = j + k;
        paramSpannable.setSpan(new ForegroundColorSpan(paramInt), j, i, 33);
        j = i;
      }
      if (j < 0) {
        break;
      }
      i = j;
    } while (j < str.length());
  }
  
  public SpannableString b(String paramString)
  {
    int i = a(paramString).toLowerCase(Locale.US).indexOf(a);
    if (i > 20)
    {
      int j = i - 20;
      int k = paramString.codePointAt(j - 1);
      if (k != 20)
      {
        i = j;
        if (EmotcationConstants.EMOJI_MAP.get(k, -1) >= 0)
        {
          i = j;
          if (k <= 65535) {}
        }
      }
      else
      {
        i = j + 1;
      }
      StringBuilder localStringBuilder = new StringBuilder(paramString.length());
      localStringBuilder.append("...");
      localStringBuilder.append(paramString.substring(i));
      paramString = new SpannableString(localStringBuilder.toString());
      paramString.setSpan("...", 0, 3, 33);
      return paramString;
    }
    return new SpannableString(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uniseq = ");
    localStringBuilder.append(this.b.uniseq);
    localStringBuilder.append(", msg = ");
    localStringBuilder.append(this.b.msg);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageItem
 * JD-Core Version:    0.7.0.1
 */