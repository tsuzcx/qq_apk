package com.tencent.aelight.camera.aeeditor.module.debug;

import android.widget.TextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DebugInfoPart
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  
  private String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("调试信息：\n");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(str);
      localStringBuilder2.append("：");
      localStringBuilder2.append((String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
      localStringBuilder2.append("\n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
    paramString1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramString1 != null) {
      paramString1.setText(a());
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length / 2)
    {
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      int j = i * 2;
      localHashMap.put(paramArrayOfString[j], paramArrayOfString[(j + 1)]);
      i += 1;
    }
    paramArrayOfString = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramArrayOfString != null) {
      paramArrayOfString.setText(a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.debug.DebugInfoPart
 * JD-Core Version:    0.7.0.1
 */