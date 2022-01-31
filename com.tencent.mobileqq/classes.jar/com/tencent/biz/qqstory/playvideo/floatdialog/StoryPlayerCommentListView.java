package com.tencent.biz.qqstory.playvideo.floatdialog;

import ajya;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import bcql;
import bfpt;
import bfpu;
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
import stb;
import tae;
import tao;
import ted;
import tyc;
import tym;
import tyn;
import tyo;
import tys;
import tyt;
import tyu;
import tyv;
import upp;
import ved;
import vei;
import wco;

public class StoryPlayerCommentListView
  extends SegmentList
  implements View.OnTouchListener, bfpt, bfpu
{
  public int a;
  private List<wco> jdField_a_of_type_JavaUtilList = new ArrayList();
  private tyc jdField_a_of_type_Tyc;
  private tyu jdField_a_of_type_Tyu;
  private tyv jdField_a_of_type_Tyv;
  
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
    upp localupp = this.jdField_a_of_type_Tyc.a();
    if ((localupp == null) || (localupp.a == null))
    {
      ved.d("Q.qqstory.player.StoryPlayerCommentListView", "feed item null , notify feed info change error!");
      return;
    }
    tae localtae;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localtae = new tae(2, paramCommentEntry.feedId, paramInt);
      localtae.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localtae;; paramCommentEntry = new tae(2, localupp.a.feedId, paramInt, localupp.a))
    {
      paramCommentEntry.a = localupp.a;
      stb.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void b()
  {
    setOnLoadMoreListener("CommentFloatDialog", new tyt(this));
    setLoadMoreComplete("CommentFloatDialog", true, false);
    setOnTouchListener(this);
    super.setOverScrollHeader(null);
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    wco localwco;
    for (int i = 0;; i = localwco.a() + i) {
      if (localIterator.hasNext())
      {
        localwco = (wco)localIterator.next();
        if (!(localwco instanceof tyo)) {}
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
    Object localObject = new tys(getContext());
    tyo localtyo = new tyo(getContext());
    tyn localtyn = new tyn(getContext());
    tym localtym = new tym(getContext(), 30);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localtym);
    this.jdField_a_of_type_JavaUtilList.add(localtyo);
    this.jdField_a_of_type_JavaUtilList.add(localtyn);
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((wco)((Iterator)localObject).next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Tyc.a(paramCommentEntry, paramBoolean);
    tao.a().a();
    p();
    bcql.a(BaseApplication.getContext(), 2, ajya.a(2131714559), 0).a();
    a(2, paramCommentEntry);
  }
  
  public void a(@NonNull tyc paramtyc, tyu paramtyu, int paramInt)
  {
    super.j();
    this.jdField_a_of_type_Tyu = paramtyu;
    this.jdField_a_of_type_Tyc = paramtyc;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Tyv = new tyv(this, null);
    this.jdField_a_of_type_Tyc.a(this.jdField_a_of_type_Tyv);
    tyo localtyo = (tyo)a("PlayerCommentSegment");
    if (localtyo != null) {
      localtyo.a(paramtyc, paramtyu, this.jdField_a_of_type_Int);
    }
    paramtyu = (tyn)a("PlayerCommentEmptySegment");
    if (paramtyu != null) {
      paramtyu.a(paramtyc);
    }
    paramtyu = (tys)a("PlayerDoubleTabSegment");
    if (paramtyu != null) {
      paramtyu.a(paramtyc);
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
    if (this.jdField_a_of_type_Tyu != null) {
      this.jdField_a_of_type_Tyu.a();
    }
    return true;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < a()) {
      return false;
    }
    paramInt -= a();
    paramView = ((tyo)a("PlayerCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      ved.e("Q.qqstory.player.StoryPlayerCommentListView", "the long clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramAdapterView = this.jdField_a_of_type_Tyc.a();
    if ((paramAdapterView != null) && (paramAdapterView.a != null)) {
      if (!paramAdapterView.a.getOwner().isMe()) {
        break label147;
      }
    }
    label147:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      vei.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, vei.a(this.jdField_a_of_type_Int) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_Tyc.a(this.jdField_a_of_type_Tyc.a());
      return true;
    }
    if (this.jdField_a_of_type_Tyu != null) {
      this.jdField_a_of_type_Tyu.b(paramView, paramInt, this.jdField_a_of_type_Tyc.a());
    }
    return true;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    wco localwco;
    if (localIterator.hasNext())
    {
      localwco = (wco)localIterator.next();
      if ((localwco instanceof tyo)) {
        i = localwco.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localwco.a() + i;
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
      paramAdapterView = ((tyo)a("PlayerCommentSegment")).a(paramInt);
      if (paramAdapterView == null)
      {
        ved.e("Q.qqstory.player.StoryPlayerCommentListView", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      if (paramAdapterView.type == 1)
      {
        this.jdField_a_of_type_Tyc.a(this.jdField_a_of_type_Tyc.a());
        return;
      }
    } while (this.jdField_a_of_type_Tyu == null);
    this.jdField_a_of_type_Tyu.a(paramAdapterView, paramInt, this.jdField_a_of_type_Tyc.a());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Tyu != null) {
      return this.jdField_a_of_type_Tyu.a(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView
 * JD-Core Version:    0.7.0.1
 */