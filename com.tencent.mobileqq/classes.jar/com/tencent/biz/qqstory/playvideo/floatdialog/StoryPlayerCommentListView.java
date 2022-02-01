package com.tencent.biz.qqstory.playvideo.floatdialog;

import amtj;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
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
import vli;
import vsd;
import vsn;
import vwb;
import wpu;
import wqe;
import wqf;
import wqg;
import wqk;
import wql;
import wqm;
import wqn;
import xhh;
import xvv;
import xwa;
import ysg;

public class StoryPlayerCommentListView
  extends SegmentList
  implements View.OnTouchListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  public int a;
  private List<ysg> jdField_a_of_type_JavaUtilList = new ArrayList();
  private wpu jdField_a_of_type_Wpu;
  private wqm jdField_a_of_type_Wqm;
  private wqn jdField_a_of_type_Wqn;
  
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
    xhh localxhh = this.jdField_a_of_type_Wpu.a();
    if ((localxhh == null) || (localxhh.a == null))
    {
      xvv.d("Q.qqstory.player.StoryPlayerCommentListView", "feed item null , notify feed info change error!");
      return;
    }
    vsd localvsd;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localvsd = new vsd(2, paramCommentEntry.feedId, paramInt);
      localvsd.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localvsd;; paramCommentEntry = new vsd(2, localxhh.a.feedId, paramInt, localxhh.a))
    {
      paramCommentEntry.a = localxhh.a;
      vli.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void b()
  {
    setOnLoadMoreListener("CommentFloatDialog", new wql(this));
    setLoadMoreComplete("CommentFloatDialog", true, false);
    setOnTouchListener(this);
    super.setOverScrollHeader(null);
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    ysg localysg;
    for (int i = 0;; i = localysg.a() + i) {
      if (localIterator.hasNext())
      {
        localysg = (ysg)localIterator.next();
        if (!(localysg instanceof wqg)) {}
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
    Object localObject = new wqk(getContext());
    wqg localwqg = new wqg(getContext());
    wqf localwqf = new wqf(getContext());
    wqe localwqe = new wqe(getContext(), 30);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localwqe);
    this.jdField_a_of_type_JavaUtilList.add(localwqg);
    this.jdField_a_of_type_JavaUtilList.add(localwqf);
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((ysg)((Iterator)localObject).next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Wpu.a(paramCommentEntry, paramBoolean);
    vsn.a().a();
    p();
    QQToast.a(BaseApplication.getContext(), 2, amtj.a(2131713585), 0).a();
    a(2, paramCommentEntry);
  }
  
  public void a(@NonNull wpu paramwpu, wqm paramwqm, int paramInt)
  {
    super.j();
    this.jdField_a_of_type_Wqm = paramwqm;
    this.jdField_a_of_type_Wpu = paramwpu;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Wqn = new wqn(this, null);
    this.jdField_a_of_type_Wpu.a(this.jdField_a_of_type_Wqn);
    wqg localwqg = (wqg)a("PlayerCommentSegment");
    if (localwqg != null) {
      localwqg.a(paramwpu, paramwqm, this.jdField_a_of_type_Int);
    }
    paramwqm = (wqf)a("PlayerCommentEmptySegment");
    if (paramwqm != null) {
      paramwqm.a(paramwpu);
    }
    paramwqm = (wqk)a("PlayerDoubleTabSegment");
    if (paramwqm != null) {
      paramwqm.a(paramwpu);
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
    ysg localysg;
    if (localIterator.hasNext())
    {
      localysg = (ysg)localIterator.next();
      if ((localysg instanceof wqg)) {
        i = localysg.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localysg.a() + i;
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
      paramAdapterView = ((wqg)a("PlayerCommentSegment")).a(paramInt);
      if (paramAdapterView == null)
      {
        xvv.e("Q.qqstory.player.StoryPlayerCommentListView", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      if (paramAdapterView.type == 1)
      {
        this.jdField_a_of_type_Wpu.a(this.jdField_a_of_type_Wpu.a());
        return;
      }
    } while (this.jdField_a_of_type_Wqm == null);
    this.jdField_a_of_type_Wqm.a(paramAdapterView, paramInt, this.jdField_a_of_type_Wpu.a());
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < a()) {
      return false;
    }
    paramInt -= a();
    paramView = ((wqg)a("PlayerCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      xvv.e("Q.qqstory.player.StoryPlayerCommentListView", "the long clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramAdapterView = this.jdField_a_of_type_Wpu.a();
    if ((paramAdapterView != null) && (paramAdapterView.a != null)) {
      if (!paramAdapterView.a.getOwner().isMe()) {
        break label147;
      }
    }
    label147:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      xwa.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, xwa.a(this.jdField_a_of_type_Int) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_Wpu.a(this.jdField_a_of_type_Wpu.a());
      return true;
    }
    if (this.jdField_a_of_type_Wqm != null) {
      this.jdField_a_of_type_Wqm.b(paramView, paramInt, this.jdField_a_of_type_Wpu.a());
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Wqm != null) {
      return this.jdField_a_of_type_Wqm.a(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
    if (this.jdField_a_of_type_Wqm != null) {
      this.jdField_a_of_type_Wqm.a();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView
 * JD-Core Version:    0.7.0.1
 */