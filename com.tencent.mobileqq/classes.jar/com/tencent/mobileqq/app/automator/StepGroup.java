package com.tencent.mobileqq.app.automator;

import aklc;

public class StepGroup
  extends AsyncStep
{
  protected AsyncStep[] a;
  protected String[] a;
  public String b;
  public int e;
  
  private String a(String paramString)
  {
    Object localObject = paramString.toCharArray();
    int n = localObject.length;
    int j;
    int i1;
    int k;
    if (localObject[0] == '{')
    {
      j = 125;
      i1 = localObject[0];
      k = 0;
    }
    int i;
    for (int m = 0;; m = i)
    {
      if (k >= n) {
        break label147;
      }
      if (localObject[k] == i1) {
        i = m + 1;
      }
      for (;;)
      {
        if (i != 0) {
          break label135;
        }
        localObject = paramString.substring(0, k + 1);
        do
        {
          return localObject;
          if (localObject[0] == '[')
          {
            j = 93;
            break;
          }
          localObject = paramString;
        } while (paramString.indexOf(",") == -1);
        return paramString.substring(0, paramString.indexOf(","));
        i = m;
        if (localObject[k] == j) {
          i = m - 1;
        }
      }
      label135:
      k += 1;
    }
    label147:
    return "";
  }
  
  private String[] a(String paramString)
  {
    int i = 0;
    if (paramString.length() <= 2) {
      return new String[0];
    }
    String str2 = paramString.substring(1, paramString.length() - 1);
    int k = str2.length();
    StringBuilder localStringBuilder = new StringBuilder(50);
    for (paramString = str2; i < k; paramString = str2.substring(i, k))
    {
      int j = i;
      String str1 = paramString;
      if (paramString.startsWith(","))
      {
        j = i + 1;
        str1 = str2.substring(j, k);
      }
      paramString = a(str1);
      localStringBuilder.append(paramString).append("-");
      i = j + paramString.length();
    }
    return localStringBuilder.toString().split("-");
  }
  
  public AsyncStep a()
  {
    if (this.e < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep[this.e] = aklc.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator, this.jdField_a_of_type_ArrayOfJavaLangString[this.e]);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep[this.e].jdField_a_of_type_ArrayOfJavaLangObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
      AsyncStep[] arrayOfAsyncStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep;
      int i = this.e;
      this.e = (i + 1);
      return arrayOfAsyncStep[i];
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Long = 2147483647L;
    this.jdField_a_of_type_ArrayOfJavaLangString = a(this.jdField_b_of_type_JavaLangString);
    this.e = 0;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep = new AsyncStep[this.jdField_a_of_type_ArrayOfJavaLangString.length];
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 4) {
      super.a(paramInt);
    }
    AsyncStep[] arrayOfAsyncStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep;
    int j;
    int i;
    if (((paramInt == 8) || (paramInt == 4)) && (arrayOfAsyncStep != null))
    {
      j = arrayOfAsyncStep.length;
      i = 0;
    }
    for (;;)
    {
      AsyncStep localAsyncStep;
      if (i < j)
      {
        localAsyncStep = arrayOfAsyncStep[i];
        if (localAsyncStep != null) {}
      }
      else
      {
        return;
      }
      localAsyncStep.a(paramInt);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.StepGroup
 * JD-Core Version:    0.7.0.1
 */