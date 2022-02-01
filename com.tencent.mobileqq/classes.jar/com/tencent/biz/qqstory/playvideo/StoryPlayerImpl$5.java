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
    Context localContext = StoryPlayerImpl.g(this.a).getContext();
    if (!NetworkUtil.isNetworkAvailable(localContext))
    {
      QQToast.makeText(localContext, 1, 2131892102, 0).show();
    }
    else
    {
      SLog.d("Q.qqstory.playernew.StoryPlayerImpl", "updateData error, retry, requestGroupData, currentInfo = %s", new Object[] { StoryPlayerImpl.h(this.a) });
      StoryPlayerImpl.i(this.a).setVisibility(0);
      StoryPlayerImpl.e(this.a).removeCallbacks(StoryPlayerImpl.d(this.a));
      StoryPlayerImpl.e(this.a).postDelayed(StoryPlayerImpl.d(this.a), 500L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerImpl.5
 * JD-Core Version:    0.7.0.1
 */