package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.secure.android.common.ssl.SecureX509SingleInstance;
import java.io.InputStream;

public class d
  extends AsyncTask<Context, Integer, InputStream>
{
  private static final String TAG = d.class.getSimpleName();
  
  protected InputStream a(Context... paramVarArgs)
  {
    Object localObject = null;
    long l = System.currentTimeMillis();
    try
    {
      paramVarArgs = BksUtil.getBksFromTss(paramVarArgs[0]);
      g.b(TAG, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - l) + " ms");
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        g.e(TAG, "doInBackground: exception : " + paramVarArgs.getMessage());
        paramVarArgs = localObject;
      }
    }
  }
  
  protected void a(Integer... paramVarArgs)
  {
    g.c(TAG, "onProgressUpdate: current thread name is : " + Thread.currentThread().getName());
  }
  
  protected void b(InputStream paramInputStream)
  {
    g.b(TAG, "onPostExecute: current thread name is : " + Thread.currentThread().getName());
    if (paramInputStream == null)
    {
      g.e(TAG, "get bks from tss error , result is null");
      return;
    }
    SecureX509SingleInstance.updateBks(paramInputStream);
  }
  
  protected void onPreExecute()
  {
    g.b(TAG, "onPreExecute: current thread name is : " + Thread.currentThread().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.d
 * JD-Core Version:    0.7.0.1
 */