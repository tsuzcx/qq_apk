package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class DrawClassifier$1
  implements Runnable
{
  DrawClassifier$1(MessageForQQWalletMsg paramMessageForQQWalletMsg) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("DrawClassifier", 2, "tryPreDownLoadModel");
        }
        String str2 = this.a.mQQWalletRedPacketMsg.body.feedId;
        localObject3 = BaseHbFragment.getHbPannelConfig(10);
        String str1 = "";
        if (localObject3 == null) {
          break label201;
        }
        if (!TextUtils.isEmpty(str2))
        {
          localObject2 = ((JSONObject)localObject3).optString("aModelPrefix", "https://i.gtimg.cn/drawrp/aModel_");
          localObject3 = DrawClassifier.a((JSONObject)localObject3, str2);
          if (localObject3 == null) {
            break label213;
          }
          str1 = ((JSONObject)localObject3).optString("aMd5");
          break label213;
          if (!TextUtils.isEmpty(str2))
          {
            if (TextUtils.isEmpty(((String)localObject2).trim()))
            {
              str1 = "https://i.gtimg.cn/drawrp/aModel_";
              str1 = str1 + str2 + ".zip";
            }
          }
          else
          {
            localObject2 = new DownloadParam();
            ((DownloadParam)localObject2).filePos = 1;
            ((DownloadParam)localObject2).url = str1;
            ((DownloadParam)localObject2).md5 = ((String)localObject3);
            ((DownloadParam)localObject2).useQWalletConfig = true;
            PreloadStaticApi.a().getResPath((DownloadParam)localObject2, new DrawClassifier.1.1(this));
          }
        }
        else
        {
          str1 = ((JSONObject)localObject3).optString("aModel", "https://i.gtimg.cn/channel/imglib/201907/upload_e119bb8768152fcb2476c5c41b896cf2.zip");
          localObject2 = "";
          localObject3 = "";
          continue;
        }
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      continue;
      label201:
      Object localObject2 = "";
      Object localObject3 = "";
      Object localObject1 = "";
      continue;
      label213:
      localObject3 = localObject1;
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.1
 * JD-Core Version:    0.7.0.1
 */