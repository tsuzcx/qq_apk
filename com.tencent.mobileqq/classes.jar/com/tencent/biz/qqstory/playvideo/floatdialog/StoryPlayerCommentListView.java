package com.tencent.biz.qqstory.playvideo.floatdialog;

import alud;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import bhuw;
import bhux;
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
import umc;
import utf;
import utp;
import uxe;
import vrd;
import vrn;
import vro;
import vrp;
import vrt;
import vru;
import vrv;
import vrw;
import wiq;
import wxe;
import wxj;
import xvp;

public class StoryPlayerCommentListView
  extends SegmentList
  implements View.OnTouchListener, bhuw, bhux
{
  public int a;
  private List<xvp> jdField_a_of_type_JavaUtilList = new ArrayList();
  private vrd jdField_a_of_type_Vrd;
  private vrv jdField_a_of_type_Vrv;
  private vrw jdField_a_of_type_Vrw;
  
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
    wiq localwiq = this.jdField_a_of_type_Vrd.a();
    if ((localwiq == null) || (localwiq.a == null))
    {
      wxe.d("Q.qqstory.player.StoryPlayerCommentListView", "feed item null , notify feed info change error!");
      return;
    }
    utf localutf;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localutf = new utf(2, paramCommentEntry.feedId, paramInt);
      localutf.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localutf;; paramCommentEntry = new utf(2, localwiq.a.feedId, paramInt, localwiq.a))
    {
      paramCommentEntry.a = localwiq.a;
      umc.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void b()
  {
    setOnLoadMoreListener("CommentFloatDialog", new vru(this));
    setLoadMoreComplete("CommentFloatDialog", true, false);
    setOnTouchListener(this);
    super.setOverScrollHeader(null);
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    xvp localxvp;
    for (int i = 0;; i = localxvp.a() + i) {
      if (localIterator.hasNext())
      {
        localxvp = (xvp)localIterator.next();
        if (!(localxvp instanceof vrp)) {}
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
    Object localObject = new vrt(getContext());
    vrp localvrp = new vrp(getContext());
    vro localvro = new vro(getContext());
    vrn localvrn = new vrn(getContext(), 30);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localvrn);
    this.jdField_a_of_type_JavaUtilList.add(localvrp);
    this.jdField_a_of_type_JavaUtilList.add(localvro);
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((xvp)((Iterator)localObject).next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Vrd.a(paramCommentEntry, paramBoolean);
    utp.a().a();
    p();
    QQToast.a(BaseApplication.getContext(), 2, alud.a(2131714943), 0).a();
    a(2, paramCommentEntry);
  }
  
  public void a(@NonNull vrd paramvrd, vrv paramvrv, int paramInt)
  {
    super.j();
    this.jdField_a_of_type_Vrv = paramvrv;
    this.jdField_a_of_type_Vrd = paramvrd;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Vrw = new vrw(this, null);
    this.jdField_a_of_type_Vrd.a(this.jdField_a_of_type_Vrw);
    vrp localvrp = (vrp)a("PlayerCommentSegment");
    if (localvrp != null) {
      localvrp.a(paramvrd, paramvrv, this.jdField_a_of_type_Int);
    }
    paramvrv = (vro)a("PlayerCommentEmptySegment");
    if (paramvrv != null) {
      paramvrv.a(paramvrd);
    }
    paramvrv = (vrt)a("PlayerDoubleTabSegment");
    if (paramvrv != null) {
      paramvrv.a(paramvrd);
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
    if (this.jdField_a_of_type_Vrv != null) {
      this.jdField_a_of_type_Vrv.a();
    }
    return true;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < a()) {
      return false;
    }
    paramInt -= a();
    paramView = ((vrp)a("PlayerCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      wxe.e("Q.qqstory.player.StoryPlayerCommentListView", "the long clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramAdapterView = this.jdField_a_of_type_Vrd.a();
    if ((paramAdapterView != null) && (paramAdapterView.a != null)) {
      if (!paramAdapterView.a.getOwner().isMe()) {
        break label147;
      }
    }
    label147:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      wxj.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, wxj.a(this.jdField_a_of_type_Int) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_Vrd.a(this.jdField_a_of_type_Vrd.a());
      return true;
    }
    if (this.jdField_a_of_type_Vrv != null) {
      this.jdField_a_of_type_Vrv.b(paramView, paramInt, this.jdField_a_of_type_Vrd.a());
    }
    return true;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    xvp localxvp;
    if (localIterator.hasNext())
    {
      localxvp = (xvp)localIterator.next();
      if ((localxvp instanceof vrp)) {
        i = localxvp.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localxvp.a() + i;
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
      paramAdapterView = ((vrp)a("PlayerCommentSegment")).a(paramInt);
      if (paramAdapterView == null)
      {
        wxe.e("Q.qqstory.player.StoryPlayerCommentListView", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      if (paramAdapterView.type == 1)
      {
        this.jdField_a_of_type_Vrd.a(this.jdField_a_of_type_Vrd.a());
        return;
      }
    } while (this.jdField_a_of_type_Vrv == null);
    this.jdField_a_of_type_Vrv.a(paramAdapterView, paramInt, this.jdField_a_of_type_Vrd.a());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Vrv != null) {
      return this.jdField_a_of_type_Vrv.a(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView
 * JD-Core Version:    0.7.0.1
 */