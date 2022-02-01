package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;

public class e
  extends AsyncTask<Context, Integer, Boolean>
{
  private static final String a = "e";
  
  protected Boolean a(Context... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    try
    {
      paramVarArgs = BksUtil.getBksFromTss(paramVarArgs[0]);
    }
    catch (Exception paramVarArgs)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doInBackground: exception : ");
      localStringBuilder.append(paramVarArgs.getMessage());
      g.b(str, localStringBuilder.toString());
      paramVarArgs = null;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doInBackground: get bks from hms tss cost : ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    localStringBuilder.append(" ms");
    g.a(str, localStringBuilder.toString());
    if (paramVarArgs != null)
    {
      f.a(paramVarArgs);
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      g.c(a, "onPostExecute: upate done");
      return;
    }
    g.b(a, "onPostExecute: upate failed");
  }
  
  protected void a(Integer... paramVarArgs)
  {
    g.c(a, "onProgressUpdate");
  }
  
  protected void onPreExecute()
  {
    g.a(a, "onPreExecute");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.e
 * JD-Core Version:    0.7.0.1
 */