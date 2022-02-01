package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import org.json.JSONObject;

class StickerRecManager$1
  implements StickerRecManager.ImgUpdateListener
{
  StickerRecManager$1(StickerRecManager paramStickerRecManager) {}
  
  public void a(List<IStickerRecEmoticon> paramList, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new StringBuilder().append("OnImgUpdated: empty data or text ").append(paramString1).append(" ");
      if (paramList == null) {}
      for (paramList = "null";; paramList = Integer.valueOf(paramList.size()))
      {
        QLog.i("StickerRecManager", 2, paramList);
        return;
      }
    }
    paramList = QzoneIPCModule.parseSticker2Json(paramList);
    if (paramList == null)
    {
      QLog.i("StickerRecManager", 2, "OnImgUpdated: failed to parse img data");
      return;
    }
    QzoneIPCModule.getInstance().onGetStickerRecResp(paramString1, paramList.toString(), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.1
 * JD-Core Version:    0.7.0.1
 */