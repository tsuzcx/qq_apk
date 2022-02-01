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
    if (!this.jdField_a_of_type_JavaLangString.equals(paramBaseResp.transaction)) {
      return;
    }
    int i = paramBaseResp.errCode;
    if (i != -4)
    {
      if (i != -2)
      {
        if (i != 0)
        {
          paramBaseResp = this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackStoryShareCallback;
          if (paramBaseResp != null) {
            paramBaseResp.b(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareWeChatData);
          }
        }
        else
        {
          paramBaseResp = this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackStoryShareCallback;
          if (paramBaseResp != null) {
            paramBaseResp.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareWeChatData);
          }
        }
      }
      else
      {
        paramBaseResp = this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackStoryShareCallback;
        if (paramBaseResp != null) {
          paramBaseResp.c(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareWeChatData);
        }
      }
    }
    else
    {
      paramBaseResp = this.jdField_a_of_type_ComTencentBizQqstoryNewshareCallbackStoryShareCallback;
      if (paramBaseResp != null) {
        paramBaseResp.b(this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareWeChatData);
      }
    }
    WXShareHelper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryBasicShareUtils.1
 * JD-Core Version:    0.7.0.1
 */