package com.tencent.mobileqq.app.automator;

public class StepGroup
  extends AsyncStep
{
  protected AsyncStep[] b;
  public String c;
  public int d;
  protected String[] e;
  
  private String[] a(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    if (j <= 2) {
      return new String[0];
    }
    String str2 = paramString.substring(1, paramString.length() - 1);
    int k = str2.length();
    StringBuilder localStringBuilder = new StringBuilder(50);
    for (paramString = str2; i < k; paramString = str2.substring(i, k))
    {
      j = i;
      String str1 = paramString;
      if (paramString.startsWith(","))
      {
        j = i + 1;
        str1 = str2.substring(j, k);
      }
      paramString = b(str1);
      localStringBuilder.append(paramString);
      localStringBuilder.append("-");
      i = j + paramString.length();
    }
    return localStringBuilder.toString().split("-");
  }
  
  private String b(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int n = arrayOfChar.length;
    int j;
    if (arrayOfChar[0] == '{')
    {
      j = 125;
    }
    else
    {
      if (arrayOfChar[0] != '[') {
        break label121;
      }
      j = 93;
    }
    int i1 = arrayOfChar[0];
    int k = 0;
    int i;
    for (int m = 0; k < n; m = i)
    {
      if (arrayOfChar[k] == i1)
      {
        i = m + 1;
      }
      else
      {
        i = m;
        if (arrayOfChar[k] == j) {
          i = m - 1;
        }
      }
      if (i == 0) {
        return paramString.substring(0, k + 1);
      }
      k += 1;
    }
    return "";
    label121:
    if (paramString.indexOf(",") == -1) {
      return paramString;
    }
    return paramString.substring(0, paramString.indexOf(","));
  }
  
  public AsyncStep a()
  {
    int i = this.d;
    if (i < this.e.length)
    {
      this.b[i] = StepFactory.a(this.mAutomator, this.e[this.d]);
      this.b[this.d].mParams = this.mParams;
      AsyncStep[] arrayOfAsyncStep = this.b;
      i = this.d;
      this.d = (i + 1);
      return arrayOfAsyncStep[i];
    }
    return null;
  }
  
  public void onCreate()
  {
    this.mTimeout = 2147483647L;
    this.e = a(this.c);
    this.d = 0;
    this.b = new AsyncStep[this.e.length];
  }
  
  public void setResult(int paramInt)
  {
    if (paramInt != 4) {
      super.setResult(paramInt);
    }
    AsyncStep[] arrayOfAsyncStep = this.b;
    if (((paramInt == 8) || (paramInt == 4)) && (arrayOfAsyncStep != null))
    {
      int j = arrayOfAsyncStep.length;
      int i = 0;
      while (i < j)
      {
        AsyncStep localAsyncStep = arrayOfAsyncStep[i];
        if (localAsyncStep == null) {
          return;
        }
        localAsyncStep.setResult(paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.StepGroup
 * JD-Core Version:    0.7.0.1
 */