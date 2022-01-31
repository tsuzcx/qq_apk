package com.tencent.biz.qqstory.playvideo.floatdialog;

import ajyc;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import bcpw;
import bfpc;
import bfpd;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ste;
import tah;
import tar;
import teg;
import tyf;
import typ;
import tyq;
import tyr;
import tyv;
import tyw;
import tyx;
import tyy;
import ups;
import veg;
import vel;
import wcr;

public class StoryPlayerCommentListView
  extends SegmentList
  implements View.OnTouchListener, bfpc, bfpd
{
  public int a;
  private List<wcr> jdField_a_of_type_JavaUtilList = new ArrayList();
  private tyf jdField_a_of_type_Tyf;
  private tyx jdField_a_of_type_Tyx;
  private tyy jdField_a_of_type_Tyy;
  
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
    ups localups = this.jdField_a_of_type_Tyf.a();
    if ((localups == null) || (localups.a == null))
    {
      veg.d("Q.qqstory.player.StoryPlayerCommentListView", "feed item null , notify feed info change error!");
      return;
    }
    tah localtah;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localtah = new tah(2, paramCommentEntry.feedId, paramInt);
      localtah.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localtah;; paramCommentEntry = new tah(2, localups.a.feedId, paramInt, localups.a))
    {
      paramCommentEntry.a = localups.a;
      ste.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void b()
  {
    setOnLoadMoreListener("CommentFloatDialog", new tyw(this));
    setLoadMoreComplete("CommentFloatDialog", true, false);
    setOnTouchListener(this);
    super.setOverScrollHeader(null);
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    wcr localwcr;
    for (int i = 0;; i = localwcr.a() + i) {
      if (localIterator.hasNext())
      {
        localwcr = (wcr)localIterator.next();
        if (!(localwcr instanceof tyr)) {}
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
    Object localObject = new tyv(getContext());
    tyr localtyr = new tyr(getContext());
    tyq localtyq = new tyq(getContext());
    typ localtyp = new typ(getContext(), 30);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localtyp);
    this.jdField_a_of_type_JavaUtilList.add(localtyr);
    this.jdField_a_of_type_JavaUtilList.add(localtyq);
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((wcr)((Iterator)localObject).next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Tyf.a(paramCommentEntry, paramBoolean);
    tar.a().a();
    p();
    bcpw.a(BaseApplication.getContext(), 2, ajyc.a(2131714548), 0).a();
    a(2, paramCommentEntry);
  }
  
  public void a(@NonNull tyf paramtyf, tyx paramtyx, int paramInt)
  {
    super.j();
    this.jdField_a_of_type_Tyx = paramtyx;
    this.jdField_a_of_type_Tyf = paramtyf;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Tyy = new tyy(this, null);
    this.jdField_a_of_type_Tyf.a(this.jdField_a_of_type_Tyy);
    tyr localtyr = (tyr)a("PlayerCommentSegment");
    if (localtyr != null) {
      localtyr.a(paramtyf, paramtyx, this.jdField_a_of_type_Int);
    }
    paramtyx = (tyq)a("PlayerCommentEmptySegment");
    if (paramtyx != null) {
      paramtyx.a(paramtyf);
    }
    paramtyx = (tyv)a("PlayerDoubleTabSegment");
    if (paramtyx != null) {
      paramtyx.a(paramtyf);
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
    if (this.jdField_a_of_type_Tyx != null) {
      this.jdField_a_of_type_Tyx.a();
    }
    return true;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < a()) {
      return false;
    }
    paramInt -= a();
    paramView = ((tyr)a("PlayerCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      veg.e("Q.qqstory.player.StoryPlayerCommentListView", "the long clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramAdapterView = this.jdField_a_of_type_Tyf.a();
    if ((paramAdapterView != null) && (paramAdapterView.a != null)) {
      if (!paramAdapterView.a.getOwner().isMe()) {
        break label147;
      }
    }
    label147:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      vel.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, vel.a(this.jdField_a_of_type_Int) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_Tyf.a(this.jdField_a_of_type_Tyf.a());
      return true;
    }
    if (this.jdField_a_of_type_Tyx != null) {
      this.jdField_a_of_type_Tyx.b(paramView, paramInt, this.jdField_a_of_type_Tyf.a());
    }
    return true;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    wcr localwcr;
    if (localIterator.hasNext())
    {
      localwcr = (wcr)localIterator.next();
      if ((localwcr instanceof tyr)) {
        i = localwcr.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localwcr.a() + i;
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
      paramAdapterView = ((tyr)a("PlayerCommentSegment")).a(paramInt);
      if (paramAdapterView == null)
      {
        veg.e("Q.qqstory.player.StoryPlayerCommentListView", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      if (paramAdapterView.type == 1)
      {
        this.jdField_a_of_type_Tyf.a(this.jdField_a_of_type_Tyf.a());
        return;
      }
    } while (this.jdField_a_of_type_Tyx == null);
    this.jdField_a_of_type_Tyx.a(paramAdapterView, paramInt, this.jdField_a_of_type_Tyf.a());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Tyx != null) {
      return this.jdField_a_of_type_Tyx.a(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView
 * JD-Core Version:    0.7.0.1
 */