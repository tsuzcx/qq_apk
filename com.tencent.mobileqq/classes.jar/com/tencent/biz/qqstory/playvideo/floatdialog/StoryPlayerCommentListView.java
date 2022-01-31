package com.tencent.biz.qqstory.playvideo.floatdialog;

import alpo;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import bhqp;
import bhqq;
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
import uht;
import uow;
import upg;
import usv;
import vmu;
import vne;
import vnf;
import vng;
import vnk;
import vnl;
import vnm;
import vnn;
import weh;
import wsv;
import wta;
import xrg;

public class StoryPlayerCommentListView
  extends SegmentList
  implements View.OnTouchListener, bhqp, bhqq
{
  public int a;
  private List<xrg> jdField_a_of_type_JavaUtilList = new ArrayList();
  private vmu jdField_a_of_type_Vmu;
  private vnm jdField_a_of_type_Vnm;
  private vnn jdField_a_of_type_Vnn;
  
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
    weh localweh = this.jdField_a_of_type_Vmu.a();
    if ((localweh == null) || (localweh.a == null))
    {
      wsv.d("Q.qqstory.player.StoryPlayerCommentListView", "feed item null , notify feed info change error!");
      return;
    }
    uow localuow;
    if ((paramInt == 2) || (paramInt == 1))
    {
      localuow = new uow(2, paramCommentEntry.feedId, paramInt);
      localuow.c = paramCommentEntry.commentId;
    }
    for (paramCommentEntry = localuow;; paramCommentEntry = new uow(2, localweh.a.feedId, paramInt, localweh.a))
    {
      paramCommentEntry.a = localweh.a;
      uht.a().dispatch(paramCommentEntry);
      return;
    }
  }
  
  private void b()
  {
    setOnLoadMoreListener("CommentFloatDialog", new vnl(this));
    setLoadMoreComplete("CommentFloatDialog", true, false);
    setOnTouchListener(this);
    super.setOverScrollHeader(null);
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    xrg localxrg;
    for (int i = 0;; i = localxrg.a() + i) {
      if (localIterator.hasNext())
      {
        localxrg = (xrg)localIterator.next();
        if (!(localxrg instanceof vng)) {}
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
    Object localObject = new vnk(getContext());
    vng localvng = new vng(getContext());
    vnf localvnf = new vnf(getContext());
    vne localvne = new vne(getContext(), 30);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localvne);
    this.jdField_a_of_type_JavaUtilList.add(localvng);
    this.jdField_a_of_type_JavaUtilList.add(localvnf);
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a((xrg)((Iterator)localObject).next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundColor(-1);
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Vmu.a(paramCommentEntry, paramBoolean);
    upg.a().a();
    p();
    QQToast.a(BaseApplication.getContext(), 2, alpo.a(2131714931), 0).a();
    a(2, paramCommentEntry);
  }
  
  public void a(@NonNull vmu paramvmu, vnm paramvnm, int paramInt)
  {
    super.j();
    this.jdField_a_of_type_Vnm = paramvnm;
    this.jdField_a_of_type_Vmu = paramvmu;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Vnn = new vnn(this, null);
    this.jdField_a_of_type_Vmu.a(this.jdField_a_of_type_Vnn);
    vng localvng = (vng)a("PlayerCommentSegment");
    if (localvng != null) {
      localvng.a(paramvmu, paramvnm, this.jdField_a_of_type_Int);
    }
    paramvnm = (vnf)a("PlayerCommentEmptySegment");
    if (paramvnm != null) {
      paramvnm.a(paramvmu);
    }
    paramvnm = (vnk)a("PlayerDoubleTabSegment");
    if (paramvnm != null) {
      paramvnm.a(paramvmu);
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
    if (this.jdField_a_of_type_Vnm != null) {
      this.jdField_a_of_type_Vnm.a();
    }
    return true;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < a()) {
      return false;
    }
    paramInt -= a();
    paramView = ((vng)a("PlayerCommentSegment")).a(paramInt);
    if (paramView == null)
    {
      wsv.e("Q.qqstory.player.StoryPlayerCommentListView", "the long clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramAdapterView = this.jdField_a_of_type_Vmu.a();
    if ((paramAdapterView != null) && (paramAdapterView.a != null)) {
      if (!paramAdapterView.a.getOwner().isMe()) {
        break label147;
      }
    }
    label147:
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      wta.a("home_page", "press_reply", 0, 0, new String[] { paramAdapterView, wta.a(this.jdField_a_of_type_Int) });
      if (paramView.type != 1) {
        break;
      }
      this.jdField_a_of_type_Vmu.a(this.jdField_a_of_type_Vmu.a());
      return true;
    }
    if (this.jdField_a_of_type_Vnm != null) {
      this.jdField_a_of_type_Vnm.b(paramView, paramInt, this.jdField_a_of_type_Vmu.a());
    }
    return true;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    xrg localxrg;
    if (localIterator.hasNext())
    {
      localxrg = (xrg)localIterator.next();
      if ((localxrg instanceof vng)) {
        i = localxrg.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localxrg.a() + i;
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
      paramAdapterView = ((vng)a("PlayerCommentSegment")).a(paramInt);
      if (paramAdapterView == null)
      {
        wsv.e("Q.qqstory.player.StoryPlayerCommentListView", "the clicked comment is null. position is %d.", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      if (paramAdapterView.type == 1)
      {
        this.jdField_a_of_type_Vmu.a(this.jdField_a_of_type_Vmu.a());
        return;
      }
    } while (this.jdField_a_of_type_Vnm == null);
    this.jdField_a_of_type_Vnm.a(paramAdapterView, paramInt, this.jdField_a_of_type_Vmu.a());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Vnm != null) {
      return this.jdField_a_of_type_Vnm.a(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView
 * JD-Core Version:    0.7.0.1
 */