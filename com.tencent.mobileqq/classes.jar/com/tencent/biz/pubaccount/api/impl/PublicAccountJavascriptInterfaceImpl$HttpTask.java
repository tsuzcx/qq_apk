package com.tencent.biz.pubaccount.api.impl;

import android.os.AsyncTask;
import com.tencent.biz.common.util.Util;

public class PublicAccountJavascriptInterfaceImpl$HttpTask
  extends AsyncTask<String, Integer, String>
{
  String a;
  
  protected String a(String... paramVarArgs)
  {
    if (super.isCancelled()) {
      return null;
    }
    return this.b.httpRequest(paramVarArgs[0], paramVarArgs[1]);
  }
  
  protected void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "{\"r\" : \"-100\"}";
    }
    this.b.callJs("clientCallback", new String[] { Util.c(str), Util.c(this.a) });
  }
  
  protected void a(Integer... paramVarArgs) {}
  
  protected void onCancelled()
  {
    super.onCancelled();
  }
  
  protected void onPreExecute() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.HttpTask
 * JD-Core Version:    0.7.0.1
 */