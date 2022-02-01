package com.tencent.biz.pubaccount.weishi_new.player;

import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;

public abstract class WSPlayerListenerAdapter
{
  public void a(WSPlayerWrapper paramWSPlayerWrapper)
  {
    if (QLog.isColorLevel()) {
      WSLog.b("WSPlayerListenerAdapter", 2, "onCompletion videoPlayer:" + paramWSPlayerWrapper);
    }
  }
  
  public void a(WSPlayerWrapper paramWSPlayerWrapper, long paramLong)
  {
    if (QLog.isColorLevel()) {
      WSLog.b("WSPlayerListenerAdapter", 2, "onAccessVideoBitRate videoBitRate:" + paramLong);
    }
  }
  
  public abstract void a(WSPlayerWrapper paramWSPlayerWrapper, Object paramObject);
  
  public void a(WSPlayerWrapper paramWSPlayerWrapper, String paramString)
  {
    if (QLog.isColorLevel()) {
      WSLog.b("WSPlayerListenerAdapter", 2, "OnDownloadCallback state:" + paramString + ", videoPlayer:" + paramWSPlayerWrapper);
    }
  }
  
  public void a(WSPlayerWrapper paramWSPlayerWrapper, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      WSLog.b("WSPlayerListenerAdapter", 2, "onCaptureImage result:" + paramBoolean + ", errCode:" + paramInt1 + ", id:" + paramInt2 + ", bitmap:" + paramBitmap + ", videoPlayer:" + paramWSPlayerWrapper);
    }
  }
  
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, WSPlayerWrapper paramWSPlayerWrapper)
  {
    if (QLog.isColorLevel()) {
      WSLog.b("WSPlayerListenerAdapter", 2, "onAccessVideoBitRate onTencentVideoDefnInfo:" + paramTVK_NetVideoInfo);
    }
  }
  
  public boolean a(WSPlayerWrapper paramWSPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      WSLog.b("WSPlayerListenerAdapter", 2, "onError model:" + paramInt1 + ", what:" + paramInt2 + ", extra:" + paramInt3 + ", detailInfo:" + paramString + ", info:" + paramObject);
    }
    return false;
  }
  
  public boolean a(WSPlayerWrapper paramWSPlayerWrapper, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      WSLog.b("WSPlayerListenerAdapter", 2, "onInfo what:" + paramInt + ", extra:" + paramObject + ", videoPlayer:" + paramWSPlayerWrapper);
    }
    return false;
  }
  
  public void b(WSPlayerWrapper paramWSPlayerWrapper)
  {
    if (QLog.isColorLevel()) {
      WSLog.b("WSPlayerListenerAdapter", 2, "onSeekComplete videoPlayer:" + paramWSPlayerWrapper);
    }
  }
  
  public void b(WSPlayerWrapper paramWSPlayerWrapper, String paramString)
  {
    if (QLog.isColorLevel()) {
      WSLog.d("WSPlayerListenerAdapter", 2, "onConnectQualityCallback json:" + paramString);
    }
  }
  
  public void c(WSPlayerWrapper paramWSPlayerWrapper)
  {
    if (QLog.isColorLevel()) {
      WSLog.b("WSPlayerListenerAdapter", 2, "onDownloadFinish videoPlayer:" + paramWSPlayerWrapper);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerListenerAdapter
 * JD-Core Version:    0.7.0.1
 */