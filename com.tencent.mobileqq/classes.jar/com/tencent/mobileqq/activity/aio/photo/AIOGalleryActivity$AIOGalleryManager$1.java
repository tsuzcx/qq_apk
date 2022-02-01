package com.tencent.mobileqq.activity.aio.photo;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageForShortVideo;

class AIOGalleryActivity$AIOGalleryManager$1
  extends IAIOImageProviderCallBack.Stub
{
  AIOGalleryActivity$AIOGalleryManager$1(AIOGalleryActivity.AIOGalleryManager paramAIOGalleryManager) {}
  
  public void a()
  {
    this.a.a.runOnUiThread(new AIOGalleryActivity.AIOGalleryManager.1.4(this));
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    this.a.a.runOnUiThread(new AIOGalleryActivity.AIOGalleryManager.1.2(this, paramLong1, paramInt1, paramInt2, paramInt3, paramLong2, paramBoolean));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    this.a.a.runOnUiThread(new AIOGalleryActivity.AIOGalleryManager.1.1(this, paramBoolean, paramLong, paramInt1, paramInt2, paramInt3, paramString));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle)
  {
    this.a.a.runOnUiThread(new AIOGalleryActivity.AIOGalleryManager.1.5(this, paramLong, paramInt1, paramInt2, paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3));
  }
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    this.a.a.runOnUiThread(new AIOGalleryActivity.AIOGalleryManager.1.3(this, paramArrayOfAIORichMediaData, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1
 * JD-Core Version:    0.7.0.1
 */