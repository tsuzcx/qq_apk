package com.tencent.biz.qqstory.newshare.util;

import com.tencent.biz.qqstory.newshare.callback.StoryShareCallback;
import com.tencent.biz.qqstory.newshare.model.ShareWeChatData;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

final class StoryBasicShareUtils$1
  implements WXShareHelper.WXShareListener
{
  StoryBasicShareUtils$1(String paramString, StoryShareCallback paramStoryShareCallback, ShareWeChatData paramShareWeChatData) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (!this.a.equals(paramBaseResp.transaction)) {
      return;
    }
    int i = paramBaseResp.errCode;
    if (i != -4)
    {
      if (i != -2)
      {
        if (i != 0)
        {
          paramBaseResp = this.b;
          if (paramBaseResp != null) {
            paramBaseResp.b(this.c);
          }
        }
        else
        {
          paramBaseResp = this.b;
          if (paramBaseResp != null) {
            paramBaseResp.a(this.c);
          }
        }
      }
      else
      {
        paramBaseResp = this.b;
        if (paramBaseResp != null) {
          paramBaseResp.c(this.c);
        }
      }
    }
    else
    {
      paramBaseResp = this.b;
      if (paramBaseResp != null) {
        paramBaseResp.b(this.c);
      }
    }
    WXShareHelper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryBasicShareUtils.1
 * JD-Core Version:    0.7.0.1
 */