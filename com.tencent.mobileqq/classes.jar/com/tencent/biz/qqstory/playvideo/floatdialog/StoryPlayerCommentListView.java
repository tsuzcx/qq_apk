package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import anvx;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.ListView;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wad;
import wgy;
import whi;
import wkw;
import xep;
import xez;
import xfa;
import xfb;
import xff;
import xfg;
import xfh;
import xfi;
import xwc;
import ykq;
import ykv;
import zgz;

public class StoryPlayerCommentListView
  extends SegmentList
  implements View.OnTouchListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  public int a;
  private List<zgz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xep jdField_a_of_type_Xep;
  private xfh jdField_a_of_type_Xfh;
  private xfi jdField_a_of_type_Xfi;
  
  public StoryPlayerCommentListView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public StoryPlayerCommentListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public StoryPlayerCommentListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(int paramInt, CommentEntry paramCommentEntry)
  {
    xwc localxwc = this.jdField_a_of_type_Xep.a();
    if ((localxwc == null) || (localxwc.a == null))
    {
      ykq.d("Q.qqstory.player.StoryPlayerCommentListView", "feed item null , notify feed info change error!");
      return;
    }
    wgy localwgy;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localwgy = new wgy(2, paramCommentEntry.feedId, paramInt);
      localwgy.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localwgy;; paramCommentEntry = new wgy(2, localxwc.a.feedId, paramInt, localxwc.a))
    {
      paramCommentEntry.a = localxwc.a;
      wad.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void b()
  {
    setOnLoadMoreListener("CommentFloatDialog", new xfg(this));
    setLoadMoreComplete("CommentFloatDialog", true, false);
    setOnTouchListener(this);
    super.setOverScrollHeader(null);
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    zgz localzgz;
    for (int i = 0;; i = localzgz.a() + i) {
      if (localIterator.hasNext())
      {
        localzgz = (zgz)localIterator.next();
        if (!(localzgz instanceof xfb)) {}
      }
      else
      {
        return i;
      }
    }
  }
  
  public void a()
  {
    super.setActTAG("list_qqstory_detail");
    Object localObject = new xff(getContext());
    xfb localxfb = new xfb(getContext());
    xfa localxfa = new xfa(getContext());
    xez localxez = new xez(getContext(), 30);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localxez);
    this.jdField_a_of_type_JavaUtilList.add(localxfb);
    this.jdField_a_of_type_JavaUtilList.add(localxfa);
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((zgz)((Iterator)localObject).next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xep.a(paramCommentEntry, paramBoolean);
    whi.a().a();
    p();
    QQToast.a(BaseApplication.getContext(), 2, anvx.a(2131713932), 0).a();
    a(2, paramCommentEntry);
  }
  
  public void a(@NonNull xep paramxep, xfh paramxfh, int paramInt)
  {
    super.j();
    this.jdField_a_of_type_Xfh = paramxfh;
    this.jdField_a_of_type_Xep = paramxep;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Xfi = new xfi(this, null);
    this.jdField_a_of_type_Xep.a(this.jdField_a_of_type_Xfi);
    xfb localxfb = (xfb)a("PlayerCommentSegment");
    if (localxfb != null) {
      localxfb.a(paramxep, paramxfh, this.jdField_a_of_type_Int);
    }
    paramxfh = (xfa)a("PlayerCommentEmptySegment");
    if (paramxfh != null) {
      paramxfh.a(paramxep);
    }
    paramxfh = (xff)a("PlayerDoubleTabSegment");
    if (paramxfh != null) {
      paramxfh.a(paramxep);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.a(1);
      return;
    }
    super.a(1, e);
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    zgz localzgz;
    if (localIterator.hasNext())
    {
      localzgz = (zgz)localIterator.next();
      if ((localzgz instanceof xfb)) {
        i = localzgz.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localzgz.a() + i;
        break;
      }
      return i;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < a()) {}
    do
    {
      return;
      paramInt -= a();
      paramAdapterView = ((xfb)a("PlayerCommentSegment")).a(paramInt);
      if (paramAdapterView == null)
      {
        ykq.e("Q.qqstory.player.StoryPlayerCommentListView", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      if (paramAdapterView.type == 1)
      {
        this.jdField_a_of_type_Xep.a(this.jdField_a_of_type_Xep.a());
        return;
      }
    } while (this.jdField_a_of_type_Xfh == null);
    this.jdField_a_of_type_Xfh.a(paramAdapterView, paramInt, this.jdField_a_of_type_Xep.a());
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < a()) {
      return false;
    }
    paramInt -= a();
    paramView = ((xfb)a("PlayerCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      ykq.e("Q.qqstory.player.StoryPlayerCommentListView", "the long clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramAdapterView = this.jdField_a_of_type_Xep.a();
    if ((paramAdapterView != null) && (paramAdapterView.a != null)) {
      if (!paramAdapterView.a.getOwner().isMe()) {
        break label147;
      }
    }
    label147:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      ykv.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, ykv.a(this.jdField_a_of_type_Int) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_Xep.a(this.jdField_a_of_type_Xep.a());
      return true;
    }
    if (this.jdField_a_of_type_Xfh != null) {
      this.jdField_a_of_type_Xfh.b(paramView, paramInt, this.jdField_a_of_type_Xep.a());
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Xfh != null) {
      return this.jdField_a_of_type_Xfh.a(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
    if (this.jdField_a_of_type_Xfh != null) {
      this.jdField_a_of_type_Xfh.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView
 * JD-Core Version:    0.7.0.1
 */