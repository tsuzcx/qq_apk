package com.tencent.biz.pubaccount.readinjoy.viola;

import bace;
import java.io.File;
import java.io.IOException;
import rnl;

class ViolaAccessHelper$6$1
  implements Runnable
{
  ViolaAccessHelper$6$1(ViolaAccessHelper.6 param6, String paramString) {}
  
  public void run()
  {
    try
    {
      this.this$0.a.a(bace.b(new File(this.a)));
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.6.1
 * JD-Core Version:    0.7.0.1
 */