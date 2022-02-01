package com.tencent.mobileqq.app.automator;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class TimerChecker
  extends LinearGroup
{
  public void onCreate()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = StepFactory.jdField_a_of_type_ArrayOfInt;
    StringBuilder localStringBuilder1 = new StringBuilder("{");
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = this.mAutomator.a;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("LAST_UPDATE_TIME_PRE_");
      localStringBuilder2.append(localObject1[i]);
      if ((Math.abs(l - ((SharedPreferences)localObject2).getLong(localStringBuilder2.toString(), 0L)) >= localObject1[i] * 60 * 60 * 1000) && (StepFactory.jdField_a_of_type_ArrayOfJavaLangString[i].length() > 2))
      {
        localStringBuilder1.append(StepFactory.jdField_a_of_type_ArrayOfJavaLangString[i]);
        localStringBuilder1.append(',');
        localObject2 = this.mAutomator.a.edit();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("LAST_UPDATE_TIME_PRE_");
        localStringBuilder2.append(localObject1[i]);
        ((SharedPreferences.Editor)localObject2).putLong(localStringBuilder2.toString(), l).commit();
      }
      i += 1;
    }
    localObject1 = localStringBuilder1.toString();
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(((String)localObject1).substring(0, ((String)localObject1).length() - 1));
    localStringBuilder1.append("}");
    this.a = localStringBuilder1.toString();
    super.onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.TimerChecker
 * JD-Core Version:    0.7.0.1
 */