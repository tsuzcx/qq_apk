package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import android.util.Log;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.FileUtil;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.showview.LoadToPlayInter;
import java.util.HashMap;
import org.json.JSONObject;

class LottieView$3
  implements Runnable
{
  LottieView$3(LottieView paramLottieView, String paramString, LoadToPlayInter paramLoadToPlayInter) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(FileUtil.readString(this.val$playConfigFilePath)).getJSONObject("starframe");
      if (localJSONObject == null) {
        break label189;
      }
      i = localJSONObject.getInt("starframe");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LottieView.access$400(this.this$0).getLogger().e(LottieView.access$200(this.this$0), " e =" + localException.toString(), new Object[0]);
        localException.printStackTrace();
        continue;
        label189:
        int i = 0;
      }
    }
    LottieView.access$102(this.this$0, (int)(i * 1.0F / 30.0F + 0.5F) * 1000000);
    Log.e(LottieView.access$200(this.this$0), "t=" + LottieView.access$100(this.this$0));
    LottieView.access$300(this.this$0).put(this.val$playConfigFilePath, Integer.valueOf(LottieView.access$100(this.this$0)));
    if (this.val$loadToPlayInter != null) {
      this.val$loadToPlayInter.onPrepareStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.LottieView.3
 * JD-Core Version:    0.7.0.1
 */