package com.tencent.biz.pubaccount.readinjoy.channelCover;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

class ChannelCoverView$ChannelCoverViewObserver
  extends ReadInJoyObserver
{
  private ChannelCoverView$ChannelCoverViewObserver(ChannelCoverView paramChannelCoverView) {}
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (ChannelCoverView.a(this.a) == paramInt))
    {
      ChannelCoverView.a(this.a, (ArrayList)paramList);
      if ((ChannelCoverView.a(this.a) == null) || (ChannelCoverView.a(this.a) == null) || (ChannelCoverView.a(this.a).size() <= 0)) {
        break label200;
      }
      ChannelCoverView.a(this.a).a(ChannelCoverView.a(this.a));
      ChannelCoverView.a(this.a).notifyDataSetChanged();
      if (ChannelCoverView.a(this.a).findHeaderViewPosition(ChannelCoverView.a(this.a)) < 0) {
        ChannelCoverView.a(this.a).addHeaderView(ChannelCoverView.a(this.a));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onSubChannelListUpdate infos size" + ChannelCoverView.a(this.a).size());
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onSubChannelListUpdate" + paramBoolean);
      }
      return;
      label200:
      ChannelCoverView.a(this.a).removeHeaderView(ChannelCoverView.a(this.a));
    }
  }
  
  public void b(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (ChannelCoverView.a(this.a) == 0))
    {
      ChannelCoverView.a(this.a, (ArrayList)paramList);
      if ((ChannelCoverView.a(this.a) == null) || (ChannelCoverView.a(this.a).size() <= 0)) {
        break label183;
      }
      ChannelCoverView.a(this.a).a(ChannelCoverView.a(this.a));
      ChannelCoverView.a(this.a).notifyDataSetChanged();
      if (ChannelCoverView.a(this.a).findHeaderViewPosition(ChannelCoverView.a(this.a)) < 0) {
        ChannelCoverView.a(this.a).addHeaderView(ChannelCoverView.a(this.a));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onMainChannelListUpdate infos size" + ChannelCoverView.a(this.a).size());
      }
      QLog.d("ChannelCoverView", 2, "onMainChannelListUpdate" + paramBoolean);
      return;
      label183:
      ChannelCoverView.a(this.a).removeHeaderView(ChannelCoverView.a(this.a));
    }
  }
  
  public void c(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (ChannelCoverView.a(this.a) == 56))
    {
      ChannelCoverView.a(this.a, (ArrayList)paramList);
      if ((ChannelCoverView.a(this.a) == null) || (ChannelCoverView.a(this.a) == null) || (ChannelCoverView.a(this.a).size() <= 0)) {
        break label201;
      }
      ChannelCoverView.a(this.a).a(ChannelCoverView.a(this.a));
      ChannelCoverView.a(this.a).notifyDataSetChanged();
      if (ChannelCoverView.a(this.a).findHeaderViewPosition(ChannelCoverView.a(this.a)) < 0) {
        ChannelCoverView.a(this.a).addHeaderView(ChannelCoverView.a(this.a));
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onVideoChannelListUpdate infos size" + ChannelCoverView.a(this.a).size());
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "onVideoChannelListUpdate" + paramBoolean);
      }
      return;
      label201:
      ChannelCoverView.a(this.a).removeHeaderView(ChannelCoverView.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.ChannelCoverViewObserver
 * JD-Core Version:    0.7.0.1
 */