package com.tencent.biz.pubaccount.readinjoy.viola;

import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.LoadAsyBack;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;

class ViolaAccessHelper$7$1
  implements Runnable
{
  ViolaAccessHelper$7$1(ViolaAccessHelper.7 param7, String paramString) {}
  
  public void run()
  {
    try
    {
      this.this$0.a.a(FileUtils.b(new File(this.a)));
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.7.1
 * JD-Core Version:    0.7.0.1
 */