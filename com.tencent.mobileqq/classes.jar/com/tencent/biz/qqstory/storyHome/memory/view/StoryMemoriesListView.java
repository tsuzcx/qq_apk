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
import szs;
import ted;
import utx;
import uuj;
import vaq;
import vbu;
import ved;
import vei;
import wco;

public class StoryMemoriesListView
  extends SegmentList
  implements View.OnTouchListener, vbu
{
  private utx a;
  
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
      a((wco)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setOnTouchListener(this);
    if (this.a.jdField_a_of_type_Vaq != null) {
      this.a.jdField_a_of_type_Vaq.a().setInputViewHideListener(this);
    }
  }
  
  public void a(String paramString, CommentEntry paramCommentEntry) {}
  
  public void b()
  {
    if (this.a.jdField_a_of_type_Vaq != null) {
      this.a.jdField_a_of_type_Vaq.g();
    }
  }
  
  public void c()
  {
    if (this.a.jdField_a_of_type_Vaq != null) {
      this.a.jdField_a_of_type_Vaq.h();
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
      ved.e("SwipListView", "error:%s", new Object[] { localIllegalStateException.toString() });
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_Vaq == null) {
      return false;
    }
    paramView = this.a.jdField_a_of_type_Vaq.a();
    if (paramView.getVisibility() == 0)
    {
      ((InputMethodManager)this.a.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      paramView.clearFocus();
      paramView.setVisibility(8);
      b();
      paramView = paramView.a.a;
      int i = vei.a(paramView.getOwner());
      if (paramView.getOwner().isMe()) {}
      for (paramView = "1";; paramView = "2")
      {
        vei.a("home_page", "cancel_reply", i, 0, new String[] { paramView, "3", "", "" });
        return true;
      }
    }
    return false;
  }
  
  public void setConfig(@NonNull utx paramutx)
  {
    this.a = paramutx;
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    uuj localuuj = (uuj)a("FeedSegment");
    if ((localuuj == null) || (localuuj.a() == 0) || (!localuuj.c())) {
      return super.trackMotionScroll(paramInt1, paramInt2);
    }
    localuuj.c(1);
    boolean bool = super.trackMotionScroll(paramInt1, paramInt2);
    localuuj.c(0);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView
 * JD-Core Version:    0.7.0.1
 */