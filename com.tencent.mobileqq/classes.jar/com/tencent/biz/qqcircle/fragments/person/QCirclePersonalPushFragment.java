package com.tencent.biz.qqcircle.fragments.person;

import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.widgets.QCirclePersonalBottomStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import uyk;
import vnu;
import vuf;
import zwp;
import zwr;
import zxi;

public class QCirclePersonalPushFragment
  extends QCirclePersonalBaseBottomFragment
  implements zwr
{
  public String a()
  {
    return "profile_pushed";
  }
  
  protected void a()
  {
    this.b = getString(2131697155);
    Object localObject = new QCirclePersonalBottomStatusView(getActivity());
    ((QCirclePersonalBottomStatusView)localObject).setOwnerPicAndText("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/2-text/2-halfscreen/text_halfscreen_04.png", getString(2131697215));
    ((QCirclePersonalBottomStatusView)localObject).setReportBean(a());
    this.jdField_a_of_type_Zxi.a().setStatusView((StatusView)localObject);
    if ((this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter instanceof uyk))
    {
      localObject = new ExtraTypeInfo();
      ((ExtraTypeInfo)localObject).pageType = 9;
      ((uyk)this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter).c(2);
      ((uyk)this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter).a((ExtraTypeInfo)localObject);
    }
    if (a() != null)
    {
      this.jdField_a_of_type_Vuf = ((vuf)a(a(), null, vuf.class));
      this.jdField_a_of_type_Vuf.c().observe(a(), new vnu(this));
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    zwp.a().a(this);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Vuf != null) {
      this.jdField_a_of_type_Vuf.b(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public boolean d()
  {
    return false;
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
    zwp.a().b(this);
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
    label132:
    for (;;)
    {
      return;
      label34:
      if (this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getDataList();
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
            break label132;
          }
          try
          {
            this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.delete(i);
            this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.notifyItemRemoved(i);
            return;
          }
          catch (Throwable paramSimpleBaseEvent)
          {
            QLog.e("QCirclePersonalPushFragment", 1, "onReceiveEvent() delete local feed error!", paramSimpleBaseEvent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalPushFragment
 * JD-Core Version:    0.7.0.1
 */