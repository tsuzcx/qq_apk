package com.tencent.biz.qqcircle.fragments.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleLazyLoadTabEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import uyk;
import uys;
import vmc;
import vrf;
import vri;
import vrr;
import vrt;
import vtz;
import zwp;
import zwr;
import zxi;
import zxu;

public class QCircleFolderRcmdTabFragment
  extends QCircleBaseTabFragment
  implements zwr
{
  public static String i = "QCircleFolderRcmdTabFragment";
  private uys a;
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label122:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Vtz != null) {
        this.jdField_a_of_type_Vtz.b(paramString);
      }
      if (this.jdField_a_of_type_Uyk != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_Uyk.getDataList();
        if (localArrayList != null)
        {
          int j = 0;
          int k = localArrayList.size();
          if (j < k) {
            if (!paramString.equals(((FeedCloudMeta.StFeed)localArrayList.get(j)).id.get())) {}
          }
          for (;;)
          {
            if (j < 0) {
              break label122;
            }
            try
            {
              this.jdField_a_of_type_Uyk.delete(j);
              this.jdField_a_of_type_Uyk.notifyItemRemoved(j);
              return;
            }
            catch (Throwable paramString)
            {
              QLog.e(i, 1, "onReceiveEvent() delete local feed error!", paramString);
              return;
            }
            j += 1;
            break;
            j = -1;
          }
        }
      }
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Vtz != null) {
        this.jdField_a_of_type_Vtz.b(paramString);
      }
      if (this.jdField_a_of_type_Uyk != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_Uyk.getDataList();
        if (localArrayList != null)
        {
          int j = localArrayList.size() - 1;
          while (j >= 0)
          {
            if (paramString.equals(((FeedCloudMeta.StFeed)localArrayList.get(j)).poster.id.get())) {
              try
              {
                this.jdField_a_of_type_Uyk.delete(j);
                this.jdField_a_of_type_Uyk.notifyItemRemoved(j);
                return;
              }
              catch (Throwable paramString)
              {
                QLog.e(i, 1, "onReceiveEvent() delete local feed error!", paramString);
                return;
              }
            }
            j -= 1;
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Zxi.a().a().addOnScrollListener(new vmc(this));
    zwp.a().a(this);
  }
  
  public String b()
  {
    return g;
  }
  
  public List<zxu> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Uys = new uys(null);
    this.jdField_a_of_type_Uys.a(a());
    localArrayList.add(this.jdField_a_of_type_Uys);
    return localArrayList;
  }
  
  public void b()
  {
    super.b();
  }
  
  public boolean b()
  {
    return ((this.jdField_a_of_type_Uyk != null) && (this.jdField_a_of_type_Uyk.getItemCount() > 0)) || ((this.jdField_a_of_type_Uys != null) && (this.jdField_a_of_type_Uys.getItemCount() > 0));
  }
  
  public int c()
  {
    return 3;
  }
  
  public String c()
  {
    return i;
  }
  
  public String d()
  {
    return "explore_page";
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_Uys.a(this.jdField_a_of_type_Vtz, this);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCircleLazyLoadTabEvent.class);
    return localArrayList;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    zwp.a().b(this);
  }
  
  public void onDetach()
  {
    QLog.d(i, 1, "QCircleFolderRcmdTabFragment->onDetach");
    super.onDetach();
    vri.a().b(c());
  }
  
  public void onPause()
  {
    super.onPause();
    if (getUserVisibleHint()) {
      vri.a().d(c());
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedEvent)) && (((QCircleFeedEvent)paramSimpleBaseEvent).mState == 3))
    {
      localQCircleFeedEvent = (QCircleFeedEvent)paramSimpleBaseEvent;
      if (localQCircleFeedEvent.mState == 3) {
        a(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
      }
    }
    while (!(paramSimpleBaseEvent instanceof QCircleLazyLoadTabEvent))
    {
      QCircleFeedEvent localQCircleFeedEvent;
      do
      {
        return;
      } while (localQCircleFeedEvent.mState != 6);
      b(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
      return;
    }
    c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (getUserVisibleHint()) {
      vri.a().c(c());
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    QLog.d(i, 1, "QCircleFolderRcmdTabFragment->setUserVisibleHint:" + paramBoolean);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (vri.a().d()) {
        vri.a().a(c(), getActivity().getIntent());
      }
      vri.a().a(c());
      vri.a().c(c());
      vrf.a("", 23, 1);
      vrr.a().a(new vrt().a("main").b("impression").a(a()));
      return;
    }
    vri.a().d(c());
    vri.a().b(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderRcmdTabFragment
 * JD-Core Version:    0.7.0.1
 */