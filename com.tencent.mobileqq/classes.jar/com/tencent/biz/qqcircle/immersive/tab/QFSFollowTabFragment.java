package com.tencent.biz.qqcircle.immersive.tab;

import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import java.util.List;
import qqcircle.QQCircleCounter.RedPointInfo;

public class QFSFollowTabFragment
  extends QFSBaseLayerTabFragment
{
  protected QFSFollowTabFragment(QCircleTabInfo paramQCircleTabInfo, int paramInt)
  {
    super(paramQCircleTabInfo, paramInt);
  }
  
  private void a(long paramLong)
  {
    QLog.d("QCircleEeveeRedPoint_QFSFollowTabFragment", 1, "[sendClearFollowTabRedPointRequest]");
    RFThreadManager.execute(new QFSFollowTabFragment.1(this, paramLong));
  }
  
  private void y()
  {
    RFThreadManager.execute(new QFSFollowTabFragment.2(this));
  }
  
  public void X()
  {
    Object localObject = QCircleHostRedPointHelper.getSmallRedPointInfotByAppid("circle_entrance");
    if (localObject != null)
    {
      localObject = ((QQCircleCounter.RedPointInfo)localObject).rptRedInfo.get();
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        this.w = true;
      }
    }
  }
  
  public void Y()
  {
    super.Y();
    y();
    if (u() != null)
    {
      long l1 = EeveeRedpointUtil.getFollowTabFeedListLastPreRspTimestamp();
      long l2 = EeveeRedpointUtil.getFollowTabFeedListLastRspTimestamp();
      if (l1 > l2) {
        a(l1);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setUserVisibleHint] followTabFeedListLastPreRspTimestamp: ");
      localStringBuilder.append(l1);
      localStringBuilder.append(", followTabFeedListLastRspTimestamp: ");
      localStringBuilder.append(l2);
      QLog.d("QFSFollowTabFragment", 1, localStringBuilder.toString());
    }
  }
  
  public int a()
  {
    return 501;
  }
  
  public String b()
  {
    return "QFSFollowTabFragment";
  }
  
  protected int c()
  {
    return 2131627120;
  }
  
  protected String f()
  {
    return "pg_xsj_following_page";
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(22).setSubActionType(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */