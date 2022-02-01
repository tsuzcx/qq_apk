package com.tencent.biz.common.util;

import android.os.AsyncTask;
import android.text.TextUtils;

final class CommUtils$1
  extends AsyncTask<Void, Void, Void>
{
  String a = "";
  
  CommUtils$1(CommUtils.IHttpGetString paramIHttpGetString, String paramString) {}
  
  protected Void a(Void... paramVarArgs)
  {
    this.a = CommUtils.a(this.c);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    if (TextUtils.isEmpty(this.a))
    {
      this.b.a();
      return;
    }
    this.b.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.CommUtils.1
 * JD-Core Version:    0.7.0.1
 */