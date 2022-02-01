package com.tencent.biz.pubaccount.api.impl;

import android.os.AsyncTask;
import com.tencent.biz.common.util.Util;

public class PublicAccountJavascriptInterfaceImpl$HttpTask
  extends AsyncTask<String, Integer, String>
{
  String jdField_a_of_type_JavaLangString;
  
  protected String a(String... paramVarArgs)
  {
    if (super.isCancelled()) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.httpRequest(paramVarArgs[0], paramVarArgs[1]);
  }
  
  protected void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "{\"r\" : \"-100\"}";
    }
    this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.callJs("clientCallback", new String[] { Util.a(str), Util.a(this.jdField_a_of_type_JavaLangString) });
  }
  
  protected void a(Integer... paramVarArgs) {}
  
  protected void onCancelled()
  {
    super.onCancelled();
  }
  
  protected void onPreExecute() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.HttpTask
 * JD-Core Version:    0.7.0.1
 */