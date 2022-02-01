package com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.FirstCommentEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ViolaCommentManager$4
  implements ReadInJoyCommentUtils.FirstCommentEvent
{
  ViolaCommentManager$4(ViolaCommentManager paramViolaCommentManager) {}
  
  public void a()
  {
    if (ViolaCommentManager.a(this.a) != null) {
      ViolaCommentManager.a(this.a).a();
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaCommentManager", 2, "setFirstCommentVisible: visible=" + paramBoolean);
    }
    if (paramBoolean) {
      return;
    }
    ViolaCommentManager.a(this.a, true);
    ViolaCommentManager.a(this.a).d();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ViolaCommentManager.a(this.a, 0);
      ViolaCommentManager.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo.ViolaCommentManager.4
 * JD-Core Version:    0.7.0.1
 */