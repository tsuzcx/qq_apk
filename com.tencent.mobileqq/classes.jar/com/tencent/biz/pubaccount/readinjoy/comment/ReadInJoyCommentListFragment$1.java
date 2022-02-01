package com.tencent.biz.pubaccount.readinjoy.comment;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.TMG.utils.QLog;

class ReadInJoyCommentListFragment$1
  implements ReadInJoyCommentListFragment.HippyCommentPageListener
{
  ReadInJoyCommentListFragment$1(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ReadInJoyCommentListFragment", 1, "onHippyPageLoaded: " + paramBoolean);
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()) || (this.a.isDetached()))
    {
      QLog.d("ReadInJoyCommentListFragment", 1, "activity not exists or fragment detached");
      return;
    }
    if (paramBoolean)
    {
      ReadInJoyCommentListFragment.a(this.a, true);
      ReadInJoyCommentListFragment.a(this.a);
    }
    for (;;)
    {
      ReadInJoyCommentListFragment.b(this.a);
      return;
      if (ReadInJoyCommentListFragment.a(this.a) != null)
      {
        if (ReadInJoyCommentListFragment.a(this.a) != null)
        {
          ((FrameLayout)ReadInJoyCommentListFragment.a(this.a).findViewById(2131368437)).setVisibility(8);
          ((RelativeLayout)ReadInJoyCommentListFragment.a(this.a).findViewById(2131377246)).setVisibility(0);
        }
        ReadInJoyCommentListFragment.a(this.a, null);
      }
      if (!ReadInJoyCommentListFragment.a(this.a)) {
        ReadInJoyCommentListFragment.a(this.a, ReadInJoyCommentListFragment.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment.1
 * JD-Core Version:    0.7.0.1
 */