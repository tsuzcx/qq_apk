package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.fragment.RIJChannelReporter;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.List;

class ReadInJoyChannelViewPagerController$4
  extends ReadInJoyObserver
{
  ReadInJoyChannelViewPagerController$4(ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController) {}
  
  public void a(float paramFloat, int paramInt)
  {
    super.a(paramFloat, paramInt);
    paramFloat /= paramInt;
    ReadInJoyChannelViewPagerController.a(this.a).setY((1.0F - paramFloat) * ReadInJoyChannelViewPagerController.a(this.a).getHeight() * 0.03F);
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    super.a(paramTabChannelCoverInfo);
    if (paramTabChannelCoverInfo != null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "onChannelTabSelected, channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), ", channelName = ", paramTabChannelCoverInfo.mChannelCoverName });
      ReadInJoyChannelViewPagerController.a(paramTabChannelCoverInfo.mChannelCoverId, 1);
      this.a.c(paramTabChannelCoverInfo.mChannelCoverId);
      ReadInJoyChannelViewPagerController.a(this.a);
      if (ReadInJoyHelper.D())
      {
        ReadInJoyChannelViewPagerController.b(this.a, paramTabChannelCoverInfo);
        ReadInJoyChannelViewPagerController.b(this.a, ReadInJoyChannelViewPagerController.a(this.a, ReadInJoyChannelViewPagerController.a(this.a)));
      }
      RIJChannelReporter.a(paramTabChannelCoverInfo.mChannelCoverId, "303");
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramInt, paramList, paramBoolean2);
    paramInt = this.a.c();
    ReadInJoyChannelViewPagerController.a(this.a, paramInt);
    ReadInJoyChannelViewPagerController.a(this.a).b();
  }
  
  public void a(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    int i = 0;
    if (paramList != null) {
      i = paramList.size();
    }
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onIndependentMainChannelListupdate, success = ", Boolean.valueOf(paramBoolean), ", size = ", Integer.valueOf(i) });
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      ReadInJoyChannelViewPagerController.a(this.a, paramList);
    }
  }
  
  public void aj_()
  {
    super.aj_();
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 8;
    ReadInJoyChannelViewPagerController.a(this.a, paramBoolean);
    if (!ChannelModeConfigHandler.a())
    {
      ImageView localImageView = ReadInJoyChannelViewPagerController.a(this.a);
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      return;
    }
    ReadInJoyChannelViewPagerController.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.4
 * JD-Core Version:    0.7.0.1
 */