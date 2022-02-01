package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.adapter.DiscussionListAdapter2;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class DiscussionView$MyDiscussionObserver
  extends DiscussionObserver
{
  private DiscussionView$MyDiscussionObserver(DiscussionView paramDiscussionView) {}
  
  protected void a()
  {
    this.a.m.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.j();
    }
    this.a.m.notifyDataSetChanged();
    if (this.a.n)
    {
      DiscussionView localDiscussionView = this.a;
      localDiscussionView.n = false;
      if (paramBoolean)
      {
        DiscussionView.a(localDiscussionView).a(0);
        this.a.a(100, 800L);
        return;
      }
      localDiscussionView.l.springBackOverScrollHeaderView();
      this.a.a(2131916799);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    if (paramBoolean) {
      this.a.m.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (paramBoolean) {
      this.a.m.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {
      this.a.m.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUncollectDiscussion isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" uin:");
      localStringBuilder.append(paramLong);
      QLog.d("DiscussionView", 2, localStringBuilder.toString());
    }
    this.a.m.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    this.a.m.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.a.m.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.m.notifyDataSetChanged();
    }
  }
  
  protected void b()
  {
    this.a.m.notifyDataSetChanged();
  }
  
  protected void b(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUncollectDiscussion isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" uin:");
      localStringBuilder.append(paramLong);
      QLog.d("DiscussionView", 2, localStringBuilder.toString());
    }
    this.a.m.notifyDataSetChanged();
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.m.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.DiscussionView.MyDiscussionObserver
 * JD-Core Version:    0.7.0.1
 */