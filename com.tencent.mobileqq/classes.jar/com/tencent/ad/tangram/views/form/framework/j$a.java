package com.tencent.ad.tangram.views.form.framework;

import com.tencent.ad.tangram.net.AdHttp.Params;

class j$a
  extends AdHttp.Params
{
  public static final int RETURN_CODE_ERROR_DUPLICATE = 4;
  public static final int RETURN_CODE_ERROR_INVALID_FORM = 1;
  public static final int RETURN_CODE_ERROR_INVALID_PARAM = 3;
  public static final int RETURN_CODE_ERROR_TOKEN = 2;
  public static final int RETURN_CODE_SUCCESS = 0;
  public int returnCode = -2147483648;
  
  public boolean isSuccess()
  {
    return (super.isSuccess()) && (this.responseData != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.framework.j.a
 * JD-Core Version:    0.7.0.1
 */