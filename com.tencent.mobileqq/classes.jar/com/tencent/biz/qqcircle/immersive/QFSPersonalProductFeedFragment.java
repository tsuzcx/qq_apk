package com.tencent.biz.qqcircle.immersive;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedAdapter;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalFeedInfo;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalHintViewPart;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalViewModel;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBottomWidget.OnJustSeeListener;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.winkpublish.event.DraftDataChangeEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;

public class QFSPersonalProductFeedFragment
  extends QFSPersonalFeedFragment
{
  private FeedCloudMeta.StFeed j;
  private int k = -1;
  private QFSPersonalBottomWidget.OnJustSeeListener l;
  
  private void A()
  {
    VideoReport.setElementId(this.D, "em_xsj_profile_product_tab");
  }
  
  private boolean B()
  {
    return (this.f != null) && (!this.f.p()) && (y()) && (!z());
  }
  
  private void C()
  {
    if (!B()) {
      return;
    }
    this.f.a(this.j.id.get(), this.j.createTime.get());
  }
  
  private boolean D()
  {
    int i = this.h;
    boolean bool2 = false;
    boolean bool1 = false;
    if (i < 2)
    {
      if (this.k < 6) {
        bool1 = true;
      }
      return bool1;
    }
    i = this.k / 3;
    bool1 = bool2;
    if (i <= this.h + 1)
    {
      bool1 = bool2;
      if (i >= this.h - 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void E()
  {
    if (this.d == null) {
      return;
    }
    this.d.addOnScrollListener(new QFSPersonalProductFeedFragment.4(this));
    if (!D()) {
      this.l.a();
    }
  }
  
  private void a(QFSLayerFeedPosSyncEvent paramQFSLayerFeedPosSyncEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QFSLayerFeedPosSyncEvent position = ");
    localStringBuilder.append(paramQFSLayerFeedPosSyncEvent.getPosition());
    QLog.d("QFSPersonalProductFeedFragment", 4, localStringBuilder.toString());
    b(paramQFSLayerFeedPosSyncEvent.getPosition());
    if (z()) {
      this.l.a(D() ^ true);
    }
  }
  
  private void a(DraftDataChangeEvent paramDraftDataChangeEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleDraftDataChange event.getOptionType: ");
    localStringBuilder.append(paramDraftDataChangeEvent.getOptionType());
    QLog.d("QFSPersonalProductFeedFragment", 1, localStringBuilder.toString());
    if (this.f == null)
    {
      QLog.d("QFSPersonalProductFeedFragment", 1, "mViewModel is null.");
      return;
    }
    this.f.r();
  }
  
  private void a(List<FeedBlockData> paramList)
  {
    if (y())
    {
      if (z()) {
        return;
      }
      String str = this.j.id.get();
      int i = 0;
      while (i < paramList.size())
      {
        if (TextUtils.equals(str, ((FeedBlockData)paramList.get(i)).b().id.get()))
        {
          this.k = i;
          E();
        }
        i += 1;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (!y()) {
        return;
      }
      this.k = -1;
      this.l.a(false);
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    A();
  }
  
  public void a(QFSPersonalBottomWidget.OnJustSeeListener paramOnJustSeeListener)
  {
    this.l = paramOnJustSeeListener;
  }
  
  protected void b(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    a(paramUIStateData.i());
    if ((this.e != null) && (paramUIStateData != null) && (paramUIStateData.e() != null))
    {
      if (this.f == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < ((List)paramUIStateData.e()).size())
      {
        Object localObject = (FeedBlockData)((List)paramUIStateData.e()).get(i);
        localObject = new QFSPersonalFeedInfo(this.f.n(), ((FeedBlockData)localObject).b(), this.g);
        if (i == this.k) {
          ((QFSPersonalFeedInfo)localObject).b(100102);
        }
        localArrayList.add(localObject);
        i += 1;
      }
      this.e.b(localArrayList);
      this.e.notifyDataSetChanged();
      this.c.f();
      if (!this.f.p())
      {
        if (paramUIStateData == null) {
          return;
        }
        a((List)paramUIStateData.e());
        if ((!paramUIStateData.m()) && (!paramUIStateData.i())) {
          C();
        }
      }
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(QFSLayerFeedPosSyncEvent.class);
    localArrayList.add(DraftDataChangeEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof QFSLayerFeedPosSyncEvent))
    {
      a((QFSLayerFeedPosSyncEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof DraftDataChangeEvent)) {
      a((DraftDataChangeEvent)paramSimpleBaseEvent);
    }
  }
  
  void u()
  {
    if (this.f != null)
    {
      if (this.f.g() == null) {
        return;
      }
      this.f.g().observe(this, new QFSPersonalProductFeedFragment.1(this));
      this.f.f().observe(this, new QFSPersonalProductFeedFragment.2(this));
      this.f.j().observe(this, new QFSPersonalProductFeedFragment.3(this));
    }
  }
  
  public void x()
  {
    if (this.d == null)
    {
      QLog.i("QFSPersonalProductFeedFragment", 1, "mRecyclerView is null");
      return;
    }
    b(this.k);
    this.l.a(false);
  }
  
  public boolean y()
  {
    return (this.j != null) && (this.l != null);
  }
  
  public boolean z()
  {
    return (y()) && (this.k != -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSPersonalProductFeedFragment
 * JD-Core Version:    0.7.0.1
 */