package com.tencent.biz.common.util;

import android.os.AsyncTask;
import android.text.TextUtils;

final class CommUtils$1
  extends AsyncTask<Void, Void, Void>
{
  String jdField_a_of_type_JavaLangString = "";
  
  CommUtils$1(CommUtils.IHttpGetString paramIHttpGetString, String paramString) {}
  
  protected Void a(Void... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangString = CommUtils.a(this.b);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentBizCommonUtilCommUtils$IHttpGetString.a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizCommonUtilCommUtils$IHttpGetString.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.CommUtils.1
 * JD-Core Version:    0.7.0.1
 */