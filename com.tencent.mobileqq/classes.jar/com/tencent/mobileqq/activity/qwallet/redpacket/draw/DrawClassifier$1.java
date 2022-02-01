package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import akxe;
import akzp;
import akzq;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class DrawClassifier$1
  implements Runnable
{
  public DrawClassifier$1(MessageForQQWalletMsg paramMessageForQQWalletMsg) {}
  
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
          break label199;
        }
        if (!TextUtils.isEmpty(str2))
        {
          localObject2 = ((JSONObject)localObject3).optString("aModelPrefix", "https://i.gtimg.cn/drawrp/aModel_");
          localObject3 = akzp.a((JSONObject)localObject3, str2);
          if (localObject3 == null) {
            break label211;
          }
          str1 = ((JSONObject)localObject3).optString("aMd5");
          break label211;
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
            PreloadManager.a().a((DownloadParam)localObject2, new akzq(this));
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
      label199:
      Object localObject2 = "";
      Object localObject3 = "";
      Object localObject1 = "";
      continue;
      label211:
      localObject3 = localObject1;
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.1
 * JD-Core Version:    0.7.0.1
 */