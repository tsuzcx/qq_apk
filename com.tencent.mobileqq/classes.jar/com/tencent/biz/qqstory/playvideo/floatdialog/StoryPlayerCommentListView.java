package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import anni;
import bkij;
import bkik;
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
import wfo;
import wmr;
import wnb;
import wqq;
import xko;
import xky;
import xkz;
import xla;
import xle;
import xlf;
import xlg;
import xlh;
import ycb;
import yqp;
import yqu;
import zpa;

public class StoryPlayerCommentListView
  extends SegmentList
  implements View.OnTouchListener, bkij, bkik
{
  public int a;
  private List<zpa> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xko jdField_a_of_type_Xko;
  private xlg jdField_a_of_type_Xlg;
  private xlh jdField_a_of_type_Xlh;
  
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
    ycb localycb = this.jdField_a_of_type_Xko.a();
    if ((localycb == null) || (localycb.a == null))
    {
      yqp.d("Q.qqstory.player.StoryPlayerCommentListView", "feed item null , notify feed info change error!");
      return;
    }
    wmr localwmr;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localwmr = new wmr(2, paramCommentEntry.feedId, paramInt);
      localwmr.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localwmr;; paramCommentEntry = new wmr(2, localycb.a.feedId, paramInt, localycb.a))
    {
      paramCommentEntry.a = localycb.a;
      wfo.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void b()
  {
    setOnLoadMoreListener("CommentFloatDialog", new xlf(this));
    setLoadMoreComplete("CommentFloatDialog", true, false);
    setOnTouchListener(this);
    super.setOverScrollHeader(null);
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    zpa localzpa;
    for (int i = 0;; i = localzpa.a() + i) {
      if (localIterator.hasNext())
      {
        localzpa = (zpa)localIterator.next();
        if (!(localzpa instanceof xla)) {}
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
    Object localObject = new xle(getContext());
    xla localxla = new xla(getContext());
    xkz localxkz = new xkz(getContext());
    xky localxky = new xky(getContext(), 30);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localxky);
    this.jdField_a_of_type_JavaUtilList.add(localxla);
    this.jdField_a_of_type_JavaUtilList.add(localxkz);
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((zpa)((Iterator)localObject).next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xko.a(paramCommentEntry, paramBoolean);
    wnb.a().a();
    p();
    QQToast.a(BaseApplication.getContext(), 2, anni.a(2131713244), 0).a();
    a(2, paramCommentEntry);
  }
  
  public void a(@NonNull xko paramxko, xlg paramxlg, int paramInt)
  {
    super.j();
    this.jdField_a_of_type_Xlg = paramxlg;
    this.jdField_a_of_type_Xko = paramxko;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Xlh = new xlh(this, null);
    this.jdField_a_of_type_Xko.a(this.jdField_a_of_type_Xlh);
    xla localxla = (xla)a("PlayerCommentSegment");
    if (localxla != null) {
      localxla.a(paramxko, paramxlg, this.jdField_a_of_type_Int);
    }
    paramxlg = (xkz)a("PlayerCommentEmptySegment");
    if (paramxlg != null) {
      paramxlg.a(paramxko);
    }
    paramxlg = (xle)a("PlayerDoubleTabSegment");
    if (paramxlg != null) {
      paramxlg.a(paramxko);
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
    if (this.jdField_a_of_type_Xlg != null) {
      this.jdField_a_of_type_Xlg.a();
    }
    return true;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < a()) {
      return false;
    }
    paramInt -= a();
    paramView = ((xla)a("PlayerCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      yqp.e("Q.qqstory.player.StoryPlayerCommentListView", "the long clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramAdapterView = this.jdField_a_of_type_Xko.a();
    if ((paramAdapterView != null) && (paramAdapterView.a != null)) {
      if (!paramAdapterView.a.getOwner().isMe()) {
        break label147;
      }
    }
    label147:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      yqu.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, yqu.a(this.jdField_a_of_type_Int) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_Xko.a(this.jdField_a_of_type_Xko.a());
      return true;
    }
    if (this.jdField_a_of_type_Xlg != null) {
      this.jdField_a_of_type_Xlg.b(paramView, paramInt, this.jdField_a_of_type_Xko.a());
    }
    return true;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    zpa localzpa;
    if (localIterator.hasNext())
    {
      localzpa = (zpa)localIterator.next();
      if ((localzpa instanceof xla)) {
        i = localzpa.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localzpa.a() + i;
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
      paramAdapterView = ((xla)a("PlayerCommentSegment")).a(paramInt);
      if (paramAdapterView == null)
      {
        yqp.e("Q.qqstory.player.StoryPlayerCommentListView", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      if (paramAdapterView.type == 1)
      {
        this.jdField_a_of_type_Xko.a(this.jdField_a_of_type_Xko.a());
        return;
      }
    } while (this.jdField_a_of_type_Xlg == null);
    this.jdField_a_of_type_Xlg.a(paramAdapterView, paramInt, this.jdField_a_of_type_Xko.a());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Xlg != null) {
      return this.jdField_a_of_type_Xlg.a(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView
 * JD-Core Version:    0.7.0.1
 */