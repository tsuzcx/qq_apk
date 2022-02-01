package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Context;
import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.NewIntent;

@QAPI(process={"all"})
public abstract interface IStickerRecApi
  extends QRouteApi
{
  public abstract ProtocolDownloader getStickerRecDownloader();
  
  public abstract NewIntent getStickerRecIntent(Context paramContext, byte[] paramArrayOfByte, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecApi
 * JD-Core Version:    0.7.0.1
 */