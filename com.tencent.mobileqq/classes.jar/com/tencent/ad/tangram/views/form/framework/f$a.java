package com.tencent.ad.tangram.views.form.framework;

import com.tencent.ad.tangram.net.AdHttp.Params;

class f$a
  extends AdHttp.Params
{
  public int returnCode = -2147483648;
  
  public boolean isSuccess()
  {
    return (super.isSuccess()) && (this.responseData != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.framework.f.a
 * JD-Core Version:    0.7.0.1
 */