package com.tencent.ad.tangram.util;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.AdError;

@Keep
public class AdClickUtil$Result
{
  public int action = 0;
  private AdError error = new AdError(1);
  public boolean errorHandled = false;
  public int urlType = 0;
  
  public AdClickUtil$Result(int paramInt1, int paramInt2)
  {
    this.error = new AdError(paramInt1);
    this.action = paramInt2;
  }
  
  public AdClickUtil$Result(AdError paramAdError, int paramInt)
  {
    this.error = paramAdError;
    this.action = paramInt;
  }
  
  public int getErrorCode()
  {
    if (this.error != null) {
      return this.error.getErrorCode();
    }
    return 1;
  }
  
  public boolean isSuccess()
  {
    return getErrorCode() == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdClickUtil.Result
 * JD-Core Version:    0.7.0.1
 */