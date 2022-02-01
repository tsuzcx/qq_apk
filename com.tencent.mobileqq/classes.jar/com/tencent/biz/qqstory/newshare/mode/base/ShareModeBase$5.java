package com.tencent.biz.qqstory.newshare.mode.base;

import android.graphics.Bitmap;
import com.tencent.biz.qqstory.newshare.job.WeChatImageJob;
import com.tencent.biz.qqstory.newshare.model.ShareWeChatData;

class ShareModeBase$5
  extends WeChatImageJob
{
  ShareModeBase$5(ShareModeBase paramShareModeBase, boolean paramBoolean1, boolean paramBoolean2, ShareWeChatData paramShareWeChatData)
  {
    super(paramBoolean1, paramBoolean2);
  }
  
  public boolean c()
  {
    this.a.a = ((Bitmap)b("WeChatImageJob_out_bitmap"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase.5
 * JD-Core Version:    0.7.0.1
 */