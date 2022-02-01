package com.tencent.biz.pubaccount.weishi_new.player;

import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qphone.base.util.QLog;

public abstract class WSPlayerListenerAdapter
{
  public void a(WSPlayerWrapper paramWSPlayerWrapper)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCompletion videoPlayer:");
      localStringBuilder.append(paramWSPlayerWrapper);
      WSLog.b("WSPlayerListenerAdapter", 2, localStringBuilder.toString());
    }
  }
  
  public void a(WSPlayerWrapper paramWSPlayerWrapper, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramWSPlayerWrapper = new StringBuilder();
      paramWSPlayerWrapper.append("onAccessVideoBitRate videoBitRate:");
      paramWSPlayerWrapper.append(paramLong);
      WSLog.b("WSPlayerListenerAdapter", 2, paramWSPlayerWrapper.toString());
    }
  }
  
  public abstract void a(WSPlayerWrapper paramWSPlayerWrapper, Object paramObject);
  
  public void a(WSPlayerWrapper paramWSPlayerWrapper, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCaptureImage result:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", errCode:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", id:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", bitmap:");
      localStringBuilder.append(paramBitmap);
      localStringBuilder.append(", videoPlayer:");
      localStringBuilder.append(paramWSPlayerWrapper);
      WSLog.b("WSPlayerListenerAdapter", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a(WSPlayerWrapper paramWSPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramWSPlayerWrapper = new StringBuilder();
      paramWSPlayerWrapper.append("onError model:");
      paramWSPlayerWrapper.append(paramInt1);
      paramWSPlayerWrapper.append(", what:");
      paramWSPlayerWrapper.append(paramInt2);
      paramWSPlayerWrapper.append(", extra:");
      paramWSPlayerWrapper.append(paramInt3);
      paramWSPlayerWrapper.append(", detailInfo:");
      paramWSPlayerWrapper.append(paramString);
      paramWSPlayerWrapper.append(", info:");
      paramWSPlayerWrapper.append(paramObject);
      WSLog.b("WSPlayerListenerAdapter", 2, paramWSPlayerWrapper.toString());
    }
    return false;
  }
  
  public boolean a(WSPlayerWrapper paramWSPlayerWrapper, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInfo what:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", extra:");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(", videoPlayer:");
      localStringBuilder.append(paramWSPlayerWrapper);
      WSLog.b("WSPlayerListenerAdapter", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public void b(WSPlayerWrapper paramWSPlayerWrapper)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSeekComplete videoPlayer:");
      localStringBuilder.append(paramWSPlayerWrapper);
      WSLog.b("WSPlayerListenerAdapter", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerListenerAdapter
 * JD-Core Version:    0.7.0.1
 */