package com.tencent.aelight.camera.aeeditor.module.debug;

import android.widget.TextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DebugInfoPart
{
  private HashMap<String, String> a;
  private TextView b;
  
  private String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("调试信息：\n");
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(str);
      localStringBuilder2.append("：");
      localStringBuilder2.append((String)this.a.get(str));
      localStringBuilder2.append("\n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.put(paramString1, paramString2);
    paramString1 = this.b;
    if (paramString1 != null) {
      paramString1.setText(a());
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length / 2)
    {
      HashMap localHashMap = this.a;
      int j = i * 2;
      localHashMap.put(paramArrayOfString[j], paramArrayOfString[(j + 1)]);
      i += 1;
    }
    paramArrayOfString = this.b;
    if (paramArrayOfString != null) {
      paramArrayOfString.setText(a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.debug.DebugInfoPart
 * JD-Core Version:    0.7.0.1
 */