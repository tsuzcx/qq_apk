package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StoryPlayerImpl$5
  implements View.OnClickListener
{
  StoryPlayerImpl$5(StoryPlayerImpl paramStoryPlayerImpl) {}
  
  public void onClick(View paramView)
  {
    Context localContext = StoryPlayerImpl.a(this.a).a();
    if (!NetworkUtil.g(localContext)) {
      QQToast.a(localContext, 1, 2131694457, 0).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData error, retry, requestGroupData, currentInfo = %s", new Object[] { StoryPlayerImpl.a(this.a) });
      StoryPlayerImpl.a(this.a).setVisibility(0);
      StoryPlayerImpl.a(this.a).removeCallbacks(StoryPlayerImpl.a(this.a));
      StoryPlayerImpl.a(this.a).postDelayed(StoryPlayerImpl.a(this.a), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerImpl.5
 * JD-Core Version:    0.7.0.1
 */