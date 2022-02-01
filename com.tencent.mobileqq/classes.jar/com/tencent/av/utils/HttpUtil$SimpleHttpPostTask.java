package com.tencent.av.utils;

import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.client.ClientProtocolException;

public class HttpUtil$SimpleHttpPostTask
  extends AsyncTask<Void, Void, String>
{
  String a;
  String b;
  String c;
  
  public HttpUtil$SimpleHttpPostTask(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  protected String a(Void... paramVarArgs)
  {
    paramVarArgs = null;
    Object localObject1 = null;
    Object localObject2;
    try
    {
      String str = HttpUtil.a(this.a, this.b, this.c);
      localObject1 = str;
      paramVarArgs = str;
      localObject2 = str;
      if (QLog.isColorLevel())
      {
        localObject1 = str;
        paramVarArgs = str;
        localObject2 = new StringBuilder();
        localObject1 = str;
        paramVarArgs = str;
        ((StringBuilder)localObject2).append("SimpleHttpPostTask rsp = ");
        localObject1 = str;
        paramVarArgs = str;
        ((StringBuilder)localObject2).append(str);
        localObject1 = str;
        paramVarArgs = str;
        QLog.i("SimpleHttpPostTask", 2, ((StringBuilder)localObject2).toString());
        return str;
      }
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
      return localObject1;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      localClientProtocolException.printStackTrace();
      localObject2 = paramVarArgs;
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.HttpUtil.SimpleHttpPostTask
 * JD-Core Version:    0.7.0.1
 */