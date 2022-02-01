package com.tencent.mobileqq.activity.aio.stickerrecommended.impl;

import android.content.Context;
import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecApi;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecDrawableDownLoader;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecServlet;
import mqq.app.NewIntent;

public class StickerRecApiImpl
  implements IStickerRecApi
{
  public ProtocolDownloader getStickerRecDownloader()
  {
    return new StickerRecDrawableDownLoader();
  }
  
  public NewIntent getStickerRecIntent(Context paramContext, byte[] paramArrayOfByte, String paramString)
  {
    paramContext = new NewIntent(paramContext, StickerRecServlet.class);
    paramContext.putExtra("key_body", paramArrayOfByte);
    paramContext.putExtra("key_cmd", paramString);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecApiImpl
 * JD-Core Version:    0.7.0.1
 */