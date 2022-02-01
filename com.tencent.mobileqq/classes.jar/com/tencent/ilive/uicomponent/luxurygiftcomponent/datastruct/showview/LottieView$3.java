package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import android.util.Log;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.lottie.LoadToPlayInter;
import com.tencent.falco.utils.FileUtil;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import java.util.HashMap;
import org.json.JSONObject;

class LottieView$3
  implements Runnable
{
  LottieView$3(LottieView paramLottieView, String paramString, LoadToPlayInter paramLoadToPlayInter) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(FileUtil.readString(this.val$playConfigFilePath)).getJSONObject("starframe");
        if (localObject1 == null) {
          break label215;
        }
        i = ((JSONObject)localObject1).getInt("starframe");
        LottieView.access$102(this.this$0, (int)(i * 1.0F / 30.0F + 0.5F) * 1000000);
        localObject1 = LottieView.access$200(this.this$0);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("t=");
        ((StringBuilder)localObject2).append(LottieView.access$100(this.this$0));
        Log.e((String)localObject1, ((StringBuilder)localObject2).toString());
        LottieView.access$300(this.this$0).put(this.val$playConfigFilePath, Integer.valueOf(LottieView.access$100(this.this$0)));
      }
      catch (Exception localException)
      {
        Object localObject2 = LottieView.access$400(this.this$0).getLogger();
        String str = LottieView.access$200(this.this$0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" e =");
        localStringBuilder.append(localException.toString());
        ((LogInterface)localObject2).e(str, localStringBuilder.toString(), new Object[0]);
        localException.printStackTrace();
      }
      LoadToPlayInter localLoadToPlayInter = this.val$loadToPlayInter;
      if (localLoadToPlayInter != null) {
        localLoadToPlayInter.onPrepareStart();
      }
      return;
      label215:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.LottieView.3
 * JD-Core Version:    0.7.0.1
 */