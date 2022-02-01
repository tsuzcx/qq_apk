package com.tencent.mm.ui.widget.edittext;

import android.text.TextUtils;
import android.util.Patterns;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextPatternUtil
{
  private static final Pattern a = Patterns.EMAIL_ADDRESS;
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= paramInt2) && (paramInt1 <= paramInt3);
  }
  
  public static TextPatternUtil.EmailInfo findEmailAtPos(String paramString, int paramInt)
  {
    int j = paramInt - 256;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    int k = paramInt + 256;
    j = k;
    if (k > paramString.length()) {
      j = paramString.length();
    }
    paramString = getEmailList(i, paramInt, paramString.substring(i, j));
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        TextPatternUtil.EmailInfo localEmailInfo = (TextPatternUtil.EmailInfo)paramString.next();
        if (a(paramInt, localEmailInfo.c, localEmailInfo.c + localEmailInfo.b.length())) {
          return localEmailInfo;
        }
      }
    }
    return null;
  }
  
  public static List<TextPatternUtil.EmailInfo> getEmailList(int paramInt1, int paramInt2, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ArrayList();
    }
    Object localObject = null;
    Matcher localMatcher = a.matcher(paramString);
    while (localMatcher.find())
    {
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = new ArrayList();
      }
      String str = localMatcher.group();
      localObject = paramString.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((TextPatternUtil.EmailInfo)((Iterator)localObject).next()).isContainedIn(str))
        {
          i = 1;
          break label99;
        }
      }
      int i = 0;
      label99:
      localObject = paramString;
      if (i == 0)
      {
        paramString.add(new TextPatternUtil.EmailInfo(localMatcher.start() + paramInt1, paramInt2, str));
        localObject = paramString;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.TextPatternUtil
 * JD-Core Version:    0.7.0.1
 */