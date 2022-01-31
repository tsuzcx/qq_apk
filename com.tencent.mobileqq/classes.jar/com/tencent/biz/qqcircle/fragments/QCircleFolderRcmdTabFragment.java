package com.tencent.biz.qqcircle.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.component.QCircleComponentPageView;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import tro;
import trq;
import tvw;
import tww;
import tzv;
import tzy;
import ubm;
import yhy;
import yiw;
import yiy;

public class QCircleFolderRcmdTabFragment
  extends QCircleBaseTabFragment
  implements yiy
{
  public static String j = "QCircleFolderRcmdTabFragment";
  private tro a;
  
  public String a()
  {
    return j;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Tvw.a().a().addOnScrollListener(new tww(this));
    yiw.a().a(this);
  }
  
  protected List<yhy> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Tro = new tro(null);
    localArrayList.add(this.jdField_a_of_type_Tro);
    return localArrayList;
  }
  
  public String c()
  {
    return h;
  }
  
  public void c()
  {
    super.c();
  }
  
  protected boolean c()
  {
    return ((this.jdField_a_of_type_Trq != null) && (this.jdField_a_of_type_Trq.getItemCount() > 0)) || ((this.jdField_a_of_type_Tro != null) && (this.jdField_a_of_type_Tro.getItemCount() > 0));
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_Tro.a(this.jdField_a_of_type_Ubm, this);
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
  
  public void onDetach()
  {
    QLog.d(j, 1, "QCircleFolderRcmdTabFragment->onDetach");
    super.onDetach();
    tzy.a().a(3);
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
    label148:
    for (;;)
    {
      return;
      label34:
      if (this.jdField_a_of_type_Ubm != null) {
        this.jdField_a_of_type_Ubm.c(paramSimpleBaseEvent);
      }
      if (this.jdField_a_of_type_Trq != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_Trq.getDataList();
        if (localArrayList != null)
        {
          int i = 0;
          int k = localArrayList.size();
          if (i < k) {
            if (!paramSimpleBaseEvent.equals(((FeedCloudMeta.StFeed)localArrayList.get(i)).id.get())) {}
          }
          for (;;)
          {
            if (i < 0) {
              break label148;
            }
            try
            {
              this.jdField_a_of_type_Trq.delete(i);
              this.jdField_a_of_type_Trq.notifyItemRemoved(i);
              return;
            }
            catch (Throwable paramSimpleBaseEvent)
            {
              QLog.e(j, 1, "onReceiveEvent() delete local feed error!", paramSimpleBaseEvent);
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
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    QLog.d(j, 1, "QCircleFolderRcmdTabFragment->setUserVisibleHint:" + paramBoolean);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (tzy.a().b(3)) {
        tzy.a().a(getActivity().getIntent());
      }
      tzv.a("", 23, 1L);
      return;
    }
    tzy.a().a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleFolderRcmdTabFragment
 * JD-Core Version:    0.7.0.1
 */