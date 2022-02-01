package com.tencent.biz.qqstory.troop.activity;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.widget.AbsEmptyView;
import com.tencent.widget.ListView;
import wmf;
import wqq;
import ync;
import ynm;
import ypu;
import yqu;

public class TroopStoryListView
  extends SegmentList
  implements View.OnTouchListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ync jdField_a_of_type_Ync;
  private boolean jdField_a_of_type_Boolean;
  
  public TroopStoryListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopStoryListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopStoryListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    super.setActTAG("list_qqstory_troop");
    ynm localynm = new ynm(getContext(), this.jdField_a_of_type_AndroidAppActivity, 11, this.jdField_a_of_type_Ync, false);
    a(localynm);
    a(new ypu(getContext(), "FeedSegment", "暂时没有小视频\n你可以在这里查看群内的小视频", 2130846611, 2130846611));
    localynm.e_(true);
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public void a(Activity paramActivity, ync paramync)
  {
    this.jdField_a_of_type_Ync = paramync;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    super.setOnTouchListener(this);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    super.a(paramInt, paramView, paramListView);
    if (paramInt == 0) {
      this.jdField_a_of_type_Boolean = true;
    }
    while (paramInt != 1) {
      return true;
    }
    return true;
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    super.b(paramBoolean, paramInt);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    if ((getEmptyView() instanceof AbsEmptyView)) {
      ((AbsEmptyView)getEmptyView()).a(4);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.jdField_a_of_type_Ync.a();
    int i;
    if (paramView.getVisibility() == 0)
    {
      ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      paramView.clearFocus();
      paramView.setVisibility(8);
      paramView = paramView.a.a;
      i = yqu.a(paramView.getOwner());
      if (!paramView.getOwner().isMe()) {
        break label113;
      }
    }
    label113:
    for (paramView = "1";; paramView = "2")
    {
      yqu.a("home_page", "cancel_reply", i, 0, new String[] { paramView, "3", "", "" });
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.activity.TroopStoryListView
 * JD-Core Version:    0.7.0.1
 */