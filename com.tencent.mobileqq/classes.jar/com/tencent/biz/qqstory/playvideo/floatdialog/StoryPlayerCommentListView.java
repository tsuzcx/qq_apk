package com.tencent.biz.qqstory.playvideo.floatdialog;

import ajjy;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import bbmy;
import behi;
import behj;
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
import sgi;
import snl;
import snv;
import srk;
import tlj;
import tlt;
import tlu;
import tlv;
import tlz;
import tma;
import tmb;
import tmc;
import ucw;
import urk;
import urp;
import vpv;

public class StoryPlayerCommentListView
  extends SegmentList
  implements View.OnTouchListener, behi, behj
{
  public int a;
  private List<vpv> jdField_a_of_type_JavaUtilList = new ArrayList();
  private tlj jdField_a_of_type_Tlj;
  private tmb jdField_a_of_type_Tmb;
  private tmc jdField_a_of_type_Tmc;
  
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
    ucw localucw = this.jdField_a_of_type_Tlj.a();
    if ((localucw == null) || (localucw.a == null))
    {
      urk.d("Q.qqstory.player.StoryPlayerCommentListView", "feed item null , notify feed info change error!");
      return;
    }
    snl localsnl;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localsnl = new snl(2, paramCommentEntry.feedId, paramInt);
      localsnl.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localsnl;; paramCommentEntry = new snl(2, localucw.a.feedId, paramInt, localucw.a))
    {
      paramCommentEntry.a = localucw.a;
      sgi.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void b()
  {
    setOnLoadMoreListener("CommentFloatDialog", new tma(this));
    setLoadMoreComplete("CommentFloatDialog", true, false);
    setOnTouchListener(this);
    super.setOverScrollHeader(null);
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    vpv localvpv;
    for (int i = 0;; i = localvpv.a() + i) {
      if (localIterator.hasNext())
      {
        localvpv = (vpv)localIterator.next();
        if (!(localvpv instanceof tlv)) {}
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
    Object localObject = new tlz(getContext());
    tlv localtlv = new tlv(getContext());
    tlu localtlu = new tlu(getContext());
    tlt localtlt = new tlt(getContext(), 30);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localtlt);
    this.jdField_a_of_type_JavaUtilList.add(localtlv);
    this.jdField_a_of_type_JavaUtilList.add(localtlu);
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((vpv)((Iterator)localObject).next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Tlj.a(paramCommentEntry, paramBoolean);
    snv.a().a();
    p();
    bbmy.a(BaseApplication.getContext(), 2, ajjy.a(2131648759), 0).a();
    a(2, paramCommentEntry);
  }
  
  public void a(@NonNull tlj paramtlj, tmb paramtmb, int paramInt)
  {
    super.j();
    this.jdField_a_of_type_Tmb = paramtmb;
    this.jdField_a_of_type_Tlj = paramtlj;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Tmc = new tmc(this, null);
    this.jdField_a_of_type_Tlj.a(this.jdField_a_of_type_Tmc);
    tlv localtlv = (tlv)a("PlayerCommentSegment");
    if (localtlv != null) {
      localtlv.a(paramtlj, paramtmb, this.jdField_a_of_type_Int);
    }
    paramtmb = (tlu)a("PlayerCommentEmptySegment");
    if (paramtmb != null) {
      paramtmb.a(paramtlj);
    }
    paramtmb = (tlz)a("PlayerDoubleTabSegment");
    if (paramtmb != null) {
      paramtmb.a(paramtlj);
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
    if (this.jdField_a_of_type_Tmb != null) {
      this.jdField_a_of_type_Tmb.a();
    }
    return true;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < a()) {
      return false;
    }
    paramInt -= a();
    paramView = ((tlv)a("PlayerCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      urk.e("Q.qqstory.player.StoryPlayerCommentListView", "the long clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramAdapterView = this.jdField_a_of_type_Tlj.a();
    if ((paramAdapterView != null) && (paramAdapterView.a != null)) {
      if (!paramAdapterView.a.getOwner().isMe()) {
        break label147;
      }
    }
    label147:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      urp.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, urp.a(this.jdField_a_of_type_Int) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_Tlj.a(this.jdField_a_of_type_Tlj.a());
      return true;
    }
    if (this.jdField_a_of_type_Tmb != null) {
      this.jdField_a_of_type_Tmb.b(paramView, paramInt, this.jdField_a_of_type_Tlj.a());
    }
    return true;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    vpv localvpv;
    if (localIterator.hasNext())
    {
      localvpv = (vpv)localIterator.next();
      if ((localvpv instanceof tlv)) {
        i = localvpv.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localvpv.a() + i;
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
      paramAdapterView = ((tlv)a("PlayerCommentSegment")).a(paramInt);
      if (paramAdapterView == null)
      {
        urk.e("Q.qqstory.player.StoryPlayerCommentListView", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      if (paramAdapterView.type == 1)
      {
        this.jdField_a_of_type_Tlj.a(this.jdField_a_of_type_Tlj.a());
        return;
      }
    } while (this.jdField_a_of_type_Tmb == null);
    this.jdField_a_of_type_Tmb.a(paramAdapterView, paramInt, this.jdField_a_of_type_Tlj.a());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Tmb != null) {
      return this.jdField_a_of_type_Tmb.a(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView
 * JD-Core Version:    0.7.0.1
 */