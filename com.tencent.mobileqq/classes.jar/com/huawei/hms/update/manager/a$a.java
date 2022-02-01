package com.huawei.hms.update.manager;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.hms.support.log.HMSLog;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.HttpsURLConnection;

class a$a
  extends AsyncTask<Context, Integer, Boolean>
{
  private String b;
  
  public a$a(a parama, String paramString)
  {
    this.b = paramString;
  }
  
  protected Boolean a(Context... paramVarArgs)
  {
    bool = false;
    try
    {
      paramVarArgs = (HttpsURLConnection)new URL(this.b).openConnection();
      if (paramVarArgs == null) {
        break label138;
      }
      paramVarArgs.setRequestMethod("GET");
      paramVarArgs.setConnectTimeout(30000);
      paramVarArgs.setReadTimeout(30000);
      paramVarArgs.setUseCaches(false);
      paramVarArgs.setInstanceFollowRedirects(true);
      int i = paramVarArgs.getResponseCode();
      HMSLog.i("PingTask", "GET google result:" + i);
      bool = true;
    }
    catch (RuntimeException paramVarArgs)
    {
      for (;;)
      {
        HMSLog.e("PingTask", "GET google result:RuntimeException");
      }
    }
    catch (IOException paramVarArgs)
    {
      for (;;)
      {
        HMSLog.e("PingTask", "GET google result:safe exception");
      }
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        HMSLog.e("PingTask", "GET google result:Exception");
        continue;
        bool = false;
      }
    }
    a.a(bool);
    a.a(this.a).countDown();
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.manager.a.a
 * JD-Core Version:    0.7.0.1
 */