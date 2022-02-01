package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import anzj;
import bljm;
import bljn;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wjj;
import wqm;
import wqw;
import wul;
import xoj;
import xot;
import xou;
import xov;
import xoz;
import xpa;
import xpb;
import xpc;
import yfw;
import yuk;
import yup;
import zsv;

public class StoryPlayerCommentListView
  extends SegmentList
  implements View.OnTouchListener, bljm, bljn
{
  public int a;
  private List<zsv> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xoj jdField_a_of_type_Xoj;
  private xpb jdField_a_of_type_Xpb;
  private xpc jdField_a_of_type_Xpc;
  
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
    yfw localyfw = this.jdField_a_of_type_Xoj.a();
    if ((localyfw == null) || (localyfw.a == null))
    {
      yuk.d("Q.qqstory.player.StoryPlayerCommentListView", "feed item null , notify feed info change error!");
      return;
    }
    wqm localwqm;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localwqm = new wqm(2, paramCommentEntry.feedId, paramInt);
      localwqm.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localwqm;; paramCommentEntry = new wqm(2, localyfw.a.feedId, paramInt, localyfw.a))
    {
      paramCommentEntry.a = localyfw.a;
      wjj.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void b()
  {
    setOnLoadMoreListener("CommentFloatDialog", new xpa(this));
    setLoadMoreComplete("CommentFloatDialog", true, false);
    setOnTouchListener(this);
    super.setOverScrollHeader(null);
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    zsv localzsv;
    for (int i = 0;; i = localzsv.a() + i) {
      if (localIterator.hasNext())
      {
        localzsv = (zsv)localIterator.next();
        if (!(localzsv instanceof xov)) {}
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
    Object localObject = new xoz(getContext());
    xov localxov = new xov(getContext());
    xou localxou = new xou(getContext());
    xot localxot = new xot(getContext(), 30);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localxot);
    this.jdField_a_of_type_JavaUtilList.add(localxov);
    this.jdField_a_of_type_JavaUtilList.add(localxou);
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((zsv)((Iterator)localObject).next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xoj.a(paramCommentEntry, paramBoolean);
    wqw.a().a();
    p();
    QQToast.a(BaseApplication.getContext(), 2, anzj.a(2131713353), 0).a();
    a(2, paramCommentEntry);
  }
  
  public void a(@NonNull xoj paramxoj, xpb paramxpb, int paramInt)
  {
    super.j();
    this.jdField_a_of_type_Xpb = paramxpb;
    this.jdField_a_of_type_Xoj = paramxoj;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Xpc = new xpc(this, null);
    this.jdField_a_of_type_Xoj.a(this.jdField_a_of_type_Xpc);
    xov localxov = (xov)a("PlayerCommentSegment");
    if (localxov != null) {
      localxov.a(paramxoj, paramxpb, this.jdField_a_of_type_Int);
    }
    paramxpb = (xou)a("PlayerCommentEmptySegment");
    if (paramxpb != null) {
      paramxpb.a(paramxoj);
    }
    paramxpb = (xoz)a("PlayerDoubleTabSegment");
    if (paramxpb != null) {
      paramxpb.a(paramxoj);
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
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    super.a(paramInt, paramView, paramListView);
    if (this.jdField_a_of_type_Xpb != null) {
      this.jdField_a_of_type_Xpb.a();
    }
    return true;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < a()) {
      return false;
    }
    paramInt -= a();
    paramView = ((xov)a("PlayerCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      yuk.e("Q.qqstory.player.StoryPlayerCommentListView", "the long clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramAdapterView = this.jdField_a_of_type_Xoj.a();
    if ((paramAdapterView != null) && (paramAdapterView.a != null)) {
      if (!paramAdapterView.a.getOwner().isMe()) {
        break label147;
      }
    }
    label147:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      yup.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, yup.a(this.jdField_a_of_type_Int) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_Xoj.a(this.jdField_a_of_type_Xoj.a());
      return true;
    }
    if (this.jdField_a_of_type_Xpb != null) {
      this.jdField_a_of_type_Xpb.b(paramView, paramInt, this.jdField_a_of_type_Xoj.a());
    }
    return true;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    zsv localzsv;
    if (localIterator.hasNext())
    {
      localzsv = (zsv)localIterator.next();
      if ((localzsv instanceof xov)) {
        i = localzsv.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localzsv.a() + i;
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
      paramAdapterView = ((xov)a("PlayerCommentSegment")).a(paramInt);
      if (paramAdapterView == null)
      {
        yuk.e("Q.qqstory.player.StoryPlayerCommentListView", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      if (paramAdapterView.type == 1)
      {
        this.jdField_a_of_type_Xoj.a(this.jdField_a_of_type_Xoj.a());
        return;
      }
    } while (this.jdField_a_of_type_Xpb == null);
    this.jdField_a_of_type_Xpb.a(paramAdapterView, paramInt, this.jdField_a_of_type_Xoj.a());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Xpb != null) {
      return this.jdField_a_of_type_Xpb.a(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView
 * JD-Core Version:    0.7.0.1
 */