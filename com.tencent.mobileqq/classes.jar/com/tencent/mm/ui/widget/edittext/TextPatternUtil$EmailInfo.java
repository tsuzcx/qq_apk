package com.tencent.mm.ui.widget.edittext;

import java.util.Iterator;
import java.util.List;

public class TextPatternUtil$EmailInfo
{
  int a;
  String b;
  int c;
  
  TextPatternUtil$EmailInfo(int paramInt1, int paramInt2, String paramString)
  {
    this.c = paramInt1;
    this.a = paramInt2;
    this.b = paramString;
  }
  
  public boolean isContainedIn(String paramString)
  {
    String str = this.b;
    if ((str != null) && (paramString != null))
    {
      str = str.toLowerCase();
      paramString = paramString.toLowerCase();
      if (str.equals(paramString)) {
        return true;
      }
      return paramString.contains(str);
    }
    return false;
  }
  
  public boolean isInList(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (isContainedIn((String)paramList.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EmailInfo{start = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", email = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.TextPatternUtil.EmailInfo
 * JD-Core Version:    0.7.0.1
 */