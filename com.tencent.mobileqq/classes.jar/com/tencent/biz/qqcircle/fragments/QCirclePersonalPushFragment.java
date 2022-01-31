package com.tencent.biz.qqcircle.fragments;

import alud;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.component.QCircleComponentPageView;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import trq;
import tvw;
import txf;
import ubq;
import ubz;
import yii;
import yiw;
import yiy;

public class QCirclePersonalPushFragment
  extends QCirclePersonalBaseBottomFragment
  implements yiy
{
  private void a(ubz<List<FeedCloudMeta.StFeed>> paramubz)
  {
    if (paramubz == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp return unexpected data！");
      return;
    }
    boolean bool = paramubz.a();
    int i;
    switch (paramubz.a())
    {
    default: 
      i = 0;
    }
    while ((i != 0) && (this.jdField_a_of_type_Trq != null))
    {
      this.jdField_a_of_type_Trq.a(true, bool);
      return;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp() return empty data");
      if ((paramubz.b()) && (this.jdField_a_of_type_Trq != null) && (this.jdField_a_of_type_Trq.getItemCount() > 0))
      {
        this.jdField_a_of_type_Trq.getLoadInfo().a(bool);
        i = 1;
      }
      else
      {
        if (this.jdField_a_of_type_Tvw != null)
        {
          paramubz = getString(2131698305);
          ((QCircleStatusView)this.jdField_a_of_type_Tvw.a().a()).b(paramubz);
          f();
          i = 1;
          continue;
          if (paramubz.a() == null) {}
          for (paramubz = alud.a(2131720478);; paramubz = paramubz.a())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp() return error！errMsg:" + paramubz);
            if ((this.jdField_a_of_type_Trq == null) || (this.jdField_a_of_type_Trq.getItemCount() <= 0)) {
              break label250;
            }
            QQToast.a(BaseApplicationImpl.getContext(), 1, paramubz, 1).a();
            i = 1;
            break;
          }
          label250:
          if (this.jdField_a_of_type_Tvw != null)
          {
            ((QCircleStatusView)this.jdField_a_of_type_Tvw.a().a()).c(paramubz);
            f();
            i = 1;
            continue;
            i = 0;
            continue;
            ArrayList localArrayList = (ArrayList)paramubz.a();
            if (this.jdField_a_of_type_Trq != null)
            {
              if (paramubz.b()) {
                this.jdField_a_of_type_Trq.addAll(localArrayList);
              }
              for (;;)
              {
                if (this.jdField_a_of_type_Tvw != null)
                {
                  ((QCircleStatusView)this.jdField_a_of_type_Tvw.a().a()).setVisibility(8);
                  this.jdField_a_of_type_Tvw.a().a().setVisibility(0);
                }
                this.jdField_a_of_type_Trq.getLoadInfo().a(bool);
                i = 1;
                break;
                this.jdField_a_of_type_Trq.setDatas(localArrayList);
                this.jdField_a_of_type_Trq.a();
              }
            }
          }
        }
        i = 1;
      }
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Trq != null)
    {
      ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
      localExtraTypeInfo.pageType = 9;
      this.jdField_a_of_type_Trq.a(localExtraTypeInfo);
    }
    if (a() != null)
    {
      this.jdField_a_of_type_Ubq = ((ubq)a(a(), null, ubq.class));
      this.jdField_a_of_type_Ubq.c().observe(a(), new txf(this));
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    yiw.a().a(this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Ubq != null) {
      this.jdField_a_of_type_Ubq.c(this.b);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    yiw.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedEvent)) && (((QCircleFeedEvent)paramSimpleBaseEvent).mState == 3))
    {
      paramSimpleBaseEvent = ((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId;
      if (!TextUtils.isEmpty(paramSimpleBaseEvent)) {
        break label34;
      }
    }
    label134:
    for (;;)
    {
      return;
      label34:
      if (this.jdField_a_of_type_Trq != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_Trq.getDataList();
        if (localArrayList == null) {
          break;
        }
        int i = 0;
        int j = localArrayList.size();
        if (i < j) {
          if (!paramSimpleBaseEvent.equals(((FeedCloudMeta.StFeed)localArrayList.get(i)).id.get())) {}
        }
        for (;;)
        {
          if (i < 0) {
            break label134;
          }
          try
          {
            this.jdField_a_of_type_Trq.delete(i);
            this.jdField_a_of_type_Trq.notifyItemRemoved(i);
            return;
          }
          catch (Throwable paramSimpleBaseEvent)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "onReceiveEvent() delete local feed error!", paramSimpleBaseEvent);
            return;
          }
          i += 1;
          break;
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePersonalPushFragment
 * JD-Core Version:    0.7.0.1
 */