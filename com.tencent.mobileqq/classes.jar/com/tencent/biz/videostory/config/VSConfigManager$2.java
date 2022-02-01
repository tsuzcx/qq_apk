package com.tencent.biz.videostory.config;

import NS_QQ_STORY_CONFIG.CONFIG.StGetStoryConfigRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

class VSConfigManager$2
  implements VSDispatchObserver.onVSRspCallBack<CONFIG.StGetStoryConfigRsp>
{
  VSConfigManager$2(VSConfigManager paramVSConfigManager) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CONFIG.StGetStoryConfigRsp paramStGetStoryConfigRsp)
  {
    if ((paramStGetStoryConfigRsp != null) && (paramStGetStoryConfigRsp.intConf != null)) {
      VSConfigManager.a(this.a, paramStGetStoryConfigRsp.intConf.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager.2
 * JD-Core Version:    0.7.0.1
 */