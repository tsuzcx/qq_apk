package com.tencent.biz.qqstory.storyHome.memory.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import java.util.Iterator;
import java.util.List;
import smz;
import srk;
import uhe;
import uhq;
import unx;
import upb;
import urk;
import urp;
import vpv;

public class StoryMemoriesListView
  extends SegmentList
  implements View.OnTouchListener, upb
{
  private uhe a;
  
  public StoryMemoriesListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StoryMemoriesListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StoryMemoriesListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    Iterator localIterator = this.a.a().iterator();
    while (localIterator.hasNext()) {
      a((vpv)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setOnTouchListener(this);
    if (this.a.jdField_a_of_type_Unx != null) {
      this.a.jdField_a_of_type_Unx.a().setInputViewHideListener(this);
    }
  }
  
  public void a(String paramString, CommentEntry paramCommentEntry) {}
  
  public void b()
  {
    if (this.a.jdField_a_of_type_Unx != null) {
      this.a.jdField_a_of_type_Unx.g();
    }
  }
  
  public void c()
  {
    if (this.a.jdField_a_of_type_Unx != null) {
      this.a.jdField_a_of_type_Unx.h();
    }
  }
  
  public void d() {}
  
  public void e() {}
  
  public void layoutChildren()
  {
    try
    {
      super.layoutChildren();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      urk.e("SwipListView", "error:%s", new Object[] { localIllegalStateException.toString() });
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_Unx == null) {
      return false;
    }
    paramView = this.a.jdField_a_of_type_Unx.a();
    if (paramView.getVisibility() == 0)
    {
      ((InputMethodManager)this.a.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      paramView.clearFocus();
      paramView.setVisibility(8);
      b();
      paramView = paramView.a.a;
      int i = urp.a(paramView.getOwner());
      if (paramView.getOwner().isMe()) {}
      for (paramView = "1";; paramView = "2")
      {
        urp.a("home_page", "cancel_reply", i, 0, new String[] { paramView, "3", "", "" });
        return true;
      }
    }
    return false;
  }
  
  public void setConfig(@NonNull uhe paramuhe)
  {
    this.a = paramuhe;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    uhq localuhq = (uhq)a("FeedSegment");
    if ((localuhq == null) || (localuhq.a() == 0) || (!localuhq.c())) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    localuhq.c(1);
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    localuhq.c(0);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView
 * JD-Core Version:    0.7.0.1
 */