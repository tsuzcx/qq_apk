package com.tencent.liteav;

import android.media.MediaFormat;
import com.tencent.liteav.basic.structs.TXSNALPacket;

public abstract interface d$a
{
  public abstract void onBackgroudPushStop();
  
  public abstract void onEncVideo(TXSNALPacket paramTXSNALPacket);
  
  public abstract void onEncVideoFormat(MediaFormat paramMediaFormat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.d.a
 * JD-Core Version:    0.7.0.1
 */