package com.tencent.av.chatroom;

import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ChatRoomUtil
{
  public static int a;
  
  public static QQText a(String paramString, int paramInt)
  {
    return new QQText(a(paramString), 3, paramInt);
  }
  
  public static String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < EmotcationConstants.SYS_EMOTICON_SYMBOL.length))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('\024');
      localStringBuilder.append(EmotcationConstants.SYS_EMOTICON_SYMBOL[paramInt]);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String a(QQTextBuilder paramQQTextBuilder)
  {
    if (paramQQTextBuilder == null) {
      return null;
    }
    int i = paramQQTextBuilder.length();
    Object localObject1 = new char[i];
    int j = 0;
    paramQQTextBuilder.getChars(0, i, (char[])localObject1, 0);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject2 = (EmoticonSpan[])paramQQTextBuilder.getSpans(0, i, EmoticonSpan.class);
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append((char[])localObject1);
      localObject1 = new ArrayList(localObject2.length);
      i = 0;
      Object localObject3;
      while (i < localObject2.length)
      {
        localObject3 = localObject2[i];
        if (localObject3 != null) {
          ((ArrayList)localObject1).add(EmotionData.a((EmoticonSpan)localObject3, paramQQTextBuilder.getSpanStart(localObject3), paramQQTextBuilder.getSpanEnd(localObject3)));
        }
        i += 1;
      }
      Collections.sort((List)localObject1, EmotionData.e);
      localObject2 = ((ArrayList)localObject1).iterator();
      for (i = j; ((Iterator)localObject2).hasNext(); i = j)
      {
        localObject3 = (EmotionData)((Iterator)localObject2).next();
        paramQQTextBuilder = ((EmotionData)localObject3).a;
        int k = ((EmotionData)localObject3).b;
        j = ((EmotionData)localObject3).c;
        int m = paramQQTextBuilder.emojiType;
        if (m != 1)
        {
          if (m != 2)
          {
            paramQQTextBuilder = localStringBuilder2.substring(k, j);
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append('\024');
            ((StringBuilder)localObject3).append(paramQQTextBuilder.getDescription());
            paramQQTextBuilder = ((StringBuilder)localObject3).toString();
          }
        }
        else {
          paramQQTextBuilder = a(paramQQTextBuilder.index & 0x7FFFFFFF);
        }
        if (i < k) {
          localStringBuilder1.append(localStringBuilder2.substring(i, k));
        }
        localStringBuilder1.append(paramQQTextBuilder);
      }
      if (i < localStringBuilder2.length()) {
        localStringBuilder1.append(localStringBuilder2.substring(i));
      }
      EmotionData.a((List)localObject1);
    }
    else
    {
      localStringBuilder1.append((char[])localObject1);
    }
    return localStringBuilder1.toString();
  }
  
  public static String a(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.indexOf("/") == -1) {
      return paramString;
    }
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      Object localObject1 = paramString;
      Object localObject2 = paramString;
      try
      {
        String str;
        if (i < EmotcationConstants.SYS_EMOTICON_SYMBOL.length)
        {
          localObject2 = paramString;
          localObject1 = new StringBuilder();
          localObject2 = paramString;
          ((StringBuilder)localObject1).append('\024');
          localObject2 = paramString;
          ((StringBuilder)localObject1).append(EmotcationConstants.SYS_EMOTICON_SYMBOL[i]);
          localObject2 = paramString;
          str = ((StringBuilder)localObject1).toString();
          localObject2 = paramString;
          localObject1 = paramString;
          if (paramString.indexOf(str) != -1)
          {
            localObject2 = paramString;
            localObject1 = paramString.replace(str, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i));
          }
        }
        else
        {
          for (;;)
          {
            localObject2 = localObject1;
            paramString = (String)localObject1;
            if (j >= EmotcationConstants.SYS_EMOTICON_SYMBOL.length) {
              break;
            }
            localObject2 = localObject1;
            str = EmotcationConstants.SYS_EMOTICON_SYMBOL[j];
            paramString = (String)localObject1;
            localObject2 = localObject1;
            if (((String)localObject1).indexOf(str) != -1)
            {
              localObject2 = localObject1;
              paramString = ((String)localObject1).replace(str, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(j));
            }
            j += 1;
            localObject1 = paramString;
          }
          return paramString;
        }
      }
      catch (Exception localException)
      {
        paramString = (String)localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("ChatRoomUtil", 2, "convertMsg exception", localException);
          paramString = (String)localObject2;
        }
      }
      i += 1;
      paramString = localException;
    }
  }
  
  public static void b(String paramString)
  {
    int i = SessionMgr.a().b().g;
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, String.format("doReport, tag[%s], fromType[%s]", new Object[] { paramString, Integer.valueOf(i) }));
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.chatroom.ChatRoomUtil
 * JD-Core Version:    0.7.0.1
 */